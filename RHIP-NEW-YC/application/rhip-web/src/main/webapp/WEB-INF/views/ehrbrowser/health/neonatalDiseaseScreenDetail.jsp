<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white;">
	<ul>
		<li style="text-align: center; font-size: 25px;">新生儿疾病筛查</li>
	</ul>
	<br/>
	<div class="table-basic">
		<table>
			<colgroup>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
				<col style="width: 20%;"/>
	            <col style="width: 30%;"/>
			</colgroup>
			<tr>
				<th>新生儿姓名</th>
				<td><c:out value="${neonatalDiseaseScreen.neonatalName}"></c:out></td>
				<th>新生儿性别</th>
				<td>
					<ehr:dic code="${neonatalDiseaseScreen.neonatalGender}" dicmeta="GBT226112003"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>新生儿出生日期</th>
				<td colspan="3">
					<fmt:formatDate value="${neonatalDiseaseScreen.neonatalBirthday}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>母亲姓名</th>
				<td>
					<c:out value="${neonatalDiseaseScreen.motherName}"></c:out>
				</td>
				<th>母亲出生日期</th>
				<td>
					<fmt:formatDate value="${neonatalDiseaseScreen.motherBirthday}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>母亲身份证件类别</th>
				<td>
					<ehr:dic code="${neonatalDiseaseScreen.motherIdcardType}" dicmeta="CV0201101"></ehr:dic>
				</td>
				<th>母亲身份证件号码</th>
				<td>
					<c:out value="${neonatalDiseaseScreen.motherIdcard}"></c:out>
				</td>
			</tr>
			<tr>
				<th>户籍地址</th>
				<td colspan="3">
					<c:out value="${neonatalDiseaseScreen.hrprovince}"></c:out>
					<c:out value="${neonatalDiseaseScreen.hrcity}"></c:out>
					<c:out value="${neonatalDiseaseScreen.hrcounty}"></c:out>
					<c:out value="${neonatalDiseaseScreen.hrtownShip}"></c:out>
					<c:out value="${neonatalDiseaseScreen.hrstreet}"></c:out>
					<c:out value="${neonatalDiseaseScreen.hrhouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>户籍地址邮政编码</th>
				<td colspan="3">
					<c:out value="${neonatalDiseaseScreen.hrpostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址</th>
				<td colspan="3">
					<c:out value="${neonatalDiseaseScreen.paprovince}"></c:out>
					<c:out value="${neonatalDiseaseScreen.pacity}"></c:out>
					<c:out value="${neonatalDiseaseScreen.pacounty}"></c:out>
					<c:out value="${neonatalDiseaseScreen.patownShip}"></c:out>
					<c:out value="${neonatalDiseaseScreen.pastreet}"></c:out>
					<c:out value="${neonatalDiseaseScreen.pahouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址邮政编码</th>
				<td colspan="3">
					<c:out value="${neonatalDiseaseScreen.papostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>联系电话类别</th>
				<td>
					<ehr:dic code="${neonatalDiseaseScreen.telType}" dicmeta="CV040001"></ehr:dic>
				</td>
				<th>联系电话号码</th>
				<td>
					<c:out value="${neonatalDiseaseScreen.telNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>标本编号</th>
				<td colspan="3">
					<c:out value="${neonatalDiseaseScreen.specimenNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>采血日期时间</th>
				<td>
					<fmt:formatDate value="${neonatalDiseaseScreen.samplingDate}" pattern="yyyy/MM/dd HH:mm:ss"/>
				</td>
				<th>采血方式</th>
				<td>
					<ehr:dic code="${neonatalDiseaseScreen.samplingWay}" dicmeta="CV0450006"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>采血部位</th>
				<td colspan="3">
					<ehr:dic code="${neonatalDiseaseScreen.samplingPart}" dicmeta="CV0450007"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>采血机构名称</th>
				<td>
					<c:out value="${neonatalDiseaseScreen.samplingOrganName}"></c:out>
				</td>
				<th>采血人员姓名</th>
				<td>
					<c:out value="${neonatalDiseaseScreen.bloodPersonName}"></c:out>
				</td>
			</tr>
			<tr>
				<th>新生儿疾病筛查项目</th>
				<td>
					<ehr:dic code="${neonatalDiseaseScreen.neonatalDiseaseScreenItem}" dicmeta="CV0450008"></ehr:dic>
				</td>
				<th>新生儿疾病筛查方法</th>
				<td>
					<ehr:dic code="${neonatalDiseaseScreen.neonatalDiseaseScreenMethod}" dicmeta="CV0450009"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>新生儿疾病筛查结果</th>
				<td colspan="3">
					<c:out value="${neonatalDiseaseScreen.neonatalDiseaseScreenResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>检查(测)日期</th>
				<td>
					<fmt:formatDate value="${neonatalDiseaseScreen.checkDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>检查(测)人员姓名</th>
				<td>
					<c:out value="${neonatalDiseaseScreen.checkName}"></c:out>
				</td>
			</tr>
			<tr>
				<th>检查(测)机构名称</th>
				<td>
					<c:out value="${neonatalDiseaseScreen.checkOrganName}"></c:out>
				</td>
				<th>筛查结果通知日期</th>
				<td>
					<fmt:formatDate value="${neonatalDiseaseScreen.screenNoticeDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>召回日期</th>
				<td colspan="3">
					<fmt:formatDate value="${neonatalDiseaseScreen.recallDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>检查结果通知形式</th>
				<td>
					<ehr:dic code="${neonatalDiseaseScreen.checkNotice}" dicmeta="CV0900301"></ehr:dic>
				</td>
				<th>通知到达人姓名</th>
				<td>
					<c:out value="${neonatalDiseaseScreen.noticeMasterName}"/>
				</td>
			</tr>
			<tr>
				<th>通知到达人与新生儿关系</th>
				<td>
					<ehr:dic code="${neonatalDiseaseScreen.noticeRelation}" dicmeta="GBT4761"></ehr:dic>
				</td>
				<th>通知者姓名</th>
				<td>
					<c:out value="${neonatalDiseaseScreen.noticeName}" />
				</td>
			</tr>
		</table>
	</div>
</div>