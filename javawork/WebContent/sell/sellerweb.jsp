<%@page import="cn.edu.swu.zl.seller.Seller"%>
<%@page import="cn.edu.swu.zl.buyer.Buyer"%>
<%@page import="cn.edu.swu.zl.goods.SellGoodsService"%>
<%@page import="cn.edu.swu.zl.goods.SellGoods"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>seller</title>
<link rel="stylesheet" type="text/css" href="../frame/frame.css" />
<link rel="stylesheet" type="text/css" href="./css/sellerweb.css">
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
						<% }else{ 
							response.sendRedirect("/javawork/login/login.html");
						}
						%>

					</ul>
					<ul class="top_ul">
						<li>全部商品</li>
						<li>购物车</li>
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
					<img src="../frame/img/logo.gif" />
				</div>
				<div id="search_box">
					<form>
						<input type="text" placeholder="搜索 地猫 商品/品牌/店铺" name="search" id="search"/>
						<button type="submit" id="search_btn">搜索</button>
					</form>
					<div id="len_box"></div>
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
					
					String sql = "select * from sellgoods where sellerId=" + seller.getId();
					List<SellGoods> sellGoods = SellGoodsService.getAll(sql);
				%>
				<% 
					for(SellGoods e:sellGoods){ 
				%>
				<div class="item">
					<div class="item-img"><img src=<% out.print("'../img/goods/" +e.getImg().toString() + "'"); %>></div>
					<div class="item-name"><%out.print(e.getName()); %></div>
					<div class="item-count"><%out.print(e.getCount());%></div>
					<div class="item-price"><%out.print(e.getPrice());%></div>
				</div>
				<% } %>
				</div>
				<div>
					<a id="deploy" href="./upload.html">发布新商品</a>
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
							<th>天猫保障</th>
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
							<td>天猫规则</td>
							<td>商家入驻</td>
							<td>商家中心</td>
							<td>天猫智库</td>
							<td>物流服务</td>
							<td>喵言喵语</td>
							<td>运营服务</td>
						</tr>
						<tr>
							<th>手机天猫</th>
							<td><img src="img/TB14MWoNhjaK1RjSZFAwu2dLFXa.png"></td>
						</tr>
					</table>
				</div>
				<div class="copyright"></div>
			</div>
		</div>
</body>
</html>