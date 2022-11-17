<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script src="${pageContext.request.contextPath}/js/views/he/individual/edit.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/he/upload/upload.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function()
	{
		healthEducationUpload.uploadFile("heActivityFile", "/he/upload/uploadFile/jjdj", "/he/upload/deleteFile/jjdj");
		
		/* var val=$("#heIndividualForm #activeType").val();
		if (val== '99') {
			$('#activeTips').text('提供活动照片、签到及相关书面材料等等');
		} else if (val == '1') {
			$('#activeTips').text('提供讲座照片、签到、讲稿、通知等附件');
		} else if (val == '2') {
			$('#activeTips').text('提供活动照片、通知、小结等附件');
		} else {
			$('#activeTips').text('提供活动照片、签到及相关书面材料等等');
		} */
	});
</script>
<div class="toolbar">
<!-- 	<a href="javascript:void(0)" id="healthEducationActiveBackButton"><b class="fanhui">返回</b></a> -->
	 <!-- <a href="javascript:void(0)"
		id="heIndividualSaveButton"
	><b class="baocun">保存</b></a> -->
	<a href="javascript:void(0)"
		id="heIndividualSaveButton"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<form id="heIndividualForm">
	<div class="postcontent">
		<input type="hidden" name="id" value="${heIndividual.id}">
		<table class="posttable">
			<colgroup>
				<col style="width: 20%;" />
				<col style="width: 30%;" />
				<col style="width: 20%;" />
				<col style="width: 30%;" />
			</colgroup>
			<tr>
				<th><label class="required">姓名</label></th>
				<td>
					 <input type="text" style="width: 125px;" 
					reg='{"required":"true","maxlength":50}' name="individualName" id="individualName" value="${heIndividual.individualName}"
				/></td>
				<th><label class="required">性别</label></th>
				<td>
					<ehr:dic-list reg='{"required":"true"}' name="gender" dicmeta="GBT226112003" value="${heIndividual.gender}"></ehr:dic-list>
				</td>
			</tr>
			<tr>
				<th><label class="required">年龄</label></th>
				<td><input name="age"  style="width: 100px;" type="text" id="age" reg='{"required":"true","maxlength":"20"}' value="${heIndividual.age}" /></td>
				<th><label class="required">联系电话</label></th>
				<td><input type="text" id="phoneNumber"
							   name="phoneNumber"  reg='{"required":"true","maxlength":20,"regex":"phone"}'  value="${heIndividual.phoneNumber}"/></td>
			</tr>
			<tr>
				<th><label class="required">身份证号码</label></th>
				<td colspan="3"><input type="text" name="idcard" id="idcard"  style="width: 180px"  reg='{"required":"true","idCard":true}' value="${heIndividual.idcard}" ></input></td>
			</tr>
			<tr>
			<tr>
							<th><label class="required">现住址:</label></th>
							<td colspan="3">
								<ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" callback="heIndividualEdit.displayPaAddress"
															 townId="patown_address" villageName="paGroup" streetName="pastreet"
															 townName="patownShip" villageValue="${heIndividual.paGroup}" streetValue="${heIndividual.pastreet}"
															 townValue="${heIndividual.patownShip}" width="118px;" reg="{'required':true}" />
								<label id="tempPaValue">
									<ehr:dic code="${heIndividual.patownShip}" dicmeta="FS990001"/>
									<ehr:dic code="${heIndividual.pastreet}" dicmeta="FS990001"/>
									<ehr:dic code="${heIndividual.paGroup}" dicmeta="FS990001"/>
								</label>
	                            <input type="text" id="pahouseNumber" name="pahouseNumber" value="${heIndividual.pahouseNumber}"
	                                   reg='{"maxlength":"70"}'/>
	                            <span id="spanPaNumber"></span>
				            </td>
						</tr>
						<tr>
	                        <th><label class="required">个体化健康教育方式:</label></th>
	                        <td colspan="3">
	                            <ehr:dic-checkbox name="individualType" dicmeta="HE00028" value="${heIndividual.individualType}" code="1,2,3,4,5,6,7,8,9,10,11,12"
	                                              onchange="toggleOtherCK('individualType','other1','12')" reg='{"required":"true"}'/>
										<span id="other1" style="display: none;">
											<input type="text" name="individualDesc" value="${heIndividual.individualDesc }"  reg='{"required":"true","maxlength":"100"}'
	                                               style="width: 20%"/>
										</span>
	                        </td>
                    	</tr>
                    	<tr>
	                        <th><label class="required">教育对象（人群）类型:</label></th>
	                        <td colspan="3">
	                            <ehr:dic-checkbox name="educationType" dicmeta="HE00029" value="${heIndividual.educationType}" code="1,2,3,4,5,6,7,8,9"
	                                              onchange="toggleOtherCK('educationType','other2','9')" reg='{"required":"true"}'/>
										<span id="other2" style="display: none;">
											<input type="text" name="educationDesc" value="${heIndividual.educationDesc }"  reg='{"required":"true","maxlength":"100"}'
	                                               style="width: 20%"/>
										</span>
	                        </td>
                    	</tr>
                    	
                    <tr>
						<th><label class="required">指导医生</label></th>
						<td><input name="preceptor"  style="width: 150px;" type="text" reg='{"required":"true","maxlength":"50"}' value="${heIndividual.preceptor}" /></td>
						<th><label class="required">指导时间</label></th>
						<td><%-- <tag:dateInput reg='{"required":"true"}' style="width: 150px;" name="guidanceTime" id="guidanceTime" date="${heIndividual.guidanceTime}" onlypast="true" /> --%>
						<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="guidanceTime" id="guidanceTime" value="<fmt:formatDate value='${heIndividual.guidanceTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 150px;" />
						</td>
			</tr>
			<tr>
	                        <th><label class="required">地点（场所）名称:</label></th>
	                        <td colspan="3">
	                            <ehr:dic-checkbox name="placeName" dicmeta="HE00030" value="${heIndividual.placeName}" code="1,2,3,4,5,6,7"
	                                              onchange="toggleOtherCK('placeName','other3','7')" reg='{"required":"true"}'/>
										<span id="other3" style="display: none;">
											<input type="text" name="placeDesc" value="${heIndividual.placeDesc }"  reg='{"required":"true","maxlength":"100"}'
	                                               style="width: 20%"/>
										</span>
	                        </td>
                    	</tr>	
			<tr>
				<th><label class="required">现存主要健康问题</label></th>
				<td colspan="3"><textarea name="healthDesc" reg='{"required":"true","maxlength":"200"}' style="height: 80px; width: 700px;">${heIndividual.healthDesc}</textarea></td>
			</tr>
			<tr>
	                        <th><label class="required">健康指导意见:</label></th>
	                        <td colspan="3">
	                            <ehr:dic-checkbox name="guidanceAdvice" dicmeta="HE00031" value="${heIndividual.guidanceAdvice}" code="1,2,3,4,5,6,7，8,9,10,11,12"
	                                              onchange="toggleOtherCK('guidanceAdvice','other4','12')" reg='{"required":"true"}'/>
										<span id="other4" style="display: none;">
											<input type="text" name="guidanceAdviceDesc" value="${heIndividual.guidanceAdviceDesc }"  reg='{"required":"true","maxlength":"100"}'
	                                               style="width: 20%"/>
										</span>
	                        </td>
                    	</tr>
			
			<tr>
								<th style="width: 16%"><label class="required">危险因素控制</label></th>
								<td id="ttbRisk">
									<label>
										<input class="risk" type="checkbox" name="riskQuitSmoking" ${heIndividual.riskQuitSmoking eq '1' ? 'checked' : ''}  value="1"/>
										<span class="risklable">戒烟</span>
									</label>
									<br>
									<label>
										<input class="risk" type="checkbox" name="riskHealthDrink" ${heIndividual.riskHealthDrink eq '1' ? 'checked' : ''}  value="1"/>
										<span class="risklable">健康饮酒</span>
									</label>
									<br>
									<label>
										<input class="risk" type="checkbox" name="riskDiet" ${heIndividual.riskDiet eq '1' ? 'checked' : ''}  value="1"/>
										<span class="risklable">饮食</span>
									</label>
									<br>
									<label>
										<input class="risk" type="checkbox" name="riskExercise" ${heIndividual.riskExercise eq '1' ? 'checked' : ''}  value="1"/>
										<span class="risklable">锻炼</span>
									</label>
									<br>
									<label>
										<input class="risk" type="checkbox" name="riskHygiene" ${heIndividual.riskHygiene eq '1' ? 'checked' : ''}  value="1"/>
										<span class="risklable">注意卫生</span>
									</label>
									<br>
									<label>
										<input class="risk" type="checkbox" name="riskNursing" ${heIndividual.riskNursing eq '1' ? 'checked' : ''}  value="1"/>
										<span class="risklable">注意护理</span>
									</label>
									<br>
									<label>
										<input class="risk" type="checkbox" id="riskWeightReduction" onclick="util.clickShowText(this,'riskWeightTarget')" name="riskWeightReduction" ${heIndividual.riskWeightReduction eq '1' ? 'checked' : ''}  value="1"/>
										<span class="risklable">减体重</span>
									</label>
									<span id="riskWeightTarget" class="hidediv">目标:&nbsp;
										<!--  <input type="text" name="heIndividual.riskWeightTarget" value="${heIndividual.riskWeightTarget}">  -->
		            	 <tag:numberInput point="point"  style="width: 40px;"  value="${heIndividual.riskWeightTarget}" name="riskWeightTarget"  cssClass="width30 " reg="{'dependOn':'riskWeightReduction','scale':2,'required':'true','min':0,'max':9999}"/>Kg
		            </span>
									<br>
									<label>
										<input class="risk" type="checkbox" id="guideVaccination" onclick="util.clickShowText(this,'guideVaccinationDesc')" name="guideVaccination" ${heIndividual.guideVaccination eq '1' ? 'checked' : ''}  value="1"/>
										<span class="risklable">建议接种疫苗</span>
									</label>
									<span id="guideVaccinationDesc" class="hidediv"> <input type="text" name="guideVaccinationDesc" value="${heIndividual.guideVaccinationDesc}" style="width: 200px;"  reg='{"dependOn":"guideVaccination","required":"true","maxlength":"33"}'> </span>
									<br>
									<label class="risklable">
										<input class="risk" type="checkbox" id="riskOther" onclick="util.clickShowText(this,'riskOtherDesc')" name="riskOther" ${heIndividual.riskOther eq '1' ? 'checked' : ''}  value="1"/>
										<span class="risklable">其他</span></label>
									<span id="riskOtherDesc" class="hidediv"><input type="text" name="riskOtherDesc" value="${heIndividual.riskOtherDesc}" reg='{"dependOn":"riskOther","required":"true","maxlength":"33"}' style="width: 200px;" ></span>
								</td>
							</tr>
			<tr>
				<th></th>
				<td colspan="3">
					<div style="width: 690px;">
						<c:forEach items="${attches}" var="attche" >
							<div style="width: 150px;float: left;margin-top: 5px;text-align: center;" id="${attche.id}-div">
								<c:if test="${attche.imageFlag eq true}">
										<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
											src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2"
										/></a>
									</c:if>
									<c:if test="${attche.imageFlag eq false}">
										<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.fileName}</a>
									</c:if>
									<br />
									<a href="javascript:void(0);" onclick="healthEducationUpload.deleteFile('${attche.id}')">删除</a>
							</div>
						</c:forEach>
					</div>
				</td>
			</tr>
			<tr><th><label >服务机构</label></th>
						<td>${organization.organName}</td>
						</tr>
			<tr>
				<th><label class="required">附件</label></th>
				<td style="width: 120px;"><div id="heActivityFile"></div></td>
				<td colspan="2"><span style="color: blue;">注：单个附件请控制在2M之内(建议图片分辨率为800像素*600像素如果原图片超过2M，建议使用<a href="http://xiuxiu.meitu.com" target="blank"><strong>美图</strong></a>软件修改),附件数量不能超过5个</span> <span id="activeTips" style="color: blue;"></span>
				</td>
			</tr>
		</table>
	</div>
</form>

<script type="text/javascript">
layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#guidanceTime' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
    });
    
    
    
  });
</script>