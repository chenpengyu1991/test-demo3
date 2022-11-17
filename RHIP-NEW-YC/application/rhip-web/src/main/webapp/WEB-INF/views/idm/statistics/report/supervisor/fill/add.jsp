<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/idm//statistics/report/supervisor/fill/edit.js" type="text/javascript"></script>
<div class="toolbar">
	<c:if test="${type !='add'}">
    	<a href="javascript:void(0)" onclick="javascript:fillEdit.returnSearch()"><b class="fanhui">返回</b></a>
    </c:if>
    <c:if test="${type !='view'}">
   		<a href="javascript:void(0)" onclick="javascript:fillEdit.fillSubmit()"><b class="tijiao">提交</b></a>
   	</c:if>
</div>

<form id="fillSupervisorForm">
	<input type="hidden" id="type" value="${type}"/>
	<input type="hidden" id="pageIndex" name="pageIndex" value="${pageIndex}">
	<input type="hidden" name="id" value="${supervisor.id}"/>

    <input type="hidden"  id="reportUnitCodeId" name="reportUnitCode" value="${supervisor.reportUnitCode}"/>	
    <input type="hidden"  name="reportUserCode" value="${supervisor.reportUserCode}"/>
    <input type="hidden"  id="reportMonthFlag" />
    <input type="hidden"  name="modifyUnitCode" value="${supervisor.modifyUnitCode}"/>	
    <input type="hidden"  name="modifyUserCode" value="${supervisor.modifyUserCode}"/>	
    <input type="hidden"  name="modifyDate" value="<fmt:formatDate pattern="yyyy/MM/dd" value="${supervisor.modifyDate}"/>"/>  
    
    <input type="hidden"  id="reportMonthOldId" name="reportMonthOldId" value="<fmt:formatDate pattern="yyyy/MM" value="${supervisor.reportMonth}"/>"/>	  
    <div class="postcontent">
        <i class="popno">江苏省传染病管理及督导</i>
		<table class="posttable">
		    <tr style="text-align: right;">
		        <td>
		        	<label class="required">填报月份：</label>
					<tag:dateInput nullToToday="true" id="reportMonthId" name="reportMonth" onlypast="true" reg='{"required":"true"}'
			        	pattern="yyyy/MM" date="${supervisor.reportMonth}"  style="width:120px"/>
		        </td>
		        <td>
		        	<label class="required">填报日期：</label>
					<tag:dateInput nullToToday="true" id="reportDateId" name="reportDate" onlypast="true" reg='{"required":"true"}'
			        	pattern="yyyy/MM/dd" date="${supervisor.reportDate}" style="width:120px"/>
		        </td>		        
		    </tr>
		</table>        
        <div class="postdiv">
        	<fieldset>
        		<legend>传染病零缺报县督导情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 100px; width: 40%;"/>
                        <col style="min-width: 180px; width: 60%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                        <th>上月是否零缺报：</th>
                        <td>
                        	<ehr:dic-radio name="lastMonthMiss" dicmeta="PH00001" value="${supervisor.lastMonthMiss}"   code="1,2"/>
                        </td>
                    </tr>
                    <tr>
                       <th>是否开展督导：</th>
                        <td>
                        	<span>&nbsp;&nbsp;省级&nbsp;&nbsp;</span>
                        	<ehr:dic-radio name="supervisorProvince" dicmeta="PH00001" value="${supervisor.supervisorProvince}"   code="1,2"/>
                        	<span>&nbsp;&nbsp;市级&nbsp;&nbsp;</span>
                        	<ehr:dic-radio name="supervisorCity" dicmeta="PH00001" value="${supervisor.supervisorCity}"   code="1,2"/>                        	
                        </td>                     
                    </tr>
                    <tr>
                        <th>本级上月零缺报网络直报点数：</th>
                        <td>
                        	<input type="text" id="zeroDefectOrgNumId" name="zeroDefectOrgNum" value="${supervisor.zeroDefectOrgNum}" 
                        		style="width: 100px;" reg='{"digits":"true","max":999999}'/>
                        </td>
                    </tr> 
                    <tr>
                        <th>本级县以上医疗机构零缺报单位数：</th>
                        <td>
                        	<input type="text" id="zeroDefectMedicalNumId" name="zeroDefectMedicalNum" value="${supervisor.zeroDefectMedicalNum}" 
                        		style="width: 100px;" reg='{"digits":"true","max":999999}'/>
                        </td>
                    </tr>                                          
                    <tr>
                       <th>督导网络直报点数：</th>
                        <td>
                        	<span>&nbsp;&nbsp;省级&nbsp;&nbsp;</span>
                        	<input type="text" id="directNumProvinceId" name="directNumProvince" value="${supervisor.directNumProvince}" 
                        		style="width: 100px;" reg='{"digits":"true","max":999999}'/>
                        	<span>&nbsp;&nbsp;市级&nbsp;&nbsp;</span>
                        	<input type="text" id="directNumCityId" name="directNumCity" value="${supervisor.directNumCity}" 
                        		style="width: 100px;" reg='{"digits":"true","max":999999}'/> 
                        	<span>&nbsp;&nbsp;县级&nbsp;&nbsp;</span>
                        	<input type="text" id="directNumCounty Id" name="directNumCounty" value="${supervisor.directNumCounty}" 
                        		style="width: 100px;" reg='{"digits":"true","max":999999}'/>                        	
                        </td>                     
                    </tr>  
                    <tr>
                        <th>督导应报传染病数：</th>
                        <td>
                        	<input type="text" id="supervisorNumId" name="supervisorNum" value="${supervisor.supervisorNum}" 
                        		style="width: 100px;" reg='{"digits":"true","max":999999}'/>
                        </td>
                    </tr> 
                    <tr>
                        <th>传染病漏报数：</th>
                        <td>
                        	<input type="text" id="supervisorMissNumId" name="supervisorMissNum" value="${supervisor.supervisorMissNum}" 
                        		style="width: 100px;" reg='{"digits":"true","max":999999}'/>
                        </td>
                    </tr> 
                    <tr>
                        <th>漏报率(%)：</th>
                        <td>
                        	<input type="text" id="supervisorMissRateId" name="supervisorMissRate" value="${supervisor.supervisorMissRate}" 
                        		style="width: 100px;" reg='{"number":"true","max":100}'/>
                        	<span>&nbsp;&nbsp;%</span>
                        </td>
                    </tr>                                                                             
                    </tbody>
                </table>
            </fieldset>
        	<fieldset>
        		<legend>网络直报及漏报调查情况</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 100px; width: 40%;"/>
                        <col style="min-width: 180px; width: 60%;"/>
                    </colgroup>
                    <tbody>
                    <tr>
                       <th>督导或调查点数：</th>
                        <td>
                        	<span>&nbsp;&nbsp;市级&nbsp;&nbsp;</span>
                        	<input type="text" id="networkNumCityId" name="networkNumCity" value="${supervisor.networkNumCity}" 
                        		style="width: 100px;" reg='{"digits":"true","max":999999}'/>
                        	<span>&nbsp;&nbsp;县级&nbsp;&nbsp;</span>
                        	<input type="text" id="networkNumCountyId" name="networkNumCounty" value="${supervisor.networkNumCounty}" 
                        		style="width: 100px;" reg='{"digits":"true","max":999999}'/>                        	
                        </td>                     
                    </tr>                    
                    <tr>
                       <th>是否开展传染病漏报专项检查：</th>
                        <td>
                        	<span>&nbsp;&nbsp;市级&nbsp;&nbsp;</span>
                        	<ehr:dic-radio name="surveyFlagCity" dicmeta="PH00001" value="${supervisor.surveyFlagCity}"   code="1,2"/>
                        	<span>&nbsp;&nbsp;县级&nbsp;&nbsp;</span>
                        	<ehr:dic-radio name="surveyFlagCounty" dicmeta="PH00001" value="${supervisor.surveyFlagCounty}"   code="1,2"/>                        	
                        </td>                     
                    </tr>
                    <tr>
                        <th>应报传染病数：</th>
                        <td>
                        	<input type="text" id="networkNumId" name="networkNum" value="${supervisor.networkNum}" 
                        		style="width: 100px;" reg='{"digits":"true","max":999999}'/>
                        </td>
                    </tr> 
                    <tr>
                        <th>传染病漏报数：</th>
                        <td>
                        	<input type="text" id="networkMissNumId" name="networkMissNum" value="${supervisor.networkMissNum}" 
                        		style="width: 100px;" reg='{"digits":"true","max":999999}'/>
                        </td>
                    </tr> 
                    <tr>
                        <th>漏报率(%)：</th>
                        <td>
                        	<input type="text" id="networkMissRateId" name="networkMissRate" value="${supervisor.networkMissRate}" 
                        		style="width: 100px;" reg='{"number":"true","max":100}'/>
                        	<span>&nbsp;&nbsp;%</span>
                        </td>
                    </tr>                                                                             
                    </tbody>
                </table>
            </fieldset>
			<table class="posttable">
			    <tr style="text-align: right;">
			        <td>
			        	填报人：<ehr:user userCode="${supervisor.modifyUserCode}"/>
			        </td>
			    </tr>
			</table> 
        </div>
    </div>
</form>
