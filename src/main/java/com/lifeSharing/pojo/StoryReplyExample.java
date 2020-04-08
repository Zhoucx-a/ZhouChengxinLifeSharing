package com.lifeSharing.pojo;

import java.util.ArrayList;
import java.util.List;

public class StoryReplyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoryReplyExample() {
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

        public Criteria andReplyCodeIsNull() {
            addCriterion("reply_code is null");
            return (Criteria) this;
        }

        public Criteria andReplyCodeIsNotNull() {
            addCriterion("reply_code is not null");
            return (Criteria) this;
        }

        public Criteria andReplyCodeEqualTo(String value) {
            addCriterion("reply_code =", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeNotEqualTo(String value) {
            addCriterion("reply_code <>", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeGreaterThan(String value) {
            addCriterion("reply_code >", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("reply_code >=", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeLessThan(String value) {
            addCriterion("reply_code <", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeLessThanOrEqualTo(String value) {
            addCriterion("reply_code <=", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeLike(String value) {
            addCriterion("reply_code like", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeNotLike(String value) {
            addCriterion("reply_code not like", value, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeIn(List<String> values) {
            addCriterion("reply_code in", values, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeNotIn(List<String> values) {
            addCriterion("reply_code not in", values, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeBetween(String value1, String value2) {
            addCriterion("reply_code between", value1, value2, "replyCode");
            return (Criteria) this;
        }

        public Criteria andReplyCodeNotBetween(String value1, String value2) {
            addCriterion("reply_code not between", value1, value2, "replyCode");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeIsNull() {
            addCriterion("comments_code is null");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeIsNotNull() {
            addCriterion("comments_code is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeEqualTo(String value) {
            addCriterion("comments_code =", value, "commentsCode");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeNotEqualTo(String value) {
            addCriterion("comments_code <>", value, "commentsCode");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeGreaterThan(String value) {
            addCriterion("comments_code >", value, "commentsCode");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("comments_code >=", value, "commentsCode");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeLessThan(String value) {
            addCriterion("comments_code <", value, "commentsCode");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeLessThanOrEqualTo(String value) {
            addCriterion("comments_code <=", value, "commentsCode");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeLike(String value) {
            addCriterion("comments_code like", value, "commentsCode");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeNotLike(String value) {
            addCriterion("comments_code not like", value, "commentsCode");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeIn(List<String> values) {
            addCriterion("comments_code in", values, "commentsCode");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeNotIn(List<String> values) {
            addCriterion("comments_code not in", values, "commentsCode");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeBetween(String value1, String value2) {
            addCriterion("comments_code between", value1, value2, "commentsCode");
            return (Criteria) this;
        }

        public Criteria andCommentsCodeNotBetween(String value1, String value2) {
            addCriterion("comments_code not between", value1, value2, "commentsCode");
            return (Criteria) this;
        }

        public Criteria andReplyToIdIsNull() {
            addCriterion("reply_to_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyToIdIsNotNull() {
            addCriterion("reply_to_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyToIdEqualTo(String value) {
            addCriterion("reply_to_id =", value, "replyToId");
            return (Criteria) this;
        }

        public Criteria andReplyToIdNotEqualTo(String value) {
            addCriterion("reply_to_id <>", value, "replyToId");
            return (Criteria) this;
        }

        public Criteria andReplyToIdGreaterThan(String value) {
            addCriterion("reply_to_id >", value, "replyToId");
            return (Criteria) this;
        }

        public Criteria andReplyToIdGreaterThanOrEqualTo(String value) {
            addCriterion("reply_to_id >=", value, "replyToId");
            return (Criteria) this;
        }

        public Criteria andReplyToIdLessThan(String value) {
            addCriterion("reply_to_id <", value, "replyToId");
            return (Criteria) this;
        }

        public Criteria andReplyToIdLessThanOrEqualTo(String value) {
            addCriterion("reply_to_id <=", value, "replyToId");
            return (Criteria) this;
        }

        public Criteria andReplyToIdLike(String value) {
            addCriterion("reply_to_id like", value, "replyToId");
            return (Criteria) this;
        }

        public Criteria andReplyToIdNotLike(String value) {
            addCriterion("reply_to_id not like", value, "replyToId");
            return (Criteria) this;
        }

        public Criteria andReplyToIdIn(List<String> values) {
            addCriterion("reply_to_id in", values, "replyToId");
            return (Criteria) this;
        }

        public Criteria andReplyToIdNotIn(List<String> values) {
            addCriterion("reply_to_id not in", values, "replyToId");
            return (Criteria) this;
        }

        public Criteria andReplyToIdBetween(String value1, String value2) {
            addCriterion("reply_to_id between", value1, value2, "replyToId");
            return (Criteria) this;
        }

        public Criteria andReplyToIdNotBetween(String value1, String value2) {
            addCriterion("reply_to_id not between", value1, value2, "replyToId");
            return (Criteria) this;
        }

        public Criteria andReplierNoIsNull() {
            addCriterion("replier_no is null");
            return (Criteria) this;
        }

        public Criteria andReplierNoIsNotNull() {
            addCriterion("replier_no is not null");
            return (Criteria) this;
        }

        public Criteria andReplierNoEqualTo(String value) {
            addCriterion("replier_no =", value, "replierNo");
            return (Criteria) this;
        }

        public Criteria andReplierNoNotEqualTo(String value) {
            addCriterion("replier_no <>", value, "replierNo");
            return (Criteria) this;
        }

        public Criteria andReplierNoGreaterThan(String value) {
            addCriterion("replier_no >", value, "replierNo");
            return (Criteria) this;
        }

        public Criteria andReplierNoGreaterThanOrEqualTo(String value) {
            addCriterion("replier_no >=", value, "replierNo");
            return (Criteria) this;
        }

        public Criteria andReplierNoLessThan(String value) {
            addCriterion("replier_no <", value, "replierNo");
            return (Criteria) this;
        }

        public Criteria andReplierNoLessThanOrEqualTo(String value) {
            addCriterion("replier_no <=", value, "replierNo");
            return (Criteria) this;
        }

        public Criteria andReplierNoLike(String value) {
            addCriterion("replier_no like", value, "replierNo");
            return (Criteria) this;
        }

        public Criteria andReplierNoNotLike(String value) {
            addCriterion("replier_no not like", value, "replierNo");
            return (Criteria) this;
        }

        public Criteria andReplierNoIn(List<String> values) {
            addCriterion("replier_no in", values, "replierNo");
            return (Criteria) this;
        }

        public Criteria andReplierNoNotIn(List<String> values) {
            addCriterion("replier_no not in", values, "replierNo");
            return (Criteria) this;
        }

        public Criteria andReplierNoBetween(String value1, String value2) {
            addCriterion("replier_no between", value1, value2, "replierNo");
            return (Criteria) this;
        }

        public Criteria andReplierNoNotBetween(String value1, String value2) {
            addCriterion("replier_no not between", value1, value2, "replierNo");
            return (Criteria) this;
        }

        public Criteria andReplierNameIsNull() {
            addCriterion("replier_name is null");
            return (Criteria) this;
        }

        public Criteria andReplierNameIsNotNull() {
            addCriterion("replier_name is not null");
            return (Criteria) this;
        }

        public Criteria andReplierNameEqualTo(String value) {
            addCriterion("replier_name =", value, "replierName");
            return (Criteria) this;
        }

        public Criteria andReplierNameNotEqualTo(String value) {
            addCriterion("replier_name <>", value, "replierName");
            return (Criteria) this;
        }

        public Criteria andReplierNameGreaterThan(String value) {
            addCriterion("replier_name >", value, "replierName");
            return (Criteria) this;
        }

        public Criteria andReplierNameGreaterThanOrEqualTo(String value) {
            addCriterion("replier_name >=", value, "replierName");
            return (Criteria) this;
        }

        public Criteria andReplierNameLessThan(String value) {
            addCriterion("replier_name <", value, "replierName");
            return (Criteria) this;
        }

        public Criteria andReplierNameLessThanOrEqualTo(String value) {
            addCriterion("replier_name <=", value, "replierName");
            return (Criteria) this;
        }

        public Criteria andReplierNameLike(String value) {
            addCriterion("replier_name like", value, "replierName");
            return (Criteria) this;
        }

        public Criteria andReplierNameNotLike(String value) {
            addCriterion("replier_name not like", value, "replierName");
            return (Criteria) this;
        }

        public Criteria andReplierNameIn(List<String> values) {
            addCriterion("replier_name in", values, "replierName");
            return (Criteria) this;
        }

        public Criteria andReplierNameNotIn(List<String> values) {
            addCriterion("replier_name not in", values, "replierName");
            return (Criteria) this;
        }

        public Criteria andReplierNameBetween(String value1, String value2) {
            addCriterion("replier_name between", value1, value2, "replierName");
            return (Criteria) this;
        }

        public Criteria andReplierNameNotBetween(String value1, String value2) {
            addCriterion("replier_name not between", value1, value2, "replierName");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIsNull() {
            addCriterion("reply_type is null");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIsNotNull() {
            addCriterion("reply_type is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTypeEqualTo(String value) {
            addCriterion("reply_type =", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotEqualTo(String value) {
            addCriterion("reply_type <>", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeGreaterThan(String value) {
            addCriterion("reply_type >", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("reply_type >=", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeLessThan(String value) {
            addCriterion("reply_type <", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeLessThanOrEqualTo(String value) {
            addCriterion("reply_type <=", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeLike(String value) {
            addCriterion("reply_type like", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotLike(String value) {
            addCriterion("reply_type not like", value, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeIn(List<String> values) {
            addCriterion("reply_type in", values, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotIn(List<String> values) {
            addCriterion("reply_type not in", values, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeBetween(String value1, String value2) {
            addCriterion("reply_type between", value1, value2, "replyType");
            return (Criteria) this;
        }

        public Criteria andReplyTypeNotBetween(String value1, String value2) {
            addCriterion("reply_type not between", value1, value2, "replyType");
            return (Criteria) this;
        }

        public Criteria andToIdIsNull() {
            addCriterion("to_id is null");
            return (Criteria) this;
        }

        public Criteria andToIdIsNotNull() {
            addCriterion("to_id is not null");
            return (Criteria) this;
        }

        public Criteria andToIdEqualTo(String value) {
            addCriterion("to_id =", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdNotEqualTo(String value) {
            addCriterion("to_id <>", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdGreaterThan(String value) {
            addCriterion("to_id >", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdGreaterThanOrEqualTo(String value) {
            addCriterion("to_id >=", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdLessThan(String value) {
            addCriterion("to_id <", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdLessThanOrEqualTo(String value) {
            addCriterion("to_id <=", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdLike(String value) {
            addCriterion("to_id like", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdNotLike(String value) {
            addCriterion("to_id not like", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdIn(List<String> values) {
            addCriterion("to_id in", values, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdNotIn(List<String> values) {
            addCriterion("to_id not in", values, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdBetween(String value1, String value2) {
            addCriterion("to_id between", value1, value2, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdNotBetween(String value1, String value2) {
            addCriterion("to_id not between", value1, value2, "toId");
            return (Criteria) this;
        }

        public Criteria andToNameIsNull() {
            addCriterion("to_name is null");
            return (Criteria) this;
        }

        public Criteria andToNameIsNotNull() {
            addCriterion("to_name is not null");
            return (Criteria) this;
        }

        public Criteria andToNameEqualTo(String value) {
            addCriterion("to_name =", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameNotEqualTo(String value) {
            addCriterion("to_name <>", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameGreaterThan(String value) {
            addCriterion("to_name >", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameGreaterThanOrEqualTo(String value) {
            addCriterion("to_name >=", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameLessThan(String value) {
            addCriterion("to_name <", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameLessThanOrEqualTo(String value) {
            addCriterion("to_name <=", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameLike(String value) {
            addCriterion("to_name like", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameNotLike(String value) {
            addCriterion("to_name not like", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameIn(List<String> values) {
            addCriterion("to_name in", values, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameNotIn(List<String> values) {
            addCriterion("to_name not in", values, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameBetween(String value1, String value2) {
            addCriterion("to_name between", value1, value2, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameNotBetween(String value1, String value2) {
            addCriterion("to_name not between", value1, value2, "toName");
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