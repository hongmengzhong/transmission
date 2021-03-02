package com.example.transmission.msdata.product.service.impl;

import com.example.transmission.msdata.product.mapper.MsProductImeiMapper;
import com.example.transmission.msdata.product.mapper.MsProductMapper;
import com.example.transmission.msdata.product.mapper.MsProductStoreMapper;
import com.example.transmission.msdata.product.service.MsProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MsProductServiceImpl implements MsProductService {

    @Autowired
    MsProductMapper msProductMapper;
    @Autowired
    MsProductImeiMapper msProductImeiMapper;
    @Autowired
    MsProductStoreMapper msProductStoreMapper;

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

    public List<String> getSynchronizationProduct(Date sysTime, Date updateTime) {
        List<String> idslist = new ArrayList<>();
        List<String> productList = msProductMapper.findSynchronizationProduct(sysTime,updateTime);
        List<String> stockList = msProductStoreMapper.findSynchronizationStock(sysTime,updateTime);
        List<String> imeiList = msProductImeiMapper.findSynchronizationImei(sysTime,updateTime);

        idslist.addAll(productList);idslist.addAll(stockList);idslist.addAll(imeiList);
        idslist.stream().distinct().collect(Collectors.toList());
        return idslist;
    }
}
