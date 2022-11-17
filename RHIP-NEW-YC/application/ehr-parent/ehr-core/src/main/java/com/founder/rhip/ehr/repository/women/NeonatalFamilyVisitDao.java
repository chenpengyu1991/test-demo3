package com.founder.rhip.ehr.repository.women;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.child.NeonatalFamilyVisit;
import com.founder.rhip.ehr.entity.women.PrenatalFollowup;

public interface NeonatalFamilyVisitDao extends IDao<NeonatalFamilyVisit, String>{


	public void insert(NeonatalFamilyVisit neonatalFamilyVisit);

	public void update(NeonatalFamilyVisit neonatalFamilyVisit);

	
}
