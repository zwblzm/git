package cn.aurora.ssh.service.impl;

import cn.aurora.ssh.dao.ILeaveBillDao;
import cn.aurora.ssh.service.ILeaveBillService;

public class LeaveBillServiceImpl implements ILeaveBillService {

	private ILeaveBillDao leaveBillDao;

	public void setLeaveBillDao(ILeaveBillDao leaveBillDao) {
		this.leaveBillDao = leaveBillDao;
	}

}
