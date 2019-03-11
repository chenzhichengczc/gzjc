package com.jc.modules.company.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Charles Chan
 * @Date: 2019/3/11 16:58
 * @Version 1.0
 */
@Data
@ApiModel("基础实体类")
public class BasicEntity implements Serializable {

    @ApiModelProperty(value = "创建时间",name = "createTime")
    private Date createTime;

    @ApiModelProperty(value = "创建人",name = "createBy")
    private  String createBy;

    @ApiModelProperty(value = "修改时间",name = "proUpdateTime")
    private  Date proUpdateTime;

    @ApiModelProperty(value = "修改人",name = "proUpdateBy")
    private  String proUpdateBy;
}
