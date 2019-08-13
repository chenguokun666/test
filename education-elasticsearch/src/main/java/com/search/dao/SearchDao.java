package com.search.dao;

import com.search.pojo.EsCourse;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchDao extends ElasticsearchRepository<EsCourse,String> {

}
