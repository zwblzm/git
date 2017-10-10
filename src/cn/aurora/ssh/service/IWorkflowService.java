package cn.aurora.ssh.service;

import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.repository.Deployment;



public interface IWorkflowService {

	void saveDeployByZIP(ZipInputStream in, String fileName);

	List<Deployment> findDeploymentAll();


	

}
