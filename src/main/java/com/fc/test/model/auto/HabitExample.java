package com.fc.test.model.auto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 个人习性
 * 
 * @author fuce
 * @email 87766867@qq.com
 * @date 2019-05-18 20:49:11
 */
public class HabitExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HabitExample() {
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
        
        		
        public Criteria andEatingHabitsIsNull() {
            addCriterion("eating_habits is null");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsIsNotNull() {
            addCriterion("eating_habits is not null");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsEqualTo(String value) {
            addCriterion("eating_habits =", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsNotEqualTo(String value) {
            addCriterion("eating_habits <>", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsGreaterThan(String value) {
            addCriterion("eating_habits >", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsGreaterThanOrEqualTo(String value) {
            addCriterion("eating_habits >=", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsLessThan(String value) {
            addCriterion("eating_habits <", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsLessThanOrEqualTo(String value) {
            addCriterion("eating_habits <=", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsLike(String value) {
            addCriterion("eating_habits like", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsNotLike(String value) {
            addCriterion("eating_habits not like", value, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsIn(List<String> values) {
            addCriterion("eating_habits in", values, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsNotIn(List<String> values) {
            addCriterion("eating_habits not in", values, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsBetween(String value1, String value2) {
            addCriterion("eating_habits between", value1, value2, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsNotBetween(String value1, String value2) {
            addCriterion("eating_habits not between", value1, value2, "eatingHabits");
            return (Criteria) this;
        }

        public Criteria andEatingHabitsOrderBy() {
            addCriterion("order by eating_habits");
            return (Criteria) this;
        }
        
        		
        public Criteria andWorkRestIsNull() {
            addCriterion("work_rest is null");
            return (Criteria) this;
        }

        public Criteria andWorkRestIsNotNull() {
            addCriterion("work_rest is not null");
            return (Criteria) this;
        }

        public Criteria andWorkRestEqualTo(String value) {
            addCriterion("work_rest =", value, "workRest");
            return (Criteria) this;
        }

        public Criteria andWorkRestNotEqualTo(String value) {
            addCriterion("work_rest <>", value, "workRest");
            return (Criteria) this;
        }

        public Criteria andWorkRestGreaterThan(String value) {
            addCriterion("work_rest >", value, "workRest");
            return (Criteria) this;
        }

        public Criteria andWorkRestGreaterThanOrEqualTo(String value) {
            addCriterion("work_rest >=", value, "workRest");
            return (Criteria) this;
        }

        public Criteria andWorkRestLessThan(String value) {
            addCriterion("work_rest <", value, "workRest");
            return (Criteria) this;
        }

        public Criteria andWorkRestLessThanOrEqualTo(String value) {
            addCriterion("work_rest <=", value, "workRest");
            return (Criteria) this;
        }

        public Criteria andWorkRestLike(String value) {
            addCriterion("work_rest like", value, "workRest");
            return (Criteria) this;
        }

        public Criteria andWorkRestNotLike(String value) {
            addCriterion("work_rest not like", value, "work_rest");
            return (Criteria) this;
        }

        public Criteria andWorkRestIn(List<String> values) {
            addCriterion("work_rest in", values, "workRest");
            return (Criteria) this;
        }

        public Criteria andWorkRestNotIn(List<String> values) {
            addCriterion("work_rest not in", values, "workRest");
            return (Criteria) this;
        }

        public Criteria andWorkRestBetween(String value1, String value2) {
            addCriterion("work_rest between", value1, value2, "workRest");
            return (Criteria) this;
        }

        public Criteria andWorkRestNotBetween(String value1, String value2) {
            addCriterion("work_rest not between", value1, value2, "workRest");
            return (Criteria) this;
        }

        public Criteria andWorkRestOrderBy() {
            addCriterion("order by work_rest");
            return (Criteria) this;
        }

        		
        public Criteria andSmokeIsNull() {
            addCriterion("smoke is null");
            return (Criteria) this;
        }

        public Criteria andSmokeIsNotNull() {
            addCriterion("smoke is not null");
            return (Criteria) this;
        }

        public Criteria andSmokeEqualTo(String value) {
            addCriterion("smoke =", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeNotEqualTo(String value) {
            addCriterion("smoke <>", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeGreaterThan(String value) {
            addCriterion("smoke >", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeGreaterThanOrEqualTo(String value) {
            addCriterion("smoke >=", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeLessThan(String value) {
            addCriterion("smoke <", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeLessThanOrEqualTo(String value) {
            addCriterion("smoke <=", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeLike(String value) {
            addCriterion("smoke like", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeNotLike(String value) {
            addCriterion("smoke not like", value, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeIn(List<String> values) {
            addCriterion("smoke in", values, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeNotIn(List<String> values) {
            addCriterion("smoke not in", values, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeBetween(String value1, String value2) {
            addCriterion("smoke between", value1, value2, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeNotBetween(String value1, String value2) {
            addCriterion("smoke not between", value1, value2, "smoke");
            return (Criteria) this;
        }

        public Criteria andSmokeOrderBy() {
            addCriterion("order by smoke");
            return (Criteria) this;
        }
        
        		
        public Criteria andSleepQualityIsNull() {
            addCriterion("sleep_quality is null");
            return (Criteria) this;
        }

        public Criteria andSleepQualityIsNotNull() {
            addCriterion("sleep_quality is not null");
            return (Criteria) this;
        }

        public Criteria andSleepQualityEqualTo(String value) {
            addCriterion("sleep_quality =", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityNotEqualTo(String value) {
            addCriterion("sleep_quality <>", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityGreaterThan(String value) {
            addCriterion("sleep_quality >", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityGreaterThanOrEqualTo(String value) {
            addCriterion("sleep_quality >=", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityLessThan(String value) {
            addCriterion("sleep_quality <", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityLessThanOrEqualTo(String value) {
            addCriterion("sleep_quality <=", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityLike(String value) {
            addCriterion("sleep_quality like", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityNotLike(String value) {
            addCriterion("sleep_quality not like", value, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityIn(List<String> values) {
            addCriterion("sleep_quality in", values, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityNotIn(List<String> values) {
            addCriterion("sleep_quality not in", values, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityBetween(String value1, String value2) {
            addCriterion("sleep_quality between", value1, value2, "sleep_quality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityNotBetween(String value1, String value2) {
            addCriterion("sleep_quality not between", value1, value2, "sleepQuality");
            return (Criteria) this;
        }

        public Criteria andSleepQualityOrderBy() {
            addCriterion("order by sleep_quality");
            return (Criteria) this;
        }
        
        		
        public Criteria andStudentIdIsNull() {
            addCriterion("student_id is null");
            return (Criteria) this;
        }

        public Criteria andStudentIdIsNotNull() {
            addCriterion("student_id is not null");
            return (Criteria) this;
        }

        public Criteria andStudentIdEqualTo(String value) {
            addCriterion("student_id =", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotEqualTo(String value) {
            addCriterion("student_id <>", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThan(String value) {
            addCriterion("student_id >", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdGreaterThanOrEqualTo(String value) {
            addCriterion("student_id >=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThan(String value) {
            addCriterion("student_id <", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLessThanOrEqualTo(String value) {
            addCriterion("student_id <=", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdLike(String value) {
            addCriterion("student_id like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotLike(String value) {
            addCriterion("student_id not like", value, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdIn(List<String> values) {
            addCriterion("student_id in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotIn(List<String> values) {
            addCriterion("student_id not in", values, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdBetween(String value1, String value2) {
            addCriterion("student_id between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdNotBetween(String value1, String value2) {
            addCriterion("student_id not between", value1, value2, "studentId");
            return (Criteria) this;
        }

        public Criteria andStudentIdOrderBy() {
            addCriterion("order by student_id");
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