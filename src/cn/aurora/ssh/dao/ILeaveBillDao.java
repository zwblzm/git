package cn.aurora.ssh.dao;

import java.util.List;

import cn.aurora.ssh.domain.LeaveBill;



public interface ILeaveBillDao {

	void saveLeaveBill(LeaveBill leaveBill);

	List<LeaveBill> findLeaveBillListByEmployee(Long id);

	LeaveBill findLeaveBillById(Long id);

	void deleteLeaveBillByEntity(LeaveBill leaveBill);

	


}
