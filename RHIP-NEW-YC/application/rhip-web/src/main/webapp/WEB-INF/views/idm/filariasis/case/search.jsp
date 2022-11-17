<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<script src="${pageContext.request.contextPath}/js/views/idm/filariasis/filariasisCase.js" type="text/javascript"></script>
<div>
	<div id="topAll">
		<div class="searchBox searchSection x-admin-sm">
			<form id="caseSearchForm">
                <table id="caseSearch" >
				<colgroup>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:100px; width: 23%;"/>
					<col style="min-width:70px; width: 10%;"/>
					<col style="min-width:100px; width: 23%;"/>
					<col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:181px; width: 23%;"/>
				</colgroup>		
					<tbody>
						<tr>
                            <input type="hidden" id="pageIndex" value="${pageIndex}"/>
							<td class="coltext">患者姓名</td>
							<td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
                            <%--<td class="coltext">身份证号</td>--%>
                            <%--<td class="colinput"><input type="text" name="idcard" /></td>--%>
                            <td class="coltext">患者性别</td>
                            <td class="colinput">
                                <ehr:dic-list id="gender" name="gender" dicmeta="GBT226112003" code="1,2" cssClass="x-layui-input"/>
                            </td>
						</tr>
                        <tr>
                            <td class="coltext">症状状态</td>
                            <td class="colinput">
                                <ehr:dic-list id="" name="feature" dicmeta="IDM00276" cssClass="x-layui-input"/>
                            </td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>
								<button class="layui-btn layui-btn-sm" id="caseBtnSearch"><i class="layui-icon">&#xe615;</i>查询</button>
                            </td>
                        </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="idmCommon.toggle(this,'caseSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>
			 </form>
		</div>
		<div id="caseListDiv"></div>
	</div>
	<div id="caseDetailDiv" ></div>
</div>

