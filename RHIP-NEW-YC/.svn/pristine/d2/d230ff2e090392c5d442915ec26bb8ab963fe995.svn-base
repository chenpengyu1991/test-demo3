<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- <script type="text/javascript">
require(['views/ihm/cwhTarget/child/childCountEcharts'],function(hmIndex) {
	hmIndex.load();
	});
</script>  -->
<div class="repeattable">
    <input type="hidden" id="count" value="${count}"/>
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:150px;width: 20%;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
			<col style="min-width:80px;"/>
		</colgroup>
        <thead>
			<tr>
				<th>镇</th>
				<th>0-1岁</th>
				<th>1-2岁</th>
				<th>2-3岁</th>
				<th>3-4岁</th>
				<th>4-5岁</th>
				<th>5-6岁</th>
				<th>6-7岁</th>
				<th>总计</th>
			</tr>
        </thead>
		<tbody>
			<c:forEach var="childCound" items="${childCoundList}" varStatus="status">
                 <tr>
					 <td>
						 <c:choose>
							 <c:when test="${childCound.ORGAN_CODE=='合计'}">合计</c:when>
							 <c:otherwise>
								 <c:choose>
									 <c:when test="${genreCode == '0'}"><ehr:dic dicmeta="FS990001" code="${childCound.ORGAN_CODE}"/></c:when>
									 <c:otherwise><ehr:tip><ehr:org code="${childCound.ORGAN_CODE}"/></ehr:tip></c:otherwise>
								 </c:choose>
							 </c:otherwise>
						 </c:choose>
					 </td>
					 <td class="centertd"><ehr:tip>${empty childCound.G1?0:childCound.G1}</ehr:tip></td>
					 <td class="centertd"><ehr:tip>${empty childCound.G2?0:childCound.G2}</ehr:tip></td>
					 <td class="centertd"><ehr:tip>${empty childCound.G3?0:childCound.G3}</ehr:tip></td>
					 <td class="centertd"><ehr:tip>${empty childCound.G4?0:childCound.G4}</ehr:tip></td>
					 <td class="centertd"><ehr:tip>${empty childCound.G5?0:childCound.G5}</ehr:tip></td>
					 <td class="centertd"><ehr:tip>${empty childCound.G6?0:childCound.G6}</ehr:tip></td>
					 <td class="centertd"><ehr:tip>${empty childCound.G7?0:childCound.G7}</ehr:tip></td>
					 <td class="centertd"><ehr:tip>${empty childCound.ORGSUM?0:childCound.ORGSUM}</ehr:tip></td>
				 </tr>
			</c:forEach>
		</tbody>
	</table>
</div>