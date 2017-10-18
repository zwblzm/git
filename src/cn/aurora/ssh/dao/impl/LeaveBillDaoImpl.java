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

	
}
