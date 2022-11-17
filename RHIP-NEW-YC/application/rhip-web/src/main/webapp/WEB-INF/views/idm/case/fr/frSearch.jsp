<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ page import="com.founder.rhip.ehr.common.EHRConstants" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<jsp:include page="../../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>" />
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>" />
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>" />
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>" />
<c:set var="ZCRB" value="<%=RoleType.ZCRB.getValue()%>" />
<c:set var="JK_CODE" value="<%=EHRConstants.JK_CODE%>"/>
<script src="${pageContext.request.contextPath}/js/views/idm/case/frSearch.js" type="text/javascript"></script>
<!-- <script type="text/javascript">
    require(['views/idm/case/frts'],function(caseFrts){
        caseFrts.load();
    });
</script> -->
<%--<script src="${pageContext.request.contextPath}/js/views/idm/case/frts.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<div class="section"  id="top_all">
	<div class="toolbar">
		<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">传染病及突发事件</a>
		        <a href="javascript:void(0)">疫情处置</a>
		        <a>
		          <cite>随访管理</cite></a>
		      </span>
		</div>
	</div>
		<div class="searchbox searchSection x-admin-sm">
			<form id="reportSearchForm">				
                <table id="caseSearch" >
				<colgroup>
                    <col style="min-width:70px; width: 10%;"/>
                    <col style="min-width:160px; width: 27%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                    <col style="min-width:160px; width: 27%;"/>
                    <col style="min-width:60px; width: 10%;"/>
				</colgroup>		
					<tbody>
						<tr>
							<td class="coltext">身份证号</td>
							<td class="colinput">
								<tag:idcardInput name="idcard" id="idCard" cssClass="x-layui-input"></tag:idcardInput>&nbsp;
                                <input type="button" id="check-submit-btn" value="读卡" style="width: 40px;">
                                <input type="hidden" id="pageIndex" value="">
							</td>
                            <td class="coltext">患者姓名</td>
                            <td class="colinput"><input type="text" name="name" class="x-layui-input" /></td>
						</tr>
                        <tr>
                            <td class="coltext">出生日期</td>
                            <td class="colinput">
                                <%-- <tag:dateInput  id="birthBeginDate" name="birthBeginDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput>
                                ~<tag:dateInput nullToToday="true" id="birthEndDate" name="birthEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput> --%>
                                
                                <input type="text" class="layui-input x-admin-sm-date"  name="birthBeginDate" id="birthBeginDate" style="width: 36%;" > ~
                            <input type="text" class="layui-input x-admin-sm-date"  name="birthEndDate" id="birthEndDate" style="width: 36%;">
                            </td>
                           <%--  <td class="coltext">填写单位</td>
                            <td class="colinput">
                                <ehr:org-type-list id="surveyOrgCode" name="surveyOrgCode" type="hospital,centre,other,station"  code="${fillOrganCode}"  codeOther="46714114-9"/>
                            </td> --%>
                            <td class="coltext">档案状态</td>
                            <td class="colinput">
                                <ehr:dic-radio name="logoff" dicmeta="PH00031" isDefault="Y" value="${logoff}"/>
                            </td> 
                        </tr>
                        <tr class="advanceSearchSection" style="display: none;">
                            <%--<td class="coltext">疾病名称</td>--%>
                            <%--<td class="colinput">--%>
                                <%--<select id="infectiousCode" name="infectiousCode"></select>--%>
                            <%--</td>--%>
                            <td class="coltext">随访状态</td>
                            <td class="colinput">
                                <ehr:dic-radio code="" name="frStatus" dicmeta="IDM00628" value="${caseStatus==null ? 1 : caseStatus}" isDefault="Y"/>
                            </td>
                            <ehr:authorize ifAnyGranted="${ZXCRB}">
                                <td class="coltext">管理单位</td>
                                <td class="colinput">
                                <ehr:dic-org-list name="surveyOrgCode" isShowOneself="true" cssClass="x-layui-input"/>
                           	</ehr:authorize>
                           	<ehr:authorize ifAnyGranted="${JKFYK},${ADMIN}">
                                <td class="coltext">管理单位</td>
                                <td class="colinput">
                                <ehr:org-type-list id="fillOrganCode" name="surveyOrgCode" type="hospital,centre,other,station" code="${fillOrganCode}"  codeOther="${JK_CODE}" cssClass="x-layui-input"/>
                           	</ehr:authorize>
                           	<ehr:authorize ifAnyGranted="${YYCRB},${ZCRB}">
                                <td class="coltext"></td>
                                <td class="colinput"></td>
                           	</ehr:authorize>
                        </tr>
                        <tr>
                            <td class="righttd" colspan="5">
                                <%-- <input type="button" value="查询" onclick="frSearch.search(1)" class="search_btn"/> --%>
                                <button class="layui-btn layui-btn-sm" id="frSearchButton" ><i class="layui-icon">&#xe615;</i>查询</button>
                                <button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn" ><i class="iconfont">&#x60010;</i>高级</button>
                            </td>
                        </tr>
					</tbody>
				</table>
                <table>
	                <tr>
	                    <td colspan="6" class="colbottom">
	                          <span onclick="frSearch.toggle(this,'caseSearch')" class="ico-bottom">&nbsp;</span>
	                    </td>
	                </tr>
				</table>

			 </form>
		</div>
		<div id="caseResultDiv">
        </div>
</div>
<div id="detailDiv"></div>

<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        laydate.render({
          elem: '#birthBeginDate' 
       	   ,format: 'yyyy/MM/dd'
       	   ,max:0
        });

        laydate.render({
          elem: '#birthEndDate'
           ,format: 'yyyy/MM/dd'
        	   ,max:0
        });
        
      
      });

    </script>