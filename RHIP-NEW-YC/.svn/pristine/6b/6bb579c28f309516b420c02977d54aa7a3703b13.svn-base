<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.jqprint.js"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:fgrestdrugreg.returnExport()"><b class="fanhui">返回</b></a>
	<a href="javascript:void(0)" onclick="javascript:fgrestdrugreg.printFg()"><b class="dayin">打印</b></a>
</div>

<div  id="printPage"  class="postcontent">
    <i class="popno">重点人群休止期督导服药登记表 </i>
    <div class="postdiv">
    	<fieldset>
    		<legend>患者信息</legend>
	<table class="posttable">
                <colgroup>
                    <col style="min-width: 80px; width: 10%;"/>
                    <col style="min-width: 120px; width: 20%;"/>
                    <col style="min-width: 80px; width: 10%;"/>
                    <col style="min-width: 120px; width: 60%;"/>
                </colgroup>
                <tbody>
          		<tr>
                 	<th>患者姓名:</th>
                 	<td>${malariaDto.listFg.patientName}</td>
                 	<th>患者身份证:</th>
                 	<td>${malariaDto.listFg.patientIdcard}</td>	                    	
                 </tr>
               	</tbody>
        	</table>        		
    	</fieldset>
    	<fieldset>
    		<legend>人群信息</legend>
            <table class="posttable">
                <colgroup>
                    <col style="min-width: 80px; width: 10%;"/>
                    <col style="min-width: 120px; width: 20%;"/>
                    <col style="min-width: 80px; width: 10%;"/>
                    <col style="min-width: 120px; width: 20%;"/>
                    <col style="min-width: 80px; width: 10%;"/>
                    <col style="min-width: 120px; width: 20%;"/>
                </colgroup>
                <tbody>
                <tr>
                    <th>姓名:</th>
                    <td>${malariaDto.listFg.name}</td>
                    <th>家长姓名:</th>
                    <td>${malariaDto.listFg.parentsName}</td>                        
                    <th>性别:</th>
                    <td><ehr:dic dicmeta="GBT226112003" code="${malariaDto.listFg.gender}"/></td>
                 </tr>
                <tr>
                    <th>年龄:</th>
                    <td>${malariaDto.listFg.age}</td>
                    <th>体重:</th>
                    <td>${malariaDto.listFg.weight}&nbsp;Kg</td>
                    <td></td>
                    <td></td>                        
                </tr>
     		<tr>
          	<th>详细住址:</th>
           <td colspan="3">
                 	<ehr:dic dicmeta="FS990001" code="${malariaDto.listFg.patownShip}"></ehr:dic>
                 	<ehr:dic dicmeta="FS990001" code="${malariaDto.listFg.pastreet}"></ehr:dic>
                 	<c:out value="${malariaDto.listFg.pahomeNumber}"></c:out><span>(门牌号)</span>
        </td>
                    <th>联系电话:</th>
                    <td>${malariaDto.listFg.phoneNumber}</td>  				        
    	</tr>                    
                 <tr>
                    <th>休治对象:</th>
                    <td colspan="3">
	 			<ehr:dic dicmeta="IDM00272"	code="${malariaDto.listFg.restObject}"/>                       
        </td>                        		
                </tr>
                <tr>
                    <th>督导服药人:</th>
                    <td colspan="3">${malariaDto.listFg.dutyDoctor}</td>                        
                    <th>服药是否规范:</th>
                    <td><ehr:dic dicmeta="PH00001" code="${malariaDto.listFg.drugNorm}"/></td>  
                </tr>                    
                </tbody>
            </table>
        </fieldset>
        <fieldset>
        	<legend>督导服药</legend>
             <div>
            	<span>是否为应服对象:</span>
					<ehr:dic dicmeta="PH00001" code="${malariaDto.listFg.drugObject}"/>
				<c:if test="${malariaDto.listFg.drugObject == '99'}">
	                <span>&nbsp;&nbsp;&nbsp;(如否请注明原因:
	                    	<ehr:dic dicmeta="IDM00270" code="${malariaDto.listFg.noObjectResult}"/>
	                     <span>${malariaDto.listFg.noObjectOther}</span>)
	                </span>	
                </c:if>                
            </div>
            <br>
	<div id ="childDiv" class="repeattable">
		<table>
			<colgroup>
				<col style="width:15%;"/>
				<col style="width:20%;"/>
				<col style="width:5%;"/>
				<col style="width:5%;"/>
				<col style="width:5%;"/>
				<col style="width:5%;"/>
				<col style="width:5%;"/>
				<col style="width:5%;"/>																																			
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
				<c:forEach var="drugreg" items="${fgrestdrugregs}" varStatus="status">
					<tr>
						<td><fmt:formatDate value="${drugreg.drugDt}" pattern="yyyy/MM/dd" /></td>
						<td>${drugreg.drugName}</td>
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
						<td>${drugreg.patientName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<div>
	        <span>未全程规范服药原因:</span>
		 	<ehr:dic dicmeta="IDM00271" code="${malariaDto.listFg.noWholeResult}"/>
		 	<c:if test="${malariaDto.listFg.noWholeResult == '99'}">
	 			<span>${malariaDto.listFg.noWholeOther}&nbsp;(请注明)</span>
	 		</c:if>
		</div>					
	</div> 
    <br>
    <table class="posttable">
        <colgroup>
            <col style="min-width: 80px; width: 10%;"/>
            <col style="min-width: 120px; width: 20%;"/>
            <col style="min-width: 80px; width: 10%;"/>
            <col style="min-width: 120px; width: 20%;"/>
            <col style="min-width: 80px; width: 10%;"/>
            <col style="min-width: 120px; width: 20%;"/>                        	                        
        </colgroup>                                                        
         <tr>
             <th>休止期督导服药人:</th>
             <td><ehr:user userCode="${malariaDto.listFg.restDutyDoctor}"/></td>
             <th>上报单位:</th>
             <td><ehr:org code="${malariaDto.listFg.reportOrg}"/></td>
             <th>上报日期:</th>
             <td><fmt:formatDate value="${malariaDto.listFg.reportDate}" pattern="yyyy/MM/dd" /></td>		                        
         </tr>		                                        
        </tbody>
    </table>					               
    </fieldset>
    </div>
</div>
