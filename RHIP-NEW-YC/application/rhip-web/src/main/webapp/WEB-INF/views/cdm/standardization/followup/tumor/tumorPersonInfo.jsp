<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/ehr/person/addCover.js" type="text/javascript"></script>
<div class="dm-followup-from-content">
    <form id="dm-followup-tumor-first-from" class="dm-followup-from">
        <input type="hidden" name="id" value="${diseaseInfo.id}" />
        <div class="postcontent">
            <div class="postdiv">
            <fieldset class="layui-elem-field">

                <legend>基本信息</legend>
                <input type="hidden" id="dis-person-id" name="personInfo.id" value="${personInfo.id}">
                <table class="posttable">
                    <%--<colgroup>
                        <col style="width: 15%;min-width:100px;" />
                        <col style="width: 35%;min-width:200px;" />
                        <col style="width: 15%;min-width:100px;" />
                        <col style="width: 35%;min-width:200px;" />
                        <col style="width: 35%;min-width:200px;" />
                        <col style="width: 35%;min-width:200px;" />
                    </colgroup>--%>
                    <tr>
                        <th><label class="required" class="required" for="name">姓名</label></th>
                        <td><input type="text" id="name" name="personInfo.name" value="${personInfo.name}" reg="{'required':true,'maxlength':16}" /></td>
                        <th><label class="required" class="required">性别</label></th>
                        <td><ehr:dic-radio id="gender" dicmeta="GBT226112003" uninclude="0,9" name="personInfo.gender" value="${personInfo.gender}" reg="{'required':true}" /></td>
                        <th><label class="required" class="required" for="birthday">出生日期</label></th>
                        <td>
                        <%-- <tag:dateInput name="personInfo.birthday" id="birthday" onlypast="true" reg="{'required':true}" date="${personInfo.birthday}" /> --%>
                        <input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" name="personInfo.birthday" id="tumorBirthdayId" value="<fmt:formatDate value='${personInfo.birthday}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required"   for="idcard2">身份证号</label></th>
                        <td>
                            <c:if test="${empty personInfo.idcard}">
                                <input type="text"  id="idcard2"   name="personInfo.idcard" placeholder="输入身份证获取人员信息" value="${personInfo.idcard}" style="width: 180px;" reg='{"required":true,"idCard":true}' />
                                <input type="button" id="check-submit-btn1" value="读卡" style="width: 40px;" >
                            </c:if>
                            <c:if test="${not empty personInfo.idcard}">
                                <input  type="text" id="idcard2"  readonly="readonly" name="personInfo.idcard" value="${personInfo.idcard}" reg='{"idCard":true}' style="width: 180px;" />
                            </c:if>
                        </td>
                        <th>年龄</th>
                        <td>
                            <input type="text" style="width: 50px;" name="age" id="age" value="${age}"  readonly="true"/>
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required" for="nation">民族</label></th>
                        <td><ehr:dic-list dicmeta="GBT3304" id="nation" width="180px;"   name="personInfo.nation" value="${personInfo.nation}" reg="{'required':true}" /></td>
                        <th><label class="required" for="education">文化程度</label></th>
                        <td><ehr:dic-list dicmeta="GBT46582006" code="IDM17,20,IDM18,IDM19,IDM20,IDM21,IDM02,IDM07,IDM22,IDM10"   width="180px;"  value="${personInfo.education}" id="education" name="personInfo.education" reg="{'required':true}" /></td>
                        <th><label class="required" for="marriage">婚姻状况</label></th>
                        <td><ehr:dic-list dicmeta="GBT226122003" id="marriage" width="180px;"   name="personInfo.marriage" value="${personInfo.marriage}" reg="{'required':true}" /></td>
                    </tr>
                    <tr>
                        <th><label class="required" for="unitName">工作单位</label></th>
                        <td colspan="2"><input type="text" id="unitName" name="personInfo.unitName" value="${personInfo.unitName}" reg="{'required':true,'maxlength':46}" /></td>
                        <th><label class="required" for="occupation">职业（工种）</label></th>
                        <td><ehr:dic-list dicmeta="GBT6565"  width="180px;" code="0,1/2,3,4,5,6/7/8/9,X,Y,CV00031"   value="${personInfo.occupation}" id="occupation" name="personInfo.occupation" reg="{'required':true}" /></td>
                    </tr>
                    <tr>
                        <th><label class="required" for="firstGuardian">联系人</label></th>
                        <td><input id="firstGuardian" type="text" name="personInfo.firstGuardian" value="${personInfo.firstGuardian}" reg="{'required':true}" /></td>
                        <th><label class="required" for="guardianPhoneOne">联系电话1</label></th>
                        <td><input id="guardianPhoneOne" type="text" name="personInfo.guardianPhoneOne" value="${personInfo.guardianPhoneOne}" reg="{'required':true,'regex':'phone'}" /></td>
                        <th><label for="guardianPhoneTwo">联系电话2</label></th>
                        <td><input id="guardianPhoneTwo" type="text" name="personInfo.guardianPhoneTwo" value="${personInfo.guardianPhoneTwo}" reg="{'regex':'phone'}" /></td>
                    </tr>
                    <tr>
                        <th><label class="required">户口地址</label></th>
                        <td colspan="3">
                            <div class="${'2' eq personInfo.householdType?'hide':'' }" id="hr-address-select">

                            <ehr:dic-town-street-village
                                    villageId="homeVillage_address" townId="homeTown_address" streetId="homeStreet_address"
                                    villageName="personInfo.hrGroup" streetName="personInfo.hrstreet"
                                    townName="personInfo.hrtownShip" streetValue="${personInfo.hrstreet}"
                                    villageValue="${personInfo.hrGroup}" callback="addPersonCover.displayHrAddress"
                                    townValue="${personInfo.hrtownShip}" width="118px;" reg="{'dependOn':'personInfo.householdType','dependValue':'1','required':true}"/>


                            </div>

                            <span id="homeSpan" <c:if test='${"2" == personInfo.householdType}'> style="display: none;" </c:if> >
                                <label id="tempHrValue">
                                    <ehr:dic code="${personInfo.hrtownShip}" dicmeta="FS990001"/>
                                    <ehr:dic code="${personInfo.hrstreet}" dicmeta="FS990001"/>
                                    <ehr:dic code="${personInfo.hrGroup}" dicmeta="FS990001"/>
                                </label><br/>
                                <input type="hidden" name="personInfo.hrAddressDetail" id="orgHrName" value="${personInfo.hrAddressDetail}"/>
                            </span>
                            <input reg='{"required":true,"maxlength":50}' type="text" id="text_hrhouseNumber" name="personInfo.hrhouseNumber" value="${personInfo.hrhouseNumber}"/>(详细地址)
                        </td>
                    </tr>
                    <tr>
                        <th><label class="required">现住址</label></th>
                        <td colspan="3">

                            <ehr:dic-town-street-village villageId="village_address" streetId="street_address"
                                                         townId="town_address" villageName="personInfo.paGroup" streetName="personInfo.pastreet"
                                                         townName="personInfo.patownShip" villageValue="${personInfo.paGroup}" streetValue="${personInfo.pastreet}"
                                                         townValue="${personInfo.patownShip}" width="118px;" reg="{'required':true}" callback="addPersonCover.displayPaAddress"/>

                            <br />
                            <label id="tempPaValue">
                                <ehr:dic code="${personInfo.patownShip}" dicmeta="FS990001"/>
                                <ehr:dic code="${personInfo.pastreet}" dicmeta="FS990001"/>
                                <ehr:dic code="${personInfo.paGroup}" dicmeta="FS990001"/>
                            </label><br/>
                            <input type="hidden" name="personInfo.paAddressDetail" id="orgPaName" value="${personInfo.paAddressDetail}"/>
                            <input type="text" id="text_pahouseNumber" reg='{"required":true,"maxlength":50}'  name="personInfo.pahouseNumber" value="${personInfo.pahouseNumber}"/>(详细地址)

                        </td>
                    </tr>
                    <tr>
                        <th><label >肿瘤病名</label></th>
                        <td>
                            <input type="text" name="tumorType" readonly="readonly" value="${diseaseInfo.tumorType}" reg="{'maxlength':50}"/>
                            <input type="hidden" name="tumorFlag" value="${diseaseInfo.tumorFlag}">
                            <input type="hidden" name="tumorManagedFlag" value="${diseaseInfo.tumorManagedFlag}">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="tumorPrimaryPart">诊断(亚部位)</label></th>
                        <td><input type="text" id="tumorPrimaryPart" name="tumorPrimaryPart" value="${diseaseInfo.tumorPrimaryPart}" reg="{'maxlength':33}" /></td>
                        <th><label for="tumorPathologyType">病理类型</label></th>
                        <td><input type="text" id="tumorPathologyType" name="tumorPathologyType" value="${diseaseInfo.tumorPathologyType}" reg="{'maxlength':16}" /></td>
                    </tr>
                    <tr>
                        <th><label for="tumorMetastasisPart">继发(转移部位)</label></th>
                        <td  style="vertical-align:top;"><input type="text" id="tumorMetastasisPart" name="tumorMetastasisPart" value="${diseaseInfo.tumorMetastasisPart}"
                                                                reg="{'maxlength':33}"
                        /></td>
                        <th><label for="tumorDiagnosisDate">首次诊断日期</label></th>
                        <td><%-- <tag:dateInput onlypast="true" id="tumorDiagnosisDate" name="tumorDiagnosisDate" date="${diseaseInfo.tumorDiagnosisDate}" reg="{'greaterThan':'tumorAccidentDate'}" /> --%>
                        <input type="text" class="layui-input x-admin-content-sm-date" reg="{'greaterThan':'tumorAccidentDate'}" name="tumorDiagnosisDate" id="tumorDiagnosisDate" value="<fmt:formatDate value='${diseaseInfo.tumorDiagnosisDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                        </td>
                    </tr>
                    <tr>
                        <th><label for="diagnoseTypet">确诊时期别</label></th>
                        <%--<td>T<input type="text" id="diagnoseTypet" name="diagnoseTypet" value="${reportInfo.diagnoseTypet}" reg="{'maxlength':33}" />--%>
                            <%--N<input type="text" id="diagnoseTypen" name="diagnoseTypen" value="${reportInfo.diagnoseTypen}" reg="{'maxlength':33}" />--%>
                            <%--M<input type="text" id="diagnoseTypem" name="diagnoseTypem" value="${reportInfo.diagnoseTypem}" reg="{'maxlength':33}" />--%>
                        <%--</td>--%>
                        <th><label for="tumorClinical">临床分期</label></th>
                        <%--<td><input type="text" id="tumorClinical" name="tumorClinical" value="${reportInfo.tumorClinical}" reg="{'maxlength':33}" /></td>--%>

                    </tr>
                    <tr>
                        <th><label for="tumorDiagnosisDepends">诊断依据</label></th>
                        <td colspan="6"><ehr:dic-checkbox reg="{'required':true}" dicmeta="DMD00010" name="tumorDiagnosisDepends" value="${diseaseInfo.tumorDiagnosisDepends}"></ehr:dic-checkbox></td>
                    </tr>
                    <tr>
                        <th><label class="required" for="diagnosisOrganCode">诊断单位</label></th>
                        <td colspan="3">
                            <%--<ehr:org-type-list id="diagnosisOrganCode"  width="250px" reg="{'required':true}" name="diagnosisOrganCode" type="hospital,centre"  value="${diseaseInfo.diagnosisOrganCode}"/>--%>
                            <%--&lt;%&ndash;<c:if test="${hospitalaReport !=true}">&ndash;%&gt;--%>
                                <%--外地诊断:<input id="otherDiagnosisOrganFlag" type="checkbox" value="2" name="otherDiagnosisOrganFlag" ${diseaseInfo.otherDiagnosisOrganFlag eq '2' ?'checked':''}>--%>
                                <%--<input id="otherDiagnosisOrganName" style="width:150px " reg="{'maxlength':23,'dependOn':'otherDiagnosisOrganFlag','required':true}" type="text" value="${diseaseInfo.otherDiagnosisOrganName}" name="otherDiagnosisOrganName">--%>
                            <%--</c:if>--%>
                        </td>
                    <tr>
                        <th><label class="required">报告单位</label></th>
                        <td><input type="hidden" name="tumorCreateOrganCode" value="${diseaseInfo.tumorCreateOrganCode}" style="width: 180px"/>

                            <input type="text" readonly="readonly"
                                   name="tumorCreateOrganName" value="<ehr:org code="${diseaseInfo.tumorCreateOrganCode}"  />" style="width: 180px"/>
                        </td>

                        <th><label class="required" for="tumorCreateDate">报告日期</label></th>
                        <td>
                            <%-- <tag:dateInput style="width:178px;" onlypast="true" id="tumorCreateDate" name="tumorCreateDate" date="${diseaseInfo.tumorCreateDate}" reg="{'required':true}" /> --%>
                            <input type="text" class="layui-input x-admin-content-sm-date" reg="{'required':true}" placeholder="选择时间" name="tumorCreateDate" id="tumorCreateDateId" value="<fmt:formatDate value='${diseaseInfo.tumorCreateDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;" />
                        </td>
                        <th><label class="required">报告医生</label></th>
                        <td><input type="hidden" name="tumorCreateDoctorCode" value="${diseaseInfo.tumorCreateDoctorCode}" />
                            <c:if test="${not empty diseaseInfo.tumorCreateDoctorCode }">
                                <input type="text" readonly="readonly" name="tumorCreateDoctorName" value="<ehr:user userCode="${diseaseInfo.tumorCreateDoctorCode}"></ehr:user>" />
                            </c:if>
                            <c:if test="${ empty diseaseInfo.tumorCreateDoctorCode }">
                                <input type="text" readonly="readonly" name="tumorCreateDoctorName" value="${diseaseInfo.tumorCreateDoctorCode}" />
                            </c:if>
                        </td>
                    </tr>
                </table>
            </fieldset>
            </div>
        </div>
    </form>
</div>

<script type="text/javascript">

layui.use('laydate', function(){
    var laydate = layui.laydate;
    
    laydate.render({
      elem: '#tumorBirthdayId' 
   	   ,format: 'yyyy/MM/dd'
   	   ,max:0
    });
    
    laydate.render({
        elem: '#tumorCreateDateId' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click'
     		 ,done:function(value) {
  		        if(!$.isEmpty(value)){
  		            $("#tumorCreateDateId").removeClass("lose");
  		        }else{
  		            $("#tumorCreateDateId").addClass("lose");
  		        }
  		   }
      });
    
    laydate.render({
        elem: '#tumorDiagnosisDate' 
     	   ,format: 'yyyy/MM/dd'
     	   ,max:0
     	  , trigger: 'click' 
     		 , trigger: 'click'
         		 ,done:function(value) {
      		        if(!$.isEmpty(value)){
      		            $("#tumorDiagnosisDate").removeClass("lose");
      		        }else{
      		            $("#tumorDiagnosisDate").addClass("lose");
      		        }
      		   }
      });

  });
</script>