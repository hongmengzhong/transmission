package com.example.transmission.mssdata.autodata.service;


import java.util.Date;
import java.util.Map;

public interface AutoDataService {

    Map<String, Object> getXlsAutoSysTimestampInfo(Map<String, Object> param);

    Date getSysDate();

    int updateTableInfo(Integer acoundid, String xls_auto_product, Date sysTime);

    void updateAutoProductAllDate(String auto_product_store_imei_all, Date sysTime);

    Date getUpdateAllTime(String auto_product_store_imei_all);
}
