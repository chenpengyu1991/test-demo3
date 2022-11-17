<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<fieldset>
	<table class="posttable">
		<colgroup>
			<col style="width: 15%; min-width: 100px;" />
					<col style="width: 35%; min-width: 200px;" />
					<col style="width: 15%; min-width: 100px;" />
					<col style="width: 35%; min-width: 200px;" />
		</colgroup>
		<tr>
			<th><label class="required" for="findMainPro">发现的主要问题</label></th>
			<td><input type="text" id="findMainPro" name="findMainPro"  reg="{'required':true,'maxlength':30}"    ></input></td>
			<th><label  class="required" for="inspDate">巡查日期</label></th>
			<td><tag:dateInput  name="inspDate" id="inspDate" onlypast="true" date="${inspRecord.inspDate}" reg="{'required':true}" /></td>
		</tr>
		
		
		<tr>
			<th><label  class="required" for="inspPersonName">巡查人</label></th>
			<td><input type="text" id="inspPersonName" name="inspPersonName"  reg="{'maxlength':30,'required':true}"  ></input></td>
			<th><label for="remark">备注</label></th>
			<td><input type="text" id="remark" name="remark"  reg="{'maxlength':40}" ></input></td>
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
				<td><ehr:dic-radio dicmeta="FS10246" name="isGuide" id="isGuide" value="2" /></td>
			</tr>
		</table>
	</fieldset>
</div>
<div class="postdiv hide" id="hsa-guide-content">
	<jsp:include page="locationInspGuide.jsp"></jsp:include>
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
					<td><ehr:dic-radio dicmeta="FS10246" name="isReport" id="isReport" value="2"/></td>
				</tr>
			</table>
		</fieldset>
	</div>
	<div class="postdiv hide"  id="hsa-report-record-content">
		<jsp:include page="reportRecord.jsp"></jsp:include>
	</div>

