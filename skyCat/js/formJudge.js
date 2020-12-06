<script type="text/javascript"> 
 
  //验证用户名   
  function checkUserName(){ 
  var username = document.getElementById('userName'); 
  var errname = document.getElementById('nameErr'); 
  var pattern = /^\w{3,}$/;  //用户名格式正则表达式：用户名要至少三位 
  if(username.value.length == 0){ 
    errname.innerHTML="用户名不能为空"
    errname.className="error"
    return false; 
    } 
  if(!pattern.test(username.value)){ 
    errname.innerHTML="用户名不合规范"
    errname.className="error"
    return false; 
    } 
   else{ 
     errname.innerHTML="OK"
     errname.className="success"; 
     return true; 
     } 
  } 
  //验证密码   
function checkPassword(){ 
  var userpasswd = document.getElementById('userPasword'); 
  var errPasswd = document.getElementById('passwordErr'); 
  var pattern = /^\w{4,8}$/; //密码要在4-8位 
  if(!pattern.test(userpasswd.value)){ 
    errPasswd.innerHTML="密码不合规范"
    errPasswd.className="error"
    return false; 
    } 
   else{ 
     errPasswd.innerHTML="OK"
     errPasswd.className="success"; 
     return true; 
     } 
  } 
 
 

</script>


