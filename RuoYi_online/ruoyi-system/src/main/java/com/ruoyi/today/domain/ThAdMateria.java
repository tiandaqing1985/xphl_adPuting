package com.ruoyi.today.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 素材对象 th_ad_materia
 * 
 * @author ruoyi
 * @date 2019-09-11
 */
public class ThAdMateria extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 文件名称 */
    private String fileName;

    /** 本地路径 */
    private String localPath;

    /** 远程路径 */
    private String remotePath;

    /** 素材MD5码 */
    private String md5;

    /** 素材id */
    private String materiaId;

    /** 广告主 */
    private String advertiserId;

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setLocalPath(String localPath) 
    {
        this.localPath = localPath;
    }

    public String getLocalPath() 
    {
        return localPath;
    }
    public void setRemotePath(String remotePath) 
    {
        this.remotePath = remotePath;
    }

    public String getRemotePath() 
    {
        return remotePath;
    }
    public void setMd5(String md5) 
    {
        this.md5 = md5;
    }

    public String getMd5() 
    {
        return md5;
    }
    public void setMateriaId(String materiaId) 
    {
        this.materiaId = materiaId;
    }

    public String getMateriaId() 
    {
        return materiaId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fileName", getFileName())
            .append("localPath", getLocalPath())
            .append("remotePath", getRemotePath())
            .append("md5", getMd5())
            .append("materiaId", getMateriaId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
