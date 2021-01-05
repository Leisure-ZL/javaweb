<%@page import="cn.edu.swu.zl.goods.BuyGoodsService"%>
<%@page import="cn.edu.swu.zl.goods.BuyGoods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.edu.swu.zl.goods.SellGoodsService"%>
<%@page import="cn.edu.swu.zl.goods.SellGoods"%>
<%@page import="java.util.*"%>
<%@page import="cn.edu.swu.zl.buyer.Buyer"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>cart</title>
		<link rel="stylesheet" type="text/css" href="../frame/frame.css"> 
		<link rel="stylesheet" type="text/css" href="css/cart.css"> 
	</head>
	<body>
		<div id="all-box">
			<div id="top_user">
				<div id="top_container">
					<ul id="top_ul_left">
						<li><em>喵~欢迎来到地猫</em></li>
						<% 
							//String userName = (String)session.getAttribute("userName");
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
						<a href="/javawork/buy/allGoods.jsp"><li>全部商品</li></a>
						<li>购物车</li>
						<a href="/javawork/buy/buyGoods.jsp"><li>购买商品清单</li></a>
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
			
				<div id="cart-title">
					<div id="cart-title-content">
						<div class="cart-title-item">图片</div>
						<div class="cart-title-item">介绍</div>
						<div class="cart-title-item" style="margin-left: 230px;">价格</div>
						<div class="cart-title-item">操作</div>
					</div>
				</div>
				<div id="cart-good-content">
				<% 
					Buyer b = (Buyer)session.getAttribute("buyer");
					String sql="select * from buygoods where buyerId=" + b.getId()+";";
					List<BuyGoods> bGoods = BuyGoodsService.getAll(sql);
				%>
				<%
					float sum = 0;
					for(BuyGoods bGood:bGoods){
						sum += bGood.getPrice();
				%>
					<div class="cart-good-item">
						<div class="cart-item-img"><img src=<% out.print("'../img/goods/" +bGood.getImg().toString() + "'"); %>></div>
						<div class="cart-item-name"><% out.print(bGood.getName()); %></div>
						<div class="cart-item-price"><% out.print(bGood.getPrice()); %></div>
						<a href="/javawork/RemoveServlet?name=<%out.print(bGood.getName());%>"><div class="cart-item-remove">移出购物车</div></a>
					</div>
				<%
					}
				%>
					<div id="settle">
					<% if(sum != 0){ %>
						<a href="/javawork/SettleServlet"><div id="settle-submit">结算</div></a><!-- 传用户id参数 -->
					<% }else{ %>
						<div id="settle-submit" style="background-color:#F1F1F1">结算</div>
					<% } %>
						<div id="settle-price"><% out.print(sum); %></div>
					</div>
				</div>
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
	<script type="text/javascript">
		
	</script>
</html>
