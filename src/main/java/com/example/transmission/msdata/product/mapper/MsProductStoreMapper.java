package com.example.transmission.msdata.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface MsProductStoreMapper {

    void saveProductStore(Map<String, Object> map);

    void deleteProductStore(Map<String, Object> map);

    void saveAutoStoreList(List<Map<String, Object>> productLists);

    void saveProductStoreList(List<Map<String, Object>> productLists);

    void updateDelProductStore(Map<String, Object> map);
    void callPinitKc(@Param("updateTime") Date updateTime);

    List<String> findSynchronizationStock(@Param("endTime") Date sysTime, @Param("startTime")Date updateTime);
}
