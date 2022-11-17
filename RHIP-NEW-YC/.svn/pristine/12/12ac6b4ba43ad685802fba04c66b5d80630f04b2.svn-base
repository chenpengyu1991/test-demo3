<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />

<div style="height: 400px;">
<div class="repeattable">
<div style="min-width: 1000px; width: 100%">
<div id="cpwlisttableTopDiv">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <col style="width: 160px;"/>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <col style="width: 160px;"/>
                    <col style="width: 160px;"/>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <col style="width: 160px;"/>
                    <col style="width: 160px;"/>
                    <col style="width: 160px;"/>
                </c:when>
            </c:choose>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
        </colgroup>
        <thead>
        <tr>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <th>镇</th>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <th colspan="2">医疗机构</th>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <th colspan="3">医疗机构</th>
                </c:when>
                <c:otherwise>
                    <th rowspan="2">医疗机构</th>
                </c:otherwise>
            </c:choose>
             <c:choose>
                <c:when test="${genreCode == '0' }">
                    <th>进入临床数</th>
		            <th>退出数</th>
		            <th>完成数</th>
		            <th>治愈数</th>
		            <th>死亡数</th>
                </c:when>
                <c:otherwise>
                    <th rowspan="2">进入临床数</th>
		            <th rowspan="2">退出数</th>
		            <th rowspan="2">完成数</th>
		            <th rowspan="2">治愈数</th>
		            <th rowspan="2">死亡数</th>
                </c:otherwise>
            </c:choose>
        </tr>
        <c:if test="${genreCode != '0' }">
        	<tr>
	            <c:choose>
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
	            </c:choose>
	          </tr>
        </c:if>
        </thead>
        <tbody>
        <c:forEach var="report" items="${summaryList}" varStatus="status">
            <tr>
                <c:choose>
	              	<c:when test="${genreCode == '0' }">
              			<td><ehr:tip><ehr:dic code="${report.gb_Code}" dicmeta="FS990001"/></ehr:tip>
              				<c:if test="${report.gb_Code == '合计' || report.organ_Code == '合计'}"> <b>合计</b> </c:if>
              			</td> 
	              	</c:when>
	              	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
	              		<c:choose>
	              			<c:when test="${report.gb_Code == '合计' || report.organ_Code == '合计'}">
	              				<td colspan="2" class="centertd"><b>合计</b></td>
	              			</c:when>
	              			<c:when test="${report.gbCode == '小计' || report.organCode == '小计'}">
	              				<td><ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
	              				<td><b>小计</b></td>
	              			</c:when>
	              			<c:otherwise>
	              				 <td><ehr:tip><ehr:dic code="${report.gb_Code}" dicmeta="FS990001"/></ehr:tip> </td>
	              				 <td><ehr:tip><ehr:org code="${report.organ_Code}"/></ehr:tip></td>
	              			</c:otherwise>
	              		</c:choose>
	              	</c:when>
	                  <c:when test="${genreCode == STATION}">
	                  	<c:choose>
	              			<c:when test="${report.gb_Code == '合计' || report.organ_Code == '合计'}">
	              				<td colspan="3" class="centertd"><b>合计</b></td> 
	              			</c:when>
	              			<c:when test="${report.gb_Code == '小计' || report.organ_Code == '小计'}">
	              			<td><ehr:tip><ehr:dic code="${report.gb_Code}" dicmeta="FS990001"/></ehr:tip> </td>
			              		<td><ehr:tip><ehr:org code="${report.parent_Code}"/></ehr:tip></td>
			                  	<td><b>小计</b></td>
	              			</c:when>
	              			<c:otherwise>
	              				<td><ehr:tip><ehr:dic code="${report.gb_Code}" dicmeta="FS990001"/></ehr:tip> </td>
			              		<td><ehr:tip><ehr:org code="${report.parent_Code}"/></ehr:tip></td>
			                  	<td><ehr:tip><ehr:org code="${report.organ_Code}"/></ehr:tip></td>
	              			</c:otherwise>
	              		</c:choose>
	                  </c:when>
              </c:choose>
                <td class="centertd"><tags:numberLabel value="${report.INPCOUNT}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.QUITCOUNT}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.COMCOUNT}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.CURECOUNT}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.DEATHCOUNT}" defaultValue="0" align="center"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%-- <div id="cpwlisttableDiv" <c:if test="${genreCode != '0' }">class="contentfixed144"</c:if> style="min-width: 1000px; width: 100%;overflow-x: auto; margin-left: 0px;">
    <table style="width: 100%;" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <col style="width: 160px;"/>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <col style="width: 160px;"/>
                    <col style="width: 160px;"/>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <col style="width: 160px;"/>
                    <col style="width: 160px;"/>
                    <col style="width: 160px;"/>
                </c:when>
                <c:otherwise>
                    <col style="width: 160;"/>
                </c:otherwise>
            </c:choose>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
            <col style="min-width:60px;"/>
        </colgroup>
        <tbody>
        <c:forEach var="report" items="${summaryList}" varStatus="status">
            <tr>
                <c:choose>
	              	<c:when test="${genreCode == '0' }">
              			<td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip>
              				<c:if test="${report.gbCode == '合计' || report.organCode == '合计'}"> <b>合计</b> </c:if>
              			</td> 
	              	</c:when>
	              	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
	              		<c:choose>
	              			<c:when test="${report.gbCode == '合计' || report.organCode == '合计'}">
	              				<td colspan="2" class="centertd"><b>合计</b></td>
	              			</c:when>
	              			<c:when test="${report.gbCode == '小计' || report.organCode == '小计'}">
	              				<td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip> </td>
	              				<td><b>小计</b></td>
	              			</c:when>
	              			<c:otherwise>
	              				 <td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip> </td>
	              				 <td><ehr:tip><ehr:org code="${report.organCode}"/></ehr:tip></td>
	              			</c:otherwise>
	              		</c:choose>
	              	</c:when>
	                  <c:when test="${genreCode == STATION}">
	                  	<c:choose>
	              			<c:when test="${report.gbCode == '合计' || report.organCode == '合计'}">
	              				<td colspan="3" class="centertd"><b>合计</b></td> 
	              			</c:when>
	              			<c:when test="${report.gbCode == '小计' || report.organCode == '小计'}">
	              			<td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip> </td>
			              		<td><ehr:tip><ehr:org code="${report.centerCode}"/></ehr:tip></td>
			                  	<td><b>小计</b></td>
	              			</c:when>
	              			<c:otherwise>
	              				<td><ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"/></ehr:tip> </td>
			              		<td><ehr:tip><ehr:org code="${report.centerCode}"/></ehr:tip></td>
			                  	<td><ehr:tip><ehr:org code="${report.organCode}"/></ehr:tip></td>
	              			</c:otherwise>
	              		</c:choose>
	                  </c:when>
              </c:choose>
                <td class="centertd"><tags:numberLabel value="${report.clinicalPathwayNum}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.outCpNum}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.completeCpNum}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.cureCpNum}" defaultValue="0" align="center"/></td>
                <td class="centertd"><tags:numberLabel value="${report.deathCpNum}" defaultValue="0" align="center"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div> --%>
</div>
</div>
</div>