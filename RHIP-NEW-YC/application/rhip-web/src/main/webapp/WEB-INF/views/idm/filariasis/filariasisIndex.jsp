<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../../layouts/load-js-css-resources.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/js/views/idm/filariasis/filariasis.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/views/idm/idmCommon.js" type="text/javascript"></script>

<script>
    var tabContent = 0;
    layui.use('element', function () {
        var element = layui.element;

        $("#tag1").click(function () {
            if ($("#tag1").hasClass("layui-this")) {
                tabContent = 0;
            } else if ($("#tag2").hasClass("layui-this")) {
                tabContent = 1;
            } else if ($("#tag3").hasClass("layui-this")) {
                tabContent = 2;
            } else if ($("#tag4").hasClass("layui-this")) {
                tabContent = 3;
            }
        });

        $("#tag2").click(function () {
            if ($("#tag1").hasClass("layui-this")) {
                tabContent = 0;
            } else if ($("#tag2").hasClass("layui-this")) {
                tabContent = 1;
            } else if ($("#tag3").hasClass("layui-this")) {
                tabContent = 2;
            } else if ($("#tag4").hasClass("layui-this")) {
                tabContent = 3;
            }
        });

        $("#tag3").click(function () {
            if ($("#tag1").hasClass("layui-this")) {
                tabContent = 0;
            } else if ($("#tag2").hasClass("layui-this")) {
                tabContent = 1;
            } else if ($("#tag3").hasClass("layui-this")) {
                tabContent = 2;
            } else if ($("#tag4").hasClass("layui-this")) {
                tabContent = 3;
            }
        });

        $("#tag4").click(function () {
            if ($("#tag1").hasClass("layui-this")) {
                tabContent = 0;
            } else if ($("#tag2").hasClass("layui-this")) {
                tabContent = 1;
            } else if ($("#tag3").hasClass("layui-this")) {
                tabContent = 2;
            } else if ($("#tag4").hasClass("layui-this")) {
                tabContent = 3;
            }
        });

        // 事件监听
        element.on('tab(idmfilariasisTab)', function (data) {
            if (data.index == 0) {
                if (contentChanged) {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        var index = layer.confirm('确认离开？',{icon:0, title:'确认提示'}, function (index) {
                            layer.close(index);
                            disableChangeConfirm();
                            filariasis.registerIndex();
                            return;
                        });
                    });
                    if (tabContent == 0) {
                        element.tabChange('idmfilariasisTab', 'tag1');
                    } else if (tabContent == 1) {
                        element.tabChange('idmfilariasisTab', 'tag2');
                    } else if (tabContent == 2) {
                        element.tabChange('idmfilariasisTab', 'tag3');
                    } else if (tabContent == 3) {
                        element.tabChange('idmfilariasisTab', 'tag4');
                    }
                }else {
                    filariasis.registerIndex();
                }
            } else if (data.index == 1) {
                if (contentChanged) {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        var index = layer.confirm('确认离开？', {icon:0, title:'确认提示'}, function (index) {
                            layer.close(index);
                            disableChangeConfirm();
                            filariasis.caseIndex();
                            return;
                        });
                    });
                    if (tabContent == 0) {
                        element.tabChange('idmfilariasisTab', 'tagContent1');
                    } else if (tabContent == 1) {
                        element.tabChange('idmfilariasisTab', 'tagContent2');
                    } else if (tabContent == 2) {
                        element.tabChange('idmfilariasisTab', 'tagContent3');
                    } else if (tabContent == 3) {
                        element.tabChange('idmfilariasisTab', 'tagContent4');
                    }
                }else {
                    filariasis.caseIndex();
                }
            } else if (data.index == 2) {
                if (contentChanged) {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        var index = layer.confirm('确认离开？', {icon:0, title:'确认提示'}, function (index) {
                            layer.close(index);
                            disableChangeConfirm();
                            filariasis.standardIndex();
                            return;
                        });
                    });
                    if (tabContent == 0) {
                        element.tabChange('idmfilariasisTab', 'tagContent1');
                    } else if (tabContent == 1) {
                        element.tabChange('idmfilariasisTab', 'tagContent2');
                    } else if (tabContent == 2) {
                        element.tabChange('idmfilariasisTab', 'tagContent3');
                    } else if (tabContent == 3) {
                        element.tabChange('idmfilariasisTab', 'tagContent4');
                    }
                }else {
                    filariasis.standardIndex();
                }
            } else if (data.index == 3) {
                if (contentChanged) {
                    layui.use('layer', function () {
                        var layer = layui.layer;
                        var index = layer.confirm('确认离开？', {icon:0, title:'确认提示'}, function (index) {
                            layer.close(index);
                            disableChangeConfirm();
                            filariasis.reportIndex();
                            return;
                        });
                    });
                    if (tabContent == 0) {
                        element.tabChange('idmfilariasisTab', 'tagContent1');
                    } else if (tabContent == 1) {
                        element.tabChange('idmfilariasisTab', 'tagContent2');
                    } else if (tabContent == 2) {
                        element.tabChange('idmfilariasisTab', 'tagContent3');
                    } else if (tabContent == 3) {
                        element.tabChange('idmfilariasisTab', 'tagContent4');
                    }
                }else {
                    filariasis.reportIndex();
                }
            }
        });
    });
</script>

<div id="con" class="sectionnoborder">
<div class="toolbar">
			<div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">传染病及突发事件</a>
		        <a href="javascript:void(0)">专项</a>
		        <a>
		          <cite>丝虫病</cite></a>
		      </span>
		</div>
        </div>
    <div class="layui-tab layui-tab-brief" lay-filter="idmfilariasisTab" style="width: 98%;margin-left: 8px;">
        <ul class="layui-tab-title">
            <li class="layui-this" id="tag1" lay-id="tag1">监测登记</li>
            <li id="tag2" lay-id="tag2">个案调查</li>
            <li id="tag3" lay-id="tag3">规范化管理</li>
            <li id="tag4" lay-id="tag4">统计报表</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show" id="tagContent1">
            </div>
            <div class="layui-tab-item" id="tagContent2">
            </div>
            <div class="layui-tab-item" id="tagContent3">
            </div>
            <div class="layui-tab-item" id="tagContent4">
            </div>
        </div>
    </div>
</div>


