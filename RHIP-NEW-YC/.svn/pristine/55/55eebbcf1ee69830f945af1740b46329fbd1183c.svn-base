<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<div>
	<div class="postcontent">
		<div class="postdiv">
			<input type="hidden" id="id" name="id" value="${record.id}"/>
			<table class="posttable">
				<colgroup>
					<col style="width: 30%"/>
					<col style="width: 70%"/>
				</colgroup>
				<tbody>
				<tr>
					<th>抽检方向</th>
					<td>
						<ehr:dic dicmeta="FS10270" code="${base.position}"/>
					</td>
				</tr>
				<tr>
					<th>被抽取乡镇</th>
					<td><ehr:dic dicmeta="FS990001" code="${base.gbCode}"/></td>
				</tr>
				<tr>
					<th>被抽取村</th>
					<td>
						<table>
							<c:forEach var="record" items="${records}" varStatus="idx">
								<tr>
									<td><ehr:dic dicmeta="FS990001" code="${record.villageCode}"/></td>
								</tr>
							</c:forEach>
						</table>
					</td>
				</tr>
				<tr>
					<th>抽样日期</th>
					<td><fmt:formatDate value="${base.samplingTime}" pattern="yyyy/MM/dd"/></td>
				</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>