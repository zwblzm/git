package cn.aurora.ssh.service;

import java.util.List;

import cn.aurora.ssh.domain.LeaveBill;



public interface ILeaveBillService {

	void saveLeaveBill(LeaveBill leaveBill);

	List<LeaveBill> findLeaveBillListByEmployee(Long id);

	LeaveBill findLeaveBillById(Long id);

	void deleteLeaveBillByEntity(LeaveBill leaveBill);

	
}
