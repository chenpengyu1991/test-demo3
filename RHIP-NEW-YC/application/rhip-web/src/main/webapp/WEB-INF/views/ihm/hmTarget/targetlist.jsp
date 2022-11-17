<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable" style="overflow-x: auto;overflow-y: auto; min-width: 800px; width: 100%; height: 450px;">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 200px;"/>
            <col span="22" style="min-width:80px;width: 80px;" />
		</colgroup>
		<thead>
			<tr>
                <th>医疗机构</th>
                <th>65岁以上老年人</th>
                <th>体检人数</th>
                <th>体检率</th>
                <th>血常规、生化</th>
                <th>尿常规</th>
                <th>心电图</th>
                <th>B超</th>
                <th>X线透视</th>
                <th>血压异常</th>
                <th>血糖异常</th>
                <th>血脂异常</th>
                <th>肝功能异常</th>
                <th>肾功能异常</th>
                <th>心电图异常</th>
                <th>肝囊肿</th>
                <th>脂肪肝</th>
                <th>胆结石</th>
                <th>胆囊炎</th>
                <th>肾囊肿</th>
                <th>肾结石</th>
                <th>可疑肿瘤</th>
                <th>可疑肺结核</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="health" items="${healthlist}" varStatus="status">
				<tr>
                 	<td>
                 		<c:if test="${empty health.organCode}"><b>总计</b></c:if>
                    	<c:choose>
                    		<c:when test="${genreCode == '0' }"><ehr:tip><ehr:dic dicmeta="FS990001" code="${health.organCode}"/></ehr:tip></c:when>
                    		<c:otherwise><ehr:tip><ehr:org  code="${health.organCode}"/></ehr:tip></c:otherwise>
                    	</c:choose>
                   	</td>
                   	<td><tags:numberLabel value="${health.shouldExamQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.actualExamQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.physicalExamRate}" defaultValue="0" type="percent" fractionDigits="2"/></td> 
                   	<td><tags:numberLabel value="${health.bloodBioQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.urineRoutineQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.ecgQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.bUltrasonicQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.xRayQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.bpvQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.ifgQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.dyslipidemiaQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.liverAbnormalQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.renalAbnormalQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.xRayAbnormalQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.hepaticCystQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.fattyLiverQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.gallStoneQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.cholecystitisQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.renalCystQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.kidneyStoneQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.tumorQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.tuberculosisQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.tuberculosisQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.tuberculosisQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.tuberculosisQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.tuberculosisQuantity}" defaultValue="0" /></td>
                   	<td><tags:numberLabel value="${health.tuberculosisQuantity}" defaultValue="0" /></td>                  
                </tr>
			</c:forEach>
		</tbody>
	</table>
</div>