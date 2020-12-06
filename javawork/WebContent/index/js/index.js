window.onload = function () {
	var oMeau = document.getElementsByClassName("menu_nav");
	var aItem = oMeau[0].getElementsByTagName("li");
	
	
	//mark
	
	var aTwoGird = document.getElementsByClassName("mark_twogrid");
	var aMarkLi = aTwoGird[0].getElementsByTagName("li");
	var aTwogirdCon = aTwoGird[0].getElementsByClassName("twogird_con");
	
	//mark_auto
	var timer = null;
	var count = 0;
	function mark_auto(){
		if(count % 2 == 0){
			aMarkLi[0].style.backgroundColor = "#00b262";	
			aTwogirdCon[0].style.display = "block";
			aMarkLi[1].style.backgroundColor = "#F1F1F1";	
			aTwogirdCon[1].style.display = "none";
		}else{
			aMarkLi[1].style.backgroundColor = "#00b262";	
			aTwogirdCon[1].style.display = "block";
			aMarkLi[0].style.backgroundColor = "#F1F1F1";	
			aTwogirdCon[0].style.display = "none";
		}
		count++;

	}
	timer = setInterval(mark_auto,3000);
	
	for(var i = 0;i < 2;i++){
		aMarkLi[i].index = i;

		aMarkLi[i].onmouseover = function () {
			clearInterval(timer);
			
			this.style.backgroundColor = "#00b262";	
			aTwogirdCon[this.index].style.display = "block";
			if(this.index == 1){
				aTwogirdCon[this.index-1].style.display = "none";
				aMarkLi[this.index-1].style.backgroundColor = "#F1F1F1";
			}else{
				aTwogirdCon[this.index+1].style.display = "none";
				aMarkLi[this.index+1].style.backgroundColor = "#F1F1F1";
			}
		}
		aMarkLi[i].onmouseout = function () {
			timer = setInterval(mark_auto,3000);
		}
	}
	
	//吸顶导航
		
	var oTop = document.getElementById("topshow");
	var topTimer = null;
	var isMoving = false;
	
	var oLeft = document.getElementById("navshow");
		
	window.onscroll = function(){
		var srollTop = document.documentElement.scrollTop || document.body.scrollTop;
//		console.log(srollTop);
		
		if(srollTop > 120){
			//显示
			if(isMoving){
				return 0;
			}
			
			isMoving = true;
		
			topTimer =setInterval(function(){
			
				if(oTop.offsetTop == 0){
					clearInterval(topTimer);
					isMoving = false;
				}else{		
					oTop.style.top = oTop.offsetTop + 5 + "px";
				}
			},30);
		}else{
			//隐藏
			if(isMoving){
				return 0;
			}
			
			isMoving = true;
		
			topTimer =setInterval(function(){
			
				if(oTop.offsetTop == -60){
					clearInterval(topTimer);
					isMoving = false;
				}else{		
					oTop.style.top = oTop.offsetTop - 5 + "px";
				}
			},30);
		}
		
		
	}
	
	
	
//结束	
}
