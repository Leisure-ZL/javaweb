<%@page import="cn.edu.swu.zl.goods.SellGoodsService"%>
<%@page import="cn.edu.swu.zl.goods.SellGoods"%>
<%@page import="java.util.*" %>
<%@page import="cn.edu.swu.zl.buyer.Buyer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="../frame/frame.css"> 
		<link rel="stylesheet" type="text/css" href="css/allGoods.css" />
	</head>
	<body>
		<div id="all-box">
			<div id="top_user">
				<div id="top_container">
					<ul id="top_ul_left">
						<li><em>喵~欢迎来到地猫</em></li>
						<% 
							Buyer buyer = (Buyer)session.getAttribute("buyer");
						%>
						
						<%	if(buyer != null){ %>
							<li><a><% out.print(buyer.getName() + " 您好！"); %></a></li>
						<% }else{ %>
							<a href="../login/login.html"><li>请登录</li></a>
							<a href="../login/signout.html"><li>免费注册</li></a>
						<%	} %>
					</ul>
					<ul class="top_ul">
						<a href="/javawork/buy/allGoods.jsp"><li>全部商品</li>
						<a href="/javawork/buy/cart.jsp"><li style="color=black">购物车</li></a>
						<li>收藏夹</li>
					</ul>
					<ul class="top_ul">
						<li>手机版</li>
						<li>淘宝网</li>
						<li>商家支持</li>
					</ul>
				</div>
			</div>
			<div id="header">
				<div id="logo">
					<a href="/javawork/index/index.jsp"><img src="../frame/img/logo.gif" /></a>
				</div>
				<div id="search_box">
					<form action="/javawork/SearchServlet" method="get">
						<input type="text" placeholder="搜索 地猫 商品/品牌/店铺" name="search" id="search"/>
						<button type="submit" id="search_btn">搜索</button>
					</form>
					
				</div>
			</div>
			<div id="content">
				<div id="item-title">
					<div id="title-img">图片</div>
					<div id="title-name">名称</div>
					<div id="title-count">数量</div>
					<div id="title-price">价格</div>
				</div>
				<% 
					String sql = "select * from sellgoods;";
					List<SellGoods> SGoods = SellGoodsService.getAll(sql);
					int i=0;
				%>
				<% for(SellGoods e:SGoods){ %>
				<a href=<% out.print("/javawork/buy/buy.jsp?index="+i); %>><div class="item">
					<div class="item-img"><img src=<% out.print("'../img/goods/" +e.getImg().toString() + "'"); %>></div>
					<div class="item-name"><% out.print(e.getName()); %></div>
					<div class="item-count"><% out.print(e.getCount()); %></div>
					<div class="item-price"><% out.print(e.getPrice()); %></div>
				</div></a>
				<%
					i++;
				} %>
			</div>
			<div class="footer">
				<div class="tmall_sure">
					<div class="tmall_sure_abox">
						<a></a>
						<a></a>
						<a></a>
						<a></a>
					</div>
				</div>
				<div class="tmall_desc">
					<table>
						<tr>
							<th>购物指南</th>
							<td>免费注册</td>
							<td>开通支付宝</td>
							<td>支付宝充值</td>
						</tr>
						<tr>
							<th>地猫保障</th>
							<td>发票保障</td>
							<td>售后规则</td>
							<td>缺货赔付</td>
						</tr>
						<tr>
							<th>支付方式</th>
							<td>快捷支付</td>
							<td>信用卡</td>
							<td>余额宝</td>
							<td>蚂蚁花呗</td>
							<td>货到付款</td>
						</tr>
						<tr>
							<th>商家服务</th>
							<td>地猫规则</td>
							<td>商家入驻</td>
							<td>商家中心</td>
							<td>地猫智库</td>
							<td>物流服务</td>
							<td>喵言喵语</td>
							<td>运营服务</td>
						</tr>
						<tr>
							<th>手机地猫</th>
							<td><img src="../frame/img/code.png"></td>
						</tr>
					</table>
				</div>
				<div class="copyright"></div>
			</div>
		</div>
	</body>
</html>
