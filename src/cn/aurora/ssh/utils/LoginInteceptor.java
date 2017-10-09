package cn.aurora.ssh.utils;

import cn.aurora.ssh.domain.Employee;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.Interceptor;


/**
 * 登录验证拦截器
 *
 */
@SuppressWarnings("serial")
public class LoginInteceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	/**
	 * 控制项目中的session是否存在，如果存在调用invocation.invoke()对应的Action类，
	 * 如果不存在就跳转到登录页面
	 * */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Employee employee =SessionContext.get();
		ActionProxy proxy = invocation.getProxy();
		if(proxy.getActionName().equals("loginAction_login") || employee!=null){
			
			
			return invocation.invoke();
		}else {
			
			return "login";
		}
		
		
		
		
		
	}

}
