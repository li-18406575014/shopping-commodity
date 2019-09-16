package com.api.es;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.api.entity.Commodity;

@Mapper
public interface CommodityDao extends ElasticsearchRepository<Commodity, Integer>{



}