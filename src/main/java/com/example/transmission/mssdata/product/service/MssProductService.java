package com.example.transmission.mssdata.product.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MssProductService {

     List<Map<String,Object>> getCountAll(int acoundid, Date startTime,Date endTime);

     /**
      * 获取所有得accountId
      * @return
      */
     List<Integer> getAccountIdList();

}
