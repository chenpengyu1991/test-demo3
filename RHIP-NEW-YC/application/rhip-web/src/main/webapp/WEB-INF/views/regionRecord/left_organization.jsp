<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div>
	<table class="formtable">
		<tbody>
			<tr>
				<td><input type="text" id="filter_org_input"></td>
				<td><input type="button" class="btn" value="搜索" id="filter_org_btn" /></td>
			</tr>
		</tbody>
	</table>

</div>
<div id="sidemenuwrapper">
	<div id="org_treebox" class="sidemenu">
		<jsp:include page="org_tree.jsp"></jsp:include>
	</div>
</div>
<input type="hidden" id="menuUrlHid" value="" />
<input type="hidden" id="preUrlHid" value="" />