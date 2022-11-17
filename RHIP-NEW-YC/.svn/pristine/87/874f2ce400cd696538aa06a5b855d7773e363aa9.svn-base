<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table class="posttable">

    <colgroup>
        <col style="width: 15%"/>
        <col style="width: 35%"/>
        <col style="width: 15%"/>
        <col style="width: 35%"/>
    </colgroup>

    <tr>
        <th><label class="required">是否管理</label></th>
        <td>
            <ehr:dic-radio reg="{'required':true}" dicmeta="FS10246" name="strokeManagedFlag" value="${diseaseInfo.strokeManagedFlag}"/>
        </td>
        <th><label class="required">是否管理满一年</label></th>
        <td>
            <ehr:dic-radio reg="{'required':true}" dicmeta="FS10246" name="strokeManagedFayFlag" value="${diseaseInfo.strokeManagedFayFlag}"/>
        </td>
    </tr>

    <c:choose> 
    	<c:when test="${isBringIntoManage==true}">
	        <tr>
	            <th><label class="required" for="strokeType">脑卒中类型</label></th>
	            <td>
	                <input type="hidden" name="strokeType" value="${diseaseInfo.strokeType}"/>
	                <ehr:dic dicmeta="DMD00009" code="${diseaseInfo.strokeType}"  />
	           </td>
	           <th><label class="required">确诊时间</label></th>
	            <td>
	             	<input type="hidden" name="strokeDiagnosisDate" value='<fmt:formatDate value="${diseaseInfo.strokeDiagnosisDate}" pattern="yyyy/MM/dd" />' />
					<fmt:formatDate value="${diseaseInfo.strokeDiagnosisDate}"  pattern="yyyy/MM/dd" />
	            </td>
	        </tr>
	    </c:when> 
	    <c:otherwise>
	    	<c:choose>
				<c:when test="${isHealth==true}"><%--健康档案创建慢病管理卡 --%>
			         <tr>
			            <th><label class="required" for="strokeType">脑卒中类型</label></th>
			            <td>
				            <ehr:dic-list width="180px;" dicmeta="DMD00009" name="strokeType" value="${diseaseInfo.strokeType}" reg="{'required':true}"/></td>
			            </td>
						<th><label class="required">确诊时间</label></th>
			            <td>
			            	<%-- <tag:dateInput style="width:180px;" name="strokeDiagnosisDate" onlypast="true" reg="{'required':true}" date="${diseaseInfo.strokeDiagnosisDate}" /> --%>
			            	<input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date" name="strokeDiagnosisDate" id="strokeDiagnosisDateId" value="<fmt:formatDate value='${diseaseInfo.strokeDiagnosisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:180px;" />
			            </td>
			        </tr>
			     </c:when>
			     <c:otherwise><%--查看慢病管理卡 --%>
			     	 <tr>
			            <th><label class="required" for="strokeType">脑卒中类型</label></th>
			            <td>
			            	<ehr:dic dicmeta="DMD00009" code="${diseaseInfo.strokeType}"/>
							<input type="hidden" name="strokeType" value="${diseaseInfo.strokeType}" />
			            </td>
						<th><label class="required">确诊时间</label></th>
			            <td>
			            	<fmt:formatDate value="${diseaseInfo.strokeDiagnosisDate}" pattern="yyyy/MM/dd" />	
							<input type="hidden" name="strokeDiagnosisDate" value='<fmt:formatDate value="${diseaseInfo.strokeDiagnosisDate}" pattern="yyyy/MM/dd" />' />
			            </td>
			        </tr>
			     </c:otherwise>
			 </c:choose>
	    </c:otherwise>
    </c:choose>

    <tr>
        <th><label>家族史</label></th>
        <td>
            <ehr:dic-list width="180px;" dicmeta="PH00001" name="strokeFamilyHisFlag" value="${diseaseInfo.strokeFamilyHisFlag}"/></td>
        <th><label class="required">身体活动受限</label></th>
        <td>
            <ehr:dic-list width="180px;" dicmeta="FS10246" name="strokeBodyLimitFlag" value="${diseaseInfo.strokeBodyLimitFlag}" reg="{'required':true}"/></td>
    </tr>
    <c:if test="${diseaseInfo.strokeManagedDate != null}">
	    <tr>
	        <th><label>管理卡创建时间</label></th>
	        <td>
	        	<fmt:formatDate value="${diseaseInfo.strokeManagedDate}" pattern="yyyy/MM/dd" />
	        </td>
	    </tr>
    </c:if>
</table>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#strokeDiagnosisDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
   		,done:function (value) {
			if(!$.isEmpty(value)){
				$("#strokeDiagnosisDateId").removeClass("lose");
			}else{
				$("#strokeDiagnosisDateId").addClass("lose");
			}
		}
    });

  });
</script>