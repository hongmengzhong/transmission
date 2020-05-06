package com.example.transmission.msdata.product.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MsProductStoreService {

    void saveProductStore(Map<String, Object> map);

    void deleteProductStore(Map<String, Object> map);

    void saveAutoStoreList(List<Map<String, Object>> productLists);

    void saveProductStoreList(List<Map<String, Object>> productLists);

    void updateDelProductStore(Map<String, Object> map);

    void callPinitKc(Date sysTime);
}
