package com.example.testmongo.dao;

import com.example.testmongo.entity.MavenCentral;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MavenCentralDao {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<MavenCentral> findAll(){
        return mongoTemplate.findAll(MavenCentral.class);
    }
}
