<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/role/role2.js" type="text/javascript"></script>
<!-- <script type="text/javascript">
	 require(['views/role/role'],function(role){
		 role.load();
	 });
</script> -->
<div class="section">
<div class="toolbar"></div>
 <div class="searchbox searchSection x-admin-sm">
	<form id="roleQueryForm">
		<table id="roleSearch">
			<tr>
				<td class="coltext">角色描述</td>
				<td class="colinput">
					<input type="text" name="description:String:LIKE" style="width: 200px;" class="x-layui-input" />
					<input type="text" style="display: none;">
				</td> 
				<td >
				<!-- <input type="button" id="roleButtonId"  value="查 询" class="search_btn"/> -->
				<button class="layui-btn layui-btn-sm" id="roleButtonId"><i class="layui-icon">&#xe615;</i>查询</button>
				</td>
			</tr> 
		</table>
         <table>
              <tr>
                  <td colspan="3" class="colbottom">
                         <span id="roleSpanId" class="ico-bottom">&nbsp;</span>
                  </td>
              </tr>
         </table>
	</form>
</div>
<div id="listDiv">
</div>
