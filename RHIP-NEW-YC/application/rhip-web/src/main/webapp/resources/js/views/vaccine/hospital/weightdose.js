function OnKey() 
{          	
	document.getElementById("vacDose").value = (Math.round(document.getElementById("pW").value/10)*10)*20;
	if(document.getElementById("vacDose").value!="")
	document.getElementById("btlCnt").innerText=document.getElementById("vacDose").value/200;
}    		 	