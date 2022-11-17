<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<form id="continueEducation_form">
	<input type="hidden" name="id" value="${continueEducation.id}"/>
<div class="postcontent">
	<table class="posttable">
		<colgroup>
			<col style="width: 20%;" />
			<col style="width: 30%;" />
			<col style="width: 20%;" />
			<col style="width: 30%;" />
		</colgroup>
		<tr>
			<th>
				<label class="required">项目代号</label>
			</th>
			<td>
			    <input type="hidden" id="staffCode" name="staffCode" value="${continueEducation.staffCode}" reg="{'required':true,'maxlength':200}"/>
				<input type="text" id="projectNo" name="projectNo" value="${continueEducation.projectNo}" reg="{'required':true,'maxlength':200}"/>
			</td>
			<th>
				<label class="required">项目名称</label>
			</th>
			<td>
				<input type="text" id="projectName" name="projectName" value="${continueEducation.projectName}" reg="{'required':true,'maxlength':200}"/>
			</td>
		</tr>
		<tr>
			<th>
				<label class="required">举办单位</label>
			</th>
			<td>
				<input type="text" id="organizer" name="organizer" value="${continueEducation.organizer}" reg="{'required':true,'maxlength':200}"/>
			</td>
			<th>
				<label class="required">学时数</label>
			</th>
			<td>
				<input type="text" id="period" name="period" value="${continueEducation.period}" reg="{'required':true,'number':true,'maxlength':4}"/>
			</td>
		</tr>
		<tr>
			<th>
				<label class="required">一类学分</label>
			</th>
			<td>
				<input type="text" id="creditA" name="creditA" value="${continueEducation.creditA}" reg="{'required':true,'number':true,'maxlength':4}"/>
			</td>
			<th>
				<label class="required">二类学分</label>
			</th>
			<td>
				<input type="text" id="creditB" name="creditB" value="${continueEducation.creditB}" reg="{'required':true,'number':true,'maxlength':4}"/>
			</td>
		</tr>
		<tr>
			<th>
				<label class="required">登记年份</label>
			</th>
			<td>
				<input type="text" id="recordYear" name="recordYear" value="${continueEducation.recordYear}" reg="{'required':true,'length':4,'digits':true}"/>
			</td>
		</tr>
	</table>
    <div align="center"><br/>
		<input type="button" value="保存" class="search_btn" onclick="ceSearch.saveContinueEducation(getProject())"/>
	</div>
</div>
</form>
<script type="text/javascript">
    function getProject(){
    	var continueEducation = {};
    	$("input:text").each(function(i){
    		continueEducation[this.name] = this.value;
    	});
    	return continueEducation;
    }
</script>
