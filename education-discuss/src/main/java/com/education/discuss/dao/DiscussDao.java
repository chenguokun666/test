package com.education.discuss.dao;

import com.education.discuss.pojo.Discuss;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface DiscussDao extends JpaRepository<Discuss,Integer>,JpaSpecificationExecutor<Discuss>{

    @Query(value = "select a.discussid,a.discusstitle,a.discusscontent,a.checkcount,a.replycount,a.discusstime,b.discussname,c.usernick from discuss a LEFT JOIN discusstype b on a.discusstypeid=b.discusstypeid LEFT JOIN `user` c on a.userid=c.userid where a.discusstypeid=?1 ORDER BY a.discusstime limit ?2,?3",nativeQuery = true)
    List discussNew(int discusstypeid, int page, int pageSize);
    @Query(value = "select a.discussid,a.discusstitle,a.discusscontent,a.checkcount,a.replycount,a.discusstime,b.discussname,c.usernick from discuss a LEFT JOIN discusstype b on a.discusstypeid=b.discusstypeid LEFT JOIN `user` c on a.userid=c.userid where a.discusstypeid=?1 ORDER BY a.checkcount limit ?2,?3",nativeQuery = true)
    List discussHot(int discusstypeid, int page, int pageSize);
    @Query(value = "select a.discussid,a.discusstitle,a.discusscontent,a.checkcount,a.replycount,a.discusstime,b.discussname,c.usernick from discuss a LEFT JOIN discusstype b on a.discusstypeid=b.discusstypeid LEFT JOIN `user` c on a.userid=c.userid where a.discusstypeid=?1 and a.replycount=0 ORDER BY a.replycount limit ?2,?3",nativeQuery = true)
    List discussRepy(int discusstypeid, int page, int pageSize);
    @Query(value = "select a.discussid,a.discusstitle,a.discusscontent,a.checkcount,a.replycount,a.discusstime,b.discussname,c.usernick from discuss a LEFT JOIN discusstype b on a.discusstypeid=b.discusstypeid LEFT JOIN `user` c on a.userid=c.userid where a.discusstypeid=?1 ORDER BY a.discusstime desc limit ?2,?3",nativeQuery = true)
    List discussNewDesc(int discusstypeid, int page, int pageSize);
    @Query(value = "select a.discussid,a.discusstitle,a.discusscontent,a.checkcount,a.replycount,a.discusstime,b.discussname,c.usernick from discuss a LEFT JOIN discusstype b on a.discusstypeid=b.discusstypeid LEFT JOIN `user` c on a.userid=c.userid where a.discusstypeid=?1 ORDER BY a.checkcount desc limit ?2,?3",nativeQuery = true)
    List discussHotDesc(int discusstypeid, int page, int pageSize);
    @Query(value = "select a.discussid,a.discusstitle,a.discusscontent,a.checkcount,a.replycount,a.discusstime,b.discussname,c.usernick from discuss a LEFT JOIN discusstype b on a.discusstypeid=b.discusstypeid LEFT JOIN `user` c on a.userid=c.userid where a.discusstypeid=?1 and a.replycount=0 ORDER BY a.replycount desc limit ?2,?3",nativeQuery = true)
    List discussRepyDesc(int discusstypeid, int page, int pageSize);
}
