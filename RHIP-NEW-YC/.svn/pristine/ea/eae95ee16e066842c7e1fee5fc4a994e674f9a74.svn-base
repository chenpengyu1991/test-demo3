/**
 * Created by jingqiu on 17-3-25.
 */
var examList = (function() {
    $(function() {
        $('#returnChildSearchBtn').click(function () {
            $('#child-exam-input-box').empty();
            $('#child-exam-input-box').hide();
            $('#child-exam-list-box').show();
            childSearch.search(1);
        });
        $('#newExamBtn').click(function () {
            var babyCardNo = $(this).data('babyCardNo');
            childList.editChildExam(babyCardNo);
        });
        $('#newExamBtnSix').click(function () {
            var idCard = $(this).data('idCardNo');
            childList.editChildExamSix(idCard);
        });
        $('#examListTable').on('click', '.exam_edit', function() {
            var babyCardNo = $(this).data('babyCardNo');
            var examId = $(this).data('id');
            childList.editChildExam(babyCardNo, examId);
        });
        $('#examListTable').on('click', '.exam_editSix', function() {
            var idCard = $(this).data('idCardNo');
            var examId = $(this).data('id');
            childList.editChildExamSix(idCard, examId);
        });
        $('#examListTable').on('click', '.exam_view', function() {
            var examId = $(this).data('id');
            var url = '/childHealthExamine/viewExam';

            $.post(contextPath+url,{
                examId:examId
            }, function(ret){
                layui.use(['layer'], function() {
                    var layer = layui.layer
                    layer.open({
                        type: 1,
                        id:"childHealthExamineView",
                        area: ['900px', '600px'],
                        title:"儿童健康体检",
                        content: ret
                    });
                });
            });

        });
        $('#examListTable').on('click', '.exam_delete', function() {
            var examId = $(this).data('id');
            var babyCardNo = $(this).data('babyCardNo');
            var index = layer.confirm("是否删除该记录？", {icon:2, title:'确认提示'}, function() {
                $.getJsonByUrl({
                    url: '/childHealthExamine/deleteExam',
                    param: {
                        examId: examId
                    },
                    callback: function(result) {
                        if (result) {
                            layui.use('layer', function() {
                            	var layer = layui.layer;
                            	layer.alert("删除成功！", {icon:0,title:'提示'});
                            });
                            childList.viewChildExams(babyCardNo);
                        } else {
                            layui.use('layer', function() {
                            	var layer = layui.layer;
                            	layer.alert("删除失败！", {icon:0,title:'提示'});
                            });
                        }
                    }
                });
                layer.close(index);
            });
        })
        $('#examListTable').on('click', '.exam_deleteSix', function() {
            var examId = $(this).data('id');
            var idCard = $(this).data('idCardNo');
            var index = layer.confirm("是否删除该记录？", {icon:2, title:'确认提示'}, function() {
                $.getJsonByUrl({
                    url: '/childHealthExamine/deleteExam',
                    param: {
                        examId: examId
                    },
                    callback: function(result) {
                        if (result) {
                            layui.use('layer', function() {
                            	var layer = layui.layer;
                            	layer.alert("删除成功！", {icon:0,title:'提示'});
                            });
                            childList.viewChildExams(idCard);
                        } else {
                            layui.use('layer', function() {
                            	var layer = layui.layer;
                            	layer.alert("删除失败！", {icon:0,title:'提示'});
                            });
                        }
                    }
                });
                layer.close(index);
            });
        })
    });
})();