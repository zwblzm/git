package cn.aurora.ssh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.aurora.ssh.dao.ILeaveBillDao;
import cn.aurora.ssh.domain.LeaveBill;

public class LeaveBillDaoImpl extends HibernateDaoSupport implements ILeaveBillDao {

	@Override
	public void saveLeaveBill(LeaveBill leaveBill) {
		this.getHibernateTemplate().save(leaveBill);
		
	}

	@Override
	public List<LeaveBill> findLeaveBillListByEmployee(Long id) {
		List<LeaveBill> leaveBillList = this.getHibernateTemplate().findByNamedQuery("getLeaveBillByEmployeeID", id);
		return leaveBillList;
	}

	@Override
	public LeaveBill findLeaveBillById(Long id) {
		List<LeaveBill> leaveBills = this.getHibernateTemplate().findByNamedQuery("getLeaveBillById", id);
		return leaveBills.get(0);
	}

	@Override
	public void deleteLeaveBillByEntity(LeaveBill leaveBill) {
		this.getHibernateTemplate().delete(leaveBill);
		
	}

	
	
}
