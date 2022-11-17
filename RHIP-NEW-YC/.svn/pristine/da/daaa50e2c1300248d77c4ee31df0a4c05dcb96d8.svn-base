<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<script>
    function initEdit(type, id) {
        var title = '';
        if("add" == type){
            title = '添加药品设置';
        }else if("edit" == type){
            title = '修改药品设置';
        }
        
        $.post(contextPath+"/dcConfig/check/drug/add", {
        	id:id
    	},
    	function(ret) {
    	  layer.open({
    		  type: 1,
    		  id:"dcConfigDialog",
    		  area: ['450px', '220px'],
    		  title:title,
    		  content: ret
    	  });
    	});
    }

    function del(id) {
    	layer.confirm("确定删除吗？", {icon:2, title:'确认提示'}, function(index){
            var params = {
                url : "/dcConfig/check/inspect/delete",
                callback : function(data) {
                	layer.closeAll();
                    if (data.indexOf("fail") > -1) {
                    	layer.alert("删除失败！", {icon:0,title:'提示'});
                    }else {
                    	layer.alert("删除成功！", {icon:0,title:'提示'});
                        search(1);
                    }
                },
                param : {
                    id : id
                }
            };
            $.getJsonByUrl(params);
            layer.close(index);
        });
    }

    function search(pageIndex) {
        $("#messageDiv").remove();
        $("#top_all").show();
        $("#detailDiv").hide();
        pageIndex = (isEmpty(pageIndex)?1:pageIndex);
        var personal = $("#personal").val();
        var searchObj = {
            url : '/dcConfig/check/drug/list',
            insertDiv : "resultDiv",
            param : {
                pageIndex : pageIndex,
                personal : personal
            },
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
        };
        $("#searchForm").submitFormLoadHtml(searchObj);
    };
</script>
<div class="repeattable">
    <table class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;"/>
            <col style="min-width:80px;width:18%;"/>
        </colgroup>
        <thead>
        <tr>
            <th>检查项</th>
            <th>时限（小时）</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="result" items="${resultList}" varStatus="status">
            <tr>
                <td><ehr:tip>${result.itemCode}</ehr:tip></td>
                <td class="righttd"><ehr:tip>${result.itemValue}</ehr:tip></td>
                <td class="centertd">
                	<a href="javascript:void(0);" onclick="initEdit('edit', ${result.id})" title="修改"><i class="layui-icon">&#xe642;</i></a>
					<a href="javascript:void(0);" onclick="del(${result.id})" title="删除"><i class="layui-icon">&#xe640;</i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table>
        <tr>
            <ehr:pagination action="search"/>
        </tr>
    </table>
</div>