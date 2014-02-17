<%@ page language="java"  pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<script language="text/javascript" type="text/javascript" src="<%=request.getContextPath()%>/js/common/page.js"  charset="UTF-8"></script>
<!-- 存在数据 显示分页条 -->
 <tr class="tr1">
	         <div class="fy">
	                     <!--页面展示 -->
		                      	<input type="hidden" id="pageTotal" value="<s:property value="pageBean.totalPage"/>" />
		                      	<input type="hidden" id="gocurrentpage" name="currentPage" value="" />
	                    		<span class="p_span">第<s:property value="pageBean.currentPage"/>/<s:property value="pageBean.totalPage"/>页</span>
	                   			<s:if test="pageBean.hasPrePage">
		                    		<a href="javascript:void(0);" class="page" onclick="dividePage(1);">首页</a>
		                    	 	<a href="javascript:void(0);" class="page p1" onclick="dividePage(<s:property value='pageBean.currentPage-1'/>);"><span></span>&nbsp;上一页</a>
		                   		 </s:if>
		                    	<s:else>
		                    		<a href="javascript:void(0);" class="page">首页</a>
		                    		<a href="javascript:void(0);" class="page p1"><span></span>&nbsp;上一页</a>
		                   		</s:else>
		                    	<s:if test="pageBean.hasNextPage">
		                    		<a href="javascript:void(0);" class="page p2" onclick="dividePage(<s:property value='pageBean.currentPage +1'/>)">下一页&nbsp;<span></span></a>
		                   			<a href="javascript:void(0);" class="page" onclick="dividePage(<s:property value="pageBean.totalPage"/>)">末页</a>
		                    	</s:if>
		                    	<s:else>
			                    	<a href="javascript:void(0);" class="page p2">下一页&nbsp;<span></span></a>
			                   		<a href="javascript:void(0);" class="page">末页</a>
		                   	    </s:else>
	                   			<span class="p_span">跳转到<input type="text" id="jumpTxt" size="1"/></span>
		                    	<span class="p_span">页</span>
		                    	<input type="button" id="jumpBtn" value="确定"/>
		                    	<!--分页展示结束  -->
	                </div>
	            <td></td>
	     </tr>