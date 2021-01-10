<%@page import="cn.edu.swu.products.ProductsService"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="cn.edu.swu.products.Products" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>seller</title>
<link rel="stylesheet" type="text/css" href="./frame.css">
<link rel="stylesheet" type="text/css" href="./seller.css"> 
</head>
<body>
	<div id="all-box">
			<div id="top_user">
				<div id="top_container">
					<ul id="top_ul_left">
						<li><em>喵~欢迎来到天猫</em></li>
						<li><a>请登录</a></li>
						<li><a>免费注册</a></li>
					</ul>
					<ul class="top_ul">
						<li>我的淘宝</li>
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
					<img src="img/logo.gif" />
				</div>
				<div id="topbanner">
					<div id="title">卖家中心</div>
				</div>
			</div>
			<div id="content1">
				<div class="wrap-line"></div>
					<div id="item-title">
						<div id="title-img">图片</div>
						<div id="title-name">名称</div>
						<div id="title-count">数量</div>
						<div id="title-price">价格</div>
						<div>操作</div>
					</div>
					<% 
					List<Products> products = ProductsService.getAll();
				%>
				<% for(Products e:products){ 
				
				%>
				<div class="item">
					<div class="item-img"><img src=<% out.print("'" +e.getImgUrl().toString() + "'"); %>></div>
					<div class="item-name"><%out.print(e.getProductname()); %></div>
					<div class="item-count"><%out.print(e.getNumber());%></div>
					<div class="item-price"><%out.print(e.getPrice());%></div>
					<div><a href="/seller/RemoveProductServlet?name=<%out.print(e.getProductname());%>&id=<%out.print(e.getId());%>">删除</a></div>
				</div>
				<% } %>
				<div class="button"><a href="/seller/products.html">添加新品</a></div>
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
</body>
</html>