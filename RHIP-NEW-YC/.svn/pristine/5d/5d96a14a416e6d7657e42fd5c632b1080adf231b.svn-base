<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<fieldset>

    <legend>基本信息</legend>
    <input type="hidden" id="dis-person-id" name="personInfo.id" value="${personInfo.id}">
    <table class="posttable">
        <colgroup>
            <col style="width: 15%;min-width:100px;"/>
            <col style="width: 35%;min-width:200px;"/>
            <col style="width: 15%;min-width:100px;"/>
            <col style="width: 35%;min-width:200px;"/>
        </colgroup>
        <tr>
            <th><label class="required" for="idcard">身份证</label></th>
            <td>
                <c:if test="${empty personInfo.idcard}">
                <input type="text" id="idcard" name="personInfo.idcard" placeholder="输入身份证获取人员信息"
                       value="${personInfo.idcard}" reg='{"required":true,"idCard":true}'/>
                </c:if>
                <c:if test="${not empty personInfo.idcard}">
                <input type="text" id="idcard" readonly="readonly" name="personInfo.idcard" value="${personInfo.idcard}"
                       reg='{"idCard":true}'/>
                </c:if>
            <th><label class="required" class="required" for="name">姓名</label></th>
            <td><input type="text" id="name" name="personInfo.name" value="${personInfo.name}"
                       reg="{'required':true,'maxlength':16}"/></td>
        </tr>
        <tr>
            <th><label class="required" class="required" for="birthday">出生日期</label></th>
            <td><tag:dateInput name="personInfo.birthday" id="birthday" onlypast="true" reg="{'required':true}"
                               date="${personInfo.birthday}"/></td>
            <th><label class="required" class="required">性别</label></th>
            <td><ehr:dic-radio id="gender" dicmeta="GBT226112003" uninclude="0,9" name="personInfo.gender"
                               value="${personInfo.gender}" reg="{'required':true}"/></td>
        </tr>
        <tr>
            <th><label class="required" for="marriage">婚姻</label></th>
            <td><ehr:dic-list dicmeta="GBT226122003" id="marriage" width="180px;" name="personInfo.marriage"
                              value="${personInfo.marriage}" reg="{'required':true}"/></td>
            <th><label class="required" for="occupation">职业</label></th>
            <td><ehr:dic-list dicmeta="GBT6565" width="180px;"
                              code="CV020120201,CV020120202,CV020120203,CV020120204,CV020120205,CV020120206,CV020120207,CV020120224,CV020120209,CV020120210,CV020120211,CV020120212,CV020120213,CV020120214,CV020120215,CV020120216,CV020120217,CV020120299"
                              value="${personInfo.occupation}" id="occupation" name="personInfo.occupation"
                              reg="{'required':true}"/></td>
        </tr>
        <tr>
            <th><label class="required" for="nation">民族</label></th>
            <td><ehr:dic-list dicmeta="GBT3304" id="nation" width="180px;" name="personInfo.nation"
                              value="${personInfo.nation}" reg="{'required':true}"/></td>
            <th><label class="required" for="education">文化程度</label></th>
            <td><ehr:dic-list dicmeta="GBT46582006" code="IDM11,IDM12,IDM04,IDM13,IDM03,IDM02,IDM07,90" width="180px;"
                              value="${personInfo.education}" id="education" name="personInfo.education"
                              reg="{'required':true}"/></td>
        </tr>
        <tr>
            <th><label class="required" for="phoneNumber">电话</label></th>
            <td><input id="phoneNumber" type="text" name="personInfo.phoneNumber" value="${personInfo.phoneNumber}"
                       reg="{'required':true,'regex':'phone'}"/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th><label class="required">常住类型</label></th>
            <td><ehr:dic-radio reg="{'required':true}" dicmeta="FS10005" name="personInfo.householdType"
                               value='${ personInfo.householdType}'/></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <th><label class="required">现地址</label></th>
            <td colspan="3"><ehr:dic-town-village villageId="village_address" width="180px;" townId="town_address"
                                                  villageName="personInfo.pastreet"
                                                  townName="personInfo.patownShip" villageValue="${personInfo.pastreet}"
                                                  townValue="${personInfo.patownShip}" reg="{'required':true}"
                    />
                <br/><span id="text_pahouseNumber_prefix"><ehr:dic dicmeta="FS990001"
                                                                   code="${personInfo.patownShip}"></ehr:dic>
			<ehr:dic dicmeta="FS990001" code="${personInfo.pastreet}"></ehr:dic></span>
                <input style="width: 300px" type="text" id="text_pahouseNumber" reg='{"required":"true","maxlength":70}'
                       name="personInfo.pahouseNumber"
                       value="${personInfo.pahouseNumber}"
                        />(详细地址)
            </td>
        </tr>
        <tr>
            <th><label class="required">户籍地址</label></th>
            <td colspan="3">
                <div class="${'1' ne personInfo.householdType?'hide':'' }" id="hr-address-select"><ehr:dic-town-village
                        villageId="homeVillage_address" townId="homeTown_address" villageName="personInfo.hrstreet"
                        townName="personInfo.hrtownShip"
                        villageValue="${personInfo.hrstreet}" townValue="${personInfo.hrtownShip}" width="180px;"
                        reg="{'dependOn':'personInfo.householdType','dependValue':'1','required':true}"
                        /></div>
				<span id="text_hrhouseNumber_prefix"><ehr:dic dicmeta="FS990001"
                                                              code="${personInfo.hrtownShip}"></ehr:dic><ehr:dic
                        dicmeta="FS990001" code="${personInfo.hrstreet}"></ehr:dic></span> <input style="width: 300px"
                                                                                                  reg='{"required":"true","maxlength":70}'
                                                                                                  type="text"
                                                                                                  id="text_hrhouseNumber"
                                                                                                  name="personInfo.hrhouseNumber"
                                                                                                  reg="{'required':true}"
                                                                                                  value="${personInfo.hrhouseNumber}"
                    />(详细地址)
            </td>
        </tr>
        <tr>
            <th><label class="required" for="unitName">工作单位</label></th>
            <td><input type="text" id="unitName" name="personInfo.unitName" value="${personInfo.unitName}"
                       reg="{'required':true,'maxlength':46}"/></td>
            <th>建档单位</th>
            <td><input type="text" id="inputOrganName" readonly="readonly" name="personInfo.inputOrganName"
                       value="${personInfo.inputOrganName}"/>
                <input type="hidden" id="inputOrganCode" name="personInfo.inputOrganCode"
                       value="${personInfo.inputOrganCode}"/></td>
        </tr>
    </table>
</fieldset>