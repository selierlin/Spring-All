package com.springboot.ehcache.service.impl;

import com.springboot.ehcache.entity.Student;
import com.springboot.ehcache.mapper.StudentMapper;
import com.springboot.ehcache.service.StudentService;
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
    public Student update(Student student) {
        //return this.studentMapper.update(student);
        this.studentMapper.update(student);
        return this.studentMapper.queryStudentBySno(student.getSno());
    }
    
    @Override
    public void deleteBysno(String sno) {
        //return this.studentMapper.deleteBysno(sno);
        this.studentMapper.deleteBysno(sno);
    }
    
    @Override
    public Student queryStudentBySno(String sno) {
        System.out.println("查询sno: "+sno);
        return this.studentMapper.queryStudentBySno(sno);
    }
}