<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<c:set var="SQZX" value="03" />
<c:set var="FYK" value="10" />
<c:set var="SJYYFBK" value="19" />
<script src="${pageContext.request.contextPath}/js/views/idm/case/tsSearch.js" type="text/javascript"></script>
<!-- <script type="text/javascript">
    require(['views/idm/case/frts'],function(caseFrts){
        caseFrts.load();
    });
</script> -->
<script src="${pageContext.request.contextPath}/js/views/idm/case/frts.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<div class="section"  id="top_all">
    <div class="searchbox">
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
                        <tag:idcardInput name="idcard" ></tag:idcardInput>
                        <input type="hidden" id="pageIndex" value="">
                    </td>
                    <td class="coltext">患者姓名</td>
                    <td class="colinput"><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td class="coltext">出生日期</td>
                    <td class="colinput">
                        <tag:dateInput nullToToday="true" id="birthBeginDate" name="birthBeginDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput>
                        ~<tag:dateInput nullToToday="true" id="birthEndDate" name="birthEndDate" pattern="yyyy/MM/dd"  onlypast="true"  style="width: 36%;"></tag:dateInput>
                    </td>
                    <td class="coltext">填写单位</td>
                    <td class="colinput">
                        <ehr:org-type-list id="surveyOrgCode" name="surveyOrgCode" type="hospital,centre,other"  code="${fillOrganCode}"  codeOther="46714114-9"/>
                    </td>
                </tr>
                <tr>
                    <td class="coltext">疾病名称</td>
                    <td class="colinput">
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
                    </td>
                    <td class="coltext">采样状态</td>
                    <td class="colinput">
                        <ehr:dic-radio  name="tsStatus" dicmeta="PH00020" value="${caseStatus==null ? 1 : caseStatus}" isDefault="Y"/>
                    </td>
                    <td>
                        <input type="button" value="查询" onclick="tsSearch.search(1)" class="search_btn"/>
                    </td>
                </tr>
                <tr>
                    <td class="coltext">档案状态</td>
                    <td class="colinput">
                        <ehr:dic-radio name="logoff" dicmeta="PH00031" isDefault="Y" value="${logoff}"/>
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
    <div id="caseResultDiv">
    </div>

</div>
<div id="detailDiv"></div>

