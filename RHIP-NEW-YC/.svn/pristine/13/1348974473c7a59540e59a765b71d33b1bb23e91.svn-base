<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script src="${pageContext.request.contextPath}/js/views/cdm/highRisk/preventiveManage.js" type="text/javascript"></script>

<div class="section">
<div class="toolbar" align="right">
	<%-- <a id="returnButton"><b class="fanhui">返回</b></a> --%>
	<a id="returnButton" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<form id="riskFactorsInfo" method="post">	
	<div class="postcontent">	
		<i class="popno">慢病预防管理个人危险因素查看</i>
		<div class="postdiv">
			<fieldset class="layui-elem-field">
				 <legend>患者基本信息</legend>			
				 <table class="posttable">
				 		<colgroup>
							<col style="width: 18%" />
							<col style="width: 35%" />
							<col style="width: 15%" />
							<col style="width: 35%" />
						</colgroup>
						<tr>
							<th>姓名</th>
							<td><input readonly="readonly" type="text" id="name" name="name" value="${dmPotentialPersonInfo.name}"></td>
							<th>姓别</th>
							<td><input readonly="readonly" type="text" value="<ehr:dic dicmeta="GBT226112003" code = "${dmPotentialPersonInfo.gender}"/>"></td>				
						</tr>
						<tr>
							<th>出生年月</th>
							<td>
								<input readonly="readonly" type="text" value="<fmt:formatDate value='${dmPotentialPersonInfo.birthday}' pattern='yyyy/MM/dd'/>">
							</td>
						</tr>
				 </table>		
			</fieldset>
			<fieldset class="layui-elem-field">
				 <legend>第一类健康危险因素</legend>			
				  <table class="posttable">
				 		<colgroup>
							<col style="width: 16%" />
							<col style="width: 74%" />
						</colgroup>		
						<c:forEach var="firstClassStandardList" items="${dmPotentialPersonInfo.firstClassStandard}">
			 				<c:if test="${firstClassStandardList.parameterId eq 'CDM0000001'}">
				 				<tr>
				 					<th>是否吸烟：</th>
				 					<td>${firstClassStandardList.resultValue eq '1'? '是':'否'};</td>
				 				</tr>
			 				</c:if>
			 				<c:if test="${firstClassStandardList.parameterId eq 'CDM0000002'}">
			 					<tr>
				 					<th>空腹血糖值：</th>
				 					<td>${firstClassStandardList.resultValue}mmol/L;</td>
				 				</tr>
			 				</c:if>
			 				<c:if test="${firstClassStandardList.parameterId eq 'CDM0000003'}">
			 					<tr>
				 					<th>血清总胆固醇值：</th>
				 					<td>${firstClassStandardList.resultValue}mmol/L;</td>
				 				</tr>	
			 				</c:if>
			 				<c:if test="${firstClassStandardList.parameterId eq 'CDM0000004'}">
			 					<tr>
				 					<th>男性腰围值：</th>
				 					<td>${firstClassStandardList.resultValue}cm;</td>
				 				</tr>
			 				</c:if>
			 				<c:if test="${firstClassStandardList.parameterId eq 'CDM0000005'}">
			 					<tr>
				 					<th>女性腰围值：</th>
				 					<td>${firstClassStandardList.resultValue}cm;</td>
				 				</tr>
			 				</c:if>
			 				<c:if test="${firstClassStandardList.parameterId eq 'CDM0000014'}">
			 					<tr>
				 					<th>收缩压：</th>
				 					<td>${firstClassStandardList.resultValue}mmHg;</td>
				 				</tr>
			 				</c:if>
			 				<c:if test="${firstClassStandardList.parameterId eq 'CDM0000015'}">
			 					<tr>
				 					<th>舒张压：</th>
				 					<td>${firstClassStandardList.resultValue}mmHg;<br></td>
				 				</tr>
			 				</c:if>
		 			    </c:forEach>
		 			    <c:if test="${empty dmPotentialPersonInfo.firstClassStandard }">
			 			    <tr style="text-align: center;color:#FF6600;">
			 			    	<td>该类无健康危险因素！</td>
			 			    </tr>	
		 			    </c:if>
				  </table>
			</fieldset>
			<fieldset class="layui-elem-field">
				 <legend>第二类健康危险因素</legend>			
				  <table class="posttable">
				 		<colgroup>
							<col style="width: 16%" />
							<col style="width: 74%" />
						</colgroup>		
						<c:forEach var="secondClassStandardList" items="${dmPotentialPersonInfo.secondClassStandard}">
			 				<c:if test="${secondClassStandardList.parameterId eq 'CDM0000006'}">
				 				<tr>
				 					<th>年龄段：</th>
				 					<td>${secondClassStandardList.resultValue}岁;</td>
				 				</tr>
			 				</c:if>
			 				<c:if test="${secondClassStandardList.parameterId eq 'CDM0000007'}">
			 					<tr>
				 					<th>体质指数(BMI)：</th>
				 					<td>${secondClassStandardList.resultValue};</td>
				 				</tr>			
			 				</c:if>
			 				<c:if test="${secondClassStandardList.parameterId eq 'CDM0000008'}">
			 					<tr>
				 					<th>运动时间：</th>
				 					<td>${secondClassStandardList.resultValue}分钟/次 ;</td>
				 				</tr>
			 				</c:if>
			 				<c:if test="${secondClassStandardList.parameterId eq 'CDM0000009'}">
			 					<tr>
				 					<th> 吸烟状况：</th>
				 					<td>
				 						<c:if test="${secondClassStandardList.resultValue eq '1'}">现在每天吸</c:if>
			 				 			<c:if test="${secondClassStandardList.resultValue eq '2'}">现在吸,但不是每天吸</c:if>
			 				 			<c:if test="${secondClassStandardList.resultValue eq '3'}">过去吸,现在不吸</c:if>
			 				 			<c:if test="${secondClassStandardList.resultValue eq '4'}">从不吸 </c:if>;
				 					</td>
				 				</tr>
			 				</c:if>
			 				<c:if test="${secondClassStandardList.parameterId eq 'CDM0000010'}">
			 					<tr>
				 					<th>饮酒状况：</th>
				 					<td>${secondClassStandardList.resultValue eq '1'? '每天':'经常'};</td>
				 				</tr>
			 				</c:if>
			 				<c:if test="${secondClassStandardList.parameterId eq 'CDM0000011'}">
			 					<tr>
				 					<th>总胆固醇：</th>
				 					<td>${secondClassStandardList.resultValue}mmol/L;</td>
				 				</tr>					 					
			 				</c:if>
			 				<c:if test="${secondClassStandardList.parameterId eq 'CDM0000012'}">
			 					<tr>
				 					<th>甘油三酯：</th>
				 					<td>${secondClassStandardList.resultValue}mmol/L;</td>
				 				</tr>					 					
			 				</c:if>
			 				<c:if test="${secondClassStandardList.parameterId eq 'CDM0000013'}">
			 					<tr>
				 					<th>家族史：</th>
				 					<td>${secondClassStandardList.resultValue eq '1'? '高血压':'糖尿病'};</td>
				 				</tr>
			 				</c:if>
		 		    	</c:forEach>
		 		    	<c:if test="${empty dmPotentialPersonInfo.secondClassStandard }">
		 			    	<tr style="text-align: center;color:#FF6600;">
		 			    		<td>该类无健康危险因素！</td>
		 			    	</tr>
		 			    </c:if>								
				  </table>
			</fieldset>
		</div>
	</div>
</form>
</div>
