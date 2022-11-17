<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script src="${pageContext.request.contextPath}/js/util/jquery.jqprint-0.3.js" type="text/javascript"></script>
<%--<script src="${pageContext.request.contextPath}/js/views/ehr/person/addCover.js" type="text/javascript"></script>--%>
<%--<i class="pop_No">
		 <a class="bc" id="button_print">打印</a>
	</i>--%>
<div style="width:700px;" id="printDiv">
    <div style="height: 25px">
        <c:choose>
            <c:when test="${not empty personInfo.healthFileNo}">
                ${personInfo.healthFileNoHtml}
            </c:when>
            <c:otherwise>
                <s class="pop_No">
                    <span class="text" style="width: 80px;"><b>编号：111</b></span>
                    <span></span><span></span><span></span><span></span><span></span>
                    <span class="line">-</span>
                    <span></span><span></span><span></span>
                    <span class="line">-</span>
                    <span></span><span></span><span></span>
                    <span class="line">-</span>
                    <span></span><span></span><span></span><span></span>
                </s>
            </c:otherwise>
        </c:choose>
    </div>
    <div >
        <ul class="add_gr_text" style="width:100%;">
            <table border="0">
            <tr>
                <td>
                    <table border="0" style="margin:0px;width:600px;">
                        <tr>
                            <th width="100px">姓名：</th>
                            <td width="270px" class="b_line">&nbsp;
                                <c:choose>
                                    <c:when test="${not empty brwAnonymousSetStr}">
                                        <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                                            <c:out value="${fn:substring(personInfo.name, 0, 1)}" />
                                            <c:choose>
                                                <c:when test="${fn:length(personInfo.name) ==2}">${ANONYMOUS_X}</c:when>
                                                <c:when test="${fn:length(personInfo.name) ==3}">${ANONYMOUS_2X}</c:when>
                                                <c:otherwise>${ANONYMOUS_3X}</c:otherwise>
                                            </c:choose>
                                        </ehr:authorize>
                                        <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                                            ${personInfo.name}
                                        </ehr:authorize>
                                    </c:when>
                                    <c:otherwise>${personInfo.name}</c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                        <tr>
                            <th>证件类型：</th>
                            <td class="b_line"><ehr:dic dicmeta="PH00034" code="${not empty personInfo.idcard?'0':personInfo.otherIdcardType}"/></td>
                        </tr>
                        <tr>
                            <th>
                                证件号码：
                            </th>
                            <c:choose>
                                <c:when test="${not empty personInfo.idcard}">
                                    <td class="b_line">
                                        <c:if test="${not empty brwAnonymousSetStr}">
                                            <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                                                ${fn:replace(personInfo.idcard,fn:substring(personInfo.idcard,6,14), ANONYMOUS_XS)}
                                            </ehr:authorize>
                                            <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                                                ${personInfo.idcard}
                                            </ehr:authorize>
                                        </c:if>
                                        <c:if test="${empty brwAnonymousSetStr}">
                                            ${personInfo.idcard}
                                        </c:if>
                                    </td>
                                </c:when>
                                <c:when test="${not empty personInfo.otherIdcard}">
                                    <td class="b_line">&nbsp;
                                        <c:if test="${not empty brwAnonymousSetStr}">
                                            <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                                                ${fn:replace(personInfo.otherIdcard,fn:substring(fi.otherIdcard,2,5), ANONYMOUS_XS)}
                                            </ehr:authorize>
                                            <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                                                ${personInfo.otherIdcard}
                                            </ehr:authorize>
                                        </c:if>
                                        <c:if test="${empty brwAnonymousSetStr}">
                                            ${personInfo.otherIdcard}
                                        </c:if>
                                    </td>
                                </c:when>
                            </c:choose>
                        </tr>
                        <c:if test="${not empty personInfo.babyCardNo}">
                            <tr>
                                <th>保健编号：</th>
                                <td class="b_line">&nbsp;${personInfo.babyCardNo}</td>
                            </tr>
                        </c:if>
                        <tr>
                            <th>现住址：</th>
                            <td class="b_line">
                                <ehr:dic dicmeta="FS990001" code="${personInfo.patownShip}"></ehr:dic>
                                <ehr:dic dicmeta="FS990001" code="${personInfo.pastreet}"></ehr:dic>
                                <ehr:dic dicmeta="FS990001" code="${personInfo.paGroup}"></ehr:dic>
                                <c:out value="${personInfo.pahouseNumber}"></c:out>
                            </td>
                        </tr>
                        <%--<tr>--%>
                        <%--<th>常住类型：</th>--%>
                        <%--<td class="b_line">&nbsp;--%>
                        <%--<ehr:dic dicmeta="FS10005" code="${personInfo.livingType}"/>--%>
                        <%--</td>--%>
                        <%--</tr>--%>
                        <tr>
                            <th>常住类型：</th>
                            <td class="b_line">&nbsp;
                                <ehr:dic dicmeta="FS10005" code="${personInfo.householdType}"/>
                            </td>
                        </tr>
                        <tr>
                            <th>户籍地址：</th>
                            <td class="b_line">
                                <c:if test="${'1' eq personInfo.householdType }">
                                    <ehr:dic dicmeta="FS990001" code="${personInfo.hrtownShip}"></ehr:dic>
                                    <ehr:dic dicmeta="FS990001" code="${personInfo.hrstreet}"></ehr:dic>
                                    <ehr:dic dicmeta="FS990001" code="${personInfo.hrGroup}"></ehr:dic>
                                </c:if>
                                <c:out value="${personInfo.hrhouseNumber}"></c:out>
                            </td>
                        </tr>
                        <tr>
                            <th>人群分类：</th>
                            <td class="b_line">
                                <table>
                                    <tr>
                                        <td>贫困人口：

                                            <ehr:dic dicmeta="FS10281" code="${personInfo.poverty==null?'1':personInfo.poverty}"/>

                                            <c:if test="${personInfo.poverty=='2' }">
                                                贫困类型：<ehr:dic dicmeta="FS990024" code="${personInfo.povertyType}"/>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>残疾人口：
                                            <ehr:dic dicmeta="FS10281" code="${personInfo.disabled==null?'1':personInfo.disabled}"/>
                                            <c:if test="${personInfo.disabled=='2' }">
                                                残疾类型：<ehr:dic dicmeta="FS990025" code="${personInfo.veryPovertyType}"/>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>计生特困：
                                            <ehr:dic dicmeta="FS10281" code="${personInfo.veryPoverty==null?'1':personInfo.veryPoverty}"/>
                                    </tr>

                                </table>

                            </td>
                        </tr>
                        <tr>
                            <th>联系电话：</th>
                            <td class="b_line">
                                <c:if test="${not empty brwAnonymousSetStr}">
                                    <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                                        ${fn:substring(personInfo.phoneNumber,0,3)}${ANONYMOUS_XS}
                                    </ehr:authorize>
                                    <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                                        <c:out value="${personInfo.phoneNumber}"></c:out>
                                    </ehr:authorize>
                                </c:if>
                                <c:if test="${empty brwAnonymousSetStr}">
                                    <c:out value="${personInfo.phoneNumber}"></c:out>
                                </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>紧急联系人电话：</th>
                            <td class="b_line">
                                    <c:if test="${not empty brwAnonymousSetStr}">
                                        <ehr:authorize ifAnyGranted="${brwAnonymousSetStr}">
                                            ${fn:substring(personInfo.guardianPhoneOne,0,3)}${ANONYMOUS_XS}
                                        </ehr:authorize>
                                        <ehr:authorize ifNotGranted="${brwAnonymousSetStr}">
                                            <c:out value="${personInfo.guardianPhoneOne}"></c:out>
                                        </ehr:authorize>
                                    </c:if>
                                    <c:if test="${empty brwAnonymousSetStr}">
                                        <c:out value="${personInfo.guardianPhoneOne}"></c:out>
                                    </c:if>
                            </td>
                        </tr>
                        <tr>
                            <th>备注：</th>
                            <td class="b_line">&nbsp;<ehr:dic dicmeta="FS990026" code="${personInfo.remarks}"/></td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td>
                    <table border="0" style="margin-left:90px;width:500px;margin-top: 10px">
                        <tr>
                            <th width="100">管理单位：</th>
                            <td width="150" class="b_line">&nbsp;<ehr:org code="${personInfo.inputOrganCode}"></ehr:org></td>
                        </tr>
                        <tr>
                            <th>管理医生：</th>
                            <td class="b_line">&nbsp;${personInfo.inputName}</td>
                        </tr>
                        <tr>
                            <th>管理日期：</th>
                            <td class="b_line">&nbsp;<fmt:formatDate value='${personInfo.inputDate}' pattern='yyyy/MM/dd'/></td>
                        </tr>
                        <tr>
                            <th width="100">建档单位：</th>
                            <td width="150" class="b_line">
                                <ehr:org code="${personInfo.createOrganCode}"/>
                            </td>
                        </tr>
                        <tr>
                            <th class="b_line">建档医生：</th>
                            <td class="b_line">
                                <ehr:staff-name staffCode="${personInfo.createId}"/>
                            </td>
                        </tr>
                        <tr>
                            <th class="b_line">建档日期：</th>
                            <td class="b_line">
                                <fmt:formatDate value="${personInfo.createDate}" pattern="yyyy/MM/dd"/>
                            </td>
                    </table>
                </td>
            </tr>
        </table>
        </ul>
        <br style="clear: both" />
    </div>
</div>
