package com.pinhobrunodev.user;

import com.pinhobrunodev.user.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String > {
}
