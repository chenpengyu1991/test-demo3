<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<link href="${pageContext.request.contextPath}/js/fineuploader/fineuploader-3.4.1.css" rel="stylesheet"/>
<script type="text/javascript"
        src="${pageContext.request.contextPath}/js/fineuploader/jquery.fineuploader-3.4.1.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        healthEducationUpload.uploadFile("heCopyFile", "/he/upload/uploadFile/gjtg", "/he/upload/deleteFile/gjtg");
    });
</script>
<div class="postcontent">
    <input type="hidden" name="id" value="${heCopy.id}">
    <table class="posttable">
        <colgroup>
            <col style="width: 20%;"/>
            <col style="width: 30%;"/>
            <col style="width: 20%;"/>
            <col style="width: 30%;"/>
        </colgroup>
        <tr>
            <th>刊（播）出文章题目</th>
            <td>
                ${heCopy.title}
            </td>
            <th>刊（播）日期</th>
            <td>
                <fmt:formatDate value="${heCopy.publishDate}" pattern="yyyy/MM/dd"></fmt:formatDate>
            </td>
        </tr>
        <tr>
            <th>发表新闻单位</th>
            <td><ehr:dic dicmeta="HE00012" code="${heCopy.publishOrgan}"></ehr:dic></td>
            <th>版面</th>
            <td>${heCopy.edition}</td>
        </tr>
        <tr>
            <th>类型</th>
            <td><ehr:dic dicmeta="HE00013" code="${heCopy.type}"></ehr:dic></td>
            <th>作者</th>
            <td>${heCopy.author}</td>
        </tr>
        <tr>
            <th>级别</th>
            <td><ehr:dic dicmeta="HE00014" code="${heCopy.pLevel}"></ehr:dic></td>
            <th>媒体分类</th>
            <td><ehr:dic dicmeta="HE00015" code="${heCopy.media}"></ehr:dic></td>
        </tr>
        <tr>
            <th>信息类别</th>
            <td><ehr:dic dicmeta="HE00016" code="${heCopy.category}"></ehr:dic></td>
            <th><label>字数</label></th>
            <td>${heCopy.words}</td>
        </tr>
        <tr>
            <th>附件</th>
            <td colspan="3">
                <table>
                    <tr>
                        <c:forEach items="${attches}" var="attche" varStatus="status">
                        <td style="padding: 15px;"><c:if test="${status.index % 4 == 0 && status.index != 0}">
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
                            <a target="blank"  href="${pageContext.request.contextPath}/he/upload/download/${attche.id}" onclick="javascript:void(0)">${attche.originalFileName}</a>
                        </c:if>
                    </td>
                    </c:forEach>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</div>
