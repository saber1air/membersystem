package com.deliver.dao;

import com.deliver.entity.Course;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by pdl on 2018/9/13.
 */
@CacheConfig(cacheNames = "advert")
public interface CourseDao extends JpaRepository<Course, Integer> {
    //@Cacheable()  //查询缓存
    List<Course> findBySchoolIDAndDeleteFlag(int id, int deleteFlag);

    List<Course> findBySchoolIDAndFinishFlagAndDeleteFlag(int id,int finishFlag, int deleteFlag);

    Course findByCourseIDAndDeleteFlag(int id, int deleteFlag);

    List<Course> findByDeleteFlag(int deleteFlag);

    List<Course> findBySchoolIDAndUpdateTimeAfter(int id, Date date);

    /**
     * 新增或修改时
     */
    @CachePut()//往缓存中新增
    @Override
    Course save(Course course);

    @Transactional   //事务管理
    @Modifying
    int deleteByCourseID(int id);

}

