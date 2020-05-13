package com.lifeSharing.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoryInformationHisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoryInformationHisExample() {
        oredCriteria = new ArrayList<Criteria>();
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

        public Criteria andHisNoIsNull() {
            addCriterion("his_no is null");
            return (Criteria) this;
        }

        public Criteria andHisNoIsNotNull() {
            addCriterion("his_no is not null");
            return (Criteria) this;
        }

        public Criteria andHisNoEqualTo(String value) {
            addCriterion("his_no =", value, "hisNo");
            return (Criteria) this;
        }

        public Criteria andHisNoNotEqualTo(String value) {
            addCriterion("his_no <>", value, "hisNo");
            return (Criteria) this;
        }

        public Criteria andHisNoGreaterThan(String value) {
            addCriterion("his_no >", value, "hisNo");
            return (Criteria) this;
        }

        public Criteria andHisNoGreaterThanOrEqualTo(String value) {
            addCriterion("his_no >=", value, "hisNo");
            return (Criteria) this;
        }

        public Criteria andHisNoLessThan(String value) {
            addCriterion("his_no <", value, "hisNo");
            return (Criteria) this;
        }

        public Criteria andHisNoLessThanOrEqualTo(String value) {
            addCriterion("his_no <=", value, "hisNo");
            return (Criteria) this;
        }

        public Criteria andHisNoLike(String value) {
            addCriterion("his_no like", value, "hisNo");
            return (Criteria) this;
        }

        public Criteria andHisNoNotLike(String value) {
            addCriterion("his_no not like", value, "hisNo");
            return (Criteria) this;
        }

        public Criteria andHisNoIn(List<String> values) {
            addCriterion("his_no in", values, "hisNo");
            return (Criteria) this;
        }

        public Criteria andHisNoNotIn(List<String> values) {
            addCriterion("his_no not in", values, "hisNo");
            return (Criteria) this;
        }

        public Criteria andHisNoBetween(String value1, String value2) {
            addCriterion("his_no between", value1, value2, "hisNo");
            return (Criteria) this;
        }

        public Criteria andHisNoNotBetween(String value1, String value2) {
            addCriterion("his_no not between", value1, value2, "hisNo");
            return (Criteria) this;
        }

        public Criteria andStoryCodeIsNull() {
            addCriterion("story_code is null");
            return (Criteria) this;
        }

        public Criteria andStoryCodeIsNotNull() {
            addCriterion("story_code is not null");
            return (Criteria) this;
        }

        public Criteria andStoryCodeEqualTo(String value) {
            addCriterion("story_code =", value, "storyCode");
            return (Criteria) this;
        }

        public Criteria andStoryCodeNotEqualTo(String value) {
            addCriterion("story_code <>", value, "storyCode");
            return (Criteria) this;
        }

        public Criteria andStoryCodeGreaterThan(String value) {
            addCriterion("story_code >", value, "storyCode");
            return (Criteria) this;
        }

        public Criteria andStoryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("story_code >=", value, "storyCode");
            return (Criteria) this;
        }

        public Criteria andStoryCodeLessThan(String value) {
            addCriterion("story_code <", value, "storyCode");
            return (Criteria) this;
        }

        public Criteria andStoryCodeLessThanOrEqualTo(String value) {
            addCriterion("story_code <=", value, "storyCode");
            return (Criteria) this;
        }

        public Criteria andStoryCodeLike(String value) {
            addCriterion("story_code like", value, "storyCode");
            return (Criteria) this;
        }

        public Criteria andStoryCodeNotLike(String value) {
            addCriterion("story_code not like", value, "storyCode");
            return (Criteria) this;
        }

        public Criteria andStoryCodeIn(List<String> values) {
            addCriterion("story_code in", values, "storyCode");
            return (Criteria) this;
        }

        public Criteria andStoryCodeNotIn(List<String> values) {
            addCriterion("story_code not in", values, "storyCode");
            return (Criteria) this;
        }

        public Criteria andStoryCodeBetween(String value1, String value2) {
            addCriterion("story_code between", value1, value2, "storyCode");
            return (Criteria) this;
        }

        public Criteria andStoryCodeNotBetween(String value1, String value2) {
            addCriterion("story_code not between", value1, value2, "storyCode");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNull() {
            addCriterion("user_no is null");
            return (Criteria) this;
        }

        public Criteria andUserNoIsNotNull() {
            addCriterion("user_no is not null");
            return (Criteria) this;
        }

        public Criteria andUserNoEqualTo(String value) {
            addCriterion("user_no =", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotEqualTo(String value) {
            addCriterion("user_no <>", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThan(String value) {
            addCriterion("user_no >", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoGreaterThanOrEqualTo(String value) {
            addCriterion("user_no >=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThan(String value) {
            addCriterion("user_no <", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLessThanOrEqualTo(String value) {
            addCriterion("user_no <=", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoLike(String value) {
            addCriterion("user_no like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotLike(String value) {
            addCriterion("user_no not like", value, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoIn(List<String> values) {
            addCriterion("user_no in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotIn(List<String> values) {
            addCriterion("user_no not in", values, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoBetween(String value1, String value2) {
            addCriterion("user_no between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andUserNoNotBetween(String value1, String value2) {
            addCriterion("user_no not between", value1, value2, "userNo");
            return (Criteria) this;
        }

        public Criteria andStoryContextIsNull() {
            addCriterion("story_context is null");
            return (Criteria) this;
        }

        public Criteria andStoryContextIsNotNull() {
            addCriterion("story_context is not null");
            return (Criteria) this;
        }

        public Criteria andStoryContextEqualTo(String value) {
            addCriterion("story_context =", value, "storyContext");
            return (Criteria) this;
        }

        public Criteria andStoryContextNotEqualTo(String value) {
            addCriterion("story_context <>", value, "storyContext");
            return (Criteria) this;
        }

        public Criteria andStoryContextGreaterThan(String value) {
            addCriterion("story_context >", value, "storyContext");
            return (Criteria) this;
        }

        public Criteria andStoryContextGreaterThanOrEqualTo(String value) {
            addCriterion("story_context >=", value, "storyContext");
            return (Criteria) this;
        }

        public Criteria andStoryContextLessThan(String value) {
            addCriterion("story_context <", value, "storyContext");
            return (Criteria) this;
        }

        public Criteria andStoryContextLessThanOrEqualTo(String value) {
            addCriterion("story_context <=", value, "storyContext");
            return (Criteria) this;
        }

        public Criteria andStoryContextLike(String value) {
            addCriterion("story_context like", value, "storyContext");
            return (Criteria) this;
        }

        public Criteria andStoryContextNotLike(String value) {
            addCriterion("story_context not like", value, "storyContext");
            return (Criteria) this;
        }

        public Criteria andStoryContextIn(List<String> values) {
            addCriterion("story_context in", values, "storyContext");
            return (Criteria) this;
        }

        public Criteria andStoryContextNotIn(List<String> values) {
            addCriterion("story_context not in", values, "storyContext");
            return (Criteria) this;
        }

        public Criteria andStoryContextBetween(String value1, String value2) {
            addCriterion("story_context between", value1, value2, "storyContext");
            return (Criteria) this;
        }

        public Criteria andStoryContextNotBetween(String value1, String value2) {
            addCriterion("story_context not between", value1, value2, "storyContext");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("publish_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("publish_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("publish_time =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("publish_time <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("publish_time >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_time >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("publish_time <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("publish_time <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("publish_time in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("publish_time not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("publish_time between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("publish_time not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNull() {
            addCriterion("is_check is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNotNull() {
            addCriterion("is_check is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckEqualTo(Integer value) {
            addCriterion("is_check =", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotEqualTo(Integer value) {
            addCriterion("is_check <>", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThan(Integer value) {
            addCriterion("is_check >", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_check >=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThan(Integer value) {
            addCriterion("is_check <", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThanOrEqualTo(Integer value) {
            addCriterion("is_check <=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckIn(List<Integer> values) {
            addCriterion("is_check in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotIn(List<Integer> values) {
            addCriterion("is_check not in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckBetween(Integer value1, Integer value2) {
            addCriterion("is_check between", value1, value2, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotBetween(Integer value1, Integer value2) {
            addCriterion("is_check not between", value1, value2, "isCheck");
            return (Criteria) this;
        }

        public Criteria andOperNoIsNull() {
            addCriterion("oper_no is null");
            return (Criteria) this;
        }

        public Criteria andOperNoIsNotNull() {
            addCriterion("oper_no is not null");
            return (Criteria) this;
        }

        public Criteria andOperNoEqualTo(String value) {
            addCriterion("oper_no =", value, "operNo");
            return (Criteria) this;
        }

        public Criteria andOperNoNotEqualTo(String value) {
            addCriterion("oper_no <>", value, "operNo");
            return (Criteria) this;
        }

        public Criteria andOperNoGreaterThan(String value) {
            addCriterion("oper_no >", value, "operNo");
            return (Criteria) this;
        }

        public Criteria andOperNoGreaterThanOrEqualTo(String value) {
            addCriterion("oper_no >=", value, "operNo");
            return (Criteria) this;
        }

        public Criteria andOperNoLessThan(String value) {
            addCriterion("oper_no <", value, "operNo");
            return (Criteria) this;
        }

        public Criteria andOperNoLessThanOrEqualTo(String value) {
            addCriterion("oper_no <=", value, "operNo");
            return (Criteria) this;
        }

        public Criteria andOperNoLike(String value) {
            addCriterion("oper_no like", value, "operNo");
            return (Criteria) this;
        }

        public Criteria andOperNoNotLike(String value) {
            addCriterion("oper_no not like", value, "operNo");
            return (Criteria) this;
        }

        public Criteria andOperNoIn(List<String> values) {
            addCriterion("oper_no in", values, "operNo");
            return (Criteria) this;
        }

        public Criteria andOperNoNotIn(List<String> values) {
            addCriterion("oper_no not in", values, "operNo");
            return (Criteria) this;
        }

        public Criteria andOperNoBetween(String value1, String value2) {
            addCriterion("oper_no between", value1, value2, "operNo");
            return (Criteria) this;
        }

        public Criteria andOperNoNotBetween(String value1, String value2) {
            addCriterion("oper_no not between", value1, value2, "operNo");
            return (Criteria) this;
        }

        public Criteria andOperNameIsNull() {
            addCriterion("oper_name is null");
            return (Criteria) this;
        }

        public Criteria andOperNameIsNotNull() {
            addCriterion("oper_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperNameEqualTo(String value) {
            addCriterion("oper_name =", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameNotEqualTo(String value) {
            addCriterion("oper_name <>", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameGreaterThan(String value) {
            addCriterion("oper_name >", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameGreaterThanOrEqualTo(String value) {
            addCriterion("oper_name >=", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameLessThan(String value) {
            addCriterion("oper_name <", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameLessThanOrEqualTo(String value) {
            addCriterion("oper_name <=", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameLike(String value) {
            addCriterion("oper_name like", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameNotLike(String value) {
            addCriterion("oper_name not like", value, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameIn(List<String> values) {
            addCriterion("oper_name in", values, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameNotIn(List<String> values) {
            addCriterion("oper_name not in", values, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameBetween(String value1, String value2) {
            addCriterion("oper_name between", value1, value2, "operName");
            return (Criteria) this;
        }

        public Criteria andOperNameNotBetween(String value1, String value2) {
            addCriterion("oper_name not between", value1, value2, "operName");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNull() {
            addCriterion("oper_type is null");
            return (Criteria) this;
        }

        public Criteria andOperTypeIsNotNull() {
            addCriterion("oper_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperTypeEqualTo(String value) {
            addCriterion("oper_type =", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotEqualTo(String value) {
            addCriterion("oper_type <>", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThan(String value) {
            addCriterion("oper_type >", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeGreaterThanOrEqualTo(String value) {
            addCriterion("oper_type >=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThan(String value) {
            addCriterion("oper_type <", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLessThanOrEqualTo(String value) {
            addCriterion("oper_type <=", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeLike(String value) {
            addCriterion("oper_type like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotLike(String value) {
            addCriterion("oper_type not like", value, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeIn(List<String> values) {
            addCriterion("oper_type in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotIn(List<String> values) {
            addCriterion("oper_type not in", values, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeBetween(String value1, String value2) {
            addCriterion("oper_type between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTypeNotBetween(String value1, String value2) {
            addCriterion("oper_type not between", value1, value2, "operType");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNull() {
            addCriterion("oper_time is null");
            return (Criteria) this;
        }

        public Criteria andOperTimeIsNotNull() {
            addCriterion("oper_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperTimeEqualTo(Date value) {
            addCriterion("oper_time =", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotEqualTo(Date value) {
            addCriterion("oper_time <>", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThan(Date value) {
            addCriterion("oper_time >", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("oper_time >=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThan(Date value) {
            addCriterion("oper_time <", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeLessThanOrEqualTo(Date value) {
            addCriterion("oper_time <=", value, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeIn(List<Date> values) {
            addCriterion("oper_time in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotIn(List<Date> values) {
            addCriterion("oper_time not in", values, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeBetween(Date value1, Date value2) {
            addCriterion("oper_time between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andOperTimeNotBetween(Date value1, Date value2) {
            addCriterion("oper_time not between", value1, value2, "operTime");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIsNull() {
            addCriterion("photo_url is null");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIsNotNull() {
            addCriterion("photo_url is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlEqualTo(String value) {
            addCriterion("photo_url =", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotEqualTo(String value) {
            addCriterion("photo_url <>", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThan(String value) {
            addCriterion("photo_url >", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("photo_url >=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThan(String value) {
            addCriterion("photo_url <", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLessThanOrEqualTo(String value) {
            addCriterion("photo_url <=", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlLike(String value) {
            addCriterion("photo_url like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotLike(String value) {
            addCriterion("photo_url not like", value, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlIn(List<String> values) {
            addCriterion("photo_url in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotIn(List<String> values) {
            addCriterion("photo_url not in", values, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlBetween(String value1, String value2) {
            addCriterion("photo_url between", value1, value2, "photoUrl");
            return (Criteria) this;
        }

        public Criteria andPhotoUrlNotBetween(String value1, String value2) {
            addCriterion("photo_url not between", value1, value2, "photoUrl");
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