package com.ru.ssh.JSOperate.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ru.ssh.JSOperate.entity.QueryBean;
import com.ru.ssh.JSOperate.service.inter.JSOperateServInter;
import com.ru.ssh.base.page.PageBean;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Description: 分页的例子
 * User: NanChengRu
 * Date: 13-11-22
 * Time: 上午10:40
 * JDK: 1.6
 * version: 1.0
 */
public class PageExamAction extends ActionSupport{

    Logger log = Logger.getLogger(PageExamAction.class);
    private JSOperateServInter jsOperateService;
    //列表和分页对象
    private PageBean pageBean = new PageBean();
    //查询条件对象
    private QueryBean queryBean;
    //任务名
    private List<Object> taskNameList;

    public PageExamAction(){
        log.debug("pageExamAction spring初始化！");
    }

    /**
     * 查询datalog列表
     * @return
     */
    public String getDagaLogList(){
        log.debug("查询datalog分页列表列表-begin");
        pageBean = jsOperateService.getDagaLogList(queryBean, pageBean);
        taskNameList = jsOperateService.getTaskName();
        log.debug("查询datalog分页列表列表-end");
        return "pageList";
    }




    public PageBean getPageBean() {
        return pageBean;
    }

    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    public QueryBean getQueryBean() {
        return queryBean;
    }

    public void setQueryBean(QueryBean queryBean) {
        this.queryBean = queryBean;
    }

    public JSOperateServInter getJsOperateService() {
        return jsOperateService;
    }

    public void setJsOperateService(JSOperateServInter jsOperateService) {
        this.jsOperateService = jsOperateService;
    }

    public List<Object> getTaskNameList() {
        return taskNameList;
    }

    public void setTaskNameList(List<Object> taskNameList) {
        this.taskNameList = taskNameList;
    }
}
