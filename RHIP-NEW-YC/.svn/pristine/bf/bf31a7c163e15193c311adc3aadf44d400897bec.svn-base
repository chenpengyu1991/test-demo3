<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/mdm/orgTransferLog/villagesearch.js" type="text/javascript"></script>


<div class="section">
    <div class="searchBox">
        <input type="hidden" id="pageIndex" value="${pageIndex}">
 		<form id="form_search">
			<table id="targetSearch">
				<colgroup>
                	<col style="width: 10%; min-width: 60px;"/>
                    <col style="width: 20%; min-width: 80px;"/>
					<col style="width: 10%; min-width: 60px;"/>
                    <col style="width: 20%; min-width: 120px;"/>
                    <col style="width: 10%; min-width: 60px;"/>
                    <col style="width: 20%; min-width: 120px;"/>
				</colgroup>
				    <tr>
	                   <td class="col-text" align="right">模块功能&nbsp;</td>
					   <td class="col-input">
					      <select id="moduleName" name="moduleName" style="width: 120px;" onchange="villagetransferLogSearch.changeModule()" >
						  <option value="">请选择类别</option>
					      <c:forEach var="mo" items="${moList}" varStatus="zhName">
							  <option value="${mo}">${mo}</option>
						  </c:forEach>
						  </select>
					   </td>
				
                    	<td class="col-text">迁出村委会</td>
                        <td class="col-input">
                           <tag:autoSelect name="itemCode" id="moveOutVillage"></tag:autoSelect>
                        </td>
                        
                        <td class="col-text">迁入机构</td>
                        <td class="col-input">
                           <tag:autoSelect name="moveInOrgan" id="moveInOrgan"></tag:autoSelect>
                       </td>
					</tr>
                    <tr>
                      	<td class="col-text" align="right">操作者&nbsp;</td>
						<td class="col-input"><input type="text" name="operatorname"/></td>
                        
						<td class="col-text" align="right">迁出日期</td>
						<td class="col-input">
							<input type="text" name="beginTime" id="beginTime" value="" onClick="WdatePicker({dateFmt:'yyyy/MM/dd'})" style="width: 100px;"/>
					      	~
							<input type="text" name="endTime" id="endTime" value="" onClick="WdatePicker({dateFmt:'yyyy/MM/dd'})" style="width: 100px;"/>
						</td> 					
 					    <td class="col-text"><div id="illness1" style="display: none">疾病名称</div></td>
		                <td class="col-input">
		                 <div id="illness2" style="display: none">
		               		 <ehr:dic-list width="156px" type="true" id="disTypeSelect" name="diseaseType" dicmeta="DMD00004"/>
		            	 </div>
		             	</td>	
                    </tr>
                    <tr>
                    	<td class="col-text" align="right">
                    		<div id="person1">姓名&nbsp;</div>
                    		<div id="activity1" style="display: none">活动主题&nbsp;</div>
                    	</td>
						<td class="col-input">
							<div id="person2"><input type="text" name="name"/></div>
							<div id="activity2" style="display: none;"><input type="text" name="activityName"/></div>
						</td>
                        <td class="col-text" align="right"><div id="person3">身份证号</div></td>
                        <td class="col-input"><div id="person4"><input type="text" name="idcard"/></div></td>
						<td nowrap="nowrap" align="center" colspan="2" valign="bottom" >
					      	<input type="button" value="查询" class="search_btn" id="transferOperationLogQuery" />
						</td>
                    </tr>
			</table>
			<table>
				<tr>
					<td colspan="4" class="col-bottom">
						<span onclick="util.toggle(this,'targetSearch')" class="ico-bottom">&nbsp;</span>
					</td>
				</tr>
			</table>
		</form>
    </div>
    <div id="transferOperationLogList">
    </div>
</div>