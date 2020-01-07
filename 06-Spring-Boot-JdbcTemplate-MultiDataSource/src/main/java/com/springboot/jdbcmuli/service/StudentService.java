package com.springboot.jdbcmuli.service;

import java.util.List;
import java.util.Map;

public interface StudentService {
	List<Map<String, Object>> getAllStudentsFromOralce();
	List<Map<String, Object>> getAllStudentsFromMysql();
}
