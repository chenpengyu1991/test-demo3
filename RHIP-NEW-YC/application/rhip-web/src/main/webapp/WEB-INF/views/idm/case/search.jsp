<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<c:set var="JKFYK" value="<%=RoleType.JKFYK.getValue()%>"/>
<c:set var="ZXCRB" value="<%=RoleType.ZXCRB.getValue()%>"/>
<c:set var="YYCRB" value="<%=RoleType.YYCRB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/case/search.js" type="text/javascript"></script>

<div class="section" id="top_all">
    <div class="toolbar">
    <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">传染病及突发事件</a>
		        <a href="javascript:void(0)">疫情处置</a>
		        <a>
		          <cite>个案调查</cite></a>
		      </span>
		</div>
    </div>
    <div class="searchbox searchSection x-admin-sm">
        <form id="reportSearchForm">
            <table id="caseSearch">
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
                        <input type="hidden" id="tab" name="tab" value="${tab}">
                    </td>
                    <td class="coltext">患者姓名</td>
                    <td class="colinput"><input type="text" name="name" class="x-layui-input"/></td>
                </tr>
                <tr>
                    <td class="coltext">出生日期</td>
                    <td class="colinput">
                        <%-- <tag:dateInput reg='{"compare":["birthEndDate","le","开始时间不能大于结束时间"]}' id="birthBeginDate" name="birthBeginDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput>
                        ~<tag:dateInput reg='{"compare":["birthBeginDate","ge","结束时间不能小于开始时间"]}' id="birthEndDate" name="birthEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput>
                    --%>
                        <input type="text" class="layui-input x-admin-sm-date"
                               reg='{"compare":["birthEndDate","le","开始时间不能大于结束时间"]}' id="birthBeginDate"
                               name="birthBeginDate" style="width: 45%;padding-left: 0px;"/> ~
                        <input type="text" class="layui-input x-admin-sm-date"
                               reg='{"compare":["birthBeginDate","ge","结束时间不能小于开始时间"]}' id="birthEndDate"
                               name="birthEndDate" style="width: 45%;padding-left: 0px;"/>
                    </td>
                    <td class="coltext">档案状态</td>
                    <td class="colinput">
                        <ehr:dic-radio name="logoff" dicmeta="PH00031" isDefault="Y" value="${logoff}"/>
                    </td>

                </tr>
                <tr class="advanceSearchSection" style="display: none;">
                    <td class="coltext">疾病名称</td>
                    <td class="colinput">
                        <select id="infectiousCode" name="infectiousCode" class="x-layui-input"></select>
                    </td>
                    <%--  <td class="colinput">
                         <ehr:authorize ifAnyGranted="${JKFYK}">
                             <select id="infectiousCode" name="infectiousCode"></select>
                         </ehr:authorize>
                         <ehr:authorize ifNotGranted="${JKFYK}">
                             <select name="infectiousCode">
                             <option value="">请选择</option>
                             <option value="101">鼠疫</option>
                             <option value="102">霍乱</option>
                             <option value="201">传染性非典型性肺炎</option>
                             <option value="2031">病毒性肝炎 甲型</option>
                             <option value="2032">病毒性肝炎 乙型</option>
                             <option value="2033">病毒性肝炎 丙型</option>
                             <option value="2034">病毒性肝炎 戊型</option>
                             <option value="2035">病毒性肝炎 未分型</option>
                             <option value="205">人感染高致病性禽流感</option>
                             <option value="206">甲型H1N1流感</option>
                             <option value="208">流行性出血热</option>
                             <option value="209">狂犬病</option>
                             <option value="211">登革热</option>
                             <option value="2121">炭疽 肺炭疽</option>
                             <option value="2122">炭疽 皮肤炭疽</option>
                             <option value="2123">炭疽 未分型</option>
                             <option value="2131">痢疾 细菌性</option>
                             <option value="2132">痢疾 阿米巴性</option>
                             <option value="2151">伤寒 伤寒</option>
                             <option value="2152">伤寒 副伤寒</option>
                             <option value="216">流行性脑脊髓膜炎</option>
                             <option value="220">猩红热</option>
                             <option value="221">布鲁氏菌病</option>
                             <option value="224">钩端螺旋体病</option>
                             <option value="311">手足口病</option>
                             </select>
                         </ehr:authorize>
                     </td> --%>
                    <td class="coltext">处置状态</td>
                    <td class="colinput">
                        <ehr:dic-radio name="caseStatus" dicmeta="IDM00619"
                                       value="${caseStatus == null ? 1 : caseStatus}" isDefault="Y"/>
                    </td>
                </tr >
                <tr class="advanceSearchSection" style="display: none;">
                    <%--  <ehr:authorize ifAnyGranted="03">
                     <td class="coltext">填写单位</td>
                     <td class="colinput">
                         <ehr:dic-org-list name="surveyOrgCode" isShowOneself="true"/>
                     </td>
                 </ehr:authorize> --%>
                    <ehr:authorize ifAnyGranted="01,10">
                        <td class="coltext">填写单位</td>
                        <td class="colinput">
                                <%-- <ehr:org-type-list id="surveyOrgCode" name="surveyOrgCode" type="hospital,centre,other,station" code="${fillOrganCode}"  codeOther="46714114-9"/>	 --%>
                            <ehr:org-type-list id="modifySurveyOrg" name="modifySurveyOrg"
                                               type="hospital,centre,other,station" code="${modifySurveyOrg}"
                                               codeOther="46714114-9"/>
                        </td>
                    </ehr:authorize>
                    <%-- <td class="coltext">填写单位</td>
                    <td class="colinput">

                        <ehr:authorize ifAnyGranted="02,03,19">
                            <ehr:dic-org-list name="surveyOrgCode" isShowOneself="true"/>
                        </ehr:authorize>
                        <ehr:authorize ifAnyGranted="01,10">
                            <ehr:org-type-list id="surveyOrgCode" name="surveyOrgCode" type="hospital,centre,other,station" code="${fillOrganCode}"  codeOther="46714114-9"/>
                        </ehr:authorize>

                    </td> --%>

                </tr>
                <tr>
                    <td colspan="5" class="righttd">
                        <button class="layui-btn layui-btn-sm" id="caseSearchId"><i class="layui-icon">&#xe615;</i>查询</button>
                        <button class="layui-btn layui-btn-sm" id="perAdvanceSearchConditionBtn" ><i class="iconfont">&#x60010;</i>高级</button>
                    </td>
                </tr>
                </tbody>
            </table>
            <table>
                <tr>
                    <td colspan="6" class="colbottom">
                        <span onclick="caseSearch.toggle(this,'caseSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>

        </form>
    </div>
    <div class="toolbarSection x-admin-sm">
        <a href="javascript:void(0)" id="btnExport"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe67d;</i>导出名单</button></a>
    </div>
    <div id="caseResultDiv">
    </div>
</div>
<div id="detailDiv"></div>

<script type="text/javascript">
    layui.use('laydate', function () {
        var laydate = layui.laydate;

        laydate.render({
            elem: '#birthBeginDate'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

        laydate.render({
            elem: '#birthEndDate'
            , format: 'yyyy/MM/dd'
            , max: 0
        });

    });

</script>