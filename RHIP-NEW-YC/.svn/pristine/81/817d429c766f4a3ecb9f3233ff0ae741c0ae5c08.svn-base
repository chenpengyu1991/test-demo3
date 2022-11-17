package com.founder.rhip.ehr.entity.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "FS_INTEGRATION_MINCHINE_INFO")
public class MachineInfo implements Serializable {

	/**
	 * 唯一ID
	 */
	@Id
	@Column(name  = "ID")
	private Integer id;
	
	/**
	 * IP地址
	 */
	@Column(name  = "IPADDRESS")
	private String ipAddress;
	
	/**
	 * CPU信息
	 */
	@Column(name  = "CUPINFO")
	private String cupInfo;
	
	/**
	 * 内存信息
	 */
	@Column(name  = "MEMORYINFO")
	private String memoryInfo;
	
	/**
	 * 硬盘信息
	 */
	@Column(name  = "DISKINFO")
	private String diskInfo;
	
	/**
	 * CPU使用率
	 */
	@Column(name  = "CPURATE")
	private Double cpuRate;
	
	/**
	 * 内存使用率
	 */
	@Column(name  = "MEMORYRATE")
	private Double memoryRate;
	
	/**
	 * 磁盘使用率
	 */
	@Column(name  = "DISKRATE")
	private Double diskRate;
	
	/**
	 * 内存大小（单位G）
	 */
	@Column(name  = "MEMORYSIZE")
	private Double memorySize;
	
	/**
	 * 已使用内存（单位G）
	 */
	@Column(name  = "USEMEMORY")
	private Double useMemory;
	
	/**
	 * 磁盘大小（单位G）
	 */
	@Column(name  = "DISKSIZE")
	private Double diskSize;
	
	/**
	 * 已使用磁盘（单位G）
	 */
	@Column(name  = "USEDISK")
	private Double useDisk;
	
	/**
	 * 各个磁盘信息（大小和使用率;json格式存储）
	 */
	@Column(name  = "EACHDISKINFO")
	private String eachDiskInfo;
	
	/**
	 * 连接状态（1：正常连接 2：连接断开）
	 */
	@Column(name  = "CONNECTIONSTATUS")
	private Integer connectionStatus;
	
	/**
	 * 创建时间
	 */
	@Column(name  = "CREATETIME")
	private Timestamp createTime;
	
	/**
	 * 删除状态
	 */
	@Column(name  = "DELSTATUS")
	private Integer delStatus=0;
	
	/**
	 * 名称
	 */
	@Column(name  = "NAME")
	private String name;
	
	/**
	 * 分盘已使用磁盘（单位G）
	 */
	 @Column(name="DISKUSED")
	private String diskUsed;
	
	/**
	 * 分盘磁盘大小（单位G）
	 */
	  @Column(name="DISKTOTAL")
    private String diskTotal;
	
	  /**
	 * 分盘已使用磁盘（单位G）
	 */
	 @Column(name="DISKUNUSED")
	private String diskUnused;
	
	 
	 
	public String getDiskUnused() {
		return diskUnused;
	}

	public void setDiskUnused(String diskUnused) {
		this.diskUnused = diskUnused;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getCupInfo() {
		return cupInfo;
	}

	public void setCupInfo(String cupInfo) {
		this.cupInfo = cupInfo;
	}

	public String getMemoryInfo() {
		return memoryInfo;
	}

	public void setMemoryInfo(String memoryInfo) {
		this.memoryInfo = memoryInfo;
	}

	public String getDiskInfo() {
		return diskInfo;
	}

	public void setDiskInfo(String diskInfo) {
		this.diskInfo = diskInfo;
	}

	public Double getCpuRate() {
		return cpuRate;
	}

	public void setCpuRate(Double cpuRate) {
		this.cpuRate = cpuRate;
	}

	public Double getMemoryRate() {
		return memoryRate;
	}

	public void setMemoryRate(Double memoryRate) {
		this.memoryRate = memoryRate;
	}

	public Double getDiskRate() {
		return diskRate;
	}

	public void setDiskRate(Double diskRate) {
		this.diskRate = diskRate;
	}

	public Double getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(Double memorySize) {
		this.memorySize = memorySize;
	}

	public Double getUseMemory() {
		return useMemory;
	}

	public void setUseMemory(Double useMemory) {
		this.useMemory = useMemory;
	}

	public Double getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(Double diskSize) {
		this.diskSize = diskSize;
	}

	public Double getUseDisk() {
		return useDisk;
	}

	public void setUseDisk(Double useDisk) {
		this.useDisk = useDisk;
	}

	public String getEachDiskInfo() {
		return eachDiskInfo;
	}

	public void setEachDiskInfo(String eachDiskInfo) {
		this.eachDiskInfo = eachDiskInfo;
	}

	public Integer getConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(Integer connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	public Integer getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(Integer delStatus) {
		this.delStatus = delStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public String getDiskUsed() {
        return this.diskUsed;
    }
    
    public void setDiskUsed(String diskUsed) {
        this.diskUsed = diskUsed;
    }
    
  

    public String getDiskTotal() {
        return this.diskTotal;
    }
    
    public void setDiskTotal(String diskTotal) {
        this.diskTotal = diskTotal;
    }

	public String toString()
	{
		String line = System.getProperty("line.separator");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("              id = ").append(id).append(line);
		sb.append("       ipAddress = ").append(ipAddress).append(line);
		sb.append("         cupInfo = ").append(cupInfo).append(line);
		sb.append("      memoryInfo = ").append(memoryInfo).append(line);
		sb.append("        diskInfo = ").append(diskInfo).append(line);
		sb.append("         cpuRate = ").append(cpuRate).append(line);
		sb.append("      memoryRate = ").append(memoryRate).append(line);
		sb.append("        diskRate = ").append(diskRate).append(line);
		sb.append("      memorySize = ").append(memorySize).append(line);
		sb.append("       useMemory = ").append(useMemory).append(line);
		sb.append("        diskSize = ").append(diskSize).append(line);
		sb.append("         useDisk = ").append(useDisk).append(line);
		sb.append("    eachDiskInfo = ").append(eachDiskInfo).append(line);
		sb.append("connectionStatus = ").append(connectionStatus).append(line);
		sb.append("      createTime = ").append(createTime.toString()).append(line);
		sb.append("       delStatus = ").append(delStatus).append(line);
		sb.append("            name = ").append(name).append(line);
		
		return sb.toString();
	}
}
