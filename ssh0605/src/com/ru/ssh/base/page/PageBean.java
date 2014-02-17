package com.ru.ssh.base.page;

import java.util.List;

/**
 * 
 * 分页工具类
 * @version 1.0
 * 
 * @author 南成如
 * @param <T>
 * @since JDK1.6
 */
public class PageBean<T> {

    //当前页
    private int currentPage = 1;
	//每页显示多少条记录
	private int pageSize = 10;
	//总记录数
	private int totalCount;
	//总页数
	private int totalPage;

	//查询起始点
	private int beginIndex;
	//是否有上一页
	private boolean hasPrePage;
	//是否有下一页
	private boolean hasNextPage;
	//对象列表
	private List<T> pageBeanList;
	
	//DividePages构造方法
	public PageBean(){
		
	}
	//DividePages构造方法
	public PageBean(int pageSize,int totalCount,int currentPage){
		this.pageSize = getEveryPage(pageSize);
		this.currentPage = getCurrentPage(currentPage);
		this.totalPage = getTotalPage(pageSize, totalCount);
		this.beginIndex = getBeginIndex(pageSize, currentPage);
		this.hasPrePage = getHasPrePage(currentPage);
		this.hasNextPage = getHasNextPage(totalPage, currentPage);
	}

	public PageBean(int totalCount, int currentPage, List<T> list) {
		this.currentPage = getCurrentPage(currentPage);
		this.totalPage = getTotalPage(pageSize, totalCount);
		this.beginIndex = getBeginIndex(pageSize, currentPage);
		this.hasPrePage = getHasPrePage(currentPage);
		this.hasNextPage = getHasNextPage(totalPage, currentPage);
		this.pageBeanList = list;
	}

    /**
     * 初始化pagebean对象
     * @param totalCount
     * @param currentPage
     * @param list
     */
    public void initPage(int totalCount, int currentPage, List<T> list){
        this.currentPage = getCurrentPage(currentPage);
        this.totalPage = getTotalPage(pageSize, totalCount);
        this.beginIndex = getBeginIndex(pageSize, currentPage);
        this.hasPrePage = getHasPrePage(currentPage);
        this.hasNextPage = getHasNextPage(totalPage, currentPage);
        this.pageBeanList = list;
    }
	
	//获得每页显示几条记录个数
	public static int getEveryPage(int pageSize){
		return pageSize == 0 ? 5 : pageSize;
	}
	
	//获得当前页
	public static int getCurrentPage(int currentPage){
		return currentPage == 0 ? 1 : currentPage;
	}
	
	//获得总页数
	public static int getTotalPage(int pageSize,int totalCount){
		int totalPage = 0;
		if(totalCount != 0 && totalCount % pageSize == 0){
			totalPage = totalCount / pageSize;
		}else{
			totalPage = totalCount/pageSize + 1;
		}
		return totalPage;
	}
	
	//获得起始位置
	public static int getBeginIndex(int pageSize,int currentPage){
		return (currentPage - 1) * pageSize;
	}
	
	//是否有上一页
	public static boolean getHasPrePage(int currentPage){
		return currentPage == 1 ? false : true;
	}
	
	//是否有下一页
	public static boolean getHasNextPage(int totalPage,int currentPage){
		return currentPage == totalPage || totalPage == 0 ? false : true;
	}
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public boolean isHasPrePage() {
		return hasPrePage;
	}
	public void setHasPrePage(boolean hasPrePage) {
		this.hasPrePage = hasPrePage;
	}
	public boolean isHasNextPage() {
		return hasNextPage;
	}
	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageBeanList() {
		return pageBeanList;
	}
	public void setPageBeanList(List<T> pageBeanList) {
		this.pageBeanList = pageBeanList;
	}
}
