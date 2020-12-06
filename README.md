# javaweb
The work of javaweb
参与人员：
周亮  --master
周妍  --zhouyan分支
李玟  --liwen分支
作品简介：
仿照天猫制作的简单电商网站，以现有的知识实现基本功能：
1.登录页面.
包含登录与注册功能，可以选择角色(卖家或买家)。实现表单验证，登录过滤等功能。
2.首页页面.
删减天猫首页，留下核心功能。实现顶部用户栏实时显示用户信息，动态从数据库显示最新卖家发布的商品信息，并点击商品跳转至购买页面。
3.购买页面.
动态生成商品信息(图片，价格，介绍等…)，包含添加到购物车功能，查看购物车等功能。
4.卖家页面.
卖家可上传商品信息，点击发布商品，存储到数据库，动态显示到首页；
可查看发布商品信息，销售情况。

布局设计：
前端布局基本仿照天猫布局加上自己设计，适当使用JavaScript添加吸顶导航栏，表单前端验证等功能；
后端使用servlet部署在tomcat上，通过JDBC连接数据库，jsp动态生成网页，实现与前端通信。

人员安排：
李玟：实现登录页面设计，表单注册、添加用户至数据库、表单验证登录、登录过滤器等。
周妍：实现卖家页面设计，接受卖家上传商品信息、更新商品数据库、动态显示卖家已发布商品清单、卖家个人中心设计等。
周亮：实现首页与商品购买页面设计，调用数据库动态生成首页与商品页面、实现买家添加到购物车、查看购物车功能、连接登录页面和卖家页面设计，组织三人代码合并并测试。
