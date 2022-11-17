/**
 * Created by jingqiu on 17-4-17.
 */
var question135 = (function() {
    $(function () {
        search(1);
        $('#questionSearchBtn').click(function() {
            search(1);
        });
        $('#addFirstQuestion').click(function() {
            editQuestion(null, 1);
        });
        $('#addLastQuestion').click(function() {
            editQuestion(null, 2);
        });
        $("#questionSearchSpanId").click(function(){
            toggle(this,'questionSearchTableId');
        });
        $("#questionSearchForm").onEnter(search, 1);
        $("#check-submit-btn").on("click", function () {
            StartRead();
        });

    });
    function StartRead()//开始读卡
    {
        if (GT2ICROCX.GetState() == 0){
            GT2ICROCX.ReadCard()
        }

        //GT2ICROCX.ReadCard() //循环读卡
        $("#text_idcard").val(GT2ICROCX.CardNo);
        $("#idCard").val(GT2ICROCX.CardNo);
    }

    function back() {
        $('#questionEdit').empty();
        $('#questionEdit').hide();
        $('#questionSearch').show();
        $('#list_view').show();
        $('#factorsInfo_view').hide();
    }

    function search(index) {
        $('#questionSearchForm').submitFormLoadHtml({
            url: '/cdm/highRisk135/question/list',
            insertDiv: 'questionList',
            param: {
                indexPage: index
            }
        })
    }

    function editLastQuestion(idNo, meNumber) {
        $.loadHtmlByUrl({
            url: '/cdm/highRisk135/otherQuestions/list',
            insertDiv: 'questionEdit',
            param: {
                meNumber: meNumber
                /*id: id,
                type: type*/
            },
            wait: true,
            callback: function() {
                $('#questionSearch').hide();
                $('#questionEdit').show();
            }
        });
    }
    function editQuestion(idNo, meNumber) {
        $.loadHtmlByUrl({
            url: '/cdm/highRisk135/question/edit',
            insertDiv: 'questionEdit',
            param: {
                idNo: idNo,
                meNumber: meNumber
            },
            wait: true,
            callback: function() {
                $('#questionSearch').hide();
                $('#questionEdit').show();
            }
        });

    }

    function deleteQuestion(id, type) {
    	layui.use('layer', function() {
			var layer = layui.layer;
			layer.confirm('是否删除该记录？', {icon:2, title:'确认提示'}, function(index) {
				 $.getJsonByUrl({
		                url: '/cdm/highRisk135/question/delete',
		                param: {
		                    id: id,
		                    type: type
		                },
		                callback: function(data) {
		                    if (data.success) {
		                    	var index = layer.alert("删除成功！", {icon:0,title:'提示'}, function() {
		                    		layer.close(index);
		                    		back();
		                    		search(1);
		                    	});
		                    } else {
		                    	layer.alert("删除失败！", {icon:0,title:'提示'});
		                    }
		                }
		          })
			});
		});
        /*layer.confirm("是否删除该记录？", function(index) {
            $.getJsonByUrl({
                url: '/cdm/highRisk135/question/delete',
                param: {
                    id: id,
                    type: type
                },
                callback: function(data) {
                    if (data.success) {
                        msgUtil.alert("删除成功");
                        back();
                        search(1);
                    } else {
                        msgUtil.alert("删除失败");
                    }
                }
            })
            layer.close(index);
        })*/
    }


    return {
        search: search,
        back: back,
        editQuestion: editQuestion,
        editLastQuestion: editLastQuestion,
        deleteQuestion: deleteQuestion
    }
})();