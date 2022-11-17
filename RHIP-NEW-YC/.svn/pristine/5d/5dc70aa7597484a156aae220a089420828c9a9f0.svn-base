<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="repeattable" style="width:100%;overflow:auto;height:450px;">
	<table id="doctorSignCensusTable" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 70px;" />
			<col style="width: 130px;" />
			<col style="width: 60px;" />
			<col style="width: 70px;" />
			
			<col style="width: 70px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 70px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
						
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 70px;" />
						
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
						
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			<col style="width: 60px;" />
			
			<col style="width: 60px;" />
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2">区县</th>
				<th rowspan="2">机构</th>
				<th colspan="33">家庭医生签约服务进展情况统计表</th>
			</tr>
			<tr>
				<th>已组建家庭医生团队数(个)</th>
				<th>辖区户籍人口数(人)</th>
				<th>辖区内常住居民数(人)</th>
				<th>常住人 口签约数(人)</th>
				<th>常住人口签约率(%)</th>
				
				<th>辖区内重点人群总数(人)</th>
				<th>重点人群签约数(人)</th>
				<th>重点人群签约率(%)</th>
				
				<th>辖区内0-6岁儿童数(人)</th>
				<th>辖区内接受1次及以上随访的0-6岁儿童数(人)</th>
				<th>0-6岁儿童签约数(人)</th>
				<th>0-6岁儿童签约率(%)</th>
				
				<th>辖区内65岁及以上常住居民数(人)</th>
				<th>辖区内65岁及以上已管理常住居民数(人)</th>
				<th>65岁及以上常住居民签约数(人)</th>
				<th>65岁及以上常住居民签约率(%)</th>
				
				<th>辖区内孕13周之前建册并进行第一次产前检查的产妇人数(人)</th>
				<th>孕产妇签约数(人)</th>
				<th>孕产妇签约率(%)</th>
				
				<th>年内辖区内高血压患者总人数(人)</th>
				<th>辖区内已管理的高血压患者人数(人)</th>
				<th>在管高血压患者家庭医生签约人数(人)</th>
				<th>在管高血压患者家庭医生签约率(%)</th>
				
				<th>年内辖区内糖尿病患者总人数(人)</th>
				<th>辖区内已管理的2型糖尿病患者人数(人)</th>
				<th>糖尿病患者签约人数(人)</th>
				<th>糖尿病患者签约率(%)</th>
				
				<th>已管理的肺结核患者人数(人)</th>
				<th>肺结核患者签约数(人)</th>
				<th>肺结核患者签约率(%)</th>
				
				<th>辖区内按照规范要求进行管理的严重精神障碍患者人数(人)</th>
				<th>严重精神障碍患者签约数(人)</th>
				<th>严重精神障碍患者签约率(%)</th>
			</tr>
		</thead>
		<tbody id="displayBody">
			 <c:forEach var="report" items="${reports}" >
				<tr>
					<td>
						<ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"  /></ehr:tip>
					</td>
					<td>
						<c:choose>
							<c:when test="${not empty all}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
							<c:when test="${empty orgCode && empty centerOrgCode && empty gbcode}">
								<ehr:tip><ehr:dic code="${report.orgCode}" dicmeta="FS990001"  /></ehr:tip>
							</c:when>
							<c:when test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
						</c:choose>
					</td>
					<!-- 已组建家庭医生团队数（个） -->
					<td title="${report.doctorTeamNum }">${report.doctorTeamNum }</td>
					
					<!-- 户籍人口数（人） -->
					<td title="${report.householdNum }">${report.householdNum }</td>
					
					<!-- 常住人口 -->
					<td title="${report.permanentNum}">${report.permanentNum}</td>
					<td title="${report.permanentSignNum}">${report.permanentSignNum}</td>
					<td title="<fmt:formatNumber value="${report.permanentNum==0?0:(report.permanentSignNum/report.permanentNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.permanentNum==0?0:(report.permanentSignNum/report.permanentNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 重点人群 -->
					<td title="${report.focusGroupsNum}">${report.focusGroupsNum}</td>
					<td title="${report.focusGroupsSignNum}">${report.focusGroupsSignNum}</td>
					<td title="<fmt:formatNumber value="${report.focusGroupsNum==0?0:(report.focusGroupsSignNum/report.focusGroupsNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.focusGroupsNum==0?0:(report.focusGroupsSignNum/report.focusGroupsNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 0-6岁儿童-->
					<td title="${report.childNum}">${report.childNum}</td>
					<td title="${report.familyVisitNum}">${report.familyVisitNum}</td>
					<td title="${report.childSignNum}">${report.childSignNum}</td>
					<td title="<fmt:formatNumber value="${report.childNum==0?0:(report.childSignNum/report.childNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.childNum==0?0:(report.childSignNum/report.childNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 65岁及以上常住居民-->
					<td title="${report.householdGreatSixfNum}">${report.householdGreatSixfNum}</td>
					<td title="${report.greatSixfHasNum}">${report.greatSixfHasNum}</td>
					<td title="${report.greatSixfSignNum}">${report.greatSixfSignNum}</td>
					<td title="<fmt:formatNumber value="${report.greatSixfHasNum==0?0:(report.greatSixfSignNum/report.greatSixfHasNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.greatSixfHasNum==0?0:(report.greatSixfSignNum/report.greatSixfHasNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 孕产妇-->
					<td title="${report.womenNum}">${report.womenNum}</td>
					<td title="${report.womenSignNum}">${report.womenSignNum}</td>
					<td title="<fmt:formatNumber value="${report.womenNum==0?0:(report.womenSignNum/report.womenNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.womenNum==0?0:(report.womenSignNum/report.womenNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 高血压患者-->
					<td title="${report.hbpNum}">${report.hbpNum}</td>
					<td title="${report.hbpHasNum}">${report.hbpHasNum}</td>
					<td title="${report.hbpSignNum}">${report.hbpSignNum}</td>
					<td title="<fmt:formatNumber value="${report.hbpHasNum==0?0:(report.hbpSignNum/report.hbpHasNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.hbpHasNum==0?0:(report.hbpSignNum/report.hbpHasNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 糖尿病患者-->
					<td title="${report.diNum}">${report.diNum}</td> 
					<td title="${report.diHasNum}">${report.diHasNum}</td> 
					<td title="${report.diSignNum}">${report.diSignNum}</td> 
					<td title="<fmt:formatNumber value="${report.diHasNum==0?0:(report.diSignNum/report.diHasNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.diHasNum==0?0:(report.diSignNum/report.diHasNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 肺结核患者-->
					<td title="${report.tubercManageNum}">${report.tubercManageNum}</td> 
					<td title="${report.tubercSignNum}">${report.tubercSignNum}</td> 
					<td title="<fmt:formatNumber value="${report.tubercManageNum==0?0:(report.tubercSignNum/report.tubercManageNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.tubercManageNum==0?0:(report.tubercSignNum/report.tubercManageNum)*100}" pattern="#,##0.0"/>% 
					</td>
					
					<!-- 严重精神障碍患者-->
					<td title="${report.mentalManageNum}">${report.mentalManageNum}</td> 
					<td title="${report.mentalSignNum}">${report.mentalSignNum}</td> 
					<td title="<fmt:formatNumber value="${report.mentalManageNum==0?0:(report.mentalSignNum/report.mentalManageNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.mentalManageNum==0?0:(report.mentalSignNum/report.mentalManageNum)*100}" pattern="#,##0.0"/>% 
					</td>
				</tr>
			</c:forEach>
			<c:if test="${census!=null}">
				<tr>
					<td colspan="2"><strong>合计</strong></td>
					<!-- 已组建家庭医生团队数（个） -->
						<td title="${census.doctorTeamNum }">${census.doctorTeamNum }</td>
						
						<!-- 户籍人口数（人） -->
						<td title="${census.householdNum }">${census.householdNum }</td>
						
						<!-- 常住人口 -->
						<td title="${census.permanentNum}">${census.permanentNum}</td>
						<td title="${census.permanentSignNum}">${census.permanentSignNum}</td>
						<td title="<fmt:formatNumber value="${census.permanentNum==0?0:(census.permanentSignNum/census.permanentNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.permanentNum==0?0:(census.permanentSignNum/census.permanentNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 重点人群 -->
						<td title="${census.focusGroupsNum}">${census.focusGroupsNum}</td>
						<td title="${census.focusGroupsSignNum}">${census.focusGroupsSignNum}</td>
						<td title="<fmt:formatNumber value="${census.focusGroupsNum==0?0:(census.focusGroupsSignNum/census.focusGroupsNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.focusGroupsNum==0?0:(census.focusGroupsSignNum/census.focusGroupsNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 0-6岁儿童-->
						<td title="${census.childNum}">${census.childNum}</td>
						<td title="${census.familyVisitNum}">${census.familyVisitNum}</td>
						<td title="${census.childSignNum}">${census.childSignNum}</td>
						<td title="<fmt:formatNumber value="${census.childNum==0?0:(census.childSignNum/census.childNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.childNum==0?0:(census.childSignNum/census.childNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 65岁及以上常住居民-->
						<td title="${census.householdGreatSixfNum}">${census.householdGreatSixfNum}</td>
						<td title="${census.greatSixfHasNum}">${census.greatSixfHasNum}</td>
						<td title="${census.greatSixfSignNum}">${census.greatSixfSignNum}</td>
						<td title="<fmt:formatNumber value="${census.greatSixfHasNum==0?0:(census.greatSixfSignNum/census.greatSixfHasNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.greatSixfHasNum==0?0:(census.greatSixfSignNum/census.greatSixfHasNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 孕产妇-->
						<td title="${census.womenNum}">${census.womenNum}</td>
						<td title="${census.womenSignNum}">${census.womenSignNum}</td>
						<td title="<fmt:formatNumber value="${census.womenNum==0?0:(census.womenSignNum/census.womenNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.womenNum==0?0:(census.womenSignNum/census.womenNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 高血压患者-->
						<td title="${census.hbpNum}">${census.hbpNum}</td>
						<td title="${census.hbpHasNum}">${census.hbpHasNum}</td>
						<td title="${census.hbpSignNum}">${census.hbpSignNum}</td>
						<td title="<fmt:formatNumber value="${census.hbpHasNum==0?0:(census.hbpSignNum/census.hbpHasNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.hbpHasNum==0?0:(census.hbpSignNum/census.hbpHasNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 糖尿病患者-->
						<td title="${census.diNum}">${census.diNum}</td> 
						<td title="${census.diHasNum}">${census.diHasNum}</td> 
						<td title="${census.diSignNum}">${census.diSignNum}</td> 
						<td title="<fmt:formatNumber value="${census.diHasNum==0?0:(census.diSignNum/census.diHasNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.diHasNum==0?0:(census.diSignNum/census.diHasNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 肺结核患者-->
						<td title="${census.tubercManageNum}">${census.tubercManageNum}</td> 
						<td title="${census.tubercSignNum}">${census.tubercSignNum}</td> 
						<td title="<fmt:formatNumber value="${census.tubercManageNum==0?0:(census.tubercSignNum/census.tubercManageNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.tubercManageNum==0?0:(census.tubercSignNum/census.tubercManageNum)*100}" pattern="#,##0.0"/>% 
						</td>
						
						<!-- 严重精神障碍患者-->
						<td title="${census.mentalManageNum}">${census.mentalManageNum}</td> 
						<td title="${census.mentalSignNum}">${census.mentalSignNum}</td> 
						<td title="<fmt:formatNumber value="${census.mentalManageNum==0?0:(census.mentalSignNum/census.mentalManageNum)*100}" pattern="#,##0.0"/>%">
							<fmt:formatNumber value="${census.mentalManageNum==0?0:(census.mentalSignNum/census.mentalManageNum)*100}" pattern="#,##0.0"/>% 
						</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</div>