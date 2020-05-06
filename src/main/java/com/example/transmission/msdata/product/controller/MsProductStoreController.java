package com.example.transmission.msdata.product.controller;

import com.example.transmission.msdata.product.service.impl.MsProductServiceImpl;
import com.example.transmission.msdata.product.service.impl.MsProductStoreServiceImpl;
import com.example.transmission.mssdata.autodata.service.impl.AutoDataServiceImpl;
import com.example.transmission.mssdata.product.service.MssProductStoreService;
import com.example.transmission.mssdata.product.service.impl.MssProductServiceImpl;
import com.example.transmission.mssdata.product.service.impl.MssProductStoreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务*/
//@Controller
@Slf4j
public class MsProductStoreController {



    @Autowired
    @Qualifier(value = "mssProductServiceImpl")
    private MssProductServiceImpl mssProductServiceImpl;
    @Autowired
    private AutoDataServiceImpl autoDataServiceImpl;
    @Autowired
    private MssProductStoreServiceImpl mssProductStoreServiceImpl;
    @Autowired
    private MsProductStoreServiceImpl msProductStoreServiceImpl;
    @Autowired
    private MsProductServiceImpl msProductServiceImpl;
    /**
     * 同步productStore
     * @return
    */
    //或直接指定时间间隔，例如：5秒@Scheduled(fixedRate=5000)
    //@Scheduled(cron = "0 0/5* * * ?")
   /* @RequestMapping("/saveAllProductStore")
    @ResponseBody*/
    public void saveAllProductStore(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-M-ddHH:mm:ss");
        //获取accountid总数
        List<Integer> accountIdList = mssProductServiceImpl.getAccountIdList();
        log.info(accountIdList.size()+"=========accountid总数");
        Date updateTime = autoDataServiceImpl.getUpdateAllTime("auto_product_store_imei_all");
        for (Integer acoundid : accountIdList) {
            Date sysTime = autoDataServiceImpl.getSysDate();
            log.info(acoundid+"=================");
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("accountid",acoundid);
            param.put("className","xls_auto_store");
            //获取更新日志表信息
            Map<String,Object> xlsAutoSysTimestampInfo = autoDataServiceImpl.getXlsAutoSysTimestampInfo(param);
            //判断是否有原始数据没有得话   默认查三天
            if (xlsAutoSysTimestampInfo==null && xlsAutoSysTimestampInfo.size()<=0){
                log.info("xlsAutoSysTimestampInfo表中暂无"+acoundid+"此acoundid=================");
                continue;
            }
            List<Map<String,Object>> productStoreList = mssProductStoreServiceImpl.getAllProductStore1(acoundid);

            //如果转换失败 productList==null时继续下一次循环
            if (productStoreList ==null){
                continue;
            }
            int OPERATER_NUM = 1000;                 //每批插入几条数据
            int listSize=productStoreList.size();            //要插入的数据总数
            int toIndex=OPERATER_NUM;
            for (int i = 0; i < productStoreList.size(); i++) {
                try {
                  //  msProductStoreServiceImpl.saveProductStore(productStoreList.get(i));
                    if(i+OPERATER_NUM>listSize){//作用为toIndex最后没有2000条数据则剩余几条newList中就装几条
                        toIndex=listSize-i;
                        List<Map<String,Object>>productLists = productStoreList.subList(i,i+toIndex);
                        msProductStoreServiceImpl.saveProductStoreList(productLists);
                        break;
                    }
                    //i%10  每到10的倍数进行一次批量
                    if (i==0 || i%OPERATER_NUM==0){
                        List<Map<String,Object>>productLists = productStoreList.subList(i,i+toIndex);
                        msProductStoreServiceImpl.saveProductStoreList(productLists);
                    }
                }catch (Exception e){
                    log.error(e.getMessage());
                }
            }
            autoDataServiceImpl.updateTableInfo(acoundid,"xls_auto_store",sysTime);
        }
    }

    /**
     * 同步Store表
    */
  /*  @RequestMapping("/saveDataToYKStore")
    @ResponseBody*/
    @Scheduled(cron = "0 0/8 * * * ?")
    public void saveDataToYKStore(){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-M-ddHH:mm:ss");
        //获取accountid总数
        List<Integer> accountIdList = mssProductServiceImpl.getAccountIdList();
        log.info(accountIdList.size()+"=========accountid总数");
        Date updateTime = autoDataServiceImpl.getUpdateAllTime("auto_store_all");
        Date sysTime = autoDataServiceImpl.getSysDate();
        for (Integer acoundid : accountIdList) {
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("accountid",acoundid);
            param.put("className","auto_store");
            //获取更新日志表信息
            /*Map<String,Object> xlsAutoSysTimestampInfo = autoDataServiceImpl.getXlsAutoSysTimestampInfo(param);
            //判断是否有原始数据没有得话   默认查三天
            if (xlsAutoSysTimestampInfo==null && xlsAutoSysTimestampInfo.size()<=0){
                log.info("xlsAutoSysTimestampInfo表中暂无"+acoundid+"此acoundid=================");
                continue;
            }*/
            //根据acountid 和 更新时间查询需要同步得store信息
            List<Map<String,Object>>      autoDataStoreList = mssProductStoreServiceImpl.getAutoDataStore(acoundid,updateTime,sysTime);

            //如果转换失败 productList==null时继续下一次循环
            if (autoDataStoreList ==null){
                continue;
            }
            int OPERATER_NUM = 20;                 //每批插入几条数据
            int listSize=autoDataStoreList.size();            //要插入的数据总数
            int toIndex=OPERATER_NUM;

            for (int i = 0; i < autoDataStoreList.size(); i++) {
                try {
                    if(i+OPERATER_NUM>listSize){//作用为toIndex最后没有2000条数据则剩余几条newList中就装几条
                        toIndex=listSize-i;
                        List<Map<String,Object>>productLists = autoDataStoreList.subList(i,i+toIndex);
                        msProductStoreServiceImpl.saveAutoStoreList(productLists);
                        break;
                    }
                    //i%10  每到10的倍数进行一次批量
                    if (i==0 || i%OPERATER_NUM==0){
                        List<Map<String,Object>>productLists = autoDataStoreList.subList(i,i+toIndex);
                        msProductStoreServiceImpl.saveAutoStoreList(productLists);
                    }
                }catch (Exception e){
                    log.error(e.getMessage());
                }
            }
            autoDataServiceImpl.updateTableInfo(acoundid,"auto_store",sysTime);
        }
        autoDataServiceImpl.updateAutoProductAllDate("auto_store_all", sysTime);
        log.info("saveDataToYKStore执行完毕");
    }
}
