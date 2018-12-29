package com.biz.std.service;

import com.biz.std.vo.PageReqVo;
import com.biz.std.vo.student.StdSubVo;
import com.biz.std.vo.student.StudentListVo;
import com.biz.std.vo.student.StudentVo;

/**
 * StudentService class
 * @author junzhang
 * @date 2018-12-29
 */

public interface StudentService {

    /**
     * 分页获取学生信息集合
     * @param reqVo 分页信息
     * @return StudentListVo
     */
    StudentListVo findStudentList(PageReqVo reqVo);

    /**
     * 根据学号获取学生信息
     */
    StudentVo getStudent(Long id);

    /**
     * 保存学生信息
     */
    void saveStudent(StudentVo studentVo);

    /**
     * 添加学生选课信息
     */
    void saveStudent(StdSubVo stdSubVo);

    /**
     * 删除学生信息
     */
    void deleteStudent(Long id);
}
