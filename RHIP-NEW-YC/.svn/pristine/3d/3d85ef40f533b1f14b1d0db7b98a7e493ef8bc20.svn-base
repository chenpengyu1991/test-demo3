<%--
  Created by IntelliJ IDEA.
  User: zheng_dandan
  Date: 13-5-16
  Time: 下午12:50
  To change this template use File | Settings | File Templates.
--%>
<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<head>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery1.7.2.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.jqprint.js"></script>
    <script type="text/javascript">
        $(function(){$("#print").click(function() {
            $("#printDetaile").jqprint();
//	    mainPageH.search(1);
//	    return;
        });});
    </script>
</head>

<body>
<div class="toolbar" style="text-align: right; margin-right: 20px;">
    <a href="javascript:void(0)" id="print"><b class="">打印</b></a>
</div>
<input type="hidden" name="ehrId" value="${ehrId}"/>
<input type="hidden" name="timesString" value="${timesString}"/>
<input type="hidden" id="barcode" value="${vaccinationEvent.barcode}"/>
<!-- 患者基本情况 -->
<div class="postcontent" id="printDetaile">
<div style="width:100%; font-size: 16px; font-weight: bold; float: left; text-align: center;">
    <div style="text-align: right;"><img src="${pageContext.request.contextPath}/barcode/show?msg=${vaccinationEvent.barcode}" height="50px" width="160px"/></div>
    <div style=" text-align: center; ">永城市狂犬病暴露医学处置记录卡</div>
</div>
<br/>
<div class="postdiv" style="clear:both;">
        一.患者基本情况
        <table style="width:99%; font-size: 14px;" class="posttable">
            <colgroup >
                <col width="15%" />
                <col width="15%" />
                <col width="15%" />
                <col width="15%" />
                <col width="20%" />
                <col width="20%" />
            <colgroup>
                <tbody>
                <tr>
                    <th style="text-align: right;">姓名：</th>
                    <td>${vaccinationMgmt.name}</td>
                    <th style="text-align: right;">身份证号码：</th>
                    <td>${vaccinationMgmt.idCard}</td>
                    <th style="text-align: right;">性别：</th>
                    <td><ehr:dic dicmeta="GBT226112003" code="${vaccinationMgmt.gender}"/></td>
                </tr>
                 <tr>
                	<th style="text-align: right;">监护人姓名：</th>
                    <td>${vaccinationMgmt.guardianNameText}</td>
                    <th style="text-align: right;">监护人联系电话：</th>
                    <td>${vaccinationMgmt.guardianPhoneText}</td>
                    <th style="text-align: right;">年龄：</th>
                    <td>${vaccinationMgmt.age}&nbsp;岁</td>
                </tr>
                <tr>
                    <th style="text-align: right;">体重：</th>
                    <td>${vaccinationMgmt.weight}&nbsp;公斤</td>
                    <th style="text-align: right;">联系电话：</th>
                    <td>${vaccinationMgmt.phoneNumber}</td>
                    <th style="text-align: right;">职业：</th>
                    <td><ehr:dic dicmeta="GBT6565" code="${vaccinationMgmt.occupation}" /></td>
                </tr>
                <tr>
                    <th style="text-align: right;">地址：</th>
                    <td><ehr:dic dicmeta="FS990001" code="${vaccinationMgmt.patownShip}" /><ehr:dic dicmeta="FS990001" code="${vaccinationMgmt.pastreet}" />${vaccinationMgmt.pahouseNumber}</td>
                    <th style="text-align: right;">就诊日期：</th>
                    <td><fmt:formatDate value="${traumaHistory.treatmentTime}" pattern='yyyy/MM/dd HH'/>时</td>
                </tr>
       			
            </tbody>
        </table>

</div>
<br/>
<div class="postdiv" style="clear:both;">
       二.狂犬疫苗接种史
        <table style="width:99%; font-size: 14px;" class="posttable">
            <colgroup >
                <col width="15%" />
                <col width="15%" />
                <col width="15%" />
                <col width="15%" />
                <col width="20%" />
                <col width="20%" />
            <colgroup>
                <tbody>
                <tr>
                    <th style="text-align: right;">伤人日期：</th>
                    <td><fmt:formatDate value="${traumaHistory.opsDate}" pattern='yyyy/MM/dd HH'/>时</td>
                    <th style="text-align: right;" >以前是否接种过人狂犬疫苗：</th>
                    <td	>
                        <ehr:dic dicmeta="PH00001" code="${vaccinationEvent.isInjected==null?2:vaccinationEvent.isInjected}"></ehr:dic>
                    </td>
                    <th style="text-align: right;">最近一次接种日期：</th>
                    <td>
                        <fmt:formatDate value="${vaccinationEvent.lastInjectedDate}" pattern='yyyy/MM/dd'/>
                    </td>
                </tr>
             	<tr>
                   	<th style="text-align: right;">全程接种是否完成：</th>
                    <td>
                        <c:if test="${vacciantionFlag eq 1}">是</c:if>
                        <c:if test="${vacciantionFlag ne 1}">否</c:if>
                    </td>
                    <th style="text-align: right;">一年内是否全程接种过：</th>
                    <td>
                        <c:if test="${vaccinationEvent.isOneYearInjected eq 1}">是</c:if>
                        <c:if test="${vaccinationEvent.isOneYearInjected ne 1}">否</c:if>
                    </td>
                    <th style="text-align: right;">一年前三年内是否全程接种过：</th>
           			<td>
                   		<c:if test="${vaccinationEvent.isThreeYearInjected eq 1}">是</c:if>
                   		<c:if test="${vaccinationEvent.isThreeYearInjected ne 1}">否</c:if>
                	</td>
             	</tr>
           	 	<tr>
           			<th style="text-align: right;">三年内是否加强接种过：</th>
            		<td>
                   		<c:if test="${vaccinationEvent.isPowerInjected eq 1}">是</c:if>
                   		<c:if test="${vaccinationEvent.isPowerInjected ne 1}">否</c:if>
                	</td>
                	<th style="text-align: right;">全程接种最后一剂接种时间：</th>
             		<td>
                		<fmt:formatDate value="${vaccinationEvent.lastFullInjectedDate}" pattern='yyyy/MM/dd'/>
                	</td>
                	<th style="text-align: right;">加强接种最后一剂接种时间：</th>
                	<td>
                		<fmt:formatDate value="${vaccinationEvent.lastPowerInjectedDate}" pattern='yyyy/MM/dd'/>
                	</td>
            	</tr>
           </tbody>
       </table>
</div>
<br/>
<div class="postdiv" style="clear:both;">
        三.暴露（被伤）情况
        <table style="width:99%; font-size: 14px;" class="posttable">
            <colgroup >
                <col width="15%" />
                <col width="15%" />
                <col width="15%" />
                <col width="15%" />
                <col width="20%" />
                <col width="20%" />
            <colgroup>
            <tbody>
                   <tr>
                 	<th style="text-align: right;">伤人动物：</th>
                    <td>${traumaHistory.hurtType}</td>
                	<th style="text-align: right;">动物来源：</th>
                    <td>${traumaHistory.hurtSource}</td>
                    <th style="text-align: right;">动物状态：</th>
                    <td>${traumaHistory.hurtStatus}</td>
                </tr>
                <tr>
                	<th style="text-align: right;">伤口部位：</th>
                    <td><ehr:dic dicmeta="FS990002" code="${traumaHistory.opsName}" /></td>
                	<th style="text-align: right;">暴露方式：</th>
                    <td>${traumaHistory.exposeType}</td>
                    <th style="text-align: right;">被伤性质：</th>
                    <td>${traumaHistory.hurtNature}</td>
                </tr>
            </tbody>
        </table>

</div>
<br/>
 <!-- 告知事项及处理措施 -->
<div class="postdiv">
		四.告知事项及处理措施
        <div style="font-size: 15px;">
        <b>
        	1.为安全有效地使用人狂犬病疫苗和狂犬病人免疫球蛋白，在您使用之前我们将有关信息告知于您。
        </b>
        </div>
        <div class="repeattable" style="font-size: 14px;">
            医生建议处置措施：
            <table border="1" style="width: 100%; margin-bottom: 0px; font-size: 14px;border-collapse: collapse;">
            	<colgroup >
                	<col width="10%" />
                	<col width="40%" />
                	<col width="30%" />
                	<col width="20%" />
           		<colgroup>
                <tbody>
                <tr>
                		<td>分级</td>
                        <td>接触方式</td>
                        <td>暴露程度</td>
                        <td>医生建议</td>
                </tr>
                <tr>
                    <c:if test="${traumaHistory.biteLevel eq '1'}">
                        <td>I级</td>
                        <td>符合以下情况之一者：<br/>1、接触或喂养动物；<br/>2、完好的皮肤被舔。<br/></td>
                        <td>无</td>
                        <td>确认接触方式可靠则不需处置。</td>
                        
                        
                    </c:if>
                    <c:if test="${traumaHistory.biteLevel eq '2'}">
                        <td>II级</td>
                        <td>符合以下情况之一者：<br/>1、裸露的皮肤被轻咬；<br/>2、无出血的轻微抓伤或擦伤。<br/></td>
                        <td><br/>轻度<br/><br/></td>
                        <td>
                            1、处理伤口；<br/>
                            2、接种人用狂犬病疫苗。<br/>
                        </td>
                        
                        
                    </c:if>
                    <c:if test="${traumaHistory.biteLevel eq '3'}">
                        <td>III级</td>
                        <td>符合以下情况之一者：<br/>1、单处或多处贯穿性皮肤咬伤或抓伤；<br/>2、破损皮肤被舔；<br/>3、开放性伤口或粘膜被污染。<br/></td>
                        <td><br/>重度<br/><br/></td>
                        <td>
                            1、处理伤口；<br/>
                            2、接种人用狂犬病疫苗。<br/>
                            3、注射狂犬病免疫球蛋白。<br/>
                        </td>
                        
                    </c:if>
                </tr>
                </tbody>
            </table>
        </div>
           <div class="repeattable" style="font-size: 14px;">
            伤口处理情况：
            <table border="1" style="width: 100%; margin-bottom: 0px; font-size: 14px;border-collapse: collapse;line-height:30px;">
                <colgroup >
                	<col width="10%" />
                	<col width="40%" />
                	<col width="30%" />
                	<col width="20%" />
           		<colgroup>
                <tbody>
                <tr>
                		<td>医疗机构</td>
                        <td>冲洗</td>
                        <td>消毒</td>
                        <td>其他处理</td>
                </tr>
                <tr>
                        <td>本门诊</td>
                        <td>冲洗方式：${traumaHistory.flushMethod} 冲洗时长：${traumaHistory.flushTime}</td>
                        <td>消毒剂：${traumaHistory.disInfectant} </td>
                        <td>其他处理：${traumaHistory.otherHandle} </td>
                     
                </tr>
                 <tr>
                        <td>其他</td>
                       	<td>冲洗方式：${traumaHistory.otherFlushMethod} 冲洗时长：${traumaHistory.otherFlushTime}</td>
                        <td>消毒剂：${traumaHistory.otherDisInfectant} </td>
                        <td>其他处理：${traumaHistory.otherHandles} </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div style="font-size: 14px;">
            <!-- <b style="font-size: 15px;">2.不良反应：</b>任何疫苗和药物使用后均有可能产生不良反应。如：注射部位局部反应（疼痛、红肿、硬结等）；皮疹和荨麻疹等过敏反应；发热或全身不适等全身反应。一般不需特殊处理。特殊情况可电话咨询接种单位，必要时可赴医院诊治。<br/> -->
            <!--<b style="font-size: 15px;">2.接种注意事项：</b>人狂犬病疫苗和狂犬病人免疫球蛋白都属于公民<b>自愿</b>接种；必须严格按照预约日期完成疫苗的全程接种；接种后请在接种单位<b>留观30分钟</b>；注射疫苗期间可照常工作、学习，但忌饮酒、浓茶、咖啡及辛辣刺激性食物，并避免剧烈运动、过度疲劳、受凉，防止感冒。<br/>-->
            <%--如出现轻微反应，一般不需特殊处理。特殊情况可电话咨询接种单位，必要时可赴医院诊治。<br/>--%>
            <b style="font-size: 15px;">2.被动免疫制剂使用记录：</b>
             <table border="1" style="width: 100%; font-size: 14px;border-collapse: collapse;line-height:30px;" >
                <tbody>
                <tr>
                    <th style="width: 12%" class="centerth">名称</th>
                    <th style="width: 12%" class="centerth">生产厂家</th>
                    <th style="width: 16%" class="centerth">批号</th>
                    <th style="width: 15%" class="centerth">有效期</th>
                    <th style="width: 15%" class="centerth">剂量(IU)</th>
                    <th style="width: 15%" class="centerth">注射部位</th>
                    <th style="width: 15%" class="centerth">注射时间</th>
                </tr>
                 <tr align="center">
	                    <td>&nbsp;</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	             </tr>
	             <tr align="center">
	                    <td>&nbsp;</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	             </tr>
                </tbody>
             </table>
            <b style="font-size: 15px;">3.接种情况：</b>
            <table border="1" style="width: 100%; font-size: 14px;border-collapse: collapse;line-height:30px;" >
                <tbody>
                <tr>
                    <th style="width: 12%" class="centerth">接种次数</th>
                    <th style="width: 12%" class="centerth">预约日期</th>
                    <th style="width: 16%" class="centerth">接种剂量(支)</th>
                    <th style="width: 15%" class="centerth">疫苗批次</th>
                    <th style="width: 15%" class="centerth">接种日期</th>
                    <th style="width: 15%" class="centerth">接种者签名</th>
                    <th style="width: 15%" class="centerth">生产厂家</th>
                </tr>
                <c:if test="${vacciantionFlag ne '1' && vaccinationEvent.rabiesType ne 5 && vaccinationEvent.rabiesType ne 9}">
	                <tr align="center">
	                    <td>第一次</td>
	                    <td><fmt:formatDate value="${reservation.firstDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                    <tr align="center">
	                    <td>第二次</td>
	                    <td><fmt:formatDate value="${reservation.firstDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                <tr align="center">
	                    <td>第三次</td>
	                    <td><fmt:formatDate value="${reservation.secondDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                <tr align="center">
	                    <td>第四次</td>
	                    <td><fmt:formatDate value="${reservation.thirdDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
                </c:if>
                <c:if test="${vacciantionFlag ne '1' && vaccinationEvent.rabiesType eq 5}">
	                <tr align="center">
	                    <td>第一次</td>
	                    <td><fmt:formatDate value="${reservation.firstDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                <tr align="center">
	                    <td>第二次</td>
	                    <td><fmt:formatDate value="${reservation.secondDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                <tr align="center">
	                    <td>第三次</td>
	                    <td><fmt:formatDate value="${reservation.thirdDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                 <tr align="center">
	                    <td>第四次</td>
	                    <td><fmt:formatDate value="${reservation.fourDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                 <tr align="center">
	                    <td>第五次</td>
	                    <td><fmt:formatDate value="${reservation.fiveDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
                </c:if>
                 <c:if test="${vacciantionFlag ne '1' && vaccinationEvent.rabiesType eq 9}">
	                <tr align="center">
	                    <td>第一次</td>
	                    <td><fmt:formatDate value="${reservation.firstDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                <tr align="center">
	                    <td>第二次</td>
	                    <td><fmt:formatDate value="${reservation.secondDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                <tr align="center">
	                    <td>第三次</td>
	                    <td><fmt:formatDate value="${reservation.thirdDate}" pattern="yyyy/MM/dd"/>或<fmt:formatDate value="${reservation.fourDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
                </c:if>
                 <c:if test="${vacciantionFlag eq '1' && vaccinationEvent.rabiesType ne 5 && vaccinationEvent.rabiesType ne 9}">
                 	<c:if test="${not empty reservation.firstDate}">
	                <tr align="center">
	                    <td>第一次</td>
	                    <td><fmt:formatDate value="${reservation.firstDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>
	                    1
	                    </td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
                 	</c:if>
                 	<c:if test="${not empty reservation.secondDate}">
	                <tr align="center">
	                    <td>第二次</td>
	                    <td><fmt:formatDate value="${reservation.secondDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                </c:if>
	                <c:if test="${not empty reservation.thirdDate}">
	                <tr align="center">
	                    <td>第三次</td>
	                    <td><fmt:formatDate value="${reservation.thirdDate}" pattern="yyyy/MM/dd"/></td>
	                    <td>1</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                </tr>
	                </c:if>
                </c:if>
                </tbody>
            </table>
            <b style="font-size: 15px;">4.接种不良反应记录：</b>
            <table border="1" style="width: 100%; font-size: 14px;border-collapse: collapse;line-height:30px;" >
                <tbody>
                <tr>
                    <th style="width: 12%" class="centerth">发现反应时间</th>
                    <th style="width: 12%" class="centerth">主要临床表现</th>
                    <th style="width: 16%" class="centerth">初步诊断</th>
                    <th style="width: 15%" class="centerth">处置措施</th>
                    <th style="width: 15%" class="centerth">转归</th>
                 <tr align="center">
	                    <td>&nbsp;</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	             </tr>
	             <tr align="center">
	                    <td>&nbsp;</td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	                    <td></td>
	             </tr>
                </tbody>
             </table>
            <%-- <b style="font-size: 15px;">5.转诊建议：</b>
            <b style="font-size: 15px;">在市医院、市二院、市中医院首诊接种人狂犬疫苗后，请您按预约日期，带好本知情同意书在白天医院上班时间（上午7:30~10:30，下午13:00~15:30），就近至社区卫生服务中心（卫生院）接种其余针次。城区及周边提供预防接种服务的单位（联系电话）如下：</b><br/>
            <b style="font-size: 15px;">兴隆社区卫生服务中心（52157302）&nbsp; 藕渠社区卫生服务中心（52977807/夜52977830）&nbsp;<br/>
谢桥社区卫生服务中心（52611129）&nbsp; 大义卫生院（52399008）&nbsp;<br/>
莫城社区卫生服务中心（52493309/夜52451146）&nbsp;
东南街道社区卫生服务中心（52975609） &nbsp;<br/>尚湖度假区社区卫生服务中心（52979902）（周一~周六）&nbsp;<br/>
其余各镇医院、卫生院（社区卫生服务中心）均提供接种服务。
</b><br/>
 <c:if test="${traumaHistory.biteLevel ne '3'}">
<b style="font-size: 15px;">本人已详细了解知情同意书的具体内容、充分理解了医生的建议，对其所建议的处置措施已作出了自主选择，同意接种人用狂犬病疫苗，并签字确认！</b>
</c:if>
 <c:if test="${traumaHistory.biteLevel eq '3'}">
<b style="font-size: 15px;">本人已详细了解知情同意书的具体内容、充分理解了医生的建议，对其所建议的处置措施已作出了自主选择，同意接种<span style="font-size: 20">□</span>/不同意接种<span style="font-size: 20">□</span>狂犬病人免疫球蛋白，并签字确认！</b> 
</c:if>--%>
        </div>
    <div class="postdiv" style="margin-top: 25px;">
        <table style="font-size: 16px;">
            <colgroup>
                <col style="width: 25%">
                <col style="width: 30%">
            </colgroup>
            <tr>
                <th style="text-align: left;">首诊医生（签名）：______________</th>
                <th style="text-align: right;">受种者（或监护人）签字：______________</th>
            </tr>
	    <tr>
		<th style="text-align: left;">首诊单位：<ehr:tip><ehr:org code="${vaccinationEvent.createOrg}"/></ehr:tip></th>
		<th style="text-align: right;">日期：<fmt:formatDate value="${currentDt}" pattern="yyyy/MM/dd"/></th>
	    </tr>
        </table>
    </div>
</div>
<br/>

</div>
</body>
</html>