<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<script src="${pageContext.request.contextPath}/js/views/he/supervisor/detail.js" type="text/javascript"></script>

<div class="postcontent">
		<div class="postdiv">
			<table class="posttable">
				<colgroup>
					<col style="width: 15%;"/>
					<col style="width: 35%;"/>
					<col style="width: 15%;"/>
					<col style="width: 35%;"/>
				</colgroup>
				<tr>
					<th>督查时间</th>
					<td>
						<fmt:formatDate value="${healthSupervisor.overseeTime}" pattern="yyyy/MM/dd"/>
					</td>
					<th>参加人员</th>
					<td>
						${healthSupervisor.participants}
					</td>
				</tr>
				<tr>
					<th>督查对象</th>
					<td>
						${healthSupervisor.overseePerson}
					</td>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th>内容摘要</th>
					<td colspan="3">${healthSupervisor.content}</td>
				</tr>
				<tr>
					<th>附件</th>
					<td colspan="3">
						<table>
							<tr>
								<c:forEach items="${attches}" var="attche" varStatus="status">
									<td style="padding: 15px;">
									<c:if test="${status.index % 4 == 0 && status.index != 0}">
										<tr>
										</tr>
										<td style="padding: 15px;">
									</c:if>
								<c:if test="${attche.imageFlag eq true}">
										<a target="blank" href="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=1"><img alt="点击查看大图" title="点击查看大图"
											src="${pageContext.request.contextPath}/he/upload/showAsImage/${attche.id}?type=2"
										/></a>
									</c:if>
									<c:if test="${attche.imageFlag eq false}">
										<a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.fileName}</a>
									</c:if>
								</td>
								</c:forEach>
							</tr>
						</table>
						</td>
					</tr>
				</table>
					</td>
				</tr>
			</table>
		</div>
</div>