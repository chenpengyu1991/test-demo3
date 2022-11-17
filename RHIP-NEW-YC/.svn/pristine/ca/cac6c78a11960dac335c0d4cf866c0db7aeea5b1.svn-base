<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/woman/PostpartumFTwo/postpartumFTwo.js" type="text/javascript" ></script>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        laydate.render({
          elem: '#leaveHospitalDate'
           ,format: 'yyyy/MM/dd'
        });
        
        laydate.render({
          elem: '#deliveryDate'
        	  ,format: 'yyyy/MM/dd'
        });
      
        laydate.render({
            elem: '#supervisionDate'
             ,format: 'yyyy/MM/dd'
             ,trigger: 'click'
          });
          
      });

    </script>
<div class="toolbar">
    <a href="javascript:void(0)" id="revert"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
	<a href="javascript:void(0);" id="PosFTwoSave"><button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>保存</button></a>
</div>
<div class="Contentbox divFixed105" style="text-align: left;top: 65px;">
    <form id="addPosFTwoForm"  method="post">
        <input type="hidden" id="personId" name="personId" value="${postpartumDaysHealthInfo.personId}" />
        <br/>
        <br/>
        <ul>
            <li style="text-align: center; font-size: 25px;">产后42天健康检查记录表</li>
        </ul>
        <br/>
        <br/>
        <div class="postcontent">
            <table class="posttable" >
                <colgroup>
                    <col style="width: 15%;"/>
                    <col style="width: 35%;"/>
                    <col style="width: 15%;"/>
                    <col style="width: 35%;"/>
                </colgroup>
                <tr>
                    <th><label class="required">姓名</label></th>
                    <td><input reg='{"required":"true"}' type="text" id="name" name="name" value="${postpartumDaysHealthInfo.name}" /></td>
                    <th><label class="required">健康档案编号</label></th>
                    <td><input readonly="readonly" reg='{"required":"true"}' type="text" id="healthFileNo" name="healthFileNo" value="${postpartumDaysHealthInfo.healthFileNo}" /></td>
                    <%--<td><tag:numberInput name="healthFileNo" id="healthFileNo" value="${postpartumDaysHealthInfo.healthFileNo}"   reg="{'min':0,'required':true}"/></td>--%>
                </tr>
                <tr>
                    <th width="15%"><label class="required">身份证号</label></th>
                    <td>
                        <tag:idcardInput name="idCard" id="idCard"  reg='{"required":"true","idCard":true}' value="${postpartumDaysHealthInfo.idCard}">
                        </tag:idcardInput>
                    </td>
                    <%--<td><input type="text" id="idCard" name="postnatalFollowup.idCard" value="${postnatalFollowup.idCard}" /></td--%>
                    <th width="15%"><label class="required">血压</label></th>
                    <td>
                        <tag:numberInput style="width:90px;" name="sbp" value="${postpartumDaysHealthInfo.sbp}"   reg="{'min':0,'max':9999,'required':true}" id="sbp"/>/
                        <tag:numberInput style="width:90px;" name="dbp" value="${postpartumDaysHealthInfo.dbp}"   reg="{'min':0,'max':9999,'required':true}" id="dbp"/>mmHg
                    </td>
                </tr>
                <tr>
                    <th width="15%"><label class="required">一般健康情况</label></th>
                    <td><input type="text" id="healthStatus" name="healthStatus" reg='{"required":"true"}' value="${postpartumDaysHealthInfo.healthStatus}" /></td>
                    <th width="15%"><label class="required">一般心理状况</label></th>
                    <td><input type="text" id="psychologicalStatus" name="psychologicalStatus" reg='{"required":"true"}' value="${postpartumDaysHealthInfo.psychologicalStatus}" /></td>
                </tr>
                <%--<tr>
                    <th><label class="required">血压</label></th>
                    <td colspan="3">
                        <tag:numberInput style="width:80px;" name="PostnatalFollowupDTO.postnatalFollowup.sbp" value="${postnatalFollowup.sbp}"   reg="{'min':0,'max':9999}" id="sbp"/>/
                        <tag:numberInput style="width:80px;" name="PostnatalFollowupDTO.postnatalFollowup.dbp" value="${postnatalFollowup.dbp}"   reg="{'min':0,'max':9999}" id="dbp"/>mmHg
                    </td>
                </tr>--%>
                <tr>
                    <th><label class="required">乳房</label></th>
                    <td>
                        <label><input type="radio" name="breastAnomalySign" onclick="util.clickHideText(this,'breastAnomalyDescText')" ${postpartumDaysHealthInfo.breastAnomalySign eq "0" or postpartumDaysHealthInfo.breastAnomalySign eq null? "checked" : ""} value="0">未见异常</label>
                        <label><input type="radio" id="breastAnomalySign" onclick="util.clickShowText(this,'breastAnomalyDescText')" name="breastAnomalySign" ${postpartumDaysHealthInfo.breastAnomalySign eq"1" ?"checked":""} value="1">异常</label>
                        <span id="breastAnomalyDescText" CLASS="hidediv"> <input reg='{"maxlength":"33","required":"true"}' type="text" name="breastAnomalyDesc" value="${postpartumDaysHealthInfo.breastAnomalyDesc}" style="width: 150px;"></span>
                    </td>
                    <th width="15%"><label class="required">分娩日期</label></th>
                    <td>
                    	<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="deliveryDate" id="deliveryDate" 
                            value="<fmt:formatDate value='${postpartumDaysHealthInfo.deliveryDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />   
                    </td>
                </tr>
                <tr>
                    <th><label class="required">恶露</label></th>
                    <td>
                        <label><input type="radio" name="lochiaAnomalySign" onclick="util.clickHideText(this,'lochiaConditionText')" ${postpartumDaysHealthInfo.lochiaAnomalySign eq "0" or postpartumDaysHealthInfo.lochiaAnomalySign eq null? "checked" : ""} value="0">未见异常</label>
                        <label><input type="radio" id="lochiaAnomalySign" onclick="util.clickShowText(this,'lochiaConditionText')" name="lochiaAnomalySign" ${postpartumDaysHealthInfo.lochiaAnomalySign eq"1" ?"checked":""} value="1">异常</label>
                        <span id="lochiaConditionText" CLASS="hidediv"> <input reg='{"maxlength":"33","required":"true"}' type="text" name="lochiaCondition" value="${postpartumDaysHealthInfo.lochiaCondition}" style="width: 150px;"></span>
                    </td>
                    <th><label class="required">出院日期</label></th>
                    <td>
                    	<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="leaveHospitalDate" id="leaveHospitalDate" 
                            value="<fmt:formatDate value='${postpartumDaysHealthInfo.leaveHospitalDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" /> 
                    </td>
                </tr>
                <tr>
                    <th><label class="required">子宫</label></th>
                    <td colspan="3">
                        <label><input type="radio" name="corpusAnomaly" onclick="util.clickHideText(this,'corpusAnomalyDescText')" ${postpartumDaysHealthInfo.corpusAnomaly eq "0" or postpartumDaysHealthInfo.corpusAnomaly eq null? "checked" : ""} value="0">未见异常</label>
                        <label><input type="radio" id="corpusAnomaly" onclick="util.clickShowText(this,'corpusAnomalyDescText')" name="corpusAnomaly" ${postpartumDaysHealthInfo.corpusAnomaly eq"1" ?"checked":""} value="1">异常</label>
                        <span id="corpusAnomalyDescText" CLASS="hidediv"> <input reg='{"maxlength":"33","required":"true"}' type="text" name="corpusAnomalyDesc" value="${postpartumDaysHealthInfo.corpusAnomalyDesc}" style="width: 150px;"></span>
                    </td>
                </tr>
                <tr>
                    <th><label class="required">伤口</label></th>
                    <td colspan="3">
                        <label><input type="radio" name="woundAnomalySign" onclick="util.clickHideText(this,'woundAnomalyDescText')" ${postpartumDaysHealthInfo.woundAnomalySign eq "0" or postpartumDaysHealthInfo.woundAnomalySign eq null? "checked" : ""} value="0">未见异常</label>
                        <label><input type="radio" id="woundAnomalySign" onclick="util.clickShowText(this,'woundAnomalyDescText')" name="woundAnomalySign" ${postpartumDaysHealthInfo.woundAnomalySign eq"1" ?"checked":""} value="1">异常</label>
                        <span id="woundAnomalyDescText" CLASS="hidediv"> <input reg='{"maxlength":"33","required":"true"}' type="text" name="woundAnomalyDesc" value="${postpartumDaysHealthInfo.woundAnomalyDesc}" style="width: 150px;"></span>
                    </td>
                </tr>
                <tr>
                    <th><label>其他</label></th>
                    <td colspan="3">
                        <input style="width:190px;" type="text" id="other" name="other" value="${postpartumDaysHealthInfo.other}" />
                    </td>
                </tr>
                <tr>
                    <th><label class="required">分类</label></th>
                    <td colspan="3">
                        <label><input type="radio" name="classifyFlag" onclick="util.clickHideText(this,'classifyDescText')" ${postpartumDaysHealthInfo.classifyFlag eq "0" or postpartumDaysHealthInfo.classifyFlag eq null? "checked" : ""} value="0">已恢复</label>
                        <label><input type="radio" id="classifyFlag" onclick="util.clickShowText(this,'classifyDescText')" name="classifyFlag" ${postpartumDaysHealthInfo.classifyFlag eq"1" ?"checked":""} value="1">未恢复</label>
                        <span id="classifyDescText" CLASS="hidediv"> <input reg='{"maxlength":"33","required":"true"}' type="text" name="classifyDesc" value="${postpartumDaysHealthInfo.classifyDesc}" style="width: 150px;"></span>
                    </td>
                </tr>
                <tr>
                    <th><label class="required">指导</label></th>
                    <td colspan="3">
                        <input type="hidden" value="${postpartumDaysHealthInfo.healthGuidanceClass}" id="GuidanceText"/>
                        <ehr:dic-checkbox name="healthGuidanceClass" reg='{"required":"true"}' value="${postpartumDaysHealthInfo.healthGuidanceClass}" dicmeta="CV0600219" code="16,17,18,19,99"></ehr:dic-checkbox>
                        <span id="other_Guidance" class="hidediv">
				    	<input type="text" reg='{"maxlength":"100","required":"true"}' name="healthGuidanceDesc" value="${postpartumDaysHealthInfo.healthGuidanceDesc}" style="width: 150px" >
				    </span>
                    </td>
                </tr>
                <tr>
                    <th>中医药健康管理服务</th>
                    <td colspan="3">
                        <ehr:dic-checkbox dicmeta="FS10307" code="6,9,10,8,99" name="cmHealthManage" value="${postpartumDaysHealthInfo.cmHealthManage}"
                                          onchange="toggleOtherCK('cmHealthManage','cmHealthManageDescSpan',99);"/>
                        <span id="cmHealthManageDescSpan">
					   	<input reg='{"required":"true","maxlength":100}' type="text" name="cmHealthManageDesc" value="${postpartumDaysHealthInfo.cmHealthManageDesc}" style="width: 10%"/>
                   </span>
                    </td>
                </tr>
                <tr>
                    <th><label class="required">处理</label></th>
                    <td colspan="3">
                        <label><input type="radio" name="finalMark" onclick="util.clickHideText(this,'referralReasonText')" ${postpartumDaysHealthInfo.finalMark eq "0" ? "checked" : ""} value="0">结案</label>
                        <label><input type="radio" id="referralFlag" onclick="util.clickShowText(this,'referralReasonText')" name="finalMark" ${postpartumDaysHealthInfo.finalMark eq"1" ?"checked":""} value="1">转诊</label>
                        <span id="referralReasonText" CLASS="hidediv">&nbsp;&nbsp;&nbsp;原因:<input reg='{"maxlength":"33","required":"true"}' type="text" name="referralReason" value="${postnatalFollowup.referralReason}" style="width: 200px;">
                        &nbsp;&nbsp;&nbsp;&nbsp;机构及科室:<input reg='{"maxlength":"33","required":"true"}' type="text" name="referralHospitalName" value="${postpartumDaysHealthInfo.referralHospitalName}" style="width: 180px;">
                        <input reg='{"maxlength":"33","required":"true"}' type="text" name="referralDeptName" value="${postpartumDaysHealthInfo.referralDeptName}" style="width: 100px;">
                        </span>
                    </td>
                </tr>
                <tr>
                    <th class="required">随访机构</th>
                    <input type="hidden" id="createOrganName" name="createOrganName" value="${postpartumDaysHealthInfo.createOrganName}"/>
                    <input type="hidden" id="createOrganCode" name="createOrganCode" value="${postpartumDaysHealthInfo.createOrganCode}"/>
                    <td colspan="3">
                        <select style="width:30.4%">
                            <option>${postpartumDaysHealthInfo.createOrganName}</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th><label class="required">随访医生签名</label></th>
                    <td><ehr:staff-list name="supervisionDoctor" value="${postpartumDaysHealthInfo.supervisionDoctor}" defaultval="Y" style="width:75%"/></td>
                    <%--<td><input type="text" id="supervisionDoctor" name="supervisionDoctor" value="${postpartumDaysHealthInfo.supervisionDoctor}" /></td>--%>
                    <th><label class="required">随访日期</label></th>
                    <td>
                    	<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="supervisionDate" id="supervisionDate" 
                            value="<fmt:formatDate value='${postpartumDaysHealthInfo.supervisionDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>