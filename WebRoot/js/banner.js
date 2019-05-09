// JavaScript Document
$(function(){
	//变量初始化
	var cur_i=0;
	var num=$(".bannerlist li").length-1;
	var time;
	init();
	//事件处理区
	start();
	$(".bannernav li").mouseover(function(){
		cur_i=$(this).index();
		move(cur_i);
		});
	$("#leftarrow").click(function(){prev();});
	$("#rightarrow").click(function(){next();});
	$("#banner").hover(function(){clearInterval(time);},function(){start();});
	//函数定义区
	function init(){
		$('<ul class="bannernav"></ul>').appendTo($("#banner-content"));
		for(var i=0;i<=num;i++){
			$("<li></li>").appendTo($(".bannernav"));
		}
		$(".bannernav li:first").addClass("cur");
		$(".bannerlist li:first").addClass("cur");
	};
	function start(){
		time=setInterval(function(){
		next();
		},3000);
	};
	function prev(){
		cur_i--;
		if(cur_i<0){
			cur_i=num;
		}
		move(cur_i);
	};
	function next(){
		cur_i++;
		if(cur_i>num){cur_i=0;}
		move(cur_i);
	};
});
function move(i){
		$(".bannerlist .cur").fadeOut(1000).removeClass("cur");
		$(".bannerlist li").eq(i).fadeIn(1000).addClass("cur");
		$(".bannernav .cur").removeClass("cur");
		$(".bannernav li").eq(i).addClass("cur");
}