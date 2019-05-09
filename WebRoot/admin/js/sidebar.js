// JavaScript Document
function explodeItems(titleId,ItemsId)
{
	if(document.getElementById(ItemsId).style.display=="none"){
		document.getElementById(ItemsId).style.display="block";
		document.getElementById(titleId).style.backgroundImage="url(images/expand.gif)";
	}
	else{
		document.getElementById(ItemsId).style.display="none";
		document.getElementById(titleId).style.backgroundImage="url(images/collapse.gif)";
	}
}