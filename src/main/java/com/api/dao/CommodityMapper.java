package com.api.dao;

import com.api.entity.Commodity;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommodityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Commodity record);

    Commodity selectByPrimaryKey(Integer id);

    List<Commodity> selectAll();

    int updateByPrimaryKey(Commodity record);
}