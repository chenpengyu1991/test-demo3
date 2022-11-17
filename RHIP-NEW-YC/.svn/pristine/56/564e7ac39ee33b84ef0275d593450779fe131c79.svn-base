<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<script src="${pageContext.request.contextPath}/js/views/reserve/frequent/list.js" type="text/javascript"></script>

<c:if test="${not empty frequentContactsList}">
    <div class="contact-info-box">
        <div class="contact-title">
            <div class="contact-title-item" style="width: 20%">
                <span>姓名</span>
            </div>
            <div class="contact-title-item" style="width: 5%">
                <span>性别</span>
            </div>
            <div class="contact-title-item" style="width: 20%">
                <span>手机号码</span>
            </div>
            <div class="contact-title-item" style="width: 20%">
                <span>身份证号码</span>
            </div>
            <div class="contact-title-item" style="width: 15%">
                <span>出生日期</span>
            </div>
            <div class="contact-title-item" style="width: 20%">
                <span>操作</span>
            </div>
        </div>
        <ul>
            <c:forEach items="${frequentContactsList}" var="frequentContacts">
                <li>
                    <div class="contact-content">
                        <div class="contact-item-info" style="width: 20%; ">
                                ${frequentContacts.frequentName}
                        </div>
                        <div class="contact-item-info" style="width: 5%; ">
                            <ehr:dic code="${frequentContacts.gender }" dicmeta="FS10006"/>
                        </div>
                        <div class="contact-item-info" style="width: 20%; ">
                                ${frequentContacts.telephone}
                        </div>
                        <div class="contact-item-info" style="width: 20%; ">
                                ${frequentContacts.cardNo}
                        </div>
                        <div class="contact-item-info" style="width: 15%; ">
                            <fmt:formatDate value='${frequentContacts.birthday}' pattern='yyyy/MM/dd'/>
                        </div>
                        <div class="contact-item-info" style="width: 20%; ">
                            <ul>
                                <li>
                                     <span data-id="${frequentContacts.id}"
                                           data-frequent-name="${frequentContacts.frequentName}"
                                           data-telephone="${frequentContacts.telephone}"
                                           data-gender="${frequentContacts.gender}"
                                           data-card-no="${frequentContacts.cardNo}"
                                           data-birthday="${frequentContacts.birthday}">
                                         <input class="list-edit-btn" type="button" value="修改"
                                                onclick="frequentList.modifyFrequent(this)"/>
                                    </span>
                                    <input class="list-delete-btn" type="button" value="删除"
                                           onclick="frequentList.deleteFrequent('${frequentContacts.id}')"/>
                                </li>
                            </ul>
                        </div>
                    </div>
                </li>
            </c:forEach>
        </ul>
        <ehr:pagination action="frequentSearch.search"/>
    </div>
</c:if>
