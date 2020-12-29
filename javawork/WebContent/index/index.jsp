<%@page import="cn.edu.swu.zl.buyer.Buyer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="cn.edu.swu.zl.goods.SellGoodsService"%>
<%@page import="cn.edu.swu.zl.goods.SellGoods"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dmail jsp</title>
	<link rel="stylesheet" type="text/css" href="../frame/frame.css" />
	<link rel="stylesheet" type="text/css" href="css/index.css" />
	<link rel="stylesheet" type="text/css" href="Swiper/swiper-bundle.css">
	<script src="js/index.js"></script>
	<script src="Swiper/swiper-bundle.js"></script>
	<script src="../frame/jquery-3.2.1.min.js"></script>
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
							<li><% out.print(buyer.getName() + " 您好！"); %></li>
							<li><a href="/javawork/QuitServlet">登出</a></li>
						<% }else{ %>
							<a href="../login/login.html"><li>请登录</li></a>
							<a href="../login/signout.html"><li>免费注册</li></a>
						<%	} %>
					</ul>
					<ul class="top_ul">
						<a href="/javawork/buy/allGoods.jsp"><li>全部商品</li>
						<a href="/javawork/buy/cart.jsp"><li>购物车</li></a>
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
					<div id="len_box"></div>
				</div>
			</div>
			<div id="content">
				<div id="main_nav">
					<div id="category-type">
						<i></i>
						<div class="text">商品分类</div>
					</div>
					<div id="nav">
							<a><img src="img/天猫超市.png"></a>
							<a><img src="img/天猫国际.png"></a>
							<a>天猫会员</a>
							<a>电器城</a>
							<a>喵鲜生</a>
							<a>医药馆</a>
							<a>营业厅</a>
							<a>魅力惠</a>
							<a>飞猪旅行</a>
							<a>苏宁易购</a>
					</div>
				</div>
				<div class="menu_nav">
					<ul>
						<li class="menu_nav_item0">
							<a>女装</a>/
							<a>内衣</a>
						</li>
						<li class="menu_nav_item1">
							<a>男装</a>/
							<a>运动户外</a>
						</li>
						<li class="menu_nav_item2">
							<a>女鞋</a>/
							<a>男鞋</a>/
							<a>箱包</a>
						</li>
						<li class="menu_nav_item3">
							<a>美妆</a>/
							<a>个人护理</a>
						</li>
						<li class="menu_nav_item4">
							<a>腕表</a>/
							<a>眼镜</a>/
							<a>珠宝饰品</a>
						</li>
						<li class="menu_nav_item5">
							<a>手机</a>/
							<a>数码</a>/
							<a>电脑办公</a>
						</li>
						<li class="menu_nav_item6">
							<a>母婴玩具</a>
						</li>
						<li class="menu_nav_item7">
							<a>零食</a>/
							<a>茶酒</a>/
							<a>进口食品</a>
						</li>
						<li class="menu_nav_item8">
							<a>生鲜水果</a>
						</li>
						<li class="menu_nav_item9">
							<a>大家电</a>/
							<a>生活电器</a>
						</li>
						<li class="menu_nav_item10">
							<a>家具建材</a>
						</li>
						<li class="menu_nav_item11">
							<a>汽车</a>/
							<a>配件</a>/
							<a>用品</a>
						</li>
						<li class="menu_nav_item12">
							<a>家纺</a>/
							<a>家饰</a>/
							<a>鲜花</a>
						</li>
						<li class="menu_nav_item13">
							<a>医药保健</a>
						</li>
						<li class="menu_nav_item14">
							<a>厨具</a>/
							<a>收纳</a>/
							<a>宠物</a>
						</li>
						<li class="menu_nav_item15">
							<a>图书音像</a>
						</li>
					</ul>		
				</div>
				<div id="slideshow">
					  <div class="swiper-container">
			            <div class="swiper-wrapper">
			                <div class="swiper-slide"><img src="img/swiper/O1CN01chAT0m1CRJ6qyX17e_!!77-0-luban.jpg_q100.jpg_.webp"></div>
			                <div class="swiper-slide"><img src="img/swiper/O1CN01Y07j1p1C0k8eqZBUa_!!19-0-luban.jpg_q100.jpg_.webp"></div>
			                <div class="swiper-slide"><img src="img/swiper/TB1_8omK.z1gK0jSZLeSuv9kVXa.jpg"></div>
			                <div class="swiper-slide"><img src="img/swiper/TB1_JXrLVXXXXbZXVXXSutbFXXX.jpg"></div>
			                <div class="swiper-slide"><img src="img/swiper/TB1gWMLckcx_u4jSZFlXXXnUFXa-1130-500.jpg_q100.jpg_.webp"></div>
			                <div class="swiper-slide"><img src="img/swiper/TB1W4nPJFXXXXbSXpXXSutbFXXX.jpg"></div>
			            </div>
			            <!-- 如果需要分页器 -->
			            <div class="swiper-pagination"></div>
			
			            <!-- 如果需要导航按钮 -->
			            <div class="swiper-button-prev"></div>
			            <div class="swiper-button-next"></div>
			
			            <!-- 如果需要滚动条 -->
			            <div class="swiper-scrollbar"></div>
			        </div>
				</div>
				<div class="mark">
					<div class="item_name">
						<img src="img/mark.png" />
					</div>
					<div class="mark_con">
						<div class="item_bigimg">
							<a href="/javawork/buy/buy.jsp?index=-1"><img src="./img/mark-left.jpg" class="item_bigimg_img"/></a>
							<img src="img/more.png" class="item_more">
						</div>
						<div class="mark_right">
							<div class="mark_twogrid">
								<ul>
									<li>今日疯抢</li>
									<li>限量版</li>
								</ul>
								<div class="twogird_con" style="display: block;">
									<a href="/javawork/buy/buy.jsp?index=-2"><img src="./img/mark-twogrid1.jpg"></a>
									<div class="twogrid_text">
										<div class="twogrid_text_head">
											<img src="./img/TB12RqQewMPMeJjy1XdXXasrXXa-23-23.png"/>
											<span>进口牛奶</span>
										</div>
										<div class="twogrid_text_cn">第2件0元</div>
									</div>
								</div>
								<div class="twogird_con" style="display: none;">
									<a href="/javawork/buy/buy.jsp?index=-3"><img src="./img/mark-twogrid2.jpg"></a>
									<div class="twogrid_text">
										<div class="twogrid_text_head">
											<img src="./img/TB12RqQewMPMeJjy1XdXXasrXXa-23-23.png"/>
											<span>全球零食</span>
										</div>
										<div class="twogrid_text_cn">第2件0元</div>
									</div>
								</div>
							</div>
							<%
								String sql = "select * from sellgoods;";
								List<SellGoods> sGoods = SellGoodsService.getAll(sql);
								
							%>
							<!--
                            	
                            -->
							<a href="/javawork/buy/buy.jsp?index=0">
								<div class="content_item_warp">
									<img class="item_img" src=<% out.print("'../img/goods/" +sGoods.get(0).getImg().toString() + "'"); %>>
									<div class="item_title"><%out.print(sGoods.get(0).getName());%></div>
									<div class="item_price">￥<% out.print(sGoods.get(0).getPrice()); %></div>
								</div>
							</a>
							<a href="/javawork/buy/buy.jsp?index=1">
								<div class="content_item_warp">
									<img class="item_img" src=<% out.print("'../img/goods/" +sGoods.get(1).getImg().toString() + "'"); %>/>
									<div class="item_title"><%out.print(sGoods.get(1).getName());%></div>
									<div class="item_price">￥<% out.print(sGoods.get(1).getPrice()); %></div>
								</div>
							</a>
							<a href="/javawork/buy/buy.jsp?index=2">
								<div class="content_item_warp">
									<img class="item_img" src=<% out.print("'../img/goods/" +sGoods.get(2).getImg().toString() + "'"); %>/>
									<div class="item_title"><%out.print(sGoods.get(2).getName());%></div>
									<div class="item_price">￥<% out.print(sGoods.get(2).getPrice()); %></div>
								</div>
							</a>
							<a href="/javawork/buy/buy.jsp?index=3">
								<div class="content_item_warp">
									<img class="item_img" src=<% out.print("'../img/goods/" +sGoods.get(3).getImg().toString() + "'"); %>/>
									<div class="item_title"><%out.print(sGoods.get(3).getName());%></div>
									<div class="item_price">￥<% out.print(sGoods.get(3).getPrice()); %></div>
								</div>
							</a>
							<a href="/javawork/buy/buy.jsp?index=4">
								<div class="content_item_warp">
									<img class="item_img" src=<% out.print("'../img/goods/" +sGoods.get(4).getImg().toString() + "'"); %>/>
									<div class="item_title"><%out.print(sGoods.get(4).getName());%></div>
									<div class="item_price">￥<% out.print(sGoods.get(4).getPrice()); %></div>
								</div>
							</a>
							<a href="/javawork/buy/buy.jsp?index=5">
								<div class="content_item_warp">
									<img class="item_img" src=<% out.print("'../img/goods/" +sGoods.get(5).getImg().toString() + "'"); %>/>
									<div class="item_title"><%out.print(sGoods.get(5).getName());%></div>
									<div class="item_price">￥<% out.print(sGoods.get(5).getPrice()); %></div>
								</div>
							</a>
						</div>
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
							<th>手机天猫</th>
							<td><img src="../frame/img/code.png"></td>
						</tr>
					</table>
				</div>
				<div class="copyright"></div>
			</div>
			<div id="topshow">
				<div class="topshow_container">
					<div class="logo">
						<span class="logo_en">TMALL</span>
						<span class="logo_cn">地猫</span>
					</div>
					<div class="topshow_search">
						<form action="/javawork/SearchServlet" method="get">
							<input type="text" placeholder="搜索 地猫 商品/品牌/店铺" name="search"/>
							<button>搜索</button>
						</form>
					</div>
				</div>
			</div>
			<div id="navshow">
				<div class="navshow_first">导航</div>
				<div class="navshow_left">
					<a class="navshow_item">天猫超市</a>
					<a class="navshow_item">天猫国际</a>
					<a class="navshow_item">美丽人生</a>
					<a class="navshow_item">潮酷电玩</a>
					<a class="navshow_item">居家生活</a>
					<a class="navshow_item">打造爱巢</a>
					<a class="navshow_item">户外出行</a>
					<a class="navshow_item">猜你喜欢</a>
					<div class="navshow_item">
						<a>顶部</a>
						<a>^</a>
					</div>
				</div>
			</div>
		</div>
		<script>
			var mySwiper = new Swiper('.swiper-container', {
                direction: 'horizontal', // 水平切换选项
                loop: true, // 循环模式选项
                autoplay: true, //自动           
                // 分页器
                pagination: {
                    el: '.swiper-pagination',
                },
                // 前进后退按钮
                navigation: {
                    nextEl: '.swiper-button-next',
                    prevEl: '.swiper-button-prev',
                }
           })
			
			$(function(){
				
				$("input[name=search]").css({
					"position":"relative"
				});
				
				$("#len_box").css({
					"width": "480px",
					"height": "200px",
					"position": "absolute",
					"top": "115px",
					"left": "450px",
					"z-index": "999"
				});
				
				// 键盘松开的时候触发联想功能
				$("input[name=search]").keyup(function(){
					var goodsName = $(this).val();
					if(goodsName != ""){
						$.ajax({
							url:"LenServlet",
							type:"post",
							data:{"goodsName":goodsName},
							dataType:"html",
							async:true,
							success:function(result){
								$("#len_box").show();
								$("#len_box").html(result);
								
								// 点击模糊列表的值，必须在这里写，其他位置不起作用
								$("li").unbind("click").bind("click", function(){
									$("input[name=search]").val($(this).html());
									$("input[name=search]").focus();
									$("#len_box").hide();
								});
								
								// 点击其他地方的时候隐藏
								$("input[name=goodsName]").blur(function(){
									$("#len_box").hide();
								});
							}
						});
					}else{
						$("#len_box").html("");
						$("#len_box").hide();
					}
				});
			});	
			
			
		</script>
</body>
</html>