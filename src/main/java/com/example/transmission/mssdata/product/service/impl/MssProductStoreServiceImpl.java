package com.example.transmission.mssdata.product.service.impl;

import com.example.transmission.mssdata.product.mapper.MssProductStoreMapper;
import com.example.transmission.mssdata.product.service.MssProductStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MssProductStoreServiceImpl implements MssProductStoreService {

    @Autowired
    private MssProductStoreMapper mssProductStoreMapper;

    @Override
    public List<Map<String, Object>> getAllProductStore(Integer acoundid, Date startdate, Date sysTime) {
        return mssProductStoreMapper.getAllProductStore(acoundid,startdate,sysTime);
    }

    @Override
    public List<Map<String, Object>> getdelAllProductStore(Integer acoundid, Date update_date, Date sysTime) {
        return mssProductStoreMapper.getdelAllProductStore(acoundid, update_date, sysTime);
    }

    @Override
    public List<Map<String, Object>> getAutoDataStore(Integer acoundid, Date update_date, Date sysTime) {
        return mssProductStoreMapper.getAutoDataStore(acoundid, update_date, sysTime);
    }

    @Override
    public List<Map<String, Object>> getAllProductStore1(Integer acoundid) {
        return mssProductStoreMapper.getAllProductStore1(acoundid);
    }
}
