package com.founder.rhip.mdm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "STAND_PARAMETER_CFG")
public class StandParameterCfg implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|子增长字段|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|名称||", length = 100, nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", columnDefinition = "VARCHAR2|描述||", length = 500, nullable = false)
    private String description;

    @Column(name = "VALUE", columnDefinition = "VARCHAR2|值||", length = 1000, nullable = false)
    private String value;

    @Column(name = "VALID", columnDefinition = "VARCHAR2|有效性（1：有效，0：无效）||", length = 1, nullable = false)
    private String valid;

    /**
     * @return ID
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return NAME
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return DESCRIPTION
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return VALUE
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return VALID
     */
    public String getValid() {
        return valid;
    }

    /**
     * @param valid
     */
    public void setValid(String valid) {
        this.valid = valid;
    }
}