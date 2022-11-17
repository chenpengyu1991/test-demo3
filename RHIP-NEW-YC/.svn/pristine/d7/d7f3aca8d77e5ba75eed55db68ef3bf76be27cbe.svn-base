<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>

<script type="text/javascript">
	 require(['views/portal/organizationLink/search'],function(linkSearch){
		 linkSearch.load();
	 });
</script>
<input name="id" type="hidden" value="${organizationlink.id} " />
<div>
	<div id="top_allLink">
		<div class="toolbar">
		    <a id="LinkAddButId"><b class="xinz">新增</b></a>
		</div>
		 <div class="searchbox">
			<form id="linkFormId" name="linkForm" onsubmit="return false;">
				<table id="linkSearchTableId">
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
							<td class="coltext">机构名称</td>
							<td class="colinput">
		                         <input type="text" id="orgName" name="orgName" />
		                    </td> 
							<td class="coltext">审核状态</td>
							<td>
								<ehr:dic-list id="status" dicmeta="LH00008" name="status" code="0,1"/>
							</td>
							<td></td>
							<td class="colinput">
								<input type="button" id="linkSearchBut" value="查 询" class="search_btn" />
							</td>
						</tr>
					</tbody>
				</table>
		         <table>
		              <tr>
		                 <td colspan="6" class="colbottom">
					    <span id="organizationLinkSearchSpanId" class="ico-bottom">&nbsp;</span>
					</td>
		              </tr>
		         </table>
			</form>
		</div>
		<div id="listDivLink"></div>
	</div>
	<div id="infoDivLink"></div>
</div>
