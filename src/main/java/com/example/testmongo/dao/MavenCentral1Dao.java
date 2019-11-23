package com.example.testmongo.dao;

import com.example.testmongo.entity.MavenCentral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MavenCentral1Dao {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<MavenCentral> insertMaven(List<MavenCentral> userList) {
        return (List<MavenCentral>) mongoTemplate.insert(userList,MavenCentral.class);
    }
}
