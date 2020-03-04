package com.example.testmongo.dao;



import com.example.testmongo.entity.Bug;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Component
public interface BugDao {

    @Results(id = "bugMap", value = {
            @Result(id=true, column = "pk_res_bug", property = "pkResbug"),
            @Result(column = "pk_task", property = "pkTask"),
            @Result(column = "engine_id", property = "enginId"),
            @Result(column = "bug_id", property = "bugId"),
            @Result(column = "bug_level", property = "bugLevel"),
            @Result(column = "rule_code", property = "ruleCode"),
            @Result(column = "domain_type", property = "domainType"),
            @Result(column = "level", property = "level"),
            @Result(column = "bug_file", property = "bugFile"),
            @Result(column = "file_name", property = "fileName"),
            @Result(column = "file_path", property = "filePath"),
            @Result(column = "file_encoding", property = "fileEncoding"),
            @Result(column = "file_type", property = "fileType"),
            @Result(column = "bug_file_md5", property = "bugFilemd5"),
            @Result(column = "bug_begin_line", property = "bugBeginline"),
            @Result(column = "bug_end_line", property = "bugEndline"),
            @Result(column = "bug_begin_col", property = "bugBegincol"),
            @Result(column = "bug_end_col", property = "bugEndcol"),
            @Result(column = "standard_name", property = "standardName"),
            @Result(column = "rule_type", property = "ruleType"),
            @Result(column = "rule_name", property = "ruleName"),
            @Result(column = "bug_func", property = "bugFunc"),
            @Result(column = "audit_result", property = "auditResult"),
            @Result(column = "audit_result", property = "auditResultOld"),
            @Result(column = "audit_memo", property = "auditMemo"),
            @Result(column = "pk_user", property = "pkUser"),
            @Result(column = "audit_time", property = "auditTime"),
            @Result(column = "bug_url", property = "bugUrl"),
            @Result(column = "svn_git_info", property = "svngitInfo"),
            @Result(column = "tool", property = "tool"),
            @Result(column = "spoint", property = "sourcePoint"),
            @Result(column = "bug_status", property = "auditState"),
            @Result(column = "committer", property = "authorName"),
            @Result(column = "commit_id", property = "commitId"),
            @Result(column = "commit_time", property = "commitTime"),
            @Result(column = "commit_msg", property = "commitMsg"),
            @Result(column = "email", property = "email")
    })

    @Select("SELECT * FROM chk_res_bug_148 where pk_res_bug < #{idend, jdbcType=INTEGER} and pk_res_bug > #{idstart,jdbcType=INTEGER}")
    List<Bug> findAll(int idstart, int idend);
}
