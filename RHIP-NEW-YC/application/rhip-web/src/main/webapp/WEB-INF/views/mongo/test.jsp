<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery1.7.2.js"></script>
<script>
    var contextPath = "${pageContext.request.contextPath}";
    function uploadFile() {
        $("#fileForm").form('submit',{
            url:contextPath + "/mongo/testUpload",
            type:"post",
            success:function(data){
            }
        })
    }

</script>
<form method="post"  enctype="multipart/form-data" id="fileForm" action="${pageContext.request.contextPath}/mongo/testUpload">
    <!-- <input type="text" id="pid"> -->
    <input name="file" type="file" style ="width: 300px">
    <input type="submit" value="Upload" />
</form>
<a onclick='uploadFile()'>上传</a>
<a href="${pageContext.request.contextPath}/mongo/testDownload">下载</a>
