package com.path.dao;

import com.path.pojo.Path;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface PathDao extends JpaRepository<Path,String>,JpaSpecificationExecutor<Path>{

    @Query(value = "select * from path ORDER BY pathlevel DESC",nativeQuery = true)
    List<Path> pathLevalDesc();

    @Query(value = "select * from path ORDER BY pathlevel",nativeQuery = true)
    List<Path> pathLevalAsec();

    @Query(value = "select * from path order by pathjoincount desc ",nativeQuery = true)
    List<Path> pathjoinCountDesc();

    @Query(value = "select * from path order by pathjoincount ",nativeQuery = true)
    List<Path> pathjoinCountAsec();
}
