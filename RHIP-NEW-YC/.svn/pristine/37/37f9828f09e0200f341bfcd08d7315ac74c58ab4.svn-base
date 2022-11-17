$(document).ready(function() {
    //-------------the pucker of section ----------------
	$(".section .pucker").toggle(function(){				
		$(this).addClass("opucker").removeClass("pucker");	
		$(this).parent().next().hide();
	},function(){
		$(this).addClass("pucker").removeClass("opucker");
		$(this).parent().next().show();
	});
	
	//----------set style for select control -----------
	$(".formtable select").parent().addClass("select_td");
	
	//---------- set style for repeat table -------------	
	$('table.repeattable tbody tr:odd').addClass("l-odd");
	$('table.repeattable tbody tr:even').addClass("l-even"); 
    $("table.repeattable tr").hover(function(){					 
	    $(this).addClass("l-hover");							  
 }, function(){
	    $(this).removeClass("l-hover");	
  });
})

function selectTag(showContent,selfObj){
	$('#tags').find('li').each(function(){
		$(this).removeClass('selectTag');
	});

	selfObj.parentNode.className = "selectTag";
	$('#tagContent').find("[id^='tagContent']").each(function(){
		$(this).hide();
	});

	document.getElementById(showContent).style.display = "block";
}

function selectTagl(showContent,selfObj){
    $('#tagsl').find('li').each(function(){
        $(this).removeClass('selectTag');
    });

    selfObj.parentNode.className = "selectTag";
    $('#tagContent').find("[id^='tagContent']").each(function(){
        $(this).hide();
    });

    document.getElementById(showContent).style.display = "block";
}

function setTab(name,cursel,n){
    try {
        for(var i=1;i<=n;i++){
            var menu=document.getElementById(name+i);
            var con=document.getElementById("con_"+name+"_"+i);
            menu.className=i==cursel?"hover":"";
            con.style.display=i==cursel?"block":"none";
        }
    } catch(e){
}

}