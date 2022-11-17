<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="repeattable">
	<table id="hsa-report-service-report-result-table" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 100px;" />
			<col style="width: 200px;" />
			<col span="6" style="width:15%" />
		</colgroup>
		<caption>
			<span style="font-size: 25px;">县卫生监督协管服务汇总表</span>
		</caption>
		<thead>
			<tr>
				<th colspan="2" rowspan="2">协管项目</th>
				<%-- <th colspan="2">发现的卫生监督协管事件或线索数（次）</th>--%>
				<th colspan="2">报告的卫生监督协管事件或线索数（次）</th>
				<th colspan="2">开展实地巡查数（次）</th>
				<th colspan="2">宣传教育数（次）</th>
			</tr>
			<tr>
				<%--<th>本月</th>
				<th>累计</th>--%>
				<th>本月</th>
				<th>累计</th>
				<th>本月</th>
				<th>累计</th>
				<th>本月</th>
				<th>累计</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td rowspan="2"><ehr:tip>食品安全</ehr:tip></td>
				<td>事故</td>
				<%--<td></td><td></td>--%>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['1_2'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['1_2'].count}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${inspection['1'].total}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${inspection['1'].count}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${edu['1'].total}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${edu['1'].count}"></tags:numberLabel></td>
			</tr>
			<tr>
				<td><ehr:tip>违法行为</ehr:tip></td>
				<%--<td></td><td></td>--%>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['1_1'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['1_1'].count}"></tags:numberLabel></td>
			</tr>
			<tr>
				<td rowspan="2"><ehr:tip>公共场所</ehr:tip></td>
				<td><ehr:tip>危害健康事故</ehr:tip></td>
				<%--<td></td><td></td>--%>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['2_2'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['2_2'].count}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${inspection['2'].total}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${inspection['2'].count}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${edu['2'].total}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${edu['2'].count}"></tags:numberLabel></td>
			</tr>
			<tr>
				<td><ehr:tip>违法行为</ehr:tip></td>
				<%--<td></td><td></td>--%>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['2_1'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['2_1'].count}"></tags:numberLabel></td>
			</tr>
			<tr >
				<td rowspan="2"><ehr:tip>生活饮用水</ehr:tip></td>
				<td><ehr:tip>污染事故或异常情况</ehr:tip></td>
				<%--<td></td><td></td>--%>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['3_2'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['3_2'].count}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${inspection['3'].total}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${inspection['3'].count}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${edu['3'].total}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${edu['3'].count}"></tags:numberLabel></td>
			</tr>
			<tr>
				<td><ehr:tip>违法行为</ehr:tip></td>
				<%--<td></td><td></td>--%>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['3_1'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['3_1'].count}"></tags:numberLabel></td>
			</tr>
			<tr>
				<td rowspan="2"><ehr:tip>传染病防控</ehr:tip></td>
				<td><ehr:tip>传染病疫情</ehr:tip></td>
				<%--<td></td><td></td>--%>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['6_2'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['6_2'].count}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${inspection['6'].total}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${inspection['6'].count}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${edu['6'].total}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${edu['6'].count}"></tags:numberLabel></td>
			</tr>
			<tr>
				<td><ehr:tip>违法行为</ehr:tip></td>
				<%--<td></td><td></td>--%>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['6_1'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['6_1'].count}"></tags:numberLabel></td>
			</tr>
			<tr>
				<td rowspan="2"><ehr:tip>职业卫生</ehr:tip></td>
				<td><ehr:tip>可疑职业病</ehr:tip></td>
				<%--<td></td><td></td>--%>
				<td style="text-align: center;">--</td>
				<td style="text-align: center;">--</td>
				<td style="text-align: center;">--</td>
				<td style="text-align: center;">--</td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${edu['4'].total}"></tags:numberLabel></td>
				<td rowspan="2"><tags:numberLabel defaultValue="0" value="${edu['4'].count}"></tags:numberLabel></td>
			</tr>
            <tr>
                <td><ehr:tip>咨询指导</ehr:tip></td>
                <%--<td></td><td></td>--%>
                <td><tags:numberLabel defaultValue="0" value="${sodp['4'].total}"></tags:numberLabel></td>
                <td><tags:numberLabel defaultValue="0" value="${sodp['4'].count}"></tags:numberLabel></td>
                <td style="text-align: center;">--</td>
                <td style="text-align: center;">--</td>
            </tr>
			<tr>
				<td><ehr:tip>学校卫生</ehr:tip></td>
				<td><ehr:tip>问题及隐患</ehr:tip></td>
				<%--<td></td><td></td>--%>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['5_2'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['5_2'].count}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${inspection['5'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${inspection['5'].count}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${edu['5'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${edu['5'].count}"></tags:numberLabel></td>
			</tr>
			<tr>
				<td colspan="2"><ehr:tip>非法行医（采供血）</ehr:tip></td>
				<%--<td></td><td></td>--%>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['7_2'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${reportRecord['7_2'].count}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${inspection['7'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${inspection['7'].count}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${edu['7'].total}"></tags:numberLabel></td>
				<td><tags:numberLabel defaultValue="0" value="${edu['7'].count}"></tags:numberLabel></td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="8">填报单位:${currentOrgName }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 填报人:${currentUserName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 填报时间:<fmt:formatDate
						pattern="yyyy/MM/dd" value="${currentDate}"
					/></td>
			</tr>
		</tfoot>
	</table>
</div>