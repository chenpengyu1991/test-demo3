<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<div id="ehr-brw-check-content">
    <script language="JavaScript">
        !(function () {
            $(function () {
                $("#check-submit-btn").on("click", function () {
                    open();
                });
                open();
            });

            function open() {
                checkIdcard(function (idCard) {
                    var parent = $("#ehr-brw-check-content").parent();
                    var id = parent.attr("id");
                    var personId = $("input[name='personId']", "#check-card-input-form").val();
                    var submitFormLoadHtmlOption = {
                        url: "/ehrbrowser/index/" + personId,
                        insertDiv: id,
                        param: {cicIdCard: idCard}
                    };
                    $("#check-card-input-form").submitFormLoadHtml(submitFormLoadHtmlOption);
                })
            }


            function checkIdcard(callback) {
                var result = readIdCard();
                var resultType = result.result;
                if (resultType == 1) {
                    showMessage("您暂时没有查看健康档案的权限，若有需要请联系管理员!");
                    return;
                }

//                if (resultType == 2) {
//                   showMessage("请刷市民卡!");
//                    return;
//                }
//
//                if (resultType == 3) {
//                   showMessage("市民卡身份证号读取失败!");
//                    return;
//                }

//                var idCard = result.idCard;
//                var currentIdCard = $("input[name='idCard']", "#check-card-input-form").val() || "";
//                currentIdCard = $.trim(currentIdCard.toLowerCase())
//
//                if (currentIdCard) {
//                    if (idCard == currentIdCard) {
//                        if ($.isFunction(callback)) {
//                            callback(idCard);
//                        }
//                    } else {
//                       showMessage("市民卡身份证与当前信息不匹配!");
//                    }
//                } else {
//                   showMessage("当前人员无身份证信息,请检查是否已经建档!");
//                }

            }

            function readIdCard() {
                return  readIdCardForPro();
            }

            function readIdCardForDev() {
                var result = {result: 9, idCard: ""};
                var currentIdCard = $("input[name='idCard']", "#check-card-input-form").val() || "";
                currentIdCard = $.trim(currentIdCard.toLowerCase())
                result.idCard = currentIdCard;
                return result
            }

            function readIdCardForPro() {
                var result = {result: 1, idCard: ""};
                var smkInfoObj;
                try {
                    smkInfoObj = readCsSmk();
                } catch (e) {
                    smkInfoObj = null;
                }

                if (null == smkInfoObj) {
                    result.result = 1;//读卡失败
                } else if (smkInfoObj == 'error') {
                    result.result = 2;//请正确放入市民卡
                } else if (!$.isPlainObject(smkInfoObj) || smkInfoObj.IDCardNum == null || smkInfoObj.IDCardNum == "") {
                    result.result = 3;//市民卡身份证号读取失败
                } else {
                    result.result = 9;//
                    var idCard = smkInfoObj.IDCardNum || "";
                    idCard = $.trim(idCard.toString());
                    result.idCard = idCard.toLowerCase();
                }
                return result;
            }

            function showMessage(msg){
                $("#check-card-message").html(msg);
            }

        })();
    </script>
    <style type="text/css">
        <!--
        .messagenav{
            width:600px;
            height:180px;
            border:1px #d4d4d4 solid;
            background-color:#eef6f8;
            margin: 180px  auto;
        }

        -->
    </style>
    <form id="check-card-input-form">
        <input type="hidden" name="personId" value="${personId}">
        <input type="hidden" name="idCard" value="${personIdcard}">

        <div class="postcontent">
            <div class="postdiv" >

                <table class="posttable messagenav" style="">
                    <tr>
                        <td  style="padding-left: 50px;"><h3 class="tip">提示信息:</h3></td>
                    </tr>
                    <tr>
                        <td style="padding-left: 100px;"> <label id="check-card-message" style="color: red"> ${checkMessage}</label></td>
                    </tr>
                    <tr>
                        <td style="text-align: right;padding-right: 50px;"><input type="button" id="check-submit-btn" value="刷新"></td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                </table>

            </div>
        </div>
    </form>
</div>
