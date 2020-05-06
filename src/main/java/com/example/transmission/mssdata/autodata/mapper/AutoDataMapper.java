package com.example.transmission.mssdata.autodata.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;

@Mapper
public interface AutoDataMapper {

    Map<String, Object> getXlsAutoSysTimestampInfo(Map<String, Object> param);

    Date getSysDate();

    int updateTableInfo(@Param("accountid") Integer acoundid, @Param("className") String className, @Param("sysTime") Date sysTime);

    void updateAutoProductAllDate(@Param("className") String className, @Param("sysTime") Date sysTime);

    Date getUpdateAllTime(@Param("className") String className);
}
