<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>
<jsp:include page="../layouts/load-js-css-resources.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/views/menubox/menubox.css"/>
<script type="text/javascript">
var roleAccess = (function () {
    var model = {getAllAccess:getAllAccess};
    //当前选择角色信息
    var current = {};

    $(function () {
    	//分页绑定函数
		pageUtil.bind("role-access-role-list",searchRole);
        searchRole(1);
        enterEven('searchRole', 'role-access-role-search-form"', '1');
        $("#role-access-role-list").on("click", ".role-access-access-setting", getAccess);
        getAllAccess();
        //
        $("#role-access-expand-selected-btn").on("click", function (e) {
        	e.preventDefault();
        	expandSelected();
        });
        $("#role-access-expand-all-true-btn").on("click", function (e) {
        	e.preventDefault();
        	expandAll(true);
        });
        $("#role-access-expand-all-false-btn").on("click", function (e) {
        	e.preventDefault();
        	expandAll(false);
        });
        $("#role-access-role-search-btn").on("click", function (e) {
        	e.preventDefault();
            searchRole(1);
        });
        $("#role-access-role-access-save-btn").on("click", function (e) {
        	e.preventDefault();
        	saveRoleAccess(1);
        });

        $("#role-access-expand-add-btn").on("click", function (e) {
        	e.preventDefault();
        	menuManage('add');
        });
        $("#role-access-expand-modify-btn").on("click", function (e) {
        	e.preventDefault();
        	menuManage('modify');
        });
        $("#role-access-expand-delete-btn").on("click", function (e) {
        	e.preventDefault();
        	menuManage('delete');
        });
        $("#menuManageBtn").click(function(e) {
        	e.preventDefault();
        	$("#menubox").show();
            $(document).on("click", clickSomeWhereListener);
        });
        function clickSomeWhereListener(e) {
            if (e.target.id != "menuManageBtn") {
                $("#menubox").hide();
                $(document).off("click", clickSomeWhereListener);
            }
        }
    });

    /*
     * 弹出菜单管理画面
     * add:新增
     * modify:修改
     * delete:删除
     * */
    function menuManage(type){
        var node = getSelectedMenu();
        debugger;
        if("delete" == type){
            debugger;
            if($.isEmpty(node)){
                layer.alert("请选择菜单！", {icon:0,title:'提示'});
                return;
            } else if(node['menuId'] == '0'){
                layer.alert("根节点不能删除！", {icon:0,title:'提示'});
                return;
            } else if(!$.isEmpty(node.children)){
                layer.alert("请先删除子菜单！", {icon:0,title:'提示'});
                return;
            }
            layer.confirm("确认删除菜单信息？", {icon:2, title:'确认提示'}, function(index){
                $("#role-access-role-search-form").submitFormGetJson({
                    url : "/role/deleteMenu",
                    callback : function(data) {
                        if (data.indexOf("fail") > -1) {
                            layer.alert("删除失败！", {icon:0,title:'提示'});
                        }else {
                            layer.alert("删除成功！", {icon:0,title:'提示'});
                            getAllAccess();
                            return false;
                        }
                    },
                    param : {menuId:node['menuId']},
                    wait:true
                });
                layer.close(index);
            });
        }else{
            if(node['menuId'] == '0' && "modify" == type){
                layer.alert("根节点不能修改！", {icon:0,title:'提示'});
                return;
            }
            var menuManageDialog = {
                url : "/role/popuMenu",
                height : 300,
                width : 500,
                title : "菜单管理" ,
                id :"menuManageDialog",
                param:{
                    type:type,
                    menuId:node['menuId']
                }
            };
            $.dialog(menuManageDialog);
        }
    }

    /*
     * 获取当前选择的菜单
     * */
    function getSelectedMenu() {

        var selNode = null;
        var zTree = $.fn.zTree.getZTreeObj("role-access-menu-tree");
        var nodes = zTree.getSelectedNodes();
        if(!$.isEmpty(nodes)){
            selNode = nodes[0];
        }
        return selNode;
    }

    function getAllAccess() {
        $.getJsonByUrl({
            url: "/role/roleAccess/getAccesses",
            callback: function (data) {
                if (data) {
                    initTree(data);
                }
            }});
    }

    model.searchRole = searchRole;
    function searchRole(indexPage) {
        //翻页后,必须重选设置权限
        current.success = false;
        var zTree = $.fn.zTree.getZTreeObj("role-access-menu-tree");
        if(zTree){
            zTree.checkAllNodes(false);
            expandAll(false);
        }
        //获取角色列表
        var url = "/role/roleAccess/roleList";
        var searchObj = {
            url: url,
            insertDiv: "role-access-role-list",
            param: { indexPage: indexPage}
        };
        $("#role-access-role-search-form").formPost(searchObj);
    }

    function getAccess(event) {
        var zTree = $.fn.zTree.getZTreeObj("role-access-menu-tree");
        zTree.checkAllNodes(false);
        expandAll(false);
        var $this = $(this);
        //var roleCode = $this.data("roleCode"); 若是数字会自动转换为整数 不符合需求 例如原值是04 获取后为4
        var roleCode = $this.attr("data-role-code");
        current.roleCode = roleCode;
        current.success = false;
        current.desc = $this.data("roleDesc");
        if (roleCode) {
            $.getJsonByUrl({
                url: "/role/roleAccess/getAccessByRole",
                param: {roleCode: roleCode},
                checkRepeat: true,
                callback: function (data) {
                    try {
                        checkNodes(data);
                        current.success = true;
                    } catch (e) {
                        current.success = false;
                        layer.alert("获取权限失败！", {icon:0,title:'提示'});
                    }
                }});
        }
    }

    function getSelectedRoleId() {
        var $table = $("#role-access-role-list").find("#role-access-role-list-result");
        var $selectedTr = $table.find("tr.listtrselect")
        if ($selectedTr.length > 0) {
            return $selectedTr.attr("data-role-code");
            //return $selectedTr.data("roleCode");
        }
        return null;
    }

    function saveRoleAccess() {
        var currentRoleId = current.roleCode;
        if (!current.success) {
            layer.alert("请设置权限！", {icon:0,title:'提示'});
            return;
        }

        var selectedRoleId = getSelectedRoleId();
        if (null == selectedRoleId) {
            layer.alert("请选择角色！", {icon:0,title:'提示'});
            return;
        }

        //检查当前权限设置是否为选中角色的
        if (currentRoleId != selectedRoleId) {
            layer.alert("当前权限与选择的角色不符,请重新选择角色！", {icon:0,title:'提示'});
            return;
        }

        //获取设置后的权限id集合
        var treeObj = $.fn.zTree.getZTreeObj("role-access-menu-tree");
        var nodes = treeObj.getCheckedNodes(true);
        var message = "确定保存" + current.desc + "的权限?";
        if (nodes.length == 0) {
            message += "注意:当前没有选择任何权限!";
        }
        layer.confirm(message, {icon:1, title:'确认提示'}, function (index) {
            var accessCodes = [];
            for (var i = 0; i < nodes.length; i++) {
                var node = nodes[i];
                accessCodes[i] = node["accessCode"];
            }
            $.getJsonByUrl({
                url: "/role/roleAccess/saveAccess",
                param: {accessCodes: accessCodes.join(","), roleCode: currentRoleId},
                callback: function (data) {
                    if (false == data) {
                        layer.alert("保存失败！", {icon:0,title:'提示'})
                    } else {
                        layer.alert("保存成功！", {icon:0,title:'提示'})
                    }
                }});
            layer.close(index);
        })
    }

    function checkNodes(data) {
        var zTree = $.fn.zTree.getZTreeObj("role-access-menu-tree");
        for (var i = 0; i < data.length; i++) {
            var accessCode = data[i].accessCode;  
            var node = zTree.getNodeByParam("accessCode", accessCode, null);
            if (null != node) {
                zTree.checkNode(node, true, false, false);
            }
        }
        expandRoot();
    }

    function initTree(accessData) {
        var treeSetting = {
            view: {
                dblClickExpand: false,
                selectedMulti: true
            },
            data: {
                simpleData: {
                    enable: true,
                    idKey: "accessCode",
                    pIdKey: "parentCode",
                    rootPid: 0
                },
                key: {
                    name: "label"
                }
            },
            check: {
                enable: true
            }
        };
        $.fn.zTree.init($("#role-access-menu-tree"), treeSetting, accessData);

        expandRoot();
    }

    function expandAll(flag) {
        var treeObj = $.fn.zTree.getZTreeObj("role-access-menu-tree");
        treeObj.expandAll(flag);
    }

    function filter(node) {
        return (node.level == 1 && node.checked == true);
    }

    function expandSelected() {

        var treeObj = $.fn.zTree.getZTreeObj("role-access-menu-tree");
        //只需要选择一级节点即可
        var nodes = treeObj.getNodesByFilter(filter);
        for (var i = 0; i < nodes.length; i++) {
            treeObj.expandNode(nodes[i], true, true, true);
        }
    }

    /**
     *   展开根节点
     */
    function expandRoot(){

        var treeObj = $.fn.zTree.getZTreeObj("role-access-menu-tree");
        var rootNode = treeObj.getNodeByParam("accessCode", 0, null);
        treeObj.expandNode(rootNode, true, false, true);
        treeObj.selectNode(rootNode);
    }
    return model;
})();

//快捷键show ctrl+shift+<- =======快捷键hide ctrl+shift+->
$(document).keydown(function(e){
    if(e.which == 37&&e.shiftKey&&e.ctrlKey) {
        $("#menudivid").show();
    }
    if(e.which == 39&&e.shiftKey&&e.ctrlKey) {
        $("#menudivid").hide();
    }
});

</script>
<div class="toolbar">
    <div class="x-nav">
		      <span class="layui-breadcrumb">
		        <a href="javascript:void(0)">系统管理</a>
		        <a href="javascript:void(0)">权限管理</a>
		        <a>
		          <cite>角色权限</cite></a>
		      </span>
    </div>
    <a id="role-access-role-access-save-btn" href="javascript:void(0)"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe605;</i>保存</button></a>
</div>
<div class="section divFixed105" style="top: 50px;">
    <div class="searchbox searchSection x-admin-sm">
        <form id="role-access-role-search-form">
            <table id="roleSearch">
                <colgroup>
                    <col style="width: 10%">
                    <col style="width: 40%">
                    <col style="width: 12%">
                    <col style="width: 33%">
                    <col style="width: 5%">
                </colgroup>
                <tr>
                    <td class="coltext">角色描述</td>
                    <td class="colinput">
                        <input type="text" name="description" style="width: 200px;" class="x-layui-input">
                        <input type="text" style="display: none;">
                    </td>
                    <td>
                    <!-- <input type="button" id="role-access-role-search-btn" value="查 询" class="search_btn"/> -->
                    <button class="layui-btn layui-btn-sm" id="role-access-role-search-btn"><i class="layui-icon">&#xe615;</i>查询</button>
                    </td>
                    <td style="text-align: right">
                        <div class="toolbar">
                            <div style="position: relative">
                                <a href="javascript:void(0)" id="role-access-expand-selected-btn">展开选择</a>
                                <a href="javascript:void(0)" id="role-access-expand-all-true-btn">展开全部</a>
                                <a href="javascript:void(0)" id="role-access-expand-all-false-btn">关闭全部</a>
                                <a href="javascript:void(0)" id="menudivid" style="display: none;"><b class="xinz" id="menuManageBtn">菜单管理</b></a>
                                <div id="menubox">
                                    <ul>
                                        <li><a href="javascript:void(0)" id="role-access-expand-add-btn">添加菜单</a></li>
                                        <li><a href="javascript:void(0)" id="role-access-expand-modify-btn">修改菜单</a></li>
                                        <li><a href="javascript:void(0)" id="role-access-expand-delete-btn">删除菜单</a></li>
                                    </ul>
                                </div>
                            </div>

                        </div>
                    </td>
                    <td></td>
                </tr>
            </table>
        </form>
    </div>
    <div style="float: left;width: 60%" id="role-access-role-list"></div>
    <div style="float: left;width: 35%;margin-left: 10px;">
        <div id="role-access-menu-tree-content" class="treeContent " style="max-height: 600px;min-height:500px;overflow: auto;border: 1px solid #e6e6e6;">
            <ul id="role-access-menu-tree" class="ztree" style="margin-top: 0; "></ul>
        </div>
    </div>
    <br style="clear: both"/>
</div>

