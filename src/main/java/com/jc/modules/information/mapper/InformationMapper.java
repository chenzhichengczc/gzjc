package com.jc.modules.information.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jc.modules.information.entity.InformationEntity;

import java.util.List;


/**
 * @author ：fenghuang
 * @date ：Created in 2019/3/12 18:07
 * @description：资讯核心mapper
 * @modified By：
 * @version:
 */
public interface InformationMapper extends BaseMapper<InformationEntity> {

   boolean insertBatch(List<InformationEntity> list);

}
