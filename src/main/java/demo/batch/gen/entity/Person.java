package demo.batch.gen.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Person extends PersonKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.age
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.birth
     *
     * @mbg.generated
     */
    private Date birth;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.sex
     *
     * @mbg.generated
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.salary
     *
     * @mbg.generated
     */
    private BigDecimal salary;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.description
     *
     * @mbg.generated
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.ref_timestamp_zone
     *
     * @mbg.generated
     */
    private Date refTimestampZone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.create_user
     *
     * @mbg.generated
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.create_date
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.update_user
     *
     * @mbg.generated
     */
    private String updateUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.update_date
     *
     * @mbg.generated
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.is_active
     *
     * @mbg.generated
     */
    private Boolean isActive;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.is_delete
     *
     * @mbg.generated
     */
    private Boolean isDelete;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table person
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.age
     *
     * @return the value of person.age
     *
     * @mbg.generated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.age
     *
     * @param age the value for person.age
     *
     * @mbg.generated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.birth
     *
     * @return the value of person.birth
     *
     * @mbg.generated
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.birth
     *
     * @param birth the value for person.birth
     *
     * @mbg.generated
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.sex
     *
     * @return the value of person.sex
     *
     * @mbg.generated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.sex
     *
     * @param sex the value for person.sex
     *
     * @mbg.generated
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.salary
     *
     * @return the value of person.salary
     *
     * @mbg.generated
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.salary
     *
     * @param salary the value for person.salary
     *
     * @mbg.generated
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.description
     *
     * @return the value of person.description
     *
     * @mbg.generated
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.description
     *
     * @param description the value for person.description
     *
     * @mbg.generated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.ref_timestamp_zone
     *
     * @return the value of person.ref_timestamp_zone
     *
     * @mbg.generated
     */
    public Date getRefTimestampZone() {
        return refTimestampZone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.ref_timestamp_zone
     *
     * @param refTimestampZone the value for person.ref_timestamp_zone
     *
     * @mbg.generated
     */
    public void setRefTimestampZone(Date refTimestampZone) {
        this.refTimestampZone = refTimestampZone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.create_user
     *
     * @return the value of person.create_user
     *
     * @mbg.generated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.create_user
     *
     * @param createUser the value for person.create_user
     *
     * @mbg.generated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.create_date
     *
     * @return the value of person.create_date
     *
     * @mbg.generated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.create_date
     *
     * @param createDate the value for person.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.update_user
     *
     * @return the value of person.update_user
     *
     * @mbg.generated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.update_user
     *
     * @param updateUser the value for person.update_user
     *
     * @mbg.generated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.update_date
     *
     * @return the value of person.update_date
     *
     * @mbg.generated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.update_date
     *
     * @param updateDate the value for person.update_date
     *
     * @mbg.generated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.is_active
     *
     * @return the value of person.is_active
     *
     * @mbg.generated
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.is_active
     *
     * @param isActive the value for person.is_active
     *
     * @mbg.generated
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.is_delete
     *
     * @return the value of person.is_delete
     *
     * @mbg.generated
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.is_delete
     *
     * @param isDelete the value for person.is_delete
     *
     * @mbg.generated
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", age=").append(age);
        sb.append(", birth=").append(birth);
        sb.append(", sex=").append(sex);
        sb.append(", salary=").append(salary);
        sb.append(", description=").append(description);
        sb.append(", refTimestampZone=").append(refTimestampZone);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", isActive=").append(isActive);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Person other = (Person) that;
        return (this.getPersonId() == null ? other.getPersonId() == null : this.getPersonId().equals(other.getPersonId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getBirth() == null ? other.getBirth() == null : this.getBirth().equals(other.getBirth()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getSalary() == null ? other.getSalary() == null : this.getSalary().equals(other.getSalary()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getRefTimestampZone() == null ? other.getRefTimestampZone() == null : this.getRefTimestampZone().equals(other.getRefTimestampZone()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getIsActive() == null ? other.getIsActive() == null : this.getIsActive().equals(other.getIsActive()))
            && (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table person
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPersonId() == null) ? 0 : getPersonId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getBirth() == null) ? 0 : getBirth().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getSalary() == null) ? 0 : getSalary().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getRefTimestampZone() == null) ? 0 : getRefTimestampZone().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getIsActive() == null) ? 0 : getIsActive().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        return result;
    }
}