<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div>
	<input type="hidden" id="pageIndex" value="${pageIndex}">
    <div class="toolbar">
        <a href="javascript:leprosyCommon.returnSearch('contact.searchTemp')" id="cancelContact"><b class="fanhui">返回</b></a>
        <c:if test="${logoff != 1 }">
	        <a href="javascript:void(0)" onclick="javascript:contact.initAddCc()" id="xinzeng" style="display: none"><b class="xinz">新增</b></a>
	        <%--<a href="javascript:void(0)" onclick="javascript:contact.updateCc()" id="xiugai" style="display: none"><b class="xiug">修改</b></a>--%>
            <a href="javascript:void(0)" onclick="javascript:contact.updateCc()" id="xiugai" style="display: none"><b class="baocun">保存</b></a>
            <a href="javascript:void(0)" onclick="javascript:contact.addCc()" id="baocun" ><b class="baocun">保存</b></a>
	        <a href="javascript:void(0)" onclick="javascript:contact.deleteCc()" id="shanchu" style="display: none"><b class="zuofei">删除</b></a>
        </c:if>
    </div>
    <div class="repeattable" id="contactsList" style="width:300px; float: left;margin-right: 10px;margin-left: 10px; margin-top: 10px;">
        <table id="ccList">
            <colgroup>
                <col style="width:20px"/>
                <col style="width:50px"/>
                <col style="width:50px"/>
                <col style="width:50px"/>
            </colgroup>
            <thead>
            <tr>
                <th class="centerth">序号</th>
	            <th class="centerth" style="width: 10%">接触者姓名</th>
	            <th class="centerth" style="width: 35%">与接触者关系</th>
	            <th class="centerth" style="width: 35%">阳性体征</th>
            </tr>
            </thead>
            <tbody>
             <c:forEach var="listCc" items="${listCcs}" varStatus="status">
                 <tr onclick="contact.clickRow(this)" id="${listCc.id}">
                     <td>${status.index + 1}</</td>
                     <td><ehr:tip>${listCc.closeName}</ehr:tip></td>
                     <td><ehr:tip><ehr:dic code="${listCc.closeType}" dicmeta="IDM00249"/></ehr:tip></td>
                     <td><ehr:tip><ehr:dic code="${listCc.positiveSigns}" dicmeta="PH00002"/></ehr:tip></td>
                  </tr>
                </c:forEach>
            </tbody>
        </table>
        <table class="mini">
            <tr>
                <ehr:pagination-mini action="contact.searchContactList" colspan="4" />
            </tr>
        </table>
    </div>
    <div class="postcontent postdiv" id="detailDiv">
        <fieldset style="margin-top: 10px">
            <legend>麻风密切接触者登记</legend>
            <form id="ccForm">${listCc.idmId}
            	<input type="hidden" id="singleIdContact" name="idmId" value="${idmId == null ? listCc.idmId : idmId}">
                <input type="hidden" id="frId" name="id" value="${listCc.id}">
                <table class="formtable" id="popVillageTable">
					<colgroup>
						<col style="width: 30%" />
						<col style="width: 70%" />
					</colgroup>
					<tr>
                        <th>患者姓名：</th>
                        <td>${generalCondition.name}<input type="hidden" name="patientName" value="${generalCondition.name}"/></td>
                    </tr>
					<tr>
						<th><label class="required">接触者姓名：</label></th>
						<td><input type="text" name="closeName" value="${listCc.closeName}" reg='{"required":"true","maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th>性别：</th>
						<td><ehr:dic-radio dicmeta="GBT226112003" code="1,2"  name="sex" value="${listCc.sex}"/> </td>
					</tr>
					<tr>
						<th>年龄：</th>
						<td><input type="text" name="age" value="${listCc.age}" reg='{"maxlength":"20"}'/></td>
					</tr>
					<tr>
						<th>详细地址：</th>
						<td><input type="text" name="address" value="${listCc.address}" reg='{"maxlength":"100"}'/></td>
					</tr>
					<tr>
						<th><label class="required">与接触者关系：</label></th>
						<td><ehr:dic-radio dicmeta="IDM00249" name="closeType" value="${listCc.closeType}" reg='{"required":"true"}'
	                                           onchange="contact.changeType('closeType')"/>
	                        <span id="closeDetail1" style="${listCc.closeType == '1' ? '' : 'display:none;'}">
	                        	<ehr:dic-list name="closeDetail" id="closeDetail" dicmeta="IDM00055" code="2,3,5,7,99" value="${listCc.closeDetail}" reg='{"required":"true"}'/>
	                        </span>
	                        <span id="closeDetail2" style="${listCc.closeType == '2' ? '' : 'display:none;'}">
	                        	<ehr:dic-list name="checkSympton" id="checkSympton" dicmeta="IDM00057" code="2,3,4,99" value="${listCc.checkSympton}" reg='{"required":"true"}'/>
	                        </span>
	                    </td>
					</tr>
					<tr>
						<th>麻风阳性体征：</th>
						<td>
							<ehr:dic-radio dicmeta="PH00002" code="1,2" name="positiveSigns" value="${listCc.positiveSigns}"
								onchange="toggleOther('positiveSigns','diagnosisResultDetail','1')"/>
							<span id="diagnosisResultDetail" style="${listCc.positiveSigns == '1' ? '' : 'display:none;'}">
								类型及诊断依据：<input type="text" name="diagnosisResultDetail" value="${listCc.diagnosisResultDetail}" reg='{"maxlength":"50"}' style="width: 40%;">
							</span>
						 </td>
					</tr>
					<tr>
						<th>检查医生：</th>
						<td><input type="text" name="dorctorName" value="${listCc.dorctorName}" reg='{"maxlength":"50"}'/></td>
					</tr>
					<tr>
						<th>检查日期：</th>
						<td><tag:dateInput nullToToday="true" name="registDt" pattern="yyyy/MM/dd" onlypast="true" date="${listCc.registDt}"/></td>
					</tr>
				</table>
            </form>
            </fieldset>
	</div>
</div>