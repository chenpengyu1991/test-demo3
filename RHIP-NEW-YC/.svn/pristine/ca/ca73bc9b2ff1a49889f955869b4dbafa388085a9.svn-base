<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" %>
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
					td1[i].bgColor="#66FFCC";
					td2[i].bgColor="#66FFCC";
				} else {
					td1[i].bgColor="#FFFF99";
					td2[i].bgColor="#FFFF99";
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
		<tr><td colspan="3">人员职业信息</td></tr>
		<tr>
			<th colspan="2">人员主索引</th>
			<td flg="L">${leftStaff.smpiId}</td>
			<td flg="R">${rightStaff.smpiId}</td>
		</tr>
		<tr>
			<th colspan="2">所在机构</th>
			<td flg="L">${leftStaff.organCode}</td>
			<td flg="R">${rightStaff.organCode}</td>
		</tr>
		<tr>
			<th colspan="2">所在科室</th>
			<td flg="L">${leftStaff.deptCode}</td>
			<td flg="R">${rightStaff.deptCode}</td>
		</tr>
		<tr>
			<th colspan="2">资格证书编码</th>
			<td flg="L">${leftStaff.qualCert}</td>
			<td flg="R">${rightStaff.qualCert}</td>
		</tr>
		<tr>
			<th colspan="2">执业证书编码</th>
			<td flg="L">${leftStaff.pracCert}</td>
			<td flg="R">${rightStaff.pracCert}</td>
		</tr>
		<tr>
			<th colspan="2">执业级别</th>
			<td flg="L">${leftStaff.practiceLevel}</td>
			<td flg="R">${rightStaff.practiceLevel}</td>
		</tr>
		<tr>
			<th colspan="2">执业类别</th>
			<td flg="L">
                <ehr:dic dicmeta="FS990008" code="${leftStaff.practiceType}"/>
            </td>
			<td flg="R">
                <ehr:dic dicmeta="FS990008" code="${rightStaff.practiceType}"/>
            </td>
		</tr>
		<tr>
			<th colspan="2">执业科目</th>
			<td flg="L">${leftStaff.practiceSubject}</td>
			<td flg="R">${rightStaff.practiceSubject}</td>
		</tr>

		<tr><td colspan="3">人员基本信息</td></tr>
		<tr>
			<th colspan="2">姓名</th>
			<td flg="L">${leftStaff.name}</td>
			<td flg="R">${rightStaff.name}</td>
		</tr>
		<tr>
			<th colspan="2">拼音</th>
			<td flg="L">${leftStaff.cpy}</td>
			<td flg="R">${rightStaff.cpy}</td>
		</tr>
		<tr>
			<th colspan="2">身份证号</th>
			<td flg="L">${leftStaff.idCard}</td>
			<td flg="R">${rightStaff.idCard}</td>
		</tr>
		<tr>
			<th colspan="2">性别</th>
			<td flg="L"><ehr:dic dicmeta="GBT226112003" code="${leftStaff.gender}"/></td>
			<td flg="R"><ehr:dic dicmeta="GBT226112003" code="${rightStaff.gender}"/></td>
		</tr>
		<tr>
			<th colspan="2">出生日期</th>
			<td flg="L"><fmt:formatDate value="${leftStaff.birthday}" pattern="yyyy/MM/dd"/></td>
			<td flg="R"><fmt:formatDate value="${rightStaff.birthday}" pattern="yyyy/MM/dd"/></td>
		</tr>
		<tr>
			<th colspan="2">民族</th>
			<td flg="L"><ehr:dic dicmeta="GBT3304" code="${leftStaff.nation}"/></td>
			<td flg="R"><ehr:dic dicmeta="GBT3304" code="${rightStaff.nation}"/></td>
		</tr>
		<tr>
			<th colspan="2">婚姻状况</th>
			<td flg="L"><ehr:dic dicmeta="GBT226122003" code="${leftStaff.marriage}"/></td>
			<td flg="R"><ehr:dic dicmeta="GBT226122003" code="${rightStaff.marriage}"/></td>
		</tr>
		<tr>
			<th colspan="2">学历</th>
			<td flg="L"><ehr:dic dicmeta="GBT46582006" code="${leftStaff.education}"/></td>
			<td flg="R"><ehr:dic dicmeta="GBT46582006" code="${rightStaff.education}"/></td>
		</tr>
		<tr>
			<th colspan="2">党派</th>
			<td flg="L"><ehr:dic dicmeta="GBT47631984" code="${leftStaff.party}"/></td>
			<td flg="R"><ehr:dic dicmeta="GBT47631984" code="${rightStaff.party}"/></td>
		</tr>

		<tr><td colspan="3">人员其他信息</td></tr>
		<tr>
			<th colspan="2">住宅电话</th>
			<td flg="L">${leftStaff.homeTel}</td>
			<td flg="R">${rightStaff.homeTel}</td>
		</tr>
		<tr>
			<th colspan="2">手机</th>
			<td flg="L">${leftStaff.mobile}</td>
			<td flg="R">${rightStaff.mobile}</td>
		</tr>
		<tr>
			<th colspan="2">电子邮箱</th>
			<td flg="L">${leftStaff.mail}</td>
			<td flg="R">${rightStaff.mail}</td>
		</tr>
		<tr>
			<th colspan="2">毕业学校</th>
			<td flg="L">${leftStaff.university}</td>
			<td flg="R">${rightStaff.university}</td>
		</tr>
		<tr>
			<th colspan="2">所学专业</th>
			<td flg="L">${leftStaff.speciality}</td>
			<td flg="R">${rightStaff.speciality}</td>
		</tr>
		<tr>
			<th colspan="2">最高学位</th>
			<td flg="L"><ehr:dic dicmeta="GBT6864" code="${leftStaff.degree}"/></td>
			<td flg="R"><ehr:dic dicmeta="GBT6864" code="${rightStaff.degree}"/></td>
		</tr>

		<tr><td colspan="3">人员联系地址</td></tr>
		<tr>
			<th rowspan="3">家庭住址</th>
			<!-- <th>行政区划代码</th> -->
			<td flg="L">${leftStaff.gbCode}</td>
			<%-- <td flg="R">${rightStaff.gbCode}</td> --%>
		</tr>
		<tr>
			<th>完整地址</th>
			<td flg="L">${leftStaff.paProvince}${leftStaff.paCity}${leftStaff.paCounty}${leftStaff.paTownship}${leftStaff.paStreet}${leftStaff.paHouseNumber}</td>
			<td flg="R">${rightStaff.paProvince}${rightStaff.paCity}${rightStaff.paCounty}${rightStaff.paTownship}${rightStaff.paStreet}${rightStaff.paHouseNumber}</td>
		</tr>
		<tr>
			<th>邮政编码</th>
			<td flg="L">${leftStaff.paPostcode}</td>
			<td flg="R">${rightStaff.paPostcode}</td>
		</tr>
	</table>
</div>