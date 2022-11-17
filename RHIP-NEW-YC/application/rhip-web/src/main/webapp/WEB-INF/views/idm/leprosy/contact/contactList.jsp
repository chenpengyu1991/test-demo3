<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table id="ccList">
     <colgroup>
         <col style="width:20px"/>
         <col style="width:50px"/>
         <col style="width:50px"/>
         <col style="width:50px"/>
     </colgroup>
     <thead>
     <tr>
         <th class="centerth">序号</th>
      <th class="centerth" style="width: 10%">接触者姓名</th>
      <th class="centerth" style="width: 35%">与接触者关系</th>
      <th class="centerth" style="width: 35%">阳性体征</th>
     </tr>
     </thead>
     <tbody>
      <c:forEach var="listCc" items="${listCcs}" varStatus="status">
          <tr onclick="contact.clickRow(this)" id="${listCc.id}">
              <td>${status.index + 1}</</td>
              <td><ehr:tip>${listCc.closeName}</ehr:tip></td>
              <td><ehr:tip><ehr:dic code="${listCc.closeType}" dicmeta="IDM00249"/></ehr:tip></td>
              <td><ehr:tip><ehr:dic code="${listCc.positiveSigns}" dicmeta="PH00002"/></ehr:tip></td>
           </tr>
         </c:forEach>
     </tbody>
 </table>
 <table class="mini">
     <tr>
         <ehr:pagination-mini action="contact.searchContactList" colspan="4" />
     </tr>
 </table>