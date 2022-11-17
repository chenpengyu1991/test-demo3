<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/case/frts.js" type="text/javascript"></script>
<script type="text/javascript"> 
	$(function(){
        enableChangeConfirm();
    });
</script>

<div class="toolbar toolbarfixed0" style="margin-top: 8px;">
    <%-- <a href="javascript:void(0)" onclick="javascript:frSearch.returnSearch()"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:void(0)" onclick="javascript:frSearch.returnSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <c:if test="${'1' != logoff}">
        <%-- <a href="javascript:void(0)" onclick="javascript:frts.saveFr('add')" id="baocun" ><b class="baocun">保存</b></a> --%>
        <a href="javascript:void(0)" onclick="javascript:frts.saveFr('add')" ><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
    </c:if>
</div>
<div class="postcontent contentfixed61">
    <form id="frForm">
    <div class="postdiv" id="subDetailDiv">
    	 <fieldset style="margin-top: 10px" class="layui-elem-field">
            <legend>1. 编 号</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 50px; width: 15%;"/>
                        <col style="min-width: 80px; width: 35%;"/>
                        <col style="min-width: 50px; width: 15%;"/>
                        <col style="min-width: 80px; width: 35%;"/>
                    </colgroup>
                    <tr>
                        <th><label class="required">病例编号：</label></th>
                        <td><input type="text" name="recordNumber" value="${listFr.recordNumber}" reg='{"maxlength":"50","required":"true"}' readonly="readonly"/></td>
                    </tr>
                </table>
        </fieldset>
        <fieldset style="margin-top: 10px" class="layui-elem-field">
            <legend>2. 基本情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 50px; width: 15%;"/>
                        <col style="min-width: 80px; width: 35%;"/>
                        <col style="min-width: 50px; width: 15%;"/>
                        <col style="min-width: 80px; width: 35%;"/>
                    </colgroup>
                    <tr>
                        <input type="hidden" id="infectiousCode" name="infectiousCode" value="${infectiousCode}">
                        <input type="hidden" id="singleIdFr" name="idmId" value="${singleId}">
                        <input type="hidden" name="id" id="subId" value="${listFr.id}">  
                        <input type="hidden" name="visitById" id="visitById" value="${listFr.visitById}">
                        <input type="hidden" name="visitInst" id="visitInst" value="${listFr.visitInst}">
                        <input type="hidden" name="createUnit" id="createUnit" value="${listFr.createUnit}">
                        <input type="hidden" name="createUser" id="createUser" value="${listFr.createUser}">
                        <div style="display:none;"><tag:dateInput name="birthday" date="${listFr.birthday}" onlypast="true"></tag:dateInput>  </div>
                        <th>病人姓名：</th>
                        <td><input type="text" name="name" value="${listFr.name}" reg='{"maxlength":"50","required":"true"}' readonly="readonly"/></td>
                        <th>性别：</th>
                        <td><ehr:dic-radio dicmeta="GBT226112003" name="gender" value="${listFr.gender}"/></td>
                    </tr>
                    <tr>
                        <th>出生日期：</th>
                        <td>
                        <%-- <tag:dateInput name="birthday" date="${listFr.birthday}" onlypast="true"></tag:dateInput>  --%> 
                        <input type="text" class="layui-input x-admin-content-sm-date"  name="birthday" id="birthday" value="<fmt:formatDate value='${listFr.birthday}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                    </tr>
                    <tr>
                        <th>病人详细住址：</th>
                        <td colspan="3">
                            <ehr:dic-town-village villageName="pastreet" townName="patownShip" villageValue="${listFr.pastreet}" townValue="${listFr.patownShip}" width="180px;" />
                            <input type="text" name="pahouseNumber" value="${listFr.pahouseNumber}" reg='{"maxlength":"50"}' style="width: 180px;"/>
                        </td>
                    </tr>
               </table>
        </fieldset>
        <fieldset style="margin-top: 10px" class="layui-elem-field">
         <legend>3. 麻痹60天后随访</legend>
         <table class="posttable">
             <colgroup>
                 <col style="width: 20%"/>
                 <col style="width: 25%"/>
                 <col style="width: 20%"/>
                 <col style="width: 35%"/>
             </colgroup>
             <tr>
                 <th>a. 是否进行病例随访：</th>
                 <td><ehr:dic-radio dicmeta="PH00001" name="followUp" value="${listFr.followUp}" code="1,2"/></td>
                 <th>b. 随访单位：</th>
                 <td><ehr:dic-radio dicmeta="CV850003" code="3,2,1" name="followUpUnit" value="${listFr.followUpUnit}"/></td>
             </tr>
             <tr>
                 <th>c. 随访日期：</th>
                 <td><%-- <tag:dateInput id="visitDt" name="visitDt" date="${listFr.visitDt}" pattern="yyyy/MM/dd" nullToToday="true" onlypast="true"
                 		reg='{"compare":["toCdcDt","le","随访日期不能小于随访表送达省CDC时间"]}' /> --%>
                 	<input type="text" reg='{"compare":["toCdcDt","le","随访日期不能小于随访表送达省CDC时间"]}' class="layui-input x-admin-content-sm-date"  name="visitDt" id="visitDt" value="<fmt:formatDate value='${listFr.visitDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />	
                 		</td>
                 <th>d. 随访人姓名：</th>
                 <td> <ehr:user userCode="${listFr.visitById}"/>
                      <input type="hidden" name="visitById" value="${listFr.visitById}"/></td>
             </tr>
             <tr>
                 <th>e. 病例死亡：</th>
                 <td><ehr:dic-radio dicmeta="PH00001" name="followupCaseDie" value="${listFr.followupCaseDie}" code="1,2"/></td>
                 <th>f. 病例失访：</th>
                 <td><ehr:dic-radio dicmeta="PH00001" name="followupCaseLostFollowup" value="${listFr.followupCaseLostFollowup}" code="1,2"/></td>
             </tr>
             <tr>
                 <th> g. 是否残留麻痹：</th>
                 <td>
                 	<ehr:dic-radio dicmeta="PH00001" name="followupResidualParalysis" value="${listFr.followupResidualParalysis}" code="1,2"
                 	 onchange="toggleOther('followupResidualParalysis','leftUpperLimb',1);"/>
                 </td>
             </tr>
             <tr id="leftUpperLimb" style="${listFr.followupResidualParalysis == '1' ? '' : ';display:none;'}">
             	<td colspan="4" style="padding: 0px;">
             		<table>
             			<colgroup>
			                 <col style="width: 20%"/>
			                 <col style="width: 25%"/>
			                 <col style="width: 20%"/>
			                 <col style="width: 35%"/>
			             </colgroup>
             			<tr>
			                 <th> 麻痹部位：</th>
			             </tr>
			             <tr>
			                 <th>h. 左上肢：</th>
			                 <td><ehr:dic-list name="leftUpperLimb" dicmeta="IDM00116" value="${listFr.leftUpperLimb}" width="60%" uninclude="99"/></td>
			                 <th>i. 右上肢：</th>
			                 <td><ehr:dic-list name="rightUpperLimb" dicmeta="IDM00116" value="${listFr.rightUpperLimb}" width="50%" uninclude="99"/></td>
			             </tr>
			             <tr>
			                 <th> j. 左下肢：</th>
			                 <td>
			                 	<ehr:dic-list name="leftLowerLimb" dicmeta="IDM00116" value="${listFr.leftLowerLimb}" width="60%" uninclude="99"/>
			                </td>
			                <th> k. 右下肢：</th>
			                <td><ehr:dic-list name="rightLowerLimb" dicmeta="IDM00116" value="${listFr.rightLowerLimb}" width="50%" uninclude="99"/></td>
			             </tr>
             		</table>
             	</td>
             </tr>
             <tr>
                 <th>l. 肢体感觉障碍：</th>
                 <td colspan="3">
                 	<ehr:dic-radio dicmeta="PH00002" name="limbSensoryDisturbance" value="${listFr.limbSensoryDisturbance}" uninclude="3,5"
                 		onchange="toggleOther('limbSensoryDisturbance','limbPart',1);"/>
                 		<span id="limbPart" style="${listFr.limbSensoryDisturbance == '1' ? '' : 'display:none;'}">
	     					 部位(请注明)：<input type="text" name="limbPart" value="${listFr.limbPart}" reg='{"maxlength":"100"}' style="width: 40%"/>
     					 </span>
                 </td>
             </tr>
             <tr>
                 <th> m. 如有大小便失禁,持续时间：</th>
                 <td><input type="text" name="incontinentDuration" value="${listFr.incontinentDuration}" reg='{"maxlength":"20"}'/>天</td>
                 <th>n. 巴彬斯基氏反射：</th>
                 <td><ehr:dic-radio dicmeta="PH00002" name="babinskiReflex" value="${listFr.babinskiReflex}" uninclude="3,5"/></td>
             </tr>
             <tr>
                 <th>o. 踝阵挛：</th>
                 <td><ehr:dic-radio dicmeta="PH00002" name="ankleClonus" value="${listFr.ankleClonus}" uninclude="3,5"/></td>
                 <th>P. 肌肉萎缩：</th>
                 <td>
                 	<ehr:dic-radio dicmeta="PH00002" name="muscleAtrophy" value="${listFr.muscleAtrophy}" uninclude="3,5"
                 	onchange="toggleOther('muscleAtrophy','musclePart',1);"/>
                 	<span id="musclePart" style="${listFr.muscleAtrophy == '1' ? '' : 'display:none;'}">
                 		部位（请注明）：<input type="text" name="musclePart" value="${listFr.musclePart}" reg='{"maxlength":"100"}' style="width: 40%"/>
                    </span>
                 </td>
             </tr>
             <tr>
                 <th>q. 深部腱反射异常：</th>
                 <td>
                 	<ehr:dic-radio dicmeta="PH00002" name="dtrUnusual" value="${listFr.dtrUnusual}" uninclude="3,5"
                 		onchange="toggleOther('dtrUnusual','tendoCalcaneus',1);"/>
                 </td>
             </tr>
             <tr id="tendoCalcaneus" style="${listFr.dtrUnusual == '1' ? '' : 'display:none;'}">
                 <td colspan="4" style="padding: 0px;">
                 	<table>
                 		<colgroup>
			                 <col style="width: 20%"/>
			                 <col style="width: 25%"/>
			                 <col style="width: 20%"/>
			                 <col style="width: 35%"/>
			             </colgroup>
                 		<tr>
			                 <th>跟腱：</th>
			                 <td><ehr:dic-radio dicmeta="IDM00118" name="tendoCalcaneus" value="${listFr.tendoCalcaneus}" uninclude="5"/></td>
			                 <th>膝：</th>
			                 <td><ehr:dic-radio dicmeta="IDM00118" name="knee" value="${listFr.knee}" uninclude="5"/></td>
			             </tr>
			             <tr>
			                 <th>肱二头肌：</th>
			                 <td><ehr:dic-radio dicmeta="IDM00118" name="bicepsBrachii" value="${listFr.bicepsBrachii}" uninclude="5"/></td>
			             </tr>
                 	</table>
                 </td>
             </tr>
             <tr>
                 <th> r. 行走能力：</th>
                 <td><ehr:dic-list name="locomotorActivity" dicmeta="IDM00127" value="${listFr.locomotorActivity}" width="80%"/></td>
                 <th>s. 检查医师：</th>
                 <td>
                 	<ehr:dic-list name="checkDoctor" dicmeta="IDM00128" value="${listFr.checkDoctor}"
                 		onchange="toggleOtherSC('checkDoctor','checkDoctorOther','99')" width="40%"/>	
                  	<input type="text" id="checkDoctorOther" name="checkDoctorOther" value="${listFr.checkDoctorOther}" reg='{"maxlength":"100"}' style="${listFr.checkDoctor == '99' ? 'width:40%;' : 'width:40%;display:none;'}" />
                  </td>
             </tr>
             <tr>
                 <th>t. 病例出院诊断：</th>
                 <td>
                 	<ehr:dic-list name="outHospitlDiagnosis" dicmeta="IDM00121" value="${listFr.outHospitlDiagnosis}" uninclude="1,6"
                 		onchange="toggleOtherSC('outHospitlDiagnosis','diagnosisOtherTr','99')" width="60%"/>
                 	<input type="text" id="diagnosisOtherTr" name="diagnosisOther" value="${listFr.diagnosisOther}" reg='{"maxlength":"100"}'
                 		style="${listFr.outHospitlDiagnosis == '99' ? 'width:25%;' : 'width:25%;display:none;'}"/>
                 </td>
                 <th>u. 随访表送达省CDC时间：</th>
                 <td>
                 	<%-- <tag:dateInput id="toCdcDt" name="toCdcDt" pattern="yyyy/MM/dd" date="${listFr.toCdcDt}" nullToToday="true" onlypast="true" 
                 		reg='{"compare":["visitDt","ge","随访表送达省CDC时间不能大于随访日期"]}'/> --%>
                 		<input type="text" reg='{"compare":["visitDt","ge","随访表送达省CDC时间不能大于随访日期"]}' class="layui-input x-admin-content-sm-date"  name="toCdcDt" id="toCdcDt" value="<fmt:formatDate value='${listFr.toCdcDt}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                 </td>
             </tr>

         </table>
     </fieldset>
    </div>
    </form>
</div>
<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#birthday' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });

    laydate.render({
      elem: '#visitDt' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });
    
    laydate.render({
        elem: '#toCdcDt' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
      });
  });
</script>