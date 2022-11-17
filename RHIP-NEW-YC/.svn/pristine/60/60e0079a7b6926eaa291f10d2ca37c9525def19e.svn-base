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
layui.use('laydate', function() {
    var laydate = layui.laydate;
    
    //执行一个laydate实例
    laydate.render({
      elem: '#visitDate' 
   	   ,format: 'yyyy/MM/dd'
   	  , trigger: 'click' 
    });
    laydate.render({
        elem: '#nextSupervisionDate' 
     	   ,format: 'yyyy/MM/dd'
     	  , trigger: 'click' 
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
                <tag:autoSelect name="checkOrganCode" id="checkOrganCode" reg="{'required':true}"
                                codeValue="${exam.checkOrganCode}" style="width:180px" />
            </td>
        </tr>
        <tr>
            <th><label class="required">随访日期</label></th>
            <td>
            
            <%-- <tag:dateInput style="width:120px;" reg="{'required':true}" onlypast="true"
                               name="visitDate" date="${exam.visitDate}" cssClass="width100"/> --%> 
            <input type="text" class="layui-input x-admin-content-sm-date" placeholder="随访日期" name="visitDate" id="visitDate" value="<fmt:formatDate value="${exam.visitDate}" pattern="yyyy/MM/dd"/>" reg='{"required":"true"}' style="padding-left: 0px;width: 120px;"/>                   
                               </td>
            <th><label class="required">体重</label></th>
            <td>
                <tag:numberInput point="point" name="bodyWeight" value="${exam.bodyWeight}"
                                 reg="{'max':'999.99','required':true}"
                                 style="width: 100px;"/>kg
                <ehr:dic-radio name="evaluationresultcode" dicmeta="CV0510006" code="1,2,3" reg="{'required':true}"
                               value="${exam.evaluationresultcode}"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">身高</label></th>
            <td>
                <tag:numberInput point="point" name="stature" value="${exam.stature}"
                                 reg="{'max':'999.9','required':true}"
                                 style="width: 100px;"/>cm
                <ehr:dic-radio name="heightEvaluationResult" dicmeta="CV0510006" code="1,2,3" reg="{'required':true}"
                               value="${exam.heightEvaluationResult}"/>

            </td>
           <th><label class="required">体格发育评价</label></th>
            <td><ehr:dic-radio name="physiquegrowthCode" dicmeta="CV0410020" value="${exam.physiquegrowthCode}" reg="{'required':true}"/></td>
        </tr>
        <tr>
            <th><label class="required">体重/身高</label></th>
            <td><%-- <fmt:formatNumber value="${(report.familyVisitNum/report.deliveryNum)*100}" pattern="#,##0.0"/>% --%>
                <input reg="{'required':true,'max':999.99}" type="text" id="bodyWeightStature" name="bodyWeightStature" 
                value="${exam.bodyWeightStature}" readonly="readonly" style="width: 100px;"/>
                <%-- tag:numberInput point="point" name="bodyWeightStature" value="${exam.bodyWeightStature}" 
                                 reg="{'max':'999.9','required':true}"
                                 style="width: 100px;"/> --%>
                <ehr:dic-radio name="weightHeightResult" dicmeta="CV0510006" code="1,2,3" reg="{'required':true}"
                               value="${exam.weightHeightResult}"/>

            </td>
            
        </tr>
        </tbody>
    </table>
</fieldset>
<fieldset>
    <legend><label class="required">体格检查</label></legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
            <col style="width: 15%"/>
            <col style="width: 35%"/>
        </colgroup>
        <tbody>
        <tr>
            <c:if test="${'3岁' ne examAge}">
                <th><label class="required">视力</label></th>
                <td>
                    左眼：<tag:numberInput point="point" name="lNakedEye" value="${exam.lNakedEye}"
                                        reg="{'max': 99.9,'required':true}" style="width: 60px;"/>
                    右眼：<tag:numberInput point="point" name="rNakedeye" value="${exam.rNakedeye}"
                                        reg="{'max': 99.9,'required':true}" style="width: 60px;"/>
                </td>
            </c:if>
            <c:if test="${'3岁' eq examAge}">
                <th><label class="required">听力</label></th>
                	<td><ehr:dic-radio name="hearingScreeningResults" dicmeta="MH00055" code="1,2" reg="{'required':'true'}"
                                   value="${exam.hearingScreeningResults}"/></td>
            </c:if>
        </tr>
        <tr>
            <th><label class="required">牙数(颗)/龋齿数</label></th>
            <td>
                <tag:numberInput name="teethNumber" value="${exam.teethNumber}"
                                 reg="{'max':'99','required':'true'}" style="width: 50px;"/> / <tag:numberInput name="decayedToothNumber" value="${exam.decayedToothNumber}"
                                                                                              reg="{'max':'99','required':'true'}" style="width: 50px;"/>
            </td>
        </tr>
        <tr>
            <th><label class="required">胸部</label></th>
            <td>
                <ehr:dic-radio name="heartLungAnomalySign" dicmeta="FS10046" reg="{'required':'true'}"
                               value="${exam.heartLungAnomalySign}"/>
                <input type="text" id="heartLungAnomalyDesc" name="heartLungAnomalyDesc"
                       value="${exam.heartLungAnomalyDesc}" reg="{'maxlength':'50','required':'true'}"
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
            <th><label class="required">血红蛋白值</label></th>
            <td><tag:numberInput point="point" name="hemoglobinValue" value="${exam.hemoglobinValue}"
                                 reg="{'max':'9999.9','required':'true'}" style="width: 100px"/>g/L
            </td>
        </tr>
        <tr>
            <th>其他</th>
            <td colspan="3"><input type="text" name="other"
                                   reg="{'maxlength':'200'}" value="${exam.other}"/></td>
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
        	 <th><label >发育评估</label></th>
            <c:if test="${'3岁' eq examAge}">
               
                <td valign="top" colspan="3">
                    <ehr:dic-checkbox dicmeta="CV0510110" code="29,30,31,32"
								name="childDevelopmentEvaluation"
								value='${exam.childDevelopmentEvaluation}' />
                </td>
            </c:if>
            <c:if test="${'4岁' eq examAge}">
               
                <td valign="top" colspan="3">
                    <ehr:dic-checkbox dicmeta="CV0510110" code="33,34,35,36"
								name="childDevelopmentEvaluation"
								value='${exam.childDevelopmentEvaluation}' />
                </td>
            </c:if>
            <c:if test="${'5岁' eq examAge}">
               
                <td valign="top" colspan="3">
                    <ehr:dic-checkbox dicmeta="CV0510110" code="37,38,39,40"
								name="childDevelopmentEvaluation"
								value='${exam.childDevelopmentEvaluation}' />
                </td>
            </c:if>
            <c:if test="${'6岁' eq examAge}">
               
                <td valign="top" colspan="3">
                    <ehr:dic-checkbox dicmeta="CV0510110" code="41,42,43,44"
								name="childDevelopmentEvaluation"
								value='${exam.childDevelopmentEvaluation}' />
                </td>
            </c:if>
            
        </tr>
        
        
        <tr>
            <th><label class="required">两次随访间患病情况</label></th>
            <td colspan="3">
                <ehr:dic-radio name="followupSick" dicmeta="FS10187" reg="{'required':'true'}"
								code="1,2" value="${exam.followupSick}" />	
                <div id="followupSickDetail">
                    肺炎：<tag:numberInput reg="{'max':'999','required':'true'}" name="pneumoniaHospitalizations" value="${exam.pneumoniaHospitalizations}" style="width:80px;" />次
                    腹泻：<tag:numberInput reg="{'max':'999','required':'true'}" name="diarrheaHospitalizations" value="${exam.diarrheaHospitalizations}" style="width:80px;" />次 
                    外伤：<tag:numberInput reg="{'max':'999','required':'true'}" name="traumaHospitalizations" value="${exam.traumaHospitalizations}" style="width:80px;" />次
                    其他：<input type="text" reg="{'maxlength':'100','required':'true'}" name="otherDiseaseState" value="${exam.otherDiseaseState}" style="width:80px;" />
                </div>
            </td>
        </tr>
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
        <c:if test="${'3岁' eq examAge}">
        <tr>
            <th>中医药健康管理服务</th>
            <td colspan="3">
                <ehr:dic-checkbox name="tcmHealthManageService" dicmeta="FS10307"
                                  code="1,2,5,99" value="${exam.tcmHealthManageService}"/>
               <span id="tcmHealthManageDetail" style="display: none;">
                <input type="text" name="tcmHealthOther"
                       value="${exam.tcmHealthOther}" style="width: 200px;"/></span>
            </td>
        </tr></c:if>
        <tr>
            <th><label class="required">指导</label></th>
            <td colspan="3">
                <ehr:dic-checkbox name="guidanceCategory" dicmeta="CV0600310" code="6,2,3,4,5,9" value="${exam.guidanceCategory}" reg="{'required':'true'}"/>
                <span id="guidanceCategoryDetail" style="display: none;">
									   <input type="text" name="mgOpinion" value="${exam.mgOpinion}" style="width: 200px;" reg="{'required':'true'}">
							</span>
            </td>
        </tr>
        <tr>
            <th><label class="required">下次随访日期</label></th>
            <td>
            <input type="text" class="layui-input x-admin-content-sm-date" placeholder="下次随访日期" name="nextSupervisionDate" id="nextSupervisionDate" value="<fmt:formatDate value="${exam.nextSupervisionDate}" pattern="yyyy/MM/dd"/>" reg='{"required":"true"}' style="padding-left: 0px;width: 120px;">
            <%-- <tag:dateInput style="width:120px;"
                               name="nextSupervisionDate" date="${exam.nextSupervisionDate}" cssClass="width100" reg="{'required':'true'}"/> --%></td>
            <th><label class="required">随访医生签名</label></th>
            <td>
                <ehr:staff-list name="visitDoctorCode" value="${exam.visitDoctorCode}" reg="{'required':'true'}" style="width:180px"/>
            </td>
        </tr>
        </tbody>
    </table>

</fieldset>