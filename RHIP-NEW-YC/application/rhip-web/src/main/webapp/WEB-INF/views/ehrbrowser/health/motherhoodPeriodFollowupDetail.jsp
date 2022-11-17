<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">孕产期保健服务与高危管理随访</li>
	</ul>
	<br/>
	<div class="table-basic">
		<table class="layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 23%;"/>
	            <col style="width: 27%;"/>
				<col style="width: 23%;"/>
	            <col style="width: 27%;"/>
			</colgroup>
			<tr>
				<th>母亲姓名</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.motherName}" ></c:out></td>
				<th>出生日期</th>                        
				<td><fmt:formatDate value="${motherhoodPeriodFollowup.birthday}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>民族</th>                        
				<td><ehr:dic code="${motherhoodPeriodFollowup.nation}" dicmeta="GBT3304"></ehr:dic></td>
				<th>文化程度</th>                    
				<td><ehr:dic code="${motherhoodPeriodFollowup.education}" dicmeta="GBT46582006"></ehr:dic></td>
			</tr>
			<tr>
				<th>本人电话号码</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.phoneNumber}" ></c:out></td>
				<th>身份证件号码</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.idcard}" ></c:out></td>
			</tr>
			<tr>
				<th>其他证件类别</th>                
				<td><ehr:dic code="${motherhoodPeriodFollowup.otherIdcardType}" dicmeta="CV0201101"></ehr:dic></td>
				<th>其他证件号码</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.otherIdcard}" ></c:out></td>
			</tr>
			<tr>
				<th>职业类别</th>              
				<td><ehr:dic code="${motherhoodPeriodFollowup.occupationType}" dicmeta="GBT6565"></ehr:dic></td>
				<th>工作单位名称</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.unitName}" ></c:out></td>
			</tr>
			<tr>
				<th>配偶姓名</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.spouseName}" ></c:out></td>
				<th>配偶出生日期</th>                    
				<td><fmt:formatDate value="${motherhoodPeriodFollowup.spouseBirthday}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>配偶民族</th>                    
				<td><ehr:dic code="${motherhoodPeriodFollowup.spouseNation}" dicmeta="GBT3304"></ehr:dic></td>
				<th>配偶文化程度</th>                
				<td><ehr:dic code="${motherhoodPeriodFollowup.spouseEducation}" dicmeta="GBT46582006"></ehr:dic></td>
			</tr>
			<tr>
				<th>配偶身份证件号码</th>               
				<td colspan="3"><c:out value="${motherhoodPeriodFollowup.spouseIdcard}" /></td>
			</tr>
			<tr>
				<th>配偶职业类别</th>          
				<td><ehr:dic code="${motherhoodPeriodFollowup.spouseOccupation}" dicmeta="GBT6565"></ehr:dic></td>
				<th>配偶工作单位名称</th>                
				<td><c:out value="${motherhoodPeriodFollowup.spouseUnitName}" ></c:out></td>
			</tr>
			<tr>
				<th>新生儿姓名</th>                      
				<td><c:out value="${motherhoodPeriodFollowup.neonatalName}" ></c:out></td>
				<th>新生儿性别</th>                  
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.neonatalGender}" dicmeta="GBT226112003"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>户籍地址</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.hrprovince}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.hrcity}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.hrcounty}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.hrtownShip}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.hrstreet}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.hrhouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>户籍地址邮政编码</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.hrpostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.paprovince}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.pacity}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.pacounty}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.patownShip}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.pastreet}"></c:out>
					<c:out value="${motherhoodPeriodFollowup.pahouseNumber}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现住址邮政编码</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.papostCode}"></c:out>
				</td>
			</tr>
			<tr>
				<th>现病史</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.presentHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>既往疾病史</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.pastMedicalHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>手术史</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.operationHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>过敏史</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.allergicHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>家族遗传性疾病史</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.familyGeneDiseaseHistory}"></c:out>
				</td>
			</tr>
			<tr>
				<th>初潮年龄(岁)</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.menarcheAge}" ></c:out></td>
				<th>痛经程度</th>                    
				<td><ehr:dic code="${motherhoodPeriodFollowup.dysmenorrheaDegree}" dicmeta="FS10041"></ehr:dic></td>
			</tr>
			<tr>
				<th>月经持续时间(d)</th>                 
				<td><c:out value="${motherhoodPeriodFollowup.menstrualDuration}" ></c:out></td>
				<th>月经出血量</th>              
				<td><ehr:dic code="${motherhoodPeriodFollowup.menstrualBleedingType}" dicmeta="FS10028"></ehr:dic></td>
			</tr>
			<tr>
				<th>月经周期(d)</th>                     
				<td><c:out value="${motherhoodPeriodFollowup.menstrualCycle}" ></c:out></td>
				<th>末次月经日期</th>                    
				<td><fmt:formatDate value="${motherhoodPeriodFollowup.lastMenstrualDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>孕次</th>                            
				<td><c:out value="${motherhoodPeriodFollowup.gravidityTimes}" ></c:out></td>
				<th>产次</th>                            
				<td><c:out value="${motherhoodPeriodFollowup.productionTimes}" ></c:out></td>
			</tr>
			<tr>
				<th>早产次数</th>                        
				<td colspan="3"><c:out value="${motherhoodPeriodFollowup.prematureDeliveryTimes}" ></c:out></td>
			</tr>
			<tr>
				<th>自然流产次数</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.spontaneousAbortionTimes}" ></c:out></td>
				<th>人工流产次数</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.artificialAbortionTimes}" ></c:out></td>
			</tr>
			<tr>
				<th>剖宫产次数</th>                      
				<td><c:out value="${motherhoodPeriodFollowup.cesareanSectionTimes}" ></c:out></td>
				<th>阴道助产次数</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.vaginaDeliveryTimes}" ></c:out></td>
			</tr>
			<tr>
				<th>死胎例数</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.stillbirthCasesNumber}" ></c:out></td>
				<th>死产例数</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.stillbornCasesNumber}" ></c:out></td>
			</tr>
			<tr>
				<th>前次分娩方式</th>                
				<td><ehr:dic code="${motherhoodPeriodFollowup.previousChildbirthWay}" dicmeta="CV0210003"></ehr:dic></td>
				<th>前次妊娠终止方式</th>            
				<td><ehr:dic code="${motherhoodPeriodFollowup.previousPregnancyEndWay}" dicmeta="CV0210002"></ehr:dic></td>
			</tr>
			<tr>
				<th>前次妊娠终止日期</th>
				<td><fmt:formatDate value="${motherhoodPeriodFollowup.previousPregnancyEndDate}" pattern="yyyy/MM/dd"/></td>
				<th>前次分娩日期</th>
				<td><fmt:formatDate value="${motherhoodPeriodFollowup.previousChildbirthDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>收缩压(mmHg)</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.dbp}" ></c:out></td>
				<th>舒张压(mmHg)</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.sbp}" ></c:out></td>
			</tr>
			<tr>
				<th>基础收缩压(mmHg)</th>                
				<td><c:out value="${motherhoodPeriodFollowup.baseDbp}" ></c:out></td>
				<th>基础舒张压(mmHg)</th>                
				<td><c:out value="${motherhoodPeriodFollowup.baseSbp}" ></c:out></td>
			</tr>
			<tr>
				<th>体温(℃)</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.temperature}" ></c:out></td>
				<th>体重(kg)</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.weight}" ></c:out></td>
			</tr>
			<tr>
				<th>基础体重(kg)</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.baseWeight}" ></c:out></td>
				<th>腹围(cm)</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.abdominalGirth}" ></c:out></td>
			</tr>
			<tr>
				<th>症状</th>                            
				<td colspan="3"><c:out value="${motherhoodPeriodFollowup.symptom}" ></c:out></td>
			</tr>
			<tr>
				<th>体征</th>                            
				<td colspan="3"><c:out value="${motherhoodPeriodFollowup.signs}" ></c:out></td>
			</tr>
			<tr>
				<th>心率(次/分钟)</th>                   
				<td><c:out value="${motherhoodPeriodFollowup.heartRate}" ></c:out></td>
				<th>胎心率(次/分钟)</th>                 
				<td><c:out value="${motherhoodPeriodFollowup.fetalHeartRate}" ></c:out></td>
			</tr>
			<tr>
				<th>分娩孕周</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.deliveryWeek}" ></c:out></td>
				<th>分娩日期时间</th>                    
				<td>
                    <%--2014-07-08 修改 刘洋  臻鼎数据只显示年月日--%>
                    <%--<fmt:formatDate value="${motherhoodPeriodFollowup.deliveryDate}" pattern="yyyy/MM/dd HH:mm:dd"/>--%>
                    <fmt:formatDate value="${motherhoodPeriodFollowup.deliveryDate}" pattern="yyyy/MM/dd"/>
                </td>
			</tr>
			<tr>
				<th>分娩方式</th>
				<td><ehr:dic dicmeta="CV0210003" code="${motherhoodPeriodFollowup.deliveryWay}"></ehr:dic>
				</td>
				<th>分娩结局</th>
				<td><c:out value="${motherhoodPeriodFollowup.deliveryOutcome}" ></c:out></td>
			</tr>
			<tr>
				<th>总产程时长(min)</th>                 
				<td><c:out value="${motherhoodPeriodFollowup.totalLaborRuntime}" ></c:out></td>
				<th>第一产程时长(min)</th>               
				<td><c:out value="${motherhoodPeriodFollowup.firstTotalLaborRuntime}" ></c:out></td>
			</tr>
			<tr>
				<th>第二产程时长(min)</th>               
				<td><c:out value="${motherhoodPeriodFollowup.secondTotalLaborRuntime}" ></c:out></td>
				<th>第三产程时长(min)</th>               
				<td><c:out value="${motherhoodPeriodFollowup.thirdTotalLaborRuntime}" ></c:out></td>
			</tr>
			<tr>
				<th>产后开奶时长(min)</th>               
				<td><c:out value="${motherhoodPeriodFollowup.postpartumOpenMilkRuntime}" ></c:out></td>
				<th>产后天数(d)</th>                     
				<td><c:out value="${motherhoodPeriodFollowup.postpartumDays}" ></c:out></td>
			</tr>
			<tr>
				<th>产时并发症</th>                  
				<td><ehr:dic dicmeta="CV0501009" code="${motherhoodPeriodFollowup.complicationsCode}"></ehr:dic></td>
				<th>总出血量(ml)</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.deliveryTotalBleed}" ></c:out></td>
			</tr>
			<tr>
				<th>产时出血量(ml)</th>                  
				<td><c:out value="${motherhoodPeriodFollowup.deliveryBleed}" ></c:out></td>
				<th>产后两小时出血量(ml)</th>            
				<td><c:out value="${motherhoodPeriodFollowup.deliveryTwoBleed}" ></c:out></td>
			</tr>
			<tr>
				<th>新生儿体温(℃)</th>                  
				<td><c:out value="${motherhoodPeriodFollowup.neonatalTemperature}" ></c:out></td>
				<th>新生儿心率(次/分钟)</th>             
				<td><c:out value="${motherhoodPeriodFollowup.neonatalHeartRate}" ></c:out></td>
			</tr>
			<tr>
				<th>体重(g)</th>                         
				<td><c:out value="${motherhoodPeriodFollowup.neonatalWeight}" ></c:out></td>
				<th>身长(cm)</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.neonatalStature}" ></c:out></td>
			</tr>
			<tr>
				<th>身高(cm)</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.neonatalHeight}" ></c:out></td>
				<th>头围(cm)</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.neonatalHeadCircumference}" ></c:out></td>
			</tr>
			<tr>
				<th>胸围(cm)</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.neonatalBust}" ></c:out></td>
				<th>新生儿心脏听诊结果</th>              
				<td><c:out value="${motherhoodPeriodFollowup.neonatalCardiacAuscuResult}" ></c:out></td>
			</tr>
			<tr>
				<th>新生儿肺部听诊结果</th>              
				<td><c:out value="${motherhoodPeriodFollowup.neonatalLungAuscuResult}" ></c:out></td>
				<th>恶露状况</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.lochiaCondition}" ></c:out></td>
			</tr>
			<tr>
				<th>预产期</th>                          
				<td><fmt:formatDate value="${motherhoodPeriodFollowup.estimatedDueDates}" pattern="yyyy/MM/dd"/></td>
				<th>孕期异常情况记录</th>                
				<td><c:out value="${motherhoodPeriodFollowup.pregnancyAnomaliesRecord}" ></c:out></td>
			</tr>
			<tr>
				<th>早孕反应开始孕周</th>                
				<td><c:out value="${motherhoodPeriodFollowup.earlyResponseStartWeek}" ></c:out></td>
				<th>早孕反应标志</th>                    
				<td>
                    <c:if test="${!empty motherhoodPeriodFollowup.earlyResponseFlag}">
                         <c:out value="${motherhoodPeriodFollowup.earlyResponseFlag eq '1' ? '是' : '否'}" ></c:out>
                    </c:if>
                </td>
			</tr>
			<tr>
				<th>危重孕产妇标志</th>                  
				<td>
                    <c:if test="${!empty motherhoodPeriodFollowup.severeMaternalFlag}">
                        <c:out value="${motherhoodPeriodFollowup.severeMaternalFlag eq '1' ? '是' : '否'}" ></c:out>
                    </c:if>
                </td>
				<th>孕产期高危因素</th>             
				<td><ehr:dic dicmeta="CV0300402" code="${motherhoodPeriodFollowup.riskFactorCode}"></ehr:dic></td>
			</tr>
			<tr>
				<th>孕产期高危标志</th>             
				<td>
                    <c:if test="${!empty motherhoodPeriodFollowup.riskFactorFlag}">
                        <c:out value="${motherhoodPeriodFollowup.riskFactorFlag eq '1' ? '是' : '否'}" ></c:out>
                    </c:if>
                </td>
				<th>高危评分日期</th>                    
				<td>
                    <%--2014-07-08 修改 刘洋 臻鼎数据只显示年月日--%>
                    <%--<c:out value="${motherhoodPeriodFollowup.riskScoreDate}" ></c:out>--%>
                    <fmt:formatDate value="${motherhoodPeriodFollowup.riskScoreDate}" pattern="yyyy/MM/dd"/>
                </td>
			</tr>
			<tr>
				<th>高危评分孕周</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.riskScorePreWeek}" ></c:out></td>
				<th>高危评分值(分)</th>                  
				<td><c:out value="${motherhoodPeriodFollowup.riskScoreValue}" ></c:out></td>
			</tr>
			<tr>
				<th>高危妊娠级别</th>                
				<td><ehr:dic dicmeta="FS10030" code="${motherhoodPeriodFollowup.riskPregnancyLevel}"></ehr:dic></td>
				<th>宫底高度(cm)</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.uterineBottomHeight}" ></c:out></td>
			</tr>
			<tr>
				<th>骶耻外径(cm)</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.externalConjugate}" ></c:out></td>
				<th>髂棘间径(cm)</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.interSpinousDiameter}" ></c:out></td>
			</tr>
			<tr>
				<th>髂嵴间径(cm)</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.interCrestalDiameter}" ></c:out></td>
				<th>坐骨结节间径(cm)</th>                
				<td><c:out value="${motherhoodPeriodFollowup.chialTuberosityDiameter}" ></c:out></td>
			</tr>
			<tr>
				<th>骨盆测量日期</th>                    
				<td><fmt:formatDate value="${motherhoodPeriodFollowup.pelvimetryDate}" pattern="yyyy/MM/dd"/></td>
				<th>骨盆测量孕周</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.pelvimetryPreWeek}" ></c:out></td>
			</tr>
			<tr>
				<th>口腔检查结果</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.oralExaminationResult}" ></c:out></td>
				<th>心脏听诊结果</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.cardiacAuscuResult}" ></c:out></td>
			</tr>
			<tr>
				<th>肺部听诊结果</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.lungAuscuResult}" ></c:out></td>
				<th>肝脏触诊结果</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.liverPalpResult}" ></c:out></td>
			</tr>
			<tr>
				<th>脾脏触诊结果</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.spleenPalpResult}" ></c:out></td>
				<th>宫颈检查结果</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.cervixCheckResult}" ></c:out></td>
			</tr>
			<tr>
				<th>阴道检查结果</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.vaginaCheckResult}" ></c:out></td>
				<th>会阴-切开标志</th>                   
				<td><c:if test="${!empty motherhoodPeriodFollowup.perineumCutFlag}">
                        <c:out value="${motherhoodPeriodFollowup.perineumCutFlag eq '1' ? '是' : '否'}" ></c:out>
                    </c:if>
                </td>
			</tr>
			<tr>
				<th>会阴-缝合针数</th>                   
				<td><c:out value="${motherhoodPeriodFollowup.perineumTearNeedleNumber}" ></c:out></td>
				<th>会阴裂伤程度</th>                
				<td>
					<ehr:dic dicmeta="CV0501010" code="${motherhoodPeriodFollowup.perineumTearDegree}"/>
				</td>
			</tr>
			<tr>
				<th>子宫检查结果</th>                    
				<td colspan="3"><c:out value="${motherhoodPeriodFollowup.uterusCheckResult}" ></c:out></td>
			</tr>
			<tr>
				<th>左侧附件检查结果</th>            
				<td><ehr:dic dicmeta="CV0410001" code="${motherhoodPeriodFollowup.lAttachmentCheckResult}"></ehr:dic></td>
				<th>右侧附件检查结果</th>            
				<td><ehr:dic dicmeta="CV0410001" code="${motherhoodPeriodFollowup.rAttachmentCheckResult}"></ehr:dic></td>
			</tr>
			<tr>
				<th>左侧乳腺检查结果</th>            
				<td><ehr:dic dicmeta="CV0410012" code="${motherhoodPeriodFollowup.lBreastCheckResult}"></ehr:dic></td>
				<th>右侧乳腺检查结果</th>            
				<td><ehr:dic dicmeta="CV0410012" code="${motherhoodPeriodFollowup.rBreastCheckResult}"></ehr:dic></td>
			</tr>
			<tr>
				<th>脊柱检查结果</th>                    
				<td colspan="3"><c:out value="${motherhoodPeriodFollowup.spineCheckResult}" ></c:out></td>
			</tr>
			<tr>
				<th>甲状腺检查结果</th>                  
				<td><c:out value="${motherhoodPeriodFollowup.thyroidCheckResult}" ></c:out></td>
				<th>皮肤毛发检查结果</th>                
				<td><c:out value="${motherhoodPeriodFollowup.skinHairCheckResult}" ></c:out></td>
			</tr>
			<tr>
				<th>脐部检查结果</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.umbilicusCheckResult}" ></c:out></td>
				<th>外阴检查结果</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.vulvaCheckResult}" ></c:out></td>
			</tr>
			<tr>
				<th>乳头检查结果</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.nippleCheckResult}" ></c:out></td>
				<th>乳汁量</th>                      
				<td><ehr:dic dicmeta="CV0401002" code="${motherhoodPeriodFollowup.milkVolumeCode}"></ehr:dic></td>
			</tr>
			<tr>
				<th>四肢检查结果</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.limbsCheckResult}" ></c:out></td>
				<th>浮肿程度</th>                    
				<td><ehr:dic dicmeta="CV0410005" code="${motherhoodPeriodFollowup.edemaDegreeCode}"></ehr:dic></td>
			</tr>
			<tr>
				<th>衔接标志</th>                        
				<td><c:if test="${!empty motherhoodPeriodFollowup.joinFlag}">
                        <c:out value="${motherhoodPeriodFollowup.joinFlag eq '1' ? '有' : '无'}" ></c:out>
                    </c:if>
                </td>
				<th>B超检查结果</th>                     
				<td><c:out value="${motherhoodPeriodFollowup.bmodeCheckResult}" ></c:out></td>
			</tr>
			<tr>
				<th>新生儿睡眠状况</th>                  
				<td><c:out value="${motherhoodPeriodFollowup.neonatalSleepCondition}" ></c:out></td>
				<th>胎动孕周</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.fetalPregnantWeek}" ></c:out></td>
			</tr>
			<tr>
				<th>胎方位</th>                      
				<td><ehr:dic dicmeta="CV0501007" code="${motherhoodPeriodFollowup.fetalPosition}"></ehr:dic></td>
				<th>胎数</th>                            
				<td><c:out value="${motherhoodPeriodFollowup.gestationalNumber}" ></c:out></td>
			</tr>
			<tr>
				<th>胎先露</th>                      
				<td colspan="3"><ehr:dic dicmeta="CV0501008" code="${motherhoodPeriodFollowup.fetalCode}"></ehr:dic></td>
			</tr>
			<tr>
				<th>ABO血型</th>                     
				<td><ehr:dic dicmeta="CV0450005" code="${motherhoodPeriodFollowup.aboBloodType}"></ehr:dic></td>
				<th>Rh血型</th>                      
				<td>
					<ehr:dic dicmeta="FS10010" code="${motherhoodPeriodFollowup.rhBloodType}"/>
				</td>
				
			</tr>
			<tr>
				<th>新生儿黄疸程度</th>              
				<td><ehr:dic dicmeta="CV0501012" code="${motherhoodPeriodFollowup.neonatalJaundiceDegree}"></ehr:dic></td>
			</tr>
			<tr>
				<th>肝功能检测结果</th>              
				<td><ehr:dic dicmeta="FS10143" code="${motherhoodPeriodFollowup.liverDetectResult}"></ehr:dic></td>
				<th>肾功能检测结果</th>              
				<td><ehr:dic dicmeta="FS10167" code="${motherhoodPeriodFollowup.renalDetectResult}"></ehr:dic></td>
			</tr>
			<tr>
				<th>血β-绒毛膜促性腺激素值(IU/L)</th>    
				<td><c:out value="${motherhoodPeriodFollowup.serumBhcgValue}" ></c:out></td>
				<th>血糖检测值(mmol/L)</th>              
				<td><c:out value="${motherhoodPeriodFollowup.bloodGlucoseValues}" ></c:out></td>
			</tr>
			<tr>
				<th>白细胞计数值(G/L)</th>               
				<td><c:out value="${motherhoodPeriodFollowup.leukocyteCount}" ></c:out></td>
				<th>红细胞计数值(G/L)</th>               
				<td><c:out value="${motherhoodPeriodFollowup.erythrocyteCount}" ></c:out></td>
			</tr>
			<tr>
				<th>血小板计数值(G/L)</th>               
				<td><c:out value="${motherhoodPeriodFollowup.plateletCount}" ></c:out></td>
				<th>出血时间(s)</th>                     
				<td><c:out value="${motherhoodPeriodFollowup.bleedingTime}" ></c:out></td>
			</tr>
			<tr>
				<th>凝血时间(s)</th>                     
				<td><c:out value="${motherhoodPeriodFollowup.coagulationTime}" ></c:out></td>
				<th>血红蛋白值(g/L)</th>                 
				<td><c:out value="${motherhoodPeriodFollowup.hemoglobinValue}" ></c:out></td>
			</tr>
			<tr>
				<th>血清谷丙转氨酶值(U/L)</th>           
				<td><c:out value="${motherhoodPeriodFollowup.serumGptValue}" ></c:out></td>
				<th>尿比重</th>                          
				<td><c:out value="${motherhoodPeriodFollowup.urineProportion}" ></c:out></td>
			</tr>
			<tr>
				<th>尿蛋白定量检测值(mg/24h)</th>        
				<td><c:out value="${motherhoodPeriodFollowup.urineProQuantitativeValue}" ></c:out></td>
				<th>尿糖定量检测(mmol/L)</th>            
				<td><c:out value="${motherhoodPeriodFollowup.urineSugQuantitativeDetect}" ></c:out></td>
			</tr>
			<tr>
				<th>尿液酸碱度</th>                      
				<td><c:out value="${motherhoodPeriodFollowup.urinePh}" ></c:out></td>
				<th>阴道分泌物性状描述</th>              
				<td><c:out value="${motherhoodPeriodFollowup.vaginaSecretionsDesc}" ></c:out></td>
			</tr>
			<tr>
				<th>滴虫检测结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.trichomoDetectResult}" dicmeta="FS10045"></ehr:dic>
				</td>
				<th>念珠菌检测结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.candidaDetectResult}" dicmeta="FS10044"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>阴道分泌物清洁度</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.vaginaSecretionsCleanliness}" dicmeta="CV0450010"></ehr:dic>
				</td>
				<th>梅毒血清学试验结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.syphilisSerologyCheckResult}" dicmeta="FS10058"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>乙型肝炎病毒表面抗原检测结果</th>
				<td>
					<ehr:dic code="${motherhoodPeriodFollowup.hbsagDetectResult}" dicmeta="FS10092"></ehr:dic>
				</td>
				<th>淋球菌检查结果</th>
				<td colspan="3">
					<c:out value="${motherhoodPeriodFollowup.NGonorrhoeaeCheckResult}"></c:out>
				</td>
			</tr>
			<tr>
				<th>HIV抗体检测结果</th>
				<td>
                    <ehr:dic code="${motherhoodPeriodFollowup.hivlgDetectResult}" dicmeta="FS10056"></ehr:dic>
				</td>
				<th>喂养方式类别</th>
				<td>
					<ehr:dic dicmeta="FS10026" code="${motherhoodPeriodFollowup.feedingType}"></ehr:dic>
				</td>
			</tr>
			<tr>
				<th>臀红标志</th>                        
				<td><c:if test="${!empty motherhoodPeriodFollowup.hipRedFlag}">
                        <c:out value="${motherhoodPeriodFollowup.hipRedFlag eq '1' ? '是' : '否'}" ></c:out>
                    </c:if>
                </td>
				<th>Apgar评分值(分)</th>                 
				<td><c:out value="${motherhoodPeriodFollowup.apgarValue}" ></c:out></td>
			</tr>
			<tr>
				<th>新生儿小便状况记录</th>              
				<td><c:out value="${motherhoodPeriodFollowup.neonatalPeereCord}" ></c:out></td>
				<th>新生儿大便状况记录</th>              
				<td><c:out value="${motherhoodPeriodFollowup.neonatalFecalRecord}" ></c:out></td>
			</tr>
			<tr>
				<th>新生儿特殊情况记录</th>              
				<td><c:out value="${motherhoodPeriodFollowup.neonatalSpecialCase}" ></c:out></td>
				<th>辅助检查-结果</th>                   
				<td><c:out value="${motherhoodPeriodFollowup.aeResult}" ></c:out></td>
			</tr>
			<tr>
				<th>辅助检查-项目名称</th>               
				<td><c:out value="${motherhoodPeriodFollowup.aeItemName}" ></c:out></td>
				<th>产后42天检查结果</th>                
				<td><c:out value="${motherhoodPeriodFollowup.postpartumDaysCheckResult}" ></c:out></td>
			</tr>
			<tr>
				<th>转诊记录</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.referralRecord}" ></c:out></td>
				<th>孕产妇高危筛查机构名称</th>          
				<td><c:out value="${motherhoodPeriodFollowup.riskScreenOrganName}" ></c:out></td>
			</tr>
			<tr>
				<th>高危妊娠转归</th>                
				<td><ehr:dic dicmeta="FS10030" code="${motherhoodPeriodFollowup.riskPregProgCode}"></ehr:dic></td>
				<th>妊娠合并症/并发症史</th>             
				<td><c:out value="${motherhoodPeriodFollowup.complicationHistory}" ></c:out></td>
			</tr>
			<tr>
				<th>妊娠诊断方法</th>                
				<td><ehr:dic code="${motherhoodPeriodFollowup.pregDiagnosisWay}" dicmeta="CV0450012"></ehr:dic></td>
				<th>伤口愈合状况</th>                
				<td><ehr:dic code="${motherhoodPeriodFollowup.woundHealingStatus}" dicmeta="CV0501011"></ehr:dic></td>
			</tr>
			<tr>
				<th>出生缺陷标志</th>                    
				<td><c:if test="${!empty motherhoodPeriodFollowup.birthDefectFlag}">
                        <c:out value="${motherhoodPeriodFollowup.birthDefectFlag eq '1' ? '是':'否'}" ></c:out>
                    </c:if>
                </td>
				<th>出生缺陷类别</th>                
				<td><ehr:dic dicmeta="CV0210004" code="${motherhoodPeriodFollowup.birthDefectType}"/></td>
			</tr>
			<tr>
				<th>出生缺陷儿例数</th>                  
				<td colspan="3"><c:out value="${motherhoodPeriodFollowup.birthDefectsNumber}" ></c:out></td>
			</tr>
			<tr>
				<th>新生儿并发症-标志</th>               
				<td>
                    <c:if test="${!empty motherhoodPeriodFollowup.neonatalComplicationsFlag}">
                        <c:out value="${motherhoodPeriodFollowup.neonatalComplicationsFlag eq '1' ? '是' : '否'}" ></c:out>
                    </c:if>
                </td>
				<th>新生儿并发症</th>               
				<td><ehr:dic code="${motherhoodPeriodFollowup.neonatalComplicationsCode}" dicmeta="CV0501013"></ehr:dic></td>
			</tr>
			<tr>
				<th>新生儿疾病筛查标志</th>              
				<td>
                    <c:if test="${!empty motherhoodPeriodFollowup.neonatalScreeningFlag}">
                        <c:out value="${motherhoodPeriodFollowup.neonatalScreeningFlag eq '1' ? '是' : '否'}" ></c:out>
                    </c:if>
                </td>
				<th>新生儿抢救标志</th>                  
				<td><c:if test="${!empty motherhoodPeriodFollowup.neonatalRescueFlag}">
                        <c:out value="${motherhoodPeriodFollowup.neonatalRescueFlag eq '1' ? '是' : '否'}" ></c:out>
                    </c:if>
                </td>
			</tr>
			<tr>
				<th>新生儿抢救方法</th>              
				<td><ehr:dic code="${motherhoodPeriodFollowup.neonatalRescueMethod}" dicmeta="CV0600108"></ehr:dic></td>
				<th>孕产妇死亡时间类别</th>          
				<td><ehr:dic code="${motherhoodPeriodFollowup.maternalDeathtimeType}" dicmeta="FS10029"></ehr:dic></td>
			</tr>
			<tr>
				<th>处理及指导意见</th>                  
				<td><c:out value="${motherhoodPeriodFollowup.mgOpinion}" ></c:out></td>
				<th>新生儿处理及指导意见</th>            
				<td><c:out value="${motherhoodPeriodFollowup.maternalMgOpinion}" ></c:out></td>
			</tr>
			<tr>
				<th>计划生育指导内容</th>                
				<td colspan="3"><c:out value="${motherhoodPeriodFollowup.familyPlanGuidance}" ></c:out></td>
			</tr>
			<tr>
				<th>宣教内容</th>                        
				<td colspan="3"><c:out value="${motherhoodPeriodFollowup.missionaryContent}" ></c:out></td>
			</tr>
			<tr>
				<th>检查(测)人员姓名</th>                
				<td><c:out value="${motherhoodPeriodFollowup.checkName}" ></c:out></td>
				<th>检查(测)日期</th>                    
				<td colspan="3">
					<fmt:formatDate value="${motherhoodPeriodFollowup.checkDate}" pattern="yyyy/MM/dd"/>
				</td>
			</tr>
			<tr>
				<th>检查(测)机构名称</th>                
				<td colspan="3"><c:out value="${motherhoodPeriodFollowup.checkOrganName}" ></c:out></td>
			</tr>
			<tr>
				<th>助产人员姓名</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.midwiferyName}" ></c:out></td>
				<th>建档孕周</th>                        
				<td><c:out value="${motherhoodPeriodFollowup.inputGestationalWeek}" ></c:out></td>
			</tr>
			<tr>
				<th>助产机构名称</th>                    
				<td colspan="3"><c:out value="${motherhoodPeriodFollowup.midwiferyOrganName}" ></c:out></td>
			</tr>
			<tr>
				<th>建档人员姓名</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.inputName}" ></c:out></td>
				<th>建档机构名称</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.inputOrganName}" ></c:out></td>
			</tr>
			<tr>
				<th>结案日期</th>                        
				<td><fmt:formatDate value="${motherhoodPeriodFollowup.closedDate}" pattern="yyyy/MM/dd"/></td>
				<th>结案单位名称</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.closedUnitName}" ></c:out></td>
			</tr>
			<tr>
				<th>预约日期</th>                        
				<td><fmt:formatDate value="${motherhoodPeriodFollowup.reservationDate}" pattern="yyyy/MM/dd"/></td>
				<th>访视日期</th>                        
				<td><fmt:formatDate value="${motherhoodPeriodFollowup.interviewDate}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>访视人员姓名</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.interviewName}" ></c:out></td>
				<th>访视机构名称</th>                    
				<td><c:out value="${motherhoodPeriodFollowup.interviewOrganName}" ></c:out></td>
			</tr>
		</table>
		<br/>
	</div>
</div>