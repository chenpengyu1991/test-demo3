<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	 require(['views/uthealth/electrocardio/search'],function(electrocardio){
         electrocardio.load();
	 });
</script>

<div class="section">
 <div class="searchbox">
	<form id="electrocarFormId" name="waterOilForm" action="" method="post">
		<table id="useSearchTableId">
               <colgroup>
                    <col style="width: 10%"/>
                    <col style="width: 23%"/>
                    <col style="width: 10%"/>
                    <col style="width: 23%"/>
                    <col style="width: 10%"/>
                    <col style="width: 23%"/>
                </colgroup>
     			<tbody>
				<tr>
                    <td class="coltext">关键字</td>
                    <td class="colinput">
                        <input type="text" id="keyword" name="keyword" placeholder="用户编码/用户名"/>
                    </td>
					<td class="coltext">时间</td>
					<td class="colinput">
						<tag:dateInput name="startTime" pattern="MM-dd-yyyy" id="startTime" maxId="startTime" onlypast="true" style="width: 80px;"/>~<tag:dateInput name="endTime" pattern="MM-dd-yyyy" id="endTime" minId="endTime" onlypast="true"  style="width: 80px;"/>
					</td>
					<td class="colinput">
						<input type="button" id="SearchBt" value="查 询" class="search_btn" />
					</td>
				</tr>
			</tbody>
		</table>
         <table>
              <tr>
                  <td colspan="4" class="colbottom">
                         <span id="bloodPressureSearchSpanId" class="ico-bottom">&nbsp;</span>
                  </td>
              </tr>
         </table>
	</form>
 </div>
<div id="listDiv"></div>
