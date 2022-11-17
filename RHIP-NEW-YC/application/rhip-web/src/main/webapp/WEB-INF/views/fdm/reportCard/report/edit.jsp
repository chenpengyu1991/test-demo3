<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="toolbar" style="margin-top: 10px;">
    <!-- <a href="javascript:void(0)" id="fdm-report-back-btn"><b class="fanhui">返回</b></a> -->
    <a href="javascript:void(0)" id="fdm-report-back-btn"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
    <%--疾控卫生科打回后修改--%>
    <c:if test="${food.status eq 6 || food.status eq 7}">
        <!-- <a href="javascript:void(0)" id="fdm-report-save-btn"><b class="baocun">保存</b></a> -->
        <a href="javascript:void(0)" id="fdm-report-save-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
    </c:if>
    <c:if test="${food.status eq 1}">
        <!-- <a href="javascript:void(0)" id="fdm-report-appok-btn"><b class="tongguo">通过</b></a> -->
        <a href="javascript:void(0)" id="fdm-report-appok-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>通过</button></a>
        <!-- <a href="javascript:void(0)" id="fdm-report-appno-btn"><b class="zuofei">作废</b></a> -->
        <a href="javascript:void(0)" id="fdm-report-appno-btn"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#x1006;</i>作废</button></a>
    </c:if>
</div>
<jsp:include page="input.jsp"></jsp:include>
<script type="text/javascript">
    !(function() {

        toggleOtherCK('nerveSymptom','pupilException','513');
        toggleOtherCK('previousHistory','previousHistoryOther','99');
        toggleOtherCK('foodHistory','foodHistoryOther','99');
        var validate = null;

        $(function() {
            validate = $("#report-input-form").easyValidate();

            $("#fdm-report-save-btn").on("click", save);
            $("#fdm-report-back-btn").on("click", back);
            $("#fdm-report-appno-btn").on("click", cacel);
            $("#fdm-report-appok-btn").on("click", app);
        });

        function back(event) {
            event.preventDefault();
            layer.confirm("确认离开？",function(index){
                layer.close(index);
                fdReportCardSearch.back();
            });

        }

        function cacel(event) {
        	event.preventDefault();
            customValidate();
            var result = validate.validateForm();
            if (!result) {
                return;
            }
            var id=$("#report-input-form input[name='id']").val();
            $("#report-input-form").submitFormGetJson({
                url : "/fdm/reportCard/app",
                param:{
                    id:id,
                    op:'2'
                },
                callback : function(data) {
                    if (true == data) {
                    	layer.alert("作废成功！", {icon:0,title:'提示'});
                        fdReportCardSearch.back();
                        fdReportCardSearch.refresh();
                    } else {
                    	layer.alert("作废失败！", {icon:0,title:'提示'});
                    }
                }
            });
        }

        function app(event) {
        	event.preventDefault();
            customValidate();
            var result = validate.validateForm();
            if (!result) {
                return;
            }
            var id=$("#report-input-form input[name='id']").val();
            $("#report-input-form").submitFormGetJson({
                url : "/fdm/reportCard/app",
                param:{
                    id:id,
                    op:'1'
                },
                callback : function(data) {
                    if (true == data) {
                    	layer.alert("审核成功！", {icon:0,title:'提示'});
                        fdReportCardSearch.back();
                        fdReportCardSearch.refresh();
                    } else {
                    	layer.alert("审核失败！", {icon:0,title:'提示'});
                    }
                }
            });
        }

        function save(event) {
        	event.preventDefault();
            customValidate();
            var result = validate.validateForm();
            if (!result) {
                return;
            }

            $("#report-input-form").submitFormGetJson({
                url : "/fdm/reportCard/save",
                callback : function(data) {
                    if (true == data) {
                    	layer.alert("保存成功！", {icon:0,title:'提示'});
                        fdReportCardSearch.back();
                        fdReportCardSearch.refresh();
                    } else {
                    	layer.alert("保存失败！", {icon:0,title:'提示'});
                    }
                }
            });
        }

        function customValidate(){
            var idCard = $('#idCardTemp').val();
            if(idCard == '输入身份证获取人员信息'){
                $('#idCardTemp').val('');
            }
        }
    })();
</script>