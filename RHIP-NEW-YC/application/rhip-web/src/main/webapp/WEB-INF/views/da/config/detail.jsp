<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="postcontent contentfixed32" style="margin:10px 0px 0px 0px">
	<table class="posttable">
		<colgroup>
			<col style="min-width:400px; width: 100%;"/>
           </colgroup>
		<tbody>
			<tr>
               	<td style="float:right;"><b>${organName}</b></td>
			</tr>
		</tbody>
	</table>
	<fieldset>
		<legend>人员情况</legend>
		<table class="posttable">
			<colgroup>
				<col style="min-width:100px; width: 25%;"/>
				<col style="min-width:80px; width: 15%;"/>
				<col style="min-width:80px; width: 5%;"/>
				<col style="min-width:80px; width: 15%;"/>
				<col style="min-width:80px; width: 20%;"/>
				<col style="min-width:80px; width: 10%;"/>
				<col style="min-width:80px; width: 15%;"/>
            </colgroup>
			<tbody>
				<tr>
                	<th>药剂科从事药学专业技术工作</th>
                	<td><tags:numberLabel value="${config.technicianNum}" fractionDigits="0" defaultValue="0"/></td>
                	<td>人</td>
                	<th>药剂科负责人姓名</th>
                	<td>${config.leaderName}</td>
                	<th>职称</th>
                	<td>${config.leaderProfession}</td>
				</tr>
				<tr>
                	<th>联系电话1</th>
                	<td>${config.tel1}</td>
                	<td></td>
                	<th>联系电话2</th>
                	<td>${config.tel2}</td>
                	<td colspan="2" rowspan="2" style="vertical-align: middle;">(药房及药库的固定电话或人员手机)</td>
				</tr>	
				<tr>
                	<th>联系电话3</th>
                	<td>${config.tel3}</td>
                	<td></td>
                	<th>联系电话4</th>
                	<td>${config.tel4}</td>
				</tr>							
			</tbody>
		</table>		
	</fieldset>
	<fieldset>
		<legend>药品储存场所情况</legend>
		<table class="posttable">
			<colgroup>
				<col style="min-width:100px; width: 10%;"/>
				<col style="min-width:80px; width: 13%;"/>
				<col style="min-width:40px; width: 7%;"/>
				<col style="min-width:80px; width: 12%;"/>
				<col style="min-width:80px; width: 11%;"/>
				<col style="min-width:40px; width: 7%;"/>
				<col style="min-width:80px; width: 13%;"/>
				<col style="min-width:80px; width: 10%;"/>
				<col style="min-width:40px; width: 7%;"/>
            </colgroup>
			<tbody>
				<tr>
                	<th>药房总面积</th>
                	<td><tags:numberLabel value="${config.allPharmacyArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
                	<th>门诊药房面积</th>
                	<td><tags:numberLabel value="${config.outpatientArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
                	<th>急诊药房面积</th>
                	<td><tags:numberLabel value="${config.emergencyArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
				</tr>
				<tr>
                	<th>中药房总面积</th>
                	<td><tags:numberLabel value="${config.pharmacyChineseArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
                	<th>中心药房面积</th>
                	<td><tags:numberLabel value="${config.centerArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
                	<th>配置中心总面积</th>
                	<td><tags:numberLabel value="${config.congifCenterArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
				</tr>
				<tr>
                	<th>其他面积</th>
                	<td><tags:numberLabel value="${config.otherPharmacyArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td  colspan="7">平方米</td>
				</tr>
				<tr>
                	<th>药库总面积</th>
                	<td><tags:numberLabel value="${config.storageArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
                	<th>中药库面积</th>
                	<td><tags:numberLabel value="${config.storageChineseArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
                	<th>西药库面积</th>
                	<td><tags:numberLabel value="${config.storageWesternArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
				</tr>
				<tr>
                	<th>危险品库面积</th>
                	<td><tags:numberLabel value="${config.dangerArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
                	<th>特殊药品库面积</th>
                	<td><tags:numberLabel value="${config.specialArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
                	<th>管理专柜</th>
                	<td><tags:numberLabel value="${config.managementNum}" fractionDigits="0" defaultValue="0"/></td>
                	<td>个</td>
				</tr>	
				<tr>
                	<th>常温库面积</th>
                	<td><tags:numberLabel value="${config.roomArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
                	<th>阴凉库面积</th>
                	<td><tags:numberLabel value="${config.coolTempArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>平方米</td>
                	<th>冷藏库容积</th>
                	<td><tags:numberLabel value="${config.coldStorageArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td>立方米</td>
				</tr>
				<tr>
                	<th>冷藏柜</th>
                	<td><tags:numberLabel value="${config.coldCupboardNum}" fractionDigits="0" defaultValue="0"/></td>
                	<td>个</td>
                	<th>其他面积</th>
                	<td><tags:numberLabel value="${config.otherStorageArea}" fractionDigits="2" defaultValue="0"/></td>
                	<td colspan="4">平方米</td>
 				</tr>					
				<tr>
                	<th>独立空调</th>
                	<td><tags:numberLabel value="${config.airconNum}" fractionDigits="0" defaultValue="0"/></td>
                	<td>台</td>
                	<th>中央空调</th>
                	<td><tags:numberLabel value="${config.vrvNum}" fractionDigits="0" defaultValue="0"/></td>
                	<td colspan="4">台</td>
 				</tr>				
			</tbody>
		</table>		
	</fieldset>	
	<table class="posttable">
		<colgroup>
			<col style="min-width:400px; width: 100%;"/>
           </colgroup>
		<tbody>
			<tr>
               	<td>(以上没有的信息填"0")</td>
			</tr>
		</tbody>
	</table>
	<div class="toolbar">
	    <a href="javascript:void(0)" onclick="configSearch.closePopUp()"><b class="fanhui">关闭</b></a>
	</div>	
</div>

