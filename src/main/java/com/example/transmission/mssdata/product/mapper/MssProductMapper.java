package com.example.transmission.mssdata.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface MssProductMapper {
    List<Map<String,Object>> getCountAll(@Param("acoundid") int acoundid,@Param("startTime") Date startTime,@Param("endTime") Date endTime);

    List<Integer> getAccountIdList();

    Map<String, Object> getXlsAutoSysTimestampInfo(Map<String, Object> param);
}
