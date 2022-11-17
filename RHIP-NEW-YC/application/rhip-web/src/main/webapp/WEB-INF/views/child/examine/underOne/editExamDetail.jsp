<%--
  Created by IntelliJ IDEA.
  User: jingqiu
  Date: 17-3-25
  Time: 上午10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        //执行一个laydate实例
        laydate.render({
            elem: '#visitDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
        });

        //执行一个laydate实例
        laydate.render({
            elem: '#nextSupervisionDate'
            ,format: 'yyyy/MM/dd'
            ,trigger: 'click'
        });
    });
</script>

<fieldset>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tbody>
        <tr>
            <th><label class="required">体检机构</label></th>
            <td>
                <tag:autoSelect name="checkOrganCode" id="checkOrganCode" reg="{'required':'true'}"
                                codeValue="${exam.checkOrganCode}" style="width:180px" />
            </td>
        </tr>
        <tr>
            <th><label class="required">随访日期</label></th>
            <td>
                <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                       name="visitDate" id="visitDate"
                       value="<fmt:formatDate value='${exam.visitDate}' pattern='yyyy/MM/dd'/>"
                       style="padding-left: 0px;"/>
            </td>
            <th><label class="required">体重</label></th>
            <td>
                <tag:numberInput point="point" name="bodyWeight" value="${exam.bodyWeight}"
                                 reg="{'max':'999.99','required':'true'}"
                                 style="width: 100px;"/>kg
                <ehr:dic-radio name="evaluationresultcode" dicmeta="CV0510006" code="1,2,3"
                               value="${exam.evaluationresultcode}"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">身长</label></th>
            <td>
                <tag:numberInput point="point" name="stature" value="${exam.stature}"
                                 reg="{'max':'999.9','required':'true'}"
                                 style="width: 100px;"/>cm
                <ehr:dic-radio name="heightEvaluationResult" dicmeta="CV0510006" code="1,2,3" reg="{'required':'true'}"
                               value="${exam.heightEvaluationResult}"/>

            </td>
            <th><label class="required">头围</label></th>
            <td><tag:numberInput point="point" name="headCircumference" value="${exam.headCircumference}"
                                 reg="{'max':'999.9','required':'true'}" style="width: 100px;"/>cm
            </td>
        </tr>
        </tbody>
    </table>
</fieldset>
<fieldset>
    <legend>体格检查</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tbody>
        <tr>
            <th><label class="required">面色</label></th>
            <td>
                <c:choose>
                    <c:when test="${'满月' eq examAge or '3月龄' eq examAge}">
                        <ehr:dic-radio name="childrenComplexionCode" dicmeta="CV0410008" code="1,2,9" reg="{'required':'true'}"
                                       value="${exam.childrenComplexionCode}"/>
                    </c:when>
                    <c:otherwise>
                        <ehr:dic-radio name="childrenComplexionCode" dicmeta="CV0410008" code="1,9" reg="{'required':'true'}"
                                       value="${exam.childrenComplexionCode}"/>
                    </c:otherwise>
                </c:choose>
                <input type="text" id="complexionOther" name="complexionOther" value="${exam.complexionOther}" 
                        reg="{'maxlength':'100','required':'true'}" style="width: 130px;display: ${'9' eq exam.childrenComplexionCode ? '' : 'none'}"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">皮肤</label></th>
            <td>
                <ehr:dic-radio name="skinInspectionAnomalySign" dicmeta="FS10046" reg="{'required':'true'}"
                               value="${exam.skinInspectionAnomalySign}" />
                <input type="text" id="skinInspectionAnomalyDesc" name="skinInspectionAnomalyDesc"
                       value="${exam.skinInspectionAnomalyDesc}"
                       reg="{'maxlength':'50','required':'true'}"
                       style="width: 130px;display: ${'2' eq exam.skinInspectionAnomalySign ? '' : 'none'}">
            </td>
        </tr>
        <tr>
            <th><label class="required">前囟</label></th>
            <td>
            <ehr:dic-radio dicmeta="CV0410018" code="10,11" reg="{'required':'true'}"
								name="afClosureFlag"
								value='${exam.afClosureFlag}' />
                <%-- <input type="radio" name="afClosureFlag"  reg="{'required':'true'}"
                       value="1" ${"１" eq exam.afClosureFlag ? 'checked' : ''}/>闭合
                <input type="radio" name="afClosureFlag" reg="{'required':'true'}"
                       value="0" ${"0" eq exam.afClosureFlag ? 'checked' : ''}/>未闭合 --%>
                <span id="teethDiameter" ${"11" eq exam.afClosureFlag ? '' : 'hidden'}>
                    <tag:numberInput point="point" id="afTransverseDiameter" name="afTransverseDiameter"
                                     reg="{'max':'9.9','required':'true'}"
                                     style="width: 40px;"
                                     value="${exam.afTransverseDiameter}"/>cm × <tag:numberInput point="point"
                                                                                                 id="bregmaDiameter"
                                                                                                 name="bregmaDiameter"
                                                                                                 value="${exam.bregmaDiameter}"
                                                                                                 reg="{'max':'9.9','required':'true'}"
                                                                                                 style="width: 40px;"/>cm
                </span>
            </td>
        </tr>
        <tr>
            <c:if test="${'8月龄' ne examAge}">
                <th><label class="required">颈部包块</label></th>
                <td><ehr:dic-radio name="neckLumpSign" dicmeta="PH00002" code="1,2"  reg="{'required':'true'}"
                                   value="${exam.neckLumpSign}"/></td>
            </c:if>
        </tr>
        <tr>
            <th><label class="required">眼睛</label></th>
            <td>
                <ehr:dic-radio name="eyeappearanceSign" dicmeta="FS10046" reg="{'required':'true'}"
                               value="${exam.eyeappearanceSign}"/>
                <input type="text" id="eyeAppearanceInspectionDesc" name="eyeAppearanceInspectionDesc"
                       value="${exam.eyeAppearanceInspectionDesc}"
                       reg="{'maxlength':'50','required':'true'}"
                       style="width: 130px;display: ${'2' eq exam.eyeappearanceSign ? '' : 'none'}">
            </td>
        </tr>
        <tr>
            <th><label class="required">耳</label></th>
            <td>
                <ehr:dic-radio name="earappearanceSign" dicmeta="FS10046" reg="{'required':'true'}"
                               value="${exam.earappearanceSign}"/>
                <input type="text" id="earappearanceDesc" name="earappearanceDesc"
                       value="${exam.earappearanceDesc}"
                       reg="{'maxlength':'50','required':'true'}"
                       style="width: 130px;display: ${'2' eq exam.earappearanceSign ? '' : 'none'}">
            </td>
        </tr>
        <tr>
            <th><label class="required">口腔</label></th>
            <td>
                <c:if test="${'满月' eq examAge or '3月龄' eq examAge}">
                    <ehr:dic-radio name="oralExamination" dicmeta="FS10046" value="${exam.oralExamination}" reg="{'required':'true'}"/>
                    <input type="text" id="oralExaminationDesc" name="oralExaminationDesc"
                           value="${exam.oralExaminationDesc}"
                           reg="{'maxlength':'50','required':'true'}"
                           style="width: 130px;display: ${'2' eq exam.oralExamination ? '' : 'none'}">
                </c:if>
                <c:if test="${'6月龄' eq examAge or '8月龄' eq examAge}">
                    出牙数: <tag:numberInput name="teethNumber" value="${exam.teethNumber}"
                                          reg="{'max':'99','required':'true'}" style="width: 50px;"/>颗
                </c:if>
            </td>
        </tr>
        <tr>
            <c:if test="${'6月龄' eq examAge}">
                <th><label class="required">听力</label></th>
                <td><ehr:dic-radio name="hearingScreeningResults" dicmeta="MH00055" code="1,2" reg="{'required':'true'}"
                                   value="${exam.hearingScreeningResults}"/></td>
            </c:if>
        </tr>
        <tr>
            <th><label class="required">胸部</label></th>
            <td>
                <ehr:dic-radio name="heartLungAnomalySign" dicmeta="FS10046" reg="{'required':'true'}"
                               value="${exam.heartLungAnomalySign}"/>
                <input type="text" id="heartLungAnomalyDesc" name="heartLungAnomalyDesc"
                       value="${exam.heartLungAnomalyDesc}"
                       reg="{'maxlength':'50','required':'true'}"
                       style="width: 130px;display: ${'2' eq exam.heartLungAnomalySign ? '' : 'none'}">
            </td>
        </tr>
        <tr>
            <th><label class="required">腹部</label></th>
            <td>
                <ehr:dic-radio name="abdominalPalp" dicmeta="FS10046" value="${exam.abdominalPalp}" reg="{'required':'true'}"/>
                <input type="text" id="abdominalPalpAnomalyDesc" name="abdominalPalpAnomalyDesc"
                       value="${exam.abdominalPalpAnomalyDesc}"
                       reg="{'maxlength':'50','required':'true'}"
                       style="width: 130px;display: ${'2' eq exam.abdominalPalp ? '' : 'none'}">
            </td>
        </tr>
        <tr>
            <th><label class="required">四肢</label></th>
            <td>
                <ehr:dic-radio name="limbActivityAnomalySign" dicmeta="FS10046" reg="{'required':'true'}"
                               value="${exam.limbActivityAnomalySign}"/>
                <input type="text" id="limbActivityDesc" name="limbActivityDesc"
                       value="${exam.limbActivityDesc}"
                       reg="{'maxlength':'50','required':'true'}"
                       style="width: 130px;display: ${'2' eq exam.limbActivityAnomalySign ? '' : 'none'}">
            </td>
        </tr>
        <tr>
            <c:if test="${'满月' eq examAge}">
                <th><label class="required">脐部</label></th>
                <td>
                    <ehr:dic-radio name="umbilicalCordCheck" dicmeta="CV0410019" reg="{'required':'true'}"
                                   value="${exam.umbilicalCordCheck}"/>
                </td>
            </c:if>
            <c:if test="${'3月龄' eq examAge}">
                <th><label class="required">脐部</label></th>
                <td>
                    <ehr:dic-radio name="umbilicalCordCheck" dicmeta="FS10046" reg="{'required':'true'}"
                                   value="${exam.umbilicalCordCheck}"/>
                    <input type="text" id="umbilicalCordCheckDesc" name="umbilicalCordCheckDesc"
                           value="${exam.umbilicalCordCheckDesc}"
                           reg="{'maxlength':'50','required':'true'}"
                           style="width: 130px;display: ${'2' eq exam.umbilicalCordCheck ? '' : 'none'}">
                </td>
            </c:if>
        </tr>
        <tr>
            <c:if test="${'满月' ne examAge}">
                <th><label class="required">可疑佝偻病症状</label></th>
                <td><ehr:dic-checkbox name="suspiciousRicketsSymptoms" dicmeta="CV0410021" reg="{'required':'true'}" code="1,2,3,4"
                                   value="${exam.suspiciousRicketsSymptoms}"/></td>
            </c:if>
        </tr>
        <tr> <c:if test="${'3月龄' eq examAge}">
            <th><label class="required">可疑佝偻病体征</label></th>
           
                <td><ehr:dic-checkbox name="suspiciousRicketsSigns" dicmeta="CV0410022" code="01,02" reg="{'required':'true'}"
                                   value="${exam.suspiciousRicketsSigns}"/></td>
            </c:if>
            <c:if test="${'6月龄' eq examAge or '8月龄' eq examAge}">
            	<th><label class="required">可疑佝偻病体征</label></th>
                <td><ehr:dic-checkbox name="suspiciousRicketsSigns" dicmeta="CV0410022" code="01,05,07,08,09,02,03" reg="{'required':'true'}"
                                   value="${exam.suspiciousRicketsSigns}"/></td>
            </c:if>
        </tr>
        <tr>
            <th><label class="required">肛门/外生殖器</label></th>
            <td>
                <ehr:dic-radio name="analGenitaliaCheck" dicmeta="FS10046" reg="{'required':'true'}"
                               value="${exam.analGenitaliaCheck}"/>
                <input type="text" id="analGenitaliaAnomalyDesc" name="analGenitaliaAnomalyDesc"
                       value="${exam.analGenitaliaAnomalyDesc}"
                       reg="{'maxlength':'50','required':'true'}"
                       style="width: 130px;display: ${'2' eq exam.analGenitaliaCheck ? '' : 'none'}">
            </td>
        </tr>
        <tr>
            <th><label >血红蛋白值</label></th>
            <td><tag:numberInput point="point" name="hemoglobinValue" value="${exam.hemoglobinValue}" 
                       reg="{'max':'9999.9'}" style="width: 100px"/>g/L
            </td>
        </tr>
        </tbody>
    </table>
</fieldset>
<fieldset>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tbody>
        <tr>
            <th><label class="required">户外活动</label></th>
            <td><tag:numberInput point="point" name="outdoorDuration" value="${exam.outdoorDuration}"
                                 reg="{'max':'24.0','required':'true'}" style="width: 100px"/>小时/日
            </td>
        </tr>
        <tr>
            <th><label class="required">服用维生素D</label></th>
            <td>
                <tag:numberInput name="takeVitaminD" value="${exam.takeVitaminD}"
                                 reg="{'max':'99999','required':'true'}" style="width: 100px"/>IU/日
            </td>
            <th><label class="required">维生素D名称</label></th>
            <td>
                <input type="text" name="takeVitaminDName" reg="{'required':'true'}"
                       value="${exam.takeVitaminDName}" style="width: 150px;">
            </td>
        </tr>
        <tr>
        	
            
            <c:if test="${'3月龄' eq examAge}">
            <th><label >发育评估</label></th>
            <td valign="top" colspan="3">
            	<ehr:dic-checkbox dicmeta="CV0510110" code="1,2,3,4"
								name="childDevelopmentEvaluation"
								value='${exam.childDevelopmentEvaluation}' />
				</td>				
			</c:if>
			<c:if test="${'6月龄' eq examAge}">
            	 <th><label >发育评估</label></th>
            <td valign="top" colspan="3">
            	<ehr:dic-checkbox dicmeta="CV0510110" code="5,6,7,8"
								name="childDevelopmentEvaluation"
								value='${exam.childDevelopmentEvaluation}' />
				</td>		
			</c:if>
			<c:if test="${'8月龄' eq examAge}">
            	 <th><label >发育评估</label></th>
            <td valign="top" colspan="3">
            	<ehr:dic-checkbox dicmeta="CV0510110" code="9,10,11,12"
								name="childDevelopmentEvaluation"
								value='${exam.childDevelopmentEvaluation}' />
				</td>		
			</c:if></tr>					
            <tr>
            <th><label class="required">两次随访间患病情况</label></th>
            <%-- <td>
            	<ehr:dic-radio dicmeta="CV0410018" code="14,15" reg="{'required':'true'}"
								name="followupSick"
								value='${exam.followupSick}' />
                <input type="text" id="otherDiseaseState" name="otherDiseaseState"
                       value="${exam.otherDiseaseState}"
                       reg="{'maxlength':'50','required':'true'}"
                       style="width: 130px;display: ${'1' eq exam.followupSick ? '' : 'none'}">
            </td> --%>
            <td colspan="3" valign="top">
                <ehr:dic-radio name="followupSick" dicmeta="FS10187" reg="{'required':'true'}"
								code="1,2" value="${exam.followupSick}" />	
                <div id="followupSickDetail">
                    肺炎：<tag:numberInput reg="{'max':'999','required':'true'}" name="pneumoniaHospitalizations" value="${exam.pneumoniaHospitalizations}" style="width:80px;"/>次
                    腹泻：<tag:numberInput reg="{'max':'999','required':'true'}" name="diarrheaHospitalizations" value="${exam.diarrheaHospitalizations}" style="width:80px;"/>次
                    外伤：<tag:numberInput reg="{'max':'999','required':'true'}" name="traumaHospitalizations" value="${exam.traumaHospitalizations}" style="width:80px;"/>次
                    其他：<input type="text" reg="{'maxlength':'100','required':'true'}" name="otherDiseaseState" value="${exam.otherDiseaseState}" style="width:80px;"/>
                </div>
            </td>
            
        </tr>
        <%-- <tr>
            <th><label class="required">其他</label></th>
            <td colspan="3"><input type="text" name="other"
                                   reg="{'maxlength':'200','required':'true'}" value="${exam.other}"/></td>
        </tr> --%>
        <tr>
            <th><label class="required">转诊建议</label></th>
            <td>
                <ehr:dic-radio name="referralFlag" dicmeta="FS10187" value="${exam.referralFlag}" reg="{'required':'true'}"/>
                <div id="referralDetail" ${"2" eq exam.referralFlag ? '' : 'hidden'}>
                    原因：<input type="text" id="referralReason" name="referralReason" value="${exam.referralReason}" reg="{'required':'true'}"><br>
                    转诊机构：<input type="text" id="referralHospitalName" name="referralHospitalName" value="${exam.referralHospitalName}" reg="{'required':'true'}"><br>
                    转诊科室：<input type="text" id="referralDeptName" name="referralDeptName" value="${exam.referralDeptName}" reg="{'required':'true'}">
                </div>

            </td>
        </tr>
        <tr>
            <c:if test="${'6月龄' eq examAge}">
                <th>中医药健康管理服务</th>
                <td colspan="3">
                    <ehr:dic-checkbox name="tcmHealthManageService" dicmeta="FS10307"
                    code="1,2,3,99" value="${exam.tcmHealthManageService}"/>
                     <span id="tcmHealthManageDetail" style="display: none;">
                    <input type="text" name="tcmHealthOther"
                           value="${exam.tcmHealthOther}" style="width: 200px;"/>
                           </span>
                </td>
            </c:if>
        </tr>
        <tr>
            <th><label class="required">指导</label></th>
            <td colspan="3">
                <ehr:dic-checkbox name="guidanceCategory" dicmeta="CV0600310" uninclude="6" value="${exam.guidanceCategory}" reg="{'required':'true'}"/>
                <span id="guidanceCategoryDetail" style="display: none;">
									   <input type="text" name="mgOpinion" value="${exam.mgOpinion}" style="width: 200px;" reg="{'required':'true'}">
							</span>
                
                
                
            </td>
        </tr>
        <tr>
            <th><label class="required">下次随访日期</label></th>
            <td>
                <input type="text" reg='{"required":"true"}' class="layui-input x-admin-content-sm-date"
                       name="nextSupervisionDate" id="nextSupervisionDate"
                       value="<fmt:formatDate value='${exam.nextSupervisionDate}' pattern='yyyy/MM/dd'/>"
                       style="padding-left: 0px;"/>
                </td>
            <th><label class="required">随访医生签名</label></th>
            <td>
                <ehr:staff-list name="visitDoctorCode" value="${exam.visitDoctorCode}" reg="{'required':'true'}" style="width:180px"/>
            </td>
        </tr>
        </tbody>
    </table>

</fieldset>