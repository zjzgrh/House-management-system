package com.swjtu.zjz.dao;

import com.swjtu.zjz.model.House;
import com.swjtu.zjz.model.HouseApply;
import com.swjtu.zjz.model.Rent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface rentMapper {
    @Insert("insert into rent (owner_id,house_id,tenant_id,rent_starttime,rent_time,need_rent,actual_rent) " +
            "values (#{owner_id},#{house_id},#{tenant_id},#{rent_starttime},#{rent_time},#{need_rent},#{actual_rent})")
    void addHouseRent(Rent rent);

    @Select("select * from rent where owner_id = #{id}")
    List<Rent> getRentHouselists(Integer id);

    //将租金缴纳状态设置未1，表示租金已经缴纳,订单已经完成
    @Update("update rent set rent_status = '1' where actual_rent > 0")
    void updateRentStatus();

    //设置实缴金额
    @Update("update rent set actual_rent = #{actual_rent} where house_id = #{house_id}")
    void updateActualRent(Integer house_id,Integer actual_rent);

    /*@Delete("delete from house_apply where house_id = #{house_id}")
    void deleteApplyHouseId(Integer house_id);

    //判断房子申请状态
    @Select("select * from house_apply where house_id = #{house_id} and tenant_id  = #{tenant_id}")
    HouseApply judgeApplyStatus(Integer house_id,Integer tenant_id);*/
}
