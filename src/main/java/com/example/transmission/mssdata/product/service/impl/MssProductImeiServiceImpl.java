package com.example.transmission.mssdata.product.service.impl;

import com.example.transmission.mssdata.product.mapper.MssProductImeiMapper;
import com.example.transmission.mssdata.product.service.MssProductImeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MssProductImeiServiceImpl implements MssProductImeiService {

    @Autowired
    private MssProductImeiMapper mssProductImeiMapper;

    @Override
    public List<Map<String, Object>> getProductImeiList(Integer acoundid, Date update_date, Date sysTime) {
        return mssProductImeiMapper.getProductImeiList(acoundid, update_date, sysTime);
    }

    @Override
    public List<Map<String, Object>> getDelProductImeiList(Integer acoundid, Date update_date, Date sysTime) {
        return mssProductImeiMapper.getDelProductImeiList(acoundid,update_date,sysTime);
    }
}
