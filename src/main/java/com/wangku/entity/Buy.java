package com.wangku.entity;

/**
 * Title:Buy
 * Description: 采购实体类
 * Company: 中国网库
 * @author 庞大涛
 * @date 2016-2-2 下午4:34:41
 */
public class Buy {
    private Integer id;// 主键ID

    private String buyDetail;// 采购详细

    private String linkPerson;// 联系人

    private String phoneNum;// 手机号码

    private String wxUser;// 创建者微信

    private String address;// 商家地址

    private Integer checkStatus;// 审核状态  0：未审核  1：已审核 2：未通过 4：删除

    private String createTime;// 创建时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuyDetail() {
        return buyDetail;
    }

    public void setBuyDetail(String buyDetail) {
        this.buyDetail = buyDetail == null ? null : buyDetail.trim();
    }

    public String getLinkPerson() {
        return linkPerson;
    }

    public void setLinkPerson(String linkPerson) {
        this.linkPerson = linkPerson == null ? null : linkPerson.trim();
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getWxUser() {
        return wxUser;
    }

    public void setWxUser(String wxUser) {
        this.wxUser = wxUser == null ? null : wxUser.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}