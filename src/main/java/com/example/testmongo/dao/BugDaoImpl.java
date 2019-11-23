package com.example.testmongo.dao;

import com.example.testmongo.entity.Bug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BugDaoImpl {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<Bug> insertCollection(List<Bug> bugList) {
        return (List<Bug>) mongoTemplate.insert(bugList,Bug.class);
    }

    public Bug selectBug(String id) {return mongoTemplate.findById(id,Bug.class);}
}
