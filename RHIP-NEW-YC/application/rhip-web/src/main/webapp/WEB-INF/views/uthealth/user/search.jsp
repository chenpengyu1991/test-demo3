<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	 require(['views/uthealth/user/search'],function(userSearch){
		 userSearch.load();
	 });
</script>

<div class="section" id="searchDiv">
	<div class="searchbox">
		<form id="userFormId" name="userForm" action="" method="post">
			<table id="useSearchTableId">
				   <colgroup>
						<col style="width: 10%"/>
						<col style="width: 23%"/>
						<col style="width: 10%"/>
						<col style="width: 23%"/>
						<col style="width: 10%"/>
						<col style="width: 23%"/>
					</colgroup>
					<tbody>
					<tr>
						<td class="coltext">关键字</td>
						<td class="colinput">
							<input type="text" id="keywordId" name="keyword" placeholder="用户名称/身份证号"/>
						</td>
						<td></td>
						<td></td>
						<td></td>
						<td class="colinput">
							<input class="hide" /><input type="button" id="userSearchBut" value="查 询" class="search_btn" />
						</td>
					</tr>
				</tbody>
			</table>
			 <table>
				  <tr>
					  <td colspan="4" class="colbottom">
							 <span id="userSearchSpanId" class="ico-bottom">&nbsp;</span>
					  </td>
				  </tr>
			 </table>
		</form>
	</div>
	<div id="listDiv"></div>
</div>
<div id="detailDiv"></div>