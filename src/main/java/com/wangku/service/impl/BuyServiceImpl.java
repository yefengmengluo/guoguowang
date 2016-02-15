package com.wangku.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wangku.entity.Buy;
import com.wangku.entity.BuyExample;
import com.wangku.mapper.BuyMapper;
import com.wangku.service.BuyService;

/**
 * Title:BuyServiceImpl
 * Description: 采购SERVICE接口实现类
 * Company: 中国网库
 * @author 庞大涛
 * @date 2016-2-2 下午4:39:42
 */
@Service
public class BuyServiceImpl implements BuyService{
	
	@Autowired
	private BuyMapper buyMapper;

	/**
	 * 展示采购列表
	 * 
	 * @param buyExample
	 * @return
	 */
	public List<Buy> search(BuyExample buyExample) {
		return buyMapper.selectByExample(buyExample);
	}
	
	/**
	 * 查询采购列表数据条数
	 * 
	 * @param buyExample
	 * @return
	 */
	public int searchCount(BuyExample buyExample) {
		return buyMapper.countByExample(buyExample);
	}

	/**
	 * 发布采购信息
	 * 
	 * @param buy
	 * @return
	 */
	public int add(Buy buy) {
		return buyMapper.insert(buy);
	}

}