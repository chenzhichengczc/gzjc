package com.jc.modules.information.service.impl;


import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jc.common.annotation.RedisCache;
import com.jc.common.exception.JcException;
<<<<<<< HEAD
import com.jc.modules.information.entity.InformationDetailEntity;
=======
import com.jc.modules.company.service.CompanyService;
>>>>>>> f53de285fb7d2bc2c06347224ae1a37ed4103bea
import com.jc.modules.information.entity.InformationEntity;
import com.jc.modules.information.mapper.InformationMapper;
import com.jc.modules.information.service.InformationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/3/12 18:11
 * @description：资讯核心serviceImpl
 * @modified By：
 * @version:
 */
@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, InformationEntity>
        implements InformationService {

    @Resource
    private InformationMapper informationMapper;

<<<<<<< HEAD
    /*
       查询Information与InformationDetail两表全部内容
     */
    @Override
    public List<InformationDetailEntity> findAll(){
        List<InformationDetailEntity> information=informationMapper.findAll();
        return information;
    }

    @Override
    public List<InformationDetailEntity> getList(int categoryId){
        List<InformationDetailEntity> typeList=informationMapper.getList(categoryId);
        return typeList;
    }

    @Override
    public List<InformationEntity> getCatalogy() {
        return informationMapper.getCatalogy();
    }

    //分页
    @Override
=======
    @RedisCache(key = "pub:cache_key_in_information_list",time = 1000)
>>>>>>> f53de285fb7d2bc2c06347224ae1a37ed4103bea
    public List<InformationEntity> findByPage(Page<InformationEntity> page, Wrapper<InformationEntity> wrapper) {
       /* InformationEntity informationEntity = new InformationEntity();
        informationEntity.setTypeName("hello11");
        informationEntity.setCreateTime(new Date());
        informationEntity.setCreateBy("Rocky");
        informationEntity.setUpdateTime(new Date());
        informationEntity.setUpdateBy("Rocky");
*/
        List<InformationEntity> informationList = informationMapper.selectPage(page, wrapper);
        String s = "s";
        s.equals(page);
        //.add(informationEntity);
        return informationList;
    }
    @RedisCache(key = "pub:cache_key_in_information",time = 60)
    @Override
    public InformationEntity selectById(Integer id) {
        InformationEntity informationEntity = informationMapper.selectById(id);

        return informationEntity;
    }

    @Override
    public void insertInfo(InformationEntity informationEntity) {
        Integer insertResult = informationMapper.insert(informationEntity);
        if(insertResult != 1){
            throw new JcException("资讯类型插入失败");
        }
    }

    @Override
    public void batchInsertInfo(List<InformationEntity> infoList) {
        boolean b = informationMapper.insertBatch(infoList);
        //是否有事务管理
        if(b != true){
            throw new JcException("批量资讯类型插入失败");
        }
    }

    @Override
    public void updateInfoById(InformationEntity informationEntity) {
        Integer integer = informationMapper.updateById(informationEntity);
        if(integer != 1){
            throw new JcException("更新资讯类型失败");
        }

        System.out.println("InformationServiceImpl.updateInfoById");

    }

    @Override
    public void deleteInfoById(Integer id) {
        Integer integer = informationMapper.deleteById(id);
        if(integer != 1){
            throw new JcException("删除资讯类型失败");
        }
    }

    @Override
    public List<InformationEntity> selectPage() {
        List<InformationEntity> informationEntities = informationMapper.selectPage();
        return informationEntities;
    }


}
