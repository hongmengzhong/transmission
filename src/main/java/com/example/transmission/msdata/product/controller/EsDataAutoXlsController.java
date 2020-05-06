package com.example.transmission.msdata.product.controller;

import com.example.transmission.msdata.product.service.MsProductImeiService;
import com.example.transmission.msdata.product.service.impl.MsProductImeiServiceImpl;
import com.example.transmission.msdata.product.service.impl.MsProductServiceImpl;
import com.example.transmission.msdata.product.service.impl.MsProductStoreServiceImpl;
import com.example.transmission.mssdata.autodata.service.impl.AutoDataServiceImpl;
import com.example.transmission.mssdata.product.service.impl.MssProductImeiServiceImpl;
import com.example.transmission.mssdata.product.service.impl.MssProductServiceImpl;
import com.example.transmission.mssdata.product.service.impl.MssProductStoreServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
@Controller
@Slf4j
public class EsDataAutoXlsController {
    @Autowired
    @Qualifier(value = "msProductServiceImpl")
    private MsProductServiceImpl msProductServiceImpl;
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
    private MssProductImeiServiceImpl mssProductImeiServiceImpl;
    @Autowired
    private MsProductImeiServiceImpl msProductImeiServiceImpl;

    SimpleDateFormat format=new SimpleDateFormat("yyyy-M-ddHH:mm:ss");
    @RequestMapping("esDataAutoXlsFunction")
    @ResponseBody
    @Scheduled(cron = "0 0/10 * * * ?")
   // @Scheduled(cron = "0 55 23 * * ?")
    public void esDataAutoXlsFunction(){
        List<Integer> accountIdList = mssProductServiceImpl.getAccountIdList();
        Date sysTime = autoDataServiceImpl.getSysDate();
        Date updateTime = autoDataServiceImpl.getUpdateAllTime("auto_product_store_imei_all");
        log.info(accountIdList.size()+"=========accountid总数");
        for (Integer accountId : accountIdList) {
            if (saveAllProduct(accountId,sysTime,updateTime)){
                saveAllProductStore(accountId,sysTime,updateTime);
                saveAllProductImei(accountId,sysTime,updateTime);
            }else{
                continue;
            }
        }
        msProductServiceImpl.callProductNew(updateTime);
        msProductStoreServiceImpl.callPinitKc(updateTime);
        msProductImeiServiceImpl.callPsynImei(updateTime);
        autoDataServiceImpl.updateAutoProductAllDate("auto_product_store_imei_all", sysTime);
        log.info("esDataAutoXlsFunction执行完毕=================");
    }

    public boolean saveAllProduct(Integer acoundid,Date sysTime,Date updateTime) {
        log.info("进入saveAllProduct方法,accountId=" + acoundid);
       // Date sysTime = autoDataServiceImpl.getSysDate();
        log.info(acoundid + "=================");
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("accountid", acoundid);
        param.put("className", "xls_auto_product");
        /*//获取更新日志表信息
        Map<String, Object> xlsAutoSysTimestampInfo = autoDataServiceImpl.getXlsAutoSysTimestampInfo(param);
        //判断是否有原始数据没有得话   默认查三天
        if (xlsAutoSysTimestampInfo == null && xlsAutoSysTimestampInfo.size() <= 0) {
            log.info("xlsAutoSysTimestampInfo表中暂无" + acoundid + "此acoundid=================");
            return false;
        }*/
        List<Map<String, Object>> productList = mssProductServiceImpl.getCountAll(acoundid, updateTime, sysTime);
        //如果转换失败 productList==null时继续下一次循环
        if (productList == null) {
            return false;
        }
        int OPERATER_NUM = 1;                 //每批插入几条数据
        int listSize = productList.size();            //要插入的数据总数
        int toIndex = OPERATER_NUM;
        for (Map<String, Object> product : productList) {
            try {
                int index = msProductServiceImpl.findProductExist(product);
                if (index==0){
                    msProductServiceImpl.saveAll(product);
                }else{
                    msProductServiceImpl.updateProductInfo(product);
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
         /*for (int i = 0; i < productList.size(); i++) {
            try {

               if (i + OPERATER_NUM > listSize) {//作用为toIndex最后没有2000条数据则剩余几条newList中就装几条
                    toIndex = listSize - i;
                    List<Map<String, Object>> productLists = productList.subList(i, i + toIndex);
                    msProductServiceImpl.saveAllList(productLists);
                    break;
                }
                //i%10  每到10的倍数进行一次批量
                if (i == 0 || i % OPERATER_NUM == 0) {
                    List<Map<String, Object>> productLists = productList.subList(i, i + toIndex);
                    msProductServiceImpl.saveAllList(productLists);
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }*/
        autoDataServiceImpl.updateTableInfo(acoundid, "xls_auto_product", sysTime);
        return true;
    }

    //同步库存方法
    public boolean saveAllProductStore(Integer acoundid,Date sysTime,Date updateTime){
            log.info("进入saveAllProductStore方法,accountId="+acoundid);
            //Date sysTime = autoDataServiceImpl.getSysDate();
            log.info(acoundid+"=================");
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("accountid",acoundid);
            param.put("className","xls_auto_store");
           /* //获取更新日志表信息
            Map<String,Object> xlsAutoSysTimestampInfo = autoDataServiceImpl.getXlsAutoSysTimestampInfo(param);
            //判断是否有原始数据没有得话   默认查三天
            if (xlsAutoSysTimestampInfo==null && xlsAutoSysTimestampInfo.size()<=0){
                log.info("xlsAutoSysTimestampInfo表中暂无"+acoundid+"此acoundid=================");
                return false;
            }*/
            //根据acountid 和 更新时间查询需要同步得store信息
            List<Map<String,Object>> productStoreList = mssProductStoreServiceImpl.getAllProductStore(acoundid,updateTime,sysTime);
            List<Map<String,Object>> delproductStoreList = mssProductStoreServiceImpl.getdelAllProductStore(acoundid,updateTime,sysTime);

            //如果转换失败 productList==null时继续下一次循环
            if (productStoreList ==null){
                return false;
            }
            try {
                if (delproductStoreList!=null && delproductStoreList.size()>0){
                    for (Map<String, Object> map : delproductStoreList) {
                        msProductStoreServiceImpl.updateDelProductStore(map);
                    }
                }
                for (int i = 0; i < productStoreList.size(); i++) {
                    msProductStoreServiceImpl.saveProductStore(productStoreList.get(i));
                }
            }catch (Exception e){
                log.error(e.getMessage());
            }
            autoDataServiceImpl.updateTableInfo(acoundid,"xls_auto_store",sysTime);
        return true;
    }

    public boolean saveAllProductImei(Integer acoundid,Date sysTime,Date updateTime){
            log.info("进入saveAllProductImei方法,accountId="+acoundid);
            //Date sysTime = autoDataServiceImpl.getSysDate();
            log.info(acoundid+"=================");
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("accountid",acoundid);
            param.put("className","xls_auto_imei");
            //获取更新日志表信息
           /* Map<String,Object> xlsAutoSysTimestampInfo = autoDataServiceImpl.getXlsAutoSysTimestampInfo(param);
            //判断是否有原始数据没有得话   默认查三天
            if (xlsAutoSysTimestampInfo==null && xlsAutoSysTimestampInfo.size()<=0){
                log.info("xlsAutoSysTimestampInfo表中暂无"+acoundid+"此acoundid=================");
                return false;
            }*/
            //根据acountid 和 更新时间查询需要同步得商品imei
            List<Map<String,Object>> productImeiList = mssProductImeiServiceImpl.getProductImeiList(acoundid,updateTime,sysTime);
            List<Map<String,Object>> deleteproductImeiList = mssProductImeiServiceImpl.getDelProductImeiList(acoundid,updateTime,sysTime);

            //如果转换失败 productList==null时继续下一次循环
            if (productImeiList ==null){
                return false;
            }
            try {
                if (deleteproductImeiList!=null && deleteproductImeiList.size()>0){
                    for (Map<String, Object> map : deleteproductImeiList) {
                        msProductImeiServiceImpl.updateDelProductImei(map);
                    }
                }
                for (int i = 0; i < productImeiList.size(); i++) {
                        msProductImeiServiceImpl.saveProductImei(productImeiList.get(i));
                }
            }catch (Exception e){
                log.error(e.getMessage());
            }
            autoDataServiceImpl.updateTableInfo(acoundid,"xls_auto_imei",sysTime);
            log.info("====================="+acoundid+"已完成=========================");
            return true;
    }

}
