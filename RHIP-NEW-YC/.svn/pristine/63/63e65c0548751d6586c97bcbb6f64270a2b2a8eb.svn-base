var mrhFeeSearch = (function() {
    var validate=null;
    $(function() {
        validate = $("#targetSearchForm").easyValidate();
        $("#targetBtnSearch").click(function(e) {
            e.preventDefault();
            search(1);
        });
        $("#targetBtnSearch").onEnter(search, 1);
        initForm();
    });

    function initForm(){
        $('#centre1').on("change",function(){
            $('#superOrganCode').val(this.value);
        });
        $('#town1').on("change",function(){
            $('#gbCode').val(this.value);
        });
        $('#centre2').on("change",function(){
            $('#superOrganCode').val(this.value);
        });
        $('#town2').on("change",function(){
            $('#gbCode').val(this.value);
        });
        $('#station2').on("change",function(){
            $('#organCode').val(this.value);
        });
        $('#genreCode').on("change",function(){
            changeOrgType();
        });
        $('#rangeType').on("change",function(){
            changeRangeType();
        });
        changeOrgType();
        changeRangeType();
    }

    function changeRangeType(){
        var yearType = $('input[name="yearType"]:checked').val();
        if($.isEmpty(yearType)){
            $('input[name="yearType"]:eq(0)').attr("checked",'checked');
        }
        var rangeType = $('#rangeType').val();
        if(rangeType == '1'){//按月
            $('#byMonth').show();
            $('#byQuarter').hide();
            $('#byYear').hide();
            $('#byRange').hide();
        }else if(rangeType == '2'){//按季度
            $('#byMonth').hide();
            $('#byQuarter').show();
            $('#byYear').hide();
            $('#byRange').hide();
        }else if(rangeType == '3'){//按年
            $('#byMonth').hide();
            $('#byQuarter').hide();
            $('#byYear').show();
            $('#byRange').hide();
        }
        changeRequired(rangeType);
    }
    function changeRequired(type){
        if(type == '1'){//按月
            validate.removeCheckElement('yearDate');
            validate.removeCheckElement('quarterDate');
            validate.addCheckElement('monthDate',{"required":"true"});
        }else if(type == '2'){//按季度
            validate.removeCheckElement('yearDate');
            validate.removeCheckElement('monthDate');
            validate.addCheckElement('quarterDate',{"required":"true"});
        }else if(type == '3'){//按年
            validate.removeCheckElement('monthDate');
            validate.removeCheckElement('quarterDate');
            validate.addCheckElement('yearDate',{"required":"true"});
        }
    }
    function changeOrgType(){
        var genreCode = $('#genreCode').val();
        if(genreCode == 'A100'){
            $('#byHospital').show();
            $('#byCentre').hide();
            $('#byStation').hide();
            $('#byTown').hide();
            $('#orgTitle').show();
            getCurrentOrgCode(0);
        }else if(genreCode == 'B100'){
            $('#byHospital').hide();
            $('#byCentre').show();
            $('#byStation').hide();
            $('#byTown').hide();
            getCurrentOrgCode(1);
            $('#orgTitle').show();
        }else if(genreCode == 'B200'){
            $('#byHospital').hide();
            $('#byCentre').hide();
            $('#byStation').show();
            $('#byTown').hide();
            $('#orgTitle').show();
            getCurrentOrgCode(2);
        }else if(genreCode == '0'){
            $('#byHospital').hide();
            $('#byCentre').hide();
            $('#byStation').hide();
            $('#byTown').show();
            $('#orgTitle').show();
            getCurrentOrgCode(3);
        }else if(genreCode == 'G2'){
            $('#byHospital').hide();
            $('#byCentre').hide();
            $('#byStation').hide();
            $('#byTown').hide();
            $('#orgTitle').hide();
            getCurrentOrgCode('G2');
        }
    }

    function getCurrentOrgCode(index){
        $('#gbCode').val($('#town' + index).val());
        if('G2' == index){
            $('#orgG2').val("320003261"); //常熟市妇幼保健所
        }
        if(index==0){
            $('#superOrganCode').val($('#organCode' + index).val());
        }else if(index != 3){
            $('#superOrganCode').val($('#centre' + index).val());
            $('#organCode').val($('#station' + index).val());
        }else{
            $('#superOrganCode').val("");
            $('#organCode').val("");
        }
    }
    function search(pageIndex) {
        var result=validate.validateForm();
        if(!result){
            return;
        }
        changeOrgType();
        changeRangeType();
        pageIndex = ($.isEmpty(pageIndex)?1:pageIndex);
        var searchObj = {
            url : $('#searchUrl').val(),
            insertDiv : "resultDiv",
            param : {
                indexPage : pageIndex
            },
            callback : function(data) {
                $("#pageIndex").val(pageIndex);
            }
        };
        $("#targetSearchForm").submitFormLoadHtml(searchObj);
    };


    return {
        changeOrgType:changeOrgType,
        search:search
    };
})();



