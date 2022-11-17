<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="${pageContext.request.contextPath}/js/util/jquery.jqprint-0.3.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/addPersonInfo.js" type="text/javascript" ></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<link href="${pageContext.request.contextPath}/css/views/ehrbrowser/personalRecord/phyExam.css" type="text/css"  rel="stylesheet" />
<%--<i class="pop_No">
		 <a class="bc" id="button_print">打印</a>
</i>--%>
<div class="postcontent" id="printDiv">

<form id="personInfoForm">
<div style="height: 25px">
<span class="span_floatleft"><b>姓名:</b>
    <c:choose>
        <c:when test="${not empty brwAnonymousSetStr}">
            <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                <c:out value="${fn:substring(personBasicInfoDto.personInfo.name, 0, 1)}" />
                <c:choose>
                    <c:when test="${fn:length(personBasicInfoDto.personInfo.name) ==2}">${ANONYMOUS_X}</c:when>
                    <c:when test="${fn:length(personBasicInfoDto.personInfo.name) ==3}">${ANONYMOUS_2X}</c:when>
                    <c:otherwise>${ANONYMOUS_3X}</c:otherwise>
                </c:choose>
            </ehr:authorize>
            <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                ${personBasicInfoDto.personInfo.name}
            </ehr:authorize>
        </c:when>
        <c:otherwise>${personBasicInfoDto.personInfo.name}</c:otherwise>
    </c:choose>
</span>
 <c:choose>
		<c:when test="${not empty personBasicInfoDto.personInfo.healthFileNoHtml}">
			${personBasicInfoDto.personInfo.healthFileNoHtml}
		</c:when>
		<c:otherwise>
			<s class="pop_No">
				<span class="text"><b>编号：</b></span>
				<span></span><span></span><span></span><span></span><span></span>
				<span class="line">-</span>
				<span></span><span></span><span></span>
				<span class="line">-</span>
				<span></span><span></span><span></span>
				<span class="line">-</span>
				<span></span><span></span><span></span><span></span>
			</s>
		</c:otherwise>
	</c:choose>
</div>
<div class="table-01">
<table border="0" cellpadding="0" cellspacing="0" style="clear:both;">
<tr>
    <th colspan="2">性别</th>
    <td colspan="2">
        <ehr:dic dicmeta="GBT226112003" code="${personBasicInfoDto.personInfo.gender}"/>
    </td>
    <th colspan="2">出生日期</th>
    <td colspan="2">
        <c:if test="${not empty brwAnonymousSetStr}">
            <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                YYYY/MM/DD
            </ehr:authorize>
            <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                <fmt:formatDate value='${personBasicInfoDto.personInfo.birthday}' pattern='yyyy/MM/dd'/>
            </ehr:authorize>
        </c:if>
        <c:if test="${empty brwAnonymousSetStr}">
            <fmt:formatDate value='${personBasicInfoDto.personInfo.birthday}' pattern='yyyy/MM/dd'/>
        </c:if>
    </td>
</tr>
<tr>
    <th colspan="2">身份证号</th>
    <td colspan="2">
        <c:if test="${not empty brwAnonymousSetStr}">
            <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                ${fn:replace(personBasicInfoDto.personInfo.idcard,fn:substring(personBasicInfoDto.personInfo.idcard,6,14), ANONYMOUS_XS)}
            </ehr:authorize>
            <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                ${personBasicInfoDto.personInfo.idcard}
            </ehr:authorize>
        </c:if>
        <c:if test="${empty brwAnonymousSetStr}">
            ${personBasicInfoDto.personInfo.idcard}
        </c:if>
    </td>
    <th colspan="2">工作单位</th>
    <td colspan="2">${personBasicInfoDto.personInfo.unitName }</td>
</tr>
<tr>
    <th colspan="2">本人电话</th>
    <td  colspan="6">
        <c:if test="${not empty brwAnonymousSetStr}">
            <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                ${fn:substring(personBasicInfoDto.personInfo.phoneNumber,0,3)}${ANONYMOUS_XS}
            </ehr:authorize>
            <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                <c:out value="${personBasicInfoDto.personInfo.phoneNumber}"></c:out>
            </ehr:authorize>
        </c:if>
        <c:if test="${empty brwAnonymousSetStr}">
            <c:out value="${personBasicInfoDto.personInfo.phoneNumber}"></c:out>
        </c:if>
    </td>
</tr>
<tr>
	<th colspan="2">联系人姓名</th>
    <td colspan="2">
        <c:choose>
            <c:when test="${not empty brwAnonymousSetStr}">
                <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                    <c:out value="${fn:substring(personBasicInfoDto.personInfo.firstGuardian, 0, 1)}" />
                    <c:choose>
                        <c:when test="${fn:length(personBasicInfoDto.personInfo.firstGuardian) ==2}">${ANONYMOUS_X}</c:when>
                        <c:when test="${fn:length(personBasicInfoDto.personInfo.firstGuardian) ==3}">${ANONYMOUS_2X}</c:when>
                        <c:otherwise>${ANONYMOUS_3X}</c:otherwise>
                    </c:choose>
                </ehr:authorize>
                <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                    ${personBasicInfoDto.personInfo.firstGuardian}
                </ehr:authorize>
            </c:when>
            <c:otherwise>${personBasicInfoDto.personInfo.firstGuardian}</c:otherwise>
        </c:choose>
    </td>
    <th colspan="2">紧急联系人电话</th>
    <td colspan="2">
        <c:if test="${not empty brwAnonymousSetStr}">
            <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                ${fn:substring(personBasicInfoDto.personInfo.guardianPhoneOne,0,3)}${ANONYMOUS_XS}
            </ehr:authorize>
            <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                <c:out value="${personBasicInfoDto.personInfo.guardianPhoneOne}"></c:out>
            </ehr:authorize>
        </c:if>
        <c:if test="${empty brwAnonymousSetStr}">
            <c:out value="${personBasicInfoDto.personInfo.guardianPhoneOne}"></c:out>
        </c:if>
    </td>
</tr>
<tr>
    <th colspan="2">常住类型</th>
    <td colspan="2">
        <ehr:dic dicmeta="FS10005" code="${personBasicInfoDto.personInfo.householdType}"/>
    </td>
    <th colspan="2">民族</th>
    <td colspan="2">
        <c:if test="${personBasicInfoDto.personInfo.nation eq '01'}">
            汉族
        </c:if>
        <c:if test="${personBasicInfoDto.personInfo.nation ne '01' && not empty personBasicInfoDto.personInfo.nation && personBasicInfoDto.personInfo.nation ne '1'}">
            少数民族：${personBasicInfoDto.personInfo.otherNationDesc}
        </c:if>
    </td>
</tr>
<tr>
    <th colspan="2">血型</th>
    <td colspan="6">
        <ehr:dic dicmeta="CV0450005" code="${personBasicInfoDto.personInfo.aboBloodType}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <c:out value="RH阴性:"></c:out>
            <ehr:dic dicmeta="FS10010" code="${personBasicInfoDto.personInfo.rhBloodType}"/>
    </td>
</tr>
<tr>
    <th colspan="2">文化程度</th>
    <td colspan="6">

        <ehr:dic dicmeta="GBT46582006" code="${personBasicInfoDto.personInfo.education}"/>
    </td>
</tr>
<tr>
    <th colspan="2">职业</th>
    <td colspan="6">
        <ehr:dic dicmeta="GBT6565" code="${personBasicInfoDto.personInfo.occupation}"/>
    </td>
</tr>
<tr>
    <c:choose>
        <c:when test="${personBasicInfoDto.personInfo.gender ne '1'}">
            <th colspan="2">婚姻状况</th>
            <td colspan="2">
                <ehr:dic dicmeta="GBT226122003" code="${personBasicInfoDto.personInfo.marriage}"/>
            </td>
            <th colspan="2">是否孕产妇</th>
            <td colspan="2">
                <ehr:dic dicmeta="FS10281" code="${personBasicInfoDto.personInfo.maternalFlag}"/>
            </td>
        </c:when>
        <c:otherwise>
            <th colspan="2">婚姻状况</th>
            <td colspan="6">
                <ehr:dic dicmeta="GBT226122003" code="${personBasicInfoDto.personInfo.marriage}"/>
            </td>
        </c:otherwise>
    </c:choose>
</tr>
    <c:if test="${personBasicInfoDto.personInfo.gender ne '1' && personBasicInfoDto.personInfo.maternalFlag eq '2'}">
        <tr>
            <th colspan="2">末次月经日期</th>
            <td colspan="2">
                <fmt:formatDate value='${personBasicInfoDto.personInfo.lastMenstrualDate}' pattern='yyyy/MM/dd'/>
            </td>
            <th colspan="2">预产期</th>
            <td colspan="2">
                <fmt:formatDate value='${personBasicInfoDto.personInfo.estimatedDueDate}' pattern='yyyy/MM/dd'/>
            </td>
        </tr>
    </c:if>
<tr>
    <th colspan="2">医疗费用支付方式</th>
    <td colspan="6">
        <ehr:dic dicmeta="CV0710003" code="${personBasicInfoDto.expenseInfoStr}"/>
    </td>
</tr>
<tr>
    <th colspan="2">药物过敏史</th>
    <td colspan="6">
        ${personBasicInfoDto.drugAllergyHistoryFlag eq '1' || personBasicInfoDto.drugAllergyHistoryFlag eq null  ? "无" : ""}
        ${personBasicInfoDto.drugAllergyHistoryFlag eq '2' ? "<b>有</b>:<br />" : ""}
        <ehr:dic dicmeta="CV0501038" code="${personBasicInfoDto.drugAllergyHistoryStr}"/>
        ${personBasicInfoDto.drugAllergyHistoryOtherDesc}
    </td>
</tr>
<tr>
    <th colspan="2">暴露史</th>
    <td colspan="6">
        ${personBasicInfoDto.exposeHistoryFlag eq '1' || personBasicInfoDto.exposeHistoryFlag eq null  ? "无" : ""}
        ${personBasicInfoDto.exposeHistoryFlag eq '2' ? "<b>有</b>:" : ""}
		${personBasicInfoDto.exposeHistory.chemical eq '1' ? "化学品&nbsp;" : ""}
		${personBasicInfoDto.exposeHistory.poison eq '1' ? "毒物&nbsp;" : ""}
		${personBasicInfoDto.exposeHistory.ray eq '1' ? "射线&nbsp;" : ""}
    </td>
</tr>
<tr>
    <th width="7%" rowspan="4">既往史</th>
    <th width="7%">疾病</th>
    <td colspan="6">
        ${personBasicInfoDto.diseaseHistoryFlag eq '1' || personBasicInfoDto.diseaseHistoryFlag eq null  ? '无' : ''}
        ${personBasicInfoDto.diseaseHistoryFlag eq '2' ? '<b>有</b>:' : ''}


            ${personBasicInfoDto.gxy eq '201' ? '<br>高血压' : ''}
            ${not empty personBasicInfoDto.gxyDate ? "确诊时间:":""}<fmt:formatDate value='${personBasicInfoDto.gxyDate}' pattern='yyyy/MM/dd'/>

            ${personBasicInfoDto.tnb eq '202' ? '<br>糖尿病' : ''}
            ${not empty personBasicInfoDto.tnbDate ? "确诊时间:": ""}<fmt:formatDate value='${personBasicInfoDto.tnbDate}' pattern='yyyy/MM/dd'/>

            ${personBasicInfoDto.gxb eq '203' ? '<br>冠心病' : ''}
            ${not empty personBasicInfoDto.gxbDate ? "确诊时间:": ""}<fmt:formatDate value='${personBasicInfoDto.gxbDate}' pattern='yyyy/MM/dd'/>
            ${personBasicInfoDto.fjb eq '204' ? '<br>慢性阻塞性肺疾病' : ''}
            ${not empty personBasicInfoDto.fjbDate ? "确诊时间:": ""}<fmt:formatDate value='${personBasicInfoDto.fjbDate}' pattern='yyyy/MM/dd'/>

            ${personBasicInfoDto.exzl eq '205' ? '<br>恶性肿瘤' : ''}
            ${not empty personBasicInfoDto.exzlDate ? "确诊时间:": ""}<fmt:formatDate value='${personBasicInfoDto.exzlDate}' pattern='yyyy/MM/dd'/>

            ${personBasicInfoDto.nzz eq '206' ? '<br>脑卒中' : ''}
            ${not empty personBasicInfoDto.nzzDate ? "确诊时间:": ""}<fmt:formatDate value='${personBasicInfoDto.nzzDate}' pattern='yyyy/MM/dd'/>
            ${personBasicInfoDto.zxjsb eq '207' ? '<br>重性精神障碍' : ''}
            ${not empty personBasicInfoDto.zxjsbDate ? "确诊时间:": ""}<fmt:formatDate value='${personBasicInfoDto.zxjsbDate}' pattern='yyyy/MM/dd'/>

            ${personBasicInfoDto.jhb eq '208' ? '<br>结核病' : ''}
            ${not empty personBasicInfoDto.jhbDate ? "确诊时间:": ""}<fmt:formatDate value='${personBasicInfoDto.jhbDate}' pattern='yyyy/MM/dd'/>

            ${personBasicInfoDto.gy eq '209' ? '<br>肝炎' : ''}
            ${not empty personBasicInfoDto.gyDate ? "确诊时间:": ""}<fmt:formatDate value='${personBasicInfoDto.gyDate}' pattern='yyyy/MM/dd'/>
            ${personBasicInfoDto.xtjx eq '210' ? '<br>先天畸形' : ''}
            ${not empty personBasicInfoDto.xtjxDate ? "确诊时间:": ""}<fmt:formatDate value='${personBasicInfoDto.xtjxDate}' pattern='yyyy/MM/dd'/>
            ${personBasicInfoDto.qtidm eq '212' ? '<br>其他法定传染病' : ''}
            ${not empty personBasicInfoDto.qtidmDate ? "确诊时间:": ""}<fmt:formatDate value='${personBasicInfoDto.qtidmDate}' pattern='yyyy/MM/dd'/>
            ${personBasicInfoDto.zyb eq '213' ? '<br>职业病' : ''}
            ${not empty personBasicInfoDto.zybDate ? "确诊时间:": ""}<fmt:formatDate value='${personBasicInfoDto.zybDate}' pattern='yyyy/MM/dd'/>
            ${not empty personBasicInfoDto.zybName ? "名称:": ""}${personBasicInfoDto.zybName}
            ${personBasicInfoDto.qt eq '211' ? '<br>其他' : ''}
            ${personBasicInfoDto.qtxx}
            ${not empty personBasicInfoDto.qtDate ? "确诊时间:": ""}<fmt:formatDate value='${personBasicInfoDto.qtDate}' pattern='yyyy/MM/dd'/>
    </td>
</tr>
<tr>
    <th>手术</th>
    <td colspan="5">
        ${personBasicInfoDto.surgeryHistoryFlag eq '1' ? '无' : ''}
        ${personBasicInfoDto.surgeryHistoryFlag eq '2' ? '<b>有</b>:<br>' : ''}
            <c:forEach items="${personBasicInfoDto.surgeryHistoryList}" var="surgeryHistoryOne">
            	<c:if test="${not empty surgeryHistoryOne.opsName }">
                	名称: ${surgeryHistoryOne.opsName}
                	时间: <fmt:formatDate value='${surgeryHistoryOne.opsDate}' pattern='yyyy/MM/dd'/> <br>
                </c:if>
            </c:forEach>

    </td>
</tr>
<tr>
    <th>外伤</th>
    <td colspan="5">
        ${personBasicInfoDto.traumaHistoryFlag eq '1' ? '无' : ''}
        ${personBasicInfoDto.traumaHistoryFlag eq '2' ? '<b>有</b>:<br>' : ''}
            <c:forEach items="${personBasicInfoDto.traumaHistoryList}" var="traumaHistoryOne">
            	<c:if test="${not empty traumaHistoryOne.opsName }">
                	名称: ${traumaHistoryOne.opsName}
               	 	时间: <fmt:formatDate value='${traumaHistoryOne.opsDate}' pattern='yyyy/MM/dd'/> <br>
               	</c:if>
            </c:forEach>
    </td>
</tr>
<tr>
    <th>输血</th>
    <td colspan="6">
        ${personBasicInfoDto.transBloodHistoryFlag eq '1' ? '无' : ''}
        ${personBasicInfoDto.transBloodHistoryFlag eq '2' ? '<b>有</b>:<br>' : ''}
        <c:if test="${personBasicInfoDto.transBloodHistoryFlag eq '2' }">
            <c:forEach items="${personBasicInfoDto.transBloodHistoryList}" var="transBloodHistoryOne">
                    原因: ${transBloodHistoryOne.bloodReason}
	               	时间: <fmt:formatDate value='${transBloodHistoryOne.bloodDate}' pattern='yyyy/MM/dd'/> <br>
            </c:forEach></c:if>
    </td>
</tr>
<tr>
    <th rowspan="4">家族史</th>
    <th>父亲</th>
    <td colspan="6">
        ${personBasicInfoDto.fatherFlag eq '1' || personBasicInfoDto.fatherFlag eq null ? '无' : ''}
        ${personBasicInfoDto.fatherFlag eq '2' ? '<b>有</b>:<br />' : ''}
            <ehr:dic dicmeta="FS10240" code="${personBasicInfoDto.fatherStr}"/>
        <c:if test="${fatherFlag eq true}">
            ：${personBasicInfoDto.fatherStrDesc}
        </c:if>
    </td>
</tr>
<tr>
    <th>母亲</th>
    <td colspan="6">
        ${personBasicInfoDto.motherFlag eq '1' || personBasicInfoDto.motherFlag eq null ? '无' : ''}
        ${personBasicInfoDto.motherFlag eq '2' ? '<b>有</b>:<br />' : ''}
            <ehr:dic dicmeta="FS10240" code="${personBasicInfoDto.motherStr}"/>
            <c:if test="${motherFlag eq true}">
                ：${personBasicInfoDto.motherStrDesc}
            </c:if>
    </td>
</tr>
<tr>
    <th>兄妹</th>
    <td colspan="6">
        ${personBasicInfoDto.brotherFlag eq '1' || personBasicInfoDto.brotherFlag eq null ? '无' : ''}
        ${personBasicInfoDto.brotherFlag eq '2' ? '<b>有</b>:<br />' : ''}
            <ehr:dic dicmeta="FS10240" code="${personBasicInfoDto.brotherStr}"/>
            <c:if test="${brotherFlag eq true}">
                ：${personBasicInfoDto.brotherStrDesc}
            </c:if>
    </td>
</tr>
<tr>
    <th>子女</th>
    <td colspan="6">
        ${personBasicInfoDto.childFlag eq '1' || personBasicInfoDto.childFlag eq null ? '无' : ''}
        ${personBasicInfoDto.childFlag eq '2' ? '<b>有</b>:<br />' : ''}
            <ehr:dic dicmeta="FS10240" code="${personBasicInfoDto.childStr}"/>
            <c:if test="${childFlag eq true}">
                ：${personBasicInfoDto.childStrDesc}
            </c:if>
    </td>
</tr>
<tr>
    <th colspan="2">遗传病史</th>
    <td colspan="6">
        ${personBasicInfoDto.familyHeredityHistoryFlag eq '1' || personBasicInfoDto.familyHeredityHistoryFlag eq null ? '无' : ''}
        ${personBasicInfoDto.familyHeredityHistoryFlag eq '2' ? '<b>有</b>:<br>疾病名称:' : ''}
         <c:forEach items="${personBasicInfoDto.familyHeredityHistoryList}" var="familyHeredity">
        	<c:if test="${not empty familyHeredity.heredityhistory }">
	           	${familyHeredity.heredityhistory}
          	</c:if>
        </c:forEach>
    </td>
</tr>
<tr>
    <th colspan="2">残疾情况</th>
    <td colspan="6">
        ${personBasicInfoDto.deformityFlag eq '1' || personBasicInfoDto.deformityFlag eq null ? '无' : ''}
        ${personBasicInfoDto.deformityFlag eq '2' ? '<b>有</b>:' : ''}
            ${personBasicInfoDto.deformityHistory.visionDeformity eq '1' ? '视力残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.hearingDeformity eq '1' ? '听力残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.speechDeformity eq '1' ? '言语残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.limbDeformity eq '1' ? '肢体残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.intellectDeformity eq '1' ? '智力残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.mindDeformity eq '1' ? '精神残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.other eq '1' ? '其他残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.otherDesc}
    </td>
</tr>
<tr>
    <th colspan="2" rowspan="5">生活环境*</th>
    <td colspan="2">厨房排风设施</td>
    <td colspan="4">
        <ehr:dic dicmeta="CV0300302" code="${personBasicInfoDto.personInfo.outWindType}"/>
    </td>
</tr>
<tr>
    <td colspan="2">燃料类型</td>
    <td colspan="4">
        <ehr:dic dicmeta="CV0300303" code="${personBasicInfoDto.personInfo.fuel}"/>
    </td>
</tr>
<tr>
    <td colspan="2">饮水</td>
    <td colspan="4">
        <ehr:dic dicmeta="CV0300115" code="${personBasicInfoDto.personInfo.water}"/>
    </td>
</tr>
<tr>
    <td colspan="2">厕所</td>
    <td colspan="4">
        <ehr:dic dicmeta="CV0300304" code="${personBasicInfoDto.personInfo.hastoilet}"/>
    </td>
</tr>
<tr>
    <td colspan="2">禽畜栏</td>
    <td colspan="4">
        <ehr:dic dicmeta="FS10015" code="${personBasicInfoDto.personInfo.fowlType}"/>
    </td>
</tr>
</table>
    </div>
</form>
</div>