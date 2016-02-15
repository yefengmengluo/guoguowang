package com.wangku.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.wangku.entity.Buy;
import com.wangku.entity.BuyExample;
import com.wangku.service.BuyService;
import com.wangku.util.Page;

/**
 * Title:BuyController
 * Description: 采购控制器类
 * Company: 中国网库
 * @author 庞大涛
 * @date 2016-2-2 下午4:34:26
 */
@Controller
@RequestMapping(value="/buy")
public class BuyController {
	
	public static final String BUY_LIST_PAGE = "frontpages/buy/buy_list";// 采购列表页面
	
	public static final String BUY_ADD_PAGE = "frontpages/buy/buy_add";// 发布采购页面
	
	@Autowired
	private BuyService buyService;
	
	/**
	 * 进入发布采购页面
	 * 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="list")
	public ModelAndView list(Page page,BuyExample buyExample) throws Exception{
		
		if(buyExample != null && buyExample.getBuyDetail() != null && !"".equals(buyExample.getBuyDetail())){
			
			String buyDetail = new String(buyExample.getBuyDetail().getBytes("ISO-8859-1"),"UTF-8");
			
			buyExample.setBuyDetail(buyDetail);
			
		}
		
		ModelAndView view = new ModelAndView(BUY_LIST_PAGE);
		
		buyExample.setOrderByClause("id desc");

		// 从数据库中查询数据总条数
		page.setOffsetValue(buyService.searchCount(buyExample));

		// 计算共几页
		if ((page.getOffsetValue() % page.getPageSize()) == 0) {

			page.setMaxPage((int) (page.getOffsetValue() / page.getPageSize()));

			// 如果数据库中学生数据为零,则让总页数显示为1页
			if (page.getOffsetValue() == 0) {
				page.setMaxPage(1);
			}

		} else {
			
			page.setMaxPage((int) (page.getOffsetValue() / page.getPageSize() + 1));

		}

		buyExample.setLimitClauseStart(page.getPageSize()
				* (page.getCurrentNum() - 1));

		buyExample.setLimitClauseCount(page.getPageSize());

		List<Buy> buyList = buyService.search(buyExample);
		
		List<Buy> newBuyList = new ArrayList<Buy>();
		
		if(buyList.size() > 0){
			for (Buy buy : buyList) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				buy.setCreateTime(df.format(df.parse(buy.getCreateTime())));
				newBuyList.add(buy);
			}
		}

		view.addObject("buyList", newBuyList);
		view.addObject("buyCount", buyService.searchCount(buyExample));
		view.addObject("buyDetail",buyExample.getBuyDetail());
		view.addObject("page", page);

		return view;
		
	}
	
	/**
	 * 展示采购列表
	 * 
	 * @param page
	 * @param buyExample
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="buy_list")
	@ResponseBody
	public JSONArray search(Page page,BuyExample buyExample) throws Exception{
		
		buyExample.setOrderByClause("id desc");
		
		// 从数据库中查询数据总条数
		page.setOffsetValue(buyService.searchCount(buyExample));

		// 计算共几页
		if ((page.getOffsetValue() % page.getPageSize()) == 0) {

			page.setMaxPage((int) (page.getOffsetValue() / page.getPageSize()));

			// 如果数据库中学生数据为零,则让总页数显示为1页
			if (page.getOffsetValue() == 0) {
				page.setMaxPage(1);
			}

		} else {
			
			page.setMaxPage((int) (page.getOffsetValue() / page.getPageSize() + 1));

		}

		buyExample.setLimitClauseStart(page.getPageSize()
				* (page.getCurrentNum() - 1));

		buyExample.setLimitClauseCount(page.getPageSize());

		List<Buy> buyList = buyService.search(buyExample);
		
		List<Buy> newBuyList = new ArrayList<Buy>();
		
		if(buyList.size() > 0){
			for (Buy buy : buyList) {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				buy.setCreateTime(df.format(df.parse(buy.getCreateTime())));
				newBuyList.add(buy);
			}
		}

		JSONArray json = JSONArray.fromObject(newBuyList);

		return json;
		
	}
	
	/**
	 * 进入发布采购页面
	 * 
	 * @return
	 */
	@RequestMapping(value="addUI")
	public ModelAndView addUI(){
		
		ModelAndView view = new ModelAndView(BUY_ADD_PAGE);
		
		return view;
		
	}
	
	/**
	 * 发布采购
	 * 
	 * @param buy
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public JSONObject add(Buy buy) throws Exception{
		
		// 设置创建时间为当前时间
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if(buy.getBuyDetail() != null && !"".equals(buy.getBuyDetail())){
			
			buy.setBuyDetail(new String(buy.getBuyDetail().getBytes("ISO-8859-1"), "UTF-8"));
			
		}
		
		if(buy.getLinkPerson() != null && !"".equals(buy.getLinkPerson())){
			
			buy.setLinkPerson(new String(buy.getLinkPerson().getBytes("ISO-8859-1"), "UTF-8"));
			
		}
		
		if(buy.getAddress() != null && !"".equals(buy.getAddress())){
			
			buy.setAddress(new String(buy.getAddress().getBytes("ISO-8859-1"), "UTF-8"));
			
		}

		buy.setCreateTime(df.format(new Date()));
		
		// 发布采购
		int buyCount = buyService.add(buy);
		
		if(buyCount == 1){
			
			JSONObject obj = JSONObject.fromObject("{success:true}");
			
			return obj;
			
		}else{
			
			JSONObject obj = JSONObject.fromObject("{success:false}");
			
			return obj;
			
		}
		
	}
	
}