package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 演员文件储存路径对象 actor_file
 * 
 * @author ruoyi
 * @date 2020-05-11
 */
public class ActorFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 演员表id */
    @Excel(name = "演员表id")
    private Long loadid;

    /** 编号 */
    @Excel(name = "编号")
    private String num;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 路径 */
    @Excel(name = "路径")
    private String filePath;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLoadid(Long loadid) 
    {
        this.loadid = loadid;
    }

    public Long getLoadid() 
    {
        return loadid;
    }
    public void setNum(String num) 
    {
        this.num = num;
    }

    public String getNum() 
    {
        return num;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("loadid", getLoadid())
            .append("num", getNum())
            .append("fileName", getFileName())
            .append("filePath", getFilePath())
            .append("createTime", getCreateTime())
            .toString();
    }
}
