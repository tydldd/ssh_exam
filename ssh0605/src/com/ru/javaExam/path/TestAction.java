package com.ru.javaExam.path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.SessionFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	
	/**
	 * 声明变量
	 * @remark 所有变量，常量
	 * */
	/*private SessionFactory sessionfactory;
	private TestServiceInterface testService;

	public TestServiceInterface getTestService() {
		return testService;
	}

	public void setTestService(TestServiceInterface testService) {
		this.testService = testService;
	}

	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	*/
	
	/**
	 * 测试action得到路径，request,response,session
	 * @remark 在service和dao类中得到requsest，response，和session的方法相同
	 * */
	public void getPath(){
		
		/**
		 * 得到request的方法
		 * */
		HttpServletRequest request = ServletActionContext.getRequest();
		
		/**
		 * 得到response的方法
		 * */
		HttpServletResponse response = ServletActionContext.getResponse();
		
		/**
		 * 得到session的到方法
		 * */
		//第一种
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("nan", "456");
		session.setMaxInactiveInterval(10*60);//单位秒
		
		//第二种（这种写入session信息，但是）
		ActionContext.getContext().getSession().put("ru", "123");
		String msg = (String) ActionContext.getContext().getSession().get("ru");
		
		System.out.println("第一种session:"+session.getAttribute("nan")+"\n第二种得到map里的信息："+msg);
		
		/**
		 * 得到web系统url路径的方法
		 * */
		//得到web的url路径：http://localhost:8080/ssh1/
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+
		":"+request.getServerPort()+path+"/";
		
		System.out.println("当前webURL路径："+basePath+"---web路径："+path);
		
		/**
		 * 得到文件的绝对路径
		 * @remark 所谓的真是路径即使在原路径前面加上web系统的路径,如果要找到在tomcat中的路径，需要注意
		 * @remark D:\ProgramFiles\apache-tomcat-6.0.20-8.5\webapps\ssh1\WEB-INF\classes\com\ru\.util\test.properties
		 * */
		String path2 = ServletActionContext.getRequest().
		getRealPath("/WEB-INF/classes/com/ru/util/test.properties");
		System.out.println("文件真实路径："+path2);
		
		/**
		 * 得到类文件路径
		 * @remark /D:/ProgramFiles/apache-tomcat-6.0.20-8.5/webapps/ssh1/WEB-INF/classes/com/ru/tuil/test.properties
		 * */
		String rootPath = TestAction.class.getResource("/").getPath();//得到calsses的路径
		String path3=rootPath+"com/ru/util/test.properties";
		System.out.println(path3);
	}
}
