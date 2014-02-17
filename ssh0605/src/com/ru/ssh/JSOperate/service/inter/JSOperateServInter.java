package com.ru.ssh.JSOperate.service.inter;

import com.ru.ssh.JSOperate.entity.QueryBean;
import com.ru.ssh.JSOperate.entity.Student;
import com.ru.ssh.base.page.PageBean;

import java.util.List;
import java.util.Map;

public interface JSOperateServInter {
	
	public List<Map<String, String>> getStuList(String data);
	public boolean saveStuData(List<Map<String, String>> list);
	public List<Student> getStuDataByDatabase();
    public List<Object[]> getUser(String message);
    public PageBean getDagaLogList(QueryBean queryBean, PageBean pageBean);
    public List<Object> getTaskName();
}
