package com.example.testmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("MavenCentral")
public class MavenCentral {
    private int _id;
    private String group;
    private String name;
    private String version;
    private String sha1;
    private int versionId;
    private Boolean deleted;
}
