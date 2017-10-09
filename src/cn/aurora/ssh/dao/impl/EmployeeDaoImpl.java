package cn.aurora.ssh.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.aurora.ssh.dao.IEmployeeDao;
import cn.aurora.ssh.domain.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements IEmployeeDao {

	@Override
	public Employee findEmployeeByName(String name) {
		List<Employee> employees= this.getHibernateTemplate().findByNamedQuery("getEmployeeByName", name);
		return employees.size()>0?employees.get(0):null;
	}
	
	
}
