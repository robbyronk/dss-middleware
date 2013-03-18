package org.cru.dss.middle.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.cru.dss.middle.entity.DesignationEntity;

public class StaffDesignationDao
{
	@Inject EntityManager em;
	
	public List<DesignationEntity> fetchAllActiveCruStaff()
	{
		return em.createQuery("SELECT staff FROM DesignationEntity staff " +
				"WHERE staff.designationType = 'Staff' " +
					"AND staff.status = 'Active'", DesignationEntity.class)
//				.setMaxResults(50)
				.getResultList();
	}
}
