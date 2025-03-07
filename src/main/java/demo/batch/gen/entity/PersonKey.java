package demo.batch.gen.entity;

import java.io.Serializable;

public class PersonKey implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.person_id
     *
     * @mbg.generated
     */
    private String personId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column person.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table person
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.person_id
     *
     * @return the value of person.person_id
     *
     * @mbg.generated
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.person_id
     *
     * @param personId the value for person.person_id
     *
     * @mbg.generated
     */
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column person.name
     *
     * @return the value of person.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column person.name
     *
     * @param name the value for person.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name;
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
        sb.append(", personId=").append(personId);
        sb.append(", name=").append(name);
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
        PersonKey other = (PersonKey) that;
        return (this.getPersonId() == null ? other.getPersonId() == null : this.getPersonId().equals(other.getPersonId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()));
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
        return result;
    }
}