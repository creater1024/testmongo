package com.example.testmongo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Document(collection = "bug_new_test_0.2million")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bug {
    /**
     * pk_res_bug 自增主键
     */
    private Long pkResbug;
    /**
     * pk_task 任务主键
     */
    private Long pkTask;

    /**
     * 引擎分析模式engin_id
     */
    private String enginId;

    /**
     * bug_id 引擎生成的bugid
     */
    private String bugId;

    /**
     * 引擎生成的等级bug_level
     */
    private int bugLevel;

    /**
     * 规则id rule_code
     */
    private String ruleCode;

    private Integer level;

    /**
     * 缺陷所在文件 bug_file(检测引擎生成的路径)
     */
    private String bugFile;
    /**
     * 缺陷所在文件 bug_file(引擎生成的绝对路径)
     */
    private String bugFileAbs;

    /**
     * 文件名称 file_name
     */
    private String fileName;
    /**
     * 缺陷所在文件 file_path(实际存在服务器上的路径)
     */
    private String filePath;

    /**
     * 文件类型file_type
     */
    private String fileType;
    /**
     * file_encoding 文件编码
     */
    private String fileEncoding;
    /**
     * 缺陷的Md5码 bug_file_md5
     */
    private String bugFilemd5;

    /**
     * 缺陷 起始行 bug_begin_line
     */
    private long bugBeginline;
    /**
     * 缺陷结束行 bug_end_line
     */
    private long bugEndline;

    /**
     * 缺陷起始列 bug_begin_col
     */
    private long bugBegincol;

    /**
     * 缺陷结束列bug_end_col
     */
    private long bugEndcol;

    /**
     * 一级类standard_name
     */
    private String standardName;
    /**
     * 二级类rule_type
     */
    private String ruleType;
    /**
     * 三级类rule_name
     */
    private String ruleName;

    private int domainType;

    /**
     * 缺陷所在方法名称bug_func
     */
    private String bugFunc;

    /**
     * 审计结果,数据库中存在的 audit_result
     */
    private int auditResultOld;
    /**
     * 审计时候，前台选择的 审计结果 初始值 同 auditResult
     */
    private Integer auditResult;
    /**
     * 审计描述audit_memo
     */
    private String auditMemo;
    /**
     * 审计人pk_user
     */
    private Long pkUser;
    /**
     * 审计时间audit_time
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date auditTime;
    /**
     * 缺陷起始点
     */
    private String sourcePoint;

    /**
     * 缺陷描述
     *
     */
    private String dsp;
    /**
     * 修复建议
     *
     */
    private String adv;
    /**
     * 提交bug平台后返回的地址 bug_url
     */
    private String bugUrl;
    /**
     * svn作者信息
     */
    private String svngitInfo;

    /**
     * 提交者名称 数据库字段、XML结果字段 committer
     */
    private String authorName = "";

    private Long commitId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commitTime;

    private String commitMsg;

    private String email;

    /**
     * 分支名
     */
    private String gitBranchName;

    /**
     * 标示这个缺陷是哪个引擎测出的
     */
    private String tool;

    /** 标识一个缺陷的审计状态：遗留/是问题 */
    private int auditState;

    public String getTools() {
        return tool;
    }

    public void setBugFilemd5(String bugFilemd5) {
        if(this.bugFilemd5 != null){
            if (bugFilemd5 != null) {
                int point = bugFilemd5.indexOf(",");
                if (point >= 0 && point < bugFilemd5.length()) {
                    String[] md5s = bugFilemd5.split(",");
                    if(md5s != null && md5s.length > 0){
                        StringBuilder sb = new StringBuilder(this.bugFilemd5);
                        for(String md5 : md5s){
                            if(sb.indexOf(md5) < 0){
                                sb.append(",");
                                sb.append(md5);
                            }
                        }
                        this.bugFilemd5 = sb.toString();
                    }
                }else{
                    if(!this.bugFilemd5.contains(bugFilemd5)){
                        this.bugFilemd5 += "," + bugFilemd5;
                    }
                }
            }
            if (this.bugFilemd5.length() > 500) {
                // 一个引擎32+1位，至少支持15个引擎结果整合到一起
                this.bugFilemd5 = this.bugFilemd5.substring(0, 500);
            }
        }else{
            this.bugFilemd5 = bugFilemd5;
        }

    }
}
