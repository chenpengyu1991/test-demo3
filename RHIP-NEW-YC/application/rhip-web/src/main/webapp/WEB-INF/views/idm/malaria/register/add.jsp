<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/idm/malaria/register.js" type="text/javascript"></script>
<div class="toolbar">
    <a href="javascript:void(0)" onclick="javascript:register.returnSearch()"><b class="fanhui">返回</b></a>
    <c:choose>
        <c:when test="${approveFlag=='1'}">
        	<c:if test="${type == 'add'}">
	            <a href="javascript:void(0)" id="regApprovalId" ><b class="tongguo">通过</b></a>
	            <a href="javascript:void(0)" id="reg_remove" ><b class="zuofei">排除</b></a>
            </c:if>
            <a href="javascript:void(0)" onclick="register.viewLog(${malariaDto.idmId})"><b class="jilu">操作记录</b></a>
        </c:when>
        <c:otherwise>
        	<c:if test="${type == 'add'}">
            	<a href="javascript:void(0)" onclick="javascript:register.registerSubmit()"><b class="tijiao">提交</b></a>
            </c:if>
         	<c:if test="${type == 'view'}">
            	<a href="javascript:void(0)" onclick="register.viewLog(${malariaDto.idmId})"><b class="jilu">操作记录</b></a>
            </c:if>           
        </c:otherwise>
    </c:choose>
</div>

<form id="registerForm">
	<input type="hidden" id="pageIndex" name="pageIndex" value="${pageIndex}">
	<input type="hidden" name="singleId" value="${malariaDto.singleId}"/>
	<input type="hidden" name="idmId" value="${malariaDto.idmId}"/>
	<input type="hidden" id="type" name="type" value="${type}"/>
	<input type="hidden" id="logoffId" name="logoff" value="${malariaDto.logoff}"/>
    <input type="hidden" id="specialStatusId" name="specialStatus" value="${malariaDto.specialStatus}"/>
    <div class="postcontent">
        <i class="popno">发热病人疟原虫血检病人登记表 </i>
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
                        <th><label class="required">姓名:</label></th>
                        <td>
                        	<input type="text" id="nameId" name="generalCondition.name" value="${malariaDto.generalCondition.name}" 
                        		style="width: 100px;" reg='{"required":"true","maxlength":"50"}'/>
                        </td>
                        <th><label class="required">性别:</label></th>
                        <td>
                        	<ehr:dic-radio name="generalCondition.gender" dicmeta="GBT226112003" value="${malariaDto.generalCondition.gender}"  reg='{"required":"true"}' code="1,2"/>
                        </td>
                        <th><label class="required">年龄:</label></th>
                        <td>
                        	<input type="text" id="age" name="generalCondition.age" value="${malariaDto.generalCondition.age}" 
                        		style="width: 100px;" reg='{"required":"true","digits":"true","maxlength":"20"}'/>
                        </td>
                    </tr>
					<tr>
				       	<th><label class="required">常住类型:</label></th>
				       	<td colspan="5">
				 			<ehr:dic-radio name="generalCondition.floatPopulation" dicmeta="FS10005" reg='{"required":"true"}'
				           		value="${malariaDto.generalCondition.floatPopulation}" onchange="register.toggerAddress()"/>
				       	</td>
		       		</tr>
	        		<tr>
		            <th><label class="required">详细住址:</label></th>
		            <td colspan="5">
			        	<ehr:dic-town-village villageId="pavillage_address" townId="patown_address" villageName="generalCondition.pastreet" townName="generalCondition.patownShip"
			            	villageValue="${malariaDto.generalCondition.pastreet}" townValue="${malariaDto.generalCondition.patownShip}" width="180px;" reg='{"required":"true"}'/>
                           <label id="tempPaValue">
                               <ehr:dic code="${malariaDto.generalCondition.patownShip}" dicmeta="FS990001"/><ehr:dic code="${malariaDto.generalCondition.pastreet}" dicmeta="FS990001"/>
                           </label>
			            	<input type="text" id="pahouseNumber" name="generalCondition.pahouseNumber" value="${malariaDto.generalCondition.pahouseNumber}"
			                	reg='{"required":"true","maxlength":"50"}'  style="width: 180px;">
			         	<span id="spanPaNumber">(门牌号)</span>
			        </td>
			        </tr>
			        <!-- 血检登记增加非户籍的户籍地址填写字段 -->
			        <tr>
			            <th class="pa_hr_address">户籍住址:</th>
			            <td colspan="5" class="pa_hr_address">
					    	<input type="text" id="hrAddress" name="generalCondition.hrAddress" value="${malariaDto.generalCondition.hrAddress}"
				                	reg='{"maxlength":"100"}'  style="width:90%">
				        </td>			        
			     	</tr>                    
                    <tr>
                        <th>联系电话:</th>
                        <td colspan="2">
                        	<input type="text" id="phoneNumberId" name="generalCondition.phoneNumber" value="${malariaDto.generalCondition.phoneNumber}"
                                   reg='{"phone":"true"}' style="width: 100px;"/>
                        </td>                    
                        <th>身份证号码:</th>
                        <td colspan="2">
                        	<input type="text" id="idCard" name="generalCondition.idcard" value="${malariaDto.generalCondition.idcard}"
                                   placeholder="输入身份证获取个人信息" reg='{"idCard":"true"}'/>
                        </td>
                     </tr>
                    <tr>
                        <th><label class="required">发病日期:</label></th>
                        <td colspan="2">
                        	<tag:dateInput nullToToday="true" id="pathogenesisDateId" name="attackCondition.pathogenesisDate" style="width: 100px;"
                        		reg='{"required":"true","regex":"date"}'  pattern="yyyy/MM/dd" date="${malariaDto.attackCondition.pathogenesisDate}" onlypast="true"></tag:dateInput>
                        <th><label class="required">临床初诊:</label></th>
                        <td colspan="2">
                        	<ehr:dic-radio name="diagnosis.tentativeDiagnosis" dicmeta="IDM00381"  value="${malariaDto.diagnosis.tentativeDiagnosis}"
                        		onchange="register.approvalStatus()"  reg='{"required":"true"}'/>
                        </td>                        		
                    </tr>
                    <tr>
                        <th><label class="required">检验日期:</label></th>
                        <td colspan="2">
                        	<tag:dateInput nullToToday="true" id="testDtId" name="labExamine.testDt" style="width: 100px;"
                        		reg='{"required":"true","regex":"date","compare":["pathogenesisDateId","ge","检验日期不能小于发病日期"]}'  pattern="yyyy/MM/dd" date="${malariaDto.labExamine.testDt}" onlypast="true"></tag:dateInput>
                        <th><label class="required">检验结果:</label></th>
                        <td colspan="2">
                        	<ehr:dic-radio name="labExamine.testResult" dicmeta="IDM00258" value="${malariaDto.labExamine.testResult}"
                            	onchange="register.approvalStatus()" reg='{"required":"true"}'/>
                        </td>                        		
                    </tr>
                    <%--未核实非查看、核实且查看的显示分配单位--%>
                    <c:if test="${approveFlag=='1' && (type!='view' || malariaDto.caseInformation.acceptTown!=null)}">
						<tr>
							<th><label class="required">分配单位:</label></th>
							<td  colspan="5">
								<ehr:dic-town-centre-station centreId="acceptUnitId" centreName="caseInformation.acceptUnit" centreValue="${malariaDto.caseInformation.acceptUnit}" stationName="" 
									townId="acceptTownId" townName="caseInformation.acceptTown" townValue="${malariaDto.caseInformation.acceptTown}"   style="width:250px;"/>
							</td>
						</tr>
					</c:if> 
                    <tr>
                        <th>镜检者:</th>
                        <td colspan="2">
                        	<ehr:user userCode="${malariaDto.labExamine.testUser}"/>
                        	<input type="hidden"  name="labExamine.testUser" value="${malariaDto.labExamine.testUser}"/>
                        </td>
                        <th>备注:</th>
                        <td colspan="2">
                        	<input type="text" name="labExamine.otherResult" value="${malariaDto.labExamine.otherResult}"
                                   reg='{"maxlength":"100"}'/>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
            <fieldset>
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
                        <th>报告人:</th>
                        <td>
                        	<ehr:user userCode="${malariaDto.caseInformation.reportPerson}"/>
							<input type="hidden"  name="caseInformation.reportPerson" value="${malariaDto.caseInformation.reportPerson}"/>
                        </td>
                        <th><label class="required">报告日期:</label></th>
                        <td>
                            <c:choose>
                                <c:when test="${approveFlag=='1'}">
                                    <c:if test="${type == 'add'}">
                                        <fmt:formatDate pattern="yyyy/MM/dd"
                                                        value="${malariaDto.caseInformation.reportDate}"/>
                                    </c:if>
                                    <c:if test="${type == 'view'}">
                                        <fmt:formatDate pattern="yyyy/MM/dd"
                                                        value="${malariaDto.caseInformation.reportDate}"/>
                                    </c:if>
                                    <tag:dateInput nullToToday="true" id="reportDateId"
                                                   name="caseInformation.reportDate" pattern="yyyy/MM/dd"
                                                   date="${malariaDto.caseInformation.reportDate}"
                                                   onlypast="true"
                                                   reg='{"required":"true","compare":["testDtId","ge","报告日期不能小于检验日期"]}'
                                                   style="display: none"></tag:dateInput>
                                </c:when>
                                <c:otherwise>
                                    <c:if test="${type == 'add'}">
                                        <tag:dateInput nullToToday="true" id="reportDateId"
                                                       name="caseInformation.reportDate" pattern="yyyy/MM/dd"
                                                       date="${malariaDto.caseInformation.reportDate}"
                                                       onlypast="true"
                                                       reg='{"required":"true","compare":["testDtId","ge","报告日期不能小于检验日期"]}'></tag:dateInput>
                                    </c:if>
                                    <c:if test="${type == 'view'}">
                                        <fmt:formatDate pattern="yyyy/MM/dd"
                                                        value="${malariaDto.caseInformation.reportDate}"/>
                                    </c:if>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <th>报告单位:</th>
                        <td>
                        	<ehr:org code="${malariaDto.caseInformation.reportOrg}"/>
                        	<input type="hidden"  name="caseInformation.reportOrg" value="${malariaDto.caseInformation.reportOrg}"/>
                        </td>
                    </tr>                    
                    </tbody>
                </table>
            </fieldset>
        </div>
    </div>
</form>
