package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.HouseApply;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface houseapplyMapper {

    @Insert("insert into house_apply (house_id,tenant_id,apply_starttime) values (#{house_id},#{tenant_id},#{apply_starttime})")
    void addHouseApplly(HouseApply houseApply);

    @Select("select * from house_apply where tenant_id = #{id}")
    List<House> getApplyHouselists(Integer id);

    @Delete("delete from house_apply where house_id = #{house_id}")
    void deleteApplyHouseId(Integer house_id);

    //判断房子申请状态
    @Select("select * from house_apply where house_id = #{house_id} and tenant_id  = #{tenant_id}")
    HouseApply judgeApplyStatus(Integer house_id,Integer tenant_id);

    //将申请表中的申请结果设置为1
    @Update("update house_apply set apply_result = '1' where house_id = #{house_id} and tenant_id  = #{tenant_id}")
    void setApplyResultTrue(Integer house_id,Integer tenant_id);

    //将申请表中的申请结果设置为0
    @Update("update house_apply set apply_result = '0' where house_id = #{house_id} and tenant_id  = #{tenant_id}")
    void setApplyResultFalse(Integer house_id,Integer tenant_id);

    //查询申请表中的申请结果
    @Select("select apply_result from house_apply where house_id = #{house_id} and tenant_id  = #{tenant_id}")
    char findApplyResult(Integer house_id,Integer tenant_id);

}
