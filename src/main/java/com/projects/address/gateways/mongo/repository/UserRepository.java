package com.projects.address.gateways.mongo.repository;

import com.projects.address.domains.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
