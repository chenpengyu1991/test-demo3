<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
 <%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/views/hm/manage/tableList.js"/>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<c:set var="ZXLNR" value="<%=RoleType.ZXLNR.getValue()%>"/>
<c:set var="ZLNR" value="<%=RoleType.ZLNR.getValue()%>"/>
<c:set var="QWGZX" value="<%=RoleType.QWGZX.getValue()%>"/>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>


<%-- <div class="repeattable">
	<table>
		<colgroup>
			<col style="width: 60px;" />
			<col style="width: 30px;" />
			<col style="width: 40px;" />
			<col style="width: 80px;" />
			<col style="width: 90px;" />
			<col style="width: 100px;" />
			<col style="width: 120px;" />
			<col style="width: 40px;" />
			<col style="width: 40px;" />
			<col style="width: 40px;" />
			<col style="width: 100px;" />
			<col style="width: 70px;" />
			<col style="width: 100px;" />
		</colgroup>
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄(岁)</th>
				<th>出生日期</th>
				<th>身份证号</th>
				<th>档案编号</th>
				<th>体检机构</th>
				<th>是否体检</th>
				<th>是否评估</th>
				<th>是否中医指导</th>
				<th>体检编号</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody style="text-align: center">
			<c:forEach var="physicalExamRecord" items="${physicalExamRecords}">
				<tr>
					<td>${physicalExamRecord.name}</td>
					<td><ehr:dic dicmeta="GBT226112003" code="${physicalExamRecord.gender}" /></td>
					<td>${physicalExamRecord.age}</td>
					<td><fmt:formatDate value="${physicalExamRecord.birthday}" pattern="yyyy/MM/dd" /></td>
					<td title="${physicalExamRecord.idcard}">${physicalExamRecord.idcard}</td>
					<td title="${physicalExamRecord.healthFileNo}">${physicalExamRecord.healthFileNo}</td>
					<td title="<ehr:org flag="0" code="${physicalExamRecord.inputOrganCode}"/>"><ehr:org flag="0" code="${physicalExamRecord.inputOrganCode}"/></td>
					<td><c:if test="${physicalExamRecord.examStatus eq 1}">是</c:if><c:if test="${physicalExamRecord.examStatus eq 0}">否</c:if></td>
					<td><c:if test="${physicalExamRecord.estimateStatus eq 1}">是</c:if><c:if test="${physicalExamRecord.estimateStatus eq 0}">否</c:if></td>
					<td><c:if test="${physicalExamRecord.healthGuideStatus eq 1}">是</c:if><c:if test="${physicalExamRecord.healthGuideStatus eq 0}">否</c:if></td>
					<td>${physicalExamRecord.examNumber}</td>
					<td title="${physicalExamRecord.remarks}">${physicalExamRecord.remarks}</td>
					
					<td>
                        <ehr:authorize ifAnyGranted="${ZXLNR},${ZLNR}">
                        	<c:choose>
					    		<c:when test="${physicalExamRecord.logoff == 0}">
									<c:choose>
										<c:when test="${physicalExamRecord.examStatus eq 1}">
											<a href="javascript:void(0)" onclick="hmManageList.view(${physicalExamRecord.id},${physicalExamRecord.personId})">查看</a>
											<a href="javascript:void(0)" onclick="hmManageList.add(${physicalExamRecord.id},${physicalExamRecord.personId})">编辑</a>
											<a href="javascript:void(0)" onclick="hmManageList.deleteExam(${physicalExamRecord.id})">删除</a>
										</c:when>
										<c:otherwise>
											<span class="loadclass">查看</span>
											<a href="javascript:void(0)" onclick="hmManageList.add(${physicalExamRecord.id},${physicalExamRecord.personId})">录入</a>
											<span class="loadclass">删除</span>
										</c:otherwise>
									</c:choose>
								</c:when>
					    		<c:otherwise>
					    			<c:choose>
										<c:when test="${physicalExamRecord.examStatus eq 1}">
											<span class="loadclass">查看</span>
											<span class="loadclass">编辑</span>
											<span class="loadclass">删除</span>
										</c:when>
										<c:otherwise>
											<span class="loadclass">查看</span>
											<span class="loadclass">录入</span>
											<span class="loadclass">删除</span>
										</c:otherwise>
									</c:choose>
					    		</c:otherwise>
					    	</c:choose>
                        </ehr:authorize>
						<ehr:authorize ifAnyGranted="${QWGZX},${ADMIN}">
							<c:if test="${physicalExamRecord.examStatus eq 1}">
								<a href="javascript:void(0)" onclick="hmManageList.view(${physicalExamRecord.id},${physicalExamRecord.personId})">查看</a>
							</c:if>
							
						</ehr:authorize>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="hmManageSearch.search" />
		</tr>
	</table>
</div> --%>
<div class="repeattable" style="width:100%;overflow:auto;height:auto;">
	<table id="doctorSignCensusTable">
		<colgroup>
			<col style="width: 85px;" />
			<col style="width: 65px;" />
			<col style="width: 50px;" />
			<col style="width: 50px;" />
			
			<col style="width: 95px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 75px;" />
			
			<col style="width: 70px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
						
			<col style="width: 70px;" />
			<col style="width: 120px;" />
			<col style="width: 70px;" />
			<col style="width: 70px;" />
			<col style="width: 70px;" />
						
			<col style="width: 70px;" />
			<col style="width: 70px;" />
			<col style="width: 70px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
						
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			
			<col style="width: 60px;" />
			
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
						
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			
			<col style="width: 60px;" />
			 <col style="width: 60px;" />
			<%--><col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" /> --%>
		</colgroup>
		<thead>
			<!-- <tr>
				<th colspan="57">老年人健康体检信息统计表</th>
			</tr> -->
			<tr>
				<th rowspan="3">体检日期</th>
				<th rowspan="3">姓名</th>
				<th rowspan="3">性别</th>
				<th rowspan="3">年龄</th>
				<th rowspan="3">联系电话</th>
				<th colspan="13">一般状况</th>
				<th colspan="4">生活方式</th>
				<th colspan="23">辅助检查</th>
				<th colspan="7">现存主要健康问题</th>
				<!-- <th colspan="5">体检表反馈情况</th> -->
				
			</tr>
			<tr>
				<th rowspan="2">体温℃</th>
				<th rowspan="2">脉率次/分钟</th>
				<th rowspan="2">呼吸频率次/分钟</th>
				<th colspan="2">血压</th>
				<th rowspan="2">身高cm</th>
				<th rowspan="2">体重kg</th>
				<th rowspan="2">腰围cm</th>
				<th rowspan="2">体质指数kg/㎡</th>
				<th rowspan="2">老年人健康状态自我评估</th>
				<th rowspan="2">老年人生活自理能力评估</th>
				<th rowspan="2">老年人认知功能</th>
				<th rowspan="2">老年人情感状态</th>
				<th rowspan="2">锻炼频率</th>
				<th rowspan="2">饮食习惯</th>
				<th rowspan="2">吸烟情况</th>
				<th rowspan="2">饮酒情况</th>
				<th colspan="3">血常规</th>
				<th colspan="4">尿常规</th>
				<th rowspan="2">空腹血糖mmol/l</th>
				<th rowspan="2">心电图</th>
				<th rowspan="2">尿微量白蛋白mg/dl</th>
				<th rowspan="2">大便潜血阴性/阳性</th>
				<th rowspan="2">糖化血红蛋白%</th>
				<th rowspan="2">乙型肝炎表面抗原</th>
				<th colspan="3">肝功能</th>
				<th colspan="2">肾功能</th>
				<th colspan="4">血脂</th>
				<th rowspan="2">腹部B超正常/异常</th>
				<th rowspan="2">脑血管疾病</th>
				<th rowspan="2">肾脏疾病</th>
				<th rowspan="2">心脏疾病</th>
				<th rowspan="2">血管疾病</th>
				<th rowspan="2">眼部疾病</th>
				<th rowspan="2">神经系统疾病</th>
				<th rowspan="2">其它疾病</th>
				<!-- <th colspan="2">体检结果反馈</th>
				<th rowspan="2">体检结果反馈时间</th>
				<th rowspan="2">是否健康宣教</th>
				<th rowspan="2">签字</th> -->
				
				
				
			</tr>
			<tr>
				<th>左侧mmHg</th><th>右侧mmHg</th>
				<th>血红蛋白g/l</th><th>白细胞 ×10<sup>9</sup>/L</th><th>血小板 ×10<sup>9</sup>/L</th>
				<th>尿蛋白</th><th>尿糖</th><th>尿酮体</th><th>尿潜血</th>
				<th>血清谷丙转氨酶U/L</th><th>血清谷草转氨酶U/L</th><th>总胆红素umol/l</th>
				<th>血清肌酐umol/l</th><th>血尿素氮mmol/l</th>
				<th>总胆固醇mmol/l</th><th>甘油三酯mmol/l</th><th>血清低密度脂蛋白mmol/l</th><th>血清高密度脂蛋白mmol/l</th>
				<!-- <th>是</th><th>否</th> -->
			</tr>
		</thead>
		<tbody id="displayBody">
			<c:forEach var="examination" items="${examinationList}">
			<tr>
				<td title="<fmt:formatDate value="${examination.examinationDate }" pattern="yyyy/MM/dd"/>"><fmt:formatDate value="${examination.examinationDate }" pattern="yyyy/MM/dd"/></td>
				<td title="${examination.name }">${examination.name }</td>
				<td><ehr:dic code="${examination.gender}" dicmeta="GBT226112003"  /></td>
				<td title="${examination.age }">${examination.age }</td>
				<td title="${examination.phoneNumber }">${examination.phoneNumber }</td>
				<td title="${examination.temperature }">${examination.temperature }</td>
				<td title="${examination.pulseRate }">${examination.pulseRate }</td>
				
				<td title="${examination.respiratoryRate }">${examination.respiratoryRate }</td>
				<td title="${examination.leftSbp }<c:if test="${not empty examination.leftDbp and not empty leftSbp}">/</c:if>${examination.leftDbp }">${examination.leftSbp }<c:if test="${not empty examination.leftDbp}">/</c:if>${examination.leftDbp }</td>
				<td title="${examination.rightSbp }<c:if test="${not empty examination.rightDbp and not empty rightSbp}">/</c:if>${examination.rightDbp }">${examination.rightSbp }<c:if test="${not empty examination.rightSbp and not empty examination.rightDbp}">/</c:if>${examination.rightDbp }</td>
				<td title="${examination.height}">${examination.height} </td>
				<td title="${examination.bodyWeight}">${examination.bodyWeight} </td>
				<td title="${examination.waostline}">${examination.waostline} </td>
				<td title="${examination.indexOfBodyCharacteristics}">${examination.indexOfBodyCharacteristics} </td>
				<td title="<ehr:dic code="${examination.healthSelfAssessment}" dicmeta="CV0401013"  />">
				<ehr:tip><ehr:dic code="${examination.healthSelfAssessment}" dicmeta="CV0401013"  /></ehr:tip>
				 </td>
				 <td title="<ehr:dic code="${examination.lifeAbilitySelfAssessment}" dicmeta="CV0401014"  />">
				<ehr:tip><ehr:dic code="${examination.lifeAbilitySelfAssessment}" dicmeta="CV0401014"  /></ehr:tip>
				 </td>
				 <td title="<c:if test="${examination.cognitionScreenResult =='1'}">粗筛阴性</c:if><c:if test="${examination.cognitionScreenResult =='0'}">粗筛阳性</c:if>">
				 	<c:if test="${examination.cognitionScreenResult =='1'}">粗筛阴性</c:if>
				 	<c:if test="${examination.cognitionScreenResult =='0'}">粗筛阳性</c:if>
				  </td>
				 <td title="<c:if test="${examination.emotionScreenResult =='1'}">粗筛阴性</c:if><c:if test="${examination.emotionScreenResult =='0'}">粗筛阳性</c:if>">
				 	<c:if test="${examination.emotionScreenResult =='1'}">粗筛阴性</c:if>
				 	<c:if test="${examination.emotionScreenResult =='0'}">粗筛阳性</c:if>
				  </td>
				  <td title="<ehr:dic code="${examination.trainFrequencyTypeCode}" dicmeta="FS10208"  />">
					<ehr:tip><ehr:dic code="${examination.trainFrequencyTypeCode}" dicmeta="FS10208"  /></ehr:tip>
				 </td>
				  <td title="${examination.dietHunsuEquilibrium}">
				  		${examination.dietHunsuEquilibrium}
				  </td>
				  <td title="吸烟状况：<ehr:dic code="${examination.smodeStatusCode}" dicmeta="CV0300101"  />,日吸烟量：平均${examination.dailySmoke}支，开始吸烟年龄：${examination.smokeAge}岁，戒烟年龄：${examination.quitSmokeAge}岁">
					<ehr:tip><ehr:dic code="${examination.smodeStatusCode}" dicmeta="CV0300101"  /></ehr:tip>
				 </td>
				   <td title="饮酒频率:<ehr:dic code="${examination.drinkFrequency}" dicmeta="CV0300104"  />日饮酒量:平均${examination.dailyDrink}两,是否戒酒:<c:if test="${examination.nodrink eq'2'}">未戒酒</c:if><c:if test="${examination.nodrink eq'1'}">已戒酒 ,戒酒年龄:${examination.nodrinkAge}岁,</c:if>开始饮酒年龄:${examination.drinkAge}岁,近一年内是否曾醉酒:<ehr:dic code="${examination.drunk }" dicmeta="FS10009"  />饮酒种类:${examination.drinkSpirit}">
				  		<ehr:dic code="${examination.drinkFrequency}" dicmeta="CV0300104"  />	
				  </td>
				  <td title="${examination.hemoglobinValue}">${examination.hemoglobinValue}</td>
				  <td title="${examination.leukocyteCount}">${examination.leukocyteCount}</td> 
				  <td title="${examination.plateletCount}">${examination.plateletCount}</td> 
				  <td title="${examination.urineProQuantitativeValue}">${examination.urineProQuantitativeValue}</td> 
				  <td title="${examination.urineSugQuantitativeValue}">${examination.urineSugQuantitativeValue}</td> 
				  <td title="${examination.ketQuantitativeValue}">${examination.ketQuantitativeValue}</td> 
				  <td title="${examination.eryQuantitativeValue}">${examination.eryQuantitativeValue}</td> 
				  <td title="${examination.fpgMmol}/${examination.fpgMg}">
				  
				  ${examination.fpgMmol}
				  <c:if test="${not empty examination.fpgMg }">/${examination.fpgMg}</c:if>
				  </td>
				  <td title="<c:if test="${examination.ecgAnomalyFlag eq '2' }">未检</c:if><c:if test="${examination.ecgAnomalyFlag eq '0' }">正常</c:if><c:if test="${examination.ecgAnomalyFlag eq '1' }">异常,${examination.ecgAnomalyDesc}</c:if>">
				  <c:if test="${examination.ecgAnomalyFlag eq '2' }">
				  	未检
				  </c:if><c:if test="${examination.ecgAnomalyFlag eq '0' }">
				  	正常
				  </c:if><c:if test="${examination.ecgAnomalyFlag eq '1' }">
				  	异常,${examination.ecgAnomalyDesc}
				  </c:if> </td>
				  
				  <td title="${examination.urineMicroTongAlbumin}">${examination.urineMicroTongAlbumin}</td>
				  <td ><c:if test="${examination.fecalOccultBlood eq '0'}">未检</c:if>
				  			<c:if test="${examination.fecalOccultBlood ne '0'}">
				  				<ehr:dic code="${examination.fecalOccultBlood}" dicmeta="FS10058"  />
				  			</c:if>
				  </td>
				  <td title="${examination.hgb}">${examination.hgb}</td>
				  <td ><c:if test="${examination.hbsagDetectResult eq '0'}">未检</c:if>
				  			<c:if test="${examination.hbsagDetectResult ne '0'}">
				  				<ehr:dic code="${examination.hbsagDetectResult}" dicmeta="FS10058"  />
				  			</c:if>
				  </td>
				  <td title="${examination.serumGptValue}">${examination.serumGptValue}</td>
				  <td title="${examination.serumAstValue}">${examination.serumAstValue}</td>
				  <td title="${examination.totalBilirubin}">${examination.totalBilirubin}</td>
				  
				  <td title="${examination.creatinine}">${examination.creatinine}</td>
				   <td title="${examination.bloodUreaNitrogenValue}">${examination.bloodUreaNitrogenValue}</td>
				   <td title="${examination.tc}">${examination.tc}</td>
				   <td title="${examination.triglycerideValue}">${examination.triglycerideValue}</td>
				   <td title="${examination.ldlcDetectValue}">${examination.ldlcDetectValue}</td>
				   <td title="${examination.hdlcDetectValue}">${examination.hdlcDetectValue}</td>
				   <td><c:if test="${ examination.bmodeAnomalyfFlag eq '2'}">未检</c:if>
				   		<c:if test="${ examination.bmodeAnomalyfFlag eq '0'}">
				   			正常
				   		</c:if>
				   		<c:if test="${ examination.bmodeAnomalyfFlag eq '1'}">
				   			异常
				   		</c:if>
				   </td>
				    <td title="<c:if test="${examination.cvascularFlag eq '0' or examination.cvascularFlag eq null}">未发现</c:if><c:if test="${examination.cvascularFlag eq '1' }">已发现,${examination.cvascularHemorrhageStroke}</c:if>">
				   		<c:if test="${examination.cvascularFlag eq '0' or examination.cvascularFlag eq null}">
				   				未发现
				   		</c:if>
				   		<c:if test="${examination.cvascularFlag eq '1' }">
				   				已发现,${examination.cvascularHemorrhageStroke}
				   		</c:if>
				   
				   </td>
				   <td title="<c:if test="${examination.kidneyDiseaseFlag eq '0' or examination.kidneyDiseaseFlag eq null}">未发现</c:if><c:if test="${examination.kidneyDiseaseFlag eq '1' }">已发现,${examination.kidneyDiabeticNephropathy}</c:if>">
				   		<c:if test="${examination.kidneyDiseaseFlag eq '0' or examination.kidneyDiseaseFlag eq null}">
				   				未发现
				   		</c:if>
				   		<c:if test="${examination.kidneyDiseaseFlag eq '1' }">
				   				已发现,${examination.kidneyDiabeticNephropathy}
				   		</c:if>
				   
				   </td>
				   <td title="<c:if test="${examination.heartDiseaseFlag eq '0' or examination.heartDiseaseFlag eq null}">未发现</c:if><c:if test="${examination.heartDiseaseFlag eq '1' }">已发现,${examination.heartMiocardialInfarction}</c:if>">
				   		<c:if test="${examination.heartDiseaseFlag eq '0' or examination.heartDiseaseFlag eq null}">
				   				未发现
				   		</c:if>
				   		<c:if test="${examination.heartDiseaseFlag eq '1' }">
				   				已发现,${examination.heartMiocardialInfarction}
				   		</c:if>
				   
				   </td>
				   <td title="<c:if test="${examination.arteryDiseaseFlag eq '0' or examination.arteryDiseaseFlag eq null}">未发现</c:if><c:if test="${examination.arteryDiseaseFlag eq '1' }">已发现,${examination.arteryDissectingAneurysm}</c:if>">
				   		<c:if test="${examination.arteryDiseaseFlag eq '0' or examination.arteryDiseaseFlag eq null}">
				   				未发现
				   		</c:if>
				   		<c:if test="${examination.arteryDiseaseFlag eq '1' }">
				   				已发现,${examination.arteryDissectingAneurysm}
				   		</c:if>
				   
				   </td>
				  <td title="<c:if test="${examination.eyeDiseasesFlag eq '0' or examination.eyeDiseasesFlag eq null}">未发现</c:if><c:if test="${examination.eyeDiseasesFlag eq '1' }">已发现,${examination.eyeRetinalOozing}</c:if>">
				   		<c:if test="${examination.eyeDiseasesFlag eq '0' or examination.eyeDiseasesFlag eq null}">
				   				未发现
				   		</c:if>
				   		<c:if test="${examination.eyeDiseasesFlag eq '1' }">
				   				已发现,${examination.eyeRetinalOozing}
				   		</c:if>
				   
				   </td>
				   <td title="<c:if test="${examination.nervousDiseasesFlag eq '0' or examination.nervousDiseasesFlag eq null}">未发现</c:if><c:if test="${examination.nervousDiseasesFlag eq '1' }">有,${examination.nervousDiseasesDesc}</c:if>">
				   		<c:if test="${examination.nervousDiseasesFlag eq '0' or examination.nervousDiseasesFlag eq null}">未发现
				   		</c:if>
				   		<c:if test="${examination.nervousDiseasesFlag eq '1' }">
				   				有,${examination.nervousDiseasesDesc}
				   		</c:if>
				   
				   </td>
				   <td title="<c:if test="${examination.healthOther eq '0' or examination.healthOther eq null}">未发现</c:if><c:if test="${examination.healthOther eq '1' }">有,${examination.healthOtherDesc}</c:if>">
				   		<c:if test="${examination.healthOther eq '0' or examination.healthOther eq null}">
				   				未发现
				   		</c:if>
				   		<c:if test="${examination.healthOther eq '1' }">
				   				有,${examination.healthOtherDesc}
				   		</c:if>
				   
				   </td> 
				   
				   
				   
				  <%-- <td title="<ehr:dic code="${examination.lifeAbilitySelfAssessment}" dicmeta="CV0401014"  />">
				<ehr:tip><ehr:dic code="${examination.lifeAbilitySelfAssessment}" dicmeta="CV0401014"  /></ehr:tip>
				 </td> --%>
			</tr>
			</c:forEach>
		
			 <%-- <c:forEach var="report" items="${reports}" >
				<tr>
					<td>
						<ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"  /></ehr:tip>
					</td>
					<td>
						<c:choose>
							<c:when test="${not empty all}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
							<c:when test="${empty orgCode && empty centerOrgCode && empty gbcode}">
								<ehr:tip><ehr:dic code="${report.orgCode}" dicmeta="FS990001"  /></ehr:tip>
							</c:when>
							<c:when test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
						</c:choose>
					</td>
					<!-- 已组建家庭医生团队数（个） -->
					<td title="${report.doctorTeamNum }">${report.doctorTeamNum }</td>
					
					<!-- 户籍人口数（人） -->
					<td title="${report.householdNum }">${report.householdNum }</td>
					
					<!-- 常住人口 -->
					<td title="${report.permanentNum}">${report.permanentNum}</td>
					<td title="${report.permanentSignNum}">${report.permanentSignNum}</td>
					<td title="<fmt:formatNumber value="${report.permanentNum==0?0:(report.permanentSignNum/report.permanentNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.permanentNum==0?0:(report.permanentSignNum/report.permanentNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 重点人群 -->
					<td title="${report.focusGroupsNum}">${report.focusGroupsNum}</td>
					<td title="${report.focusGroupsSignNum}">${report.focusGroupsSignNum}</td>
					<td title="<fmt:formatNumber value="${report.focusGroupsNum==0?0:(report.focusGroupsSignNum/report.focusGroupsNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.focusGroupsNum==0?0:(report.focusGroupsSignNum/report.focusGroupsNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 0-6岁儿童-->
					<td title="${report.childNum}">${report.childNum}</td>
					<td title="${report.familyVisitNum}">${report.familyVisitNum}</td>
					<td title="${report.childSignNum}">${report.childSignNum}</td>
					<td title="<fmt:formatNumber value="${report.childNum==0?0:(report.childSignNum/report.childNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.childNum==0?0:(report.childSignNum/report.childNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 65岁及以上常住居民-->
					<td title="${report.householdGreatSixfNum}">${report.householdGreatSixfNum}</td>
					<td title="${report.greatSixfHasNum}">${report.greatSixfHasNum}</td>
					<td title="${report.greatSixfSignNum}">${report.greatSixfSignNum}</td>
					<td title="<fmt:formatNumber value="${report.greatSixfHasNum==0?0:(report.greatSixfSignNum/report.greatSixfHasNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.greatSixfHasNum==0?0:(report.greatSixfSignNum/report.greatSixfHasNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 孕产妇-->
					<td title="${report.womenNum}">${report.womenNum}</td>
					<td title="${report.womenSignNum}">${report.womenSignNum}</td>
					<td title="<fmt:formatNumber value="${report.womenNum==0?0:(report.womenSignNum/report.womenNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.womenNum==0?0:(report.womenSignNum/report.womenNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 高血压患者-->
					<td title="${report.hbpNum}">${report.hbpNum}</td>
					<td title="${report.hbpHasNum}">${report.hbpHasNum}</td>
					<td title="${report.hbpSignNum}">${report.hbpSignNum}</td>
					<td title="<fmt:formatNumber value="${report.hbpHasNum==0?0:(report.hbpSignNum/report.hbpHasNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.hbpHasNum==0?0:(report.hbpSignNum/report.hbpHasNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 糖尿病患者-->
					<td title="${report.diNum}">${report.diNum}</td> 
					<td title="${report.diHasNum}">${report.diHasNum}</td> 
					<td title="${report.diSignNum}">${report.diSignNum}</td> 
					<td title="<fmt:formatNumber value="${report.diHasNum==0?0:(report.diSignNum/report.diHasNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.diHasNum==0?0:(report.diSignNum/report.diHasNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 肺结核患者-->
					<td title="${report.tubercManageNum}">${report.tubercManageNum}</td> 
					<td title="${report.tubercSignNum}">${report.tubercSignNum}</td> 
					<td title="<fmt:formatNumber value="${report.tubercManageNum==0?0:(report.tubercSignNum/report.tubercManageNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.tubercManageNum==0?0:(report.tubercSignNum/report.tubercManageNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 严重精神障碍患者-->
					<td title="${report.mentalManageNum}">${report.mentalManageNum}</td> 
					<td title="${report.mentalSignNum}">${report.mentalSignNum}</td> 
					<td title="<fmt:formatNumber value="${report.mentalManageNum==0?0:(report.mentalSignNum/report.mentalManageNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.mentalManageNum==0?0:(report.mentalSignNum/report.mentalManageNum)*100}" pattern="#,##0.0"/>% 
					</td>
				</tr>
			</c:forEach>
			<c:if test="${census!=null}">
				<tr>
					<td colspan="2"><strong>合计</strong></td>
					<!-- 已组建家庭医生团队数（个） -->
						<td title="${census.doctorTeamNum }">${census.doctorTeamNum }</td>
						
						<!-- 户籍人口数（人） -->
						<td title="${census.householdNum }">${census.householdNum }</td>
						
						<!-- 常住人口 -->
						<td title="${census.permanentNum}">${census.permanentNum}</td>
						<td title="${census.permanentSignNum}">${census.permanentSignNum}</td>
						<td title="<fmt:formatNumber value="${census.permanentNum==0?0:(census.permanentSignNum/census.permanentNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.permanentNum==0?0:(census.permanentSignNum/census.permanentNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 重点人群 -->
						<td title="${census.focusGroupsNum}">${census.focusGroupsNum}</td>
						<td title="${census.focusGroupsSignNum}">${census.focusGroupsSignNum}</td>
						<td title="<fmt:formatNumber value="${census.focusGroupsNum==0?0:(census.focusGroupsSignNum/census.focusGroupsNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.focusGroupsNum==0?0:(census.focusGroupsSignNum/census.focusGroupsNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 0-6岁儿童-->
						<td title="${census.childNum}">${census.childNum}</td>
						<td title="${census.familyVisitNum}">${census.familyVisitNum}</td>
						<td title="${census.childSignNum}">${census.childSignNum}</td>
						<td title="<fmt:formatNumber value="${census.childNum==0?0:(census.childSignNum/census.childNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.childNum==0?0:(census.childSignNum/census.childNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 65岁及以上常住居民-->
						<td title="${census.householdGreatSixfNum}">${census.householdGreatSixfNum}</td>
						<td title="${census.greatSixfHasNum}">${census.greatSixfHasNum}</td>
						<td title="${census.greatSixfSignNum}">${census.greatSixfSignNum}</td>
						<td title="<fmt:formatNumber value="${census.greatSixfHasNum==0?0:(census.greatSixfSignNum/census.greatSixfHasNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.greatSixfHasNum==0?0:(census.greatSixfSignNum/census.greatSixfHasNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 孕产妇-->
						<td title="${census.womenNum}">${census.womenNum}</td>
						<td title="${census.womenSignNum}">${census.womenSignNum}</td>
						<td title="<fmt:formatNumber value="${census.womenNum==0?0:(census.womenSignNum/census.womenNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.womenNum==0?0:(census.womenSignNum/census.womenNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 高血压患者-->
						<td title="${census.hbpNum}">${census.hbpNum}</td>
						<td title="${census.hbpHasNum}">${census.hbpHasNum}</td>
						<td title="${census.hbpSignNum}">${census.hbpSignNum}</td>
						<td title="<fmt:formatNumber value="${census.hbpHasNum==0?0:(census.hbpSignNum/census.hbpHasNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.hbpHasNum==0?0:(census.hbpSignNum/census.hbpHasNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 糖尿病患者-->
						<td title="${census.diNum}">${census.diNum}</td> 
						<td title="${census.diHasNum}">${census.diHasNum}</td> 
						<td title="${census.diSignNum}">${census.diSignNum}</td> 
						<td title="<fmt:formatNumber value="${census.diHasNum==0?0:(census.diSignNum/census.diHasNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.diHasNum==0?0:(census.diSignNum/census.diHasNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 肺结核患者-->
						<td title="${census.tubercManageNum}">${census.tubercManageNum}</td> 
						<td title="${census.tubercSignNum}">${census.tubercSignNum}</td> 
						<td title="<fmt:formatNumber value="${census.tubercManageNum==0?0:(census.tubercSignNum/census.tubercManageNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.tubercManageNum==0?0:(census.tubercSignNum/census.tubercManageNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 严重精神障碍患者-->
						<td title="${census.mentalManageNum}">${census.mentalManageNum}</td> 
						<td title="${census.mentalSignNum}">${census.mentalSignNum}</td> 
						<td title="<fmt:formatNumber value="${census.mentalManageNum==0?0:(census.mentalSignNum/census.mentalManageNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.mentalManageNum==0?0:(census.mentalSignNum/census.mentalManageNum)*100}" pattern="#,##0.0"/>% 
						</td>
				</tr>
			</c:if> --%>
			<c:if test="${not empty examinationList }">
		<tr>
			<ehr:pagination action="hmManageSearch.search" colspan="58"/>
		</tr>
	</c:if>
		</tbody>
	</table>
	
</div>