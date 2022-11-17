<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />
<script src="${pageContext.request.contextPath}/js/views/woman/PostpartumVisit/addPostnatalFollowUp.js" type="text/javascript" ></script>
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
            elem: '#nextSupervisionDate'
             ,format: 'yyyy/MM/dd'
             ,trigger: 'click'
          });
        laydate.render({
            elem: '#visitDate'
             ,format: 'yyyy/MM/dd'
             ,trigger: 'click'
          });
      });

    </script>
<%--<div style="background-color: white; height: 515px;" class="posttable">--%>
<div class="toolbar">
	<a href="javascript:void(0)" id="revert"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon"></i>返回</button></a>
    <a href="javascript:void(0);" id="button_save"><button class="layui-btn layui-btn-sm button"><i class="layui-icon"></i>保存</button></a>
</div>
<div class="Contentbox divFixed105" style="text-align: left;top: 65px">
    <form id="addPostnatalForm"  method="post">
    <ul>
        <li style="text-align: center; font-size: 25px;">产后访视记录表</li>
    </ul>
    <br/>
    <div class="postcontent">
        <table  class="posttable">
            <%--<i class="pop_No">
               <a class="bc" id="button_save">保存</a>
            </i>--%>
            <colgroup>
                <col style="width: 15%;"/>
                <col style="width: 35%;"/>
                <col style="width: 15%;"/>
                <col style="width: 35%;"/>
            </colgroup>
            <tr>
                <th><label class="required">姓名</label></th>
                <td><input reg='{"required":true}' type="text" id="name" name="name" value="${postnatalFollowup.name}" /></td>
                <th><label class="required">健康档案编号</label></th>
                <td><input readonly="readonly" reg='{"required":true}' type="text" id="healthFileNo" name="healthFileNo" value="${postnatalFollowup.healthFileNo}" /></td>
                <%--<td><tag:numberInput name="healthFileNo" id="healthFileNo" value="${postnatalFollowup.healthFileNo}"   reg="{'min':0,'required':true}"/></td>--%>
            </tr>
            <tr>
                <th width="15%"><label class=required>身份证号</label></th>
                <td>
                <tag:idcardInput name="idCard" id="idCard"  reg='{"required":"true","idCard":true}' value="${postnatalFollowup.idCard}">
                </tag:idcardInput>
                </td>
                <th width="15%"><label class="required">体温</label></th>
                <td><input type="text" id="temperature" name="temperature" reg='{"required":"true"}' value="${postnatalFollowup.temperature}" />℃</td>
            </tr>
            <tr>
                <th width="15%"><label class="required">一般健康情况</label></th>
                <td><input type="text" id="healthStatus" name="healthStatus" reg='{"required":"true"}' value="${postnatalFollowup.healthStatus}" /></td>
                <th width="15%"><label class="required">一般心理状况</label></th>
                <td><input type="text" id="psychologicalStatus" name="psychologicalStatus" reg='{"required":"true"}' value="${postnatalFollowup.psychologicalStatus}" /></td>
            </tr>
            <tr>
                <th width="15%"><label class="required">血压</label></th>
                <td>
                <tag:numberInput style="width:90px;" name="sbp" value="${postnatalFollowup.sbp}"   reg="{'min':0,'max':9999,'required':true}" id="sbp"/>/
                <tag:numberInput style="width:90px;" name="dbp" value="${postnatalFollowup.dbp}"   reg="{'min':0,'max':9999,'required':true}" id="dbp"/>mmHg
                </td>
                <th width="15%"><lable class="required">随访机构</lable></th>
                <input type="hidden" id="createOrganName" name="createOrganName" value="${postnatalFollowup.createOrganName}"/>
                <input type="hidden" id="createOrganCode" name="createOrganCode" value="${postnatalFollowup.createOrganCode}"/>
                <td>
                    <select>
                        <option>${postnatalFollowup.createOrganName}</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th width="15%"><label class="required">乳房</label></th>
                <td>
                    <label><input type="radio" name="breastAnomalyFlag" onclick="util.clickHideText(this,'breastAnomalyDescText')" ${postnatalFollowup.breastAnomalyFlag eq "0" or postnatalFollowup.breastAnomalyFlag eq null? "checked" : ""} value="0">未见异常</label>
                    <label><input type="radio" id="breastAnomalyFlag" onclick="util.clickShowText(this,'breastAnomalyDescText')" name="breastAnomalyFlag" ${postnatalFollowup.breastAnomalyFlag eq"1" ?"checked":""} value="1">异常</label>
                    <span id="breastAnomalyDescText" CLASS="hidediv"> <input reg='{"maxlength":"33","required":"true"}' type="text" name="breastAnomalyDesc" value="${postnatalFollowup.breastAnomalyDesc}" style="width: 150px;"></span>
                </td>
                <th width="15%" class="required">分娩日期</th>
                <td>
                <input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="deliveryDate" id="deliveryDate" 
                            value="<fmt:formatDate value='${postnatalFollowup.deliveryDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                </td>
            </tr>
            <tr>
                <th width="15%"><label class="required">恶露</label></th>
                <td>
                    <label><input type="radio" name="lochiaAnomalyFlag" onclick="util.clickHideText(this,'lochiaConditionText')" ${postnatalFollowup.lochiaAnomalyFlag eq "0" or postnatalFollowup.lochiaAnomalyFlag eq null? "checked" : ""} value="0">未见异常</label>
                    <label><input type="radio" id="lochiaAnomalyFlag" onclick="util.clickShowText(this,'lochiaConditionText')" name="lochiaAnomalyFlag" ${postnatalFollowup.lochiaAnomalyFlag eq"1" ?"checked":""} value="1">异常</label>
                    <span id="lochiaConditionText" CLASS="hidediv"> <input reg='{"maxlength":"33","required":"true"}' type="text" name="lochiaCondition" value="${postnatalFollowup.lochiaCondition}" style="width: 150px;"></span>
                </td>
                <th width="15%" class="required">出院日期</th>
                <td>
                	<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="leaveHospitalDate" id="leaveHospitalDate" 
                            value="<fmt:formatDate value='${postnatalFollowup.leaveHospitalDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                </td>
            </tr>
            <tr>
                <th><label class="required">子宫</label></th>
                <td colspan="3">
                    <label><input type="radio" name="corpusAnomalyFlag" onclick="util.clickHideText(this,'corpusAnomalyDescText')" ${postnatalFollowup.corpusAnomalyFlag eq "0" or postnatalFollowup.corpusAnomalyFlag eq null? "checked" : ""} value="0">未见异常</label>
                    <label><input type="radio" id="corpusAnomalyFlagEx" onclick="util.clickShowText(this,'corpusAnomalyDescText')" name="corpusAnomalyFlag" ${postnatalFollowup.corpusAnomalyFlag eq"1" ?"checked":""} value="1">异常</label>
                    <span id="corpusAnomalyDescText" CLASS="hidediv"> <input reg='{"maxlength":"33","required":"true"}' type="text" name="corpusAnomalyDesc" value="${postnatalFollowup.corpusAnomalyDesc}" style="width: 150px;"></span>
                </td>
            </tr>
            <tr>
                <th><label class="required">伤口</label></th>
                <td colspan="3">
                    <label><input type="radio" name="woundAnomalyFlag" onclick="util.clickHideText(this,'woundAnomalyDescText')" ${postnatalFollowup.woundAnomalyFlag eq "0" or postnatalFollowup.woundAnomalyFlag eq null? "checked" : ""} value="0">未见异常</label>
                    <label><input type="radio" id="woundAnomalyFlag" onclick="util.clickShowText(this,'woundAnomalyDescText')" name="woundAnomalyFlag" ${postnatalFollowup.woundAnomalyFlag eq"1" ?"checked":""} value="1">异常</label>
                    <span id="woundAnomalyDescText" CLASS="hidediv"> <input reg='{"maxlength":"33","required":"true"}' type="text" name="woundAnomalyDesc" value="${postnatalFollowup.woundAnomalyDesc}" style="width: 150px;"></span>
                </td>
            </tr>
            <tr>
                <th><label>其他</label></th>
                <td colspan="3">
                <input style="width:190px;" type="text" id="other" name="other" value="${postnatalFollowup.other}" />
                </td>
            </tr>
            <tr>
                <th><label class="required">分类</label></th>
                <td colspan="3">
                    <label><input type="radio" name="classifyFlag" onclick="util.clickHideText(this,'classifyDescText')" ${postnatalFollowup.classifyFlag eq "0" or postnatalFollowup.classifyFlag eq null? "checked" : ""} value="0">未见异常</label>
                    <label><input type="radio" id="classifyFlag" onclick="util.clickShowText(this,'classifyDescText')" name="classifyFlag" ${postnatalFollowup.classifyFlag eq"1" ?"checked":""} value="1">异常</label>
                    <span id="classifyDescText" CLASS="hidediv"> <input reg='{"maxlength":"33","required":"true"}' type="text" name="classifyDesc" value="${postnatalFollowup.classifyDesc}" style="width: 150px;"></span>
                </td>
            </tr>
            <tr>
                <th><label class="required">指导</label></th>
                <td colspan="3">
                    <input type="hidden" value="${postnatalFollowup.healthGuidanceClass}" id="GuidanceText"/>
                    <ehr:dic-checkbox name="healthGuidanceClass" reg='{"required":"true"}' value="${postnatalFollowup.healthGuidanceClass}" dicmeta="CV0600219" code="01,02,03,09,10,99"></ehr:dic-checkbox>
                    <span id="other_Guidance" class="hidediv">
				    	<input type="text" reg='{"maxlength":"100","required":"true"}' name="otherHealthGuidanceDesc" value="${postnatalFollowup.otherHealthGuidanceDesc}" style="width: 150px" >
				    </span>
                </td>
            </tr>
            <tr>
                <th><label class="required">转诊</label></th>
                <td colspan="3">
                <label><input type="radio" name="referralFlag" onclick="util.clickHideText(this,'referralReason')" ${postnatalFollowup.referralFlag eq "0" or postnatalFollowup.referralFlag eq null? "checked" : ""} value="0">无</label>
                <label><input type="radio" id="referralFlag" onclick="util.clickShowText(this,'referralReason')" name="referralFlag" ${postnatalFollowup.referralFlag eq"1" ?"checked":""} value="1">有</label>
                <span id="referralReason" CLASS="hidediv"> &nbsp;&nbsp;&nbsp;&nbsp;机构及科室:<input reg='{"maxlength":"33","required":"true"}' type="text" name="referralHospitalName" value="${postnatalFollowup.referralHospitalName}" style="width: 180px;">
                    <input reg='{"maxlength":"33","required":"true"}' type="text" name="referralDeptName" value="${postnatalFollowup.referralDeptName}" style="width: 100px;">
                    &nbsp;&nbsp;&nbsp;转诊原因:<input reg='{"maxlength":"33","required":"true"}' type="text" name="referralReason" value="${postnatalFollowup.referralReason}" style="width: 200px;">
                </span>
                </td>
            <tr>
                <th><label>中医药健康管理服务</label></th>
                <td colspan="3">
                <input type="hidden" value="${postnatalFollowup.cmediciManageFlag}" id="ManageFlag"/>
                <ehr:dic-checkbox name="cmediciManageFlag" value="${postnatalFollowup.cmediciManageFlag}" dicmeta="FS10307" code="6,9,10,8,99"></ehr:dic-checkbox>
                <span id="other_CMediciManage" class="hidediv">
				    <input type="text" reg='{"maxlength":"100","required":"true"}' name="otherCmediciManage" value="${postnatalFollowup.otherCmediciManage}" style="width: 150px" >
				 </span>
                 </td>
            </tr>
            <tr>
                <th><label class="required">随访医师签名</label></th>
                <%--<td><input type="text" id="supervisionDoctor" name="supervisionDoctor" value="${postnatalFollowup.supervisionDoctor}" /></td>--%>
                <td><ehr:staff-list name="supervisionDoctor" value="${postnatalFollowup.supervisionDoctor}" defaultval="Y" style="width:75%"/></td>
                <th><label class="required">产妇签字</label></th>
                <td>
                <input type="text" reg="{'required':true,'maxlength':20}" id="Maternalname"/>
                </td>
            </tr>
            <tr>
                <th><label class="required">随访日期</label></th>
                <td>
                    <input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="visitDate" id="visitDate" 
                            value="<fmt:formatDate value='${postnatalFollowup.visitDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                </td>
                <th><label class="required">下次随访日期</label></th>
                <td>
                	<input type="text" reg='{"required":"true"}'  class="layui-input x-admin-content-sm-date"  name="nextSupervisionDate" id="nextSupervisionDate" 
                            value="<fmt:formatDate value='${postnatalFollowup.nextSupervisionDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                </td>
            </tr>
        </table>
    </div>
    </form>
</div>
