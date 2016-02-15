package com.wangku.service;

import com.wangku.entity.GgwSupply;
import com.wangku.util.Page;

public interface GgwSupplyService {
	
	/**
	 * @author： 徐国辉  2016年2月2日 下午5:14:02
	 * @方法名： querySupplysByKeywordPaged
	 * @方法描述：
	 * @param:
	 * @返回值：Page<GgwSupply>
	 */
	public Page<GgwSupply> querySupplysByKeywordPaged(String keyWord,Integer currentNum);

	/**
	 * @author： 徐国辉  2016年2月2日 下午5:15:34
	 * @方法名： addGgwSupply
	 * @方法描述：
	 * @param: supply GgwSupply对象
	 * @返回值：int
	 */
	public int addGgwSupply(GgwSupply supply);
	
	
}
