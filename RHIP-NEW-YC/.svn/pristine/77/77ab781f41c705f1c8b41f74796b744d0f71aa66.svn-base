<%--
  永城市人用狂犬病疫苗接种记录单
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="vaccinationFlag" value="${vaccinationEvent.flag}"></c:set>
<!-- 患者基本情况 -->
<div style="text-align: center; font-size: 16px; font-weight: bold;margin:0px 0px 20px 0px">
	永城市人用狂犬病疫苗接种记录单
</div>

<div class="postdiv">
    <table class="posttable" style=" font-size: 11px;">
		<tr>
			<td style="width: 50%; text-align: left;vertical-align:middle; ">
				<span>编号：${vaccinationEvent.barcode}</span>
				
			</td>
			<td style="width: 30%;text-align: right;vertical-align:middle; ">
				<span>条形码：</span>			
			</td>
			<td style="width: 20%;text-align: right; ">
				<img src="${pageContext.request.contextPath}/barcode/show?msg=${vaccinationEvent.barcode}" height="70px" width=160px/>
			</td>
		</tr>
	</table>
    <table class="posttable" style=" font-size: 11px;">
		<tr>
			<td style="width: 34%; text-align: left;">
				<span>受种者姓名：${vaccinationMgmt.name}</span>
			</td>
			<td style="width: 33%;">
				<span>性别：<ehr:dic dicmeta="GBT226112003" code="${vaccinationMgmt.gender}"/></span>
			</td>
			<td style="width: 33%; text-align: right;">
				<span>年龄：${vaccinationMgmt.age}&nbsp;岁</span>
			</td>			
		</tr>
	</table>
	<div class="repeattable">
	    <table border="1" style="width: 100%; font-size: 11px;border-collapse: collapse;">
	        <tbody>
		        <tr>
		            <th style="width: 13%" class="centerth">接种次数</th>
		            <th style="width: 20%" class="centerth">预约日期</th>
		            <th style="width: 13%" class="centerth">接种剂量(支)</th>
		            <th style="width: 20%" class="centerth">接种日期</th>
		            <th style="width: 14%" class="centerth">接种者签名</th>
		            <th style="width: 20%" class="centerth">疫苗生产厂家</th>
		        </tr>
		        <tr>
		        	<td>第一次</td>
		        	<td>
		        		<c:if test="${vaccinationFlag not eq '1'}">
		        			<fmt:formatDate value="${reservation.firstDate}" pattern="yyyy/MM/dd"/>
		        		</c:if>
		        	</td>
		        	<td>
		        		<c:if test="${vaccinationFlag == 0}">2</c:if>
		        	</td>
		        	<td></td>
		        	<td></td>
		        	<td></td>
		        </tr>
		        <tr>
		        	<td>第二次</td>
		        	<td>
		        		<c:if test="${vaccinationFlag ne '1'}">
		        			<fmt:formatDate value="${reservation.secondDate}" pattern="yyyy/MM/dd"/></td>
		        		</c:if>
		        	<td>
		        		<c:if test="${vaccinationFlag ne '1'}">1</c:if>
		        	</td>
		        	<td></td>
		        	<td></td>
		        	<td></td>
		        </tr>
		        <tr>
		        	<td>第三次</td>
		        	<td>
		        		<c:if test="${vaccinationFlag ne '1'}">
		        			<fmt:formatDate value="${reservation.thirdDate}" pattern="yyyy/MM/dd"/></td>
		        		</c:if>
		        	<td>
		        		<c:if test="${vaccinationFlag ne '1'}">1</c:if>
		        	</td>
		        	<td></td>
		        	<td></td>
		        	<td></td>
		        </tr>		        		        
	        </tbody>
	    </table>
    </div>	
    <table class="posttable" style=" font-size: 11px;">
		<tr>
			<td style="width: 50%; text-align: left;">
				<span>接种单位：${organName}</span>
			</td>
			<td style="width: 50%; text-align: right;">
				<span>咨询电话：${organTel}</span>
			</td>
		</tr>
		<tr>
			<td colspan="2">(凭卡接种，每次接种时请带好本卡！)</td>
		</tr>
	</table>    	
</div>
<div  style="margin:20px 0px 0px 0px; font-size: 11px;">
	<div style="text-align: center; font-size: 16px; font-weight: bold;margin:20px 0px 20px 0px">
    	接种注意事项
	</div>
	<div class="postdiv">
		<div style="line-height: 200%">
			<div>1、必须严格按照预约日期完成疫苗的全程接种。</div>
			<div>2、接种后请在接种单位<b>留观30分钟</b>。</div>
			<div>3、注射疫苗期间可照常工作、学习，但忌饮、浓茶、咖啡及辛辣刺激性食物，并避免剧烈运动、过度疲劳、受凉，防治感冒。</div>
			<div>4、个别人接种后可产生不同程度的不良反应。如：注射部位局部反应（疼痛、红肿、硬结等），皮疹和荨麻疹过敏反应，发热或全身不适等全身反应。一般不需特殊处理,特殊情况可电话咨询接种单位，必要时可赴医院诊治。</div>
			<div>5、请妥善保管好此接种单，以便再次咬伤后处理时参考。</div>
		</div>
	</div>	
</div>