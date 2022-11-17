<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="${pageContext.request.contextPath}/js/views/idm/leprosy/followup_add.js" type="text/javascript"></script>
<fieldset style="margin-top: 10px">
            <legend>麻风随访观察表</legend>
            <form id="frForm">
            	<input type="hidden" id="singleIdFollow" name="idmId" value="${idmId == null ? listFr.idmId : idmId}">
                <input type="hidden" id="frId" name="id" value="${listFr.id}">
                <input type="hidden" id="listCcJson" name="listCcJson"/>
                <table class="posttable">
                    <colgroup>
						<col style="width: 20%" />
						<col style="width: 30%" />
						<col style="width: 20%" />
						<col style="width: 30%" />
					</colgroup>
                    <tr>
                    	<th>病例编号：</th>
                    	<td><input type="text" name="checkResult" value="${listFr.checkResult}" reg='{"maxlength":"100"}'/></td>
                        <th>姓名：</th>
                        <td>${patientNameF}</td>
                    </tr>
                    <tr>
                    	<th>报告单位：</th>
                    	<td colspan="3">
                    		${currentLoginInfo.organization.organName }
                    		<input type="hidden" name="visitInst" value="${listFr.visitInst==null ? currentLoginInfo.organization.organCode : listFr.visitInst}" reg='{"maxlength":"100"}'/>
                    	</td>
                    </tr>
                </table>
                <fieldset style="margin-top: 10px">
	            	<legend>一、随访概况</legend>
		            <table class="posttable">
	                    <colgroup>
							<col style="width: 15%" />
							<col style="width: 35%" />
							<col style="width: 15%" />
							<col style="width: 55%" />
						</colgroup>
	                    <tr>
	                    	<th>随访日期：</th>
	                    	<td><tag:dateInput name="visitDt" date="${listFr.visitDt==null ? nowDate : listFr.visitDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                        <th>随访状态：</th>
	                        <td><ehr:dic-radio name="followupStatus" dicmeta="IDM00374" value="${listFr.followupStatus}"/> </td>
	                    </tr>
	                    <tr>
	                    	<th>目前转归</th>
	                    	<td colspan="3"><ehr:dic-radio name="lapse" dicmeta="IDM00354" value="${listFr.lapse}"/></td>
	                    </tr>
	                </table>
	            </fieldset>
	            <fieldset style="margin-top: 10px">
	            	<legend>二、常规随访</legend>
		            <table class="posttable">
	                    <colgroup>
							<col style="width: 15%" />
							<col style="width: 35%" />
							<col style="width: 15%" />
							<col style="width: 55%" />
						</colgroup>
						<tr>
						    <th>（一）皮损</th>
						    <td colspan="3"></td>
						</tr>
	                    <tr>
	                        <th>随访时皮损：</th>
	                        <td><ehr:dic-radio name="skinLesionStatus" dicmeta="IDM00355" value="${listFr.skinLesionStatus}"/> </td>
	                    </tr>
	                    <tr>
						    <td>皮损描述：</td>
						</tr>
	                    <tr>
	                    	<td colspan="4"> <textarea name="skinLesion" style="width: 100%" rows="5" reg='{"maxlength":"100"}'>${listFr.skinLesion}</textarea></td>
	                    </tr>
	                    <tr>
						    <td>（二）神经</td>
						    <td colspan="3"></td>
						</tr>
						<tr>
	                        <td>随访时神经：</td>
	                        <td><ehr:dic-radio name="nervousLesion" dicmeta="IDM00356" value="${listFr.nervousLesion}"/> </td>
	                    </tr>
	                    <tr>
							<td colspan="4" style="padding: 0px;">
								<div class="repeattable">
								<table>
									<colgroup>
										<col style="width:10%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
									</colgroup>
									<thead>
										<tr>
											<th rowspan="2" colspan="1"style="text-align: center;">损害</th>
											<th rowspan="1" colspan="2" style="text-align: center;">耳大神经</th>
											<th rowspan="1" colspan="2" style="text-align: center;">眶上神经</th>
											<th rowspan="1" colspan="2" style="text-align: center;">尺神经</th>
											<th rowspan="1" colspan="2" style="text-align: center;">腓总神经</th>
											<th rowspan="1" colspan="2" style="text-align: center;">正中神经</th>
											<th rowspan="1" colspan="2" style="text-align: center;">胫神经</th>
											<th rowspan="1" colspan="2" style="text-align: center;">桡神经</th>
											<th rowspan="1" colspan="2" style="text-align: center;">面神经</th>
										</tr>
										<tr>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
										</tr>
										<tr>
											<th style="text-align: center;">粗大</th>
											<td style="text-align: center;"><ehr:dic-checkbox name="earRightThick" value="${listFr.earRightThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="earLeftThick" value="${listFr.earLeftThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="orbitRightThick" value="${listFr.orbitRightThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="orbitLeftThick" value="${listFr.orbitLeftThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="ulnarRightThick" value="${listFr.ulnarRightThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="ulnarLeftThick" value="${listFr.ulnarLeftThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="peronealRightThick" value="${listFr.peronealRightThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="peronealLeftThick" value="${listFr.peronealLeftThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="medianRightThick" value="${listFr.medianRightThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="medianLeftThick" value="${listFr.medianLeftThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="shinRightThick" value="${listFr.shinRightThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="shinLeftThick" value="${listFr.shinLeftThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="oarRightThick" value="${listFr.oarRightThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="oarLeftThick" value="${listFr.oarLeftThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="faceRightThick" value="${listFr.faceRightThick}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="faceLeftThick" value="${listFr.faceLeftThick}" dicmeta="IDM00376"/></td>
										</tr>
										<tr>
											<th style="text-align: center;">触痛</th>
											<td style="text-align: center;"><ehr:dic-checkbox name="earRightTender" value="${listFr.earRightTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="earLeftTender" value="${listFr.earLeftTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="orbitRightTender" value="${listFr.orbitRightTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="orbitLeftTender" value="${listFr.orbitLeftTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="ulnarRightTender" value="${listFr.ulnarRightTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="ulnarLeftTender" value="${listFr.ulnarLeftTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="peronealRightTender" value="${listFr.peronealRightTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="peronealLeftTender" value="${listFr.peronealLeftTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="medianRightTender" value="${listFr.medianRightTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="medianLeftTender" value="${listFr.medianLeftTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="shinRightTender" value="${listFr.shinRightTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="shinLeftTender" value="${listFr.shinLeftTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="oarRightTender" value="${listFr.oarRightTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="oarLeftTender" value="${listFr.oarLeftTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="faceRightTender" value="${listFr.faceRightTender}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="faceLeftTender" value="${listFr.faceLeftTender}" dicmeta="IDM00376"/></td>
										</tr>
									</thead>
								</table>
								</div>
							</td>
						</tr>
						<tr>
						    <td>其他神经：</td>
						    <td colspan="3"><input type="text" name="otherNeuro" value="${listFr.otherNeuro}" reg='{"maxlength":"100"}'/></td>
						</tr>
						<tr>
							<td colspan="4" style="padding: 0px;">
								<div class="repeattable">
								<table>
									<colgroup>
										<col style="width:10%;"/>
										<col style="width:45%;"/>
										<col style="width:45%;"/>
									</colgroup>
									<thead>
										<tr>
											<th style="text-align: center;">项　目</th>
											<th style="text-align: center;">右眼</th>
											<th style="text-align: center;">左眼</th>
										</tr>
										<tr>
											<th style="text-align: center;">视　力</th>
											<td style="text-align: center;"><ehr:dic-radio name="visionRight" value="${listFr.visionRight}" dicmeta="IDM00357"/> </td>
											<td style="text-align: center;"><ehr:dic-radio name="visionLeft" value="${listFr.visionLeft}" dicmeta="IDM00357"/> </td>
										</tr>
										<tr>
											<th style="text-align: center;">红　眼</th>
											<td style="text-align: center;"><ehr:dic-radio name="pinkeyeRight" value="${listFr.pinkeyeRight}" dicmeta="PH00002" code="2,1"/> </td>
											<td style="text-align: center;"><ehr:dic-radio name="pinkeyeLeft" value="${listFr.pinkeyeLeft}" dicmeta="PH00002" code="2,1"/> </td>
										</tr>
										<tr>
											<th style="text-align: center;">眼　痛</th>
											<td style="text-align: center;"><ehr:dic-radio name="ophthalmodyniaRight" value="${listFr.ophthalmodyniaRight}" dicmeta="PH00002" code="2,1"/> </td>
											<td style="text-align: center;"><ehr:dic-radio name="ophthalmodyniaLeft" value="${listFr.ophthalmodyniaLeft}" dicmeta="PH00002" code="2,1"/> </td>
										</tr>
										<tr>
											<th style="text-align: center;">自发性眨眼</th>
											<td style="text-align: center;"><ehr:dic-radio name="blinkRight" value="${listFr.blinkRight}" dicmeta="PH00002" code="2,1"/> </td>
											<td style="text-align: center;"><ehr:dic-radio name="blinkLeft" value="${listFr.blinkLeft}" dicmeta="PH00002" code="2,1"/> </td>
										</tr>
									</thead>
								</table>
								</div>
							</td>
						</tr>
						<tr>
						    <td>手足感觉检查图：</td>
						</tr>
						<tr>
						    <td colspan="4">
						    	<div class="handfoot"/>
						    </td>
						</tr>
						<tr>
							<td colspan="4" style="padding: 0px;">
								<div class="repeattable">
								<table>
									<colgroup>
										<col style="width:10%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
									</colgroup>
									<thead>
										<tr>
											<th style="text-align: center;"></th>
											<th style="text-align: center;">1</th>
											<th style="text-align: center;">2</th>
											<th style="text-align: center;">3</th>
											<th style="text-align: center;">4</th>
											<th style="text-align: center;">5</th>
											<th style="text-align: center;">6</th>
											<th style="text-align: center;">7</th>
											<th style="text-align: center;">8</th>
											<th style="text-align: center;">9</th>
											<th style="text-align: center;">10</th>
										</tr>
										<tr>
											<th style="text-align: center;">右手掌</th>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handRight1" value="${listFr.handRight1}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handRight2" value="${listFr.handRight2}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handRight3" value="${listFr.handRight3}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handRight4" value="${listFr.handRight4}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handRight5" value="${listFr.handRight5}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handRight6" value="${listFr.handRight6}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handRight7" value="${listFr.handRight7}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handRight8" value="${listFr.handRight8}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handRight9" value="${listFr.handRight9}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handRight10" value="${listFr.handRight10}"/></td>
										</tr>
										<tr>
											<th style="text-align: center;">左手掌</th>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handLeft1" value="${listFr.handLeft1}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handLeft2" value="${listFr.handLeft2}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handLeft3" value="${listFr.handLeft3}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handLeft4" value="${listFr.handLeft4}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handLeft5" value="${listFr.handLeft5}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handLeft6" value="${listFr.handLeft6}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handLeft7" value="${listFr.handLeft7}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handLeft8" value="${listFr.handLeft8}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handLeft9" value="${listFr.handLeft9}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="handLeft10" value="${listFr.handLeft10}"/> </td>
										</tr>
										<tr>
											<th style="text-align: center;">右足底</th>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footRight1" value="${listFr.footRight1}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footRight2" value="${listFr.footRight2}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footRight3" value="${listFr.footRight3}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footRight4" value="${listFr.footRight4}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footRight5" value="${listFr.footRight5}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footRight6" value="${listFr.footRight6}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footRight7" value="${listFr.footRight7}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footRight8" value="${listFr.footRight8}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footRight9" value="${listFr.footRight9}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footRight10" value="${listFr.footRight10}"/> </td>
										</tr>
										<tr>
											<th style="text-align: center;">左足底</th>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footLeft1" value="${listFr.footLeft1}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footLeft2" value="${listFr.footLeft2}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footLeft3" value="${listFr.footLeft3}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footLeft4" value="${listFr.footLeft4}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footLeft5" value="${listFr.footLeft5}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footLeft6" value="${listFr.footLeft6}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footLeft7" value="${listFr.footLeft7}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footLeft8" value="${listFr.footLeft8}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footLeft9" value="${listFr.footLeft9}"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox dicmeta="IDM00376" name="footLeft10" value="${listFr.footLeft10}"/> </td>
										</tr>
									</thead>
								</table>
								</div>
							</td>
						</tr>
						<tr>
	                        <td>神经功能检查：</td>
	                    </tr>
	                    <tr>
							<td colspan="4" style="padding: 0px;">
								<div class="repeattable">
								<table>
									<colgroup>
										<col style="width:10%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
									</colgroup>
									<thead>
										<tr>
											<th colspan="1" rowspan="3"></th>
											<th colspan="6" style="text-align: center;">感觉丧失</th>
											<th colspan="10" style="text-align: center;">运动功能丧失</th>
										</tr>
										<tr>
											<th colspan="2" style="text-align: center;">尺N4点</th>
											<th colspan="2" style="text-align: center;">正中N6点</th>
											<th colspan="2" style="text-align: center;">足底10点</th>
											<th colspan="2" style="text-align: center;">睑裂(轻闭)</th>
											<th colspan="2" style="text-align: center;">小指内收</th>
											<th colspan="2" style="text-align: center;">拇指对掌</th>
											<th colspan="2" style="text-align: center;">腕背屈</th>
											<th colspan="2" style="text-align: center;">足背屈</th>
										</tr>
										<tr>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
										</tr>
										<tr>
											<th style="text-align: center;">状态</th>
											<td style="text-align: center;"><input type="text" name="ulnarRightStatus" value="${listFr.ulnarRightStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="ulnarLeftStatus" value="${listFr.ulnarLeftStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="medianRightStatus" value="${listFr.medianRightStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="medianLeftStatus" value="${listFr.medianLeftStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="plantaRightStatus" value="${listFr.plantaRightStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="plantaLeftStatus" value="${listFr.plantaLeftStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="eyelidRightStatus" value="${listFr.eyelidRightStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="eyelidLeftStatus" value="${listFr.eyelidLeftStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="littleFingerRightStatus" value="${listFr.littleFingerRightStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="littleFingerLeftStatus" value="${listFr.littleFingerLeftStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="thumbRightStatus" value="${listFr.thumbRightStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="thumbLeftStatus" value="${listFr.thumbLeftStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="wristRightStatus" value="${listFr.wristRightStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="wristLeftStatus" value="${listFr.wristLeftStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="footRightStatus" value="${listFr.footRightStatus}" reg='{"maxlength":"100"}'> </td>
											<td style="text-align: center;"><input type="text" name="footLeftStatus" value="${listFr.footLeftStatus}" reg='{"maxlength":"100"}'> </td>
										</tr>
										<tr>
											<th style="text-align: center;">月数</th>
											<td style="text-align: center;"><input type="text" name="ulnarRightMonths" value="${listFr.ulnarRightMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="ulnarLeftMonths" value="${listFr.ulnarLeftMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="medianRightMonths" value="${listFr.medianRightMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="medianLeftMonths" value="${listFr.medianLeftMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="plantaRightMonths" value="${listFr.plantaRightMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="plantaLeftMonths" value="${listFr.plantaLeftMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="eyelidRightMonths" value="${listFr.eyelidRightMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="eyelidLeftMonths" value="${listFr.eyelidLeftMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="littleFingerRightMonths" value="${listFr.littleFingerRightMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="littleFingerLeftMonths" value="${listFr.littleFingerLeftMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="thumbRightMonths" value="${listFr.thumbRightMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="thumbLeftMonths" value="${listFr.thumbLeftMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="wristRightMonths" value="${listFr.wristRightMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="wristLeftMonths" value="${listFr.wristLeftMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="footRightMonths" value="${listFr.footRightMonths}" reg='{"maxlength":"20"}'> </td>
											<td style="text-align: center;"><input type="text" name="footLeftMonths" value="${listFr.footLeftMonths}" reg='{"maxlength":"20"}'> </td>
										</tr>
									</thead>
								</table>
								</div>
							</td>
						</tr>
						<tr>
	                    	<th>神经炎发生日期：</th>
	                    	<td><tag:dateInput name="neuritisHappenDt" date="${listFr.neuritisHappenDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                        <th>神经炎确诊日期：</th>
	                        <td><tag:dateInput name="neuritisDiagnosisDt" date="${listFr.neuritisDiagnosisDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                    </tr>
	                     <tr>
						    <th>检查评价：</th>
						    <td colspan="3"><input type="text" name="assessment" value="${listFr.assessment}" reg='{"maxlength":"200"}'/> </td>
						</tr>
	                    <tr>
						    <td>（三）反应</td>
						</tr>
	                    <tr>
	                        <th>随访时反应：</th>
	                        <td colspan="3"><ehr:dic-radio name="impressType" dicmeta="IDM00358" value="${listFr.impressType}"/> </td>
	                    </tr>
	                    <tr>
	                    	<th>反应发生日期：</th>
	                    	<td><tag:dateInput name="reactionHappenDt" date="${listFr.reactionHappenDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                        <th>反应确诊日期：</th>
	                        <td><tag:dateInput name="reactionDiagnosisDt" date="${listFr.reactionDiagnosisDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                    </tr>
	                     <tr>
						    <td>反应描述：</td>
						</tr>
	                    <tr>
	                    	<td colspan="4"> <textarea name="reactionDescription" style="width: 100%" rows="5" reg='{"maxlength":"400"}'>${listFr.reactionDescription}</textarea></td>
	                    </tr>
	                    <tr>
							<td colspan="4" style="padding: 0px;">
								<div class="repeattable">
								<table>
									<colgroup>
										<col style="width:7%;"/>
										<col style="width:4.5%;"/>
										<col style="width:3.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:3.5%;"/>
										<col style="width:3.5%;"/>
										<col style="width:3.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:12%;"/>
										<col style="width:12%;"/>
									</colgroup>
									<thead>
										<tr>
											<th colspan="2" style="text-align: center;">I型反应</th>
											<th colspan="9" style="text-align: center;">II型反应</th>
										</tr>
										<tr>
											<th style="text-align: center;">皮损发红浸润</th>
											<th style="text-align: center;">神经炎</th>
											<th style="text-align: center;">ENL</th>
											<th style="text-align: center;">淋巴结炎</th>
											<th style="text-align: center;">关节炎</th>
											<th style="text-align: center;">神经炎</th>
											<th style="text-align: center;">不适</th>
											<th style="text-align: center;">发热</th>
											<th style="text-align: center;">浮肿</th>
											<th style="text-align: center;">睾丸附睾炎</th>
											<th style="text-align: center;">虹膜睫状体炎</th>
										</tr>
										<tr>
											<td style="text-align: center;"><ehr:dic-checkbox name="skinRubedoInfiltration" value="${listFr.skinRubedoInfiltration}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="neuritis1" value="${listFr.neuritis1}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="enl" value="${listFr.enl}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="lymphatic" value="${listFr.lymphatic}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="arthritis" value="${listFr.arthritis}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="neuritis2" value="${listFr.neuritis2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="discomfort" value="${listFr.discomfort}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="fever" value="${listFr.fever}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="edema" value="${listFr.edema}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="orchiepididymitis" value="${listFr.orchiepididymitis}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="iridocyclitis" value="${listFr.iridocyclitis}" dicmeta="IDM00376"/> </td>
										</tr>
									</thead>
								</table>
								</div>
							</td>
						</tr>
						<tr>
						    <td>（四）畸残</td>
						</tr>
	                    <tr>
	                        <th>随访时畸残：</th>
	                        <td colspan="3">
	                        	<ehr:dic-radio name="deformity" dicmeta="IDM00359" value="${listFr.deformity}"/> 
	                        </td>
	                    </tr>
	                    <tr>
							<td colspan="4" style="padding: 0px;">
								<div class="repeattable">
								<table>
									<colgroup>
										<col style="width:3.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:2%;"/>
										<col style="width:2%;"/>
										<col style="width:5.5%;"/>
										<col style="width:2%;"/>
										<col style="width:2%;"/>
										<col style="width:5.5%;"/>
										<col style="width:2%;"/>
										<col style="width:2%;"/>
										<col style="width:5.5%;"/>
										<col style="width:2%;"/>
										<col style="width:2%;"/>
										<col style="width:5.5%;"/>
										<col style="width:2%;"/>
										<col style="width:2%;"/>
										<col style="width:20%;"/>
									</colgroup>
									<thead>
										<tr>
											<th rowspan="2" style="text-align: center;">级别</th>
											<th colspan="3" style="text-align: center;">眼</th>
											<th colspan="3" style="text-align: center;">手</th>
											<th colspan="3" style="text-align: center;">足</th>
											<th rowspan="2" style="text-align: center;">其他</th>
										</tr>
										<tr>
											<th style="text-align: center;">症　状</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">症　状</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">症　状</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
										</tr>
										<tr>
											<th style="text-align: center;">0级</th>
											<td>正　常</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="eyeRight0" value="${listFr.eyeRight0}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="eyeLeft0" value="${listFr.eyeLeft0}" dicmeta="IDM00376"/> </td>
											<td>正　常</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="handRight0" value="${listFr.handRight0}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="handLeft0" value="${listFr.handLeft0}" dicmeta="IDM00376"/> </td>
											<td>正　常 </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="footRight0" value="${listFr.footRight0}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="footLeft0" value="${listFr.footLeft0}" dicmeta="IDM00376"/> </td>
											<td rowspan="11" style="text-align: center;">
												<ehr:dic-checkbox name="browAllDrop" value="${listFr.browAllDrop}" dicmeta="IDM00376"/>脱眉全脱
												<ehr:dic-checkbox name="browHalfDrop" value="${listFr.browHalfDrop}" dicmeta="IDM00376"/>脱眉半脱 
												<ehr:dic-checkbox name="paralysisHemi" value="${listFr.paralysisHemi}" dicmeta="IDM00376"/>面瘫单侧 
												<ehr:dic-checkbox name="paralysisBilateral" value="${listFr.paralysisBilateral}" dicmeta="IDM00376"/>面瘫双侧 
												<ehr:dic-checkbox name="saddleNose" value="${listFr.saddleNose}" dicmeta="IDM00376"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;鞍鼻 
												<ehr:dic-checkbox name="otherUlcer" value="${listFr.otherUlcer}" dicmeta="IDM00376"/>其他溃疡
											</td>
										</tr>
										<tr>
											<th style="text-align: center;">1级</th>
											<td>角膜感觉障碍</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="corneaRight1" value="${listFr.corneaRight1}" dicmeta="IDM00376"/></td>
											<td style="text-align: center;"><ehr:dic-checkbox name="corneaLeft1" value="${listFr.corneaLeft1}" dicmeta="IDM00376"/> </td>
											<td>保护性感觉障碍</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="feelHandRight1" value="${listFr.feelHandRight1}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="feelHandLeft1" value="${listFr.feelHandLeft1}" dicmeta="IDM00376"/> </td>
											<td>保护性感觉障碍 </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="feelFootRight1" value="${listFr.feelFootRight1}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="feelFootLeft1" value="${listFr.feelFootLeft1}" dicmeta="IDM00376"/> </td>
										</tr>
										<tr>
											<th style="text-align: center;" rowspan="7">2级</th>
											<td>兔眼</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="lagophthalmosRight2" value="${listFr.lagophthalmosRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="lagophthalmosLeft2" value="${listFr.lagophthalmosLeft2}" dicmeta="IDM00376"/> </td>
											<td>爪形手</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="clawhandRight2" value="${listFr.clawhandRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="clawhandLeft2" value="${listFr.clawhandLeft2}" dicmeta="IDM00376"/> </td>
											<td>垂足</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="pedalRight2" value="${listFr.pedalRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="pedalLeft2" value="${listFr.pedalLeft2}" dicmeta="IDM00376"/> </td>
										</tr>
										<tr>
											<td>睑外翻</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="ectropionRight2" value="${listFr.ectropionRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="ectropionLeft2" value="${listFr.ectropionLeft2}" dicmeta="IDM00376"/> </td>
											<td>猿手</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="apeHandRight2" value="${listFr.apeHandRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="apeHandLeft2" value="${listFr.apeHandLeft2}" dicmeta="IDM00376"/> </td>
											<td>皮肤皲裂、伤口</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="skinChappedRight2" value="${listFr.skinChappedRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="skinChappedLeft2" value="${listFr.skinChappedLeft2}" dicmeta="IDM00376"/> </td>
										</tr>
										<tr>
											<td>倒睫</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="trichiasisRight2" value="${listFr.trichiasisRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="trichiasisLeft2" value="${listFr.trichiasisLeft2}" dicmeta="IDM00376"/> </td>
											<td>垂腕</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="wristDropRight2" value="${listFr.wristDropRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="wristDropLeft2" value="${listFr.wristDropLeft2}" dicmeta="IDM00376"/> </td>
											<td>单纯性足底溃疡 </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="volaUlcerRight2" value="${listFr.volaUlcerRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="volaUlcerLeft2" value="${listFr.volaUlcerLeft2}" dicmeta="IDM00376"/> </td>
										</tr>
										<tr>
											<td>暴露性角膜炎</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="keratitisRight2" value="${listFr.keratitisRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="keratitisLeft2" value="${listFr.keratitisLeft2}" dicmeta="IDM00376"/> </td>
											<td>皮肤角化皲裂伤口</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="corChappedRight2" value="${listFr.corChappedRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="corChappedLeft2" value="${listFr.corChappedLeft2}" dicmeta="IDM00376"/> </td>
											<td>复杂性足底溃疡</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="comUlcerRight2" value="${listFr.comUlcerRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="comUlcerLeft2" value="${listFr.comUlcerLeft2}" dicmeta="IDM00376"/> </td>
										</tr>
										<tr>
											<td>虹膜睫状体炎</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="irisRight2" value="${listFr.irisRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="irisLeft2" value="${listFr.irisLeft2}" dicmeta="IDM00376"/> </td>
											<td>手掌溃疡</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="handUlcerRight2" value="${listFr.handUlcerRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="handUlcerLeft2" value="${listFr.handUlcerLeft2}" dicmeta="IDM00376"/> </td>
											<td>爪形趾、马蹄足 </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="talipesRight2" value="${listFr.talipesRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="talipesLeft2" value="${listFr.talipesLeft2}" dicmeta="IDM00376"/> </td>
										</tr>
										<tr>
											<td>视力减退</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="hypopsiaRight2" value="${listFr.hypopsiaRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="hypopsiaLeft2" value="${listFr.hypopsiaLeft2}" dicmeta="IDM00376"/> </td>
											<td>关节强直</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="jointRight2" value="${listFr.jointRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="jointLeft2" value="${listFr.jointLeft2}" dicmeta="IDM00376"/> </td>
											<td>足(趾)短缩或缺失 </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="footCoactuRight2" value="${listFr.footCoactuRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="footCoactuLeft2" value="${listFr.footCoactuLeft2}" dicmeta="IDM00376"/> </td>
										</tr>
										<tr>
											<td>失明</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="blindRight2" value="${listFr.blindRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="blindLeft2" value="${listFr.blindLeft2}" dicmeta="IDM00376"/> </td>
											<td>手(指)短缩或缺失</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="handCoactuRight2" value="${listFr.handCoactuRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="handCoactuLeft2" value="${listFr.handCoactuLeft2}" dicmeta="IDM00376"/> </td>
											<td>截肢</td>
											<td style="text-align: center;"><ehr:dic-checkbox name="amputationRight2" value="${listFr.amputationRight2}" dicmeta="IDM00376"/> </td>
											<td style="text-align: center;"><ehr:dic-checkbox name="amputationLeft2" value="${listFr.amputationLeft2}" dicmeta="IDM00376"/> </td>
										</tr>
										<tr>
											<th style="text-align: center;">EHF</th>
											<td>------</td>
											<td>_ </td>
											<td>_ </td>
											<td>------</td>
											<td>_ </td>
											<td>_ </td>
											<td>------ </td>
											<td>_ </td>
											<td>_ </td>
										</tr>
									</thead>
								</table>
								</div>
							</td>
						</tr>
						<tr>
						    <td>（五）治疗情况</td>
						</tr>
						<tr>
						    <td>1、抗麻风病治疗</td>
						</tr>
	                    <tr>
	                        <th>治疗情况：</th>
	                        <td><ehr:dic-list name="treatCondition" dicmeta="IDM00360" value="${listFr.treatCondition}"/> </td>
	                        <th>治疗方案：</th>
	                        <td>
				            	<ehr:dic-list name="cureScheme" dicmeta="IDM00361" value="${listFr.cureScheme}"
				                 onchange="toggleOtherSC('cureScheme','cureSchemeOther',99)" />
			                     <span id="cureSchemeOther" style="display: none;">
			                     	<input type="text" name="cureSchemeOther" value="${listFr.cureSchemeOther}"
			                     	 reg='{"maxlength":"100"}' style="width: 36%"/>
			                     </span>
				            </td>
	                    </tr>
	                     <tr>
	                    	<th>开始治疗日期：</th>
	                    	<td><tag:dateInput name="leprosyBeginDt" date="${listFr.leprosyBeginDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                        <th>完成治疗日期：</th>
	                        <td><tag:dateInput name="leprosyBeginDt" date="${listFr.leprosyBeginDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                    </tr>
	                    <tr>
	                        <th>疗效评价：</th>
	                        <td><ehr:dic-radio name="leprosyEffect" dicmeta="IDM00362" value="${listFr.leprosyEffect}"/></td>
	                        <th>治疗地点：</th>
	                        <td>
				            	<ehr:dic-radio name="cureAddress" dicmeta="IDM00140" value="${listFr.cureAddress}" code="2,6"/>
				            </td>
	                    </tr>
	                    <tr>
						    <td>治疗说明：</td>
						</tr>
	                    <tr>
	                    	<td colspan="4"> <textarea name="leprosyExplain" style="width: 100%" rows="5" reg='{"maxlength":"200"}'>${listFr.leprosyExplain}</textarea></td>
	                    </tr>
	                    <tr>
						    <td>2、神经炎治疗</td>
						</tr>
						<tr>
	                    	<th>开始治疗日期：</th>
	                    	<td><tag:dateInput name="neuritisBeginDt" date="${listFr.neuritisBeginDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                        <th>完成治疗日期：</th>
	                        <td><tag:dateInput name="neuritisEndDt" date="${listFr.neuritisEndDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                    </tr>
	                    <tr>
	                        <th>疗效评价：</th>
	                        <td colspan="3">
				            	<ehr:dic-radio name="neuritisEffect" dicmeta="IDM00362" value="${listFr.neuritisEffect}"/>
				            </td>
	                    </tr>
	                    <tr>
	                        <th>第一治疗药物：</th>
	                        <td colspan="3">
				            	<ehr:dic-radio name="neuritis1Drug" dicmeta="IDM00363" value="${listFr.neuritis1Drug}"
				            	onchange="toggleOther('neuritis1Drug','neuritis1DrugOth',99)" />
			                     <span id="neuritis1DrugOth" style="display: none;">
			                     	<input type="text" name="neuritis1DrugOth" value="${listFr.neuritis1DrugOth}"
			                     	 reg='{"maxlength":"100"}' style="width: 36%"/>
			                     </span>
				            </td>
	                    </tr>
	                    <tr>
	                        <th>第二治疗药物：</th>
	                        <td colspan="3">
				            	<ehr:dic-radio name="neuritis2Drug" dicmeta="IDM00363" value="${listFr.neuritis2Drug}"
				            		onchange="toggleOther('neuritis2Drug','neuritis2DrugOth',99)" />
			                     <span id="neuritis2DrugOth" style="display: none;">
			                     	<input type="text" name="neuritis2DrugOth" value="${listFr.neuritis2DrugOth}"
			                     	 reg='{"maxlength":"100"}' style="width: 36%"/>
			                     </span>
				            </td>
	                    </tr>
	                    <tr>
	                        <th>第三治疗药物：</th>
	                        <td colspan="3">
				            	<ehr:dic-radio name="neuritis3Drug" dicmeta="IDM00363" value="${listFr.neuritis3Drug}"
				            	onchange="toggleOther('neuritis3Drug','neuritis3DrugOth',99)" />
			                     <span id="neuritis3DrugOth" style="display: none;">
			                     	<input type="text" name="neuritis3DrugOth" value="${listFr.neuritis3DrugOth}"
			                     	 reg='{"maxlength":"100"}' style="width: 36%"/>
			                     </span>
				            </td>
	                    </tr>
	                    <tr>
						    <td>治疗说明：</td>
						</tr>
	                    <tr>
	                    	<td colspan="4"> <textarea name="neuritisExplain" style="width: 100%" rows="5" reg='{"maxlength":"400"}'>${listFr.neuritisExplain}</textarea></td>
	                    </tr>
	                    <tr>
	                        <th>功能评价：</th>
	                        <td colspan="3">
				            	<ehr:dic-radio name="functionEvaluation" dicmeta="IDM00364" value="${listFr.functionEvaluation}"/>
				            </td>
	                    </tr>
	                    <tr>
						    <td>3、反应治疗</td>
						</tr>
						<tr>
	                    	<th>开始治疗日期：</th>
	                    	<td><tag:dateInput name="reactionBeginDt" date="${listFr.reactionBeginDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                        <th>完成治疗日期：</th>
	                        <td><tag:dateInput name="reactionEndDt" date="${listFr.reactionEndDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                    </tr>
	                    <tr>
	                        <th>疗效评价：</th>
	                        <td colspan="3">
				            	<ehr:dic-radio name="reactionEffect" dicmeta="IDM00362" value="${listFr.reactionEffect}"/>
				            </td>
	                    </tr>
	                    <tr>
	                        <th>第一治疗药物：</th>
	                        <td colspan="3">
				            	<ehr:dic-radio name="reaction1Drug" dicmeta="IDM00363" value="${listFr.reaction1Drug}"
				            	onchange="toggleOther('reaction1Drug','reaction1DrugOth',99)" />
			                     <span id="reaction1DrugOth" style="display: none;">
			                     	<input type="text" name="reaction1DrugOth" value="${listFr.reaction1DrugOth}"
			                     	 reg='{"maxlength":"100"}' style="width: 36%"/>
			                     </span>
				            </td>
	                    </tr>
	                    <tr>
	                        <th>第二治疗药物：</th>
	                        <td colspan="3">
				            	<ehr:dic-radio name="reaction2Drug" dicmeta="IDM00363" value="${listFr.reaction2Drug}"
				            	onchange="toggleOther('reaction2Drug','reaction2DrugOth',99)" />
			                     <span id="reaction2DrugOth" style="display: none;">
			                     	<input type="text" name="reaction2DrugOth" value="${listFr.reaction2DrugOth}"
			                     	 reg='{"maxlength":"100"}' style="width: 36%"/>
			                     </span>
				            </td>
	                    </tr>
	                    <tr>
	                        <th>第三治疗药物：</th>
	                        <td colspan="3">
				            	<ehr:dic-radio name="reaction3Drug" dicmeta="IDM00363" value="${listFr.reaction3Drug}"
				            	onchange="toggleOther('reaction3Drug','reaction3DrugOth',99)" />
			                     <span id="reaction3DrugOth" style="display: none;">
			                     	<input type="text" name="reaction3DrugOth" value="${listFr.reaction3DrugOth}"
			                     	 reg='{"maxlength":"100"}' style="width: 36%"/>
			                     </span>
				            </td>
	                    </tr>
	                   <tr>
						    <td>治疗说明：</td>
						</tr>
	                    <tr>
	                    	<td colspan="4"><textarea name="reactionExplain" style="width: 100%" rows="5" reg='{"maxlength":"400"}'>${listFr.reactionExplain}</textarea></td>
	                    </tr>
	                    <tr>
						    <td>（六）病程记录</td>
						</tr>
						<tr>
	                    	<td colspan="4"> <textarea name="progressNote" style="width: 100%" rows="5" reg='{"maxlength":"4000"}'>${listFr.progressNote}</textarea></td>
	                    </tr>
	                    <tr>
	                    	<th>医师签名：</th>
	                    	<td colspan="2"><input type="text" name="minDoctorName" value="${listFr.minDoctorName}" reg='{"maxlength":"100"}'/></td>
	                    </tr>
	                </table>
	            </fieldset>
	            <fieldset style="margin-top: 10px">
	            	<legend>三、专项随访（1）</legend>
		            <table class="posttable">
	                    <colgroup>
							<col style="width: 15%" />
							<col style="width: 35%" />
							<col style="width: 15%" />
							<col style="width: 55%" />
						</colgroup>
	                    <tr>
	                    	<td>（一）实验室检查</td>
	                    </tr>
	                    <tr>
	                    	<td>1、查菌</td>
	                    </tr>
	                    <tr>
	                    	<th>随访时查菌</th>
	                    	<td><ehr:dic-radio name="checkFungus" dicmeta="PH00004" value="${listFr.checkFungus}" code="1,2,3"/></td>
	                    	<th>查菌日期：</th>
	                        <td><tag:dateInput name="fungusDt" date="${listFr.fungusDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                    </tr>
	                    <tr>
	                    	<th>查菌单位性质</th>
	                    	<td colspan="3"><ehr:dic-radio name="fungusUnitProperty" dicmeta="IDM00365" value="${listFr.fungusUnitProperty}"/><br/>(具体为:<ehr:dic-radio name="fungusUnitPropertyDetail" dicmeta="IDM00366" value="${listFr.fungusUnitPropertyDetail}"/>)</td>
	                    </tr>
	                    <tr>
							<td colspan="4" style="padding: 0px;">
								<div class="repeattable">
								<table>
									<colgroup>
										<col style="width:10%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
									</colgroup>
									<thead>
										<tr>
											<th rowspan="2" style="text-align: center;">部位</th>
											<th colspan="2" style="text-align: center;">眶上</th>
											<th colspan="2" style="text-align: center;">耳垂</th>
											<th rowspan="2" style="text-align: center;">下颌</th>
											<th colspan="3" style="text-align: center;">皮损</th>
											<th rowspan="2" style="text-align: center;">BI</th>
											<th rowspan="2" style="text-align: center;">MI</th>
										</tr>
										<tr>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">_</th>
											<th style="text-align: center;">_</th>
											<th style="text-align: center;">_</th>
										</tr>
										<tr>
											<th style="text-align: center;">结果</th>
											<td><input type="text" name="orbitRight" value="${listFr.orbitRight}" reg='{"maxlength":"20"}'> </td>
											<td><input type="text" name="orbitLeft" value="${listFr.orbitLeft}" reg='{"maxlength":"20"}'> </td>
											<td><input type="text" name="earRight" value="${listFr.earRight}" reg='{"maxlength":"20"}'> </td>
											<td><input type="text" name="earLeft" value="${listFr.earLeft}" reg='{"maxlength":"20"}'> </td>
											<td><input type="text" name="mandible" value="${listFr.mandible}" reg='{"maxlength":"20"}'> </td>
											<td><input type="text" name="skinDown1" value="${listFr.skinDown1}" reg='{"maxlength":"20"}'> </td>
											<td><input type="text" name="skinDown2" value="${listFr.skinDown2}" reg='{"maxlength":"20"}'> </td>
											<td><input type="text" name="skinDown3" value="${listFr.skinDown3}" reg='{"maxlength":"20"}'> </td>
											<td><input type="text" name="BI" value="${listFr.BI}" reg='{"maxlength":"20"}'> </td>
											<td><input type="text" name="MI" value="${listFr.MI}" reg='{"maxlength":"20"}'> </td>
										</tr>
									</thead>
								</table>
								</div>
							</td>
						</tr>
	                    <tr>
	                    	<td>2、病理</td>
	                    </tr>
	                     <tr>
	                    	<th>随访时病理</th>
	                    	<td colspan="3"><ehr:dic-radio name="pathology" dicmeta="IDM00375" value="${listFr.pathology}"/></td>
	                    </tr>
	                    <tr>
	                    	<th>取材日期</th>
	                    	<td><tag:dateInput name="materialsDt" date="${listFr.materialsDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                    	<th>取材部位：</th>
	                        <td><input type="text" name="materialsPart" value="${listFr.materialsPart}" reg='{"maxlength":"100"}'/></td>
	                    </tr>
	                    <tr>
	                    	<th>抗酸杆菌检查</th>
	                    	<td colspan="3"><input type="text" name="bacilliCheck" value="${listFr.bacilliCheck}" reg='{"maxlength":"100"}'/></td>
	                    </tr>
	                    <tr>
	                    	<th>检查单位性质</th>
	                    	<td colspan="3"><ehr:dic-radio name="bacilliUnitPro" dicmeta="IDM00365" value="${listFr.bacilliUnitPro}"/><br/>(具体为:<ehr:dic-radio name="bacilliUnitProDetail" dicmeta="IDM00366" value="${listFr.bacilliUnitProDetail}"/>)</td>
	                    </tr>
	                    <tr>
						    <td>病理描述：</td>
						</tr>
						<tr>
	                    	<td colspan="4"> <textarea name="pathologyExplain" style="width: 100%" rows="5" reg='{"maxlength":"400"}'>${listFr.pathologyExplain}</textarea></td>
	                    </tr>
	                    <tr>
	                    	<td>3、其他实验室检查</td>
	                    </tr>
	                    <tr>
	                    	<th>血常规：</th>
	                    	<td><ehr:dic-radio name="bloodRoutine" dicmeta="PH00003" value="${listFr.bloodRoutine}"/></td>
	                    	<th>尿常规：</th>
	                    	<td><ehr:dic-radio name="pissRoutine" dicmeta="PH00003" value="${listFr.pissRoutine}"/></td>
	                    </tr>
	                    <tr>
	                    	<th>粪常规：</th>
	                    	<td><ehr:dic-radio name="fecesRoutine" dicmeta="PH00003" value="${listFr.fecesRoutine}"/></td>
	                    	<th>肝功能：</th>
	                    	<td><ehr:dic-radio name="liverFunction" dicmeta="PH00003" value="${listFr.liverFunction}"/></td>
	                    </tr>
	                    <tr>
	                    	<th>肾功能：</th>
	                    	<td><ehr:dic-radio name="renalFunction" dicmeta="PH00003" value="${listFr.renalFunction}"/></td>
	                    	<th>其　他：</th>
	                    	<td><ehr:dic-radio name="otherCheck" dicmeta="PH00003" value="${listFr.otherCheck}"/></td>
	                    </tr>
	                    <tr>
						    <td>异常描述：</td>
						</tr>
						<tr>
	                    	<td colspan="4"> <textarea name="exceptionDescrip" style="width: 100%" rows="5" reg='{"maxlength":"400"}'>${listFr.exceptionDescrip}</textarea></td>
	                    </tr>
	                    <tr>
	                    	<td>（二）畸残预防</td>
	                    </tr>
	                    <tr>
	                    	<th>防护措施：</th>
	                    	<td><ehr:dic-list name="precaution" dicmeta="IDM00367" value="${listFr.precaution}"/></td>
	                    	<th>发防护鞋日期：</th>
	                    	<td><tag:dateInput name="shoeDt" date="${listFr.shoeDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                    </tr>
	                    <tr>
	                    	<th>发防护鞋双数：</th>
	                        <td><input type="text" name="shoeCount" value="${listFr.shoeCount}" reg='{"maxlength":"20"}'/></td>
	                        <th>穿鞋频率：</th>
	                        <td><input type="text" name="shoeFrequency" value="${listFr.shoeFrequency}" reg='{"maxlength":"20"}'/></td>
	                    </tr>
	                    <tr>
	                    	<th>安装假肢需求：</th>
	                    	<td><ehr:dic-radio name="artificialLimb" dicmeta="IDM00368" value="${listFr.artificialLimb}"/></td>
	                    	<th>维修假肢需求：</th>
	                    	<td><ehr:dic-radio name="maintainLimb" dicmeta="IDM00368" value="${listFr.maintainLimb}"/></td>
	                    </tr>
	                    <tr>
						    <td>手术需求：</td>
						</tr>
	                    <tr>
							<td colspan="4" style="padding: 0px;">
								<div class="repeattable">
								<table>
									<colgroup>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:4.5%;"/>
										<col style="width:5.5%;"/>
										<col style="width:5.5%;"/>
									</colgroup>
									<thead>
										<tr>
											<th rowspan="1" colspan="2" style="text-align: center;">兔眼</th>
											<th rowspan="1" colspan="2" style="text-align: center;">睑内外翻</th>
											<th rowspan="1" colspan="2" style="text-align: center;">白内障</th>
											<th rowspan="1" colspan="2" style="text-align: center;">面瘫</th>
											<th rowspan="1" colspan="2" style="text-align: center;">爪形手</th>
											<th rowspan="1" colspan="2" style="text-align: center;">猿手</th>
											<th rowspan="1" colspan="2" style="text-align: center;">垂腕</th>
											<th rowspan="1" colspan="2" style="text-align: center;">垂足</th>
											<th rowspan="1" colspan="2" style="text-align: center;">截肢</th>
											<th rowspan="1" colspan="2" style="text-align: center;">溃疡清创</th>
										</tr>
										<tr>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
											<th style="text-align: center;">右</th>
											<th style="text-align: center;">左</th>
										</tr>
										<tr>
											<td><ehr:dic-checkbox name="opsRabbitRight" value="${listFr.opsRabbitRight}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsRabbitLeft" value="${listFr.opsRabbitLeft}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsEctropionRight" value="${listFr.opsEctropionRight}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsEctropionLeft" value="${listFr.opsEctropionLeft}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsCataractRight" value="${listFr.opsCataractRight}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsCataractLeft" value="${listFr.opsCataractLeft}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsParalysisRight" value="${listFr.opsParalysisRight}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsParalysisLeft" value="${listFr.opsParalysisLeft}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsClawhandRight" value="${listFr.opsClawhandRight}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsClawhandLeft" value="${listFr.opsClawhandLeft}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsApehandRight" value="${listFr.opsApehandRight}" dicmeta="IDM00376"/></td>
											<td><ehr:dic-checkbox name="opsApehandLeft" value="${listFr.opsApehandLeft}" dicmeta="IDM00376"/></td>
											<td><ehr:dic-checkbox name="opsWristDropRight" value="${listFr.opsWristDropRight}" dicmeta="IDM00376"/></td>
											<td><ehr:dic-checkbox name="opsWristDropLeft" value="${listFr.opsWristDropLeft}" dicmeta="IDM00376"/></td>
											<td><ehr:dic-checkbox name="opsPedalRight" value="${listFr.opsPedalRight}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsPedalLeft" value="${listFr.opsPedalLeft}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsAmputationRight" value="${listFr.opsAmputationRight}" dicmeta="IDM00376"/></td>
											<td><ehr:dic-checkbox name="opsAmputationLeft" value="${listFr.opsAmputationLeft}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsUlcerRight" value="${listFr.opsUlcerRight}" dicmeta="IDM00376"/> </td>
											<td><ehr:dic-checkbox name="opsUlcerLeft" value="${listFr.opsUlcerLeft}" dicmeta="IDM00376"/> </td>
										</tr>
									</thead>
								</table>
								</div>
							</td>
						</tr>
	                    <tr>
						    <td>方案说明：</td>
						</tr>
						<tr>
	                    	<td colspan="4"> <textarea name="schemeExplain" style="width: 100%" rows="5" reg='{"maxlength":"400"}'>${listFr.schemeExplain}</textarea></td>
	                    </tr>
	                    <tr>
	                    	<td colspan="3">
				                <b style="margin: 15px;">（三）密切接触者（家属）健康检查：</b>
				                <a href="javascript:followup.popup('','','${listFr.id}')" id="popupMedication" ><b class="xinz" style="padding-left: 20px;">添加</b></a>
				            </td>
				        </tr>
				        <tr>
				            <td colspan="4">
				                <div class="repeattable">
				                    <table id="contanctTable">
				                        <thead>
				                        <tr>
				                            <th class="centerth" style="width: 100px;">姓名</th>
				                            <th class="centerth" style="width: 60px;">性别</th>
				                            <th class="centerth" style="width: 60px;">出生日期</th>
				                            <th class="centerth" style="width: 60px;">与患者关系</th>
				                            <th class="centerth" style="width: 60px;">接触月数</th>
				                            <th class="centerth" >接触频率</th>
				                            <th class="centerth" >检查结果</th>
				                            <th class="centerth" style="width: 70px;">操作</th>
				                        </tr>
				                        </thead>
				                        <tbody>
											<c:forEach var="contact" items="${listFr.listCcs}" varStatus="status">
												<tr item="${status.count}">
													<td field="closeName"><ehr:tip>${contact.closeName}</ehr:tip></td>
													<td field="sexText"><ehr:tip><ehr:dic code="${contact.sex}" dicmeta="GBT226112003"/> </ehr:tip></td>
													<td field="birthday"><fmt:formatDate value="${contact.birthday}" pattern="yyyy/MM/dd" /></td>
													<td field="closeDetailText">
														<span id="closeDetail1" style="${contact.closeType == '1' ? '' : 'display:none;'}">
															<ehr:tip><ehr:dic code="${contact.closeDetail}" dicmeta="IDM00055"/> </ehr:tip>
								                        </span>
								                        <span id="closeDetail2" style="${contact.closeType == '2' ? '' : 'display:none;'}">
								                        	<ehr:tip><ehr:dic code="${contact.checkSympton}" dicmeta="IDM00057"/> </ehr:tip>
								                        </span>
													</td>
													<td field="closeMonths"><ehr:tip>${contact.closeMonths}</ehr:tip></td>
													<td field="closeFrequency"><ehr:tip>${contact.closeFrequency}</ehr:tip></td>
													<td field="diagnosisResultText"><ehr:dic code="${contact.diagnosisResult}" dicmeta="IDM00369"/></td>
													<td field="sex" style="display: none;">${contact.sex}</td>
													<td field="diagnosisResult" style="display: none;">${contact.diagnosisResult}</td>
													<td field="closeType" style="display: none;">${contact.closeType}</td>
													<td field="closeDetail" style="display: none;">${contact.closeDetail}</td>
													<td field="checkSympton" style="display: none;">${contact.checkSympton}</td>
													<td class="btnsublist" field="btn">
														<a href="javascript:void(0)" onclick="followup.popup(this,'edit','${contact.id}')">修改</a>				
														<a href="javascript:void(0)" onclick="idmCommon.removeTr(this);" >删除</a>
													</td>											
												</tr>
											</c:forEach>
				                        </tbody>
				                    </table>
				                </div>
				            </td>
				        </tr>
	                </table>
	            </fieldset>
	            <fieldset style="margin-top: 10px">
	            	<legend>四、专项检查（2）</legend>
		            <table class="posttable">
	                    <colgroup>
							<col style="width: 15%" />
							<col style="width: 35%" />
							<col style="width: 15%" />
							<col style="width: 55%" />
						</colgroup>
						<tr>
							<td>（一）药物不良反应</td>
						</tr>
	                    <tr>
	                    	<th>出现日期：</th>
	                    	<td><tag:dateInput name="uneffectHappenDt" date="${listFr.uneffectHappenDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                        <th>确诊日期：</th>
	                        <td><tag:dateInput name="uneffectDiagDt" date="${listFr.uneffectDiagDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                    </tr>
	                    <tr>
	                    	<th>发生反应的药物：</th>
	                    	<td>
	                    		<ehr:dic-list name="uneffectDrug" dicmeta="IDM00370" value="${listFr.uneffectDrug}"
	                    			onchange="toggleOtherSC('uneffectDrug','uneffectDrugOther',99)" />
			                     <span id="uneffectDrugOther" style="display: none;">
			                     	<input type="text" name="uneffectDrugOther" value="${listFr.uneffectDrugOther}"
			                     	 reg='{"maxlength":"100"}' style="width: 36%"/>
			                     </span>
	                    	
	                    	</td>
	                        <th>诊断：</th>
	                        <td><input type="text" name="uneffectDiag" value="${listFr.uneffectDiag}" reg='{"maxlength":"100"}'/></td>
	                    </tr>
	                    <tr>
	                    	<th>治疗措施：</th>
	                    	<td colspan="3">
	                    		<ehr:dic-radio name="cureStep" dicmeta="IDM00371" value="${listFr.cureStep}"
	                    			onchange="toggleOther('cureStep','cureStepOther',99)" />
			                     <span id="cureStepOther" style="display: none;">
			                     	<input type="text" name="cureStepOther" value="${listFr.cureStepOther}"
			                     	 reg='{"maxlength":"100"}' style="width: 16%"/>
			                     </span>
	                    	</td>
	                    </tr>
	                    <tr>
						    <td>治疗措施说明：</td>
						</tr>
						<tr>
	                    	<td colspan="4"> <textarea name="cureStepExplain" style="width: 100%" rows="5" reg='{"maxlength":"400"}'>${listFr.cureStepExplain}</textarea></td>
	                    </tr>
	                    <tr>
	                    	<th>治疗单位级别：</th>
	                    	<td colspan="3"><ehr:dic-radio name="cureUnitProperty" dicmeta="IDM00372" value="${listFr.cureUnitProperty}"/> </td>
	                    </tr>
	                    <tr>
	                    	<th>不良反应结果：</th>
	                    	<td><ehr:dic-radio name="uneffectResult" dicmeta="IDM00353" value="${listFr.uneffectResult}"/> </td>
	                        <th>转归日期：</th>
	                        <td><tag:dateInput name="lapseDt" date="${listFr.lapseDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                    </tr>
	                    <tr>
						    <td>不良反应描述：</td>
						</tr>
						<tr>
	                    	<td colspan="4"> <textarea name="uneffectExplain" style="width: 100%" rows="5" reg='{"maxlength":"400"}'>${listFr.uneffectExplain}</textarea></td>
	                    </tr>
	                    <tr>
							<td>（二）死因调查</td>
						</tr>
						<tr>
	                    	<th>死亡日期：</th>
	                    	<td><tag:dateInput name="dieDt" date="${listFr.dieDt}"
								 	nullToToday="true" onlypast="true" pattern="yyyy/MM/dd"/></td>
	                        <th>死亡原因：</th>
	                        <td>
	                        	<ehr:dic-list name="dieReason" dicmeta="IDM00373" value="${listFr.dieReason}"
		                        	onchange="toggleOtherSC('dieReason','dieReasonOther',99)" />
				                     <span id="dieReasonOther" style="display: none;">
				                     	<input type="text" name="dieReasonOther" value="${listFr.dieReasonOther}"
				                     	 reg='{"maxlength":"100"}' style="width: 30%"/>
				                     </span> 
	                        </td>
	                    </tr>
	                    <tr>
						    <td>死亡情况说明：</td>
						</tr>
						<tr>
	                    	<td colspan="4"> <textarea name="dieExplain" style="width: 100%" rows="5" reg='{"maxlength":"400"}'>${listFr.dieExplain}</textarea></td>
	                    </tr>
	                </table>
	            </fieldset>
                <table class="posttable">
                    <colgroup>
                        <col style="width: 15%" />
                        <col style="width: 85%" />
                    </colgroup>
                    <tr>
                        <th>医师签名：</th>
                        <td><input type="text" name="doctorName" value="${listFr.doctorName}" reg='{"maxlength":"100"}'/></td>
                    </tr>
                </table>
            </form>
            </fieldset>