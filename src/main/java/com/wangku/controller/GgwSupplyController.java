package com.wangku.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangku.entity.GgwSupply;
import com.wangku.service.GgwSupplyService;
import com.wangku.util.Page;

@Controller
@RequestMapping("/supply")
public class GgwSupplyController {

	// @InitBinder
	// public void allowEmptyDateBinding(WebDataBinder binder) {
	// binder.registerCustomEditor(Date.class,
	// new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	// }

	@Autowired
	private GgwSupplyService service;

	/**
	 * 供应列表页 @author： 徐国辉 2016年2月3日 下午4:00:19 @方法名：
	 * querySupplysByKeywordPaged @方法描述：
	 * 
	 * @param:
	 * @throws UnsupportedEncodingException
	 * @返回值：String 供应列表页的逻辑视图
	 *
	 */
	@RequestMapping(value = "/list")
	public String querySupplysByKeywordPaged(Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		// 收集页面参数
		String keyWord = request.getParameter("keyWord");
		Integer currentNum = 1;
		String currentNumStr = request.getParameter("currentNum");
		if (!StringUtils.isEmpty(currentNumStr)) {
			currentNum = Integer.parseInt(currentNumStr);
		}

		Page<GgwSupply> supplyPage = service.querySupplysByKeywordPaged(keyWord, currentNum);

		model.addAttribute("supplyPage", supplyPage);
		// 参数传回
		model.addAttribute("keyWord", keyWord);

		return "/frontpages/supply/list";
	}

	/**
	 * 列表页加载更多 @author： 徐国辉 2016年2月3日 下午4:01:30 @方法名：
	 * querySupplysByKeywordPagedJson @方法描述：
	 * 
	 * @param:
	 * @throws UnsupportedEncodingException
	 * @返回值：Page<GgwSupply> 返回加载JSON
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/listMore")
	public Page<GgwSupply> querySupplysByKeywordPagedJson(Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		// 收集页面参数
		String keyWord = request.getParameter("keyWord");
		if(StringUtils.isEmpty(keyWord)){
			keyWord = null;
		}
		Integer currentNum = 1;
		String currentNumStr = request.getParameter("currentNum");
		if (!StringUtils.isEmpty(currentNumStr)) {
			currentNum = Integer.parseInt(currentNumStr);
		}
		Page<GgwSupply> supplyPage = service.querySupplysByKeywordPaged(keyWord, currentNum);

		model.addAttribute("supplyPage", supplyPage);
		// 参数传回
		model.addAttribute("keyWord", keyWord);

		return supplyPage;
	}

	/**
	 * 
	 * @author： 徐国辉 2016年2月3日 上午9:44:46 @方法名： toAdd @方法描述：
	 * 
	 * @param:
	 * @返回值：String
	 *
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd(GgwSupply supply) {
		return "/frontpages/supply/add";
	}

	/**
	 * 
	 * @author： 徐国辉 2016年2月3日 上午9:44:40 @方法名： add @方法描述：
	 * 
	 * @param:
	 * @throws UnsupportedEncodingException
	 * @返回值：String
	 *
	 */
	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(Model model, HttpServletRequest request, @RequestParam String supplyDetail,
			@RequestParam String linkPerson, @RequestParam String phoneNum, @RequestParam String address,
			@RequestParam Integer checkStatus) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		GgwSupply supply = new GgwSupply();
		if (!StringUtils.isEmpty(supplyDetail)) {
			supply.setSupplyDetail(new String(supplyDetail.getBytes("ISO-8859-1"), "UTF-8"));
		}
		if (!StringUtils.isEmpty(linkPerson)) {
			supply.setLinkPerson(new String(linkPerson.getBytes("ISO-8859-1"), "UTF-8"));
		}
		if (!StringUtils.isEmpty(address)) {
			supply.setAddress(new String(address.getBytes("ISO-8859-1"), "UTF-8"));
		}
		supply.setPhoneNum(phoneNum);
		supply.setCheckStatus(checkStatus);
		int flag = service.addGgwSupply(supply);// 添加成功为1
		model.addAttribute("keyWod", null);
		return flag + "";
	}
}
