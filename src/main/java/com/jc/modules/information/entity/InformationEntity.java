package com.jc.modules.information.entity;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.jc.basic.BasicEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;


/**
 * @author ：fenghuang
 * @date ：Created in 2019/3/12 16:59
 * @description：资讯信息分类
 * @modified By：
 * @version:
 */
@TableName("jc_information")
@Data
@ApiModel("资讯核心表")
public class InformationEntity implements Serializable {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键",name = "id")
    private Integer id;

    @ApiModelProperty(value = "资讯类型名字",name = "typeName")
    private String typeName;

    @ApiModelProperty(value = "资讯状态;默认资讯可用 - 0为可用 - 1为不可用",name = "status")
    private Integer status;

    @ApiModelProperty(value = "父类;判断是否该类目是否为父类目，- 0为父类 - 1 不为父类",name = "is_Parent")
    private Integer isParent;



}
