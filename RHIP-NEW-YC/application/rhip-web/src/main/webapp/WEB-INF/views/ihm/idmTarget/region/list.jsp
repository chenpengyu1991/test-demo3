<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />

<div style="height: 500px;">
<div class="repeattable">
<div style="width: 2620px;">
    <div class="paddingright17">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<c:choose>
              	<c:when test="${genreCode == '0' }">
              		<col style="width: 180px;"/>
              	</c:when>
              	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
              		<col style="width: 100px;"/>
              		<col style="width: 100px;"/>
              	</c:when>
                <c:otherwise>
                	<col style="width: 100px;"/>
                </c:otherwise>
             </c:choose>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
			<col style="width: 60px;"/>
		</colgroup>
		<thead>
			<tr>
				<c:choose>
                	<c:when test="${genreCode == '0' }">
                		<th rowspan="3">镇</th>
                	</c:when>
                	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                		<th colspan="2">医疗机构</th>
                	</c:when>
                    <c:otherwise>
                    	<th rowspan="3">医疗机构</th>
                    </c:otherwise>
                </c:choose>
                <th rowspan="3">合计</th>
                <th colspan="39">法定39种传染病</th>
			</tr>
			<tr>
                <c:choose>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <th colspan="2"></th>
                </c:when>
                <c:otherwise>
                </c:otherwise>
                </c:choose>
                <th colspan="2">甲类</th>
                <th colspan="26">乙类</th>
                <th colspan="11">丙类</th>
			</tr>
			<tr>
				<c:choose>
                	<c:when test="${genreCode == '0' }">
                	</c:when>
                	<c:when test="${genreCode == HOSPITAL}">
                		<th>镇</th>
                		<th>医院</th>
                	</c:when>
					<c:when test="${genreCode == CENTRE}">
                		<th>镇</th>
                		<th>卫生院</th>
                	</c:when>                	
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>			
				<th>鼠疫</th>
				<th>霍乱</th>
				<th>传染性非典</th>
				<th>艾滋病</th>
				<th>肝炎</th>
				<th>脊灰</th>
				<th>人禽流感</th>
				<th>甲型H1N1流感</th>
				<th>麻疹</th>
				<th>出血热</th>
				<th>狂犬病</th>
				<th>乙脑</th>
				<th>登革热</th>
				<th>炭疽</th>
				<th>痢疾</th>
				<th>肺结核</th>
				<th>伤寒+副伤寒</th>
				<th>流脑</th>
				<th>百日咳</th>
				<th>白喉</th>
				<th>新生儿破伤风</th>
				<th>猩红热</th>
				<th>布病</th>
				<th>淋病</th>
				<th>梅毒</th>
				<th>钩体病</th>
				<th>血吸虫病</th>
				<th>疟疾</th>
				<th>流行性感冒</th>
				<th>流行性腮腺炎</th>
				<th>风疹</th>
				<th>急性出血性结膜炎</th>
				<th>麻风病</th>
				<th>斑疹伤寒</th>
				<th>黑热病</th>
				<th>包虫病</th>
				<th>丝虫病</th>
				<th>其它感染性腹泻病</th>
				<th>手足口病</th>
			</tr>
		</thead>
    </table>
    </div>
    <div class="paddingright17">
    <table style="width: 100%;" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <col style="width: 180px;"/>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <col style="width: 100px;"/>
                    <col style="width: 100px;"/>
                </c:when>
                <c:otherwise>
                    <col style="width: 100px;"/>
                </c:otherwise>
            </c:choose>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
            <col style="width: 60px;"/>
        </colgroup>
		<tbody>
			<c:forEach var="report" items="${reports}" varStatus="status">
				<tr>
					<c:set var="gbGroup" value="${report.GB_CODE== 'grouping'}"></c:set>
					<c:set var="parentGroup" value="${report.PARENT_CODE== 'grouping'}"></c:set>
					<c:set var="organGroup" value="${report.ORGAN_CODE== 'grouping'}"></c:set>
					<c:set var="colCount" value="0"></c:set>
					<c:if test="${gbGroup}"><c:set var="colCount" value="${colCount+1}"></c:set></c:if>
					<c:if test="${parentGroup}"><c:set var="colCount" value="${colCount+1}"></c:set></c:if>
					<c:if test="${organGroup}"><c:set var="colCount" value="${colCount+1}"></c:set></c:if>
					<c:choose>
						<c:when test="${gbGroup}">
	                		<td colspan="${colCount}"  class="centertd"><b><ehr:tip>合计</ehr:tip></b></td>
	                	</c:when>
	                	<c:when test="${parentGroup}">
	                		<td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
	                		<td colspan="${colCount}"  class="centertd"><b><ehr:tip>合计</ehr:tip></b></td>
	                	</c:when>
	                	<c:when test="${organGroup}">
	                		<td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
	                		<c:if test="${genreCode != HOSPITAL && genreCode != CENTRE}"><td><ehr:tip><ehr:org  code="${report.PARENT_CODE}"/></ehr:tip></td></c:if>
	                		<td class="centertd"><b><ehr:tip>合计</ehr:tip></b></td>
	                	</c:when>
	                	<c:otherwise>
	                		<c:choose>
	                			<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
	                				<c:if test="${not empty report.GB_CODE && !gbGroup}">
		                				<td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
		                			</c:if>
		                			<c:if test="${not empty report.ORGAN_CODE && !organGroup}">
		                				<td><ehr:tip><ehr:org  code="${report.ORGAN_CODE}"/></ehr:tip></td>
		                			</c:if>	
	                			</c:when>
	                			<c:otherwise>
				                	<c:if test="${not empty report.GB_CODE && !gbGroup}">
				                		<td><ehr:tip><ehr:dic dicmeta="FS990001" code="${report.GB_CODE}"/></ehr:tip></td>
				                	</c:if>
									<c:if test="${not empty report.PARENT_CODE && !parentGroup}">
				                		<td><ehr:tip><ehr:org  code="${report.PARENT_CODE}"/></ehr:tip></td>
				                	</c:if>
				                	<c:if test="${not empty report.ORGAN_CODE && !organGroup}">
				                		<td><ehr:tip><ehr:org  code="${report.ORGAN_CODE}"/></ehr:tip></td>
				                	</c:if>	                			
	                			</c:otherwise>
	                		</c:choose>
	                	</c:otherwise>               	
	                </c:choose>
                    <td><tags:numberLabel value="${report.INFECTIONS_COUNT}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections101}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections102}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections201}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections202}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections203}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections204}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections205}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections206}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections207}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections208}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections209}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections210}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections211}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections212}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections213}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections214}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections215}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections216}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections217}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections218}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections219}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections220}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections221}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections222}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections223}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections224}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections225}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections226}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections301}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections302}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections303}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections304}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections305}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections306}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections307}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections308}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections309}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections310}" defaultValue="0" /></td>
					<td><tags:numberLabel value="${report.infections311}" defaultValue="0" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
    </div>
</div>
</div>
</div>