<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	require(['views/wsMonitor/clientRegister/search'],function(clientRegisterSearch){
		clientRegisterSearch.load();
	});
</script>

<div class="section">
	<div class="toolbar">
		<a href="javascript:void(0)" id="clientInfoAddBut"><b class="xinz">新增</b></a>
		<a href="javascript:void(0)" id="clientInfoBackBut" style="display: none;"><b class="fanhui">返回</b></a>
		<a href="javascript:void(0)" id="clientInfoSaveBut" style="display: none;"><b class="baocun">保存</b></a>
	</div>
	<div id="searchDiv" class="searchbox">
		<form id="clientInfoForm" name="clientInfoForm" action="" method="post">
			<table id="clientInfoSearch">
				<colgroup>
                    <col style="width: 15%"/>
                    <col style="width: 25%"/>
                    <col style="width: 15%"/>
                    <col style="width: 25%"/>
					<col style="width: 20%"/>
				</colgroup>
     			<tbody>
				<tr>
					<td class="coltext">机构名称</td>
					<td class="colinput">
						<tag:autoSelect name="orgCode" id="orgCode" codeValue="${orgCode}" style="width:200px" ></tag:autoSelect>
					</td>
					<td class="coltext">来访机器IP地址</td>
					<td class="colinput">
                         <input type="text" id="userIp" name="userIp" style="width: 200px;"/>
                    </td>
				</tr>
				<tr>
					<td class="coltext">接口名称(KEY)</td>
					<td class="colinput">
						<select name="serviceId">
							<option value="">请选择</option>
							<c:forEach var="serviceInfo" items="${serviceInfos}">
								<option value="${serviceInfo.id}">${serviceInfo.webServiceName}</option>
							</c:forEach>
						</select>
					</td>
					<td class="coltext">禁用标志</td>
					<td class="colinput">
						<ehr:dic-list name="isOff" dicmeta="FS990020" width="100px;" code="1,0"/>
					</td>
					<td class="colinput">
						<input type="button" id="clientInfoSearchBut" value="查询" class="search_btn" />
					</td>
				</tr>
				</tbody>
			</table>
         	<table>
				<tr>
					<td colspan="4" class="colbottom">
						<span onclick="clientRegisterSearch.toggle(this,'clientInfoSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
         	</table>
		</form>
 	</div>
	<div id="listDiv"></div>
	<div id="detailDiv"></div>
</div>