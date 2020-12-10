package com.example.testmongo.config;

import com.mongodb.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里主要是开启mongo事务的配置 若不需要启用mongo事务则不需要这个config
 * mongo事务需要至少搭建一个副本集，当前配置是直接在代码中写死了两个分片副本入口
 * @author
 * @version 1.0
 * @date 2019-07-03 08:50
 */

@Configuration
public class MongoConfig extends AbstractMongoConfiguration{

    @Value("${spring.data.mongodb.database}")
    private String mongoDataBaseName;
    @Value("${spring.data.mongodb.username}")
    private String username;
    @Value("${spring.data.mongodb.password}")
    private String key;

    @Bean(name = "MONGO_TRANSACTION_MANAGER")
    MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    @Override
    protected String getDatabaseName() {
        return mongoDataBaseName;
    }

    /**
     * 配置mongo客户端
     * @return
     */
    @Override
    public MongoClient mongoClient() {
        ServerAddress sa = new ServerAddress("10.95.14.38", 27017);
        List<ServerAddress> saList=new ArrayList<>();
        saList.add(sa);
        saList.add(new ServerAddress("10.95.14.44",27017));
        MongoCredential mongoCredential=MongoCredential.createCredential(username, "admin", key.toCharArray());
        return new MongoClient(saList,mongoCredential, MongoClientOptions.builder().socketTimeout(200000).build());

    }

    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory,
                                                       MongoMappingContext context, BeanFactory beanFactory){
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver,context);
        try{
            converter.setCustomConversions(beanFactory.getBean("customConversions",CustomConversions.class));
        }catch (Exception e){
            e.printStackTrace();
        }
        //don't save column _class to mongo collection
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return converter;
    }

}
