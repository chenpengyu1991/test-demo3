<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/woman/prenatalFollowupOther/add.js" type="text/javascript"></script>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
          elem: '#estimatedDueDates'
           ,format: 'yyyy/MM/dd'
        });
        laydate.render({
            elem: '#inputDateTwo'
             ,format: 'yyyy/MM/dd'
          });
        laydate.render({
            elem: '#inputDateThree'
             ,format: 'yyyy/MM/dd'
          });
        laydate.render({
            elem: '#inputDateFour'
             ,format: 'yyyy/MM/dd'
          });
        laydate.render({
            elem: '#inputDateFive'
             ,format: 'yyyy/MM/dd'
          });
        
        laydate.render({
          elem: '#nextSupervisionDateFive'
        	  ,format: 'yyyy/MM/dd'
        	  ,trigger: 'click'
        });
      
        laydate.render({
            elem: '#nextSupervisionDateFour'
             ,format: 'yyyy/MM/dd'
             ,trigger: 'click'
          });
        laydate.render({
            elem: '#nextSupervisionDateThree'
          	  ,format: 'yyyy/MM/dd'
          		,trigger: 'click'
          });
        laydate.render({
            elem: '#nextSupervisionDateTwo'
          	  ,format: 'yyyy/MM/dd'
          		,trigger: 'click'
          });
      });

    </script>
<div class="toolbar">
	<a href="javascript:void(0)" id="pFOBackId"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
	<a href="javascript:void(0);" id="pFOSaveId"><button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>保存</button></a>
</div>
<div style="background-color: white;top: 65px;" class="divFixed105">
	<ul>
		<li style="text-align: center; font-size: 25px;">第2-5次产前随访服务记录表</li>
	</ul>
	<br/>
	<form id="pFOAddFromId">
		<input type="hidden" name="personId" id="text_personId" value="${prenatalFollowupOther.personId}"/>
		<input type="hidden" name="id" id="prenatalId" value="${prenatalFollowupOther.id}"/>
		<input type="hidden" name="healthFileNo" value="${prenatalFollowupOther.healthFileNo}" id="healthFileNoIdd"/>
		<input type="hidden" name="createGbcode" value="${prenatalFollowupOther.createGbcode}"/>
		<input type="hidden" name="createOrganCode" value="${prenatalFollowupOther.createOrganCode}"/>
		<input type="hidden" name="createSuperOrganCode" value="${prenatalFollowupOther.createSuperOrganCode}"/>

		<div class="posttable">
			<table>
				<colgroup>
					<col style="width: 15%;"/>
					<col style="width: 21%;"/>
					<col style="width: 21%;"/>
					<col style="width: 21%;"/>
					<col style="width: 22%;"/>
				</colgroup>
				<tr>
					<td colspan="4" align="right">健康档案编号</td>
					<td>
						<input type="text" value="${prenatalFollowupOther.healthFileNo}" disabled="disabled" id="healthFileNoId"/>
					</td>
				</tr>
				<tr>
					<th><label class="required">身份证号</label></th>
					<td>
						<c:if test="${empty prenatalFollowupOther.id }">
							<tag:idcardInput name="idCard" id="text_idcard"  reg='{"required":"true","idCard":true}' value="${prenatalFollowupOther.idCard}" ></tag:idcardInput>
						</c:if>
						<c:if test="${not empty prenatalFollowupOther.id }">
							${prenatalFollowupOther.idCard} <input type="hidden" name="idCard" maxlength="18" value="${prenatalFollowupOther.idCard}" />
						</c:if>
					</td>
					<td>
						孕妇姓名:<input reg='{"maxlength":16}'  type="text"
									id="text_name" name="name"
									value="${prenatalFollowupOther.name}" style="width: auto;"/>
					</td>
					<th><label class="required">预产期</label></th>
					<td>
					<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="estimatedDueDates" id="estimatedDueDates" value="<fmt:formatDate value='${prenatalFollowupOther.estimatedDueDates}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					</td>
				</tr>
				<tr>
					<th>项目</th>
					<td style="text-align: center">第2次</td>
					<td style="text-align: center">第3次</td>
					<td style="text-align: center">第4次*</td>
					<td style="text-align: center">第5次*</td>
				</tr>
				<tr>
					<th>随访日期</th>
					<td>
						<input type="text"  class="layui-input x-admin-content-sm-date"  name="inputDateTwo" id="inputDateTwo" value="<fmt:formatDate value='${prenatalFollowupOther.inputDateTwo}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					
						<%-- <tag:dateInput style="178px" name="inputDateTwo"  date="${prenatalFollowupOther.inputDateTwo}" onlypast="true"/> --%>
					</td>
					<td>
						<input type="text"  class="layui-input x-admin-content-sm-date"  name="inputDateThree" id="inputDateThree" value="<fmt:formatDate value='${prenatalFollowupOther.inputDateThree}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					
						<%-- <tag:dateInput style="178px" name="inputDateThree"  date="${prenatalFollowupOther.inputDateThree}" onlypast="true"/> --%>
					</td>
					<td>
						<input type="text"  class="layui-input x-admin-content-sm-date"  name="inputDateFour" id="inputDateFour" value="<fmt:formatDate value='${prenatalFollowupOther.inputDateFour}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					
						<%-- <tag:dateInput style="178px" name="inputDateFour"  date="${prenatalFollowupOther.inputDateFour}" onlypast="true"/> --%>
					</td>
					<td>
						<input type="text"  class="layui-input x-admin-content-sm-date"  name="inputDateFive" id="inputDateFive" value="<fmt:formatDate value='${prenatalFollowupOther.inputDateFive}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					
						<%-- <tag:dateInput style="178px" name="inputDateFive"  date="${prenatalFollowupOther.inputDateFive}" onlypast="true"/> --%>
					</td>
				</tr>
				<tr>
					<th>孕周</th>
					<td>
						<tag:numberInput name="gestationalWeeksTwo" value="${prenatalFollowupOther.gestationalWeeksTwo}" maxlength="2" style="width:30%;"/>周
					</td>
					<td>
						<tag:numberInput name="gestationalWeeksThree" value="${prenatalFollowupOther.gestationalWeeksThree}" maxlength="2" style="width:30%;"/>周
					</td>
					<td>
						<tag:numberInput name="gestationalWeeksFour" value="${prenatalFollowupOther.gestationalWeeksFour}" maxlength="2" style="width:30%;"/>周
					</td>
					<td>
						<tag:numberInput name="gestationalWeeksFive" value="${prenatalFollowupOther.gestationalWeeksFive}" maxlength="2" style="width:30%;"/>周
					</td>
				</tr>
				<tr>
					<th>主诉</th>
					<td>
						<input type="text" name="chiefComplaintTwo" value="${prenatalFollowupOther.chiefComplaintTwo}" reg='{"maxlength":100}'/>
					</td>
					<td>
						<input type="text" name="chiefComplaintThree" value="${prenatalFollowupOther.chiefComplaintThree}" reg='{"maxlength":100}'/>
					</td>
					<td>
						<input type="text" name="chiefComplaintFour" value="${prenatalFollowupOther.chiefComplaintFour}" reg='{"maxlength":100}'/>
					</td>
					<td>
						<input type="text" name="chiefComplaintFive" value="${prenatalFollowupOther.chiefComplaintFive}" reg='{"maxlength":100}'/>
					</td>
				</tr>
				<tr>
					<th>体重</th>
					<td>
						<tag:numberInput name="bodyWeightTwo" value="${prenatalFollowupOther.bodyWeightTwo}" maxlength="5" point="1" style="width:30%;"/>kg
					</td>
					<td>
						<tag:numberInput name="bodyWeightThree" value="${prenatalFollowupOther.bodyWeightThree}" maxlength="5" point="1" style="width:30%;"/>kg
					</td>
					<td>
						<tag:numberInput name="bodyWeightFour" value="${prenatalFollowupOther.bodyWeightFour}" maxlength="5" point="1" style="width:30%;"/>kg
					</td>
					<td>
						<tag:numberInput name="bodyWeightFive" value="${prenatalFollowupOther.bodyWeightFive}" maxlength="5" point="1" style="width:30%;"/>kg
					</td>
				</tr>
				<tr>
					<th>宫底高度</th>
					<td>
						<tag:numberInput name="uterineBottomHeightTwo" value="${prenatalFollowupOther.uterineBottomHeightTwo}" maxlength="5" point="1" style="width:30%;"/>cm
					</td>
					<td>
						<tag:numberInput name="uterineBottomHeightThree" value="${prenatalFollowupOther.uterineBottomHeightThree}" maxlength="5" point="1" style="width:30%;"/>cm
					</td>
					<td>
						<tag:numberInput name="uterineBottomHeightFour" value="${prenatalFollowupOther.uterineBottomHeightFour}" maxlength="5" point="1" style="width:30%;"/>cm
					</td>
					<td>
						<tag:numberInput name="uterineBottomHeightFive" value="${prenatalFollowupOther.uterineBottomHeightFive}" maxlength="5" point="1" style="width:30%;"/>cm
					</td>
				</tr>
				<tr>
					<th>腹围</th>
					<td>
						<tag:numberInput name="abdominalGirthTwo" value="${prenatalFollowupOther.abdominalGirthTwo}" maxlength="5" point="1" style="width:30%;"/>cm
					</td>
					<td>
						<tag:numberInput name="abdominalGirthThree" value="${prenatalFollowupOther.abdominalGirthThree}" maxlength="5" point="1" style="width:30%;"/>cm
					</td>
					<td>
						<tag:numberInput name="abdominalGirthFour" value="${prenatalFollowupOther.abdominalGirthFour}" maxlength="5" point="1" style="width:30%;"/>cm
					</td>
					<td>
						<tag:numberInput name="abdominalGirthFive" value="${prenatalFollowupOther.abdominalGirthFive}" maxlength="5" point="1" style="width:30%;"/>cm
					</td>
				</tr>
				<tr>
					<th>胎位</th>
					<td>
					</td>
					<td>
					</td>
					<td>
						<ehr:dic-list dicmeta="CV0501007" name="fetalPositionFour" value="${prenatalFollowupOther.fetalPositionFour}"/>
						<ehr:dic-list dicmeta="CV0501007" name="fetalPositionFourSec" value="${prenatalFollowupOther.fetalPositionFourSec}"/>
					</td>
					<td>
						<ehr:dic-list dicmeta="CV0501007" name="fetalPositionFive" value="${prenatalFollowupOther.fetalPositionFive}"/>
						<ehr:dic-list dicmeta="CV0501007" name="fetalPositionFiveSec" value="${prenatalFollowupOther.fetalPositionFiveSec}"/>
					</td>
				</tr>
				<tr>
					<th></th>
					<td>
					</td>
					<td>
					</td>
					<td>
						<ehr:dic-list dicmeta="CV0501007" name="fetalPositionFourThi" value="${prenatalFollowupOther.fetalPositionFourThi}"/>
						<ehr:dic-list dicmeta="CV0501007" name="fetalPositionFourFou" value="${prenatalFollowupOther.fetalPositionFourFou}"/>
					</td>
					<td>
						<ehr:dic-list dicmeta="CV0501007" name="fetalPositionFiveThi" value="${prenatalFollowupOther.fetalPositionFiveThi}"/>
						<ehr:dic-list dicmeta="CV0501007" name="fetalPositionFiveFou" value="${prenatalFollowupOther.fetalPositionFiveFou}"/>
					</td>
				</tr>
				<tr>
					<th>胎心率</th>
					<td>
						<tag:numberInput name="fetalHeartRateTwo" value="${prenatalFollowupOther.fetalHeartRateTwo}" maxlength="3" style="width:30%;"/>
						&nbsp;&nbsp;
						<tag:numberInput name="fetalHeartRateTwoSec" value="${prenatalFollowupOther.fetalHeartRateTwoSec}" maxlength="3" style="width:30%;"/>
					</td>
					<td>
						<tag:numberInput name="fetalHeartRateThree" value="${prenatalFollowupOther.fetalHeartRateThree}" maxlength="3" style="width:30%;"/>
						&nbsp;&nbsp;
						<tag:numberInput name="fetalHeartRateThreeSec" value="${prenatalFollowupOther.fetalHeartRateThreeSec}" maxlength="3" style="width:30%;"/>
					</td>
					<td>
						<tag:numberInput name="fetalHeartRateFour" value="${prenatalFollowupOther.fetalHeartRateFour}" maxlength="3" style="width:30%;"/>
						&nbsp;&nbsp;
						<tag:numberInput name="fetalHeartRateFourSec" value="${prenatalFollowupOther.fetalHeartRateFourSec}" maxlength="3" style="width:30%;"/>
					</td>
					<td>
						<tag:numberInput name="fetalHeartRateFive" value="${prenatalFollowupOther.fetalHeartRateFive}" maxlength="3" style="width:30%;"/>
						&nbsp;&nbsp;
						<tag:numberInput name="fetalHeartRateFiveSec" value="${prenatalFollowupOther.fetalHeartRateFiveSec}" maxlength="3" style="width:30%;"/>
					</td>
				</tr>
				<tr>
					<th></th>
					<td>
						<tag:numberInput name="fetalHeartRateTwoThi" value="${prenatalFollowupOther.fetalHeartRateTwoThi}" maxlength="3" style="width:30%;"/>
						&nbsp;&nbsp;
						<tag:numberInput name="fetalHeartRateTwoFou" value="${prenatalFollowupOther.fetalHeartRateTwoFou}" maxlength="3" style="width:30%;"/>
					</td>
					<td>
						<tag:numberInput name="fetalHeartRateThreeThi" value="${prenatalFollowupOther.fetalHeartRateThreeThi}" maxlength="3" style="width:30%;"/>
						&nbsp;&nbsp;
						<tag:numberInput name="fetalHeartRateThreeFou" value="${prenatalFollowupOther.fetalHeartRateThreeFou}" maxlength="3" style="width:30%;"/>
					</td>
					<td>
						<tag:numberInput name="fetalHeartRateFourThi" value="${prenatalFollowupOther.fetalHeartRateFourThi}" maxlength="3" style="width:30%;"/>
						&nbsp;&nbsp;
						<tag:numberInput name="fetalHeartRateFourFou" value="${prenatalFollowupOther.fetalHeartRateFourFou}" maxlength="3" style="width:30%;"/>
					</td>
					<td>
						<tag:numberInput name="fetalHeartRateFiveThi" value="${prenatalFollowupOther.fetalHeartRateFiveThi}" maxlength="3" style="width:30%;"/>
						&nbsp;&nbsp;
						<tag:numberInput name="fetalHeartRateFiveFou" value="${prenatalFollowupOther.fetalHeartRateFiveFou}" maxlength="3" style="width:30%;"/>
					</td>
				</tr>
				<tr>
					<th>血压(mmHg)</th>
					<td>
						<tag:numberInput name="sbpTwo" value="${prenatalFollowupOther.sbpTwo}"  style="width: 40px" reg="{'min':0,'max':9999}"/>/
						<tag:numberInput name="dbpTwo" value="${prenatalFollowupOther.dbpTwo}"  style="width: 40px" reg="{'min':0,'max':9999}"/>mmHg
					</td>
					<td>
						<tag:numberInput name="sbpThree" value="${prenatalFollowupOther.sbpThree}"  style="width: 40px" reg="{'min':0,'max':9999}"/>/
						<tag:numberInput name="dbpThree" value="${prenatalFollowupOther.dbpThree}"  style="width: 40px" reg="{'min':0,'max':9999}"/>mmHg
					</td>
					<td>
						<tag:numberInput name="sbpFour" value="${prenatalFollowupOther.sbpFour}"  style="width: 40px" reg="{'min':0,'max':9999}"/>/
						<tag:numberInput name="dbpFour" value="${prenatalFollowupOther.dbpFour}"  style="width: 40px" reg="{'min':0,'max':9999}"/>mmHg
					</td>
					<td>
						<tag:numberInput name="sbpFive" value="${prenatalFollowupOther.sbpFive}"  style="width: 40px" reg="{'min':0,'max':9999}"/>/
						<tag:numberInput name="dbpFive" value="${prenatalFollowupOther.dbpFive}"  style="width: 40px" reg="{'min':0,'max':9999}"/>mmHg
					</td>
				</tr>
				<tr>
					<th>血红蛋白</th>
					<td>
						<input type="text" name="hemoglobinValueTwo" value="${prenatalFollowupOther.hemoglobinValueTwo}" reg='{"maxlength":20}' style="width:30%;"/>g/L
					</td>
					<td>
						<input type="text" name="hemoglobinValueThree" value="${prenatalFollowupOther.hemoglobinValueThree}" reg='{"maxlength":20}' style="width:30%;"/>g/L
					</td>
					<td>
						<input type="text" name="hemoglobinValueFour" value="${prenatalFollowupOther.hemoglobinValueFour}" reg='{"maxlength":20}' style="width:30%;"/>g/L
					</td>
					<td>
						<input type="text" name="hemoglobinValueFive" value="${prenatalFollowupOther.hemoglobinValueFive}" reg='{"maxlength":20}' style="width:30%;"/>g/L
					</td>
				</tr>
				<tr>
					<th>尿蛋白</th>
					<td>
						<ehr:dic-radio dicmeta="CV0450015" code="01,03" name="urineProQuantitativeTwo" value="${prenatalFollowupOther.urineProQuantitativeTwo}"/>
					</td>
					<td>
						<ehr:dic-radio dicmeta="CV0450015" code="01,03" name="urineProQuantitativeThree" value="${prenatalFollowupOther.urineProQuantitativeThree}"/>
					</td>
					<td>
						<ehr:dic-radio dicmeta="CV0450015" code="01,03" name="urineProQuantitativeFour" value="${prenatalFollowupOther.urineProQuantitativeFour}"/>
					</td>
					<td>
						<ehr:dic-radio dicmeta="CV0450015" code="01,03" name="urineProQuantitativeFive" value="${prenatalFollowupOther.urineProQuantitativeFive}"/>
					</td>
				</tr>
				<tr>
					<th>产前筛查</th>
					<td><ehr:dic-radio name="screeningTwo" dicmeta="FS10281" value="${prenatalFollowupOther.screeningTwo}" code="1,2"/>
						高危<ehr:dic-radio name="screeningIsHighTwo" dicmeta="FS10281" value="${prenatalFollowupOther.screeningIsHighTwo}" code="1,2"/>
					</td>
					<td><ehr:dic-radio name="screeningThree" dicmeta="FS10281" value="${prenatalFollowupOther.screeningThree}" code="1,2"/>
						高危<ehr:dic-radio name="screeningIsHighThree" dicmeta="FS10281" value="${prenatalFollowupOther.screeningIsHighThree}" code="1,2"/>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>产前诊断</th>
					<td><ehr:dic-radio name="diagnosisTwo" dicmeta="FS10281" value="${prenatalFollowupOther.diagnosisTwo}" code="1,2"/>
						确诊<ehr:dic-radio name="diagnosisIsConfirmedTwo" dicmeta="FS10281" value="${prenatalFollowupOther.diagnosisIsConfirmedTwo}" code="1,2"/>
					</td>
					<td><ehr:dic-radio name="diagnosisThree" dicmeta="FS10281" value="${prenatalFollowupOther.diagnosisThree}" code="1,2"/>
						确诊<ehr:dic-radio name="diagnosisIsConfirmedThree" dicmeta="FS10281" value="${prenatalFollowupOther.diagnosisIsConfirmedThree}" code="1,2"/>
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<th>其他辅助检查</th>
					<td>
						<ehr:dic-radio name="otherExamTwoSign" dicmeta="FS10111" value="${prenatalFollowupOther.otherExamTwoSign}"
									   onchange="toggleOther('otherExamTwoSign','otherExamTwoId',2);"/>
						<input type="text" id="otherExamTwoId" name="otherExamTwo" value="${prenatalFollowupOther.otherExamTwo}" reg='{"required":"true","maxlength":100}'/>
					</td>
					<td>
						<ehr:dic-radio name="otherExamThreeSign" dicmeta="FS10111" value="${prenatalFollowupOther.otherExamThreeSign}"
									   onchange="toggleOther('otherExamThreeSign','otherExamThreeId',2);"/>
						<input type="text" id="otherExamThreeId" name="otherExamThree" value="${prenatalFollowupOther.otherExamThree}" reg='{"required":"true","maxlength":100}'/>
					</td>
					<td>
						<ehr:dic-radio name="otherExamFourSign" dicmeta="FS10111" value="${prenatalFollowupOther.otherExamFourSign}"
									   onchange="toggleOther('otherExamFourSign','otherExamFourId',2);"/>
						<input type="text" id="otherExamFourId" name="otherExamFour" value="${prenatalFollowupOther.otherExamFour}" reg='{"required":"true","maxlength":100}'/>
					</td>
					<td>
						<ehr:dic-radio name="otherExamFiveSign" dicmeta="FS10111" value="${prenatalFollowupOther.otherExamFiveSign}"
									   onchange="toggleOther('otherExamFiveSign','otherExamFiveId',2);"/>
						<input type="text" id="otherExamFiveId" name="otherExamFive" value="${prenatalFollowupOther.otherExamFive}" reg='{"required":"true","maxlength":100}'/>
					</td>
				</tr>
				<tr>
					<th>分类</th>
					<td>
						<ehr:dic-radio name="classifySignTwo" dicmeta="FS10046" value="${prenatalFollowupOther.classifySignTwo}"
									   onchange="toggleOther('classifySignTwo','classifyDescTwoId',2);"/>
					<span id="classifyDescTwoId">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="classifyDescTwo" value="${prenatalFollowupOther.classifyDescTwo}" style="width: 30%"/>
                   </span>
					</td>
					<td>
						<ehr:dic-radio name="classifySignThree" dicmeta="FS10046" value="${prenatalFollowupOther.classifySignThree}"
									   onchange="toggleOther('classifySignThree','classifyDescThreeId',2);"/>
					<span id="classifyDescThreeId">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="classifyDescThree" value="${prenatalFollowupOther.classifyDescThree}" style="width: 30%"/>
                   </span>
					</td>
					<td>
						<ehr:dic-radio name="classifySignFour" dicmeta="FS10046" value="${prenatalFollowupOther.classifySignFour}"
									   onchange="toggleOther('classifySignFour','classifyDescFourId',2);"/>
					<span id="classifyDescFourId">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="classifyDescFour" value="${prenatalFollowupOther.classifyDescFour}" style="width: 30%"/>
                   </span>
					</td>
					<td>
						<ehr:dic-radio name="classifySignFive" dicmeta="FS10046" value="${prenatalFollowupOther.classifySignFive}"
									   onchange="toggleOther('classifySignFive','classifyDescFiveId',2);"/>
					<span id="classifyDescFiveId">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="classifyDescFive" value="${prenatalFollowupOther.classifyDescFive}" style="width: 30%"/>
                   </span>
					</td>
				</tr>
				<tr>
					<th>指导</th>
					<td style="vertical-align: top;">
						<ehr:dic-checkbox name="healthGuidanceClassTwo" dicmeta="CV0600219" value="${prenatalFollowupOther.healthGuidanceClassTwo}" code="01,03,02,06,99"
										  onchange="toggleOtherCK('healthGuidanceClassTwo','healthGuidanceClassDescTwoId',99);" isBr="true"/>
					<span id="healthGuidanceClassDescTwoId">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="healthGuidanceClassDescTwo" value="${prenatalFollowupOther.healthGuidanceClassDescTwo}" style="width: 30%"/>
                   </span>
					</td>
					<td style="vertical-align: top;">
						<ehr:dic-checkbox name="healthGuidanceClassThree" dicmeta="CV0600219" value="${prenatalFollowupOther.healthGuidanceClassThree}" code="01,03,02,06,07,09,99"
										  onchange="toggleOtherCK('healthGuidanceClassThree','healthGuidanceClassDescThreeId',99);" isBr="true"/>
					<span id="healthGuidanceClassDescThreeId">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="healthGuiClassDescThree" value="${prenatalFollowupOther.healthGuiClassDescThree}" style="width: 30%"/>
                   </span>
					</td>
					<td style="vertical-align: top;">
						<ehr:dic-checkbox name="healthGuidanceClassFour" dicmeta="CV0600219" value="${prenatalFollowupOther.healthGuidanceClassFour}" code="01,03,02,06,07,08,09,99"
										  onchange="toggleOtherCK('healthGuidanceClassFour','healthGuidanceClassDescFourId',99);" isBr="true"/>
					<span id="healthGuidanceClassDescFourId">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="healthGuiClassDescFour" value="${prenatalFollowupOther.healthGuiClassDescFour}" style="width: 30%"/>
                   </span>
					</td>
					<td style="vertical-align: top;">
						<ehr:dic-checkbox name="healthGuidanceClassFive" dicmeta="CV0600219" value="${prenatalFollowupOther.healthGuidanceClassFive}" code="01,03,02,06,07,08,09,99"
										  onchange="toggleOtherCK('healthGuidanceClassFive','healthGuidanceClassDescFiveId',99);" isBr="true"/>
					<span id="healthGuidanceClassDescFiveId">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="healthGuiClassDescFive" value="${prenatalFollowupOther.healthGuiClassDescFive}" style="width: 30%"/>
                   </span>
					</td>
				</tr>

				<tr>
					<th>转诊</th>
					<td>
						<ehr:dic-radio name="referralFlagTwo" dicmeta="FY0001" value="${prenatalFollowupOther.referralFlagTwo}" code="1,0"
									   onchange="toggleOther('referralFlagTwo','referralFlagTwoId',1);"/>
					<span id="referralFlagTwoId">
						<br/>
						原因	<input reg='{"required":"true","maxlength":80}' type="text" name="referralReasonTwo" value="${prenatalFollowupOther.referralReasonTwo}" style="width: 60%"/>
						<br/>
						机构
						<input reg='{"required":"true","maxlength":80}' type="text" name="referralHospitalNameTwo" value="${prenatalFollowupOther.referralHospitalNameTwo}" style="width: 60%"/>
						<br/>
						科室
						<input reg='{"required":"true","maxlength":80}' type="text" name="referralDeptNameTwo" value="${prenatalFollowupOther.referralDeptNameTwo}" style="width: 60%"/>
					</span>
					</td>
					<td>
						<ehr:dic-radio name="referralFlagThree" dicmeta="FY0001" value="${prenatalFollowupOther.referralFlagThree}" code="1,0"
									   onchange="toggleOther('referralFlagThree','referralFlagThreeId',1);"/>
					<span id="referralFlagThreeId">
						<br/>
						原因	<input reg='{"required":"true","maxlength":80}' type="text" name="referralReasonThree" value="${prenatalFollowupOther.referralReasonThree}" style="width: 60%"/>
						<br/>
						机构
						<input reg='{"required":"true","maxlength":80}' type="text" name="referralHospitalNameThree" value="${prenatalFollowupOther.referralHospitalNameThree}" style="width: 60%"/>
						<br/>
						科室
						<input reg='{"required":"true","maxlength":80}' type="text" name="referralDeptNameThree" value="${prenatalFollowupOther.referralDeptNameThree}" style="width: 60%"/>
					</span>
					</td>
					<td>
						<ehr:dic-radio name="referralFlagFour" dicmeta="FY0001" value="${prenatalFollowupOther.referralFlagFour}" code="1,0"
									   onchange="toggleOther('referralFlagFour','referralFlagFourId',1);"/>
					<span id="referralFlagFourId">
						<br/>
						原因	<input reg='{"required":"true","maxlength":80}' type="text" name="referralReasonFour" value="${prenatalFollowupOther.referralReasonFour}" style="width: 60%"/>
						<br/>
						机构
						<input reg='{"required":"true","maxlength":80}' type="text" name="referralHospitalNameFour" value="${prenatalFollowupOther.referralHospitalNameFour}" style="width: 60%"/>
						<br/>
						科室
						<input reg='{"required":"true","maxlength":80}' type="text" name="referralDeptNameFour" value="${prenatalFollowupOther.referralDeptNameFour}" style="width: 60%"/>

					</span>
					</td>
					<td>
						<ehr:dic-radio name="referralFlagFive" dicmeta="FY0001" value="${prenatalFollowupOther.referralFlagFive}" code="1,0"
									   onchange="toggleOther('referralFlagFive','referralFlagFiveId',1);"/>
					<span id="referralFlagFiveId">
						<br/>
						原因	<input reg='{"required":"true","maxlength":80}' type="text" name="referralReasonFive" value="${prenatalFollowupOther.referralReasonFive}" style="width: 60%"/>
						<br/>
						机构
						<input reg='{"required":"true","maxlength":80}' type="text" name="referralHospitalNameFive" value="${prenatalFollowupOther.referralHospitalNameFive}" style="width: 60%"/>
						<br/>
						科室
						<input reg='{"required":"true","maxlength":80}' type="text" name="referralDeptNameFive" value="${prenatalFollowupOther.referralDeptNameFive}" style="width: 60%"/>

					</span>
					</td>
				</tr>
				<tr style="vertical-align: middle;">
					<th>中医药健康管理服务</th>
					<td>
						<ehr:dic-checkbox name="tcmHealthSignTwo" dicmeta="FS10307" value="${prenatalFollowupOther.tcmHealthSignTwo}"
										  onchange="toggleOtherCK('tcmHealthSignTwo','tcmHealthSignDescTwoId',99);" code="6,1,7,2,99" isBr="true"/>
					<span id="tcmHealthSignDescTwoId">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="tcmHealthSignDescTwo" value="${prenatalFollowupOther.tcmHealthSignDescTwo}" style="width: 30%"/>
                   </span>
					</td>
					<td>
						<ehr:dic-checkbox name="tcmHealthSignThree" dicmeta="FS10307" value="${prenatalFollowupOther.tcmHealthSignThree}"
										  onchange="toggleOtherCK('tcmHealthSignThree','tcmHealthSignDescThreeId',99);" code="6,1,7,2,99" isBr="true"/>
					<span id="tcmHealthSignDescThreeId">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="tcmHealthSignDescThree" value="${prenatalFollowupOther.tcmHealthSignDescThree}" style="width: 30%"/>
                   </span>
					</td>
					<td>
						<ehr:dic-checkbox name="tcmHealthSignFour" dicmeta="FS10307" value="${prenatalFollowupOther.tcmHealthSignFour}"
										  onchange="toggleOtherCK('tcmHealthSignFour','tcmHealthSignDescFourId',99);" code="6,1,7,2,99" isBr="true"/>
					<span id="tcmHealthSignDescFourId">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="tcmHealthSignDescFour" value="${prenatalFollowupOther.tcmHealthSignDescFour}" style="width: 30%"/>
                   </span>
					</td>
					<td>
						<ehr:dic-checkbox name="tcmHealthSignFive" dicmeta="FS10307" value="${prenatalFollowupOther.tcmHealthSignFive}"
										  onchange="toggleOtherCK('tcmHealthSignFive','tcmHealthSignDescFiveId',99);" code="6,1,7,2,99" isBr="true"/>
					<span id="tcmHealthSignDescFiveId">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="tcmHealthSignDescFive" value="${prenatalFollowupOther.tcmHealthSignDescFive}" style="width: 30%"/>
                   </span>
					</td>
				</tr>

				<tr>
					<th>下次访视日期</th>
					<td>
						<input type="text"  class="layui-input x-admin-content-sm-date"  name="nextSupervisionDateTwo" id="nextSupervisionDateTwo" value="<fmt:formatDate value='${prenatalFollowupOther.nextSupervisionDateTwo}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					</td>
					<td>
						<input type="text"  class="layui-input x-admin-content-sm-date"  name="nextSupervisionDateThree" id="nextSupervisionDateThree" value="<fmt:formatDate value='${prenatalFollowupOther.nextSupervisionDateThree}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					</td>
					<td>
						<input type="text"  class="layui-input x-admin-content-sm-date"  name="nextSupervisionDateFour" id="nextSupervisionDateFour" value="<fmt:formatDate value='${prenatalFollowupOther.nextSupervisionDateFour}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					</td>
					<td>
						<input type="text"  class="layui-input x-admin-content-sm-date"  name="nextSupervisionDateFive" id="nextSupervisionDateFive" value="<fmt:formatDate value='${prenatalFollowupOther.nextSupervisionDateFive}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
					</td>
				</tr>
				<tr>
					<th>随访医生签名</th>
					<td>
						<ehr:staff-list name="supervisionDoctorTwo" value="${prenatalFollowupOther.supervisionDoctorTwo}" defaultval="Y" style="width:30%"/>
					</td>
					<td>
						<ehr:staff-list name="supervisionDoctorThree" value="${prenatalFollowupOther.supervisionDoctorThree}" defaultval="Y" style="width:30%"/>
					</td>
					<td>
						<ehr:staff-list name="supervisionDoctorFour" value="${prenatalFollowupOther.supervisionDoctorFour}" defaultval="Y" style="width:30%"/>
					</td>
					<td>
						<ehr:staff-list name="supervisionDoctorFive" value="${prenatalFollowupOther.supervisionDoctorFive}" defaultval="Y" style="width:30%"/>
					</td>
				</tr>
			</table>
		</div>
	</form>
</div>