<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<input type="hidden" id="hsaInspRecordHiddenId" value="${inspRecord.id}" name="id"/>
<input type="hidden" id="hsaInspRecordIsGuide" value="${inspRecord.isGuide}" />
<input type="hidden" id="hsaInspRecordIsReport" value="${inspRecord.isReport}" />
<fieldset>
	<table class="posttable">
		<colgroup>
			<col style="width: 15%; min-width: 100px;" />
					<col style="width: 35%; min-width: 200px;" />
					<col style="width: 15%; min-width: 100px;" />
					<col style="width: 35%; min-width: 200px;" />
		</colgroup>
		<tr>
			<c:if test="${flag=='view'}">
				<th><label for="findMainPro">发现的主要问题</label></th>
				<td><input type="text" id="findMainPro" name="findMainPro" value="${inspRecord.findMainPro}" readonly="readonly" ></input></td>
				<th><label for="inspDate">巡查日期</label></th>
				<td><input type="text"  readonly="readonly" value='<fmt:formatDate value="${inspRecord.inspDate}" pattern="yyyy/MM/dd"/>' /></td>
			</c:if>
			
			<c:if test="${flag!='view'}">
				<th><label class="required" for="findMainPro">发现的主要问题</label></th>
				<td><input type="text" id="findMainPro" name="findMainPro" value="${inspRecord.findMainPro}" reg="{'required':true,'maxlength':30}"    ></input></td>
				<th><label  class="required" for="inspDate">巡查日期</label></th>
				<td><tag:dateInput  name="inspDate" id="inspDate" onlypast="true" date="${inspRecord.inspDate}" reg="{'required':true}" /></td>
			</c:if>
		</tr>
		
		
		<tr>
			<c:if test="${flag=='view'}">
				<th><label for="inspPersonName">巡查人</label></th>
				<td><input type="text" id="inspPersonName" name="inspPersonName" value="${inspRecord.inspPersonName}" reg="{'maxlength':50}"  readonly="readonly"></input></td>
				<th><label for="remark">备注</label></th>
				<td><input type="text" id="remark" name="remark" value="${inspRecord.remark}" reg="{'maxlength':200}" readonly="readonly"></input></td>
			</c:if>
			
			<c:if test="${flag!='view'}">
				<th><label  class="required" for="inspPersonName">巡查人</label></th>
				<td><input type="text" id="inspPersonName" name="inspPersonName" value="${inspRecord.inspPersonName}" reg="{'maxlength':30,'required':true}"  ></input></td>
				<th><label for="remark">备注</label></th>
				<td><input type="text" id="remark" name="remark" value="${inspRecord.remark}" reg="{'maxlength':40}" ></input></td>
			</c:if>
		</tr>
	</table>
</fieldset>
<div class="postdiv">
	<fieldset>
		<table class="posttable">
			<colgroup>
				<col style="width: 15%; min-width: 100px;" />
					<col style="width: 35%; min-width: 200px;" />
					<col style="width: 15%; min-width: 100px;" />
					<col style="width: 35%; min-width: 200px;" />
			</colgroup>
			<tr>
				<th><label for="isGuide">是否巡查指导</label></th>
				<td><ehr:dic-radio dicmeta="FS10246" value="${inspRecord.isGuide}" name="isGuide" id="isGuide" /></td>
			</tr>
		</table>
	</fieldset>
</div>
<div class="postdiv  ${inspRecord.isGuide ==1? '':'hide'}" id="hsa-guide-content">
	<jsp:include page="inspGuide.jsp"></jsp:include>
</div>
<div class="postdiv">
	<fieldset>
		<table class="posttable">
			<colgroup>
				<col style="width: 15%; min-width: 100px;" />
				<col style="width: 35%; min-width: 200px;" />
				<col style="width: 15%; min-width: 100px;" />
				<col style="width: 35%; min-width: 200px;" />
			</colgroup>
			<tr>
				<th><label for="isReport">是否报告登记</label></th>
				<td><ehr:dic-radio dicmeta="FS10246" value="${inspRecord.isReport}" name="isReport" id="isReport" /></td>
			</tr>
		</table>
	</fieldset>
</div>
<div class="postdiv ${inspRecord.isReport ==1? '':'hide'}" id="hsa-report-record-content">
	<jsp:include page="reportRecord.jsp"></jsp:include>
</div>