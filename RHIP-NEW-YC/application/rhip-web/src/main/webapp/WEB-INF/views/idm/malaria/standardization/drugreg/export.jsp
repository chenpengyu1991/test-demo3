<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.jqprint.js"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:drugreg.returnExport()"><b class="fanhui">返回</b></a>
	<a href="javascript:void(0)" onclick="javascript:drugreg.printDrugreg()"><b class="dayin">打印</b></a>
</div>
    <div id="printPage"  class="postcontent">
        <i class="popno">疟疾病例治疗督导服药登记表 </i>
        <div class="postdiv">
        	<fieldset>
        		<legend>一般情况</legend>
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
                        <td>${malariaDto.generalCondition.name}</td>
                        <th>家长姓名:</th>
                        <td>${malariaDto.generalCondition.parentsName}</td>                        
                        <th>性别:</th>
                        <td><ehr:dic dicmeta="GBT226112003" code="${malariaDto.generalCondition.gender}"/></td>
                     </tr>
                    <tr>
                        <th>年龄:</th>
                        <td>${malariaDto.generalCondition.age}</td>
                        <th>体重:</th>
                        <td>${malariaDto.clinicalManifestations.weight}</td>
                        <td></td>
                        <td></td>                        
                    </tr>
					<tr>
				       	<th>常住类型:</th>
				       	<td colspan="5"><ehr:dic dicmeta="FS10005" code="${malariaDto.generalCondition.floatPopulation}"/></td>
		       		</tr>
	        		<tr>
		            	<th>详细住址:</th>
			            <td colspan="3">
		                 	<ehr:dic dicmeta="FS990001" code="${malariaDto.generalCondition.patownShip}"></ehr:dic>
		                 	<ehr:dic dicmeta="FS990001" code="${malariaDto.generalCondition.pastreet}"></ehr:dic>
		                 	<c:out value="${malariaDto.generalCondition.pahouseNumber}"></c:out><span>(门牌号)</span>			            
				        </td>
                        <th>联系电话:</th>
                        <td>${malariaDto.generalCondition.phoneNumber}</td>  				        
			     	</tr>                    
                    <tr>
                        <th>发病日期:</th>
                        <td>
                        	<fmt:formatDate value="${malariaDto.attackCondition.pathogenesisDate}" pattern="yyyy/MM/dd" />
                        </td>
                        <th>首诊日期:</th>
                        <td>
                        	<fmt:formatDate value="${malariaDto.attackCondition.firstVisitDate}" pattern="yyyy/MM/dd" />
                       </td>
                        <th>诊断日期:</th>
                        <td>
                        	<fmt:formatDate value="${malariaDto.diagnosis.diagnosisDt}" pattern="yyyy/MM/dd" />
                        </td>                                                
                    </tr>
                    <tr>
                        <th>治疗日期:</th>
                        <td>
                        	<fmt:formatDate value="${malariaDto.otherCondition.thisDt}" pattern="yyyy/MM/dd" />
                         <th>治疗方法:</th>
                        <td colspan="3">${malariaDto.otherCondition.treatMethod}</td>                        		
                    </tr>
                    <tr>
                        <th>督导服药人:</th>
                        <td>${malariaDto.otherCondition.supervisorUser}</td>                        
                        <th>服药是否规范:</th>
                        <td><ehr:dic dicmeta="PH00001" code="${malariaDto.otherCondition.drugNorm}"/></td>  
                        <td></td>
                        <td></td>                       		
                    </tr>                    
                    <tr>
                        <th>诊断单位:</th>
                        <td colspan="3">
                        	 <ehr:org code="${malariaDto.diagnosis.diagnosisUnit}"/>
                        </td>
                        <th>诊断医生:</th>
                        <td><ehr:user userCode="${malariaDto.diagnosis.diagnosisDoctor}"/></td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
            	<legend>督导服药</legend>
                <table class="posttable">
                    <colgroup>
                        <col style="min-width: 100px; width: 15%;"/>
                        <col style="min-width: 180px; width: 35%;"/>
                        <col style="min-width: 100px; width: 15%;"/>
                        <col style="min-width: 180px; width: 35%;"/>                        
                    </colgroup>
                    <tbody>
	                    <tr>
	                        <th>抗疟治疗类型:</th>
	                        <td><ehr:dic dicmeta="IDM00268" code="${malariaDto.otherCondition.caseType}"/></td>
	                        <th>镜检/RDT结果:</th>
	                        <td><ehr:dic dicmeta="IDM00263" code="${malariaDto.labExamine.rdt}"/></td>                        
	                    </tr>                    
                    </tbody>
                </table>
                <br>
				<div id ="childDiv" class="repeattable">
					<table>
						<colgroup>
							<col style="width:15%;"/>
							<col style="width:25%;"/>
							<col style="width:15%;"/>
							<col style="width:15%;"/>
							<col style="width:15%;"/>
						</colgroup>	
						<thead>
							<tr>
						        <th class="centerth">用药时间</th>
						        <th class="centerth">药物名称</th>
						        <th class="centerth">成人剂量</th>
						        <th class="centerth">实用剂量</th>
						        <th class="centerth">患者本人签名</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="drugreg" items="${drugregs}" varStatus="status1">
								<tr item="${status1.count}">
									<td rowspan="${fn:length(drugreg.listSds)}"><fmt:formatDate value="${drugreg.drugDt}" pattern="yyyy/MM/dd" /></td>
									<c:forEach var="sd" items="${drugreg.listSds}" varStatus="status2">
											<c:if test="${status2.count != 1 }">
												<tr>
											</c:if>
											<td>${sd.drugName}</td>
											<td>${sd.adultMetering}</td>
											<td>${sd.practicalMetering}</td>
											<td>${sd.patientName}</td>
											</tr>
									</c:forEach>
							</c:forEach>
						</tbody>
					</table>
					<br>
					<div>
		            	<span>试治病例抗疟治疗是否有效:</span>
					 	<ehr:dic dicmeta="IDM00074" code="${malariaDto.otherCondition.valid}"/>
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
	                        <th>督导服药人:</th>
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