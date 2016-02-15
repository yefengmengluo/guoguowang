package com.wangku.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Title:BuyExample
 * Description: 采购查询实体类
 * Company: 中国网库
 * @author 庞大涛
 * @date 2016-2-2 下午4:53:52
 */
public class BuyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    
    private int limitClauseStart;// 起始参数

	private int limitClauseCount;// 数量参数
	
	private String buyDetail;// 采购详细

    public BuyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public int getLimitClauseStart() {
		return limitClauseStart;
	}

	public void setLimitClauseStart(int limitClauseStart) {
		this.limitClauseStart = limitClauseStart;
	}

	public int getLimitClauseCount() {
		return limitClauseCount;
	}

	public void setLimitClauseCount(int limitClauseCount) {
		this.limitClauseCount = limitClauseCount;
	}

	public String getBuyDetail() {
		return buyDetail;
	}

	public void setBuyDetail(String buyDetail) {
		this.buyDetail = buyDetail;
	}

	public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBuyDetailIsNull() {
            addCriterion("buy_detail is null");
            return (Criteria) this;
        }

        public Criteria andBuyDetailIsNotNull() {
            addCriterion("buy_detail is not null");
            return (Criteria) this;
        }

        public Criteria andBuyDetailEqualTo(String value) {
            addCriterion("buy_detail =", value, "buyDetail");
            return (Criteria) this;
        }

        public Criteria andBuyDetailNotEqualTo(String value) {
            addCriterion("buy_detail <>", value, "buyDetail");
            return (Criteria) this;
        }

        public Criteria andBuyDetailGreaterThan(String value) {
            addCriterion("buy_detail >", value, "buyDetail");
            return (Criteria) this;
        }

        public Criteria andBuyDetailGreaterThanOrEqualTo(String value) {
            addCriterion("buy_detail >=", value, "buyDetail");
            return (Criteria) this;
        }

        public Criteria andBuyDetailLessThan(String value) {
            addCriterion("buy_detail <", value, "buyDetail");
            return (Criteria) this;
        }

        public Criteria andBuyDetailLessThanOrEqualTo(String value) {
            addCriterion("buy_detail <=", value, "buyDetail");
            return (Criteria) this;
        }

        public Criteria andBuyDetailLike(String value) {
            addCriterion("buy_detail like", value, "buyDetail");
            return (Criteria) this;
        }

        public Criteria andBuyDetailNotLike(String value) {
            addCriterion("buy_detail not like", value, "buyDetail");
            return (Criteria) this;
        }

        public Criteria andBuyDetailIn(List<String> values) {
            addCriterion("buy_detail in", values, "buyDetail");
            return (Criteria) this;
        }

        public Criteria andBuyDetailNotIn(List<String> values) {
            addCriterion("buy_detail not in", values, "buyDetail");
            return (Criteria) this;
        }

        public Criteria andBuyDetailBetween(String value1, String value2) {
            addCriterion("buy_detail between", value1, value2, "buyDetail");
            return (Criteria) this;
        }

        public Criteria andBuyDetailNotBetween(String value1, String value2) {
            addCriterion("buy_detail not between", value1, value2, "buyDetail");
            return (Criteria) this;
        }

        public Criteria andLinkPersonIsNull() {
            addCriterion("link_person is null");
            return (Criteria) this;
        }

        public Criteria andLinkPersonIsNotNull() {
            addCriterion("link_person is not null");
            return (Criteria) this;
        }

        public Criteria andLinkPersonEqualTo(String value) {
            addCriterion("link_person =", value, "linkPerson");
            return (Criteria) this;
        }

        public Criteria andLinkPersonNotEqualTo(String value) {
            addCriterion("link_person <>", value, "linkPerson");
            return (Criteria) this;
        }

        public Criteria andLinkPersonGreaterThan(String value) {
            addCriterion("link_person >", value, "linkPerson");
            return (Criteria) this;
        }

        public Criteria andLinkPersonGreaterThanOrEqualTo(String value) {
            addCriterion("link_person >=", value, "linkPerson");
            return (Criteria) this;
        }

        public Criteria andLinkPersonLessThan(String value) {
            addCriterion("link_person <", value, "linkPerson");
            return (Criteria) this;
        }

        public Criteria andLinkPersonLessThanOrEqualTo(String value) {
            addCriterion("link_person <=", value, "linkPerson");
            return (Criteria) this;
        }

        public Criteria andLinkPersonLike(String value) {
            addCriterion("link_person like", value, "linkPerson");
            return (Criteria) this;
        }

        public Criteria andLinkPersonNotLike(String value) {
            addCriterion("link_person not like", value, "linkPerson");
            return (Criteria) this;
        }

        public Criteria andLinkPersonIn(List<String> values) {
            addCriterion("link_person in", values, "linkPerson");
            return (Criteria) this;
        }

        public Criteria andLinkPersonNotIn(List<String> values) {
            addCriterion("link_person not in", values, "linkPerson");
            return (Criteria) this;
        }

        public Criteria andLinkPersonBetween(String value1, String value2) {
            addCriterion("link_person between", value1, value2, "linkPerson");
            return (Criteria) this;
        }

        public Criteria andLinkPersonNotBetween(String value1, String value2) {
            addCriterion("link_person not between", value1, value2, "linkPerson");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNull() {
            addCriterion("phone_num is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIsNotNull() {
            addCriterion("phone_num is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumEqualTo(String value) {
            addCriterion("phone_num =", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotEqualTo(String value) {
            addCriterion("phone_num <>", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThan(String value) {
            addCriterion("phone_num >", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumGreaterThanOrEqualTo(String value) {
            addCriterion("phone_num >=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThan(String value) {
            addCriterion("phone_num <", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLessThanOrEqualTo(String value) {
            addCriterion("phone_num <=", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumLike(String value) {
            addCriterion("phone_num like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotLike(String value) {
            addCriterion("phone_num not like", value, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumIn(List<String> values) {
            addCriterion("phone_num in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotIn(List<String> values) {
            addCriterion("phone_num not in", values, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumBetween(String value1, String value2) {
            addCriterion("phone_num between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andPhoneNumNotBetween(String value1, String value2) {
            addCriterion("phone_num not between", value1, value2, "phoneNum");
            return (Criteria) this;
        }

        public Criteria andWxUserIsNull() {
            addCriterion("wx_user is null");
            return (Criteria) this;
        }

        public Criteria andWxUserIsNotNull() {
            addCriterion("wx_user is not null");
            return (Criteria) this;
        }

        public Criteria andWxUserEqualTo(String value) {
            addCriterion("wx_user =", value, "wxUser");
            return (Criteria) this;
        }

        public Criteria andWxUserNotEqualTo(String value) {
            addCriterion("wx_user <>", value, "wxUser");
            return (Criteria) this;
        }

        public Criteria andWxUserGreaterThan(String value) {
            addCriterion("wx_user >", value, "wxUser");
            return (Criteria) this;
        }

        public Criteria andWxUserGreaterThanOrEqualTo(String value) {
            addCriterion("wx_user >=", value, "wxUser");
            return (Criteria) this;
        }

        public Criteria andWxUserLessThan(String value) {
            addCriterion("wx_user <", value, "wxUser");
            return (Criteria) this;
        }

        public Criteria andWxUserLessThanOrEqualTo(String value) {
            addCriterion("wx_user <=", value, "wxUser");
            return (Criteria) this;
        }

        public Criteria andWxUserLike(String value) {
            addCriterion("wx_user like", value, "wxUser");
            return (Criteria) this;
        }

        public Criteria andWxUserNotLike(String value) {
            addCriterion("wx_user not like", value, "wxUser");
            return (Criteria) this;
        }

        public Criteria andWxUserIn(List<String> values) {
            addCriterion("wx_user in", values, "wxUser");
            return (Criteria) this;
        }

        public Criteria andWxUserNotIn(List<String> values) {
            addCriterion("wx_user not in", values, "wxUser");
            return (Criteria) this;
        }

        public Criteria andWxUserBetween(String value1, String value2) {
            addCriterion("wx_user between", value1, value2, "wxUser");
            return (Criteria) this;
        }

        public Criteria andWxUserNotBetween(String value1, String value2) {
            addCriterion("wx_user not between", value1, value2, "wxUser");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(Integer value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(Integer value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(Integer value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(Integer value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(Integer value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<Integer> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<Integer> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(Integer value1, Integer value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}