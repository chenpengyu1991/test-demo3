<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table class="posttable">
	
    <colgroup>
        <col style="width: 15%;min-width:100px;"/>
        <col style="width: 35%;min-width:200px;"/>
        <col style="width: 15%;min-width:100px;"/>
        <col style="width: 35%;min-width:200px;"/>
    </colgroup>

    <tr>
        <th><label  class="required">是否管理</label></th>
        <td>
                    <ehr:dic-radio dicmeta="FS10246"  reg="{'required':true}"  name="coronaryManagedFlag" value="${diseaseInfo.coronaryManagedFlag}"/>
        </td>
        <th><label  class="required">是否管理满一年</label></th>
        <td>
                <ehr:dic-radio   reg="{'required':true}"  dicmeta="FS10246" name="coronaryManagedFayFlag" value="${diseaseInfo.coronaryManagedFayFlag}"/>
        </td>
    </tr>

    <c:choose> <c:when test="${isBringIntoManage==true}">
       <tr>
            <th><label class="required">冠心病类型</label></th>
            <td>
                <input type="hidden" name="coronaryType" value="${diseaseInfo.coronaryType}"/>
                <ehr:dic   dicmeta="DMD00008" code="${diseaseInfo.coronaryType}"  />
            </td>    
            <th><label class="required">确诊时间</label></th>
            <td>
            	<input type="hidden" name="coronaryDiagnosisDate" value='<fmt:formatDate value="${diseaseInfo.coronaryDiagnosisDate}" pattern="yyyy/MM/dd" />' />
				<fmt:formatDate value="${diseaseInfo.coronaryDiagnosisDate}"  pattern="yyyy/MM/dd" />
            </td>
        </tr>
    </c:when> 
    <c:otherwise>
    	<c:choose>
			<c:when test="${isHealth==true}"><%--健康档案创建慢病管理卡 --%>
		        <tr>
		            <th><label class="required" for="coronaryType">冠心病类型</label></th>
		            <td>
		            	<ehr:dic-list width="180px;" id="coronaryType" dicmeta="DMD00008" name="coronaryType" value="${diseaseInfo.coronaryType}" reg="{'required':true}"/>
		            </td>
		        	<th><label class="required">确诊时间</label></th>
		            <td>
			            <%-- <tag:dateInput style="width:180px;" name="coronaryDiagnosisDate" onlypast="true" reg="{'required':true}" date="${diseaseInfo.coronaryDiagnosisDate}" /> --%>
			            <input type="text" reg="{'required':true}" class="layui-input x-admin-content-sm-date" name="coronaryDiagnosisDate" id="coronaryDiagnosisDateId" value="<fmt:formatDate value='${diseaseInfo.coronaryDiagnosisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width:180px;" />
		            </td>
		        </tr>
		      </c:when>
		      <c:otherwise><%--查看慢病管理卡 --%>
		      	<tr>
		            <th><label class="required" for="coronaryType">冠心病类型</label></th>
		            <td>
		            	<ehr:dic dicmeta="DMD00008" code="${diseaseInfo.coronaryType}"/>
						<input type="hidden" name="coronaryType" value="${diseaseInfo.coronaryType}" />
		            </td>
		        	<th><label class="required">确诊时间</label></th>
		            <td>
		            	<fmt:formatDate value="${diseaseInfo.coronaryDiagnosisDate}" pattern="yyyy/MM/dd" />	
						<input type="hidden" name="coronaryDiagnosisDate" value='<fmt:formatDate value="${diseaseInfo.coronaryDiagnosisDate}" pattern="yyyy/MM/dd" />' />
		            </td>
		        </tr>
		    </c:otherwise> 
		 </c:choose> 
    </c:otherwise>

    </c:choose>

    <tr>
        <th><label>家族史</label></th>
        <td>
            <ehr:dic-list width="180px;" dicmeta="PH00001" name="coronaryFamilyHisFlag" value="${diseaseInfo.coronaryFamilyHisFlag}"/></td>
        <th><label class="required">身体活动受限</label></th>
        <td>
            <ehr:dic-list width="180px;" dicmeta="FS10246" name="coronaryBodyLimitFlag" value="${diseaseInfo.coronaryBodyLimitFlag}" reg="{'required':true}"/></td>
    </tr>
    <c:if test="${diseaseInfo.coronaryManagedDate != null}">
	    <tr>
	        <th><label>管理卡创建时间</label></th>
	        <td>
	        	<fmt:formatDate value="${diseaseInfo.coronaryManagedDate}" pattern="yyyy/MM/dd" />
	        </td>
	    </tr>
    </c:if>
</table>


<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#coronaryDiagnosisDateId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
   	, trigger: 'click' 
   		,done:function (value) {
			if(!$.isEmpty(value)){
				$("#coronaryDiagnosisDateId").removeClass("lose");
			}else{
				$("#coronaryDiagnosisDateId").addClass("lose");
			}
		}
    });

  });
</script>