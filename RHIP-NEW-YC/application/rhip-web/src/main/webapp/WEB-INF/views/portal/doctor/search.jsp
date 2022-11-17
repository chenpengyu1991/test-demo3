<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag"%>

<script type="text/javascript">
	 require(['views/portal/doctor/search'],function(doctorSearch){
		 doctorSearch.load();
	 });
</script>

<div>
	<div id="top_allDoctor">
		<div class="toolbar">
		    <a id="doctorAddButId"><b class="xinz">新增</b></a>
		</div>
		 <div class="searchbox">
			<form id="doctorFormId" name="doctorForm" action="" method="post">
				<table id="doctorSearchTableId">
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
							<td class="coltext">医生姓名</td>
							<td class="colinput">
		                         <input type="text" id="name" name="name" />
		                    </td>
		                    <td class="coltext">所在机构</td>
		                    <td class="colinput">
								<select name="hospitalCode">
									<option value="">请选择</option>
									<c:forEach items="${hospitalInfos}" var="hospitalInfo">
										<option value="${hospitalInfo.hospitalNo}">${hospitalInfo.hospitalName}</option>
									</c:forEach>
								</select>
		                    </td>
							<td class="coltext">科室</td>
							<td class="colinput">
								<input type="text" id="deptName" name="deptName" />
							</td>
						</tr>
						<tr>

							<td class="coltext">热门专家</td>
							<td class="colinput">
								<ehr:dic-list name="isHot" dicmeta="FS10186" code="0,1" />
							</td>
							<td class="coltext">审核状态</td>
							<td class="colinput">
                                <ehr:dic-list name="status" dicmeta="LH00008" uninclude="2"/>
							</td>
							<td class="colinput"/>
							<td class="colinput">
								<input type="button" id="doctorSearchBut" value="查 询" class="search_btn" />
							</td>
						</tr>
					</tbody>
				</table>
		         <table>
		              <tr>
		                  <td colspan="4" class="colbottom">
		                         <span id="doctorSearchSpanId" class="ico-bottom">&nbsp;</span>
		                  </td>
		              </tr>
		         </table>
			</form>
		</div>
		<div id="listDivDoctor"></div>
	</div>
 	<div id="detailDivDoctor"></div>
</div>
