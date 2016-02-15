package com.wangku.mapper;

import com.wangku.entity.Buy;
import com.wangku.entity.BuyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Title:BuyMapper
 * Description: 采购MAPPER接口
 * Company: 中国网库
 * @author 庞大涛
 * @date 2016-2-2 下午4:38:57
 */
public interface BuyMapper {
    int countByExample(BuyExample example);

    int deleteByExample(BuyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Buy record);

    int insertSelective(Buy record);

    List<Buy> selectByExample(BuyExample example);

    Buy selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Buy record, @Param("example") BuyExample example);

    int updateByExample(@Param("record") Buy record, @Param("example") BuyExample example);

    int updateByPrimaryKeySelective(Buy record);

    int updateByPrimaryKey(Buy record);
}