package com.example.transmission.mssdata.product.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MssProductStoreService {

    List<Map<String, Object>> getAllProductStore(Integer acoundid, Date update_date, Date sysTime);

    List<Map<String, Object>> getdelAllProductStore(Integer acoundid, Date update_date, Date sysTime);

    List<Map<String, Object>> getAutoDataStore(Integer acoundid, Date update_date, Date sysTime);

    List<Map<String, Object>> getAllProductStore1(Integer acoundid);
}
