package com.springboot.springbootmybatis.service.impl;

import com.springboot.springbootmybatis.dao.StudentMapper;
import com.springboot.springbootmybatis.entity.Student;
import com.springboot.springbootmybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    
    @Override
    public int add(Student student) {
        return this.studentMapper.add(student);
    }
    
    @Override
    public int update(Student student) {
        return this.studentMapper.update(student);
    }
    
    @Override
    public int deleteBysno(String sno) {
        return this.studentMapper.deleteBysno(sno);
    }
    
    @Override
    public Student queryStudentBySno(String sno) {
        return this.studentMapper.queryStudentBySno(sno);
    }
}