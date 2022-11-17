<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
	.posttable td .layui-form input[type="text"]{
		width:65%;
	}
	.layui-edge{
		margin-left: 35px;
	}

</style>

<table class="posttable">
    <colgroup>
        <col style="width: 15%;min-width:100px;"/>
        <col style="width: 35%;min-width:200px;"/>
        <col style="width: 15%;min-width:100px;"/>
        <col style="width: 35%;min-width:200px;"/>
    </colgroup>
	<c:choose>
			<c:when test="${isHealth==true}">
				<tr>
			        <th><label class="required">ICD-10编码</label></th>
			        <td>
				        <input type="text" id="tumorIcd10Code" name="tumorIcdTenCode" value="${diseaseInfo.tumorIcdTenCode}" reg='{"required":true,"regex":"^C[0-9]{2}(\\.[a-zA-Z0-9]{1,3}([a-zA-Z0-9]|\\+)?)?$|^D[0-3][0-9](\\.[a-zA-Z0-9]{1,3}([a-zA-Z0-9]|\\+)?)?$|^D[4][0-8](\\.[a-zA-Z0-9]{1,3}([a-zA-Z0-9]|\\+)?)?$"}' tip="请输入正确的肿瘤icd10编码"/>
			        </td>
			        <th><label class="required">肿瘤病名</label></th>
			        <td>
			            <input type="text" name="tumorType" value="${diseaseInfo.tumorType}" reg="{'required':true,'maxlength':50}"/>
			        </td>
			    </tr>
			    <tr>
			        <th><label class="required">知情状态标志</label></th>
			        <td>
			        	<ehr:dic-list width="180px" dicmeta="PH00001" name="tumorInformedFlag" value="${diseaseInfo.tumorInformedFlag}" reg="{'required':true}"/>
			        </td>
			        <th><label>原发部位</label></th>
			        <td>
			        	<input type="text" name="tumorPrimaryPart" value="${diseaseInfo.tumorPrimaryPart}" reg="{'maxlength':33}"/>
			        </td>
			    </tr>
			    <tr>
			        <th><label>转移部位</label></th>
			        <td style="vertical-align:top;">
			            <input type="text" name="tumorMetastasisPart" value="${diseaseInfo.tumorMetastasisPart}" reg="{'maxlength':33}"/>
			        </td>
			        <th><label>诊断依据</label></th>
			        <td>
			        	<div class="layui-form">
			            <ehr:dic-list type="true" width="180px;" dicmeta="DMD00010" name="tumorDiagnosisDepends" value="${diseaseInfo.tumorDiagnosisDepends}" reg="{'maxlength':33}"/>
			            </div>
			            </td>
			    </tr>
			    <tr>
			        <th><label>病理类型</label></th>
			        <td>
			            <input type="text" name="tumorPathologyType" value="${diseaseInfo.tumorPathologyType}" reg="{'maxlength':16}"/>
			        </td>
			        <th><label>ICD-0-3编码</label></th>
			        <td><input type="text" name="tumorIcdThreeCode" value="${diseaseInfo.tumorIcdThreeCode}" reg="{'maxlength':8}"/>
			        </td>
			    </tr>
			    <tr>
			        <th><label class="required">发病日期</label></th>
			        <td>
			            <%-- <tag:dateInput onlypast="true" id="tumorAccidentDate" name="tumorAccidentDate" date="${diseaseInfo.tumorAccidentDate}" reg="{'required':true}"/> --%>
			            <input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date" name="tumorAccidentDate" id="tumorAccidentDateId" value="<fmt:formatDate value='${diseaseInfo.tumorAccidentDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			            </td>
			            
			        <th><label class="required">诊断日期</label></th>
			        <td>
			            <%-- <tag:dateInput onlypast="true" name="tumorDiagnosisDate" date="${diseaseInfo.tumorDiagnosisDate}" reg="{'required':true,'greaterThan':'tumorAccidentDate'}"/> --%>
			            <input type="text" reg="{'required':true,'greaterThan':'tumorAccidentDate'}" class="layui-input x-admin-content-sm-date" name="tumorDiagnosisDate" id="tumorDiagnosisDateId" value="<fmt:formatDate value='${diseaseInfo.tumorDiagnosisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
			            </td>
			    </tr>
			</c:when>
			<c:otherwise><%-- 慢病管理卡只显示不可修改--%>
				 <tr>
			        <th><label class="required">ICD-10编码</label></th>
			        <td>
			        	${diseaseInfo.tumorIcdTenCode}
			        	<input type="hidden" name="tumorIcdTenCode" value="${diseaseInfo.tumorIcdTenCode}"/>
			        </td>
			        <th><label class="required">肿瘤病名</label></th>
			        <td>
			        	${diseaseInfo.tumorType}
				        <input type="hidden" name="tumorType" value="${diseaseInfo.tumorType}"/>
			        </td>
			    </tr>
			    <tr>
			        <th><label class="required">知情状态标志</label></th>
			        <td>
			        	<ehr:dic dicmeta="PH00001" code="${diseaseInfo.tumorInformedFlag}"/>
				        <input type="hidden" name="tumorInformedFlag" value="${diseaseInfo.tumorInformedFlag}"/>
			        </td>
			        <th><label>原发部位</label></th>
			        <td>
			        	${diseaseInfo.tumorPrimaryPart }
				        <input type="hidden" name="tumorPrimaryPart" value="${diseaseInfo.tumorPrimaryPart}"/>
			        </td>
			    </tr>
			    <tr>
			        <th><label>转移部位</label></th>
			        <td style="vertical-align:top;">
			       		${diseaseInfo.tumorMetastasisPart}
			            <input type="hidden" name="tumorMetastasisPart" value="${diseaseInfo.tumorMetastasisPart}"/>
			        </td>
			        <th><label>诊断依据</label></th>
			        <td>
				        <ehr:dic dicmeta="DMD00010" code="${diseaseInfo.tumorDiagnosisDepends}"/>
				        <input type="hidden" name="tumorDiagnosisDepends" value="${diseaseInfo.tumorDiagnosisDepends}"/>
			        </td>
			    </tr>
			    <tr>
			        <th><label>病理类型</label></th>
			        <td>
			        	${diseaseInfo.tumorPathologyType}
			            <input type="hidden" name="tumorPathologyType" value="${diseaseInfo.tumorPathologyType}"/>
			        </td>
			        <th><label>ICD-0-3编码</label></th>
			        <td>
			        	${diseaseInfo.tumorIcdThreeCode}
			        	<input type="hidden" name="tumorIcdThreeCode" value="${diseaseInfo.tumorIcdThreeCode}" />
			        </td>
			    </tr>
			    <tr>
			        <th><label class="required">发病日期</label></th>
			        <td>
				        <fmt:formatDate value="${diseaseInfo.tumorAccidentDate}" pattern="yyyy/MM/dd" />
						<input type="hidden" name="tumorAccidentDate" value='<fmt:formatDate value="${diseaseInfo.tumorAccidentDate}" pattern="yyyy/MM/dd" />' />
			        </td>
			        <th><label class="required">诊断日期</label></th>
			        <td>
			        	<fmt:formatDate value="${diseaseInfo.tumorDiagnosisDate}" pattern="yyyy/MM/dd" />
						<input type="hidden" name="tumorDiagnosisDate" value='<fmt:formatDate value="${diseaseInfo.tumorDiagnosisDate}" pattern="yyyy/MM/dd" />' />
			    </tr>
			</c:otherwise>
    </c:choose>
</table>

<script type="text/javascript">
$(function() {
	 layui.use('multiSelect', function() {
    	var multiSelect =  layui.multiSelect;
    	multiSelect.render(); // 解决多选框不显示问题
    });
})
layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#tumorAccidentDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
   		,done:function (value) {
				if(!$.isEmpty(value)){
					$("#tumorAccidentDateId").removeClass("lose");
				}else{
					$("#tumorAccidentDateId").addClass("lose");
				}
			}
    });
    
    laydate.render({
        elem: '#tumorDiagnosisDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	, trigger: 'click' 
     		,done:function (value) {
				if(!$.isEmpty(value)){
					$("#tumorDiagnosisDateId").removeClass("lose");
				}else{
					$("#tumorDiagnosisDateId").addClass("lose");
				}
			}
      });

  });
</script>