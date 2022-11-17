<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--<script src="${pageContext.request.contextPath}/js/jquery/jquery_fixedtablehead.js" type="text/javascript"></script>--%>
<script src="${pageContext.request.contextPath}/js/views/integration/medicalData.js" type="text/javascript"></script>

  <div class="searchbox">
    <form id="medical_data_from">
      <table id="medicalDataSearch" >
      	<colgroup>
  			<col style="width: 10%;"/>
			<col style="width: 20%;"/>
            <col style="width: 10%;"/>
			<col style="width: 20%;"/>
			<col style="width: 10%;"/>
			<col style="width: 20%;"/>
            <col style="width: 10%;"/>
      	</colgroup>
        <tbody>
          <tr>
            <td class="coltext">
              <label>医院名称</label>
            </td>
            <td>
                 <ehr:org-type-list id="organCode" type="hospital,centre" name="organCode"  width="200px;"/>
            </td>
            <td class="coltext">
              <label>项目类型</label>
            </td>
            <td class="colinput">
                 <ehr:dic-list type="true" name="projectNames" id="projectNames" dicmeta="JC00001" value="h01,h03,h04"
                 code="h01,h06,h02,h03,h04,h07,h08,h09,h10,h11,h12,h13,h14,h15" width="195px" />
            </td>
           <td class="coltext">
              <label>日期</label>
            </td>
            <td class="colinput">
                 <tag:dateInput name="medicalDataDate" id="medicalDataDate"  onlypast="true"/>
            </td>
             <td>
                 <input id="medical_data_search_btn" class="search_btn" type="button" value="查询"/>
             </td>
        </tbody>
      </table>
       <table>
       <tr>
           <td colspan="6" class="colbottom">
                 <span onclick="medicalData.toggle(this,'medicalDataSearch')" class="ico-bottom">&nbsp;</span>
           </td>
       </tr>
	</table>
    </form>
  </div>
  
  <div id="medical_data_content">
  </div>
