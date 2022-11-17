package com.founder.fasf.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5944998439562776452L;

	private String username;

    private String authority;

    @Id
    public String getUsername()
    {
        return this.username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    @Column(name = "authority", nullable = false, length = 50)
    public String getAuthority()
    {
        return this.authority;
    }

    public void setAuthority(String authority)
    {
        this.authority = authority;
    }

    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Authorities pojo = (Authorities) o;

        if (authority != null ? !authority.equals(pojo.authority)
                : pojo.authority != null)
            return false;

        return true;
    }

    public int hashCode()
    {
        int result = 0;
        result = (authority != null ? authority.hashCode() : 0);

        return result;
    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("username").append("='").append(getUsername()).append("', ");
        sb.append("authority").append("='").append(getAuthority()).append("'");
        sb.append("]");

        return sb.toString();
    }
}
