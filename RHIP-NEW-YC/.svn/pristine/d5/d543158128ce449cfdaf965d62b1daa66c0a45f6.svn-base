<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- <script type="text/javascript">
	 require(['views/bulletin/search'],function(bulletinSearch){
		 bulletinSearch.load();
	 });
</script> -->
<script src="${pageContext.request.contextPath}/js/views/bulletin/search2.js" type="text/javascript"></script>

<div class="section">

<div class="toolbar">
	<ehr:authorize ifAnyGranted="01">
		<%-- <a id="bulletinAddButId"><b class="xinz">新增</b></a> --%>
		<a id="bulletinAddButId"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe608;</i>新增</button></a>
	</ehr:authorize>
	<c:if test="${fromHome}">
		 <%-- <a id = "back"><b class="fanhui">返回</b></a> --%>
		 <a href="javascript:void(0)" id = "back"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	</c:if>
</div>
<div class="searchbox searchSection x-admin-sm">
	<form id="bulletinForm">
		<table id="bulletinSearch" class="x-so">
	        <colgroup>
	             <col style="width: 10%"/>
	             <col style="width: 15%"/>
	             <col style="width: 10%"/>
	             <col style="width: 30%"/>
	             <ehr:authorize ifAnyGranted="01">
		             <col style="width: 10%"/>
		             <col style="width: 15%"/>
	             </ehr:authorize>
	             <col style="width: 10%"/>
	         </colgroup>
			<tbody>
				<tr>
					<td class="coltext">标题</td>
					<td class="colinput">
                         <input type="text" name="title" class="x-layui-input"/>
                    </td>
                    <td class="coltext">时间</td>
                    <td class="colinput">
                    	<input type="text" class="layui-input x-admin-sm-date"  name="submitDateFrom" id="submitDateFrom" style="padding-left: 0px;width: 36%;" />~
          				<input type="text" class="layui-input x-admin-sm-date"  name="submitDateTo" id="submitDateTo" style="padding-left: 0px;width: 36%;" />
                    </td>
                    <ehr:authorize ifAnyGranted="01">
	                    <td class="coltext">显示状态</td>
						<td class="colinput">
	                         <select name="isDelete">
	                         	<option value="">请选择</option>
	                         	<option value="0">显示</option>
	                         	<option value="1">隐藏</option>
	                         </select>
	                    </td>
                    </ehr:authorize>
                    <ehr:authorize ifNotGranted="01">
	                    <input name="isDelete" type="hidden" value="0"/>
                    </ehr:authorize>
                    <td class="colinput">
                    	<button class="layui-btn layui-btn-sm"  id="btnBulletinSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                        <!-- <input type="button" id="btnBulletinSearch" value="查 询" class="search_btn" /> -->
                    </td>
				</tr>
			</tbody>
		</table>
         <table>
              <tr>
                  <td colspan="4" class="colbottom">
						<span id = "bulletinSearchSpanId" class="ico-bottom">&nbsp;</span>
                  </td>
              </tr>
         </table>
	</form>
 </div>
<div id="listDiv"></div>
</div>
 <script type="text/javascript">
 layui.use('laydate', function(){
     var laydate = layui.laydate;
     
     //执行一个laydate实例
     laydate.render({
       elem: '#submitDateFrom' 
    	   ,format: 'yyyy/MM/dd' 
    		   ,max: 0
     });

     //执行一个laydate实例
     laydate.render({
       elem: '#submitDateTo' 
    	   ,format: 'yyyy/MM/dd' 
    		   ,max: 0
     });
   });

 </script>