<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.mdm.common.OrgGenreCode" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/ihm/medicalTarget/symptomList.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/js/views/ihm/popChart.js" type="text/javascript"></script>--%>
<c:set var="HOSPITAL" value="<%=OrgGenreCode.HOSPITAL.getValue()%>" />
<c:set var="CENTRE" value="<%=OrgGenreCode.CENTRE.getValue()%>" />
<c:set var="STATION" value="<%=OrgGenreCode.STATION.getValue()%>" />

<div style="height: 450px;">
<div class="repeattable">
<div style="width: 4600px;">
<div id="ihmsymptomlisttableTopDiv">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<c:choose>
              	<c:when test="${genreCode == '0' }">
              		<col style="width:150px;"/>
              	</c:when>
              	<c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
              		<col style="width:120px;"/>
              		<col style="width:120px;"/>
              	</c:when>
                <c:when test="${genreCode == STATION}">
                  	<col style="width:80px;"/>
              		<col style="width:80px;"/>
              		<col style="width:80px;"/>
                </c:when>
                <c:otherwise>
                	<col style="width:150px;"/>
                </c:otherwise>
             </c:choose>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
			<col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
		</colgroup>	
		<thead>
			<tr>
				<c:choose>
                	<c:when test="${genreCode == '0' }">
                		<th rowspan="2">镇</th>
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
				<th colspan="4">全身症状</th>
				<th colspan="7">呼吸道症状</th>
				<th colspan="6">胃肠道症状</th>
                <th colspan="7">皮疹症状</th>
                <th colspan="7">出血症状</th>
                <th colspan="9">神经症状</th>
                <th colspan="7">肉毒中毒症状</th>
                <th colspan="6">其他症状</th>
                <th rowspan="2">操作</th>
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
                <c:when test="${genreCode == STATION}">
                    <th>镇</th>
                    <th>中心</th>
                    <th>站</th>
                </c:when>
                <c:otherwise>
                </c:otherwise>
            </c:choose>
            <th>发热</th>
            <th>全身性疼痛</th>
            <th>不适和疲劳</th>
            <th>淋巴结增大</th>
            <th>口呼吸</th>
            <th>喷嚏</th>
            <th>咽痛</th>
            <th>咳嗽</th>
            <th>痰异常</th>
            <th>呼吸时胸痛</th>
            <th>呼吸困难</th>
            <th>恶心和呕吐</th>
            <th>腹痛</th>
            <th>腹泻</th>
            <th>便稀、便秘</th>
            <th>胃气胀</th>
            <th>食欲缺乏</th>
            <th>皮疹、斑疹</th>
            <th>丘疹性荨麻疹</th>
            <th>荨麻疹</th>
            <th>多形性红斑</th>
            <th>自发性瘀班</th>
            <th>紫癜</th>
            <th>水疱疹</th>
            <th>呕血</th>
            <th>鼻出血</th>
            <th>咯血</th>
            <th>血尿</th>
            <th>胃肠出血</th>
            <th>大便潜血</th>
            <th>阴道出血</th>
            <th>头痛</th>
            <th>头晕和眩晕</th>
            <th>昏迷</th>
            <th>发热性惊厥</th>
            <th>震颤</th>
            <th>手足搐搦</th>
            <th>共济失调</th>
            <th>异常反射</th>
            <th>痛性痉挛和痉挛</th>
            <th>视物模糊</th>
            <th>复视</th>
            <th>发声困难</th>
            <th>言语障碍</th>
            <th>吞咽困难</th>
            <th>口干</th>
            <th>肌无力</th>
            <th>无尿、少尿</th>
            <th>多汗</th>
            <th>皮肤发红</th>
            <th>腰痛</th>
            <th>眼痛</th>
            <th>结膜出血</th>
        </tr>
        </thead>
    </table>
</div>
<div id="ihmsymptomlisttableDiv" class="contentfixed166" style="width: 4600px; overflow-x: auto; margin-left: -2px;">
    <table style="width: 100%;">
        <colgroup>
            <c:choose>
                <c:when test="${genreCode == '0' }">
                    <col style="width:150px;"/>
                </c:when>
                <c:when test="${genreCode == HOSPITAL || genreCode == CENTRE}">
                    <col style="width:120px;"/>
                    <col style="width:120px;"/>
                </c:when>
                <c:when test="${genreCode == STATION}">
                    <col style="width:80px;"/>
                    <col style="width:80px;"/>
                    <col style="width:80px;"/>
                </c:when>
                <c:otherwise>
                    <col style="width:150px;"/>
                </c:otherwise>
            </c:choose>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
            <col style="width:80px;"/>
        </colgroup>

		<tbody>
			<c:forEach var="report" items="${results}" varStatus="status">
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
                    <td>${report.feverNum}</td>
                    <td>${report.systemicPainNum}</td>
                    <td>${report.discomfortFatigueNum}</td>
                    <td>${report.enlargedLymphNum}</td>
                    <td>${report.mouthBreathingNum}</td>
                    <td>${report.sneezeNum}</td>
                    <td>${report.soreThroatNum}</td>
                    <td>${report.coughNum}</td>
                    <td>${report.abnormalSputumNum}</td>
                    <td>${report.breathingChestPainNum}</td>
                    <td>${report.dyspneaNum}</td>
                    <td>${report.nauseaVomitingNum}</td>
                    <td>${report.abdominalPainNum}</td>
                    <td>${report.diarrheaNum}</td>
                    <td>${report.constipationNum}</td>
                    <td>${report.flatulenceNum}</td>
                    <td>${report.appetiteLackNum}</td>
                    <td>${report.rashMaculaNum}</td>
                    <td>${report.papularUrticariaNum}</td>
                    <td>${report.urticariaNum}</td>
                    <td>${report.erythemaMultiformeNum}</td>
                    <td>${report.spontaneousStasisNum}</td>
                    <td>${report.purpuraNum}</td>
                    <td>${report.waterHerpesNum}</td>
                    <td>${report.hematemesisNum}</td>
                    <td>${report.nasalBleedingNum}</td>
                    <td>${report.hemoptysisNum}</td>
                    <td>${report.hematuriaNum}</td>
                    <td>${report.stomachBloodNum}</td>
                    <td>${report.fecalOccultBloodNum}</td>
                    <td>${report.vaginalBleedingNum}</td>
                    <td>${report.headacheNum}</td>
                    <td>${report.dizzinessVertigoNum}</td>
                    <td>${report.comaNum}</td>
                    <td>${report.febrileConvulsionNum}</td>
                    <td>${report.tremorNum}</td>
                    <td>${report.tetanyNum}</td>
                    <td>${report.ataxiaNum}</td>
                    <td>${report.anomalousReflectionNum}</td>
                    <td>${report.crampsSpasmsNum}</td>
                    <td>${report.blurredVisionNum}</td>
                    <td>${report.diplopiaNum}</td>
                    <td>${report.dysphoniaNum}</td>
                    <td>${report.speechDisordersNum}</td>
                    <td>${report.dysphagiaNum}</td>
                    <td>${report.dryMouthNum}</td>
                    <td>${report.myastheniaGravisNum}</td>
                    <td>${report.noUrineOliguriaNum}</td>
                    <td>${report.hyperhidrosisNum}</td>
                    <td>${report.skinRednessNum}</td>
                    <td>${report.waistPainNum}</td>
                    <td>${report.eyePainNum}</td>
                    <td>${report.conjunctivaBloodNum}</td>
                    <td><a class="ihmSymptomPopChart" href="javascript:void(0)" onclick="symptomList.openChart('${report.organCode}','${report.gbCode}')">趋势图</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div id="ihmSymptom_pop-chart-con" style="width: 800px;height:400px"></div>
</div>
</div>
</div>
	<%--<input type="hidden" id="chart_title" value="">--%>
	<%--<input type="hidden" id="this_data" value="">--%>
	<%--<input type="hidden" id="categories" value="">--%>
	<%--<input type="hidden" id="seriesname" value="">--%>
	<%--<input type="hidden" id="seriesname" value="">--%>
	<%--<input type="hidden" id="yAxisText" value="">--%>
	<%--<input type="hidden" id=orgName value="">--%>
