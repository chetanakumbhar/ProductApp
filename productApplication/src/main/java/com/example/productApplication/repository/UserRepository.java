package com.example.productApplication.repository;

import com.example.productApplication.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    //save(User user)
    // findAll()
    // findAll()
}
