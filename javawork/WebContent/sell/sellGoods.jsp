<%@page import="cn.edu.swu.zl.buyer.BuyerService"%>
<%@page import="cn.edu.swu.zl.seller.SellerService"%>
<%@page import="cn.edu.swu.zl.seller.Seller"%>
<%@page import="cn.edu.swu.zl.goods.SellGoodsService"%>
<%@page import="cn.edu.swu.zl.goods.SellGoods"%>
<%@page import="cn.edu.swu.zl.goods.BuyGoodsService"%>
<%@page import="cn.edu.swu.zl.goods.BuyGoods"%>
<%@page import="java.util.*" %>
<%@page import="cn.edu.swu.zl.buyer.Buyer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>出售商品清单</title>
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
							Seller seller = (Seller)session.getAttribute("seller");	
						%>
						
						<%	if(seller != null){ %>
							<li><a><% out.print(seller.getName() + " 您好！"); %></a></li>
							<li><a href="/javawork/QuitServlet">登出</a></li>
						<% }else{ 
							response.sendRedirect("/javawork/login/login.html");
						}
						%>
					</ul>
					<ul class="top_ul">
						<a href="/javawork/sell/sellerweb.jsp"><li>卖家中心</li></a>
						<li>出售商品清单</li>
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
					<a><img src="../frame/img/logo.gif" /></a>
				</div>
				<div id="search_box">
					<form >
						<input type="text" placeholder="搜索 地猫 商品/品牌/店铺" name="search" id="search"/>
						<button type="submit" id="search_btn">搜索</button>
					</form>
					
				</div>
			</div>
			<div id="content">
				<div id="item-title">
					<div id="title-img">图片</div>
					<div id="title-name">名称</div>
					<div id="title-count">买家</div>
					<div id="title-price">物流信息</div>
				</div>
				<% 
					String sql = "select * from allgoods where sellerId="+seller.getId()+";";;
					List<BuyGoods> bGoods = BuyGoodsService.getAll(sql);
					int i=0;
					
				%>
				<% for(BuyGoods e:bGoods){ %>
				<div class="item">
					<div class="item-img"><img src=<% out.print("'../img/goods/" +e.getImg().toString() + "'"); %>></div>
					<div class="item-name"><% out.print(e.getName()); %></div>
					<div class="item-count"><%
					String sql2 = "select * from buyer where id=" + e.getbuyerId()+";";
					Buyer buyer = BuyerService.get(sql2);
					out.print(buyer.getName()); 
					%></div>
					<div class="item-price" style="color:black;font-size:12px;">发货</div>
				</div>
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
