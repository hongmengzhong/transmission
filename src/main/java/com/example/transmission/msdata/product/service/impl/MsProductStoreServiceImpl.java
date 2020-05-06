package com.example.transmission.msdata.product.service.impl;

import com.example.transmission.msdata.product.mapper.MsProductStoreMapper;
import com.example.transmission.msdata.product.service.MsProductStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class MsProductStoreServiceImpl implements MsProductStoreService {

    @Autowired
    private MsProductStoreMapper msProductStoreMapper;


    @Override
    public void saveProductStore(Map<String, Object> map) {
        msProductStoreMapper.saveProductStore(map);
    }

    @Override
    public void deleteProductStore(Map<String, Object> map) {
        msProductStoreMapper.deleteProductStore(map);
    }

    @Override
    public void saveAutoStoreList(List<Map<String, Object>> productLists) {
        msProductStoreMapper.saveAutoStoreList(productLists);
    }

    @Override
    public void saveProductStoreList(List<Map<String, Object>> productLists) {
        msProductStoreMapper.saveProductStoreList(productLists);
    }

    @Override
    public void updateDelProductStore(Map<String, Object> map) {
        msProductStoreMapper.updateDelProductStore(map);
    }

    @Override
    public void callPinitKc(Date sysTime) {
        msProductStoreMapper.callPinitKc(sysTime);
    }
}
