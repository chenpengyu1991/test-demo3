<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet"
	  href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">新生儿登记表</li>
	</ul>
	<br />
	<div class="table-basic">
		<table class="layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 20%;" />
				<col style="width: 30%;" />
				<col style="width: 20%;" />
				<col style="width: 30%;" />
			</colgroup>
			<tr>
				<th>个人健康档案编号</th>
				<td>${whYcfbjXsedj.jkdabh}</td>
				<th>孕产妇编号</th>
				<td>${whYcfbjXsedj.ycfbh}</td>
			</tr>
			<tr>
				<th>准生证编号</th>
				<td>${whYcfbjXsedj.zszbh}</td>
				<th>医学出生证号</th>
				<td>${whYcfbjXsedj.yxcszh}</td>
			</tr>
			<tr>
				<th>胎数</th>
				<td>${whYcfbjXsedj.ts}</td>
				<th>出生顺序</th>
				<td>${whYcfbjXsedj.cssx}</td>
			</tr>
			<tr>
				<th>娩出时间</th>
				<td colspan="3"><fmt:formatDate value="${whYcfbjXsedj.mcsj}" pattern="yyyy/MM/dd" /></td>
			</tr>
			<tr>
				<th>分娩方式</th>
				<%--分娩方式代码表--%>
				<c:if test="${whYcfbjXsedj.fmfsDm ne '9'}">
					<td colspan="3">${whYcfbjXsedj.fmfsMc}</td>
				</c:if>
				<c:if test="${whYcfbjXsedj.fmfsDm eq '9'}">
					<td>其他</td>
					<th>分娩方式详述</th>
					<td colspan="3">${whYcfbjXsedj.fmfsxs}</td>
				</c:if>
			</tr>
			<tr>
				<th>新生儿性别</th>
				<%--人的性别代码表--%>
				<td>${whYcfbjXsedj.xsexb}</td>
				<th>出生身高</th>
				<td>${whYcfbjXsedj.cssg}cm</td>
			</tr>
			<tr>
				<th>出生体重</th>
				<td>${whYcfbjXsedj.cstz}千克</td>
				<th>出生儿结局</th>
				<%--出生儿结局代码表--%>
				<td>
					<c:choose>
						<c:when test="${whYcfbjXsedj.csejjDm eq '9'}">${whYcfbjXsedj.csejjqtxs}</c:when>
						<c:otherwise>${whYcfbjXsedj.csejjMc}</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>Apgar1分钟评分</th>
				<td>${whYcfbjXsedj.apgar1fzpf}</td>
				<th>Apgar5分钟评分</th>
				<td>${whYcfbjXsedj.apgar5fzpf}</td>
			</tr>
			<tr>
				<th>Apgar10分钟评分</th>
				<td>${whYcfbjXsedj.apgar10fzpf}</td>
				<th>是否出生缺陷</th>
				<%--是/否判断--%>
				<td>${whYcfbjXsedj.sfcsqxMc}</td>
			</tr>
			<c:if test="${whYcfbjXsedj.sfcsqxDm eq '2'}">
				<tr>
					<%--出生缺陷类别代码表--%>
					<c:if test="${whYcfbjXsedj.csqxlbDm ne '99'}">
						<th>出生缺陷类别</th>
						<td colspan="3">${whYcfbjXsedj.csqxlbdmMc}</td>
					</c:if>
						<c:if test="${whYcfbjXsedj.csqxlbDm eq '99'}">
							<th>出生缺陷详述</th>
							<td colspan="3">${whYcfbjXsedj.csqxxs}</td>
						</c:if>
				</tr>
			</c:if>
			<tr>
				<th>是否出生后1小时内早接触、早吸吮、早开奶</th>
				<%--是/否判断--%>
				<td>${whYcfbjXsedj.sfcsh1xsnzjczxszknMc}</td>
				<th>有无病理性黄疸</th>
				<%--有/无判断--%>
				<td>${whYcfbjXsedj.ywblxhdMc}</td>
			</tr>
			<tr>
				<th>有无呼吸窘迫综合症</th>
				<%--有/无判断--%>
				<td>${whYcfbjXsedj.ywhxjpzhzMc}</td>
				<th>有无肺炎</th>
				<%--有/无判断--%>
				<td>${whYcfbjXsedj.ywfyMc}</td>
			</tr>
			<tr>
				<th>有无硬肿症</th>
				<%--有/无判断--%>
				<td>${whYcfbjXsedj.ywyzzMc}</td>
				<th>有无缺血缺氧性脑病</th>
				<%--有/无判断--%>
				<td>${whYcfbjXsedj.ywqxqyxnbMc}</td>
			</tr>
			<tr>
				<th>有无脐部感染</th>
				<%--有/无判断--%>
				<td>${whYcfbjXsedj.ywqbgrMc}</td>
				<th>有无败血症</th>
				<%--有/无判断--%>
				<td>${whYcfbjXsedj.ywbxzMc}</td>
			</tr>
			<tr>
				<th>有无破伤风</th>
				<%--有/无判断--%>
				<td>${whYcfbjXsedj.ywpsfMc}</td>
				<th>其他新生儿并发症详述</th>
				<td>${whYcfbjXsedj.qtxsebzxs}</td>
			</tr>
			<tr>
				<th>是否新生儿存活</th>
				<%--是/否判断--%>
				<td>${whYcfbjXsedj.sfxsechMc}</td>
				<th>是否母乳喂养</th>
				<%--是/否判断--%>
				<td>${whYcfbjXsedj.sfmrwyMc}</td>
			</tr>
			<tr>
				<th>是否新生儿疾病筛查（2项）</th>
				<%--已筛查/未筛查判断--%>
				<td>${whYcfbjXsedj.sfxsejbscMc2x}</td>
				<th>是否新生儿疾病筛查（27项）</th>
				<%--已筛查/未筛查判断--%>
				<td>${whYcfbjXsedj.sfxsejbscMc27x}</td>
			</tr>
			<tr>
				<th>听力检测结果</th>
				<%--新生儿听力筛查代码表--%>
				<td>${whYcfbjXsedj.tljcjgMc}</td>
				<th>疫苗名称</th>
				<%--疫苗名称代码表--%>
				<td>${whYcfbjXsedj.ymMc}</td>
			</tr>
			<tr>
				<th>乙肝免疫球蛋白注射情况</th>
				<%--注射情况代码表--%>
				<td colspan="3">${whYcfbjXsedj.ygmyqdbzsqk}</td>
			</tr>
			<tr>
				<th>备注</th>
				<td colspan="3">
					<c:out value="${whYcfbjXsedj.bz}"></c:out>
				</td>
			</tr>
		</table>
	</div>
</div>