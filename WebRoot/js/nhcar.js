// JavaScript Document
$(function(){
	iniSearch();
	initSubCategory();
	initNav();
	showCateMore();
	showProduct();
	returnTop();
});
/*
处理搜索框提示功能
*/
function iniSearch(){
	$("#search .skey").keyup(function(){
		var skeyvalue=$(this).val();
			if(skeyvalue==""){
				$("#search label").show();
			}
			else{
				$("#search label").hide();
			}
		});
}
function initSubCategory(){
	$("#nav .catelist").hover(function(){
		$("ul",this).stop(true,true).slideDown(500);
		},function(){
			$("ul",this).stop(true,true).slideUp(500);
			});
}
function initNav(){
	var noop = function(){};
	$('<li class="back"></li>').prependTo($("#navlist"));
	if($("#navlist .current").length==0){
		$("#navlist li").eq(1).addClass("current");
	}
	var current=$(".current").get(0);
	$(".back").css({"left":current.offsetLeft+"px"});
	$("#navlist li").not(".back").hover(function(){
		$(".back").stop(true,false).animate({left: this.offsetLeft},500);
		},noop);
		$("#navlist").hover(noop,function(){

			$(".back").stop(true,false).animate({left: current.offsetLeft},500);
			});
}
function showCateMore(){
	$("#subcategory .more").toggle(function(){
		$("#subcategory ul").css("height","100%");
		var h=$("#subcategory ul").height();
		$("#subcategory ul").css("height","50px");
		$("#subcategory ul").animate({height:h+"px"},300);
		$(this).addClass("down");
		return false;
		},function(){
			$("#subcategory ul").animate({height:"50px"},300);
			$(this).removeClass("down");
			});
	
}
function showProduct(){
	$(".homeplist li h3").css("opacity","0.7");
	$(".homeplist li").hover(function(){
		$("img",this).stop(true,true).animate({width:"250px",height:"250px"},300);
		$("h3",this).stop(true,true).animate({opacity:"0",bottom:"60px"},300);
		$("p",this).stop(true,true).animate({bottom:"0"},300);
		},function(){
			$("img",this).stop(true,true).animate({width:"220px",height:"220px"},300);
			$("h3",this).stop(true,true).animate({opacity:"0.7",bottom:"30px"},300);
			$("p",this).stop(true,true).animate({bottom:"-27px"},300);
			});
}
function returnTop(){
	$(window).scroll(function(){
			if($(window).scrollTop()>100){
			$(".top").fadeIn("200");
			}
			else{
				$(".top").fadeOut("200");
			}
		});

	$(".top a").click(function(){
		$('html, body').animate({scrollTop:0}, 'slow');
		});
}