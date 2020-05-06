package com.example.transmission.mssdata.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface MssProductImeiMapper {
    List<Map<String, Object>> getProductImeiList(@Param("acoundid") int acoundid,@Param("startTime") Date startTime,@Param("endTime") Date endTime);

    List<Map<String, Object>> getDelProductImeiList(@Param("acoundid") int acoundid,@Param("startTime") Date startTime,@Param("endTime") Date endTime);
}
