package com.example.transmission.mssdata.product.service.impl;

import com.example.transmission.mssdata.product.mapper.MssProductMapper;
import com.example.transmission.mssdata.product.service.MssProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MssProductServiceImpl implements MssProductService {

    @Autowired
    MssProductMapper mssProductMapper;

    @Override
    public List<Map<String,Object>> getCountAll(int acoundid, Date startTime,Date endTime) {
        return mssProductMapper.getCountAll(acoundid,startTime,endTime);
    }

    @Override
    public List<Integer> getAccountIdList() {
        return mssProductMapper.getAccountIdList();
    }



}
