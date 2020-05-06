package com.example.transmission.msdata.product.service.impl;

import com.example.transmission.msdata.product.mapper.MsProductImeiMapper;
import com.example.transmission.msdata.product.mapper.MsProductMapper;
import com.example.transmission.msdata.product.service.MsProductImeiService;
import com.example.transmission.msdata.product.service.MsProductService;
import com.example.transmission.mssdata.product.service.MssProductImeiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class MsProductImeiServiceImpl implements MsProductImeiService {

    @Autowired
    private MsProductImeiMapper msProductImeiMapper;
    @Override
    public void saveProductImei(Map<String, Object> map) {
        msProductImeiMapper.saveProductImei(map);
    }

    @Override
    public void deleteProductImei(Map<String, Object> map) {
        msProductImeiMapper.deleteProductImei(map);
    }

    @Override
    public void updateDelProductImei(Map<String, Object> map) {
        msProductImeiMapper.updateDelProductImei(map);
    }

    @Override
    public void callPsynImei(Date updateTime) {
        msProductImeiMapper.callPsynImei(updateTime);
    }
}
