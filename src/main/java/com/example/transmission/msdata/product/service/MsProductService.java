package com.example.transmission.msdata.product.service;


import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MsProductService {

    int getCountAll();

    void saveAll(Map<String, Object> productList);

    void saveAllList(List<Map<String, Object>> productLists);

    void callProductNew(Date updateDate);

    int findProductExist(Map<String, Object> product);

    void updateProductInfo(Map<String, Object> product);
}
