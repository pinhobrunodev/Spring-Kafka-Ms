package com.pinhobrunodev.user.repositories;

import com.pinhobrunodev.user.models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserModel,String > {
}
