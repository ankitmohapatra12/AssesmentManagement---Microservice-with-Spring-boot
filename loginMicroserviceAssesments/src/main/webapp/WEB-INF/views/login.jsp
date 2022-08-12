<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<style>
form{
	background-color: #76a8e9;
	width:400px;
	height:460px;
	border-style:solid;
	border-color:blue;
	padding:20px;
}


.login-page {
  width: 400px;
  height:360px;
  padding: 8% 0 0;
  margin: auto;
}
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: Century Gothic;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: Century Gothic;
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 40%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}

.form #loginbtn {
  font-family: Century Gothic;
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 40%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}

.form button:hover,.form button:active,.form button:focus {
  background: #43A047;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #4CAF50;
  text-decoration: none;
}

body {
  background: #6D2AE2;
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}
select {
  box-sizing: border-box;

  appearance: none;

  background-color: white;
  color:#6D2AE2;
  border-color:#6D2AE2;
  padding: 5px;
  margin-top: 10px;
margin-bottom:35px;
  width: 100%;
text-align:center;
  font-family: Century Gothic;
  font-size: 16px;
  font-weight: 500;
  line-height: 1.3;

  cursor: default;
}


</style>
<script type="text/javascript">


	 window.history.forward();
     function noBack() {
         window.history.forward();
     }

	

</script>
	</head>
	<body>
	
	<div class="login-page">
		<form action="/Home" method="post" class="login-form">
		<input type="hidden" id="hid" value="${user_id}">
			  <div class="form">
			  <h3 style="color:#6D2AE2;text-align:center:font-family:Century Gothic;">PLEASE LOGIN</h3>
			    
			      <input type="text" placeholder="username" name="userName" required/>
			      <input type="password" placeholder="password" name="password" required/>
				      <select name="userLevel" id="cars">
						  <option value="EMPLOYEE">EMPLOYEE</option>
						  <option value="ADMIN">ADMIN</option>
					</select>
			      <input id="loginbtn" type="submit" value="LOGIN" style="background-color: #6D2AE2;color:white;">
			      <input type="button" value="REGISTER" id="loginbtn" style="background-color: #6D2AE2;color:white;" onclick="register()">
				    <c:choose>
			  			<c:when test="${not empty error}">
			   				<div><p class="message" style="color:red;background-color:white;">${error}</p></div>
			  			</c:when>
			  			<c:otherwise>
			  		  		<div><br></div>
			  			</c:otherwise>
				   </c:choose>
			      </div>
		  </form>  
    </div>
	
	
	
</body>




</html>

<script>
	function register(){
		window.location.href = "/register";
	}
</script>