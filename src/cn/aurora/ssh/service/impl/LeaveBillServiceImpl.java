package cn.aurora.ssh.service.impl;

import java.util.List;

import cn.aurora.ssh.dao.ILeaveBillDao;
import cn.aurora.ssh.domain.Employee;
import cn.aurora.ssh.domain.LeaveBill;
import cn.aurora.ssh.service.ILeaveBillService;
import cn.aurora.ssh.utils.SessionContext;

public class LeaveBillServiceImpl implements ILeaveBillService {
	private static final Integer STATE_EMPTY=0;//未设置
	private static final Integer STATE_INIT=1;//
	private static final Integer STATE_BEGIN=2;
	private static final Integer STATE_END=3;

	private ILeaveBillDao leaveBillDao;

	public void setLeaveBillDao(ILeaveBillDao leaveBillDao) {
		this.leaveBillDao = leaveBillDao;
	}

	@Override
	public void saveLeaveBill(LeaveBill leaveBill) {
		Employee user = SessionContext.get();
		leaveBill.setUser(user);
		leaveBill.setState(STATE_INIT);
		
		
		
		
		leaveBillDao.saveLeaveBill(leaveBill);
		
		
	}

	@Override
	public List<LeaveBill> findLeaveBillListByEmployee(Long id) {
		
		List<LeaveBill> leaveBillList = leaveBillDao.findLeaveBillListByEmployee(id);
		return leaveBillList;
	}

	@Override
	public LeaveBill findLeaveBillById(Long id) {
		LeaveBill leaveBill = leaveBillDao.findLeaveBillById(id);
		return null;
	}

	@Override
	public void deleteLeaveBillByEntity(LeaveBill leaveBill) {
		leaveBillDao.deleteLeaveBillByEntity(leaveBill);
		
	}

	
}
