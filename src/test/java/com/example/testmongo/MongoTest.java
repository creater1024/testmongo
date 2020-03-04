package com.example.testmongo;

import com.example.testmongo.service.BugService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MongoTest {
    @Autowired
    BugService bugService;

    @Test
    public void testMongo(){
        bugService.findBug();
    }
}
