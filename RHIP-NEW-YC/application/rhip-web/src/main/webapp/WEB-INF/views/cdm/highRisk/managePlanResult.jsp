<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/loadStageMenu.js" type="text/javascript"></script>

 <fieldset  style="margin:-5px 5px 5px 1px;float:right;width:47%;height:320px;" class="layui-elem-field">
 <legend>计划制定</legend>	
 	<input type="hidden" id="deleFollowUpPlan" value="${followUpPlan}">  
	<table class="posttable">
		<colgroup>
			<col style="width:35px;"/>
			<col style="width:100px;"/>
		</colgroup>
	    <tr style="display:none">
			<th>计划id</th>
			<td><input type="text" id="id" name="id" value="${managePlanDelInfo.id}"></td>
			<td><input type="text" id="riskLevel" value="${riskLevel}"></td>
		</tr>
		<tr>
			<c:choose>
				<c:when test="${empty managePlanDelInfo.id}">
					<th><label class="required" for="year">年度</label></th>
					<td class="colinput">
						<%-- <input  reg='{"required":"true"}' type="text" id="year" readonly="true" name="year" value="${managePlanDelInfo.year}"
								onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy',minDate:'${startYear}',maxDate:'${endYear}'})"
								onchange="loadStageMenu.managePlan(this.value)"/> --%>
								<input type="text" class="layui-input x-admin-content-sm-date" reg='{"required":"true"}' placeholder="选择年度" name="year" id="year" value="${managePlanDelInfo.year}" onchange="loadStageMenu.managePlan(this.value)" 
								style="padding-left: 0px;" />
								年
					</td>
				</c:when>
				<c:otherwise>
					<th><label class="required" for="year">年度</label></th>
					<td class="colinput"><input readonly="readonly" name = "year"  value="${managePlanDelInfo.year}"/>年</td>
				</c:otherwise>
			</c:choose>	
		</tr>
		<tr>
			<th>体重指数(BMI)</th>
			<td><tag:numberInput reg="{'min':'0','max':'99.99'}" point="point" id="bodyMassIndex" name="bodyMassIndex" value="${managePlanDelInfo.bodyMassIndex}"/></td>
		</tr>
		<tr>
			<th>腰围</th>
		<td><tag:numberInput reg="{'min':'0','max':'9999.9'}" point="point" id="waostline" name="waostline" value="${managePlanDelInfo.waostline}"/>cm</td>
		</tr>
		<tr>
			<th>运动</th>
			<td><tag:numberInput reg="{'min':'0','max':'999'}" id="weeklyTrain" name="weeklyTrain" value="${managePlanDelInfo.weeklyTrain}"/>次/每周</td>
		</tr>
		<tr>
			<th>吸烟</th>
			<td><tag:numberInput reg="{'min':'0','max':'9999'}" id="dailySmoke" name="dailySmoke" value="${managePlanDelInfo.dailySmoke}"/>支/每日</td>
		</tr>
		<tr>
			<th>饮酒</th>
			<td><tag:numberInput reg="{'min':'0','max':'9999'}" id="weeklyDrinnk" name="weeklyDrinnk" value="${managePlanDelInfo.weeklyDrinnk}"/>两/每周</td>
		</tr>
		<tr>
			<th>每天吃鱼肉</th>
			<td><tag:numberInput reg="{'min':'0','max':'9999'}" id="dailyFish" name="dailyFish" value="${managePlanDelInfo.dailyFish}"/>两</td>
		</tr>
		<tr>
			<th>总胆固醇</th>
			<td><tag:numberInput reg='{"min":0,"max":999.99}' point="point" id="tc" name="tc" value="${managePlanDelInfo.tc}"/>mmol/L</td>
		</tr>
		<tr>
			<th>甘油三酯</th>
			<td><tag:numberInput reg='{"min":0,"max":99.9}' point="point" id="triglycerideValue" name="triglycerideValue" value="${managePlanDelInfo.triglycerideValue}"/>mmol/L</td>
		</tr>				 
		<tr>
			<th><label class="required" for="createDoctorName">制定人</label></th>
			<td>
				  <input type="text"  readonly="readonly" value='<ehr:user userCode="${managePlanDelInfo.createDoctorCode}"/>' />
                  <input reg='{"required":"true"}' readonly="readonly" type="hidden" id="createDoctorCode" name="createDoctorCode" value="${managePlanDelInfo.createDoctorCode}">
			</td>
		</tr>
		<tr>
			<c:choose>
				<c:when test="${empty managePlanDelInfo.id}">
					<th><label class="required" for="createDate">制定日期</label></th>
					<td>
					<%-- <tag:dateInput name="createDate"  id="createDate" onlypast="true" date="${managePlanDelInfo.createDate}" reg='{"required":"true","compare":["nextVisitDate","le","制定日期不能大于随访日期"]}'/> --%>
					<input type="text" class="layui-input x-admin-content-sm-date"  placeholder="选择年度" name="createDate" id="createDate" value="${managePlanDelInfo.year}" reg='{"required":"true","compare":["nextVisitDate","le","制定日期不能大于随访日期"]}' 
								style="padding-left: 0px;" />
					</td>
				</c:when>
				<c:otherwise>
					<th><label class="required" for="createDate">制定日期</label></th>
					<td>
					<input readonly="readonly" name="createDate"  value="<fmt:formatDate value='${managePlanDelInfo.createDate}' pattern='yyyy/MM/dd'/>">
					</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th><label class="required" for="createDate">随访日期</label></th>
			<td>
			<%-- <tag:dateInput onlyfuture="true" name="nextVisitDate"  id="nextVisitDate" date="${managePlanDelInfo.nextVisitDate}" reg='{"required":"true","compare":["createDate","ge","随访日期不能小于制定日期"]}'/> --%>
			<input type="text" class="layui-input x-admin-content-sm-date"  placeholder="选择日期" name="nextVisitDate" id="nextVisitDate" value="<fmt:formatDate value="${managePlanDelInfo.nextVisitDate}" pattern="yyyy/MM/dd"/>" reg='{"required":"true","compare":["createDate","ge","随访日期不能小于制定日期"]}' 
								style="padding-left: 0px;" />
			</td>
		</tr>			
	</table>
</fieldset>
 <script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;
        
        //执行一个laydate实例
        laydate.render({
          elem: '#year' 
       	   ,type: 'year'
       	   ,min:0
       	   ,max:365
        });

        laydate.render({
            elem: '#createDate' 
         	   ,format: 'yyyy/MM/dd'
         	   ,max:0
          });
        
        laydate.render({
            elem: '#nextVisitDate' 
         	   ,format: 'yyyy/MM/dd'
         	   ,max:0
          });
      });

    </script>