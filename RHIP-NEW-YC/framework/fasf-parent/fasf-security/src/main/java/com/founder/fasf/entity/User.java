package com.founder.fasf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = -4580407039853552989L;

	private String username;

    private String password;

    @Id
    public String getUsername()
    {
    	return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Column(name = "password", nullable = false, length = 50)
    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        User pojo = (User) o;

        if (password != null ? !password.equals(pojo.password)
                : pojo.password != null)
            return false;

        return true;
    }

    public int hashCode()
    {
        int result = 0;
        result = (password != null ? password.hashCode() : 0);

        return result;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("username").append("='").append(getUsername()).append("', ");
        sb.append("password").append("='").append(getPassword()).append("'");
        sb.append("]");

        return sb.toString();
    }
}
