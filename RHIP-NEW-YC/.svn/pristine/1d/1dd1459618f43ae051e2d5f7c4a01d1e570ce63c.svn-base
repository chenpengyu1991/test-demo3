<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script type="text/javascript">
	$('#cancelChildExamViewBtn').click(function () {
		$('#child-exam-input-box').empty();
		$('#child-exam-input-box').hide();
		$('#child-exam-list-box').show();
		childSearch.search(1);
	});
</script>
<div class="toolbar">
	<a href="javascript:void(0)" id="cancelChildExamViewBtn"><button class="btn-gray layui-btn layui-btn-sm"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<div class="contentfixed32">
	<ul>
		<li style="text-align: center; font-size: 25px;">新生儿家庭访视</li>
	</ul>
	<br/>
	<div class="table-basic">
		<p style="font-size: 14px;">出生编号:<c:out value="${neonatalFamilyVisit.babyCardNo}"></c:out></p>
		<table style="line-height: 10px;" class="posttable  layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 20%;" />
				<col style="width: 30%;" />
				<col style="width: 20%;" />
				<col style="width: 30%;" />
			</colgroup>
			<tr>
				<th>姓名</th>
				<td>${neonatalFamilyVisit.neonatusName}</td>
				<th>出生编号</th>
				<td>${neonatalFamilyVisit.babyCardNo}</td>
			</tr>
			<tr>
				<th>性别</th>
				<td><ehr:dic code="${neonatalFamilyVisit.neonatalGender}" dicmeta="GBT226112003"/></td>
				<th>出生日期</th>
				<td><fmt:formatDate value="${neonatalFamilyVisit.neonatusBirthday}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>

				<th>身份证件号码</th>
				<td colspan="3">${neonatalFamilyVisit.neonatusIdcard}</td>
			</tr>
			<tr>
				<th>家庭地址 </th>
				<td colspan="3">
					<ehr:dic code="${neonatalFamilyVisit.pacounty}" dicmeta="FS990001" />
					<ehr:dic code="${neonatalFamilyVisit.patownShip}" dicmeta="FS990001" />
					<ehr:dic code="${neonatalFamilyVisit.pastreet}" dicmeta="FS990001" />
					${neonatalFamilyVisit.pahouseNumber}
				</td>
			</tr>

			<tr>
				<th>父亲姓名</th>
				<td>${neonatalFamilyVisit.fatherName}</td>
				<th>父亲职业</th>
				<td><ehr:dic code="${neonatalFamilyVisit.fatherOccupation}" dicmeta="GBT6565" /></td>
			</tr>
			<tr>
				<th>父亲联系电话</th>
				<td>${neonatalFamilyVisit.fatherPhone}</td>
				<th>父亲出生日期</th>
				<td><fmt:formatDate value="${neonatalFamilyVisit.fatherBirthday}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>


				<th>母亲姓名</th>
				<td>${neonatalFamilyVisit.motherName}</td>
				<th>母亲职业</th>
				<td><ehr:dic code="${neonatalFamilyVisit.motherOccupation}" dicmeta="GBT6565" /> </td>

			</tr>
			<tr>
				<th>母亲联系电话</th>
				<td>${neonatalFamilyVisit.matherPhone}</td>
				<th>母亲出生日期</th>
				<td><fmt:formatDate value="${neonatalFamilyVisit.motherBirthday}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>出生孕周</th>
				<td>${neonatalFamilyVisit.gestationalWeek}周</td>
				<th>助产机构名称</th>
				<td><ehr:org code="${neonatalFamilyVisit.obstetricInstitutionsName}"/></td>
			</tr>
			<tr>
				<th>母亲妊娠期患病情况</th>
				<td colspan="3">
					<ehr:dic code="${neonatalFamilyVisit.complicationHistory}" dicmeta="T19911105"/>
					<c:if test="${neonatalFamilyVisit.complicationHistory eq '3'}">
						${neonatalFamilyVisit.otherComplicationHistory}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>出生情况</th>
				<td colspan="3">
					<ehr:dic code="${neonatalFamilyVisit.lastdeliveryCode}" dicmeta="CV0210003"/>
					<c:if test="${'40' eq neonatalFamilyVisit.lastdeliveryCode}">
						${neonatalFamilyVisit.lastdeliverycodedesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>新生儿窒息</th>
				<td>
					<ehr:dic code="${neonatalFamilyVisit.asphyxiaSign}" dicmeta="FS10111"/>
					<c:if test="${neonatalFamilyVisit.asphyxiaSign eq '2'}">
						Apgar评分
						<c:choose>
							<c:when test="${neonatalFamilyVisit.apgarValue eq '01'}">1分钟</c:when>
							<c:when test="${neonatalFamilyVisit.apgarValue eq '02'}">65分钟</c:when>
							<c:when test="${neonatalFamilyVisit.apgarValue eq '03'}">不详</c:when>
						</c:choose>
					</c:if>
				</td>
				<th>新生儿畸形标志</th>
				<td>
					<c:if test="${!empty neonatalFamilyVisit.deformitySign}">
						<c:out value='${neonatalFamilyVisit.deformitySign eq "1" ? "是" : "否"}'/>
						<c:if test="${neonatalFamilyVisit.deformitySign eq '1'}">
							${neonatalFamilyVisit.deformityDesc}
						</c:if>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>新生儿听力筛查情况</th>
				<td>
					<ehr:dic code="${neonatalFamilyVisit.hearingScreeningState}" dicmeta="FS10025"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>新生儿疾病筛查</th>
				<td colspan="3">
					<ehr:dic code="${neonatalFamilyVisit.diseaseScreeningProject}" dicmeta="CV0450008"/>
					<c:if test="${neonatalFamilyVisit.diseaseScreeningProject eq '3'}">
						${neonatalFamilyVisit.diseaseScreeningDesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>出生体重(kg)</th>
				<td>${neonatalFamilyVisit.birthWeight}</td>
				<th>出生身长(cm)</th>
				<td>${neonatalFamilyVisit.birthStature}</td>
			</tr>

			<tr>
				<th>目前体重(kg)</th>
				<td>${neonatalFamilyVisit.bodyWeight}</td>
				<th>喂养方式</th>
				<td><ehr:dic code="${neonatalFamilyVisit.feedingType}" dicmeta="FS10026"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>每天吃奶次数*</th>
				<td>${neonatalFamilyVisit.eatMilkNumber}
				</td>
				<th>每次吃奶量(ml)</th>
				<td>${neonatalFamilyVisit.eatMilkSupply}
				</td>
			</tr>
			<tr>
				<th>呕吐标志*</th>
				<td>
					<ehr:dic code="${neonatalFamilyVisit.vomitingMark}" dicmeta="FS10111"/>
				</td>
				<th>新生儿大便性状*</th>
				<td><ehr:dic code="${neonatalFamilyVisit.stoolProperty}" dicmeta="CV0401012"/></td>
			</tr>
			<tr>
				<th>新生儿大便次数*</th>
				<td>${neonatalFamilyVisit.stoolNumber}次/日</td>
			</tr>
			<tr>
				<th>体温(℃)</th>
				<td>${neonatalFamilyVisit.temperature}</td>
				<th>脉率(次/分钟)</th>
				<td>${neonatalFamilyVisit.pulseRate}</td>
			</tr>
			<tr>
				<th>呼吸频率(次/分钟)</th>
				<td>${neonatalFamilyVisit.respiratoryRate}</td>
				<th>新生儿面色</th>
				<td><ehr:dic code="${neonatalFamilyVisit.complexionCode}" dicmeta="CV0410008"/>
					<c:if test="${neonatalFamilyVisit.complexionCode} eq '9'">
						${neonatalFamilyVisit.complexionCodesDesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>黄疸部位</th>
				<td colspan="3"><ehr:dic code="${neonatalFamilyVisit.jaundicePartsCode}" dicmeta="CV0410009"></ehr:dic></td>
			</tr>
			<tr>
				<th>前囟横径(cm)</th>
				<td>${neonatalFamilyVisit.afTransverseDiameter}</td>
				<th>前囟纵径(cm)</th>
				<td>${neonatalFamilyVisit.bregmaDiameter}</td>
			</tr>
			<tr>
				<th>前囟张力</th>
				<td colspan="3">
					<ehr:dic code="${neonatalFamilyVisit.bregmaTension}" dicmeta="CV0410018"/>
					<c:if test="${'9' eq neonatalFamilyVisit.bregmaTension}">
						${neonatalFamilyVisit.bregmaTensionsDesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>眼外观检查异常</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.eyeappearanceSign}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.eyeappearanceSign == '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.eyeAppearanceInspectionDesc}</c:otherwise>
						</c:choose>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>四肢活动度异常</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.limbActivityAnomalySign}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.limbActivityAnomalySign eq '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.limbActivityDesc}</c:otherwise>
						</c:choose>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>耳外观检查异常</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.earAppearanceInspection}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.earAppearanceInspection eq '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.earAppearanceInspectionDesc}</c:otherwise>
						</c:choose>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>颈部包块标志</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.earAppearanceInspection}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.earAppearanceInspection eq '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.neckLumpDesc}</c:otherwise>
						</c:choose>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>鼻检查异常</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.nasalCheckAnomaly}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.nasalCheckAnomaly eq '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.nasalCheckAnomalyDesc}</c:otherwise>
						</c:choose>
						<%--<c:out value='${neonatalFamilyVisit.nasalCheckAnomaly eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.nasalCheckAnomalyDesc)}'></c:out>--%>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>皮肤检查异常</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.skinVisionInspection}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.skinVisionInspection eq '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.skinVisionInspectionDesc}</c:otherwise>
						</c:choose>
						<%--<c:out value='${neonatalFamilyVisit.skinVisionInspection eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.skinVisionInspectionDesc)}'></c:out>--%>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>口腔检查异常</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.oralExaminationAnomaly}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.oralExaminationAnomaly eq '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.oralExaminationAnomalyDesc}</c:otherwise>
						</c:choose>
						<%--<c:out value='${neonatalFamilyVisit.oralExaminationAnomaly eq "0" ? "未见异常" : "异常 ".concat(neonatalFamilyVisit.oralExaminationAnomalyDesc)}'></c:out>--%>
					</c:if>
				</td>
			</tr>
			<tr>
				<th>肛门检查异常</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.analExaminationAnomaly}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.analExaminationAnomaly eq '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.analExaminationAnomalyDesc}</c:otherwise>
						</c:choose>
					</c:if>
					<%--<c:out value='${neonatalFamilyVisit.analExaminationAnomaly eq "0" ? "未见异常" : neonatalFamilyVisit.analExaminationAnomalyDesc}'></c:out>--%>
				</td>
			</tr>
			<tr>
				<th>心肺听诊异常</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.cardiacAuscuAnomaly}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.cardiacAuscuAnomaly eq '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.cardiacAuscuAnomalyDesc}</c:otherwise>
						</c:choose>
					</c:if>
					<%--<c:out value='${neonatalFamilyVisit.cardiacAuscuAnomaly eq "0" ? "未见异常" : neonatalFamilyVisit.cardiacAuscuAnomalyDesc}'></c:out>--%>
				</td>
			</tr>
			<tr>
				<th>外生殖器检查异常</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.extGenitalCheckAnomaly}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.extGenitalCheckAnomaly eq '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.extGenitalCheckAnomalyDesc}</c:otherwise>
						</c:choose>
					</c:if>
					<%--<c:out value='${neonatalFamilyVisit.extGenitalCheckAnomaly eq "0" ? "未见异常" : neonatalFamilyVisit.extGenitalCheckAnomalyDesc}'></c:out>--%>
				</td>
			</tr>
			<tr>
				<th>腹部触诊异常</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.abdominalPalpAnomaly}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.abdominalPalpAnomaly eq '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.abdominalPalpAnomalyDesc}</c:otherwise>
						</c:choose>
					</c:if>
					<%--<c:out value='${neonatalFamilyVisit.abdominalPalpAnomaly eq "0" ? "未见异常" : neonatalFamilyVisit.abdominalPalpAnomalyDesc}'></c:out>--%>
				</td>
			</tr>
			<tr>
				<th>脊柱检查异常</th>
				<td colspan="3">
					<c:if test="${!empty neonatalFamilyVisit.spinalCheckAnomaly}">
						<c:choose>
							<c:when test="${neonatalFamilyVisit.spinalCheckAnomaly eq '0'}">未见异常</c:when>
							<c:otherwise>异常 ${neonatalFamilyVisit.spinalCheckAnomalyDesc}</c:otherwise>
						</c:choose>
					</c:if>
					<%--<c:out value='${neonatalFamilyVisit.spinalCheckAnomaly eq "0" ? "未见异常" : neonatalFamilyVisit.spinalCheckAnomalyDesc}'></c:out>--%>
				</td>
			</tr>
			<tr>
				<th>脐带检查结果</th>
				<td colspan="3">
					<c:choose>
						<c:when test="${neonatalFamilyVisit.umbilicalCordCheck eq '1'}">
							未脱
						</c:when>
						<c:when test="${neonatalFamilyVisit.umbilicalCordCheck eq '2'}">
							脱落
						</c:when>
						<c:when test="${neonatalFamilyVisit.umbilicalCordCheck eq '3'}">
							脐部有渗出
						</c:when>
						<c:when test="${neonatalFamilyVisit.umbilicalCordCheck eq '4'}">
							其他
						</c:when>
					</c:choose>
					<c:if test="${neonatalFamilyVisit.umbilicalCordCheck eq '4'}">
						${neonatalFamilyVisit.umbilicalCordCheckDesc}
					</c:if>
				</td>
			</tr>
			<tr>
				<th>转诊标志</th>
				<td>
					<ehr:dic code="${neonatalFamilyVisit.referralFlag}" dicmeta="FS10187"/>
				</td>
				<c:if test='${neonatalFamilyVisit.referralFlag eq "2" }'>
					<th>转诊原因</th>
					<td>
						<c:out value="${neonatalFamilyVisit.referralReason}"></c:out>
					</td>

				</c:if>
			</tr>
			<c:if test='${neonatalFamilyVisit.referralFlag eq "2" }'>
				<tr>
					<th>转诊机构</th>
					<td>
						${neonatalFamilyVisit.referralHospitalName}
					</td>
					<th>转诊科室</th>
					<td>${neonatalFamilyVisit.referralDeptName}</td>
				</tr>
			</c:if>
			<tr>
				<th>新生儿访视健康指导</th>
				<td colspan="3">
					<ehr:dic code="${neonatalFamilyVisit.healthGuidanceCategory}" dicmeta="CV0600217"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>本次访视日期</th>
				<td>
					<fmt:formatDate value="${neonatalFamilyVisit.visitDate}" pattern="yyyy/MM/dd"/>
				</td>
				<th>访视医师姓名</th>
				<td>
					<ehr:staff-name staffCode="${neonatalFamilyVisit.supervisionDoctor}"/>
				</td>
			</tr>
			<tr>
				<th>下次访视地点</th>
				<td><ehr:org code="${neonatalFamilyVisit.nextSupervisionPlace}"/></td>
				<th>下次访视日期</th>
				<td>
					<fmt:formatDate value="${neonatalFamilyVisit.nextSupervisionDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
		</table>
	</div>
</div>