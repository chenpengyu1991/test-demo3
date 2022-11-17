<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script src="${pageContext.request.contextPath}/js/views/idm/leprosy/not_report_suspected.js" type="text/javascript"></script>

<div>
	<div id="top_allNot">
	<div class="searchbox">
		<form id="suspectedSearchNotForm">
          <table id="suspectedSearchNot" >
				<colgroup>
                    <col style="min-width:70px; width: 25%;"/>
                    <col style="min-width:100px; width: 35%;"/>
                    <col style="min-width:70px; width: 40%;"/>
				</colgroup>	
				<tbody>
					<tr>
						<td class="coltext">患者姓名</td>
                        <td class="colinput"><input type="text" name="name" /></td>
                        <td>
                            <input type="button" value="查询" id="reportBtnSearch" class="search_btn"/>
                            <input type="text"  style="display: none;">
                        </td>
					</tr>
				</tbody>
			</table>
               <table>
                <tr>
                    <td colspan="3" class="colbottom">
                          <span onclick="leprosyIndex.toggle(this,'suspectedSearchNot')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
			</table>
		 </form>
	</div>
	<div id="listDivNot"></div>
	</div>
</div>

