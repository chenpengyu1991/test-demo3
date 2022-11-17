<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<table>
    <tr>
        <td colspan="2">
        	<c:if test="${empty doctorSetMap || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '2')}">
	            <fieldset class="layui-elem-field" style="padding: 4px;margin: 4px;">
	                <legend><span style="font-size: 12px;font-weight: bolder;">医疗保健活动</span></legend>
					 <span style="float: right"> <a class="index_medical_more_btn btn_more " title="医疗保健活动" href='<c:url value="/healthevent/search"></c:url>'> </a>
					</span> <br style="clear:  both"/>
	                <jsp:include page="healthevent/datagrid.jsp"></jsp:include>
	            </fieldset>
            </c:if>
        </td>
    </tr>

   <c:if test="${empty doctorSetMap || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '3')}">
    <tr>
        <td valign="top">
            <fieldset class="layui-elem-field" style="padding: 4px;margin: 4px;">
                <legend><span style="font-size: 12px;font-weight: bolder;">检验</span>
                </legend> <span style="float: right"> <a class="index_medical_more_btn btn_more" title="检验列表" href="<c:url value="/exam/search"></c:url>"></a>
				</span> <br style="clear:  both"/>
                <jsp:include page="exam/datagrid.jsp"></jsp:include>
            </fieldset>
        </td>
        <td valign="top">
	            <fieldset class="layui-elem-field" style="padding: 4px;margin: 4px;">
	                <legend><span style="font-size: 12px;font-weight: bolder;">检查</span></legend> <span style="float: right"> <a class="index_medical_more_btn btn_more" title="检查列表" href="<c:url value="/study/search"></c:url>"></a>
					</span> <br style="clear:  both"/>
	                <jsp:include page="study/datagrid.jsp"></jsp:include>
	            </fieldset>
        </td>
    </tr>
    </c:if>

	<c:if test="${empty doctorSetMap || not empty doctorSetMap && fn:contains(doctorSetMap[doctorType], '4')}">
	    <tr>
	        <td colspan="2">
		            <fieldset class="layui-elem-field" style="padding: 4px;margin: 4px;">
		                <legend><span style="font-size: 12px;font-weight: bolder;">用药情况</span> </legend><span style="float: right"> <a class="index_medical_more_btn btn_more" title="用药情况" href='<c:url value="/drug/search"></c:url>'></a>
						</span> <br style="clear:  both"/>
		                <jsp:include page="drug/datagrid.jsp"></jsp:include>
		            </fieldset>
	        </td>
	    </tr>
	</c:if>
</table>








