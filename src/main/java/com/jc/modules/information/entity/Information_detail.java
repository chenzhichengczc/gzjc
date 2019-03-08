package com.jc.modules.information.entity;

import java.util.Date;

/**
 * 资讯类型
 */
public class Information_detail {
    /**
     * 主键
     */
    private Integer detail_id;
    /**
     * 资讯类型id
     */
    private Integer category_id;
    /**
     *资讯图片
     */
    private String image;
    /**
     *资讯关键字
     */
    private String key;
    /**
     *资讯点击量
     */
    private Integer click;
    /**
     *资讯简短描述
     */
    private String brief;
    /**
     *资讯详细描述
     */
    private String text;
    /**
     *资讯来源渠道
     */
    private Integer channel;
    /**
     *创建时间
     */
    private Date create_time;
    /**
     *创建人
     */
    private String create_by;
    /**
     *修改时间
     */
    private Date update_time;
    /**
     *修改人
     */
    private String update_by;

    public Integer getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(Integer detail_id) {
        this.detail_id = detail_id;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    @Override
    public String toString() {
        return "Information_detail{" +
                "detail_id=" + detail_id +
                ", category_id=" + category_id +
                ", image='" + image + '\'' +
                ", key='" + key + '\'' +
                ", click=" + click +
                ", brief='" + brief + '\'' +
                ", text='" + text + '\'' +
                ", channel=" + channel +
                ", create_time=" + create_time +
                ", create_by='" + create_by + '\'' +
                ", update_time=" + update_time +
                ", update_by='" + update_by + '\'' +
                '}';
    }
}
