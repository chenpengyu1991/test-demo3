<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.PrintArea.js"></script>
	<style>
        .headTable {width: 650px;line-height: 200%;text-align: left}
        .headTable td input[type="text"] {border:none;border-bottom:1px solid #000;}
        .printTable {width: 645px;border: 1px solid; line-height: 200%; text-align: center}
        .printTable td {border: 1px solid;}
    </style>
<%-- <jsp:include page="input.jsp"></jsp:include> --%>
	 <div class="print" style="text-align: center;">
	            <br/>
	            <h2 style="text-align: center">食源性疾病病例信息表</h2>
	            <br/>
	            <div id="head" class="postcontentprint" style="padding: 0 10px 10px ">
			            <fieldset class="layui-elem-field">
						    <legend>一.基本信息(横线上填写相关内容，或相应选项的"□"中打√) 
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							&nbsp;&nbsp;&nbsp;
							病例编号:${food.no1}${food.year}${food.no2}</legend>
						    <table class="posttable" border="0">
						        <colgroup>
						            <col style="width: 7%; min-width: 70px;"/>
						            <col style="width: 7%; min-width: 70px;"/>
						             <col style="width: 7%; min-width: 70px;"/>
						             <col style="width: 8%; min-width: 50px;"/>
						            <col style="width: 8%; min-width: 50px;"/>
						            <col style="width: 8%; min-width: 50px;"/>
						            <col style="width: 10%; min-width: 60px;"/>
						            <col style="width: 18%; min-width: 250px;"/>
						        </colgroup>
						        <tr>
						            <th><label class="">姓名</label></th>
						            <td><input type="text" name="name" value="${food.name}" reg="{'required':true,'maxlength':50}" readonly width="200px"/></td>
						            <th><label class="">性别</label></th>
						            <td><ehr:dic-radio id="gender" uninclude="0,9" dicmeta="GBT226112003" name="gender" value="${food.gender}"
						                               reg="{'required':true}" disabled="true"/></td>
						            <th><label class="">出生年月</label></th>
						            <td align="left">
						            <fmt:formatDate value="${food.birthday}" pattern="yyyy/MM/dd" /> 
						            <th>身份证</th>
						            <td>
						                <input type="text" id="idCardTemp" name="idcard" value="${food.idcard}" reg='{"idCard":true}' readonly
						                       placeholder="输入身份证获取人员信息"/>
						            </td>
						        </tr>
						        <tr>
	
						            <th ><label class="">现住址</label></th>
						            <td colspan="5" align="left">
						                <div>
						                <label id="tempPaValue">
						                    <ehr:dic code="${food.patownShip}" dicmeta="FS990001" /><ehr:dic code="${food.pastreet}"
						                                                                                    dicmeta="FS990001"/>
						                </label>${food.pahouseNumber}</div>
						                <!-- <span id="spanPaNumber">(门牌号)</span> -->
						            </td>
						            <th><label class="">联系电话</label></th>
						            <td><input type="text" name="phoneNumber" value="${food.phoneNumber}"  reg="{'required':true,'regex':'phone'}" readonly/></td>
						        </tr>
						        <tr>
						            <th><label class="">病人属于</label></th>
						            <td colspan="7" align="left">
						                <ehr:dic-radio name="floatPopulation" dicmeta="CV0201104" id="floatPopulationId"
						                               value="${food.floatPopulation}"
						                               reg='{"required":"true"}' disabled='true'/>
						            </td> 
						        </tr>
						        <tr>
						            
						           
						                      
						            <th><label class="">门诊号</label></th>
						            <td><input type="text" name="outpatientNo" value="${food.outpatientNo}" reg="{'required':true,'maxlength':20}" readonly/></td>
						            <th><label class="">发病时间</label></th>
						            <td colspan="2" align="left">
						            	<fmt:formatDate value="${food.pathogenesisDate}" pattern="yyyy/MM/dd HH:mm" /> 
						                
						            </td>
						            <th><label class="">就诊时间</label></th>
						            <td colspan="2" align="left">
						            	<fmt:formatDate value="${food.diagnosisDate}" pattern="yyyy/MM/dd HH:mm" /> 
						                
						            </td>
						        </tr>
						        <tr>
						            <th><label class="">职业</label></th>
						            <td colspan="3">
						                <ehr:dic-list name="infectedpersonOccupation" dicmeta="GBT6565" value="${food.infectedpersonOccupation}"
						                              reg='{"required":"true"}' width="200px"
						                              onchange="toggleOtherSC('infectedpersonOccupation','occupationOther','CV020120299')"
						                              code="CV020120201,CV020120203,CV020120209,CV020120211,CV020120210,CV020120206,CV020120208,CV020120204,CV020120214,CV020120215,CV020120216,CV020120299"/>
						                            <span id="occupationOther"
						                                  style="${food.infectedpersonOccupation == 'CV020120299' ? '' : 'display:none;'}">
						                            	<input type="text" style="width: 150px;" name="occupationOther"
						                                       value="${occupationOther}" reg='{"maxlength":"20"}'/>
						                            </span>
						            </td>
						            <th>监护人</th>
						            <td colspan="3" align="left">
						            <input type="text" name="parentsName" value="${food.parentsName}" reg="{'maxlength':50}" style="width:100px" readonly/></td>
						        </tr>
						    </table>
					</fieldset>
					<fieldset class="layui-elem-field">
					    <legend>二.主要症状与体征(在相应症状或体征的"□"中打√,或于横线上填写具体描述) </legend>
					    <table class="posttable" >
					        <colgroup>
					            <col style="width: 8%; min-width: 60px;"/>
					            <col style="width: 15%; min-width: 100px;"/>
					            <col style="width: 20%; min-width: 100px;"/>
					            <col style="width: 15%; min-width: 100px;"/>
					            <col style="width: 15%; min-width: 100px;"/>
					            <col style="width: 20%; min-width: 100px;"/>
					        </colgroup>
					        <tr align="left">
					            <th>全身</th>
					            <td colspan="5">
					                <ehr:dic-checkbox  disabled="true" name="wholeBody" value="${food.wholeBody}" dicmeta="DMD00083" code="101"/>
                					<ehr:dic-checkbox  disabled="true" name="wholeBody" value="${food.wholeBody}" dicmeta="DMD00083" code="102"/>
                					<input type="text" disabled="disabled" name="emesisNum" id="emesisNum"  value="${food.emesisNum}" style="width: 50px;" />次
                					<ehr:dic-checkbox  disabled="true" name="wholeBody" value="${food.wholeBody}" uninclude="101,102" dicmeta="DMD00083"/>
					            </td>
					        </tr>

					        <tr align="left">
					            <th>中毒</th>
					            <td colspan="5"><ehr:dic-checkbox name="toxication" value="${food.toxication}" dicmeta="DMD00084" disabled="true"/></td>
					        </tr>
					
					        <tr align="left">
					            <th>肠道感染</th>
					            <td colspan="5">
					                <ehr:dic-checkbox name="intestinalInfection" value="${food.intestinalInfection}" dicmeta="DMD00070"
					                                  code="201,202" disabled="true"/>
					
					                (<label style="color:red">*</label>性状
					                <ehr:dic-checkbox name="laxSymptom" disabled="true" dicmeta="DMD00071" value="${food.laxSymptom}" reg='{"required":"true"}'/>
											                     	<input type="text" name="laxCount" value="${food.laxCount}"
					                                                       reg='{"maxlength":"20","required":"true"}' style="width: 60px;" readonly/>次/天)
					
					                <ehr:dic-checkbox name="intestinalInfection" disabled="true" value="${food.intestinalInfection}" dicmeta="DMD00070"
					                                  code="207,208,209"/>
					                (<input type="text" name="feverTemp" disabled="true" value="${food.feverTemp}" reg='{"maxlength":"20"}'
					                       style="width: 60px;" readonly/>℃ )&nbsp;&nbsp;
					
					                <ehr:dic-checkbox name="intestinalInfection" disabled="true" value="${food.intestinalInfection}" dicmeta="DMD00070"
					                                  code="210"/>
					            </td>
					        </tr>
					
					        <tr align="left">
					            <th>一般感染</th>
					            <td colspan="5"><ehr:dic-checkbox name="infect" disabled="true" dicmeta="DMD00072" value="${food.infect}"/></td>
					        </tr>

					
					        <tr align="left">
					            <th>局部感染</th>
					            <td colspan="5"><ehr:dic-checkbox name="partInfect" disabled="true" dicmeta="DMD00073" value="${food.partInfect}"/></td>
					        </tr>
					
					        <tr align="left">
					            <th>神经症状</th>
					            <td colspan="5">
					                <ehr:dic-checkbox name="nerveSymptom" disabled="true" dicmeta="DMD00074" value="${food.nerveSymptom}"
					                                  onchange="toggleOtherCK('nerveSymptom','pupilException','513')"/>
																 <span id="pupilException" style="display: none;">
											                     	（瞳孔异常描述：<input type="text" name="pupilException" value="${food.pupilException}"
					                                                       reg='{"maxlength":"20"}' style="width: 20%;"/>）
											                     </span>
					            </td>
					        </tr>

					        <tr align="left">
					            <th colspan="2">首发症状与体征(前三位)</th>
					            <td><input type="text" name="symptom" value="${food.symptom}" reg="{'maxlength':100}" readonly/></td>
					            <th colspan="2">其他症状与体征</th>
					            <td><input type="text" name="symptomOther" value="${food.symptomOther}" reg="{'maxlength':100}" readonly/></td>
					        </tr>
					    </table>
					</fieldset>
					<fieldset class="layui-elem-field">
					    <legend>三.既往病史</legend>
					    <table class="posttable">
					        <colgroup>
					            <col style="width: 15%; min-width: 100px;"/>
					            <col style="width: 85%; min-width: 200px;"/>
					        </colgroup>
					        <tr>
					            <td colspan="2">
					                <ehr:dic-checkbox name="previousHistory" disabled="true" dicmeta="DMD00075" value="${food.previousHistory }"
					                                  onchange="toggleOtherCK('previousHistory','previousHistoryOther','99')"/>
													 <span id="previousHistoryOther" style="display: none;">
								                     	(<ehr:dic-checkbox name="previousHistoryOther" value="${food.previousHistoryOther}"
					                                                       dicmeta="DMD00076"/>)
								                     </span>
					            </td>
					        </tr>
					    </table>
					</fieldset>
					<fieldset class="layui-elem-field">
					    <legend>四.临床初步诊断</legend>
					    <table class="posttable">
					        <colgroup>
					            <col style="width: 11%; min-width: 100px;"/>
					            <col style="width: 16%; min-width: 120px;"/>
					            <col style="width: 11%; min-width: 120px;"/>
					            <col style="width: 12%; min-width: 120px;"/>
					            <col style="width: 13%; min-width: 120px;"/>
					            <col style="width: 12%; min-width: 100px;"/>
					            <col style="width: 13%; min-width: 100px;"/>
					            <col style="width: 12%; min-width: 120px;"/>
					        </colgroup>
					        <tr>
					            <th><label class="">初步诊断</label></th>
					            <td><input type="text" name="clinicalDiagnosis" value="${food.clinicalDiagnosis}"
					                       reg='{"required":true,"maxlength":"20"}' readonly/></td>
					            <th>是否住院</th>
					            <td><ehr:dic-radio name="inHospital" disabled="true" dicmeta="PH00001" code="1,2" value="${food.inHospital}"/></td>
					            <th>诊前服抗生素</th>
					            <td><ehr:dic-radio name="antibiotic" disabled="true" dicmeta="PH00001" code="1,2" value="${food.antibiotic}"/></td>
					            <th>怀疑食物引起</th>
					            <td><ehr:dic-radio name="foodCause" disabled="true" dicmeta="PH00001" code="1,2" value="${food.foodCause}"/></td>
					        </tr>
					    </table>
					</fieldset>
					<fieldset class="layui-elem-field">
					    <legend>五.暴露信息（饮食史）</legend>
					    <table class="posttable">
					        <colgroup>
					            <col style="width: 15%; min-width: 100px;"/>
					            <col style="width: 35%; min-width: 200px;"/>
					            <col style="width: 15%; min-width: 100px;"/>
					            <col style="width: 35%; min-width: 200px;"/>
					        </colgroup>
					        <tr>
					            <!-- <td colspan="4" align="left">
					                <ehr:dic-checkbox name="foodHistory" disabled="true" dicmeta="DMD00077" value="${food.foodHistory}"
					                                  onchange="toggleOtherCK('foodHistory','foodHistoryOther','99')"/>
													 <span id="foodHistoryOther" style="display: none;">
								                     	<input type="text" name="foodHistoryOther" value="${food.foodHistoryOther}"
					                                           reg='{"maxlength":"100"}'/>
								                     </span>
					            </td> -->
					             <td colspan="2">
                						<ehr:dic-list reg='{"required":"true"}' name="foodHistory" dicmeta="DMD00086" value="${food.foodHistory}"
                                 		 onchange="toggleOtherSC('foodHistory','foodHistoryOther','99')"   />
								 		<span id="foodHistoryOther" style="display: none;">
			                     		<input type="text" name="foodHistoryOther" value="${food.foodHistoryOther}"
                                           reg='{"maxlength":"100"}'/>
			                   	  </span>
           						 </td>
					        </tr>
					        <tr>
					            <td colspan="4" style="padding: 0px;">
					                <div class="repeattable">
					                    <table>
					                        <colgroup>
					                           <col style="width:10%;"/>
                            				   <col style="width:10%;"/>
                           					   <col style="width:20%;"/>
                            				   <col style="width:20%;"/>
                            				   <col style="width:15%;"/>
                           			           <col style="width:10%;"/>
                          			           <col style="width:10%;"/>
					                        </colgroup>
					                        <thead>
					                        <tr>
					                            <th style="text-align: center;">可疑食物</th>
					                            <th style="text-align: center;">食物名称</th>
					                            <th style="text-align: center;">加工或包装方式</th>
					                            <th style="text-align: center;">进食场所</th>
					                            <th style="text-align: center;">进食时间</th>
					                            <th style="text-align: center;">进食人数</th>
					                            <th style="text-align: center;">其他人是否发病</th>
					                        </tr>
					                        <tr>
					                            <td style="text-align: center;">1</td>
					                            <td style="text-align: center;"><input type="text" name="food1" value="${food.food1}"
					                                                                   reg='{"maxlength":"100"}' readonly/></td>
					                            <td style="text-align: center;"><ehr:dic-list name="pack1" dicmeta="DMD00088" value="${food.pack1 }" /></td>
                         
					                            <td style="text-align: center;"><!--<ehr:dic-radio name="address1" disabled="true" dicmeta="DMD00078"
					                                                                           value="${food.address1}"/></td>-->
					                            <ehr:dic-list name="address1" dicmeta="DMD00087" value="${food.address1}" />                                         
					                            <td style="text-align: center;">
					                                <fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${food.foodDate1}"/>
					                            </td>
					                            <td style="text-align: center;"><input type="text" name="foodNum1" value="${food.foodNum1}"
					                                                                   reg='{"maxlength":"20"}' readonly/></td>
					                            <td style="text-align: center;"><ehr:dic-radio name="attack1" disabled="true" dicmeta="DMD00079"
					                                                                           value="${food.attack1}"/></td>
					                        </tr>
					                        <tr>
					                            <td style="text-align: center;">2</td>
					                            <td style="text-align: center;"><input type="text" name="food2" value="${food.food2}"
					                                                                   reg='{"maxlength":"100"}' readonly/></td>
					                            <td style="text-align: center;"><ehr:dic-list name="pack2" dicmeta="DMD00088" value="${food.pack2 }"  /></td>
					                            <td style="text-align: center;"><!--<ehr:dic-radio name="address2" disabled="true" dicmeta="DMD00078"
					                                                                           value="${food.address2}"/></td>-->
					                            <ehr:dic-list name="address2" dicmeta="DMD00087" value="${food.address2}" />   
					                            <td style="text-align: center;">
					                                <fmt:formatDate pattern="yyyy/MM/dd HH:mm:ss" value="${food.foodDate2}"/>
					                            </td>
					                            <td style="text-align: center;"><input type="text" name="foodNum2" value="${food.foodNum2}"
					                                                                   reg='{"maxlength":"20"}' readonly/></td>
					                            <td style="text-align: center;"><ehr:dic-radio name="attack2" disabled="true" dicmeta="DMD00079"
					                                                                           value="${food.attack2 }"/></td>
					                        </tr>
					                        </thead>
					                    </table>
					                </div>
					            </td>
					        </tr>
					        <tr>
					            <th>发病前一周情况：</th>
					            <td colspan="3" align="left"><ehr:dic-checkbox disabled="true" name="weekCondition" dicmeta="DMD00080" value="${food.weekCondition}"/></td>
					           
					        </tr>
					        <tr>
           						<th>进食地点</th>
           						<td>  <ehr:dic-town-village villageId="eat_village_address"
											  townId="eat_town_address"
											  townName="eatTownAddress"
											  width="178px;"
											  villageValue="${food.eatVillageAddress}"
											  townValue="${food.eatTownAddress}"
								/><input type="text" id="eatPlace" name="eatPlace" value="${food.eatPlace}"/>
           						</td>
            					<td></td>
           						<td></td>
       					    </tr>
       					    <tr>
           						 <th>购买地点</th>
            					 <td> <ehr:dic-town-village villageId="buy_village_address"
											  townId="buy_town_address"
											  townName="buyTownAddress"
											  width="178px;"
											  villageValue="${food.buyVillageAddress}"
											  townValue="${food.buyTownAddress}"
							      /><input type="text" id="buyPlace" name="buyPlace" value="${food.buyPlace}"/></td>
            					 <td></td>
            					 <td></td>
        					</tr>
					    </table>
					</fieldset>
					<fieldset class="layui-elem-field">
					    <legend>六.是否采集粪便和肛拭样本</legend>
					    <table class="posttable">
					        <colgroup>
					            <col style="width: 15%; min-width: 100px;"/>
					            <col style="width: 20%; min-width: 100px;"/>
					            <col style="width: 15%; min-width: 100px;"/>
					            <col style="width: 15%; min-width: 100px;"/>
					            <col style="width: 15%; min-width: 100px;"/>
					            <col style="width: 20%; min-width: 100px;"/>
					        </colgroup>
					        <tr>
					            <%-- <th><label class="required">是否采集粪便和肛拭标本：</label></th>
					            <td><ehr:dic-radio name="specimen" dicmeta="PH00001" code="1,2" value="${food.specimen}"
					                               reg="{'required':true}" /></td> --%>
					            <th >样本类型：</th>
					            <td cospan=""><ehr:dic-radio disabled="true" name="specimenType" dicmeta="DMD00081" code="1,2,3" value="${food.specimenType==null?2:food.specimenType}" /></td>
					        	<th>样本编号：</th>
					            <td id="ybbh">
					               ${food.no1}${food.year}${food.no2}
					            </td>
					        </tr>
					        <tr>
					            
					            <th>医疗机构名称：</th>
					            <td>
					                ${food.fillOrganName}
					                    <input type="hidden" name="fillOrganName" value="${food.fillOrganName}"/>
					                    <input type="hidden" name="fillOrganCode" value="${food.fillOrganCode}"/>
					            </td>
					            <th>填表人：</th>
					            <td>
					                ${food.reportDoctorName}
					                <%--<input type="hidden" name="reportDoctorId" value="${food.reportDoctorId}"/>--%>
					                <input type="hidden" name="reportDoctorName" value="${food.reportDoctorName}"/>
					            </td>
					            <th>填写日期：</th>
					            <td>
					                <%-- <tag:dateInput nullToToday="true" name="fillDate" onlypast="true"
					                               pattern="yyyy/MM/dd" date="${food.fillDate}"/> --%>
					                <fmt:formatDate value="${food.fillDate}" pattern="yyyy/MM/dd"/>
					            </td>
					        </tr>
					    </table>
					</fieldset>
	          	</div>
	 </div>


