package com.ruoyi.today.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * token对象 th_token
 * 
 * @author ruoyi
 * @date 2019-08-20
 */
public class ThToken extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 返回码 */
    @Excel(name = "返回码")
    private String code;

    /** 权限token */
    @Excel(name = "权限token")
    private String accessToken;

    /** 刷新token */
    @Excel(name = "刷新token")
    private String refreshToken;

    /** 返回信息 */
    @Excel(name = "返回信息")
    private String message;

    /** requestID */
    @Excel(name = "requestID")
    private String requestId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setAccessToken(String accessToken) 
    {
        this.accessToken = accessToken;
    }

    public String getAccessToken() 
    {
        return accessToken;
    }
    public void setRefreshToken(String refreshToken) 
    {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() 
    {
        return refreshToken;
    }
    public void setMessage(String message) 
    {
        this.message = message;
    }

    public String getMessage() 
    {
        return message;
    }
    public void setRequestId(String requestId) 
    {
        this.requestId = requestId;
    }

    public String getRequestId() 
    {
        return requestId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("code", getCode())
            .append("accessToken", getAccessToken())
            .append("refreshToken", getRefreshToken())
            .append("message", getMessage())
            .append("requestId", getRequestId())
            .toString();
    }
}
