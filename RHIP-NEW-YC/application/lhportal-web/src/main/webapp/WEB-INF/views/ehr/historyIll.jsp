<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div id="beforeSaveDiv" class="rightnav">
	<table>
	<tr>
      		<td class="crumbs"><div id="location" parentMenu="basic-info" childMenu="history">当前位置:&gt;&gt;基本信息:&gt;&gt;既往病史</div>
		</td>
	  </tr>
	 </table>
<div class="table-basic">
<table>
<tr>
    <th colspan="2">药物过敏史</th>
    <td colspan="5">
        ${personBasicInfoDto.drugAllergyHistoryFlag eq '1' || personBasicInfoDto.drugAllergyHistoryFlag eq null  ? "无" : ""}
        ${personBasicInfoDto.drugAllergyHistoryFlag eq '2' ? "<b>有</b>:<br />" : ""}
        <ehr:dic dicmeta="CV0501038" code="${personBasicInfoDto.drugAllergyHistoryStr}"/>
    </td>
</tr>
<tr>
    <th colspan="2">暴露史</th>
    <td colspan="5">
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
    <td colspan="5">
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

            ${personBasicInfoDto.qt eq '211' ? '<br>其它' : ''}
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
    <td colspan="5">
        ${personBasicInfoDto.transBloodHistoryFlag eq '1' ? '无' : ''}
        ${personBasicInfoDto.transBloodHistoryFlag eq '2' ? '<b>有</b>:<br>' : ''}
            <c:forEach items="${personBasicInfoDto.transBloodHistoryList}" var="transBloodHistoryOne">
            	<c:if test="${not empty transBloodHistoryOne.bewrite }">
	               	 名称: ${transBloodHistoryOne.bewrite}
	               	 时间: <fmt:formatDate value='${transBloodHistoryOne.bloodDate}' pattern='yyyy/MM/dd'/> <br>
               	 </c:if>
            </c:forEach>
    </td>
</tr>
<tr>
    <th rowspan="4">家族史</th>
    <th>父亲</th>
    <td colspan="5">
        ${personBasicInfoDto.fatherFlag eq '1' || personBasicInfoDto.fatherFlag eq null ? '无' : ''}
        ${personBasicInfoDto.fatherFlag eq '2' ? '<b>有</b>:<br />' : ''}
            <ehr:dic dicmeta="FS10240" code="${personBasicInfoDto.fatherStr}"/>
    </td>
</tr>
<tr>
    <th>母亲</th>
    <td colspan="5">
        ${personBasicInfoDto.motherFlag eq '1' || personBasicInfoDto.motherFlag eq null ? '无' : ''}
        ${personBasicInfoDto.motherFlag eq '2' ? '<b>有</b>:<br />' : ''}
            <ehr:dic dicmeta="FS10240" code="${personBasicInfoDto.motherStr}"/>
    </td>
</tr>
<tr>
    <th>兄妹</th>
    <td colspan="5">
        ${personBasicInfoDto.brotherFlag eq '1' || personBasicInfoDto.brotherFlag eq null ? '无' : ''}
        ${personBasicInfoDto.brotherFlag eq '2' ? '<b>有</b>:<br />' : ''}
            <ehr:dic dicmeta="FS10240" code="${personBasicInfoDto.brotherStr}"/>
    </td>
</tr>
<tr>
    <th>子女</th>
    <td colspan="5">
        ${personBasicInfoDto.childFlag eq '1' || personBasicInfoDto.childFlag eq null ? '无' : ''}
        ${personBasicInfoDto.childFlag eq '2' ? '<b>有</b>:<br />' : ''}
            <ehr:dic dicmeta="FS10240" code="${personBasicInfoDto.childStr}"/>
    </td>
</tr>
<tr>
    <th colspan="2">遗传病史</th>
    <td colspan="5">
        ${personBasicInfoDto.familyHeredityHistoryFlag eq '1' || personBasicInfoDto.familyHeredityHistoryFlag eq null ? '无' : ''}
        ${personBasicInfoDto.familyHeredityHistoryFlag eq '2' ? '<b>有</b>:<br>疾病名称:' : ''}
		     ${personBasicInfoDto.familyHeredityHistoryList[0].heredityhistory}
    </td>
</tr>
<tr>
    <th colspan="2">残疾情况</th>
    <td colspan="5">
        ${personBasicInfoDto.deformityFlag eq '1' || personBasicInfoDto.deformityFlag eq null ? '无' : ''}
        ${personBasicInfoDto.deformityFlag eq '2' ? '<b>有</b>:' : ''}
            ${personBasicInfoDto.deformityHistory.visionDeformity eq '1' ? '视力残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.hearingDeformity eq '1' ? '听力残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.speechDeformity eq '1' ? '言语残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.limbDeformity eq '1' ? '肢体残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.intellectDeformity eq '1' ? '智力残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.mindDeformity eq '1' ? '精神残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.other eq '1' ? '其它残疾&nbsp;' : ''}
            ${personBasicInfoDto.deformityHistory.otherDesc}
    </td>
</tr>
</table>
</div>
</div>