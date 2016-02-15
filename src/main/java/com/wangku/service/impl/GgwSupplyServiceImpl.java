package com.wangku.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.wangku.entity.GgwSupply;
import com.wangku.mapper.GgwSupplyMapper;
import com.wangku.service.GgwSupplyService;
import com.wangku.util.Page;
@Service("ggwSupplyService")
public class GgwSupplyServiceImpl implements GgwSupplyService {

	@Autowired
	private GgwSupplyMapper mapper;
	
	/**
	 * @author： 徐国辉  2016年2月2日 下午5:14:02
	 * @方法名： querySupplysByKeywordPaged
	 * @方法描述：
	 * @param:
	 * @返回值：Page<GgwSupply>
	 */
	public Page<GgwSupply> querySupplysByKeywordPaged(String keyWord, Integer currentNum) {
		Page<GgwSupply> page = new Page<GgwSupply>();
		page.setCurrentNum(currentNum);
		page.setSqlPage(page);
		List<GgwSupply> supplys = mapper.querySupplysByKeywordPaged(keyWord, page.getOffsetValue(), page.getPageSize());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm");
		if(!CollectionUtils.isEmpty(supplys)){
			for(GgwSupply supply :supplys){
				supply.setCrtTime(sdf.format(supply.getCreateTime()));
			}
		}
		
		page.setPageList(supplys);
		return page;
	}

	/**
	 * @author： 徐国辉  2016年2月2日 下午5:15:34
	 * @方法名： addGgwSupply
	 * @方法描述：
	 * @param: supply GgwSupply对象
	 * @返回值：int
	 */
	public int addGgwSupply(GgwSupply supply) {
		supply.setCreateTime(new Date());
		return mapper.insert(supply);
	}

}
