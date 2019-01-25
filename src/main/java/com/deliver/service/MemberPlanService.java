package com.deliver.service;

import com.deliver.dao.CourseDao;
import com.deliver.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by pdl on 2018/9/13.
 */

@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;

    public Course findByCourseIDAndDeleteFlag(int id, int deleteFlag){
        return courseDao.findByCourseIDAndDeleteFlag(id,deleteFlag);
    }

    public List<Course> findBySchoolIDAndDeleteFlag(int id, int deleteFlag) {
        return courseDao.findBySchoolIDAndDeleteFlag(id,deleteFlag);
    }

    public List<Course> findBySchoolIDAndFinishFlagAndDeleteFlag(int schoolID,int finishFlag, int deleteFlag){
        return courseDao.findBySchoolIDAndFinishFlagAndDeleteFlag(schoolID,finishFlag,deleteFlag);
    }

    public List<Course> findBySchoolIDAndUpdateTimeAfter(int id,Date date){
        return courseDao.findBySchoolIDAndUpdateTimeAfter(id, date);
    }


    public Course save(Course course) {
        course.setCreateTime(new Date());
        course.setUpdateTime(new Date());
        return courseDao.save(course);
    }



    public Course update(Course course) {
        course.setUpdateTime(new Date());
        return courseDao.save(course);
    }

    public Course delAdvert(Course course) {
        course.setUpdateTime(new Date());
        course.setDeleteFlag(1);
        return courseDao.save(course);
    }

    public int delete(int id) {
        return courseDao.deleteByCourseID(id);
    }

}
