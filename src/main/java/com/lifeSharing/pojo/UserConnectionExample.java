package com.lifeSharing.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserConnectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserConnectionExample() {
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

        public Criteria andFocusNoIsNull() {
            addCriterion("focus_no is null");
            return (Criteria) this;
        }

        public Criteria andFocusNoIsNotNull() {
            addCriterion("focus_no is not null");
            return (Criteria) this;
        }

        public Criteria andFocusNoEqualTo(String value) {
            addCriterion("focus_no =", value, "focusNo");
            return (Criteria) this;
        }

        public Criteria andFocusNoNotEqualTo(String value) {
            addCriterion("focus_no <>", value, "focusNo");
            return (Criteria) this;
        }

        public Criteria andFocusNoGreaterThan(String value) {
            addCriterion("focus_no >", value, "focusNo");
            return (Criteria) this;
        }

        public Criteria andFocusNoGreaterThanOrEqualTo(String value) {
            addCriterion("focus_no >=", value, "focusNo");
            return (Criteria) this;
        }

        public Criteria andFocusNoLessThan(String value) {
            addCriterion("focus_no <", value, "focusNo");
            return (Criteria) this;
        }

        public Criteria andFocusNoLessThanOrEqualTo(String value) {
            addCriterion("focus_no <=", value, "focusNo");
            return (Criteria) this;
        }

        public Criteria andFocusNoLike(String value) {
            addCriterion("focus_no like", value, "focusNo");
            return (Criteria) this;
        }

        public Criteria andFocusNoNotLike(String value) {
            addCriterion("focus_no not like", value, "focusNo");
            return (Criteria) this;
        }

        public Criteria andFocusNoIn(List<String> values) {
            addCriterion("focus_no in", values, "focusNo");
            return (Criteria) this;
        }

        public Criteria andFocusNoNotIn(List<String> values) {
            addCriterion("focus_no not in", values, "focusNo");
            return (Criteria) this;
        }

        public Criteria andFocusNoBetween(String value1, String value2) {
            addCriterion("focus_no between", value1, value2, "focusNo");
            return (Criteria) this;
        }

        public Criteria andFocusNoNotBetween(String value1, String value2) {
            addCriterion("focus_no not between", value1, value2, "focusNo");
            return (Criteria) this;
        }

        public Criteria andFocusNameIsNull() {
            addCriterion("focus_name is null");
            return (Criteria) this;
        }

        public Criteria andFocusNameIsNotNull() {
            addCriterion("focus_name is not null");
            return (Criteria) this;
        }

        public Criteria andFocusNameEqualTo(String value) {
            addCriterion("focus_name =", value, "focusName");
            return (Criteria) this;
        }

        public Criteria andFocusNameNotEqualTo(String value) {
            addCriterion("focus_name <>", value, "focusName");
            return (Criteria) this;
        }

        public Criteria andFocusNameGreaterThan(String value) {
            addCriterion("focus_name >", value, "focusName");
            return (Criteria) this;
        }

        public Criteria andFocusNameGreaterThanOrEqualTo(String value) {
            addCriterion("focus_name >=", value, "focusName");
            return (Criteria) this;
        }

        public Criteria andFocusNameLessThan(String value) {
            addCriterion("focus_name <", value, "focusName");
            return (Criteria) this;
        }

        public Criteria andFocusNameLessThanOrEqualTo(String value) {
            addCriterion("focus_name <=", value, "focusName");
            return (Criteria) this;
        }

        public Criteria andFocusNameLike(String value) {
            addCriterion("focus_name like", value, "focusName");
            return (Criteria) this;
        }

        public Criteria andFocusNameNotLike(String value) {
            addCriterion("focus_name not like", value, "focusName");
            return (Criteria) this;
        }

        public Criteria andFocusNameIn(List<String> values) {
            addCriterion("focus_name in", values, "focusName");
            return (Criteria) this;
        }

        public Criteria andFocusNameNotIn(List<String> values) {
            addCriterion("focus_name not in", values, "focusName");
            return (Criteria) this;
        }

        public Criteria andFocusNameBetween(String value1, String value2) {
            addCriterion("focus_name between", value1, value2, "focusName");
            return (Criteria) this;
        }

        public Criteria andFocusNameNotBetween(String value1, String value2) {
            addCriterion("focus_name not between", value1, value2, "focusName");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusIsNull() {
            addCriterion("is_special_focus is null");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusIsNotNull() {
            addCriterion("is_special_focus is not null");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusEqualTo(String value) {
            addCriterion("is_special_focus =", value, "isSpecialFocus");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusNotEqualTo(String value) {
            addCriterion("is_special_focus <>", value, "isSpecialFocus");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusGreaterThan(String value) {
            addCriterion("is_special_focus >", value, "isSpecialFocus");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusGreaterThanOrEqualTo(String value) {
            addCriterion("is_special_focus >=", value, "isSpecialFocus");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusLessThan(String value) {
            addCriterion("is_special_focus <", value, "isSpecialFocus");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusLessThanOrEqualTo(String value) {
            addCriterion("is_special_focus <=", value, "isSpecialFocus");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusLike(String value) {
            addCriterion("is_special_focus like", value, "isSpecialFocus");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusNotLike(String value) {
            addCriterion("is_special_focus not like", value, "isSpecialFocus");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusIn(List<String> values) {
            addCriterion("is_special_focus in", values, "isSpecialFocus");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusNotIn(List<String> values) {
            addCriterion("is_special_focus not in", values, "isSpecialFocus");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusBetween(String value1, String value2) {
            addCriterion("is_special_focus between", value1, value2, "isSpecialFocus");
            return (Criteria) this;
        }

        public Criteria andIsSpecialFocusNotBetween(String value1, String value2) {
            addCriterion("is_special_focus not between", value1, value2, "isSpecialFocus");
            return (Criteria) this;
        }

        public Criteria andFocusTimeIsNull() {
            addCriterion("focus_time is null");
            return (Criteria) this;
        }

        public Criteria andFocusTimeIsNotNull() {
            addCriterion("focus_time is not null");
            return (Criteria) this;
        }

        public Criteria andFocusTimeEqualTo(Date value) {
            addCriterion("focus_time =", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeNotEqualTo(Date value) {
            addCriterion("focus_time <>", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeGreaterThan(Date value) {
            addCriterion("focus_time >", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("focus_time >=", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeLessThan(Date value) {
            addCriterion("focus_time <", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeLessThanOrEqualTo(Date value) {
            addCriterion("focus_time <=", value, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeIn(List<Date> values) {
            addCriterion("focus_time in", values, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeNotIn(List<Date> values) {
            addCriterion("focus_time not in", values, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeBetween(Date value1, Date value2) {
            addCriterion("focus_time between", value1, value2, "focusTime");
            return (Criteria) this;
        }

        public Criteria andFocusTimeNotBetween(Date value1, Date value2) {
            addCriterion("focus_time not between", value1, value2, "focusTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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