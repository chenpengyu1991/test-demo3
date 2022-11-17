package com.founder.rhip.mdm.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.mdm.entity.DicVersion;

public interface IDicVersionService {
	
	public List<DicVersion> getDicVersionsUseCache(Criteria criteria);
	
	public List<DicVersion> getDicVersions(Criteria criteria);

	public PageList<DicVersion> getDicVersions(Page page,Criteria criteria);

	public DicVersion getDicVersion(String dicCode, String versionNumber);

	public DicVersion getDicVersionDesc(String dicCode, String versionDesc);

	public void createDicVersion(DicVersion dicVersion);

	public void updateDicVersion(DicVersion dicVersion);

	public void changeVersionStatus(DicVersion dicVersion);

	public void changeMajorVersion(DicVersion dicVersion);

	int deleteDicVersion(Criteria criteria);
	

}
