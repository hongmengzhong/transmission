package com.example.transmission.msdata.product.controller;

import com.example.transmission.msdata.product.service.impl.MsProductImeiServiceImpl;
import com.example.transmission.msdata.product.service.impl.MsProductServiceImpl;
import com.example.transmission.mssdata.autodata.service.impl.AutoDataServiceImpl;
import com.example.transmission.mssdata.product.service.impl.MssProductImeiServiceImpl;
import com.example.transmission.mssdata.product.service.impl.MssProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
@Slf4j
public class MsProductImeiController {

    @Autowired
    @Qualifier(value = "mssProductServiceImpl")
    private MssProductServiceImpl mssProductServiceImpl;
    @Autowired
    private MssProductImeiServiceImpl mssProductImeiServiceImpl;
    @Autowired
    private MsProductImeiServiceImpl msProductImeiServiceImpl;
    @Autowired
    private AutoDataServiceImpl autoDataServiceImpl;

    //@Scheduled(cron = "0 0/10 * * * ?")
    public void saveAllProduct(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-M-ddHH:mm:ss");
        //获取accountid总数
        List<Integer> accountIdList = mssProductServiceImpl.getAccountIdList();
        log.info(accountIdList.size()+"=========accountid总数");
        for (Integer acoundid : accountIdList) {
            Date sysTime = autoDataServiceImpl.getSysDate();
            log.info(acoundid+"=================");
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("accountid",acoundid);
            param.put("className","xls_auto_imei");
            //获取更新日志表信息
            Map<String,Object> xlsAutoSysTimestampInfo = autoDataServiceImpl.getXlsAutoSysTimestampInfo(param);
            //判断是否有原始数据没有得话   默认查三天
            if (xlsAutoSysTimestampInfo==null && xlsAutoSysTimestampInfo.size()<=0){
                log.info("xlsAutoSysTimestampInfo表中暂无"+acoundid+"此acoundid=================");
                continue;
            }
            List<Map<String,Object>> productImeiList = null;
            //根据acountid 和 更新时间查询需要同步得商品imei
            try {
                productImeiList = mssProductImeiServiceImpl.getProductImeiList(acoundid,format.parse(xlsAutoSysTimestampInfo.get("Update_Date").toString()),sysTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            //如果转换失败 productList==null时继续下一次循环
            if (productImeiList ==null){
                continue;
            }
            int OPERATER_NUM = 1;                 //每批插入几条数据
            int listSize=productImeiList.size();            //要插入的数据总数
            int toIndex=OPERATER_NUM;
            for (int i = 0; i < productImeiList.size(); i++) {
                try {
                    msProductImeiServiceImpl.saveProductImei(productImeiList.get(i));
                    /*if(i+OPERATER_NUM>listSize){//作用为toIndex最后没有2000条数据则剩余几条newList中就装几条
                        toIndex=listSize-i;
                        List<Map<String,Object>>productLists = productList.subList(i,i+toIndex);
                        msProductServiceImpl.saveAllList(productLists);
                        break;
                    }
                    //i%10  每到10的倍数进行一次批量
                    if (i==0 || i%OPERATER_NUM==0){
                        List<Map<String,Object>>productLists = productList.subList(i,i+toIndex);
                        msProductServiceImpl.saveAllList(productLists);
                    }*/
                }catch (Exception e){
                    log.error(e.getMessage());
                }
            }
            autoDataServiceImpl.updateTableInfo(acoundid,"xls_auto_imei",sysTime);
        }
    }


}
