package com.mongo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.entities.Student;

public interface StudentRepository extends MongoRepository<Student, Integer> {

}
