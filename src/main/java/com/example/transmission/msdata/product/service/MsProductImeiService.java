package com.example.transmission.msdata.product.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface MsProductImeiService {

    void saveProductImei(Map<String, Object> map);

    void deleteProductImei(Map<String, Object> map);

    void updateDelProductImei(Map<String, Object> map);

    void callPsynImei(Date updateTime);
}
