package com.example.transmission.msdata.product.service.impl;

import com.example.transmission.msdata.product.mapper.MsProductMapper;
import com.example.transmission.msdata.product.service.MsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MsProductServiceImpl implements MsProductService {

    @Autowired
    MsProductMapper msProductMapper;

    @Override
    public int getCountAll() {
        return msProductMapper.getCountAll();
    }

    @Override
    public void saveAll(Map<String, Object> productList) {
        msProductMapper.savaAll(productList);
    }

    @Override
    public void saveAllList(List<Map<String, Object>> productLists) {
        msProductMapper.saveAllList(productLists);
    }

    @Override
    public void callProductNew(Date updateDate) {
        msProductMapper.callProductNew(updateDate);
    }

    @Override
    public int findProductExist(Map<String, Object> product) {
        return msProductMapper.findProductExist(product);
    }

    @Override
    public void updateProductInfo(Map<String, Object> product) {
        msProductMapper.updateProductInfo(product);
    }


}
