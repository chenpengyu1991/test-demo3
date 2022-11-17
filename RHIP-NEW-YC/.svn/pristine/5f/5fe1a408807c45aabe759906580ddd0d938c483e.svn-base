<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />

<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
			<c:choose>
              	<c:when test="${genreCode == '0' }">
              		<col style="min-width:150px;width: 30%;"/>
              	</c:when>
              	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE || genreCode == 'G2'}">
              		<col style="min-width:150px;width: 10%;"/>
              		<col style="min-width:150px;width: 20%;"/>
              	</c:when>
                <c:when test="${genreCode == STATION}">
                  	<col style="min-width:150px;width: 8%;"/>
              		<col style="min-width:150px;width: 11%;"/>
              		<col style="min-width:150px;width: 11%;"/>
                </c:when>
                <c:otherwise>
                	<col style="min-width:150px;width: 30%;"/>
                </c:otherwise>
             </c:choose>
            <col style="width: 80px;"/>
            <col style="width: 80px;"/>
            <col style="width: 80px;"/>
            <col style="width: 80px;"/>
        </colgroup>
		<thead>
			<tr>
				<c:choose>
                	<c:when test="${genreCode == '0' }">
                		<th rowspan="2">镇</th>
                	</c:when>
                	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE || genreCode == 'G2'}">
                		<th colspan="2">医疗机构</th>
                	</c:when>
                    <c:when test="${genreCode == STATION}">
                    	<th colspan="3">医疗机构</th>
                    </c:when>
                    <c:otherwise>
                    	<th rowspan="2">医疗机构</th>
                    </c:otherwise>
                </c:choose>
                <th colspan="4">体检检查项</th>
			</tr>
			<tr>
				<c:choose>
                	<c:when test="${genreCode == '0' ||  genreCode eq null}">
                	</c:when>
                	<c:when test="${genreCode == HOSPITAL}">
                		<th>镇</th>
                		<th>医院</th>
                	</c:when>
					<c:when test="${genreCode == CENTRE}">
                		<th>镇</th>
                		<th>卫生院</th>
                	</c:when>                	
                    <c:when test="${genreCode == STATION}">
                    	<th>镇</th>
                		<th>中心</th>
                		<th>站</th>
                    </c:when>
                    <c:otherwise>
                    	<th>镇</th>
                		<th>卫生机构</th>
                    </c:otherwise>
                </c:choose>			
				<th>B超检查数</th>
				<th>心电图检查数</th>
				<th>血常规检查数</th>
				<th>尿常规检查数</th>
			</tr>
		</thead>        
		<tbody>
			<c:forEach var="result" items="${results}" varStatus="status">
				<tr>
					<c:choose>
	              	<c:when test="${genreCode == '0' }">
              			<td>
              				<ehr:tip><ehr:dic code="${result.gb_code}" dicmeta="FS990001"/></ehr:tip>
              				<c:if test="${result.gb_code == '合计' || result.organ_code == '合计'}"> <b>合计</b> </c:if>
              			</td> 
	              	</c:when>
	              	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE || genreCode == 'G2'}">
	              		<c:choose>
	              			<c:when test="${result.gb_code == '合计' || result.organ_code == '合计'}">
	              				<td colspan="2" class="centertd"><b>合计</b></td>
	              			</c:when>
	              			<c:when test="${result.gb_code == '小计' || result.organ_code == '小计'}">
	              				<td><ehr:tip><ehr:dic code="${result.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
	              				<td><b>小计</b></td>
	              			</c:when>
	              			<c:otherwise>
	              				 <td><ehr:tip><ehr:dic code="${result.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
	              				 <td><ehr:tip><ehr:org code="${result.organ_code}"/></ehr:tip></td>
	              			</c:otherwise>
	              		</c:choose>
	              	</c:when>
	                  <c:when test="${genreCode == STATION}">
	                  	<c:choose>
	              			<c:when test="${result.gb_code == '合计' || result.organ_code == '合计'}">
	              				<td colspan="3" class="centertd"><b>合计</b></td> 
	              			</c:when>
	              			<c:when test="${result.gb_code == '小计' || result.organ_code == '小计'}">
	              				<td><ehr:tip><ehr:dic code="${result.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
			              		<td><ehr:tip><ehr:org code="${result.center_code}"/></ehr:tip></td>
			                  	<td><b>小计</b></td>
	              			</c:when>
	              			<c:otherwise>
	              				<td><ehr:tip><ehr:dic code="${result.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
			              		<td><ehr:tip><ehr:org code="${result.center_code}"/></ehr:tip></td>
			                  	<td><ehr:tip><ehr:org code="${result.organ_code}"/></ehr:tip></td>
	              			</c:otherwise>
	              		</c:choose>
	              		
	                  </c:when>
              		</c:choose>
					<td><tags:numberLabel value="${result.bus_num}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${result.ecg_num}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${result.blood_examination_num}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${result.urine_examination_num}" defaultValue="0" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>