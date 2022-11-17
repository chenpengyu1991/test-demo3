/**
 * Created by jingqiu on 17-4-17.
 */
var editFirstQuestion = (function() {
    var validate;
    $(function () {
        validate = $('#questionForm').easyValidate();
        $('#backToSearchBtn').click(function () {
            question135.back();
        });
        $('#saveQuestionBtn').click(function(e) {
        	e.preventDefault();
            save();
        });
        $(':radio[name="a2"]').change(function() {
            chooseOthers('a2', 'a2A', '8');
        });
        $(':radio[name="b21A"]').change(function() {
            chooseOthers('b21A', 'b21A1', '8');
        });
        $(':radio[name="c29"]').change(function() {
            chooseOthers('c29', 'c29A', '1');
        });
        initSkipQuestion('b1', 'b1skip', '0');
        initSkipQuestion('b8', 'b8skip', '3');
        initSkipQuestion('b21', 'b21skip', '0');
        initSkipQuestion('c13A', 'c13skip', '0');
        initSkipQuestion('c16', 'c16skip', '0,9');
        initSkipQuestion('c18', 'c18skip', '0,9');
        initSkipQuestion('c25', 'c25skip', '0,9');
        initSkipQuestion('c30', 'c30skip', '0');
    });

    function save() {
        if (validate.validateForm()) {
            $('#questionForm').submitFormGetJson({
                url: '/cdm/highRisk135/question/saveFirst',
                wait: true,
                callback: function(data) {
                	layui.use('layer', function(){
	    				var layer = layui.layer;
	    				if (data.success) {
	    					layer.alert("保存成功！", {icon:0,title:'提示'});
	    					question135.back();
	    					question135.search(1);
	    				} else {
	    					layer.alert(data.message, {icon:0,title:'提示'});
	    				}
	    				
	    			});
                }
            });
        }
    }

    function chooseOthers(radioName, otherId, conditionValue) {
        var $other = $('#'+otherId);
        if ($(':checked[name="' + radioName + '"]').val() == conditionValue) {
            $other.show();
        } else {
            $other.val(null);
            $other.find('input').val(null);
            $other.hide();
        }
    }

    function skipQuestions(radioName, skipClass, conditionValue) {
        var $skipPart = $('.'+skipClass);
        var value = $(':checked[name="' + radioName + '"]').val();
        if ($.inArray(value, conditionValue.split(',')) > -1) {
            $skipPart.val(null);
            $skipPart.find('input[type="text"]').val(null);
            $skipPart.find(':selected').each(function() {
                $(this).removeAttr('selected');
            });
            $skipPart.find(':checked').each(function () {
                $(this).removeAttr('checked');
            });
            $skipPart.hide();
        } else {
            $skipPart.show();
        }
    }

    function initSkipQuestion(radioName, skipClass, conditionValue) {
        var value = $(':checked[name="' + radioName + '"]').val();
        if ($.inArray(value, conditionValue.split(',')) > -1) {
            $('.'+skipClass).hide();
        }
        $(':radio[name="'+radioName+'"]').change(function() {
            skipQuestions(radioName, skipClass, conditionValue);
        });
    }
})();