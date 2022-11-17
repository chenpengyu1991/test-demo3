<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cleave/cleave.min.js"></script>
<div class="dm-followup-from-content">
<form id="dm-followup-di-from" class="dm-followup-from">
	<input type="hidden" name="id" value="${di.id}" />
	<input type="hidden" name="reasonFollowId" id="reasonFollowId" value="${reasonFollowId}" />
	<input type="hidden" name="planId" value="${di.planId}">
	<input type="hidden" name="planType" id="planType" value="${planType}"/>
	<div class="postcontent">
		<div class="postdiv">
			<fieldset class="layui-elem-field" style="margin-top: -10px;">
				<legend>随访填写</legend>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 100px; width: 30%" />
						<col style="min-width: 150px; width: 70%" />
					</colgroup>
					<tr>
						<th><label class="required" for="diVisitDateId">随访日期</label></th>
						<td>
						<%-- <tag:dateInput style="width:178px;" onlypast="true" id="visitDate" name="visitDate" date="${di.visitDate}" reg="{'required':true}" /> --%>
						<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" name="visitDate" id="diVisitDateId" value="<fmt:formatDate value='${di.visitDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:178px;" />
						</td>
					</tr>
					<tr>
						<th><label class="required" for="visitWayCode">随访方式</label></th>
						<td><ehr:dic-radio dicmeta="DMD00026" value="${di.visitWayCode}" reg="{'required':true}" name="visitWayCode"></ehr:dic-radio></td>
					</tr>
					<tr>
					<th><label class="required">症状</label></th>
						<td>
						<ehr:dic-radio dicmeta="FS10238"  reg="{'required':true}" name="curSymptomFlag" value="${di.curSymptomFlag }"></ehr:dic-radio>
						<div id="di-followup-curSymptomFlag" class="${di.curSymptomFlag!='2'?'hide':'' }">
						<ehr:dic-checkbox dicmeta="DMD00043" name="curSymptom" value="${di.curSymptom }" reg="{'required':true,'dependValue':'2','dependOn':'curSymptomFlag'}"/> 
						<input style="width: 100px;" reg="{'maxlength':100,'required':true,'dependValue':'10','dependOn':'curSymptom'}" type="text" name="otherSymptom" value="${di.otherSymptom}"></input>
						</div>
						</td>
					</tr>
				</table>
				<fieldset class="layui-elem-field">
					<legend>体征</legend>
					<table class="posttable">
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
						<tr>
							<th><label class="required" for="hbpDiagnosedOrganCode">血压</label></th>
							<td><tag:numberInput style="width:50px;" id="hbpSbp" name="sbp" value="${di.sbp}" reg="{'required':true,'min':0,'max':9999}" />/
								<tag:numberInput id="hbpSbp" name="dbp" value="${di.dbp}" style="width:50px;" reg="{'required':true,'min':0,'max':9999}" />mmHg</td>
						</tr>
						<tr>
							<th><label class="required" for="height">身高</label></th>
							<td><tag:numberInput style="width:110px;" point="point" id="height" name="height" value="${di.height}" reg="{'required':true,'min':0,'max':9999.9}" />cm</td>
						</tr>
						<tr>
							<th><label class="required" for="bodyWeight">体重</label></th>
							<td><tag:numberInput  style="width:50px;" point="point"  id="bodyWeight" name="bodyWeight" value="${di.bodyWeight}" reg="{'required':true,'min':0,'max':9999.9}" placeholder="目前值"/>/
								<tag:numberInput  style="width:50px;" point="point" id="nextFollowupBodyWeight" name="nextFollowupBodyWeight" value="${di.nextFollowupBodyWeight}" reg="{'required':true,'min':0,'max':9999.9}" placeholder="期望值"/>kg</td>
						</tr>
						<tr>
							<th><label class="" for="indexOfBodyCharacteristics">体质指数(BMI)</label></th>
							<td><input style="width:50px;" readonly="readonly" type="text" id="indexOfBodyCharacteristics" name="indexOfBodyCharacteristics" value="${di.indexOfBodyCharacteristics}" reg="{'min':0,'max':999.99}"/>/
								<input style="width:50px;" readonly="readonly" type="text" id="nextFollowupBmi" name="nextFollowupBmi" value="${di.nextFollowupBmi}" reg="{'min':0,'max':999.99}"/>kg/㎡ </td>
						</tr>
						<tr>
							<th><label class="required" for="heartRate">足背动脉搏动</label></th>
							<td>
								<ehr:dic-radio reg="{'required':true}" dicmeta="DMD00044" value="${di.heartRate }" name="heartRate"
											   onchange="toggleOther('heartRate','heartRateDiSpan',2)"/>
							<span style="display:${(di.heartRate =='1' || di.heartRate =='2') ?'none':'inline' }" id="heartRateDiSpan">
								（<ehr:dic-radio reg="{'required':true}" dicmeta="IDM00280" value="${di.heartRatePart }" name="heartRatePart"/>）
							</span>
							</td>
						</tr>

						<tr>
							<th>慢性咳嗽、咳痰≥2周</th>
							<td>
								<ehr:dic-radio dicmeta="FS10238" name="isSymptomChronicCough" value="${di.isSymptomChronicCough == null ? '1' : di.isSymptomChronicCough}"/>
							</td>
						</tr>
						<tr>
							<th>咯血、血痰</th>
							<td>
								<ehr:dic-radio dicmeta="FS10238" name="isHemosputum" value="${di.isHemosputum == null ? '1' : di.isHemosputum}"/>
							</td>
						</tr>
						<tr>
							<th>发热、盗汗、胸痛或不明原因消瘦≥2周</th>
							<td>
								<ehr:dic-radio dicmeta="FS10238" name="isSymptomChestPain" value="${di.isSymptomChestPain == null ? '1' : di.isSymptomChestPain}"/>
							</td>
						</tr>
						<tr>
							<th>其他</th>
							<td><input type="text" id="signOther" name="signOther" value="${di.signOther}" reg="{'maxlength':100}"/></td>
						</tr>
					</table>
				</fieldset>
				<fieldset class="layui-elem-field">
					<legend>生活方式指导</legend>
					<table class="posttable">
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
						<tr>
							<th><label class="required" for="dailySmoke">日吸烟量（支）</label></th>
							<td><tag:numberInput style="width:50px;" id="dailySmoke" name="dailySmoke" value="${di.dailySmoke}" reg="{'required':true,'min':0,'max':9999}" placeholder="目前值"/>/
								<tag:numberInput style="width:50px;" id="smokeberTarget" name="smokeberTarget" value="${di.smokeberTarget}" reg="{'required':true,'min':0,'max':9999}" placeholder="期望值"/></td>
						</tr>
						<tr>
							<th><label class="required" for="dailySmoke">日饮酒量（两）</label></th>
							<td><tag:numberInput style="width:50px;" id="dailyDrink" name="dailyDrink" value="${di.dailyDrink}" reg="{'required':true,'min':0,'max':9999}" placeholder="目前值"/>/
								<tag:numberInput style="width:50px;" id="nextFollowupDailyDrink" name="nextFollowupDailyDrink" value="${di.nextFollowupDailyDrink}" reg="{'required':true,'min':0,'max':9999}" placeholder="期望值"/></td>
						</tr>
						<tr>
							<th><label class="required" for="trainFrequencyType">运动</label></th>
							<td><tag:numberInput style="width:50px" id="trainFrequencyType" name="trainFrequencyType" value="${di.trainFrequencyType}"
									reg="{'required':true,'min':0,'max':99}" placeholder="目前值"
								/>次/周 <tag:numberInput style="width:50px" id="trainingMin" name="trainingMin" value="${di.trainingMin}"
									reg="{'required':true,'min':0,'max':9999}" placeholder="目前值"
								/>分钟/次</td>
						</tr>
						<tr>
							<th></th>
							<td><tag:numberInput style="width:50px" id="nextExerciseFrequency" name="nextExerciseFrequency" value="${di.nextExerciseFrequency}" reg="{'required':true,'min':0,'max':99}" placeholder="期望值"/>次/周
								<tag:numberInput style="width:50px" id="nextExerciseTime" name="nextExerciseTime" value="${di.nextExerciseTime}" reg="{'required':true,'min':0,'max':9999}" placeholder="期望值"/>分钟/次</td>
						</tr>
						<tr>
							<th><label class="required" for="dailyRice">主食（克/天）</label></th>
							<td><tag:numberInput style="width:50px;" point="point"  id="dailyRice" name="dailyRice" value="${di.dailyRice}" reg="{'required':true,'min':0,'max':9999}" />/
								<tag:numberInput style="width:50px;" point="point"  id="staple" name="staple" value="${di.staple}" reg="{'required':true,'min':0,'max':9999}" /></td>
						</tr>
						<tr>
							<th><label class="required" for="selfBsMonitoring">自我血糖监测</label></th>
							<td><ehr:dic-radio reg="{'required':true}"  dicmeta="DMD00053" value="${di.selfBsMonitoring }" name="selfBsMonitoring"></ehr:dic-radio></td>
						</tr>
						<tr>
							<th><label class="required" for="mentality">心理调整</label></th>
							<td><ehr:dic-radio reg="{'required':true}"  dicmeta="DMD00039" value="${di.mentality }" name="mentality"></ehr:dic-radio></td>
						</tr>
						<tr>
							<th><label class="required" for="compiance">遵医行为</label></th>
							<td><ehr:dic-radio reg="{'required':true}"  dicmeta="DMD00040" value="${di.compiance }" name="compiance"></ehr:dic-radio></td>
						</tr>
					</table>
				</fieldset>
				<fieldset class="layui-elem-field">
					<legend>辅助检查</legend>
					<table class="posttable">
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
						<tr>
							<th><label class="required">空腹血糖值</label></th>
							<td>
								<tag:numberInput id="fpg" style="width:50px" point="point" name="fpg" value="${di.fpg}" reg="{'required':true,'min':0,'max':999.9}" />mmol/L
								<label>&nbsp;&nbsp;&nbsp;注：空腹血糖值和餐后2小时血糖值只填其一即可</label>
							</td>
						</tr>
						<tr>
							<th><label class="required">餐后2小时血糖值</label></th>
							<td><tag:numberInput id="gluValue" style="width:50px" point="point" name="gluValue" value="${di.gluValue}" reg="{'required':true,'min':0,'max':999.9}" />mmol/L</td>
						</tr>
						<tr>
							<th><label >糖化血红蛋白值</label></th>
							<td><tag:numberInput id="hgb" style="width:50px" point="point" name="hgb" reg="{'min':0,'max':99.99}" value="${di.hgb}" />%
						</tr>
						<tr>
							<th>检查日期</th>
							<td><%-- <tag:dateInput style="width:178px;" onlypast="true" id="checkDate" name="checkDate" date="${di.checkDate}"/> --%>
							<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" name="checkDate" id="checkDate" value="<fmt:formatDate value='${di.checkDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:178px;" />
							</td>
						</tr>
						<tr>
							<th>其他检查</th>
							<td><input type="text" id="otherCheck" name="otherCheck" value="${di.otherCheck}" reg="{'maxlength':100}"/></td>
						</tr>
					</table>
				</fieldset>
				<%--<fieldset>
					<legend>血脂</legend>
					<table class="posttable">
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
						<tr>
							<th>总胆固醇</th>
							<td><tag:numberInput point="point" reg="{'min':0,'max':999.99}" name="tc" value="${di.tc}" style="width: 50px;" />mmol/L</td>
						</tr>
						<tr>
							<th>甘油三酯</th>
							<td><tag:numberInput point="point" reg="{'min':0,'max':99.9}" name="triglycerideValue" value="${di.triglycerideValue}" style="width: 50px;"/>mmol/L</td>
						</tr>
						<tr>
							<th>血清低密度脂蛋白胆固醇</th>
							<td><tag:numberInput reg="{'min':0,'max':999.99}" point="point" name="ldlcDetectValue" value="${di.ldlcDetectValue}" style="width: 50px;"/>mmol/L</td>
						</tr>
						<tr>
							<th>血清高密度脂蛋白胆固醇</th>
							<td><tag:numberInput reg="{'min':0,'max':999.99}" point="point" name="hdlcDetectValue" value="${di.hdlcDetectValue}" style="width: 50px;"/>mmol/L</td>
						</tr>
					</table>
				</fieldset>--%>
				<table class="posttable">
					<colgroup>
						<col style="min-width: 100px; width: 30%" />
						<col style="min-width: 150px; width: 70%" />
					</colgroup>
					<tr>
						<th><label class="required" for="medicationCompliance">服药依从性</label></th>
						<td><ehr:dic-radio reg="{'required':true}" dicmeta="DMD00041" value="${di.medicationCompliance }" name="medicationCompliance"></ehr:dic-radio></td>
					</tr>
					<tr>
						<th>药物不良反应</th>
						<td><ehr:dic-radio dicmeta="FS10238" onchange="toggleOther('drugReaction','di-followup-effectsState','2')" value="${di.drugReaction}" name="drugReaction"></ehr:dic-radio>
							<input style="width:350px;" type="text" id="di-followup-effectsState" class="${di.drugReaction!='2'?'hide':'' }"  value="${di.effectsState}" name="effectsState" reg="{'required':true,'maxlength':100,'dependOn':'drugReaction','dependValue':'2'}"  >
						</td>
					</tr>
					
					<tr>
						<th>低血糖反应</th>
						<td><ehr:dic-radio dicmeta="DMD00045" value="${di.hypoglycemiaReaction}" name="hypoglycemiaReaction"></ehr:dic-radio></td>
					</tr>
					<tr>
						<th>糖尿病并发症</th>
						<td><ehr:dic-checkbox dicmeta="DMD00046" value="${di.diComplication }" name="diComplication"></ehr:dic-checkbox></td>
					</tr>
					<tr>
						<th><label class="required" for="visitType">此次随访分类</label></th>
						<td><ehr:dic-radio dicmeta="DMD00042" name="visitType" value="${di.visitType }" reg="{'required':true}"></ehr:dic-radio></td>
					</tr>
				</table>
				<fieldset class="layui-elem-field">
					<legend>用药情况</legend>
					<table class="posttable" >
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
						<tr>
							<th><label class="required" for="">用药</label></th>
							<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="FS10246" name="medicateDiFlag" id="medicateDiFlag" value="${di.medicateDiFlag}"/></td>
						</tr>
						
					</table>
					<div  style="display:${di.medicateDiFlag !='1'?'none':'inline' }" id="medicateDiSpan">
						<c:set var="drug" value="${di}" scope="request"></c:set>
						<jsp:include page="../hbpdicommon/druguse.jsp"></jsp:include>
					</div>
					<table class="posttable" >
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
						<tr>
							<th><label class="required" for="">胰岛素</label></th>
							<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="FS10246" name="insulinFlag" id="insulinFlag" value="${di.insulinFlag}"/></td>
						</tr>
						
					</table>
					<table  style="" id="insulinSpan" class="posttable ${di.insulinFlag !='1'?'hide':'' } ">
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
						<tr>
							<th><label class="required" for="">种类</label></th>
							<td><input type="text" name="insulinSort" value="${drug.insulinSort}" reg="{'required':true,'maxlength':16}" /></td>
						</tr>
						<tr>
							<th><label class="required" for="">用法及用量</label></th>
							<td>
								每日<tag:numberInput style="width:50px;"  name="insulinUsage" value="${drug.insulinUsage}" reg="{'required':true,'min':0,'max':99}" />次 , 每次
								<tag:numberInput  style="width:60px;"  name="dosage" value="${drug.dosage}" reg="{'required':true,'min':0,'max':999}" />
								<ehr:dic-list dicmeta="DMD00067" value="${drug.insulinDosageUnit}" reg="{'required':true}"  name="insulinDosageUnit" id="insulinDosageUnit"></ehr:dic-list>
								备注:<input style="width: 100px;" type="text" name="insulinUsageRemark" value="${drug.insulinUsageRemark}" reg="{'maxlength':50}" />
							</td>
						</tr>
						
					</table>
				</fieldset>	
				<fieldset class="layui-elem-field">
					<legend>转诊</legend>
					<table class="posttable">
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
						<tr>
							<th><label class="required" for="referralDiFlag">转诊</label></th>
							<td><ehr:dic-radio reg='{"required":"true"}' dicmeta="FS10246" name="referralDiFlag" id="referralDiFlag" value="${di.referralDiFlag}"/></td>
						</tr>
					</table>
					<table class="posttable" style="${di.referralDiFlag !='1'?'display:none':'' }" id="referralDiSpan">
						<colgroup>
							<col style="min-width: 100px; width: 30%" />
							<col style="min-width: 150px; width: 70%" />
						</colgroup>
						<tr>
							<th><label class="required" for="referralOrganCode">机构</label></th>
							<td class="colinput">
								<ehr:org-type-list id="referralOrganCode"  width="275px" name="referralOrganCode" type="hospital,centre" reg='{"required":"true"}' value="${di.referralOrganCode}"/>
							</td>
						</tr>
						<tr>
							<th><label class="required" for="referralDepartment">科别</label></th>
							<td><input type="text" name="referralDepartment" id="referralDepartment" reg="{'required':true,'maxlength':100}" value="${di.referralDepartment}"/></td>
						</tr>
						<tr>
							<th><label for="referralDoctor">接诊医生</label></th>
							<td><input type="text" name="referralDoctor" id="referralDoctor" reg="{'maxlength':100}" value="${di.referralDoctor}"/></td>
						</tr>
						<tr>
							<th><label for="referralDate">转诊日期</label></th>
							<td><%-- <tag:dateInput onlypast="true" id="referralDate" name="referralDate" style="width:178px;" date="${di.referralDate}"/> --%>
							<input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" name="referralDate" id="referralDate" value="<fmt:formatDate value='${di.referralDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:178px;" />
							</td>
						</tr>
						<tr>
							<th><label class="required" for="referralReasons">原因</label></th>
							<td><input type="text" name="referralReasons" id="referralReasons" reg="{'required':true,'maxlength':150}" value="${di.referralReasons}"/></td>
						</tr>
					 </table>
				</fieldset>
				<c:if test="${not empty attches}">
				<fieldset class="layui-elem-field">
					<legend>附件</legend>
					<table class="posttable">
						<colgroup>
							<col style="width: 15%;"/>
							<col style="width: 35%;"/>
							<col style="width: 15%;"/>
							<col style="width: 35%;"/>
						</colgroup>
						<tr>
							<th></th>
							<td colspan="3">
								<div style="width: 960px;">
									<c:forEach items="${attches}" var="attche">
										<div style="width: 320px; height:200px; overflow:hidden;float: left;margin-top: 5px;margin-left:5px;margin-right:10px;text-align: center;"
											 id="${attche.mongoId}-div">
											<a target="blank"
											   href="${pageContext.request.contextPath}/mongoFile/showAsImage/${attche.mongoId}"><img
													alt="点击查看大图" title="点击查看大图"
													src="${pageContext.request.contextPath}/mongoFile/showSmallImage/${attche.mongoId}"
											/></a>

											<a target="blank"
											   href="${pageContext.request.contextPath}/mongoFile/download/${attche.mongoId}"
											   onclick="javascript:void(0)">${attche.fileName}</a>
											<br/>
											<%--<a href="javascript:void(0);"
											   onclick="healthEducationUpload.deleteFile('${attche.mongoId}')">删除</a>--%>
										</div>
									</c:forEach>
								</div>
							</td>
						</tr>
						<%--<tr>
                            <th><label class="required">附件</label></th>
                            <td style="width: 120px;">
                                <div id="heMaterialFile"></div>
                            </td>
                            <td colspan="2">
                                <span style="color: blue;">注：提供宣传材料样张照片，单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a
                                        href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改)，附件数量不能超过5个</span>
                                <span id="activeTips" style="color: blue;"></span>
                            </td>
                        </tr>--%>
					</table>
				</fieldset>
				</c:if>
			</fieldset>
			<c:set var="input" value="${di}" scope="request"></c:set>
			<jsp:include page="../common/inputInfo.jsp"></jsp:include>
		</div>
	</div>
</form>
<jsp:include page="diabeticFollowupInputPrint.jsp"/>
</div>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#diVisitDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	   ,done:function(value) {
	        if(!$.isEmpty(value)){
	            $("#diVisitDateId").removeClass("lose");
	        }else{
	            $("#diVisitDateId").addClass("lose");
	        }
    	}
    });
    
    laydate.render({
        elem: '#checkDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	   ,done:function(value) {
     	        if(!$.isEmpty(value)){
     	            $("#checkDate").removeClass("lose");
     	        }else{
     	            $("#checkDate").addClass("lose");
     	        }
     	   }
      });
    
    laydate.render({
        elem: '#referralDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	   ,done:function(value) {
   	        if(!$.isEmpty(value)){
   	            $("#referralDate").removeClass("lose");
   	        }else{
   	            $("#referralDate").addClass("lose");
   	        }
     	   }
      });
  });
$(function () {
	$('.x-admin-content-sm-date').each(function(){
		var id = $(this).attr("id");
		if(!$.isEmpty(id)){
			autoFormatDate(id);
		}
	});
});
</script>
