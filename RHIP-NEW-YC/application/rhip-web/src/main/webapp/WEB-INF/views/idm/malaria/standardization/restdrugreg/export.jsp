<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.jqprint.js"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:restdrugreg.returnExport()"><b class="fanhui">返回</b></a>
    <a href="javascript:void(0)" onclick="javascript:restdrugreg.printDrugreg()"><b class="dayin">打印</b></a>
</div>
<div id="printPage" >
    <div class="postcontent">
    <i class="popno">间日疟休止期根治督导服药登记表 </i>
    <div class="postdiv">
    	<fieldset>
    		<legend>一、服药对象基本信息</legend>
            <table class="posttable">
                <colgroup>
                    <col style="min-width: 120px; width: 16%;"/>
                    <col style="min-width: 120px; width: 20%;"/>
                    <col style="min-width: 120px; width: 20%;"/>
                    <col style="min-width: 120px; width: 20%;"/>
                    <col style="min-width: 120px; width: 12%;"/>
                    <col style="min-width: 120px; width: 12%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <td>1.服药对象</td>
                </tr>
                <tr>
                    <th>
                        姓名：
                    </th>
                    <td>
                        ${malariaDto.generalCondition.name}
                    </td>
                    <th>
                        家长姓名：
                    </th>
                    <td>
                        ${malariaDto.generalCondition.parentsName}
                    </td>
                    <th>
                        性别：
                    </th>
                    <td>
                        <ehr:dic  dicmeta="GBT226112003" code="${malariaDto.generalCondition.gender}" />
                    </td>
                </tr>
                <tr>
                    <th>
                        年龄：
                    </th>
                    <td>
                        ${malariaDto.generalCondition.age}
                    </td>
                    <td></td>
                    <td></td>
                    <th>
                        体重：
                    </th>
                    <td>
                        ${malariaDto.clinicalManifestations.weight}&nbsp;Kg
                    </td>
                </tr>
                <tr>
                    <th>

                    </th>
                    <td>

                    </td>
                </tr>
                <tr>
                    <th>

                    </th>
                    <td>

                    </td>
                </tr>
                <tr>
                    <th>详细住址</th>
                    <td colspan="5">
                    	<ehr:dic dicmeta="FS990001" code="${malariaDto.generalCondition.patownShip}"></ehr:dic>
                    	<ehr:dic dicmeta="FS990001" code="${malariaDto.generalCondition.pastreet}"></ehr:dic>
                    	<c:out value="${malariaDto.generalCondition.pahouseNumber}"></c:out>
		            </td>
                </tr>
	            <tr>
       	            <td>2.发病情况:</td>
                </tr>
                <tr>
                    <th>
                        发病日期：
                    </th>
                    <td>
                        <fmt:formatDate value="${malariaDto.attackCondition.pathogenesisDate}" pattern="yyyy/MM/dd" />
                    </td>
                    <th>
                        诊断日期：
                    </th>
                    <td>
                        <fmt:formatDate value="${malariaDto.diagnosis.diagnosisDt}" pattern="yyyy/MM/dd" />
                    </td>
                </tr>
                <tr>
                    <th>
                        联系电话：
                    </th>
                    <td>
                        ${malariaDto.generalCondition.phoneNumber}
                    </td>
                    <th>
                        诊断单位：
                    </th>
                    <td colspan="3">
                        <ehr:org code="${malariaDto.diagnosis.diagnosisUnit}"/>
                    </td>
                </tr>
                <tr>
                    <td>3.治疗情况:</td>
                </tr>
                <tr>
                    <th>治疗日期：</th>
                    <td><fmt:formatDate value="${malariaDto.otherCondition.thisDt}" pattern="yyyy/MM/dd" /></td>
                    <th>治疗方法：</th>
                    <td>${malariaDto.otherCondition.treatMethod}</td>
                </tr>
                <tr>
                    <th>督导服药人：</th>
                    <td>${malariaDto.otherCondition.supervisorUser}</td>
                    <th>服药是否规范化：</th>
                    <td><ehr:dic dicmeta="PH00001" code="${malariaDto.otherCondition.drugNorm}" /></td>
                </tr>
                </tbody>
            </table>
        </fieldset>
        <br>
        <fieldset class="topfield">
        	<legend>二、督导服药</legend>
             <div>
            	<span>是否为应服对象</span>
				<span><ehr:dic dicmeta="PH00001" code="${malariaDto.otherCondition.drugObject}"/></span>
				<br>
				<c:if test="${malariaDto.otherCondition.drugObject == '99'}">
	                <span>
	                    	(如否请注明原因:
	                    	<ehr:dic dicmeta="IDM00270" code="${malariaDto.otherCondition.noObjectResult}"/>
	                </span>	  
	                <span>${malariaDto.otherCondition.noObjectOther})</span> 
                </c:if>             
            </div>
            <br>
<div id ="childDiv" class="repeattable">
	<table>
		<colgroup>
			<col style="width:15%;"/>
			<col style="width:23%;"/>
			<col style="width:7%;"/>
			<col style="width:7%;"/>
			<col style="width:7%;"/>
			<col style="width:7%;"/>
			<col style="width:7%;"/>
			<col style="width:7%;"/>																																			
			<col style="width:20%;"/>
		</colgroup>	
		<thead>
			<tr>
		        <th class="centerth" rowspan="2">服药日期</th>
		        <th class="centerth" rowspan="2">药物(片)</th>
		        <th class="centerth" colspan="6">年龄(周岁)</th>
		        <th class="centerth" rowspan="2">患者签名</th>
			</tr>
			<tr>
		        <th class="centerth">1-(&frac12;)</th>
		        <th class="centerth">4-(1)</th>
		        <th class="centerth">7-(1&frac12;)</th>
		        <th class="centerth">10-(2)</th>
		        <th class="centerth">13-(2&frac12;)</th>	
		        <th class="centerth">16-(3)</th>						                
			</tr>							
		</thead>
		<tbody>
			<c:forEach var="drugreg" items="${restdrugregs}" varStatus="status">
				<tr>
					<td><ehr:tip><fmt:formatDate value="${drugreg.drugDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
					<td><ehr:tip>${drugreg.drugName}</ehr:tip></td>
					<td style="text-align:center;">
						<c:if test="${drugreg.ageDose == '1'}">√</c:if>
					</td>
					<td style="text-align:center;">
						<c:if test="${drugreg.ageDose == '2'}">√</c:if>					
					</td>
					<td style="text-align:center;">
						<c:if test="${drugreg.ageDose == '3'}">√</c:if>
					</td>
					<td style="text-align:center;">
						<c:if test="${drugreg.ageDose == '4'}">√</c:if>
					</td>	
					<td style="text-align:center;">
						<c:if test="${drugreg.ageDose == '5'}">√</c:if>
					</td>
					<td style="text-align:center;">
						<c:if test="${drugreg.ageDose == '6'}">√</c:if>
					</td>																										
					<td><ehr:tip>${drugreg.patientName}</ehr:tip></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<div>
          	<span>未全程规范服药原因:</span>
          	<span><ehr:dic dicmeta="IDM00271" code="${malariaDto.otherCondition.noWholeResult}"/></span>
          	<c:if test="${malariaDto.otherCondition.noWholeResult == '99'}">
	 			<span>${malariaDto.otherCondition.noWholeOther}&nbsp;(请注明)</span>
	 		</c:if>
	</div>					
</div> 
            <br>
            <table class="posttable">
                <colgroup>
                    <col style="min-width: 120px; width: 20%;"/>
                    <col style="min-width: 120px; width: 18%;"/>
                    <col style="min-width: 120px; width: 12%;"/>
                    <col style="min-width: 120px; width: 20%;"/>
                    <col style="min-width: 120px; width: 12%;"/>
                    <col style="min-width: 120px; width: 18%;"/>
                </colgroup>                                                        
                 <tr>
                     <th>休止期督导服药人:</th>
                     <td><ehr:user userCode="${malariaDto.caseInformation.dutyDoctor}"/></td>
                     <th>上报单位:</th>
                     <td><ehr:org code="${malariaDto.caseInformation.reportOrg}"/></td>
                     <th>上报日期:</th>
                     <td><fmt:formatDate value="${malariaDto.caseInformation.reportDate}" pattern="yyyy/MM/dd" /></td>		                        
                 </tr>		                                        
                </tbody>
            </table>					               
        </fieldset>
    </div>
    </div>
</div>

