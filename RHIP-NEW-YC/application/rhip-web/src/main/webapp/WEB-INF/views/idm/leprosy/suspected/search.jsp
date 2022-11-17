<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<%@ page import="com.founder.rhip.idm.common.LeprosyStatus" %>
<c:set var="SUSPECTED" value="<%=LeprosyStatus.SUSPECTED.getValue()%>" />
<c:set var="CASE" value="<%=LeprosyStatus.CASE.getValue()%>"/>

<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="JKXAK" value="<%=RoleType.JKXAK.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/leprosy/leprosy_common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/leprosy/suspected.js" type="text/javascript"></script>

<div>
	<div id="top_allSuspected">
		<div class="toolbar">
			<label>待填疑似报卡患者:<a href="javascript:void(0)" onclick="suspected.loadNotReportLeprosy();"><span id="notCount"></span> </a></label>
	         <a href="javascript:void(0)" onclick="javascript:leprosyCommon.add('',${SUSPECTED},'1','Suspected')"><b class="xinz">新增</b></a>
	    </div>
	<div class="searchbox">
		<form id="suspectedSearchForm">
          <table id="suspectedSearch" >
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:100px; width: 23%;"/>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:183px; width: 23%;"/>
				</colgroup>	
				<tbody>
					<tr>
						<td class="coltext">患者姓名</td>
						<td class="colinput"><input type="text" name="name" /></td>
                         <td class="coltext">患者性别</td>
                         <td class="colinput">
                             <ehr:dic-list id="gender" name="gender" dicmeta="GBT226112003" code="1,2" />
                         </td>
                         <td class="coltext">上报日期</td>
                         <td class="colinput">
                              <tag:dateInput nullToToday="true" name="modifySurveyDateBegin" pattern="yyyy/MM/dd"  onlypast="true" style="width: 36%;"></tag:dateInput>
                              ~<tag:dateInput nullToToday="true" name="modifySurveyDateEnd" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput>
                          </td>
					</tr>
                       <tr>
                           <td class="coltext">报卡状态</td>
                           <td class="colinput">
                               <select name="status">
                               		<option value="">请选择</option>
                               		<option value="1">待处理</option>
                               		<option value="2">已处理</option>
                               </select>
                           </td>
                           <td class="coltext">诊断结果</td>
                           <td class="colinput">
                               <ehr:dic-list name="result" dicmeta="IDM00231" code="5,6,7"/>
                           </td>
                           <td></td>
                           <td>
                               <input type="button" id="suspectedBtnSearch" value="查询" onclick="" class="search_btn"/>
                           </td>
                       </tr>
				</tbody>
			</table>
               <table>
                <tr>
                    <td colspan="6" class="colbottom">
                          <span onclick="leprosyIndex.toggle(this,'suspectedSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
			</table>
		 </form>
	</div>
	<div id="listDivSuspected"></div>
	</div>
	<div id="detailDivSuspected"></div>
</div>

