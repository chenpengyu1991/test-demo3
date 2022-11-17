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
		<li style="text-align: center; font-size: 25px;">孕产妇死亡登记</li>
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
				<td>${whYcfbjSwdj.jkdabh}</td>
				<th>孕产妇编号</th>
				<td>${whYcfbjSwdj.ycfbh}</td>
			</tr>
			<tr>
				<th>孕妇姓名</th>
				<td>${whYcfbjSwdj.yfxm}</td>
				<th>孕妇出生日期</th>
				<td><fmt:formatDate value="${whYcfbjSwdj.yfcsrq}" pattern="yyyy/MM/dd" /></td>
			</tr>
			<tr>
				<th>孕妇年龄</th>
				<td>${whYcfbjSwdj.yfnl}</td>
				<th>怀孕次数</th>
				<td>${whYcfbjSwdj.hycs}</td>
			</tr>
			<tr>
				<th>生产次数</th>
				<td>${whYcfbjSwdj.sccs}</td>
				<th>引、流产次数</th>
				<td>${whYcfbjSwdj.yLccs}</td>
			</tr>
			<tr>
				<th>末次月经日期</th>
				<td><fmt:formatDate value="${whYcfbjSwdj.mcyjrq}" pattern="yyyy/MM/dd" /></td>
				<th>分娩时间</th>
				<td><fmt:formatDate value="${whYcfbjSwdj.fmsj}" pattern="yyyy/MM/dd" /></td>
			</tr>
			<tr>
				<%--是/否判断--%>
				<th>是否高危孕产妇</th>
				<td>${whYcfbjSwdj.sfgwycf}</td>
				<th>高危登记编号</th>
				<td>${whYcfbjSwdj.gwdjbh}</td>
			</tr>
			<tr>
				<%--孕产期高危高因素代码表--%>
				<th>孕产期高危因素</th>
				<td>${whYcfbjSwdj.ycqgwysMc}</td>
				<th>孕产期其他高危因素</th>
				<td>${whYcfbjSwdj.ycqqtgwys}</td>
			</tr>
			<tr>
				<%--高危评定代码表--%>
				<th>高危评定</th>
				<td>${whYcfbjSwdj.gwpddmMc}</td>
				<th>高危评分</th>
				<td>${whYcfbjSwdj.gwpf}</td>
			</tr>
			<tr>
				<th>治疗结果</th>
				<td colspan="3">${whYcfbjSwdj.zljgMc}</td>

			</tr>
			<tr>
				<%--接生者类型代码表--%>
				<th>接生者类型</th>
				<c:if test="${whYcfbjSwdj.jszlxDm ne '9'}">
					<td colspan="3">${whYcfbjSwdj.jszlxMc}</td>
				</c:if>
				<c:if test="${whYcfbjSwdj.jszlxDm eq '9'}">
					<td>其他人员</td>
					<th>接生者类型其他详述</th>
					<td colspan="3">${whYcfbjSwdj.jszlxqtxs}</td>
				</c:if>
			</tr>
			<tr>
				<%--有/无判断--%>
				<th>有无产前检查</th>
				<td>${whYcfbjSwdj.ywcqjcMc}</td>
				<th>初检孕周</th>
				<td>${whYcfbjSwdj.cjyz}</td>
			</tr>
			<tr>
				<th>产检次数</th>
				<td>${whYcfbjSwdj.cjcs}</td>
				<th>主要诊断编码</th>
				<%--ICD-10--%>
				<td>${whYcfbjSwdj.zyzdbmMc}</td>
			</tr>
			<tr>
				<%--死亡诊断依据代码表--%>
				<th>死亡诊断依据</th>
				<c:if test="${whYcfbjSwdj.swzdyjDm ne '7'}">
					<td colspan="3">${whYcfbjSwdj.swzdyjMc}</td>
				</c:if>
				<c:if test="${whYcfbjSwdj.swzdyjDm eq '7'}">
					<td>不详</td>
					<th>死亡诊断依据详述</th>
					<td colspan="3">${whYcfbjSwdj.swzdyjxs}</td>
				</c:if>
			</tr>
			<tr>
				<%--分娩地点代码表--%>
				<th>分娩地点</th>
				<c:if test="${whYcfbjSwdj.fmddDm ne '9'}">
					<td colspan="3">${whYcfbjSwdj.fmddMc}</td>
				</c:if>
				<c:if test="${whYcfbjSwdj.fmddDm eq '9'}">
					<td>其他</td>
					<th>分娩地点其他详述</th>
					<td colspan="3">${whYcfbjSwdj.fmddqtxs}</td>
				</c:if>
			</tr>
			<tr>
				<th>分娩机构</th>
				<td colspan="3">${whYcfbjSwdj.fmjgMc}</td>
			</tr>
			<tr>
				<%--分娩方式代码表--%>
				<th>分娩方式</th>
				<c:if test="${whYcfbjSwdj.fmfsDm ne '9'}">
					<td colspan="3">${whYcfbjSwdj.fmfsMc}</td>
				</c:if>
				<c:if test="${whYcfbjSwdj.fmfsDm eq '9'}">
					<td>其他</td>
					<th>分娩方式详述</th>
					<td colspan="3">${whYcfbjSwdj.fmfsxs}</td>
				</c:if>
			</tr>
			<tr>
				<%--死前治疗类别代码表--%>
				<th>死前治疗类别</th>
				<c:if test="${whYcfbjSwdj.sqzllbDm ne '3'}">
					<td colspan="3">${whYcfbjSwdj.sqzllbMc}</td>
				</c:if>
				<c:if test="${whYcfbjSwdj.sqzllbDm eq '3'}">
					<td>其他</td>
					<th>死前治疗类别其他详述</th>
					<td colspan="3">${whYcfbjSwdj.sqzllbqtxs}</td>
				</c:if>
			</tr>
			<tr>
				<%--未治疗就医原因代码表--%>
				<th>未治疗就医原因</th>
				<c:if test="${whYcfbjSwdj.wzljyyyDm ne '9'}">
					<td colspan="3">${whYcfbjSwdj.wzljyyyMc}</td>
				</c:if>
				<c:if test="${whYcfbjSwdj.wzljyyyDm eq '9'}">
					<td>其他</td>
					<th>未治疗就医原因其他详述</th>
					<td colspan="3">${whYcfbjSwdj.wzljyyyqtxs}</td>
				</c:if>
			</tr>
			<tr>
				<%--死亡地点类别代码表--%>
				<th>孕妇死亡地点</th>
				<c:if test="${whYcfbjSwdj.yfswddDm ne '99'}">
					<td colspan="3">${whYcfbjSwdj.yfswddMc}</td>
				</c:if>
				<c:if test="${whYcfbjSwdj.yfswddDm eq '99'}">
					<td>其他</td>
					<th>孕妇死亡地点其他详述</th>
					<td colspan="3">${whYcfbjSwdj.yfswddqtxs}</td>
				</c:if>
			</tr>
			<tr>
				<th>病历摘要</th>
				<td>${whYcfbjSwdj.blzy}</td>
				<th>病理解剖结果</th>
				<td>${whYcfbjSwdj.bljpjg}</td>
			</tr>
			<tr>
				<%--孕产妇死亡死因分类代码表--%>
				<th>孕产妇死亡死因分类</th>
				<c:if test="${whYcfbjSwdj.ycfswsyflDm ne '99'}">
					<td colspan="3">${whYcfbjSwdj.ycfswsyflMc}</td>
				</c:if>
				<c:if test="${whYcfbjSwdj.ycfswsyflDm eq '99'}">
					<td>其他</td>
					<th>孕产妇死亡死因分类其他详述</th>
					<td colspan="3">${whYcfbjSwdj.ycfswsyflqtxs}</td>
				</c:if>
			</tr>
			<tr>
				<%--影响孕产妇死亡主要因素代码表--%>
				<th>影响孕产妇死亡主要因素</th>
				<c:if test="${whYcfbjSwdj.yxycfswzyysDm ne '99'}">
					<td colspan="3">${whYcfbjSwdj.yxycfswzyysMc}</td>
				</c:if>
				<c:if test="${whYcfbjSwdj.yxycfswzyysDm eq '99'}">
					<td>其他问题</td>
					<th>影响孕产妇死亡主要因素其他详述</th>
					<td colspan="3">${whYcfbjSwdj.yxycfswzyysqtxs}</td>
				</c:if>
			</tr>
			<tr>
				<th>死亡登记机构</th>
				<td colspan="3">${whYcfbjSwdj.swdjjgMc}</td>
			</tr>
			<tr>
				<th>备注</th>
				<td colspan="3">
					<c:out value="${whYcfbjSwdj.bz}"></c:out>
				</td>
			</tr>
		</table>
	</div>
</div>