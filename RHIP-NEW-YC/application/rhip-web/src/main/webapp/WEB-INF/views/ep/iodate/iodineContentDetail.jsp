<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div>
	<form class="postcontent">
		<div class="postdiv">
			<table class="posttable">
				<colgroup>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
					<col style="width: 15%"/>
					<col style="width: 35%"/>
				</colgroup>
				<tbody>
				<c:if test="${surveyType eq 1}">
					<tr>
						<th>采样零售店名称</th>
						<td>${record.name}</td>
						<th>采样日期</th>
						<td style="vertical-align: top"><fmt:formatDate value="${record.monitorTime}" pattern="yyyy/MM/dd"/></td>
					</tr>
					<tr>
						<th>采样零售店地址</th>
						<td>${record.houseNumber}</td>
						<th>生产日期</th>
						<td style="vertical-align: top"><fmt:formatDate value="${test.manufactureDate}" pattern="yyyy/MM/dd"/></td>
					</tr>
					<tr>
						<th>盐样编号</th>
						<td>${test.saltSamplingNumber}</td>
						<th>保质期</th>
						<td>${test.bestBeforeDate} 月</td>
					</tr>
					<tr>
						<th>盐样品种</th>
						<td>${test.saltType}</td>
						<th>食盐碘含量</th>
						<td>${test.saltIodineContent} mg/kg</td>
					</tr>
					<tr>
						<th>盐样包装规格</th>
						<td>${test.saltPackingSize} g/袋</td>
						<th>零售价格</th>
						<td>${test.saltPrice} 元/袋</td>
					</tr>
				</c:if>
				<c:if test="${surveyType eq 2}">
					<tr>
						<th>盐业批发企业名称</th>
						<td>${record.name}</td>
						<th>采样日期</th>
						<td style="vertical-align: top"><fmt:formatDate value="${record.monitorTime}" pattern="yyyy/MM/dd"/></td>
					</tr>
					<tr>
						<th>盐样编号</th>
						<td>${test.saltSamplingNumber}</td>
						<th>生产日期</th>
						<td style="vertical-align: top"><fmt:formatDate value="${test.manufactureDate}" pattern="yyyy/MM/dd"/></td>
					</tr>
					<tr>
						<th>盐样品种</th>
						<td>${test.saltType}</td>
						<th>保质期</th>
						<td>${test.bestBeforeDate} 月</td>
					</tr>
					<tr>
						<th>盐样包装规格</th>
						<td>${test.saltPackingSize} g/袋</td>
						<th>食盐碘含量</th>
						<td>${test.saltIodineContent} mg/kg</td>
					</tr>
					<tr>
						<th>备注</th>
						<td colspan="3">${test.testRemark}</td>
					</tr>
				</c:if>
				</tbody>
			</table>
		</div>
	</form>
</div>