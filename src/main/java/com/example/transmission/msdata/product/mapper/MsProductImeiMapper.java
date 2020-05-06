package com.example.transmission.msdata.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface MsProductImeiMapper {

    void saveProductImei(Map<String, Object> map);
    void deleteProductImei(Map<String, Object> map);
    void updateDelProductImei(Map<String, Object> map);
    void callPsynImei(@Param("updateTime") Date updateTime);
}

