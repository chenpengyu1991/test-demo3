<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>

<script type="text/javascript">
	 require(['views/portal/fileManage/search'],function(fileSearch){
		 fileSearch.load();
	 });
</script>

<div>
	<div id="top_allFile">
		<div class="toolbar">
		    <a id="fileAddButId"><b class="xinz">新增</b></a>
		</div>
		 <div class="searchbox">
			<form id="fileFormId" name="fileForm" action="" method="post">
				<table id="fileSearchTableId">
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
							<td class="coltext">标题</td>
							<td class="colinput">
		                         <input type="text" id="title" name="title" />
		                    </td>
		                    <td class="coltext">文档类型</td>
		                    <td class="colinput">
		                       <ehr:dic-list name="fileType" dicmeta="LH00001"/>
		                    </td>
		                    <td class="coltext">更新日期</td>
		                     <td class="colinput">
		                         <tag:dateInput id="dateFromId" name="dateFrom" pattern="yyyy/MM/dd"  onlypast="true" style="width:38%;"/>
		                         ~<tag:dateInput id="dateToId" name="dateTo" pattern="yyyy/MM/dd"  onlypast="true"  style="width:38%;"/>
		                     </td>
							<td class="colinput"/>
							<td class="colinput">
								<input type="button" id="fileSearchBut" value="查 询" class="search_btn" />
							</td>
						</tr>
					</tbody>
				</table>
		         <table>
		              <tr>
		                  <td colspan="4" class="colbottom">
		                         <span id="fileSearchSpanId" class="ico-bottom">&nbsp;</span>
		                  </td>
		              </tr>
		         </table>
			</form>
		</div>
		<div id="listDivFile"></div>
	</div>
 	<div id="detailDivFile"></div>
</div>
