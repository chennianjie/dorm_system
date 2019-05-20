package com.fc.test.model.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 床位
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-19 16:11:53
 */
public class BedExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BedExample() {
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
				
        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }
        
        		
        public Criteria andBedNumIsNull() {
            addCriterion("bed_num is null");
            return (Criteria) this;
        }

        public Criteria andBedNumIsNotNull() {
            addCriterion("bed_num is not null");
            return (Criteria) this;
        }

        public Criteria andBedNumEqualTo(String value) {
            addCriterion("bed_num =", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumNotEqualTo(String value) {
            addCriterion("bed_num <>", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumGreaterThan(String value) {
            addCriterion("bed_num >", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumGreaterThanOrEqualTo(String value) {
            addCriterion("bed_num >=", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumLessThan(String value) {
            addCriterion("bed_num <", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumLessThanOrEqualTo(String value) {
            addCriterion("bed_num <=", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumLike(String value) {
            addCriterion("bed_num like", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumNotLike(String value) {
            addCriterion("bed_num not like", value, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumIn(List<String> values) {
            addCriterion("bed_num in", values, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumNotIn(List<String> values) {
            addCriterion("bed_num not in", values, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumBetween(String value1, String value2) {
            addCriterion("bed_num between", value1, value2, "bedNum");
            return (Criteria) this;
        }

        public Criteria andBedNumNotBetween(String value1, String value2) {
            addCriterion("bed_num not between", value1, value2, "bedNum");
            return (Criteria) this;
        }
        
        		
        public Criteria andEmptyIsNull() {
            addCriterion("empty is null");
            return (Criteria) this;
        }

        public Criteria andEmptyIsNotNull() {
            addCriterion("empty is not null");
            return (Criteria) this;
        }

        public Criteria andEmptyEqualTo(String value) {
            addCriterion("empty =", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyNotEqualTo(String value) {
            addCriterion("empty <>", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyGreaterThan(String value) {
            addCriterion("empty >", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyGreaterThanOrEqualTo(String value) {
            addCriterion("empty >=", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyLessThan(String value) {
            addCriterion("empty <", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyLessThanOrEqualTo(String value) {
            addCriterion("empty <=", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyLike(String value) {
            addCriterion("empty like", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyNotLike(String value) {
            addCriterion("empty not like", value, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyIn(List<String> values) {
            addCriterion("empty in", values, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyNotIn(List<String> values) {
            addCriterion("empty not in", values, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyBetween(String value1, String value2) {
            addCriterion("empty between", value1, value2, "empty");
            return (Criteria) this;
        }

        public Criteria andEmptyNotBetween(String value1, String value2) {
            addCriterion("empty not between", value1, value2, "empty");
            return (Criteria) this;
        }
        
        		
        public Criteria andBedroomIdIsNull() {
            addCriterion("bedroom_id is null");
            return (Criteria) this;
        }

        public Criteria andBedroomIdIsNotNull() {
            addCriterion("bedroom_id is not null");
            return (Criteria) this;
        }

        public Criteria andBedroomIdEqualTo(String value) {
            addCriterion("bedroom_id =", value, "bedroomId");
            return (Criteria) this;
        }

        public Criteria andBedroomIdNotEqualTo(String value) {
            addCriterion("bedroom_id <>", value, "bedroomId");
            return (Criteria) this;
        }

        public Criteria andBedroomIdGreaterThan(String value) {
            addCriterion("bedroom_id >", value, "bedroomId");
            return (Criteria) this;
        }

        public Criteria andBedroomIdGreaterThanOrEqualTo(String value) {
            addCriterion("bedroom_id >=", value, "bedroomId");
            return (Criteria) this;
        }

        public Criteria andBedroomIdLessThan(String value) {
            addCriterion("bedroom_id <", value, "bedroomId");
            return (Criteria) this;
        }

        public Criteria andBedroomIdLessThanOrEqualTo(String value) {
            addCriterion("bedroom_id <=", value, "bedroomId");
            return (Criteria) this;
        }

        public Criteria andBedroomIdLike(String value) {
            addCriterion("bedroom_id like", value, "bedroomId");
            return (Criteria) this;
        }

        public Criteria andBedroomIdNotLike(String value) {
            addCriterion("bedroom_id not like", value, "bedroomId");
            return (Criteria) this;
        }

        public Criteria andBedroomIdIn(List<String> values) {
            addCriterion("bedroom_id in", values, "bedroomId");
            return (Criteria) this;
        }

        public Criteria andBedroomIdNotIn(List<String> values) {
            addCriterion("bedroom_id not in", values, "bedroomId");
            return (Criteria) this;
        }

        public Criteria andBedroomIdBetween(String value1, String value2) {
            addCriterion("bedroom_id between", value1, value2, "bedroomId");
            return (Criteria) this;
        }

        public Criteria andBedroomIdNotBetween(String value1, String value2) {
            addCriterion("bedroom_id not between", value1, value2, "bedroomId");
            return (Criteria) this;
        }
        
        		
        public Criteria andBedroomNameIsNull() {
            addCriterion("bedroom_name is null");
            return (Criteria) this;
        }

        public Criteria andBedroomNameIsNotNull() {
            addCriterion("bedroom_name is not null");
            return (Criteria) this;
        }

        public Criteria andBedroomNameEqualTo(String value) {
            addCriterion("bedroom_name =", value, "bedroomName");
            return (Criteria) this;
        }

        public Criteria andBedroomNameNotEqualTo(String value) {
            addCriterion("bedroom_name <>", value, "bedroomName");
            return (Criteria) this;
        }

        public Criteria andBedroomNameGreaterThan(String value) {
            addCriterion("bedroom_name >", value, "bedroomName");
            return (Criteria) this;
        }

        public Criteria andBedroomNameGreaterThanOrEqualTo(String value) {
            addCriterion("bedroom_name >=", value, "bedroomName");
            return (Criteria) this;
        }

        public Criteria andBedroomNameLessThan(String value) {
            addCriterion("bedroom_name <", value, "bedroomName");
            return (Criteria) this;
        }

        public Criteria andBedroomNameLessThanOrEqualTo(String value) {
            addCriterion("bedroom_name <=", value, "bedroomName");
            return (Criteria) this;
        }

        public Criteria andBedroomNameLike(String value) {
            addCriterion("bedroom_name like", value, "bedroomName");
            return (Criteria) this;
        }

        public Criteria andBedroomNameNotLike(String value) {
            addCriterion("bedroom_name not like", value, "bedroomName");
            return (Criteria) this;
        }

        public Criteria andBedroomNameIn(List<String> values) {
            addCriterion("bedroom_name in", values, "bedroomName");
            return (Criteria) this;
        }

        public Criteria andBedroomNameNotIn(List<String> values) {
            addCriterion("bedroom_name not in", values, "bedroomName");
            return (Criteria) this;
        }

        public Criteria andBedroomNameBetween(String value1, String value2) {
            addCriterion("bedroom_name between", value1, value2, "bedroomName");
            return (Criteria) this;
        }

        public Criteria andBedroomNameNotBetween(String value1, String value2) {
            addCriterion("bedroom_name not between", value1, value2, "bedroomName");
            return (Criteria) this;
        }
        
        		
        public Criteria andDepartmentIdIsNull() {
            addCriterion("department_id is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIsNotNull() {
            addCriterion("department_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdEqualTo(String value) {
            addCriterion("department_id =", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotEqualTo(String value) {
            addCriterion("department_id <>", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThan(String value) {
            addCriterion("department_id >", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdGreaterThanOrEqualTo(String value) {
            addCriterion("department_id >=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThan(String value) {
            addCriterion("department_id <", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLessThanOrEqualTo(String value) {
            addCriterion("department_id <=", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdLike(String value) {
            addCriterion("department_id like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotLike(String value) {
            addCriterion("department_id not like", value, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdIn(List<String> values) {
            addCriterion("department_id in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotIn(List<String> values) {
            addCriterion("department_id not in", values, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdBetween(String value1, String value2) {
            addCriterion("department_id between", value1, value2, "departmentId");
            return (Criteria) this;
        }

        public Criteria andDepartmentIdNotBetween(String value1, String value2) {
            addCriterion("department_id not between", value1, value2, "departmentId");
            return (Criteria) this;
        }
        
        		
        public Criteria andDepartmentNameIsNull() {
            addCriterion("department_name is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIsNotNull() {
            addCriterion("department_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameEqualTo(String value) {
            addCriterion("department_name =", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotEqualTo(String value) {
            addCriterion("department_name <>", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThan(String value) {
            addCriterion("department_name >", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("department_name >=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThan(String value) {
            addCriterion("department_name <", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLessThanOrEqualTo(String value) {
            addCriterion("department_name <=", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameLike(String value) {
            addCriterion("department_name like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotLike(String value) {
            addCriterion("department_name not like", value, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameIn(List<String> values) {
            addCriterion("department_name in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotIn(List<String> values) {
            addCriterion("department_name not in", values, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameBetween(String value1, String value2) {
            addCriterion("department_name between", value1, value2, "departmentName");
            return (Criteria) this;
        }

        public Criteria andDepartmentNameNotBetween(String value1, String value2) {
            addCriterion("department_name not between", value1, value2, "departmentName");
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