package com.springboot.rediscache.service;

import com.springboot.rediscache.entity.Student;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@CacheConfig(cacheNames = "student")
@Repository
public interface StudentService {
    int add(Student student);

    @CachePut(key = "#p0.sno")
    Student update(Student student);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteBysno(String sno);

    @Cacheable(key = "#p0")
    Student queryStudentBySno(String sno);
}