package com.shareloc.server.ShareLocServer.repository;

import com.shareloc.server.ShareLocServer.model.User;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

}
