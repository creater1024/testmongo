package com.example.testmongo.dao;

import com.example.testmongo.entity.User;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component

public class UserDao {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<User> insertCollection( List<User> userList) {
        return (List<User>) mongoTemplate.insert(userList,User.class);
    }
//    @Transactional
    public  User insertUser(User user){
        return mongoTemplate.insert(user);
    }
    public void deleteUser(User user){
        mongoTemplate.remove(user);
    }
}
