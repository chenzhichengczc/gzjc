package com.jc.modules.information.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jc.modules.information.entity.InformationDetailEntity;
import com.jc.modules.information.entity.InformationEntity;
import org.apache.ibatis.annotations.Param;
<<<<<<< HEAD
=======
import org.apache.ibatis.annotations.Select;
>>>>>>> 8f5bc02778c5526b9ca864bb635e78b19b7173fb

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
   /*
    *  Information与InformationDetail两表全部内容
    */
   List<InformationDetailEntity> findAll();

<<<<<<< HEAD
   /*
      pageHelper分页
    */
   List<InformationDetailEntity> getList(@Param("categoryId") int categoryId);

   @Select("select * from jc_information where status = 0")
   List<InformationEntity> getCatalogy();
=======
   List<InformationEntity> selectPage();

<<<<<<< HEAD
   InformationEntity test(@Param(value = "typeName") String typeName,@Param(value = "status") String status);

=======
>>>>>>> f53de285fb7d2bc2c06347224ae1a37ed4103bea
>>>>>>> 8f5bc02778c5526b9ca864bb635e78b19b7173fb
}
