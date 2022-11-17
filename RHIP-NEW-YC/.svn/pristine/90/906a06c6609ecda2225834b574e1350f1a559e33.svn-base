<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>

<c:set var="JKJHB" value="<%=RoleType.JKJHB.getValue()%>"/>
<c:set var="YYJHB" value="<%=RoleType.YYJHB.getValue()%>"/>
<c:set var="DDCRBYY" value="<%=RoleType.DDCRBYY.getValue()%>"/>
<c:set var="ZXJHB" value="<%=RoleType.ZXJHB.getValue()%>"/>
<c:set var="ZJHB" value="<%=RoleType.ZJHB.getValue()%>"/>

<script src="${pageContext.request.contextPath}/js/views/idm/tb/ndyDrug.js" type="text/javascript"></script>
<div class="toolbar">
    <%-- <a href="javascript:void(0)" onclick="javascript:standardization.initNdyDrug('${singleId}','${patientName}','${logoff}')"><b class="fanhui">返回</b></a> --%>
    <a href="javascript:void(0)" onclick="javascript:standardization.ndyBack('${singleId}','${patientName}','${logoff}')"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
<%--    <c:if test="${logoff !=1 }">--%>
	    <%-- <a href="javascript:void(0)" onclick="javascript:drug.saveDrug(${singleId})"><b class="baocun">保存</b></a> --%>
	    <a href="javascript:void(0)" onclick="javascript:drug.saveDrug(${singleId})"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
	<%--</c:if>--%>
</div>
<div class="divFixed125" style="top: 200px">
    <form id="tbForm">
        <input type="hidden" name="id" value="${drugCard.id}"/>
        <input type="hidden" name="idmId" value="${singleId}"/>
        <div class="postcontent d">
            <i class="popno">服药卡</i>
            <div class="postdiv">
                <fieldset>
                    耐多药肺结核患者服药卡(
                    <%--<tag:dateInput name="createTime" id="searchDate" pattern="yyyy-MM" nullToToday="true" style="width:50px"/>--%>
                    <input type="text" class="layui-input x-admin-content-sm-date" name="createTime" id="searchDate" style="padding-left: 0px;width: 50px;" />
                    )   治疗月序(<input type="text" name="monthCount" value="${drugCard.monthCount}" maxlength="3" style="width:30px"/>)
                    <legend></legend>
                    <table class="posttable">
                        <colgroup>
                            <col style="width: 7%" />
                            <col style="width: 9%" />
                            <col style="width: 8%" />
                            <col style="width: 8%" />
                            <col style="width: 8%" />
                            <col style="width: 9%" />
                            <col style="width: 11%" />
                            <col style="width: 20%" />
                            <col style="width: 10%" />
                            <col style="width: 10%" />
                        </colgroup>
                        <tbody>
                        <tr>
                            <th><label class="required">姓名:</label></th>
                            <td><input type="text" id="name" name="name" value="${drugCard.name==null?patientName:drugCard.name}" reg='{"required":"true","maxlength":"100"}'></td>
                            <th>性别:</th>
                            <td>
                                <ehr:dic-radio name="sex" dicmeta="FS10006" value="${drugCard.sex}"/>
                            </td>
                            <th><label class="required">年龄:</label></th>
                            <td>
                                <input type="text" id="age" name="age" value="${drugCard.age}" reg='{"required":"true","maxlength":"3"}' style="width: 50%;">(周岁)
                            </td>
                            <th colspan="2"><label class="required">耐多药肺结核患者登记号:</label></th>
                            <td colspan="2">
                                <input type="text" id="registNo" name="registNo" value="${drugCard.registNo}" reg='{"required":"true","maxlength":"6","digits":"true"}' maxlength="6">
                            </td>
                        </tr>
                        <tr>
                            <th><label class="required">地址:</label></th>
                            <td colspan="5">
                                <%-- <ehr:dic-town-village villageId="pavillage_address" townId="patown_address"
                                                      villageName="streetCode" townName="juweihuiCode"
                                                      villageValue="${drugCard.streetCode}"
                                                      townValue="${drugCard.juweihuiCode}" width="130px;"
                                                      reg='{"required":"true"}'/> --%>
                                <ehr:dic-town-street-village villageId="pavillage_address" streetId="pastreet_address" callback="drug.displayPaAddress"
                                                             townId="patown_address" villageName="paGroup" streetName="pastreet"
                                                             townName="patownShip" villageValue="${drugCard.paGroup}" streetValue="${drugCard.pastreet}"
                                                             townValue="${drugCard.patownShip}" width="130px;" reg="{'required':true}"/>
                                <%-- <label id="tempPaValue">
                                        <ehr:dic code="${drugCard.patownShip}" dicmeta="FS990001"/>
                                        <ehr:dic code="${drugCard.pastreet}" dicmeta="FS990001"/>
                                        <ehr:dic code="${drugCard.paGroup}" dicmeta="FS990001"/>
                                </label> --%>
                                <input type="text" id="addressNo" name="addressNo" value="${drugCard.addressNo}"
                                       reg='{"required":"true","maxlength":"70"}' style="width: 80px;"/>
                                <span id="spanPaNumber">(门牌号)</span>
                            </td>
                            <th>是否DOT管理:</th>
                            <td><ehr:dic-list name="dotMgn" dicmeta="IDM00411" value="${drugCard.dotMgn}"/></td>
                        </tr>
                        <tr>
                            <th>督导机构:</th>
                            <td colspan="9">
                                <!--疾控结核，定点传染病-->
                                <ehr:authorize ifAnyGranted="${JKJHB}">
                                    <ehr:dic-town-centre-station townName="test" centreName="centerOrgCode1" centreValue="${currentLoginInfo.organization.organCode}" stationName="orgCode" stationId="orgCode"  style="width:130px;" isShowOneself="true"/>
                                </ehr:authorize>
                                <!--中心-->
                                <ehr:authorize ifAnyGranted="${ZXJHB},${YYJHB}">
                                    <ehr:org-type-list name="orgCode" id="orgCode" type="centre,hospital,station"  includeParent="true"  parentCode="${drugCard.orgCode==null?currentLoginInfo.organization.organCode:drugCard.orgCode}" value="${drugCard.orgCode==null?currentLoginInfo.organization.organCode:drugCard.orgCode}"/>
                                </ehr:authorize>
                                <ehr:authorize ifAnyGranted="${DDCRBYY}">
                                    <ehr:org-type-list name="orgCode" id="orgCode" type="hospital" defaultval="true" includeParent="true"  parentCode="${currentLoginInfo.organization.organCode}"  value="${drugCard.orgCode==null?currentLoginInfo.organization.organCode:drugCard.orgCode}"/>
                                </ehr:authorize>

                                <!--社区站-->
                                <ehr:authorize ifAnyGranted="${ZJHB}">
                                    <ehr:org-type-list name="orgCode" id="orgCode" defaultval="true" type="hospital,station" includeParent="true"  parentCode="${currentLoginInfo.organization.parentCode}" value="${currentLoginInfo.organization.organCode}"></ehr:org-type-list>
                                    <%--  <ehr:org-type-list name="orgCode" id="orgCode" defaultval="true" type="centre,hospital,station" includeParent="true"  parentCode="${currentLoginInfo.organization.organCode}" value="${currentLoginInfo.organization.organCode}"></ehr:org-type-list> --%>
                                </ehr:authorize>
                                <%--  <ehr:org-type-list name="orgCode" value="${drugCard.orgCode==null ? currentLoginInfo.organization.parentCode : drugCard.orgCode}" code="${currentLoginInfo.organization.parentCode}" />--%>
                            </td>
                        </tr>
                        <tr>
                            <th>治疗方案:</th>
                            <td colspan="7">
                                <input type="text" name="treatmentPlanA" value="${drugCard.treatmentPlanA}" maxlength="50" style="width: 100%;"/>
                            </td>
                            <th><label class="">开始时间:</label></th>
                            <td >
                                <%--<tag:dateInput name="treatmentDateA" id="searchDate" pattern="yyyy/MM/dd"  date="${drugCard.treatmentDateA}"/>--%>
                                <input type="text" class="layui-input x-admin-content-sm-date" name="treatmentDateA" id="treatmentDateA" value="<fmt:formatDate value='${drugCard.treatmentDateA}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
                            </td>
                        </tr>
                        <tr>
                            <th><label class="">剂量:</label></th>
                            <td colspan="9">
                                <ehr:dic-checkbox dicmeta="IDM00410" name="dosageA"  value="${drugCard.dosageA}"

                                                  reg='' onchange="drug.toggleDosage('dosageA')"/>
                                <br/>
                                <span  id="dosageA01" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Z<input type="text" name="z1" value="${drugCard.z1}"
                                         reg='{"maxlength":"30"}' placeholder="请输入Z剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageA02" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Cm<input type="text" name="cm1" value="${drugCard.cm1}"
                                          reg='{"maxlength":"30"}' placeholder="请输入Cm剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageA03" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Am<input type="text" name="am1" value="${drugCard.am1}"
                                          reg='{"maxlength":"30"}' placeholder="请输入Am剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageA04" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Km<input type="text" name="km1" value="${drugCard.km1}"
                                          reg='{"maxlength":"30"}' placeholder="请输入Km剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageA05" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Lfx<input type="text" name="lfx1" value="${drugCard.lfx1}"
                                           reg='{"maxlength":"30"}' placeholder="请输入Lfx剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageA06" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Pto<input type="text" name="pto1" value="${drugCard.pto1}"
                                           reg='{"maxlength":"30"}' placeholder="请输入Pto剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageA07" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Cs<input type="text" name="cs1" value="${drugCard.cs1}"
                                          reg='{"maxlength":"30"}' placeholder="请输入Cs剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageA08" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Pas<input type="text" name="pas1" value="${drugCard.pas1}"
                                           reg='{"maxlength":"30"}' placeholder="请输入PAS剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageA09" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         E<input type="text" name="e1" value="${drugCard.e1}"
                                         reg='{"maxlength":"30"}' placeholder="请输入E剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageA10" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Mfx<input type="text" name="mfx1" value="${drugCard.mfx1}"
                                           reg='{"maxlength":"30"}' placeholder="请输入Mfx剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageA11" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Amx/Clv<input type="text" name="amxclv1" value="${drugCard.amxclv1}"
                                               reg='{"maxlength":"30"}' placeholder="请输入Amx/Clv剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageA12" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         其他<input type="text" name="other1" value="${drugCard.other1}"
                                          reg='{"maxlength":"30"}' placeholder="请输入其他剂量" style="width: 50px;"/>
		                     </span>
                            </td>

                        </tr>
                        <tr>
                            <th>更改方案:</th>
                            <td colspan="7">
                                <input type="text" name="treatmentPlanB" value="${drugCard.treatmentPlanB}" maxlength="50" style="width: 100%;"/>
                            </td>
                            <th><label class="">开始时间:</label></th>
                            <td >
                                <%--<tag:dateInput name="treatmentDateB" id="searchDate" pattern="yyyy/MM/dd" date="${drugCard.treatmentDateB}"  />--%>
                                <input type="text" class="layui-input x-admin-content-sm-date" name="treatmentDateB" id="treatmentDateB" value="<fmt:formatDate value='${drugCard.treatmentDateB}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 90px;" />
                            </td>
                        </tr>
                        <tr>
                            <th><label class="">剂量:</label></th>
                            <td colspan="9">
                                <ehr:dic-checkbox dicmeta="IDM00410" name="dosageB"  value="${drugCard.dosageB}"
                                                  reg='' onchange="drug.toggleDosage('dosageB')"/>
                                <br/>
                                <span  id="dosageB01" style="display: none">
		                         <%--<label class="required"></label>--%>
		                        Z<input type="text" name="z2" value="${drugCard.z2}"
                                        reg='{"maxlength":"30"}' placeholder="请输入Z剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageB02" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Cm<input type="text" name="cm2" value="${drugCard.cm2}"
                                          reg='{"maxlength":"30"}' placeholder="请输入Cm剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageB03" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Am<input type="text" name="am2" value="${drugCard.am2}"
                                          reg='{"maxlength":"30"}' placeholder="请输入Am剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageB04" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Km<input type="text" name="km2" value="${drugCard.km2}"
                                          reg='{"maxlength":"30"}' placeholder="请输入Km剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageB05" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Lfx<input type="text" name="lfx2" value="${drugCard.lfx2}"
                                           reg='{"maxlength":"30"}' placeholder="请输入Lfx剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageB06" style="display: none">
		                         <%--<label class="required"></label>--%>
		                        Pto <input type="text" name="pto2" value="${drugCard.pto2}"
                                           reg='{"maxlength":"30"}' placeholder="请输入Pto剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageB07" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Cs<input type="text" name="cs2" value="${drugCard.cs2}"
                                          reg='{"maxlength":"30"}' placeholder="请输入Cs剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageB08" style="display: none">
		                         <%--<label class="required"></label>--%>
		                        Pas<input type="text" name="pas2" value="${drugCard.pas2}"
                                          reg='{"maxlength":"30"}' placeholder="请输入PAS剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageB09" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         E<input type="text" name="e2" value="${drugCard.e2}"
                                         reg='{"maxlength":"30"}' placeholder="请输入E剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageB10" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Mfx<input type="text" name="mfx2" value="${drugCard.mfx2}"
                                           reg='{"maxlength":"30"}' placeholder="请输入Mfx剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageB11" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         Amx/Clv<input type="text" name="amxclv2" value="${drugCard.amxclv2}"
                                               reg='{"maxlength":"30"}' placeholder="请输入Amx/Clv剂量" style="width: 50px;"/>
		                     </span>
                                <span  id="dosageB12" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         其他<input type="text" name="other2" value="${drugCard.other2}"
                                          reg='{"maxlength":"30"}' placeholder="请输入其他剂量" style="width: 50px;"/>
		                     </span>

                            </td>

                        </tr>

                        </tbody>
                    </table>
                </fieldset>
            </div>
        </div>
        <input type="hidden" id="initJson" value="${initJson}">
        <div  style="margin: 10px;">
            <table>
                <tr>
                    <td>
                        <font color="green">O</font>=直接观察服药
                        <font color="red">N</font>=没有监督服药
                        <font color="red">X</font>=没有服药
                        <%-- 已领药：<img src="${pageContext.request.contextPath}/images/lingyao.gif">
                         已服药：<img src="${pageContext.request.contextPath}/images/fuyao.png">--%>
                    </td>
                    <td>
                        病人：${patientName}
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        督导医生：<ehr:user userCode="${drugDoctor}"/>
                    </td>
                </tr>
            </table>
        </div>
        <div class="repeattable">
            <table id="drugTable" class="layui-table x-admin-sm-table-list-middle">
                <thead>
                <tr>
                    <th class="centerth" style="width: 55px;" rowspan="2">服药日期</th>
                    <th class="centerth" colspan="17">服用药物</th>
                    <th class="centerth" style="width: 200px;" rowspan="2">简要病程</th>

                    <%--<c:forEach var="h" begin="1" end="31" step="1">
                        <th>${h}</th>
                    </c:forEach>--%>
                </tr>
                <tr>
                    <th class="centerth" style="width: 10px;" colspan="3">Z</th>
                    <th class="centerth" style="width: 10px;">Cm</th>
                    <th class="centerth" style="width: 10px;">Am</th>
                    <th class="centerth" style="width: 10px;">Km</th>
                    <th class="centerth" style="width: 10px;">Lfx</th>
                    <th class="centerth" style="width: 10px;">E</th>
                    <th class="centerth" style="width: 10px;" colspan="3">Pto</th>
                    <th class="centerth" style="width: 10px;" colspan="2">PAS</th>
                    <th class="centerth" style="width: 10px;" colspan="2">Cs</th>
                    <th class="centerth" style="width: 40px;">Amx/Clv</th>
                    <th class="centerth" style="width: 10px;" >Mfx</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" begin="1" end="31" step="1">
                    <tr>
                        <td>${i}</td>
                        <c:forEach var="j" begin="1" end="17" step="1">
                            <td id="${i}-${j}" onclick="drug.changePic(this)" flag="" ></td>

                        </c:forEach>
                        <td id="${i}-18" flag=""><input type="text" id="${i}-18-txt" name="jybc" maxlength="30" onchange="drug.changeJYBC('${i}-18',this.value);" value="" /></td>

                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="repeattable">
            <fieldset>
                <legend>预约复查时间及项目</legend>
                <table class="layui-table x-admin-sm-table-list-middle">
                    <colgroup>
                        <col style="width: 10%" />
                        <col style="width: 40%" />
                        <col style="width: 10%" />
                        <col style="width: 40%" />
                    </colgroup>
                    <thead>
                    <tr>
                        <th>复查时间</th>
                        <th>复查项目</th>
                        <th>复查时间</th>
                        <th>复查项目</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <%--<tag:dateInput name="reexamineDateA" pattern="yyyy/MM/dd" date="${drugCard.reexamineDateA}" style="width:80px"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="reexamineDateA" id="reexamineDateA" value="<fmt:formatDate value='${drugCard.reexamineDateA}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td >
                            <ehr:dic-checkbox dicmeta="IDM00412" name="reexamineItemsA"  value="${drugCard.reexamineItemsA}"
                                              reg='{}' onchange="drug.toggleOther('reexamineItemsA')"/>
                            <span  id="reexamineItemsA" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         <input type="text" name="reexamineOtheritemsA" value="${drugCard.reexamineOtheritemsA}"
                                        reg='{"maxlength":"30"}' placeholder="若选择其他，请描述" style="width: 130px;"/>
		                     </span>
                        </td>
                        <td>
                            <%--<tag:dateInput name="reexamineDateB" pattern="yyyy/MM/dd" date="${drugCard.reexamineDateB}" style="width:80px"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="reexamineDateB" id="reexamineDateB" value="<fmt:formatDate value='${drugCard.reexamineDateB}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td >
                            <ehr:dic-checkbox dicmeta="IDM00412" name="reexamineItemsB"  value="${drugCard.reexamineItemsB}"
                                              reg='{}' onchange="drug.toggleOther('reexamineItemsB')"/>
                            <span  id="reexamineItemsB" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         <input type="text" name="reexamineOtheritemsB" value="${drugCard.reexamineOtheritemsB}"
                                        reg='{"maxlength":"30"}' placeholder="若选择其他，请描述" style="width: 130px;"/>
		                     </span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <%--<tag:dateInput name="reexamineDateC" id="searchDate" pattern="yyyy/MM/dd" date="${drugCard.reexamineDateC}" style="width:80px"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="reexamineDateC" id="reexamineDateC" value="<fmt:formatDate value='${drugCard.reexamineDateC}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td >
                            <ehr:dic-checkbox id="occupation" dicmeta="IDM00412" name="reexamineItemsC"  value="${drugCard.reexamineItemsC}"
                                              reg='{}' onchange="drug.toggleOther('reexamineItemsC')"/>
                            <span  id="reexamineItemsC" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         <input type="text" name="reexamineOtheritemsC" value="${drugCard.reexamineOtheritemsC}"
                                        reg='{"maxlength":"30"}' placeholder="若选择其他，请描述" style="width: 130px;"/>
		                     </span>
                        </td>
                        <td>
                            <%--<tag:dateInput name="reexamineDateD" id="searchDate" pattern="yyyy/MM/dd" date="${drugCard.reexamineDateD}" style="width:80px"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="reexamineDateD" id="reexamineDateD" value="<fmt:formatDate value='${drugCard.reexamineDateD}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td >
                            <ehr:dic-checkbox dicmeta="IDM00412" name="reexamineItemsD"  value="${drugCard.reexamineItemsD}"
                                              reg='{}' onchange="drug.toggleOther('reexamineItemsD')"/>
                            <span  id="reexamineItemsD" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         <input type="text" name="reexamineOtheritemsD" value="${drugCard.reexamineOtheritemsD}"
                                        reg='{"maxlength":"30"}' placeholder="若选择其他，请描述" style="width: 130px;"/>
		                     </span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <%--<tag:dateInput name="reexamineDateE" id="searchDate" pattern="yyyy/MM/dd" date="${drugCard.reexamineDateE}" style="width:80px"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="reexamineDateE" id="reexamineDateE" value="<fmt:formatDate value='${drugCard.reexamineDateE}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td >
                            <ehr:dic-checkbox id="occupation" dicmeta="IDM00412" name="reexamineItemsE"  value="${drugCard.reexamineItemsE}"
                                              reg='{}' onchange="drug.toggleOther('reexamineItemsE')"/>
                            <span  id="reexamineItemsE" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         <input type="text" name="reexamineOtheritemsE" value="${drugCard.reexamineOtheritemsE}"
                                        reg='{"maxlength":"30"}' placeholder="若选择其他，请描述" style="width: 130px;"/>
		                     </span>
                        </td>
                        <td>
                            <%--<tag:dateInput name="reexamineDateF" id="searchDate" pattern="yyyy/MM/dd" date="${drugCard.reexamineDateF}" style="width:80px"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="reexamineDateF" id="reexamineDateF" value="<fmt:formatDate value='${drugCard.reexamineDateF}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td >
                            <ehr:dic-checkbox dicmeta="IDM00412" name="reexamineItemsF"  value="${drugCard.reexamineItemsF}"
                                              reg='{}' onchange="drug.toggleOther('reexamineItemsF')"/>
                            <span  id="reexamineItemsF" style="display: none">
		                         <%--<label class="required"></label>--%>
		                         <input type="text" name="reexamineOtheritemsF" value="${drugCard.reexamineOtheritemsF}"
                                        reg='{"maxlength":"30"}' placeholder="若选择其他，请描述" style="width: 130px;"/>
		                     </span>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
        <div class="repeattable">
            <fieldset>
                <legend>本月痰检回报结果</legend>
                <table class="layui-table x-admin-sm-table-list-middle">
                    <colgroup>
                        <col style="width: 16%" />
                        <col style="width: 15%" />
                        <col style="width: 15%" />
                        <col style="width: 27%" />
                        <col style="width: 27%" />
                    </colgroup>
                    <thead>
                    <tr>
                        <th></th>
                        <th>送检日期</th>
                        <th>报告日期</th>
                        <th colspan="2">结果</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>痰涂片</td>
                        <td>
                            <%--<tag:dateInput name="sputumCheckDate" pattern="yyyy/MM/dd" date="${drugCard.sputumCheckDate}"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="sputumCheckDate" id="sputumCheckDate" value="<fmt:formatDate value='${drugCard.sputumCheckDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td>
                            <%--<tag:dateInput name="sputumReportDate" pattern="yyyy/MM/dd" date="${drugCard.sputumReportDate}"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="sputumReportDate" id="sputumReportDate" value="<fmt:formatDate value='${drugCard.sputumReportDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td >
                            <input type="text" name="sputumResult1" value="${drugCard.sputumResult1}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="sputumResult2" value="${drugCard.sputumResult2}" maxlength="30"/>
                        </td>
                    </tr>
                    <tr>
                        <td>痰培养</td>
                        <td>
                            <%--<tag:dateInput name="cultCheckDate" pattern="yyyy/MM/dd" date="${drugCard.cultCheckDate}"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="cultCheckDate" id="cultCheckDate" value="<fmt:formatDate value='${drugCard.cultCheckDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td>
                            <%--<tag:dateInput name="cultReportDate" pattern="yyyy/MM/dd" date="${drugCard.cultReportDate}"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="cultReportDate" id="cultReportDate" value="<fmt:formatDate value='${drugCard.cultReportDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td >
                            <input type="text" name="cultResult1" value="${drugCard.cultResult1}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="cultResult2" value="${drugCard.cultResult2}" maxlength="30"/>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
        <div class="repeattable">
            <fieldset>
                <legend>取药记录</legend>
                <table class="layui-table x-admin-sm-table-list-middle" border="1">
                    <colgroup>
                        <col style="width: 10%" />
                        <col style="width: 10%" />
                        <col style="width: 10%" />
                        <col style="width: 10%" />
                        <col style="width: 10%" />
                        <col style="width: 10%" />
                        <col style="width: 10%" />
                        <col style="width: 10%" />
                        <col style="width: 10%" />
                        <col style="width: 10%" />
                    </colgroup>
                    <thead>
                    <tr>
                        <th rowspan="2" style="vertical-align: middle">取药时间</th>
                        <th colspan="9">药物种类及数量(片/包/支)</th>
                    </tr>

                    <tr>
                        <th ><input type="text" name="drugType1" reg='{"maxlength":"30"}' maxlength="30" value="${drugCard.drugType1}" style="width: 100px"/></th>
                        <th><input type="text" name="drugType2" reg='{"maxlength":"30"}' maxlength="30" value="${drugCard.drugType2}" style="width: 100px"/></th>
                        <th><input type="text" name="drugType3" reg='{"maxlength":"30"}' maxlength="30" value="${drugCard.drugType3}" style="width: 100px"/></th>
                        <th><input type="text" name="drugType4" reg='{"maxlength":"30"}' maxlength="30" value="${drugCard.drugType4}" style="width: 100px"/></th>
                        <th><input type="text" name="drugType5" reg='{"maxlength":"30"}' maxlength="30" value="${drugCard.drugType5}" style="width: 100px"/></th>
                        <th><input type="text" name="drugType6" reg='{"maxlength":"30"}' maxlength="30" value="${drugCard.drugType6}" style="width: 100px"/></th>
                        <th><input type="text" name="drugType7" reg='{"maxlength":"30"}' maxlength="30" value="${drugCard.drugType7}" style="width: 100px"/></th>
                        <th><input type="text" name="drugType8" reg='{"maxlength":"30"}' maxlength="30" value="${drugCard.drugType8}" style="width: 100px"/></th>
                        <th><input type="text" name="drugType9" reg='{"maxlength":"30"}' maxlength="30" value="${drugCard.drugType9}" style="width: 100px"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <%--<tag:dateInput name="catchDate" pattern="yyyy/MM/dd" date="${drugCard.catchDate}"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="catchDate" id="catchDate" value="<fmt:formatDate value='${drugCard.catchDate}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td >
                            <input type="text" name="count1" value="${drugCard.count1}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count2" value="${drugCard.count2}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count3" value="${drugCard.count3}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count4" value="${drugCard.count4}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count5" value="${drugCard.count5}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count6" value="${drugCard.count6}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count7" value="${drugCard.count7}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count8" value="${drugCard.count8}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count9" value="${drugCard.count9}" maxlength="30"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <%--<tag:dateInput name="catchDate1" pattern="yyyy/MM/dd" date="${drugCard.catchDate1}"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="catchDate1" id="catchDate1" value="<fmt:formatDate value='${drugCard.catchDate1}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td >
                            <input type="text" name="count11" value="${drugCard.count11}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count12" value="${drugCard.count12}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count13" value="${drugCard.count13}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count14" value="${drugCard.count14}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count15" value="${drugCard.count15}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count16" value="${drugCard.count16}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count17" value="${drugCard.count17}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count18" value="${drugCard.count18}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count19" value="${drugCard.count19}" maxlength="30"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <%--<tag:dateInput name="catchDate2" pattern="yyyy/MM/dd" date="${drugCard.catchDate2}"/>--%>
                            <input type="text" class="layui-input x-admin-content-sm-date" name="catchDate2" id="catchDate2" value="<fmt:formatDate value='${drugCard.catchDate2}' pattern='yyyy/MM/dd'/>" style="padding-left: 0px;width: 80px;" />
                        </td>
                        <td >
                            <input type="text" name="count21" value="${drugCard.count21}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count22" value="${drugCard.count22}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count23" value="${drugCard.count23}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count24" value="${drugCard.count24}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count25" value="${drugCard.count25}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count26" value="${drugCard.count26}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count27" value="${drugCard.count27}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count28" value="${drugCard.count28}" maxlength="30"/>
                        </td>
                        <td >
                            <input type="text" name="count29" value="${drugCard.count29}" maxlength="30"/>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
    </form>
</div>


<script type="text/javascript">
    layui.use('laydate', function(){
        var laydate = layui.laydate;

        laydate.render({
            elem: '#searchDate'
            ,format: 'yyyy-MM'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#treatmentDateA'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#treatmentDateB'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#reexamineDateA'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#reexamineDateB'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#reexamineDateC'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#reexamineDateD'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#reexamineDateE'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#reexamineDateF'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#sputumCheckDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#sputumReportDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#cultCheckDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#cultReportDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#catchDate'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#catchDate1'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
        laydate.render({
            elem: '#catchDate2'
            ,format: 'yyyy/MM/dd'
            ,max:0
            , trigger: 'click'
        });
    });
</script>