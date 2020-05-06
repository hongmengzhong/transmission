package com.example.transmission.mssdata.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface MssProductStoreMapper {

    List<Map<String, Object>> getAllProductStore(@Param("acoundid") int acoundid, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<Map<String, Object>> getdelAllProductStore(@Param("acoundid") int acoundid, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<Map<String, Object>> getAutoDataStore(@Param("acoundid") int acoundid, @Param("startTime") Date startTime, @Param("endTime") Date endTime);

    List<Map<String, Object>> getAllProductStore1(@Param("acoundid")Integer acoundid);
}
