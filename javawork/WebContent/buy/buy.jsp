<%@page import="java.util.*" %>
<%@page import="cn.edu.swu.zl.goods.SellGoodsService"%>
<%@page import="cn.edu.swu.zl.goods.SellGoods"%>
<%@page import="cn.edu.swu.zl.goods.BuyGoodsService"%>
<%@page import="cn.edu.swu.zl.goods.BuyGoods"%>
<%@page import="cn.edu.swu.zl.goods.AllService"%>
<%@page import="cn.edu.swu.zl.buyer.Buyer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buy.jsp</title>
<link rel="stylesheet" type="text/css" href="../frame/frame.css"> 
<link rel="stylesheet" type="text/css" href="css/buy.css"> 
</head>
<body>
	<div id="all-box">
			<div id="top_user">
				<div id="top_container">
					<ul id="top_ul_left">
						<li><em>喵~欢迎来到地猫</em></li>
						<% 
							Buyer buyer = (Buyer)session.getAttribute("buyer");
							if(buyer == null){
								response.sendRedirect("/javawork/login/login.html");
							}else{
						%>
							<li><a><% out.print(buyer.getName() + " 您好！"); %></a></li>
							<% } %>
					</ul>
					<ul class="top_ul">
						<a href="/javawork/buy/allGoods.jsp"><li>全部商品</li>
						<a href="/javawork/buy/cart.jsp"><li style="color=black">购物车</li></a>
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
			<%
				SellGoods sGood = null;
				if(session.getAttribute("searchSGood") != null){//如果是从SearchServlet来访问的，取session中对象从新赋给sGood
					sGood = (SellGoods)session.getAttribute("searchSGood");
					if(sGood.getName() == null){
						response.sendRedirect("/javawork/buy/search-notfound.html");
					}
					
				}else{//否则通过index传递参数访问，从数据库中取并加入session
					String sql = "select * from sellgoods;";
					List<SellGoods> sGoods = SellGoodsService.getAll(sql);
					String indexStr = request.getParameter("index");
					int index = 0;//默认值
					if(indexStr != null){
						index = Integer.parseInt(indexStr);
					}
					if(index < 0){			//判断是否是index为负数的三个商品(数据库中id=1,2,3)
						sGood = sGoods.get(sGoods.size() - Math.abs(index));
					}else{
						sGood = sGoods.get(index);
					}
					session.removeAttribute("searchSGood");
					session.setAttribute("searchSGood", sGood);
				}
				
				//判断是否已经在购物车中
				int flag = 0;
				if(buyer != null){
				BuyGoods bGood = AllService.sGoodTobGood(sGood, buyer.getId());
				String sql="select * from buygoods where buyerId=" + buyer.getId()+";";
				List<BuyGoods> bGoods = BuyGoodsService.getAll(sql);
				for(BuyGoods e:bGoods) {
					if(e.getName().equals(bGood.getName())){
						flag = 1;
						break;
					}
				}
				}
				
			%>
				<div id="goods-box">
					<div id="goods-left" >
						<img src=<% out.print("'../img/goods/" +sGood.getImg().toString() + "'"); %> style="height:400px;">
					</div>
					<div id="goods-right">
						<div id="goods-name"><h1><% out.print(sGood.getName()); %></h1></div>
						<div id="goods-price">
							<div id="price-left">价格：</div>
							<div id="price-right">¥<% out.print(sGood.getPrice()); %></div></div>
						<div id="goods-dscp"><% out.print(sGood.getDscp()); %></div>
						<div id="goods-count">
							<div id="count-left">库存:</div>
							<div id="count-right"><% out.print(sGood.getCount()); %></div>
						</div>
						<% if(flag != 1){ %>
						<a href="/javawork/CartServlet" id="goods-btn-a"><div id="goods-btn">加入购物车</div></a>
						<% }else{ %>
						<div id="goods-btn" style="background-color:#F1F1F1">已加入购物车</div>
						<% } %>
					</div>
				</div>
				<%
				if(session.getAttribute("searchSGood") != null){
					session.removeAttribute("searchSGood");
					session.setAttribute("buyGood", sGood);
				}
				%>
				
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
<script>
		var btn = document.getElementById("goods-btn");
		
		btn.onclick = function(){
			btn.innerHTML = "已加入购物车";
			btn.style = "background-color:#F1F1F1";

		}
		
	</script>
</html>