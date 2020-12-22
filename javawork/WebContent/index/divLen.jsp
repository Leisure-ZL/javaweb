<%@page import="cn.edu.swu.zl.goods.SellGoods"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联想搜索功能</title>
</head>
<script src="../frame/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#search-ul").css({
			"padding":"0px",
			"margin":"0px",
			"list-style":"none",
			"width":"100%"
		});
	
		$(".search-item").css({
			"padding":"0px",
			"margin":"0px",
			"width":"100%",
			"height":"20px"
			"line-height":"20px"
			
		});
		$(".search-item").hover(
			function(){
				$(this).css({"background-color":"#ddd"});
			},
			function(){
				$(this).css({"background-color":"#fff"});
			}
		);
			
			
		
	});	
</script>
<body>
	<ul id="search-ul">
		<% 
		List<SellGoods> goods = (List<SellGoods>)request.getAttribute("goodsNames");
		for(SellGoods e:goods){ %>
			<li class="search-item"><% out.print(e.getName()); %></li>
			<%	} %>
	</ul>
</body>
</html>