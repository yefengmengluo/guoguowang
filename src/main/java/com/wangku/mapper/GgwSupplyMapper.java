package com.wangku.mapper;

import com.wangku.entity.GgwSupply;
import com.wangku.entity.GgwSupplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GgwSupplyMapper {
    int countByExample(GgwSupplyExample example);

    int deleteByExample(GgwSupplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GgwSupply record);

    int insertSelective(GgwSupply record);

    List<GgwSupply> selectByExample(GgwSupplyExample example);

    GgwSupply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GgwSupply record, @Param("example") GgwSupplyExample example);

    int updateByExample(@Param("record") GgwSupply record, @Param("example") GgwSupplyExample example);

    int updateByPrimaryKeySelective(GgwSupply record);

    int updateByPrimaryKey(GgwSupply record);
    
    //
    List<GgwSupply> querySupplysByKeywordPaged(@Param("keyWord") String keyWord,
			@Param("offsetValue") Integer offsetValue, @Param("pageSize") Integer pageSize);
}