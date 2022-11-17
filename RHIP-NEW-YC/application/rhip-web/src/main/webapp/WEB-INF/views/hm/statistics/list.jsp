<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<div class="repeattable">
    <div id="hmStatisticsDiv">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
           <c:if test="${genrecode=='1' || (genrecode=='2' && patownShip_flag==0)}"><col style="width: 60px;width: 60px;"/></c:if>
           <c:if test="${genrecode=='2' && patownShip_flag==1}">
           	 <col style="width: 30px;min-width:30px;" />
           	 <col style="width: 30px;min-width:30px;" />
           </c:if>
            <col style="width: 30px;min-width:30px;" />
            <col style="width: 30px;min-width:30px;" />
            <col style="width: 30px;min-width:30px;" />
            <col style="width: 30px;min-width:30px;" />
            <col style="width: 30px;min-width:30px;" />
            <col style="width: 30px;min-width:30px;" />
            <col style="width: 30px;min-width:30px;" />
            <col style="width: 30px;min-width:30px;" />
            <c:if test="${genrecode=='1'}"><col style="width: 30px;min-width:30px;" /></c:if>
        </colgroup>
		<thead>
			<tr>
				<c:if test="${genrecode=='1'}"><th rowspan="2">机构名称</th></c:if>
	            <c:if test="${genrecode=='2'}">
	            	<th rowspan="2">所在镇</th>
	            	<c:if test="${patownShip_flag==1}"><th rowspan="2">所在居委会</th></c:if>
	            </c:if>
				<c:if test="${genrecode=='1'}"><th rowspan="2">老年人人数</th></c:if>
				<th colspan="8">检查人数</th>
			</tr>
			<tr>
				
				<th style="vertical-align: top;">空腹血糖</th>
				<th style="vertical-align: top;">血常规</th>
				<th style="vertical-align: top;">尿常规</th>
				<th style="vertical-align: top;">血脂四项</th>
				<th style="vertical-align: top;">肝功能三项</th>
				<th style="vertical-align: top;">肾功能二项</th>
				<th style="vertical-align: top;">B超</th>
				<th style="vertical-align: top;">心电图</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="result" items="${results}">
				<tr>
					<c:if test="${genrecode=='1'}">
						<td><ehr:tip><ehr:org code="${result.org_code}"/></ehr:tip></td>
	                    <td class="righttd">${result.older_num}</td>
                    </c:if>
                    <c:if test="${genrecode=='2'}">
                    	<c:if test="${patownShip_flag==1}"><td><ehr:dic code="${result.parent_code}" dicmeta="FS990001"/></td></c:if>
                    	<td><ehr:dic code="${result.item_code}" dicmeta="FS990001"/></td>
                    </c:if>
                    <td class="righttd">${result.fpg_count}</td>
                    <td class="righttd">${result.blood_count}</td>
                    <td class="righttd">${result.urine_count}</td>
                    <td class="righttd">${result.dyslipidemia_count}</td>
                    <td class="righttd">${result.liver_count}</td>
                    <td class="righttd">${result.renal_count}</td>
                    <td class="righttd">${result.b_count}</td>
                    <td class="righttd">${result.ecg_count}</td>
				</tr>
			</c:forEach>
			<c:if test="${total!=null}">
               <tr>
                  	<c:if test="${genrecode=='1' || (genrecode=='2' && patownShip_flag==0)}"><td><b>合计</b></td></c:if>
                    <c:if test="${genrecode=='2' && patownShip_flag==1}">
                    	<td colspan="2"><b>合计</b></td>
                    </c:if>
	               <c:if test="${genrecode=='1'}"><td class="righttd">${total.older_num}</td></c:if>
                   <td class="righttd">${total.fpg_count}</td>
                   <td class="righttd">${total.blood_count}</td>
                   <td class="righttd">${total.urine_count}</td>
                   <td class="righttd">${total.dyslipidemia_count}</td>
                   <td class="righttd">${total.liver_count}</td>
                   <td class="righttd">${total.renal_count}</td>
                   <td class="righttd">${total.b_count}</td>
                   <td class="righttd">${total.ecg_count}</td>
               </tr>
              </c:if>
		</tbody>
	</table>
	</div>
    </div>
</div>