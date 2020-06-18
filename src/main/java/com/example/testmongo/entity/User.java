package com.example.testmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "manager")
public class User {
    @Id
    private String id;
    private String userName;
    @NotBlank
    private String password;
    private Integer age;

    public User(String id, String userName){
        this.id=id;
        this.userName=userName;
    }
}
