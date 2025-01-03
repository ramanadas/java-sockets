// File: src/main/java/com/example/chat/model/Group.java
package com.example.chat.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Group {
  @Id
  private String id;
  private String name;
  private List<String> memberIds; // List of user IDs

  public Group() {}

  public Group(String name, List<String> memberIds) {
    this.name = name;
    this.memberIds = memberIds;
  }

  // Getters and setters
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getMemberIds() {
    return memberIds;
  }

  public void setMemberIds(List<String> memberIds) {
    this.memberIds = memberIds;
  }
}