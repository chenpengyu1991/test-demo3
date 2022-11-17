<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">
    var srList = (function() {
        function atStart() {
            $("#tab0").click(function () {
                selectTag("tagContent0", this);
            });
            $("#tab1").click(function () {
                selectTag("tagContent1", this);
            });
            searchSr(1);
        }

        function searchSr(pageIndex) {
            var searchObj = {
                url: "/sr/list",
                insertDiv: "srDiv",
                param: {
                    pageIndex: pageIndex,
                    organCode: $("#organCodeForSr").val(),
                    type: "onlyView"
                }
            };

            $("#searchForm").submitFormLoadHtml(searchObj);
        }

        function selectTag(showContent,selfObj){
            $('#organInfo').find('#tags').find('li').each(function(){
                $(this).removeClass('selectTag');
            });

            selfObj.parentNode.className = "selectTag";
            $('#organInfo').find('#tagContent').find("[id^='tagContent']").each(function(){
                $(this).hide();
            });

            document.getElementById(showContent).style.display = "block";
        }
        return {
            atStart: atStart
        }
    })();
</script>
<script src="${pageContext.request.contextPath}/js/views/mdm/organizationArea/add.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/mdm/organizationArea/tree.js" type="text/javascript"></script>

<!--不要注释下面的代码，谢谢配合-->
<div class="toolbar" id="organinitdivid">
    <label><a href="javascript:void(0)" style="margin-top:6px;" onclick="javascript:villageAdd.popupAreaInfo(${selectYear})" title="查看详情">
    <button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe615;</i>查看详情</button>
    
    
    </a></label>
    <c:if test="${selectYear eq currentYear}">
	<span id="hiddenBtn">
   	 	<a href="javascript:void(0)" onclick="javascript:villageAdd.saveRelation()" id="baocun"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe605;</i>保存机构对应村关系</button></a>
    		<a href="javascript:void(0)" id="btnMerge"><button class="layui-btn layui-btn-sm" ><i class="layui-icon">&#xe605;</i>合并机构</button></a>
    </span>
    </c:if>
</div>
<input type="hidden" name="organCode" id="orgCodes"/>
<input type="hidden" id="genreCode"/>
<input type="hidden" id="orgId"/>

<input type="hidden" id="selectYear" value="${selectYear}"/>
<div class="postcontent contentfixed32" style="margin-top: 40px;height: 350px;">
 <table>
     <colgroup>
        <col style="min-width: 420px; width: 50%;">
        <col style="min-width: 300px; width: 50%;">
    </colgroup>
    <tr>
        <td style="padding-top: 0px; vertical-align: text-top;">
            <jsp:include page="tree.jsp"/>
        </td>
        <td style="padding-top: 0px; vertical-align: text-top; padding-right: 10px; padding-bottom: 10px;">
              <div class="repeattable" id="listDiv"></div>
          </td>
      </tr>
  </table>
</div>