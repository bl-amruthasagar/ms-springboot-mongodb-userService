package com.ams.userapis.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ams.userapis.model.UserModel;



@Repository
public interface UserRepo extends MongoRepository<UserModel, Long>{

}
