package com.springboot.mybatismuli.service.impl;

import com.springboot.mybatismuli.mysqldao.MysqlStudentMapper;
import com.springboot.mybatismuli.oracledao.OracleStudentMapper;
import com.springboot.mybatismuli.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImp implements StudentService {
	@Autowired
	private OracleStudentMapper oracleStudentMapper;
	@Autowired
	private MysqlStudentMapper mysqlStudentMapper;
	
	@Override
	public List<Map<String, Object>> getAllStudentsFromOralce() {
		return this.oracleStudentMapper.getAllStudents();
	}

	@Override
	public List<Map<String, Object>> getAllStudentsFromMysql() {
		return this.mysqlStudentMapper.getAllStudents();
	}

}
