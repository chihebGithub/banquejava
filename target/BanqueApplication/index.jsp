<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="./js/jquery-3.4.1.min.js" ></script>  
<link href="./css/login.css" rel="stylesheet" id="bootstrap-css">
<script src="./js/login.js" ></script>  
</head>
<body>

<div class="container ">
    	<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div class="panel panel-login">
					<div class="panel-heading">
						<div class="row">
							<div class="col-xs-6">
								<a href="#" class="active" id="login-form-link">Login</a>
							</div>
							<div class="col-xs-6">
								<a href="#" id="register-form-link">Register</a>
							</div>
						</div>
						<hr>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form id="login-form" action="LoginController" method="get" role="form" style="display: block;">
									<div class="form-group">
										<input type="email" name="emailname" id="emailname" required="required" tabindex="1" class="form-control" placeholder="Username" value="">
									      <p hidden="true" id="erremail" class="d-none">This paragraph should be hidden.</p>
									</div>
									<div class="form-group">
										<input type="password" name="password" id="password" required="required" tabindex="2" class="form-control" placeholder="Password">
									</div>
									<div class="form-group text-center">
										<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
										<label for="remember"> Remember Me</label>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="Log In">
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="row">
											<div class="col-lg-12">
												<div class="text-center">
													<a href="https://phpoll.com/recover" tabindex="5" class="forgot-password">Forgot Password?</a>
												</div>
											</div>
										</div>
									</div>
								</form>
								<form id="register-form" action="ClientController" method="post" role="form" style="display: none;">
								
									<div class="form-group">
									    
									<div class="form-group col-sm-6">
									   <input class="form-control" type="text" name="firstname" required="required" style="margin-left:-17px" id="firstname" tabindex="1"  placeholder="first name" value="">
									
								   	</div>
								   	<div class="form-group col-sm-6">
								  
									     <input class="form-control" type="text" name="lastname" required="required" style="margin-left:12px" id="lastname" tabindex="1" placeholder="last name" value="">
								 	</div>
									</div>
									<div class="form-group">
										<input type="text" name="cin" id="cin" tabindex="1"
											required="required" class="form-control"
											placeholder="numero carte identité" value="" />

									</div>
									<p hidden="true" id="errCin" class="d-none">This paragraph should be hidden.</p>
									<div class="form-group">
										<input type="email" name="email" id="email" tabindex="1" required="required" class="form-control form-control-sm" placeholder="Email Address" value="">
									     <p hidden="true" id="errexist" class="d-none">This paragraph should be hidden.</p>
									</div>
 
									<div class="form-group  form-control">
										<label for="sex" class="col-sm-2 col-form-label">Sex:</label>
										<div class="col-sm-10">
											<label class="radio-inline col-sm-4"><input
												type="radio" name="sex" id="male" value="male" checked>male</label> <label
												class="radio-inline col-sm-6"><input type="radio" value="female" id="female" name="sex">female</label>
										</div>
									</div>

									<div class="form-group">
										<label for="contry">Contry </label> <select 
											class="form-control" id="contry" name="contry">
											<option>Tunisia</option>
											<option>France</option>
											<option>Allemagne</option>
											<option>Autriche</option>
											<option>Belgique</option>
										</select>
									</div>

									<div class="form-group">
										<input type="password" name="password" required="required" id="passwordRegister" tabindex="2" class="form-control" placeholder="Password">
									</div>
								
									<div class="form-group">
										<div class="row">
											<div class="col-sm-6 col-sm-offset-3">
												<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="Register Now">
											</div>
										</div>
									</div>
							</form>
						</div>
					</div>
            </div>
          </div>
        </div>
        </div>
        </div>
        <script>
        
        $(document).ready(function () {
        	  //called when key is pressed in textbox
        	  $("#cin").keypress(function (e) {
        	     //if the letter is not digit then display error and don't type anything
        	     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
        	               return false;
        	    }
        	     
        	   });
        	  
        	  
        	  
        	  $("#cin").blur(function () {
         	     //if the letter is not digit then display error and don't type anything
         	     if ($("#cin").val().length != 8) {
         	         $("#errCin").text("le longeur de la carte cin est 8 caractèrs ").show().css("color","red");
         	        $("#cin").focus();
         	       $(this).addClass("alert-danger" )
         	    }
         	    if ($("#cin").val().length == 8) {
        	         $("#errCin").hide();
        	         $(this).removeClass("alert-danger" )
        	    }
         	    
         		$.ajax({
    				url : '/BanqueApplication/CompteController',
    				type:'POST',
    				dataType: "json",
    			    data :{name : $("#cin").val()},
    				success : function(responseText) {
    					
    					if(responseText.err!=null)
    					{ $("#errCin").text(responseText.err).show().css("color","red");
    					 $("#cin").focus();
    					}
    					console.log(responseText.err)
    				  //  $("#name").val(responseText.name);
    				    //$("#lastname").val(responseText.firstname);
    				  //  alert(responseText)
    					
    				}
    				
    			});
         	    
         	   });
        	  
        	  $("#emailname").blur(function () {
          	 	$.ajax({
     				url : 'https://chiheb.azurewebsites.net/CompteController',
     				type:'POST',
     				dataType: "json",
     			    data :{email : $("#emailname").val()},
     				success : function(responseText) {
     					
     					if(responseText.erremail!=null)
     					{ $("#erremail").text(responseText.erremail).show().css("color","red");
     					 $("#emailname").focus();
     					}
     					if(responseText.erremail==null)
     					{ $("#erremail").hide();
     					// $("#emailname").focus();
     					}
     			
     					
     				}
     				
     			});
     			
          	   });//fin email
          	 
        	  $("#email").blur(function () {
            	 	$.ajax({
       				url : 'https://chiheb.azurewebsites.net/CompteController',
       				type:'POST',
       				dataType: "json",
       			    data :{email : $("#email").val()},
       				success : function(responseText) {
       					//console.log(responseText)
       					if(responseText.errexist!=null)
       					{ $("#errexist").text(responseText.errexist).show().css("color","red");
       					 $("#email").focus();
       					}
       					if(responseText.errexist==null)
       					{ $("#errexist").hide();
       					// $("#emailname").focus();
       					}
       			
       					
       				}
       				
       			});
       			
            	   });
        		
        			
 
        	  
        	  
        	  
        	});
         
        </script>
	</body>
	</html>