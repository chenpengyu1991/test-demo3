<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/cdm/reportCard/delRepeatCard/repeatCard.js" type="text/javascript"></script>

<div class="section" id="list_view">
	<div class="toolbar">
          <a href="javascript:void(0)" ><b ></b></a>
    </div>
		<div class="searchbox searchSection x-admin-sm" style="width: 100%" >
			<form method="post" id="form_search">
				<table style="" id="searchTable">
				<colgroup>
					<col style="min-width: 70px;width:10%">
					<col style="min-width: 140px;width:23%">
					<col style="min-width: 70px;width:10%">
					<col style="min-width: 150px;width:27%">
					<col style="min-width: 70px;width:10%">
					<col style="min-width: 140px;width:23%">
				</colgroup>		
					<tbody>
					  <tr>
						    <td class="coltext" >上报日期</td>
							<td class="colinput">
								<%-- <tag:dateInput name="reportCreateStartDate" id="reportCreateStartDate" onlypast="true" reg="{'required':true}" style="width:36%;"/>
									~
								<tag:dateInput name="reportCreateEndDate" id="reportCreateEndDate" onlypast="true" reg="{'required':true}" style="width:36%;"/> --%>
								<input type="text" class="layui-input x-admin-sm-date" reg="{'required':true}" placeholder="开始日" name="reportCreateStartDate" id="reportCreateStartDate" style="width: 38.5%;padding-left: 0px;" />~
          				        <input type="text" class="layui-input x-admin-sm-date" reg="{'required':true}" placeholder="截止日" name="reportCreateEndDate" id="reportCreateEndDate" style="width: 38.5%;padding-left: 0px;" />
							</td>
							
						    <td class="coltext"  >查重条件</td>
							<td class="colinput" >
								<input type="radio" name="repeatConditions" value="1" checked="checked"/>姓名和出生日期
								<input type="radio" name="repeatConditions" value="2" />姓名
								<input type="radio" name="repeatConditions" value="3" />出生日期
							</td>
							
							<td class="coltext">性别</td>
							<td class="colinput">
								<ehr:dic-list dicmeta="GBT226112003"  name="gender"/>
							</td>
							
						</tr>
						<tr>
							<td class="coltext" >姓名</td>
							<td class="colinput"><input type="text" name="name" id="personName" /></td>
							<td class="coltext" >身份证号</td>
							<td class="colinput">	<tag:idcardInput name="idcard"  style="ime-mode:Disabled;" id="idcard"></tag:idcardInput>
							<input type="button" id="check-submit-btn" value="读卡" style="width: 40px;">
							</td>
							<td class="coltext"  >患病类型</td>
							<td class="colinput">
								<ehr:dic-list type="true"  id="disTypeSelect" name="reportType"  width="140px" dicmeta="DMD00004" />
							</td>
						</tr>
						<tr>
							<td colspan="5"></td>
							<td  align="left" >
										<%-- <input type="button" id="repeat_reportCard_search_btn" value="查询" onclick="" class="search_btn"/> --%>
										<button class="layui-btn layui-btn-sm"  id="repeat_reportCard_search_btn"><i class="layui-icon">&#xe615;</i>查询</button>
							</td>
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
<div id="input_view"  class="postdiv">
</div>

