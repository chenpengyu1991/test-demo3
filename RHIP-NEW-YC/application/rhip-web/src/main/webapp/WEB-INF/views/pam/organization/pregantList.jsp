<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>

<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />

<div style="height: 400px;">
<div class="repeattable">
<div style="min-width: 800px; width: 100%">
<div id="cpwlisttableTopDiv">
    <table>
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <col style="min-width:80px; width: 15%;"/>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE || genreCode == 'G2'}">
                    <col style="min-width:80px; width: 5%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <col style="min-width:80px; width: 3%;"/>
                    <col style="min-width:80px; width: 5%;"/>
                    <col style="min-width:80px; width: 8%;"/>
                </c:when>
                <c:otherwise>
                    <col style="min-width:80px; width: 15%;"/>
                </c:otherwise>
            </c:choose>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
        </colgroup>
        <thead>
        <tr>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <th>镇</th>
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
             <c:choose>
                <c:when test="${genreCode == '0' }">
                    <th>平均孕产妇登记数</th>
		            <th>平均产前检查人次数</th>
		            <th>平均孕妇叶酸发放数</th>
		            <th>平均产妇分娩数</th>
		            <th>平均产后42天健康检查人数</th>
		            <th>平均阴道自然分娩人数</th>
		            <th>平均会阴切开人数</th>
		            <th>平均会阴未切人数</th>
		            <th>平均阴道手术助产人数</th>
		            <th>平均产钳助产人数</th>
		            <th>平均臀位助产人数</th>
		            <th>平均胎头吸引人数</th>
		            <th>平均剖宫产人数</th>
		            <th>平均子宫下段横切口剖宫产人数</th>
		            <th>平均子宫体剖宫产人数</th>
		            <th>平均腹膜外剖宫产人数</th>
		            <th>平均其他分娩人数</th>
                </c:when>
                <c:otherwise>
		            <th rowspan="2">平均孕产妇登记数</th>
		            <th rowspan="2">平均产前检查人次数</th>
		            <th rowspan="2">平均孕妇叶酸发放数</th>
		            <th rowspan="2">平均产妇分娩数</th>
		            <th rowspan="2">平均产后42天健康检查人数</th>
		            <th rowspan="2">平均阴道自然分娩人数</th>
		            <th rowspan="2">平均会阴切开人数</th>
		            <th rowspan="2">平均会阴未切人数</th>
		            <th rowspan="2">平均阴道手术助产人数</th>
		            <th rowspan="2">平均产钳助产人数</th>
		            <th rowspan="2">平均臀位助产人数</th>
		            <th rowspan="2">平均胎头吸引人数</th>
		            <th rowspan="2">平均剖宫产人数</th>
		            <th rowspan="2">平均子宫下段横切口剖宫产人数</th>
		            <th rowspan="2">平均子宫体剖宫产人数</th>
		            <th rowspan="2">平均腹膜外剖宫产人数</th>
		            <th rowspan="2">平均其他分娩人数</th>
                </c:otherwise>
            </c:choose>
        </tr>
        <c:if test="${genreCode != '0' && genreCode ne null }">
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
	                <c:when test="${genreCode == 'G2'}">
	                    <th>镇</th>
                		<th>卫生机构</th>
	                </c:when>
	            </c:choose>
	          </tr>
        </c:if>
        </thead>
    </table>
</div>
<div id="cpwlisttableDiv" <c:if test="${genreCode != '0' }">class="contentfixed166"</c:if> style="min-width: 800px; width: 100%;overflow-x: auto; margin-left: -2px;">
    <table style="width: 100%;">
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <col style="min-width:80px; width: 15%;"/>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE || genreCode == 'G2'}">
                    <col style="min-width:80px; width: 5%;"/>
                    <col style="min-width:80px; width: 10%;"/>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <col style="min-width:80px; width: 3%;"/>
                    <col style="min-width:80px; width: 5%;"/>
                    <col style="min-width:80px; width: 8%;"/>
                </c:when>
            </c:choose>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
            <col style="min-width:33px; width: 5%;"/>
        </colgroup>
        <tbody>
        <c:forEach var="report" items="${result}" varStatus="status">
            <tr>
                <c:choose>
	              	<c:when test="${genreCode == '0' }">
              			<td><ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip>
              				<c:if test="${report.gb_code == '合计' || report.organ_code == '合计'}"> <b>合计</b> </c:if>
              			</td> 
	              	</c:when>
	              	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE || genreCode == 'G2'}">
	              		<c:choose>
	              			<c:when test="${report.gb_code == '合计' || report.organ_code == '合计'}">
	              				<td colspan="2" class="centertd"><b>合计</b></td>
	              			</c:when>
	              			<c:when test="${report.gb_code == '小计' || report.organ_code == '小计'}">
	              				<td><ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
	              				<td><b>小计</b></td>
	              			</c:when>
	              			<c:otherwise>
	              				 <td><ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
	              				 <td><ehr:tip><ehr:org code="${report.organ_code}"/></ehr:tip></td>
	              			</c:otherwise>
	              		</c:choose>
	              	</c:when>
	                  <c:when test="${genreCode == STATION}">
	                  	<c:choose>
	              			<c:when test="${report.gb_code == '合计' || report.organ_code == '合计'}">
	              				<td colspan="3" class="centertd"><b>合计</b></td> 
	              			</c:when>
	              			<c:when test="${report.gb_code == '小计' || report.organ_code == '小计'}">
	              			<td><ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
			              		<td><ehr:tip><ehr:org code="${report.center_code}"/></ehr:tip></td>
			                  	<td><b>小计</b></td>
	              			</c:when>
	              			<c:otherwise>
	              				<td><ehr:tip><ehr:dic code="${report.gb_code}" dicmeta="FS990001"/></ehr:tip> </td>
			              		<td><ehr:tip><ehr:org code="${report.center_code}"/></ehr:tip></td>
			                  	<td><ehr:tip><ehr:org code="${report.organ_code}"/></ehr:tip></td>
	              			</c:otherwise>
	              		</c:choose>
	                  </c:when>
              </c:choose>
              <td data-is-data="true" data-total-level="2" data-total="${report.maternal_registration_num}"><tags:numberLabel value="${report.maternal_registration_num}" defaultValue="0" /></td>
              <td data-is-data="true" data-total-level="2" data-total="${report.prenatal_check_num}"><tags:numberLabel value="${report.prenatal_check_num}" defaultValue="0" /></td>
              <td data-is-data="true" data-total-level="2" data-total="${report.folic_acid_num}"><tags:numberLabel value="${report.folic_acid_num}" defaultValue="0" /></td>
              <td data-is-data="true" data-total-level="2" data-total="${report.delivery_num}"><tags:numberLabel value="${report.delivery_num}" defaultValue="0" /></td>
              <td data-is-data="true" data-total-level="2" data-total="${report.health_examination_num}"><tags:numberLabel value="${report.health_examination_num}" defaultValue="0" /></td>
              <td data-is-data="true" data-total-level="2" data-total="${report.spontaneous_vaginal_num}"><tags:numberLabel value="${report.spontaneous_vaginal_num}" defaultValue="0" /></td>
              <td data-is-data="true" data-total-level="2" data-total="${report.perineal_incision_num}"><tags:numberLabel value="${report.perineal_incision_num}" defaultValue="0" /></td>
              <td data-is-data="true" data-total-level="2" data-total="${report.perineal_uncut_num}"><tags:numberLabel value="${report.perineal_uncut_num}" defaultValue="0" /></td>
              <td data-is-data="true" data-total-level="2" data-total="${report.vagina_surgical_delivery_num}"><tags:numberLabel value="${report.vagina_surgical_delivery_num}" defaultValue="0" /></td>
              <td data-is-data="true" data-total-level="2" data-total="${report.forceps_delivery_num}"><tags:numberLabel value="${report.forceps_delivery_num}" defaultValue="0" /></td>
              <td data-is-data="true" data-total-level="2" data-total="${report.breech_delivery_num}"><tags:numberLabel value="${report.breech_delivery_num}" defaultValue="0" /></td>
              <td data-is-data="true" data-total-level="2" data-total="${report.fetal_head_suction_num}"><tags:numberLabel value="${report.fetal_head_suction_num}" defaultValue="0" /></td>
                <td data-is-data="true" data-total-level="2" data-total="${report.cesarean_num}"><tags:numberLabel value="${report.cesarean_num}" defaultValue="0" /></td>
                <td data-is-data="true" data-total-level="3" data-total="${report.lower_cesarean_num}"><tags:numberLabel value="${report.lower_cesarean_num}" defaultValue="0" /></td>
                <td data-is-data="true" data-total-level="4" data-total="${report.uterine_cesarean_num}"><tags:numberLabel value="${report.uterine_cesarean_num}" defaultValue="0" /></td>
                <td data-is-data="true" data-total-level="5" data-total="${report.extraperitoneal_cesarean_num}"><tags:numberLabel value="${report.extraperitoneal_cesarean_num}" defaultValue="0" /></td>
                <td data-is-data="true" data-total-level="6" data-total="${report.other_delivery_num}"><tags:numberLabel value="${report.other_delivery_num}" defaultValue="0" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</div>
</div>
</div>
