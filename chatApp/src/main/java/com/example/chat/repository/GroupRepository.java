// File: src/main/java/com/example/chat/repository/GroupRepository.java
package com.example.chat.repository;

import com.example.chat.model.Group;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupRepository extends MongoRepository<Group, String> {
}