<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<script src="${pageContext.request.contextPath}/js/util/jquery.jqprint-0.3.js" type="text/javascript"></script>
<script>
    $(function() {
        $("#tjbh_print-back-btn").on("click", function(){
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                $("#detailDiv").empty();
                $("#top_all").show();
                $("#list_datagrid").show();
            });
        });
        $("#tjbh-print-btn").click(function(e){
            e.preventDefault();
            $("#tjbhPrintDivId").jqprint(
                {
                    debug: false, //如果是true则可以显示iframe查看效果（iframe默认高和宽都很小，可以再源码中调大），默认是false
                    importCSS: true, //true表示引进原来的页面的css，默认是true。（如果是true，先会找$("link[media=print]")，若没有会去找$("link")中的css文件）
                    printContainer: true, //表示如果原来选择的对象必须被纳入打印（注意：设置为false可能会打破你的CSS规则）。
                    operaSupport: true//表示如果插件也必须支持歌opera浏览器，在这种情况下，它提供了建立一个临时的打印选项卡。默认是true
                }
            );

        });
    });

</script>
<div class="toolbar" style="margin-top: 10px;">
    <a href="javascript:void(0)" id="tjbh_print-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <a href="javascript:void(0)" id="tjbh-print-btn" ><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe66d;</i>打印</button></a>
</div>
<div class="postcontent" style="width: auto;" id="tjbhPrintDivId">
    <i class="popno">身份证条形码打印</i>
    <fieldset class="layui-elem-field">
        <legend>个人基本信息</legend>
    <table class="posttable">
        <colgroup>
            <col style="width: 30%;"/>
            <col style="width: 70%;"/>
        </colgroup>
        <tr>
            <th><label>姓名：</label></th>
            <td>
               ${personBasicInfo.name}
            </td>
        </tr>
        <tr>
            <th> <label>性别：</label></th>
            <td>
                <ehr:dic dicmeta="GBT226112003" code="${personBasicInfo.gender}"/>
            </td>
        </tr>
        <tr>
            <th><label>身份证条形码：</label></th>
            <td>
                <img src="${pageContext.request.contextPath}/barcode/show?msg=${personBasicInfo.idcard}" height="118px" width=197px/>
            </td>
        </tr>
<%--        <tr>
            <th> <label>体检编号：</label></th>
            <td>
                ${phyExamPrintDTO.physiqueExamination.physicalExamCode}
            </td>
        </tr>--%>
    </table>
    </fieldset>
</div>