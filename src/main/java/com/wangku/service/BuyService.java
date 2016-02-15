package com.wangku.service;

import java.util.List;
import com.wangku.entity.Buy;
import com.wangku.entity.BuyExample;

/**
 * Title:BuyService
 * Description: 采购SERVICE接口
 * Company: 中国网库
 * @author 庞大涛
 * @date 2016-2-2 下午4:39:22
 */
public interface BuyService {
	
	/**
	 * 展示采购列表
	 * 
	 * @param buyExample
	 * @return
	 */
	public List<Buy> search(BuyExample buyExample);
	
	/**
	 * 查询采购列表数据条数
	 * 
	 * @param buyExample
	 * @return
	 */
	public int searchCount(BuyExample buyExample);
	
	/**
	 * 发布采购信息
	 * 
	 * @param buy
	 * @return
	 */
	public int add(Buy buy);
	
}