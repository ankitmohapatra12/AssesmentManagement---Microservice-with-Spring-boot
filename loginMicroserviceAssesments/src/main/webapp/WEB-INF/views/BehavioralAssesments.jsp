<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<style>
form{
	background-color: white;
	width:400px;
	height:460px;
	border-style:1px solid;
	border-color:#6D2AE2;
	padding:20px;
  	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
	margin-top:50px;
}


.login-page {
  width: 400px;
  height:360px;
  padding: 8% 0 0;
  margin: auto;
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
		body {
		      float:top;
			  font-size: 15px;
			  width:100%;
			  height:100%;
			   margin_left:-20px;
			  margin_top:-20px;
			  font-family:Century Gothic;
			}
			
			ul {
			  list-style-type: none;
			  overflow: hidden;
			  background-color: #6D2AE2;
			 position: -webkit-sticky; 
			  position: sticky;
			 
			  
			}
			
			li {
			  float: left;
			}
			
			li a {
			  display: block;
			  color: white;
			  text-align: center;
			  padding: 14px 26px;
			  text-decoration: none;
			}
			
			li a:hover {
			  background-color: white;
			  color:#6D2AE2;
			}
			
			.active {
			  color:#6D2AE2 ;
			  background-color:white;
			}
			
			#li4{
				float:right;
			}
			
			

</style>
  <script>
$(function(){
    var dtToday = new Date();
    
    var month = dtToday.getMonth() + 1;
    var day = dtToday.getDate();
    var year = dtToday.getFullYear();
    if(month < 10)
        month = '0' + month.toString();
    if(day < 10)
        day = '0' + day.toString();
    
    var maxDate = year + '-' + month + '-' + day;

   document.getElementById("dateField").min = maxDate;
});
  </script>
</head>
<body>
	<ul>
			  <li><a  href="/Employee/Homepage">Home</a></li>
			  <li><a class="active" href="/Employee/behavioralTechnicalAssesment">Behavioral Assesment Registration</a></li>
			  <li><a href="/Employee/scheduleTechnicalAssesment">Technical Assesment Registration</a></li>
			  <li id="li4"><a href="/logout">LOGOUT</a></li>
			</ul>
			<body>
	<div class="form">

    <form class="register-form" action="/Employee/saveBehavioralRegistration" method="post">
      <h3 style="color:#6D2AE2;margin-bottom:30px;">BEHAVIORAL ASSESSMENT REGISTRATION</h3>
      <input type="text" readonly="readonly" name="user_id" value="${user_id}" />
      <input type="date" id="dateField" name="date" min="0" required>
      <select name="assesment" required>
			  <option value="Step plus">Step plus</option>
			  <option value="Email Etiquette">Email Etiquette</option>
			  <option value="Learning Agility">Learning Agility</option>
			  <option value="Corporate Communication">Corporate Communication</option>
	</select>
	<input type="hidden" name="type" value="BEHAVIORAL">
<br><br>
      				<input id="loginbtn" type="reset" value="RESET" style="background-color: #6D2AE2;color:white;">
      				<input type="submit" value="REGISTER" id="loginbtn" style="background-color: #6D2AE2;color:white;">      
      
					<c:choose>
			  			<c:when test="${not empty err}">
			   				<div><p class="message" style="color:red;background-color:white;">${err}</p></div>
			  			</c:when>
						<c:when test="${not empty success}">
			   				<div><p class="message" style="color:green;">${success}</p></div>
			  			</c:when>
			  			<c:otherwise>
			  		  		<div><br></div>
			  			</c:otherwise>
				  </c:choose>
    </form>
		
  </div>		
  </body>
<html>