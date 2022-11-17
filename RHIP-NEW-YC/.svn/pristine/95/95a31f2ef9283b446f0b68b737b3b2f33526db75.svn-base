<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table class="posttable">
	<colgroup>
		<col style="min-width: 100px; width: 30%" />
		<col style="min-width: 150px; width: 70%" />
	</colgroup>
	<tr>
		<th><label class="required">第一种用药名称</label></th>
		<td><input type="text"  name="drugNameFirst" value="${drug.drugNameFirst}" reg="{'required':true,'maxlength':16}" /></td>
	</tr>
	<tr>
		<th><label class="required">第一种用药用法</label></th>
		<td>
		每日<tag:numberInput style="width:50px;"  name="drugPerdayFirst" value="${drug.drugPerdayFirst}" reg="{'required':true,'min':0,'max':99}" />次 , 每次
		<tag:numberInput  style="width:60px;" point="point" name="drugPertimeFirst" value="${drug.drugPertimeFirst}" reg="{'required':true,'min':0,'max':999999.99}" />
		<ehr:dic-list dicmeta="DMD00067" value="${drug.firstMedicateUnit}" reg="{'required':true}"  name="firstMedicateUnit" id="firstMedicateUnit"></ehr:dic-list>
		</td>
	</tr>
	
	<tr>
		<th>第二种用药名称</th>
		<td><input type="text" name="drugNameSecond" value="${drug.drugNameSecond}" reg="{'maxlength':16}" /></td>
	</tr>
	<tr>
		<th>第二种用药用法</th>
		<td>
		每日<tag:numberInput style="width:50px;" name="drugPerdaySecond" value="${drug.drugPerdaySecond}" reg="{'min':0,'max':99}" />次 , 每次
		<tag:numberInput  style="width:60px;" point="point" name="drugPertimeSecond" value="${drug.drugPertimeSecond}" reg="{'min':0,'max':999999.99}" />
		<ehr:dic-list dicmeta="DMD00067" value="${drug.secondMedicateUnit}" name="secondMedicateUnit" id="secondMedicateUnit"></ehr:dic-list>
		
		</td>
	</tr>
	
	<tr>
		<th>第三种用药名称</th>
		<td><input type="text"   name="drugNameThird" value="${drug.drugNameThird}" reg="{'maxlength':16}" /></td>
	</tr>
	<tr>
		<th>第三种用药用法</th>
		<td>
		每日<tag:numberInput style="width:50px;" name="drugPerdayThird" value="${drug.drugPerdayThird}" reg="{'min':0,'max':99}" />次 , 每次
		<tag:numberInput  style="width:60px;" point="point" name="drugPertimeThird" value="${drug.drugPertimeThird}" reg="{'min':0,'max':999999.99}" />
		<ehr:dic-list dicmeta="DMD00067" value="${drug.thirdMedicateUnit}" name="thirdMedicateUnit" id="thirdMedicateUnit"></ehr:dic-list>
		</td>
	</tr>		
</table>
