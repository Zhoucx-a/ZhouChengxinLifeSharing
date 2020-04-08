package com.lifeSharing.pojo;

import java.util.ArrayList;
import java.util.List;

public class StoryCommentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoryCommentsExample() {
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

        public Criteria andCommentatorNoIsNull() {
            addCriterion("commentator_no is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoIsNotNull() {
            addCriterion("commentator_no is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoEqualTo(String value) {
            addCriterion("commentator_no =", value, "commentatorNo");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoNotEqualTo(String value) {
            addCriterion("commentator_no <>", value, "commentatorNo");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoGreaterThan(String value) {
            addCriterion("commentator_no >", value, "commentatorNo");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_no >=", value, "commentatorNo");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoLessThan(String value) {
            addCriterion("commentator_no <", value, "commentatorNo");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoLessThanOrEqualTo(String value) {
            addCriterion("commentator_no <=", value, "commentatorNo");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoLike(String value) {
            addCriterion("commentator_no like", value, "commentatorNo");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoNotLike(String value) {
            addCriterion("commentator_no not like", value, "commentatorNo");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoIn(List<String> values) {
            addCriterion("commentator_no in", values, "commentatorNo");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoNotIn(List<String> values) {
            addCriterion("commentator_no not in", values, "commentatorNo");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoBetween(String value1, String value2) {
            addCriterion("commentator_no between", value1, value2, "commentatorNo");
            return (Criteria) this;
        }

        public Criteria andCommentatorNoNotBetween(String value1, String value2) {
            addCriterion("commentator_no not between", value1, value2, "commentatorNo");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameIsNull() {
            addCriterion("commentator_name is null");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameIsNotNull() {
            addCriterion("commentator_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameEqualTo(String value) {
            addCriterion("commentator_name =", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameNotEqualTo(String value) {
            addCriterion("commentator_name <>", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameGreaterThan(String value) {
            addCriterion("commentator_name >", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("commentator_name >=", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameLessThan(String value) {
            addCriterion("commentator_name <", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameLessThanOrEqualTo(String value) {
            addCriterion("commentator_name <=", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameLike(String value) {
            addCriterion("commentator_name like", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameNotLike(String value) {
            addCriterion("commentator_name not like", value, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameIn(List<String> values) {
            addCriterion("commentator_name in", values, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameNotIn(List<String> values) {
            addCriterion("commentator_name not in", values, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameBetween(String value1, String value2) {
            addCriterion("commentator_name between", value1, value2, "commentatorName");
            return (Criteria) this;
        }

        public Criteria andCommentatorNameNotBetween(String value1, String value2) {
            addCriterion("commentator_name not between", value1, value2, "commentatorName");
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