package com.example.transmission.mssdata.autodata.service.impl;

import com.example.transmission.mssdata.autodata.mapper.AutoDataMapper;
import com.example.transmission.mssdata.autodata.service.AutoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class AutoDataServiceImpl implements AutoDataService {

    @Autowired
    private AutoDataMapper autoDataMapper;

    @Override
    public Map<String, Object> getXlsAutoSysTimestampInfo(Map<String, Object> param) {
        return autoDataMapper.getXlsAutoSysTimestampInfo(param);
    }

    @Override
    public Date getSysDate() {
        return autoDataMapper.getSysDate();
    }

    @Override
    public int updateTableInfo(Integer acoundid, String className, Date sysTime) {
       return  autoDataMapper.updateTableInfo(acoundid,className,sysTime);
    }

    @Override
    public void updateAutoProductAllDate(String className, Date sysTime) {
        autoDataMapper.updateAutoProductAllDate(className,sysTime);
    }

    @Override
    public Date getUpdateAllTime(String className) {
        return autoDataMapper.getUpdateAllTime(className);
    }

}
