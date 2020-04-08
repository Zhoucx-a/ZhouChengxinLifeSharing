package com.lifeSharing.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserStoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserStoryExample() {
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

        public Criteria andIsLikeIsNull() {
            addCriterion("is_like is null");
            return (Criteria) this;
        }

        public Criteria andIsLikeIsNotNull() {
            addCriterion("is_like is not null");
            return (Criteria) this;
        }

        public Criteria andIsLikeEqualTo(String value) {
            addCriterion("is_like =", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeNotEqualTo(String value) {
            addCriterion("is_like <>", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeGreaterThan(String value) {
            addCriterion("is_like >", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeGreaterThanOrEqualTo(String value) {
            addCriterion("is_like >=", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeLessThan(String value) {
            addCriterion("is_like <", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeLessThanOrEqualTo(String value) {
            addCriterion("is_like <=", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeLike(String value) {
            addCriterion("is_like like", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeNotLike(String value) {
            addCriterion("is_like not like", value, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeIn(List<String> values) {
            addCriterion("is_like in", values, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeNotIn(List<String> values) {
            addCriterion("is_like not in", values, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeBetween(String value1, String value2) {
            addCriterion("is_like between", value1, value2, "isLike");
            return (Criteria) this;
        }

        public Criteria andIsLikeNotBetween(String value1, String value2) {
            addCriterion("is_like not between", value1, value2, "isLike");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNull() {
            addCriterion("like_time is null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIsNotNull() {
            addCriterion("like_time is not null");
            return (Criteria) this;
        }

        public Criteria andLikeTimeEqualTo(Date value) {
            addCriterion("like_time =", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotEqualTo(Date value) {
            addCriterion("like_time <>", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThan(Date value) {
            addCriterion("like_time >", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("like_time >=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThan(Date value) {
            addCriterion("like_time <", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeLessThanOrEqualTo(Date value) {
            addCriterion("like_time <=", value, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeIn(List<Date> values) {
            addCriterion("like_time in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotIn(List<Date> values) {
            addCriterion("like_time not in", values, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeBetween(Date value1, Date value2) {
            addCriterion("like_time between", value1, value2, "likeTime");
            return (Criteria) this;
        }

        public Criteria andLikeTimeNotBetween(Date value1, Date value2) {
            addCriterion("like_time not between", value1, value2, "likeTime");
            return (Criteria) this;
        }

        public Criteria andIsCollectionIsNull() {
            addCriterion("is_collection is null");
            return (Criteria) this;
        }

        public Criteria andIsCollectionIsNotNull() {
            addCriterion("is_collection is not null");
            return (Criteria) this;
        }

        public Criteria andIsCollectionEqualTo(String value) {
            addCriterion("is_collection =", value, "isCollection");
            return (Criteria) this;
        }

        public Criteria andIsCollectionNotEqualTo(String value) {
            addCriterion("is_collection <>", value, "isCollection");
            return (Criteria) this;
        }

        public Criteria andIsCollectionGreaterThan(String value) {
            addCriterion("is_collection >", value, "isCollection");
            return (Criteria) this;
        }

        public Criteria andIsCollectionGreaterThanOrEqualTo(String value) {
            addCriterion("is_collection >=", value, "isCollection");
            return (Criteria) this;
        }

        public Criteria andIsCollectionLessThan(String value) {
            addCriterion("is_collection <", value, "isCollection");
            return (Criteria) this;
        }

        public Criteria andIsCollectionLessThanOrEqualTo(String value) {
            addCriterion("is_collection <=", value, "isCollection");
            return (Criteria) this;
        }

        public Criteria andIsCollectionLike(String value) {
            addCriterion("is_collection like", value, "isCollection");
            return (Criteria) this;
        }

        public Criteria andIsCollectionNotLike(String value) {
            addCriterion("is_collection not like", value, "isCollection");
            return (Criteria) this;
        }

        public Criteria andIsCollectionIn(List<String> values) {
            addCriterion("is_collection in", values, "isCollection");
            return (Criteria) this;
        }

        public Criteria andIsCollectionNotIn(List<String> values) {
            addCriterion("is_collection not in", values, "isCollection");
            return (Criteria) this;
        }

        public Criteria andIsCollectionBetween(String value1, String value2) {
            addCriterion("is_collection between", value1, value2, "isCollection");
            return (Criteria) this;
        }

        public Criteria andIsCollectionNotBetween(String value1, String value2) {
            addCriterion("is_collection not between", value1, value2, "isCollection");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIsNull() {
            addCriterion("collection_time is null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIsNotNull() {
            addCriterion("collection_time is not null");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeEqualTo(Date value) {
            addCriterion("collection_time =", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotEqualTo(Date value) {
            addCriterion("collection_time <>", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThan(Date value) {
            addCriterion("collection_time >", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("collection_time >=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThan(Date value) {
            addCriterion("collection_time <", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeLessThanOrEqualTo(Date value) {
            addCriterion("collection_time <=", value, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeIn(List<Date> values) {
            addCriterion("collection_time in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotIn(List<Date> values) {
            addCriterion("collection_time not in", values, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeBetween(Date value1, Date value2) {
            addCriterion("collection_time between", value1, value2, "collectionTime");
            return (Criteria) this;
        }

        public Criteria andCollectionTimeNotBetween(Date value1, Date value2) {
            addCriterion("collection_time not between", value1, value2, "collectionTime");
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