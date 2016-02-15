package com.wangku.entity;

import java.util.Date;

public class GgwSupply {
    private Integer id;

    private String supplyDetail;

    private String linkPerson;

    private String phoneNum;

    private String wxUser;

    private String address;

    private Integer checkStatus;

    private Date createTime;
    
    private String crtTime;

    public String getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(String crtTime) {
		this.crtTime = crtTime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSupplyDetail() {
        return supplyDetail;
    }

    public void setSupplyDetail(String supplyDetail) {
        this.supplyDetail = supplyDetail == null ? null : supplyDetail.trim();
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
        this.phoneNum = phoneNum;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "GgwSupply [supplyDetail=" + supplyDetail + ", linkPerson=" + linkPerson + ", phoneNum=" + phoneNum
				+ ", address=" + address + ", checkStatus=" + checkStatus + "]";
	}
    
    
}