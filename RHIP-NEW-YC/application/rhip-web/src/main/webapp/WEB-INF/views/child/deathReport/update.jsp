<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/ehr/child/deathReport/update.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" id="button_save">
		<button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>保存</button>
	</a>
	<a href="javascript:void(0)" id="childDeathSaveBack">
		<button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button>
	</a>
</div>
<div id="con_two_3" class="postcontent contentfixed32" >
	<div class="msgError" style="display: none" id="person_px_info_errbox"></div>
	<div id="msgError" class="msgError" style="display: none;"></div>
	<form action="" id="childrenForm">
		<input type="hidden" name="id" value="${deathMedicineCertificate.id}" />
		<input type="hidden" name="fillOrganCode" value="${fillOrganCode}" />
		<div style="background-color: white;">
			<!-- <i class="pop_No"> <a class="bc" id="button_save" style="font-size:12px;font-weight:normal">保存</a>
			</i> -->
			<ul>
				<li style="text-align: center; font-size: 25px;">儿童死亡报告卡</li>
			</ul>
			<br />
			<table class="posttable">
				<!-- <tr>
					<td style="width: 70%;"></td>
					<td style="line-height:1.5em;">
						表制定机关：国家卫生计生委<br/>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：卫计统60-1表<br/>
						批准机关：国家统计局<br/>
						批准文号：国统制[2015]166号 <br/>
						有效期至：2017年12月
					</td>
				</tr> -->
				<tr>
					<td style="width: 70%;float:left;margin-left:60px;">
						<input id="childDeathhrtownShi" type="text" style="width:100px;" name="hrtownShip" 
							value="${deathMedicineCertificate.hrtownShip}" readonly="readonly"/>区县&nbsp;
						<input id="childDeathpatownShip" type="text" style="width:100px;" 
							value="${deathMedicineCertificate.patownShip}"  readonly="readonly"　readonly="readonly"/>
					</td>
					<td style="float:right;margin-right:20px;">
						<input type="hidden" value="${deathMedicineCertificate.isAdd }" id="isAddUpdateHid"/>
						<input style="width:13px;height:13px;line-height:13px;margin-right:2px; vertical-align:-2px;*vertical-align:middle;_vertical-align:3px;" type="checkbox" name="isAdd" value="" id="isAdd">补卡
					</td>
				</tr>
			</table>
			<hr style="margin-top:10px;margin-bottom:10px;">
			<div class="postcontent">
				<table style="line-height: 10px;" class="posttable">
					<colgroup>
						<col style="width: 20%;" />
						<col style="width: 30%;" />
						<col style="width: 20%;" />
						<col style="width: 30%;" />
					</colgroup>
					<tr>
						<th width="15%"><label class="required">编号</label></th>
						<td colspan="3">
							<input type="text" style="width:100px;" reg='{"maxlength":"8","required":"true"}' name="reportNo" value="${deathMedicineCertificate.reportNo}"/>
						</td>
					</tr>
					<tr>
						<th>住址</th>
						<td colspan="3">
							<ehr:dic-town-street-village defaultval="Y" 
										villageId="village_address" streetId="street_address"
										townId="town_address" villageName="pastreet"
										streetName="patownShip" townName="pacounty"
										villageValue="${deathMedicineCertificate.pastreet}"
										streetValue="${deathMedicineCertificate.patownShip}"
										townValue="${deathMedicineCertificate.pacounty}" width="118px;"
										callback="deathMedicineCertificateSearch1.displayPaAddress" />
						</td>
					</tr>
					<tr>
						<th>父亲姓名</th>
						<td>
							<input type="text" style="width:120px;" name="fathorName" value="${deathMedicineCertificate.fathorName}"/>
						</td>
						<th>母亲姓名</th>
						<td>
							<input type="text" style="width:120px;" name="mothorName" value="${deathMedicineCertificate.mothorName}"/>
						</td>
					</tr>
					<tr>
						<th><label class="required">儿童姓名</label></th>
						<td>
							<input reg='{"required":true}' type="text" style="width:120px;" name="name" value="${deathMedicineCertificate.name}"/>
						</td>
						<th>联系电话</th>
						<td>
							<input type="text" style="width:120px;" name="familyPhone" value="${deathMedicineCertificate.familyPhone}"/>
						</td>
					</tr>
					<tr>
						<th width="15%">户籍</th>
						<td colspan="3"><ehr:dic-radio name="censusRegister" dicmeta="YC201701"
		                	value="${deathMedicineCertificate.censusRegister==null?1:deathMedicineCertificate.censusRegister}" /></td>
					</tr>
					<tr>
						<th width="15%">性别</th>
						<td>
							<ehr:dic-radio name="gender" dicmeta="GBT226112003_1"
		                    	value="${deathMedicineCertificate.gender==null?1:deathMedicineCertificate.gender}" />
						</td>
						<th width="15%"><label class="required">出生日期</label></th>
						<td>
						<input type="text" reg='{"required":true}' class="layui-input x-admin-content-sm-date"  name="birthday" id="childBirthday" value="<fmt:formatDate value='${deathMedicineCertificate.birthday}' pattern='yyyy/MM/dd HH:mm'/>" style="padding-left: 0px;width: 130px;" />
						<%-- <tag:dateInput id="childBirthday"
								reg='{"required":true}' style="width:130px;" pattern="yyyy/MM/dd HH:mm" name="birthday"
								date="${deathMedicineCertificate.birthday}" onlypast="true"></tag:dateInput> --%>
						</td>
					</tr>
					<tr>
						<th width="15%">出生体重(克)</th>
						<td colspan="3">
							<tag:numberInput name="bornWeight" value="${deathMedicineCertificate.bornWeight}" maxlength="10" point="1" style="width:60px;"/>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<ehr:dic-radio name="bornWeightSelect" dicmeta="YC201706"
		                    	value="${deathMedicineCertificate.bornWeightSelect==null?1:deathMedicineCertificate.bornWeightSelect}" />&nbsp;&nbsp;&nbsp;&nbsp;
		                	孕周 &nbsp;
		                	<tag:numberInput name="pregnantWeek" value="${deathMedicineCertificate.pregnantWeek}" maxlength="100" style="width:60px;"/>周      
						</td>
					</tr>
					<tr>
						<th width="15%">出生地点</th>
						<td colspan="3"><ehr:dic-radio name="bornSite" dicmeta="YC201708"
		                	value="${deathMedicineCertificate.bornSite==null?1:deathMedicineCertificate.bornSite}" /></td>
					</tr>
					<tr>
						<th width="15%"><label class="required">死亡日期</label></th>
						<td colspan="3"><%-- <tag:dateInput id="childDeathDate" 
								reg='{"required":true}' style="width:130px;" name="deathDate"
								date="${deathMedicineCertificate.deathDate}" pattern="yyyy/MM/dd HH:mm" onlypast="true"></tag:dateInput> --%>
								<input type="text" reg='{"required":true}' class="layui-input x-admin-content-sm-date"  name="deathDate" id="childDeathDate" value="<fmt:formatDate value='${deathMedicineCertificate.deathDate}' pattern='yyyy/MM/dd HH:mm'/>" style="padding-left: 0px;width: 130px;" />
						</td>
					</tr>
					<tr>
						<th width="15%">死亡年龄</th>
						<td colspan="3">
							<input type="text" readonly="readonly" reg='{"digits":"true","min":"0","max":"100"}' style="width:40px;" name="ageSui" value="${deathMedicineCertificate.ageSui}"/>岁&nbsp;&nbsp;
							<input type="text" readonly="readonly" reg='{"digits":"true","min":"0","max":"100"}' style="width:40px;" name="ageMonth" value="${deathMedicineCertificate.ageMonth}"/>月&nbsp;&nbsp;
							<input type="text" readonly="readonly" reg='{"digits":"true","min":"0","max":"100"}' style="width:40px;" name="ageDay" value="${deathMedicineCertificate.ageDay}"/>天&nbsp;&nbsp;
							<input type="text" readonly="readonly" reg='{"digits":"true","min":"0","max":"100"}' style="width:40px;" name="ageHour" value="${deathMedicineCertificate.ageHour}"/>时&nbsp;&nbsp;
							<input type="text" readonly="readonly" reg='{"digits":"true","min":"0","max":"100"}' style="width:40px;" name="ageSecond" value="${deathMedicineCertificate.ageSecond}"/>分
						</td>
					</tr>
					<tr>
						<th width="15%">死亡诊断</th>
						<td colspan="3">
							(a) 直接导致死亡的疾病或情况:
							<input type="text" style="width:140px;" name="directCondition" value="${deathMedicineCertificate.directCondition}"/><br/>
							(b) 引起(a)的疾病或情况:
							<input type="text" style="width:140px;" name="conditionA" value="${deathMedicineCertificate.conditionA}"/><br/>
							(c) 引起(b)的疾病或情况:
							<input type="text" style="width:140px;" name="conditionB" value="${deathMedicineCertificate.conditionB}"/><br/>
							(d) 引起(c)的疾病或情况:
							<input type="text" style="width:140px;" name="conditionC" value="${deathMedicineCertificate.conditionC}"/><br/>
							根本死因:<input type="text" style="width:140px;" name="deathReason" value="${deathMedicineCertificate.deathReason}"/>
						</td>
					</tr>
					<tr>
						<th width="15%">分类编号</th>
						<td>
							<input type="text" style="width:40px;" name="categoryNo" readonly="readonly" value="${deathMedicineCertificate.categoryNo }"/>&nbsp;&nbsp;&nbsp;
							<select style="width:120px;" id="categoryNoSelect"></select>
						</td>
						<th width="15%">ICD-10编码</th>
						<td>
							<input type="text" style="width:120px;" name="icd10Code" value="${deathMedicineCertificate.icd10Code }"/>
						</td>
					</tr>
					<tr>
						<th width="15%">死亡地点</th>
						<td colspan="3">
							<input type="hidden" id="deathSiteOtherMarkHid" value="${deathMedicineCertificate.deathSiteOtherMark }"/>
							<ehr:dic-radio name="deathSite" dicmeta="YC201703"
		                    	value="${deathMedicineCertificate.deathSite==null?1:deathMedicineCertificate.deathSite}" />&nbsp;&nbsp;
		                    <%-- <span id="deathSiteOtherMarkSpan">其他&nbsp;<input type="text" style="width:120px;" reg='{"required":true}' name="deathSiteOtherMark" value="${deathMedicineCertificate.deathSiteOtherMark }"/></span> --%>                      
		                </td>
					</tr>
					<tr>
						<th width="15%">死前治疗</th>
						<td colspan="3">
							<ehr:dic-radio name="deathBeforeTreat" dicmeta="YC201704"
		                    	value="${deathMedicineCertificate.deathBeforeTreat==null?1:deathMedicineCertificate.deathBeforeTreat}" />
						</td>
					</tr>
					<tr>
						<th width="15%">诊断级别</th>
						<td colspan="3"><ehr:dic-radio name="diagnosisLevel" dicmeta="YC201705"
		                	value="${deathMedicineCertificate.diagnosisLevel==null?1:deathMedicineCertificate.diagnosisLevel}" /></td>
					</tr>
					<tr>
						<th width="15%">未治疗或未就医主要原因</th>
						<td colspan="3">
							<input type="hidden" id="noTreatReasonOtherHid" value="${deathMedicineCertificate.noTreatReasonOther }"/>
							<ehr:dic-radio  name="noTreatReason" dicmeta="YC201707"
		                    	value="${deathMedicineCertificate.noTreatReason==null?1:deathMedicineCertificate.noTreatReason}" />&nbsp;&nbsp;&nbsp;
		                	<%-- <span id="noTreatReasonOtherSpan">其他&nbsp;<input type="text" style="width:120px;" reg='{"required":true}' name="noTreatReasonOther" value="${deathMedicineCertificate.noTreatReasonOther }"/></span> --%>
		            	</td>
					</tr>
					<tr>
						<th width="15%">死因诊断依据</th>
						<td colspan="3"><ehr:dic-radio name="deathReasonBasis" dicmeta="YC201709"
		                	value="${deathMedicineCertificate.deathReasonBasis==null?1:deathMedicineCertificate.deathReasonBasis}" /></td>
					</tr>
					<tr>
						<th>填报单位</th>
						<td>
							<input type="text" readonly="readonly" style="width:200px;" name="fillOrganName" value="${fillOrganName}"/>
						</td>
						<th><label class="required">填报人</label></th>
						<td>
							<input type="text" reg='{"required":true}' style="width:120px;" name="fillUserName" value="${deathMedicineCertificate.fillUserName}"/>
						</td>
					</tr>
					<tr>
						<th><label class="required">填报日期</label></th>
						<td>
							<%-- <tag:dateInput style="width:120px;" name="fillTime" reg='{"required":true}' pattern="yyyy/MM/dd"
								date="${deathMedicineCertificate.fillTime}" nullToToday="true" onlypast="true"/> --%>
								
							<input type="text" reg='{"required":true}' class="layui-input x-admin-content-sm-date"  name="fillTime" id="fillTime" value="<fmt:formatDate value='${deathMedicineCertificate.fillTime}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 120px;" />	
						</td>
					</tr>
				</table>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript">
layui.use('laydate', function() {
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#childBirthday' 
    	  ,type:'datetime'
   	   ,format: 'yyyy/MM/dd HH:mm'
   	  , trigger: 'click' 
    });
    laydate.render({
        elem: '#childDeathDate' 
		,type:'datetime'
		,format: 'yyyy/MM/dd HH:mm'
		,trigger: 'click'
		,done:function (value) {
			childDeathReport();
		}
      });
    laydate.render({
        elem: '#fillTime' 
     	   ,format: 'yyyy/MM/dd'
     	  , trigger: 'click' 
      });
  });
</script>