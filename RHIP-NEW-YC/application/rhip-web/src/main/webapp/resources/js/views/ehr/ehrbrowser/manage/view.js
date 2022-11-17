var manageIndex = (function(){
    $(function(){
        initTab();
    });

    function initTab(){
        var $bar=$("ul[name='tags']");
        $bar.find("a").on("click",function(event){
            var $this=$(this);
            var target=$this.data("target");
            $bar.find("li.selectTag").removeClass("selectTag");
            $this.parent().addClass("selectTag");
            $("#targetContent").children().each(function(ind) {
                if($("#"+target).index() != ind) {
                    $(this).hide();
                } else {
                    $(this).show();
                }
            });
        });
        $bar.find("a:first").click();
    }
})();