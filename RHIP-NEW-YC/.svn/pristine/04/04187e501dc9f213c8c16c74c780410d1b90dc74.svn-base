package com.founder.rhip.ehr.entity.portal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by haiyingjiang on 15/11/10.
 */
@Entity
@Table(name = "INFORM_BOOK")
public class InfromBook {

    @Id
    @Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
    private Long id;

    @Column(name = "CONTENTS", columnDefinition = "CLOB|内容|2000|", length = 2000, nullable = true)
    private String contents;

    @Column(name = "IS_OPEN", columnDefinition = "VARCHAR2|是否关闭告知书功能|2|", length = 2000, nullable = true)
    private String isOpen;

    @Column(name = "TIME", columnDefinition = "NUMBER|以秒为单位 强制用户阅读告知书的时长|11|", length = 11, nullable = false)
    private Long time;

    @Column(name = "CREATE_USER", columnDefinition = "NUMBER|创建人|11|", length = 11, nullable = false)
    private Long createUser;

    @Column(name = "UPDATE_USER", columnDefinition = "NUMBER|更新人|11|", length = 11, nullable = false)
    private Long updateUser;

    @Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
    private Date createTime;

    @Column(name = "UPDATE_TIME", columnDefinition = "DATE|修改时间||", nullable = true)
    private Date updateTime;

    public String getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}

	public Long getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(Long updateUser) {
		this.updateUser = updateUser;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
