<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld" %>
<input id="frequent" name="frequent" value="${frequent.id}" type="hidden"/>
<div class="select-detail mains-doctor">
<label>常用联系人:</label>
<ul id="depart-level1-ul" class="drop-menus">
    <li style="text-align:left;">
       <c:choose>
         <c:when test="${accountInfo.reserveStatus eq '0'}">
         <span title="该用户已被禁止预约">
         	<input type="radio" name="frequentContacts" id="accountInfo"
               value="1" disabled="disabled"
               onchange="hotExpertSearch.selectFrequentOption(this,'')">
            ${accountInfo.realName}
         </span>
         </c:when>
         <c:otherwise>
         	 <input type="radio" name="frequentContacts" id="accountInfo"
               value="1" checked="checked"
               onchange="hotExpertSearch.selectFrequentOption(this,'')">
         ${accountInfo.realName}
         </c:otherwise>
       </c:choose>
       <c:forEach var="frequentContacts" items="${frequentContactsList}">
          <c:choose>   
         <c:when test="${frequentContacts.reserveStatus eq '0' }"> 
         	 <span title="该用户已被禁止预约"> 
             	<input type="radio" name="frequentContacts"
                        value="${frequentContacts.id}" disabled="disabled"
                        onchange="hotExpertSearch.selectFrequentOption(this,'${frequentContacts.id}')">
                 ${frequentContacts.frequentName}
             </span>
         </c:when>
         <c:when test="${frequentContacts.reserveStatus eq '1' && frequentContacts.frequentName eq thisFrequentName}">
            	<input type="radio" name="frequentContacts"
                       value="${frequentContacts.id}" checked="checked"
                       onchange="hotExpertSearch.selectFrequentOption(this,'${frequentContacts.id}')">
                ${frequentContacts.frequentName}
         </c:when>
         <c:otherwise>
             <input type="radio" name="frequentContacts"
                    value="${frequentContacts.id}"
                    onchange="hotExpertSearch.selectFrequentOption(this,'${frequentContacts.id}')">
             ${frequentContacts.frequentName}
         </c:otherwise>
     </c:choose>
        </c:forEach>                           
        </li>
    </ul>
</div>
