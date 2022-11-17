<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
  $(function() {
    var validate = $("#dicVersionForm").easyValidate();
    $("#saveButton").click(function(e) {
      e.preventDefault();
      if (validate.validateForm()) {
        $("#dicVersionForm").submitFormGetJson({
          url : "/mdmDictionary/saveDicVersion",
          callback : submitCallback,
          param : {
            type : $("#type").val()
          }
        });
      }
    });

    $("#cancelButton").click(function(e) {
    	e.preventDefault();
    	layer.closeAll();
     /*  $.removeDialog("d4"); */
    });


  });

  function versionSearch(indexPage){
    /* $.removeDialog("d3"); */
   /*  var dialogParams = {
      id : "d3",
      url : "/mdmDictionary/dicVersionList",
      height : 400,
      width : 850,
      close:dicItemSearch.submitCallback(),
      param : {
        dicCode : $("#parentDicCode").val(),
        indexPage : indexPage
      },
      title : "字典版本号管理"
    };
    $.dialog(dialogParams); */
    
    $.post(contextPath+'/mdmDictionary/dicVersionList',
			{
	    	dicCode : $("#parentDicCode").val(),
	        indexPage : indexPage
			},
			function(ret){
        		  layer.open({
        			  type: 1,
        			  id:'dicVersionManageDialog',
        			  area: ['850px', '400px'],
        			  title:"字典版本号管理",
        			  content: ret
        		  });
        	});
  }

  function submitCallback(data) {
    var index = layer.alert(data.message, {icon:0,title:'提示'}, function(){
      if (data.result) {
       layer.closeAll(); 
      /*  layer.close(index); // 提示窗口
       layer.close(index-1); // 新增或者编辑窗口 */
        versionSearch($("#versions_indexPage").val());
      }
    });
  }
</script>

<div>
  <div style="padding-left: 15px; padding-right: 15px; width: auto;">
    <form:form id="dicVersionForm" modelAttribute="dicVersion">
      <fieldset class="layui-elem-field">
        <legend>字典版本号信息:</legend>
        <table class="formtable">
          <tr>
            <th><label class="required">版本号</label></th>
            <td>
              <c:if test="${empty dicVersion.versionNumber}">
                <form:input path="versionNumber" reg='{"required":"true","digits":"true"}' cssClass="x-layui-input"/>
                <input type="hidden" id="type" value="add" />
              </c:if>
              <c:if test="${not empty dicVersion.versionNumber}">
                ${dicVersion.versionNumber}
                <form:hidden path="versionNumber" />
                <input type="hidden" id="type" value="edit" />
              </c:if>
            </td>
          </tr>
          <tr>
            <th><label class="required">版本描述</label></th>
            <td>
              <form:input path="versionDesc" reg='{"required":"true"}' cssClass="x-layui-input" />
              <form:hidden path="dicCode" value="${dicCode}"/>
            </td>
          </tr>
        </table>
      </fieldset>
    </form:form>
    <p style="margin-top: 15px;" align="center">
      <!-- <input type="button" id="saveButton" name="save" value="保 存" class="btnopr" /> -->
      <button class="layui-btn layui-btn-sm" id="saveButton">保存</button>
      <!-- <input type="button" id="cancelButton" name="save" value="关 闭" class="btnopr" /> -->
      <button class="layui-btn layui-btn-sm" id="cancelButton">关闭</button>
    </p>
    <div id="messageDiv" style="margin: 5px;"></div>
  </div>
</div>
