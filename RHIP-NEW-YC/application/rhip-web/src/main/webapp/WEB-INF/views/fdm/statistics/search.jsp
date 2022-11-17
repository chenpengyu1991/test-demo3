<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<div class="section">
    <div class="searchBox">
    <form method="post" id="fdm-statistics-search">
        <input type="hidden" id="searchUrl" value="${searchUrl}">
            <table id="targetSearch">
               <tbody>  
	                <tr>
	                    <%--<input type="hidden" name="id" value="${finance.id}"/>--%>
	                    <%--<th style="text-align: right;">监测医院</th>--%>
	                    <%--<td>--%>
	                        <%--<tag:autoSelect name="organCode" id="organCode" style="width:150px" reg='{"required":"true"}'></tag:autoSelect>--%>
	                    <%--</td>--%>
	                    <th style="text-align: right;">月份</th>	              
                        <td class="colinput">
                            <tag:dateInput name="yearMonth" id="yearMonth" pattern="yyyy/MM" reg="{'required':'true'}" style="width:150px;"></tag:dateInput>
                        </td>  	                    
	                    <td style="text-align: center;" colspan="2"><input type="button" id="fdmStatisticsBtnSearch" value="查询" class="search_btn" onclick="search()"/></td>
				    </tr>
		       </tbody>
            </table>
            <table>
                <tr>
                    <td class="col-bottom">
                        <span onclick="util.toggle(this,'targetSearch')" class="ico-bottom">&nbsp;</span>
                    </td>
                </tr>
            </table>
    </form>
    </div>
    <div id="resultDiv">
        <jsp:include page="list.jsp" ></jsp:include>
    </div> 
</div>

<script type="text/javascript">

$(function(){
//    $("#fdmStatisticsBtnSearch").onEnter(search);
    //机构下拉树设置
//    var option={
//        url:"/mdmOrganization/organationTree",
//        unSelecteType:['0','B1','B2']  //不能选择：0是镇，B1是中心, B2是中心
//    };
//    //机构自动检索设置
//    var opb = {
//        url:"/mdmOrganization/organationSelect",
//        feild: {
//            value: "organCode",
//            lable: "organName"
//        },
//        param:{organType:['A1','B1'], subsid:0}  //只查询A1（市级医院）
//    };
//    var organCode=$("#organCode");
//    if(organCode.length>0){
//        //初始化自动检索
//        organCode.selectBox(opb);
//        //初始化下拉树
//        organCode.initTreeSelect(option);
//    }
})

    function search() {
        validate = $("#fdm-statistics-search").easyValidate();
        var result=validate.validateForm();
        if(!result){
            return;
        }
        var yearMonth = $("#yearMonth").val();
        var searchObj = {
            url : "/fdm/reportCard/summaryList",
            param : {yearMonth:yearMonth},
            insertDiv : "resultDiv"
        };
        $("#fdm-statistics-search").submitFormLoadHtml(searchObj);
    }


</script>