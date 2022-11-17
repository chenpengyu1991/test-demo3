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
	var tag = document.getElementById("tags").getElementsByTagName("li");
	var taglength = tag.length;
	for(var i=0; i<taglength; i++){
		tag[i].className = "";
	}
	selfObj.parentNode.className = "selectTag";
	
	for(var i=0; j=document.getElementById("tagContent"+i); i++){
		j.style.display = "none";
	}
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