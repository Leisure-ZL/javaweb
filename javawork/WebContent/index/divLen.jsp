<%@page import="cn.edu.swu.zl.goods.SellGoods"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	*{
		margin:0;
		padding:0;
	}
	#search-ul{
		list-style:none;
		width:100%;
		border:2px solid black;
		background-color:#FFFFFF;
	}
	.search-item{
		width:100%;
		height:20px;
		line-height:20px;
		margin:5px 0 0 2px;
	}
	.search-item:hover{
		background-color:#ddd;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>联想搜索功能</title>
</head>
<script src="../frame/jquery-3.2.1.min.js"></script>
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