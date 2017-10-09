package cn.aurora.ssh.dao;

import cn.aurora.ssh.domain.Employee;


public interface IEmployeeDao {

	Employee findEmployeeByName(String name);

	

}
