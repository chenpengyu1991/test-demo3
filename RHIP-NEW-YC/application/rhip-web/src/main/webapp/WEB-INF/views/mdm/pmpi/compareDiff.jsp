<%@ page language="java" pageEncoding="UTF-8"
         contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script type="text/javascript">
	$(document).ready(function() {
		var td1 = $("#compareTable tr td[flg='L']");
		var td2 = $("#compareTable tr td[flg='R']");
		if (td1.length == td2.length) {
			for (var i=0;i<td1.length;i++) {
				if (td1[i].innerHTML == td2[i].innerHTML) {
					// td1[i].bgColor="#66FFCC";
					// td2[i].bgColor="#66FFCC";
				} else {
					td1[i].bgColor="#F0F0F0";
					td2[i].bgColor="#dddddd";
				}
			}
		}
	});
</script>
<div class="content">
	<table id="compareTable" class="formtable">
		<tr flg="head">
			<td width="7%"></td>
			<td width="8%"></td>
			<td><b>${leftName}</b></td>
			<td><b>${rightName}</b></td>
		</tr>
		<tr><td colspan="3">个人系统信息</td></tr>
		<tr>
			<th colspan="2">个人主索引</th>
			<td flg="L">${leftPerson.pmpiId}</td>
			<td flg="R">${rightPerson.pmpiId}</td>
		</tr>
		<tr>
			<th colspan="2">系统域标识</th>
			<td flg="L">${leftPerson.domainId}</td>
			<td flg="R">${rightPerson.domainId}</td>
		</tr>
		<tr>
			<th colspan="2">本地系统标识</th>
			<td flg="L">${leftPerson.localId}</td>
			<td flg="R">${rightPerson.localId}</td>
		</tr>
		<tr><td colspan="3">个人基本信息</td></tr>
		<tr>
			<th colspan="2">姓名</th>
			<td flg="L">${leftPerson.name}</td>
			<td flg="R">${rightPerson.name}</td>
		</tr>
		<tr>
			<th colspan="2">拼音</th>
			<td flg="L">${leftPerson.cpy}</td>
			<td flg="R">${rightPerson.cpy}</td>
		</tr>
		<tr>
			<th colspan="2">身份证号</th>
			<td flg="L">${leftPerson.idCard}</td>
			<td flg="R">${rightPerson.idCard}</td>
		</tr>
		<tr>
			<th colspan="2">性别</th>
			<td flg="L"><ehr:dic dicmeta="GBT226112003" code="${leftPerson.gender}"/></td>
			<td flg="R"><ehr:dic dicmeta="GBT226112003" code="${rightPerson.gender}"/></td>
		</tr>
		<tr>
			<th colspan="2">其他证件类型</th>
			<td flg="L"><ehr:dic dicmeta="CV0201101" code="${leftPerson.otherCardType}"/></td>
			<td flg="R"><ehr:dic dicmeta="CV0201101" code="${rightPerson.otherCardType}"/></td>
		</tr>
		<tr>
			<th colspan="2">其他证件号码</th>
			<td flg="L">${leftPerson.otherCardNo}</td>
			<td flg="R">${rightPerson.otherCardNo}</td>
		</tr>
		<tr>
			<th colspan="2">出生日期</th>
			<td flg="L"><fmt:formatDate value="${leftPerson.birthday}"
			                                pattern="yyyy/MM/dd" /></td>
			<td flg="R"><fmt:formatDate value="${rightPerson.birthday}"
			                                pattern="yyyy/MM/dd" /></td>
		</tr>
		<tr>
			<th colspan="2">国家</th>
			<td flg="L"><ehr:dic dicmeta="GBT26592000" code="${leftPerson.nation}"/></td>
			<td flg="R"><ehr:dic dicmeta="GBT26592000" code="${rightPerson.nation}"/></td>
		</tr>
		<tr>
			<th colspan="2">民族</th>
			<td flg="L"><ehr:dic dicmeta="GBT3304" code="${leftPerson.nation}"/></td>
			<td flg="R"><ehr:dic dicmeta="GBT3304" code="${rightPerson.nation}"/></td>
		</tr>
		<tr>
			<th colspan="2">婚姻状况</th>
			<td flg="L"><ehr:dic dicmeta="GBT226122003" code="${leftPerson.marriage}"/></td>
			<td flg="R"><ehr:dic dicmeta="GBT226122003" code="${rightPerson.marriage}"/></td>
		</tr>
		<tr>
			<th colspan="2">学历代码</th>
			<td flg="L"><ehr:dic dicmeta="GBT46582006" code="${leftPerson.education}"/></td>
			<td flg="R"><ehr:dic dicmeta="GBT46582006" code="${rightPerson.education}"/></td>
		</tr>
		<tr><td colspan="3">个人其他信息</td></tr>
		<tr>
			<th colspan="2">本人电话</th>
			<td flg="L">${leftPerson.phoneNumber}</td>
			<td flg="R">${rightPerson.phoneNumber}</td>
		</tr>
		<tr>
			<th colspan="2">家庭电话</th>
			<td flg="L">${leftPerson.homePhone}</td>
			<td flg="R">${rightPerson.homePhone}</td>
		</tr>
		<tr>
			<th colspan="2">电子邮箱</th>
			<td flg="L">${leftPerson.email}</td>
			<td flg="R">${rightPerson.email}</td>
		</tr>
		<tr>
			<th colspan="2">单位/学校名称</th>
			<td flg="L">${leftPerson.unitName}</td>
			<td flg="R">${rightPerson.unitName}</td>
		</tr>
		<tr>
			<th colspan="2">单位/学校电话</th>
			<td flg="L">${leftPerson.unitPhone}</td>
			<td flg="R">${rightPerson.unitPhone}</td>
		</tr>
		<tr>
			<th colspan="2">职业类别</th>
			<td flg="L"><ehr:dic dicmeta="GBT6565" code="${leftPerson.occupation}"/></td>
			<td flg="R"><ehr:dic dicmeta="GBT6565" code="${rightPerson.occupation}"/></td>
		</tr>
		<tr><td colspan="3">个人联系地址</td></tr>
		<tr>
			<th rowspan="2">户籍地址</th>
			<th>完整地址</th>
			<td flg="L">${leftPerson.hrProvince}${leftPerson.hrCity}${leftPerson.hrCounty}${leftPerson.hrTownship}${leftPerson.hrStreet}${leftPerson.hrHouseNumber}</td>
			<td flg="R">${rightPerson.hrProvince}${rightPerson.hrCity}${rightPerson.hrCounty}${rightPerson.hrTownship}${rightPerson.hrStreet}${rightPerson.hrHouseNumber}</td>
		</tr>
		<tr>
			<th>邮政编码</th>
			<td flg="L">${leftPerson.hrPostcode}</td>
			<td flg="R">${rightPerson.hrPostcode}</td>
		</tr>
		<tr>
			<th rowspan="2">现住址</th>
			<th>完整地址</th>
			<td flg="L">${leftPerson.paProvince}${leftPerson.paCity}${leftPerson.paCounty}${leftPerson.paTownship}${leftPerson.paStreet}${leftPerson.paHouseNumber}</td>
			<td flg="R">${rightPerson.paProvince}${rightPerson.paCity}${rightPerson.paCounty}${rightPerson.paTownship}${rightPerson.paStreet}${rightPerson.paHouseNumber}</td>
		</tr>
		<tr>
			<th>邮政编码</th>
			<td flg="L">${leftPerson.paPostcode}</td>
			<td flg="R">${rightPerson.paPostcode}</td>
		</tr>
	</table>
</div>