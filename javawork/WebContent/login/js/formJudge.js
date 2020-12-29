
  //验证姓名
  function checkName(){
  	var name=document.getElementById('name');
  	var errname=document.getElementById('nameErr');
  	var pattern = /^\w{3,}$/;  //用户名格式正则表达式：用户名要至少三位 
  if(name.value.length == 0){ 
     errname.innerHTML="*姓名不能为空"
    return false; 
    } 
  if(!pattern.test(username.value)){ 
    errname.innerHTML="*姓名不合规范，至少要三位"
    //errname.className="error"
    return false; 
    } 
   else{ 
    // errname.innerHTML="OK"
    // errname.className="success"; 
     return true; 
     } 
  }
  //验证用户名   
  function checkUserName(){ 
  var username = document.getElementById('userName');
  var errusername = document.getElementById('userNameErr'); 
  var pattern = /^\w{3,}$/;  //用户名格式正则表达式：用户名要至少三位 
  if(username.value.length == 0){ 
     errusername.innerHTML="*用户名不能为空"
    return false; 
    } 
  if(!pattern.test(username.value)){ 
    errusername.innerHTML="*用户名不合规范，至少三位 "
    //errname.className="error"
    return false; 
    } 
   else{ 
    // errusername.innerHTML="OK"
    // errname.className="success"; 
     return true; 
     } 
  } 
  //验证密码   
function checkPassword(){ 
  var userpasswd = document.getElementById('userPasword'); 
  var errPasswd = document.getElementById('passwordErr'); 
  var pattern = /^\w{4,8}$/; //密码要在4-8位 
  if(!pattern.test(userpasswd.value)){ 
    errPasswd.innerHTML="*密码不合规范，要在4-8位";
    //errPasswd.className="error"
    return false; 
    } 
   else{ 
    //errPasswd.innerHTML="OK"
    // errPasswd.className="success"; 
     return true; 
     } 
  } 
  //验证角色
  function checkRole(){
  	var role=document.getElementsByName("role");
    var roleErr=document.getElementById('roleErr');
    if(role[0].checked||role[1].checked){
       
   		//验证通过
			return true;
    }else{
    	roleErr.innerHTML="*请选择登录的身份"
    	return false;
    }
    
}
  
  function checkYanZheng(){
  	var yanzhengErr=document.getElementById("yanzhengErr");	   
    var res = verifyCode.validate(document.getElementById("code_input").value);
    //console.log(res);
    if(res){
    	return true;
        
    }else{
    	yanzhengErr.innerHTML="*验证码输入错误";
    	return false;
        //alert("验证码错误");
    }
		}
  

  function checkForm_log(){
  	if(checkUserName()&&
  	checkPassword()&&
  	checkRole()&&
  	checkYanZheng()){
  		//alert("right");//设置验证后需要跳转的页面
  		return true;
  	}
  	else{
  		//alert("wrong");
  		return false;
  	}
  }
  
  function checkForm_sign(){
  	if(checkName()&&
  	checkUserName()&&
  	checkPassword()&&
  	checkRole())
  	{
  		//alert("right");signInServlet里面设置的是跳转到登录界面
  		return true;
  	}
  	else{
  		//alert("wrong");
  		return false;
  	}
  	
  }
  
  //js实现验证码
    !(function(window, document) {
    function GVerify(options) { //创建一个图形验证码对象，接收options对象为参数
        this.options = { //默认options参数值
            id: "", //容器Id
            canvasId: "verifyCanvas", //canvas的ID
            width: "100", //默认canvas宽度
            height: "30", //默认canvas高度
            type: "blend", //图形验证码默认类型blend:数字字母混合类型、number:纯数字、letter:纯字母
            code: ""
        }
        
        if(Object.prototype.toString.call(options) == "[object Object]"){//判断传入参数类型
            for(var i in options) { //根据传入的参数，修改默认参数值
                this.options[i] = options[i];
            }
        }else{
            this.options.id = options;
        }
        
        this.options.numArr = "0,1,2,3,4,5,6,7,8,9".split(",");
        this.options.letterArr = getAllLetter();

        this._init();
        this.refresh();
    }

    GVerify.prototype = {
        /**版本号**/
        version: '1.0.0',
        
        /**初始化方法**/
        _init: function() {
            var con = document.getElementById(this.options.id);
            var canvas = document.createElement("canvas");
            this.options.width = con.offsetWidth > 0 ? con.offsetWidth : "100";
            this.options.height = con.offsetHeight > 0 ? con.offsetHeight : "30";
            canvas.id = this.options.canvasId;
            canvas.width = this.options.width;
            canvas.height = this.options.height;
            canvas.style.cursor = "pointer";
            canvas.innerHTML = "您的浏览器版本不支持canvas";
            con.appendChild(canvas);
            var parent = this;
            canvas.onclick = function(){
                parent.refresh();
            }
        },
        
        /**生成验证码**/
        refresh: function() {
            this.options.code = "";
            var canvas = document.getElementById(this.options.canvasId);
            if(canvas.getContext) {
                var ctx = canvas.getContext('2d');
            }else{
                return;
            }
            
            ctx.textBaseline = "middle";

            ctx.fillStyle = randomColor(180, 240);
            ctx.fillRect(0, 0, this.options.width, this.options.height);

            if(this.options.type == "blend") { //判断验证码类型
                var txtArr = this.options.numArr.concat(this.options.letterArr);
            } else if(this.options.type == "number") {
                var txtArr = this.options.numArr;
            } else {
                var txtArr = this.options.letterArr;
            }

            for(var i = 1; i <= 4; i++) {
                var txt = txtArr[randomNum(0, txtArr.length)];
                this.options.code += txt;
                ctx.font = randomNum(this.options.height/2, this.options.height) + 'px SimHei'; //随机生成字体大小
                ctx.fillStyle = randomColor(50, 160); //随机生成字体颜色        
                ctx.shadowOffsetX = randomNum(-3, 3);
                ctx.shadowOffsetY = randomNum(-3, 3);
                ctx.shadowBlur = randomNum(-3, 3);
                ctx.shadowColor = "rgba(0, 0, 0, 0.3)";
                var x = this.options.width / 5 * i;
                var y = this.options.height / 2;
                var deg = randomNum(-30, 30);
                /**设置旋转角度和坐标原点**/
                ctx.translate(x, y);
                ctx.rotate(deg * Math.PI / 180);
                ctx.fillText(txt, 0, 0);
                /**恢复旋转角度和坐标原点**/
                ctx.rotate(-deg * Math.PI / 180);
                ctx.translate(-x, -y);
            }
            /**绘制干扰线**/
            for(var i = 0; i < 4; i++) {
                ctx.strokeStyle = randomColor(40, 180);
                ctx.beginPath();
                ctx.moveTo(randomNum(0, this.options.width), randomNum(0, this.options.height));
                ctx.lineTo(randomNum(0, this.options.width), randomNum(0, this.options.height));
                ctx.stroke();
            }
            /**绘制干扰点**/
            for(var i = 0; i < this.options.width/4; i++) {
                ctx.fillStyle = randomColor(0, 255);
                ctx.beginPath();
                ctx.arc(randomNum(0, this.options.width), randomNum(0, this.options.height), 1, 0, 2 * Math.PI);
                ctx.fill();
            }
        },
        
        /**验证验证码**/
        validate: function(code){
            var code = code.toLowerCase();
            var v_code = this.options.code.toLowerCase();
            console.log(v_code);
            if(code == v_code){
                return true;
            }else{
                this.refresh();
                return false;
            }
        }
    }
    /**生成字母数组**/
    function getAllLetter() {
        var letterStr = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
        return letterStr.split(",");
    }
    /**生成一个随机数**/
    function randomNum(min, max) {
        return Math.floor(Math.random() * (max - min) + min);
    }
    /**生成一个随机色**/
    function randomColor(min, max) {
        var r = randomNum(min, max);
        var g = randomNum(min, max);
        var b = randomNum(min, max);
        return "rgb(" + r + "," + g + "," + b + ")";
    }
    window.GVerify = GVerify;
})(window, document);
  
    

