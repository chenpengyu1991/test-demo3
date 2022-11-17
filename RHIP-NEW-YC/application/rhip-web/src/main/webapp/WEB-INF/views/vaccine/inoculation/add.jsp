<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript">
$(function(){ 
	validate = $("#addInoculationForm").easyValidate();
	$.Placeholder.init({query: "#idCardTemp", callback: function (element) {
    queryPerson($(element).val());
	}})
});
function queryPerson(idCard) {
        $.getJsonByUrl({
            url: "/inoculation/queryPerson",
            wait: true,
            callback: function (data) {
                if (!isEmpty(data)) {
                	if (data.flag == 'invalid') {
                		$("#inoculationInvalidFlag").val("1"); // 设置标记用来判断保存操作是否可以
                		/* msgUtil.alert("该患者在5年内预约过,请核实情况再操作！");
                		return; */
                	}else{
                		 $("#inoculationInvalidFlag").val(""); //5年内没有查询到预约记录，清空标记
                	}
                	if(data.vaccineType1){
                		$("#vaccineType1").val("1"); // 设置标记用来判断保存操作是否可以
                		/* msgUtil.alert("患者必须年满65周岁且未满85周岁");
                		return; */
                	}else{
                		$("#vaccineType1").val(""); //病人年满65周岁且未满85周岁，清空标记
                	}
                	if(data.vaccineType3){
                		$("#vaccineType3").val("1"); // 设置标记用来判断保存操作是否可以
                	}else{
                		 $("#vaccineType3").val("");//病人年满6个月，清空标记
                	}
                	if(data.vaccineType4){
                		$("#vaccineType4").val("1"); // 设置标记用来判断保存操作是否可以
                	}else{
                		  $("#vaccineType4").val("");//病人年满3年，清空标记
                	}
                    if (data.personInfoFlag) {
                        setPersonData(data);
                    }else{
                        setIcData(data.Idcard);
                    }
                   
                }
            },
            param: {idCard: idCard}
        });
    
}
/**
 * 根据身份证获取信息
 */
function setPersonData(data) {
    $("input[name='personIdcard']").val(data.Idcard);
    $("input[name='personName']").val(data.Name);
    var gender;
    if (isEmpty(data.Gender)) {
        gender = IC.getGender(data.Idcard);
    } else {
        gender = data.Gender;
    }
    $("input[name='gender'][value='" + gender + "']").attr("checked", true);
    $("input[name='personAddress']").val(data.PaAddress);
    $("input[name='phoneNumber']").val(data.PhoneNumber);
   	if(data.DiseaseHistory!=null){
    	document.getElementById("diseaseHistory").innerHTML =data.DiseaseHistory;
	}

}
/*如果获取患者信息失败，根据身份证号码获取性别、出生日期*/
function setIcData(idCard) {
    var gender = IC.getGender(idCard);
    if (!isEmpty(gender)) {
        $('#gender').val(gender);
    }
    var birthday = IC.getBirthday(idCard);
    if (!isEmpty(birthday)) {
        $('#birthday').val(birthday);
    }
}


</script>
<div>	
	<div class="toolbar">
	 <a href="javascript:void(0)" onclick="inoculationIndex.saveInoculation(${inoculationAppointment.id})"><b class="baocun">保存</b></a>
	</div>
<form id="addInoculationForm">
	<input type="hidden" id="inoculationInvalidFlag"> 
	<input type="hidden" id="vaccineType1"> 
	<input type="hidden" id="vaccineType3"> 
	<input type="hidden" id="vaccineType4"> 
<div class="postcontent">
	<table class="posttable">
		<colgroup>
			<col style="width: 15%;"/>
			<col style="width: 35%;"/>
			<col style="width: 15%;"/>
			<col style="width: 35%;"/>
		</colgroup>
		<tbody>
			<tr>
				<th>姓名</th>
				<td><input type="text" name="personName"  reg="{'required':true,'maxlength':50}"/></td>
				<th>性別</th>
				<td><ehr:dic-radio id="gender" uninclude="0,9" dicmeta="GBT226112003" name="gender" reg="{'required':true}"/></td>
			</tr>
			<tr>
				<th>身份证</th>
				<td><input type="text" id="idCardTemp" name="personIdcard"  reg='{"idCard":true}' placeholder="输入身份证获取人员信息"/></td>
				<th>电话</th>
				<td><input type="text" name="phoneNumber" reg="{'required':true,'regex':'phone'}"/></td>
				
			</tr>
			<tr>
				<th>住址</th>
				<td> <input type="text" id="personAddress" name="personAddress"  style="width: 100%;"/></td>
				<th>预约机构</th>
				<c:if test="${currentLoginInfo.organization.organName eq '永城市疾病预防控制中心'}">
                <td class="colinput">
	               <ehr:org-type-list name="organCode" type="centre" value="${currentOrgCode}" width="51%"  reg="{'required':true}" codeOther="46714114-9"/>
                </td>
                </c:if>
                <c:if test="${currentLoginInfo.organization.organName ne '永城市疾病预防控制中心'}">
                <td class="colinput">
                  <input  style="width:51%" readonly="readonly" type="text" name="createOrgshow" reg="{'required':true}" value="${currentLoginInfo.organization.organName}" />
                  <input  style="width:51%" type="hidden" name="organCode" reg="{'required':true}" value="${currentLoginInfo.organization.organCode}" />
                  </td>
                </c:if>
			</tr>
			<tr>
				<th>预约时间</th>
				<td>
					<tag:dateInput  nullToToday="true" id="createDate" name="createDate" reg="{'required':true}" style="width:25%" pattern="yyyy/MM/dd HH:mm:ss"  />
				</td>
				<th>疫苗类型</th>
				<td> 
					<select name="vaccineType" id="vaccineType" style="width:50%" >
                    	<option value="1">老年人23价疫苗预约</option>
						<option value="3">3价流感疫苗预约</option> 
                    	<option value="4">4价流感疫苗预约</option>
                    </select>
				</td>
			</tr>
			
			<tr>
				<th>既往疾病史</th>
				<td colspan="3" id="diseaseHistory">
					
				</td>
			</tr>
		</tbody>
	</table>
	</div>
	</form>
</div>

