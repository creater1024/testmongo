package com.example.testmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Date;

@Document(collection = "bug")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bug {
    private Integer pk_res_bug;
    private Integer pk_task;
    private String engine_id;
    private String bug_id;
    private Integer bug_level;
    private String bug_code;
    private String standard_name;
    private String rule_type;
    private String rule_name;
    private String file_path;
    private String file_type;
    private String file_encoding;
    private String bug_file;
    private String bug_file_md5;
    private String bug_func;
    private Integer bug_begin_line;
    private Integer bug_begin_col;
    private Integer bug_end_line;
    private Integer bug_end_col;
    private Integer audit_result;
    private String audit_memo;
    private Integer pk_user;
    private Date audit_time;
    private String bug_url;
    private String svn_git_info;
    private String tool;
    private String spoint;
    private Integer bug_status;
    private Date ts;
    private char new_bug;
}
