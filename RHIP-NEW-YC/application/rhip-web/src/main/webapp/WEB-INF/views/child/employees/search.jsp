<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/ehr/child/employees/search.js" type="text/javascript"></script>

<div class="section" id="child-exam-list-box">
    <div class="searchBox"><div class="toolbar">
    <ehr:authorize ifAnyGranted="04,03">
    	
				          <a href="javascript:void(0)" id="followup-add-btn"><b class="xinz">新增</b></a>
				          
    </ehr:authorize>
    <a href="javascript:void(0)" id="addHealthCard"><b class="xinz">生成健康证</b></a></div>
        <input type="hidden" id="pageIndex" value="${pageIndex}">
        <input type="hidden" id="searchType" value="${searchType}">
        <form id="searchForm">
            <table id="searchTable">
                 <colgroup>
                    <col style="width: 10%; min-width: 70px;"/>
                    <col style="width: 23%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 15%; min-width: 70px;"/>
                    <col style="width: 18%; min-width: 70px;"/>
                    <col/>
                </colgroup> 
                <tbody>
                <tr>
                
                	
                   
                    
                    <td class="col-text">身份证</td>
                    <td class="col-input">
                        <input type="text" name="idCard" style="width: 90%">
                    </td>
                    
                    <td class="col-text">姓名</td>
                    <td class="col-input">
                        <input type="text" name="name">
                    </td>
                    <td class="col-text">性别</td>
                    <td class="col-input">
                        <ehr:dic-list name="gender" dicmeta="GBT226112003"></ehr:dic-list>
                    </td>
                </tr>
                <tr>
                      
                    <td class="col-text">体检日期</td>
                    <td class="col-input" >
                        <tag:dateInput name="createDate" onlypast="true" style="width:42%;"></tag:dateInput>
                        ~
                        <tag:dateInput name="createDateEnd" id="createDateEnd" style="width:41%;" onlypast="true"/>
                    </td>
                    <td class="col-text">机构</td>
                    <td class="col-input" colspan="3">
                        
                         <%-- <tag:autoSelect name="organCode" id="organCode" style="width:180px" ></tag:autoSelect>  --%>
                        <ehr:authorize ifAnyGranted="03">
                            <ehr:dic-org-list name="organCode" isShowOneself="true"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="02">
                            <ehr:dic-org-list name="organCode" defaultval="Y"/>
                        </ehr:authorize>
                         <ehr:authorize ifAnyGranted="04">
                            <ehr:dic-town-centre-station centreName="searchCenter" stationName="searchStation" townName="searchTown" width="163px;" isShowOneself="true" includeTownCodes="${currentLoginInfo.organization.gbCode}"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="01,11,62,63">
                           <input type="hidden" id="selectCodeType" name="genreCode"/>
                            <tag:autoSelect name="organCode" id="organCode" style="width:170px" /> 
                            <%-- ehr:dic-town-centre-station centreName="searchCenter" stationName="searchStation" townName="searchTown" width="180px;" /> --%>
                        </ehr:authorize>
                    </td>
                </tr>
                <tr>
                	<td align="right" colspan="6">
                        <input type="button" id="btnSearch" value="查询" onclick="" class="search_btn" />
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="4" class="col-bottom"><span onclick="toggle(this,'searchTable')" class="ico-bottom">&nbsp;</span></td>
                </tr>
            </table>
        </form>
    </div>
    <div id="employeesListDiv">
        <%--<jsp:include page="${listpath}"></jsp:include>--%>
    </div>
</div>
<div id="child-exam-input-box"></div>