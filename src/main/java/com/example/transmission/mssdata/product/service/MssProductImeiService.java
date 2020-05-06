package com.example.transmission.mssdata.product.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MssProductImeiService {

     List<Map<String, Object>> getProductImeiList(Integer acoundid, Date update_date, Date sysTime);


    List<Map<String, Object>> getDelProductImeiList(Integer acoundid, Date update_date, Date sysTime);
}
