
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/ism/reportCard/list.js" type="text/javascript"></script>

<div  class="section" id="list_view">
	<div class="toolbar">
          <a href="javascript:void(0)" ><b ></b></a>
    </div>   
		<div class="searchbox" style="width: 100%" >
			<form method="post" id="form_search">
			<input type="hidden" id="ism-app-flag" value="${reportFlag}"/>
				<%--重要! viewType用来标志是否显示审核操作列 --%>
				<input type="hidden"  name="viewType" value="1"/>
				<table style="" id="searchTable">
				<colgroup>
					<col style="min-width: 70px;width:10%">
					<col style="min-width: 150px;width:25%">
					<col style="min-width: 60px;width:8%">
					<col style="min-width: 140px;width:23%">
					<col style="min-width: 70px;width:10%">
					<col style="min-width: 140px;width:23%">
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext" >姓名</td>
							<td class="colinput"><input type="text" name="name" id="personName" /></td>
							<td class="coltext" >身份证号</td>
							<td class="colinput"><input type="text" name="idcard" id="idCard" style="ime-mode:Disabled;"/> </td>
							<td class="coltext">性别</td>
							<td class="colinput">
								<ehr:dic-list dicmeta="GBT226112003"  name="gender"/>
							</td>
							
						</tr>
						<tr>
						<td class="coltext" >上报时间</td>
							<td class="colinput">
								<tag:dateInput name="reportCreateStartDate" id="reportCreateStartDate" onlypast="true" reg="{'required':true}" style="width:35%;"/>
							~
								<tag:dateInput name="reportCreateEndDate" id="reportCreateEndDate" onlypast="true" reg="{'required':true}" style="width:35%;"/>
							</td>
						
							<td class="coltext">年龄段</td>
							<td class="colinput">
								<tag:numberInput maxlength="3" style="width:35%;"  name="startAge" id="startAge"  /> ~ 
								<tag:numberInput maxlength="3" style="width:35%;"   name="endAge" id="endAge"  /> 岁
							</td>
							<td class="coltext"><ehr:authorize ifAnyGranted="11">上报机构 </ehr:authorize></td>
							<td class="colinput"><ehr:authorize ifAnyGranted="11">
								<ehr:org-type-list id="createOrganCode" name="reportCreateOrganCode" type="hospital,centre"></ehr:org-type-list>
							</ehr:authorize></td>
						</tr>
					<tr>
						<td colspan="5"></td>
						<td align="left"><input type="button" id="reportCard_search_btn" value="查询" onclick="" class="search_btn" /></td>
					</tr>
				</tbody>
				</table>
				  <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span  class="ico-bottom" id="slideTable">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			
			</form>
		</div>
	
	<div id="list_datagrid" 	class="repeattable">
	</div>
</div>

<div id="input_view" style="display: none">
</div>

	


