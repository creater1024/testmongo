package com.example.testmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("MavenCentral1")
public class MavenCentral1 {
    private int _id;
    private String group;
    private String name;
    private String version;
    private String sha1;
    private int versionId;
    private Boolean deleted;
}
