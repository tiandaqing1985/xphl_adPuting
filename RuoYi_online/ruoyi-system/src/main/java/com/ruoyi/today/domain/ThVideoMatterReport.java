package com.ruoyi.today.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 素材报对象 th_video_matter_report
 *
 * @author ruoyi
 * @date 2020-03-11
 */
public class ThVideoMatterReport extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 广告主id
     */
    @Excel(name = "广告主id")
    private String advertiserId;

    /**
     * 素材表主键
     */
    @Excel(name = "素材表主键")
    private Long matterId;

    /**
     * 消耗量
     */
    @Excel(name = "消耗量")
    private String cost;

    /**
     * 展示量
     */
    @Excel(name = "展示量")
    private String show;

    /**
     * 点击量
     */
    @Excel(name = "点击量")
    private String click;

    /**
     * 转化量
     */
    @Excel(name = "转化量")
    private String convert;

    /**
     * 平均单词播放时长
     */
    @Excel(name = "平均单词播放时长")
    private String averagePlayTimePerPlay;

    /**
     * 25%进度播放数
     */
    @Excel(name = "25%进度播放数")
    private String play25FeedBreak;

    /**
     * 50%进度播放数
     */
    @Excel(name = "50%进度播放数")
    private String play50FeedBreak;

    /**
     * 75%进度播放数
     */
    @Excel(name = "75%进度播放数")
    private String play75FeedBreak;

    /**
     * 99%进度播放数
     */
    @Excel(name = "99%进度播放数")
    private String play100FeedBreak;

    /**
     * 关联创意数
     */
    @Excel(name = "关联创意数")
    private String aboutCreativity;

    /**
     * 数据时间
     */
    @Excel(name = "数据时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    //总播放数
    private String totalPlay;

    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTotalPlay() {
        return totalPlay;
    }

    public void setTotalPlay(String totalPlay) {
        this.totalPlay = totalPlay;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setMatterId(Long matterId) {
        this.matterId = matterId;
    }

    public Long getMatterId() {
        return matterId;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCost() {
        return cost;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getShow() {
        return show;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public String getClick() {
        return click;
    }

    public void setConvert(String convert) {
        this.convert = convert;
    }

    public String getConvert() {
        return convert;
    }

    public void setAveragePlayTimePerPlay(String averagePlayTimePerPlay) {
        this.averagePlayTimePerPlay = averagePlayTimePerPlay;
    }

    public String getAveragePlayTimePerPlay() {
        return averagePlayTimePerPlay;
    }

    public void setPlay25FeedBreak(String play25FeedBreak) {
        this.play25FeedBreak = play25FeedBreak;
    }

    public String getPlay25FeedBreak() {
        return play25FeedBreak;
    }

    public void setPlay50FeedBreak(String play50FeedBreak) {
        this.play50FeedBreak = play50FeedBreak;
    }

    public String getPlay50FeedBreak() {
        return play50FeedBreak;
    }

    public void setPlay75FeedBreak(String play75FeedBreak) {
        this.play75FeedBreak = play75FeedBreak;
    }

    public String getPlay75FeedBreak() {
        return play75FeedBreak;
    }

    public void setPlay100FeedBreak(String play100FeedBreak) {
        this.play100FeedBreak = play100FeedBreak;
    }

    public String getPlay100FeedBreak() {
        return play100FeedBreak;
    }

    public void setAboutCreativity(String aboutCreativity) {
        this.aboutCreativity = aboutCreativity;
    }

    public String getAboutCreativity() {
        return aboutCreativity;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public boolean isAllZero() {
        if (getCost() != null && Double.valueOf(getCost()) != 0) {
            return false;
        }
        if (getShow() != null && Double.valueOf(getShow()) != 0) {
            return false;
        }
        if (getClick() != null && Double.valueOf(getClick()) != 0) {
            return false;
        }
        if (getConvert() != null && Double.valueOf(getConvert()) != 0) {
            return false;
        }
        if (getAveragePlayTimePerPlay() != null && Double.valueOf(getAveragePlayTimePerPlay()) != 0) {
            return false;
        }
        if (getPlay25FeedBreak() != null && Double.valueOf(getPlay25FeedBreak()) != 0) {
            return false;
        }
        if (getPlay50FeedBreak() != null && Double.valueOf(getPlay50FeedBreak()) != 0) {
            return false;
        }
        if (getPlay75FeedBreak() != null && Double.valueOf(getPlay75FeedBreak()) != 0) {
            return false;
        }
        if (getPlay100FeedBreak() != null && Double.valueOf(getPlay100FeedBreak()) != 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("advertiserId", getAdvertiserId())
                .append("matterId", getMatterId())
                .append("cost", getCost())
                .append("show", getShow())
                .append("click", getClick())
                .append("convert", getConvert())
                .append("averagePlayTimePerPlay", getAveragePlayTimePerPlay())
                .append("play25FeedBreak", getPlay25FeedBreak())
                .append("play50FeedBreak", getPlay50FeedBreak())
                .append("play75FeedBreak", getPlay75FeedBreak())
                .append("play100FeedBreak", getPlay100FeedBreak())
                .append("aboutCreativity", getAboutCreativity())
                .append("time", getTime())
                .toString();
    }
}
