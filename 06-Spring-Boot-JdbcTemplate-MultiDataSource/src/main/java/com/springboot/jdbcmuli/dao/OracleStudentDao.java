package com.springboot.jdbcmuli.dao;

import java.util.List;
import java.util.Map;

public interface OracleStudentDao {
	List<Map<String, Object>> getAllStudents();
}
