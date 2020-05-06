package com.example.transmission.msdata.product.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface MsProductMapper {
    int getCountAll();

    void savaAll(Map<String, Object> productList);

    void saveAllList(List<Map<String, Object>> productLists);

    void callProductNew(@Param("updateDate") Date updateDate);

    int findProductExist(Map<String, Object> product);

    void updateProductInfo(Map<String, Object> product);

}
