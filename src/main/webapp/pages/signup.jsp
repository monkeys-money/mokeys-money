<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!doctype jsp>
<jsp lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Monkey's Money</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;400;500;700;900&display=swap" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/pages/css/fintech.css" rel="stylesheet">
  </head>
  <body>

    <div class="container-fluid">
        
        <div class="container">

          <div class="singin rounded child"> 
            <br/>
            <br/>
            <!-- section logo -->
            <div class="row">
              <div class="col text-center">
                <img src="${pageContext.request.contextPath}/pages/assets/monkeysMoney.png" width="400"/>
              </div>
            </div>
            <!-- end section -->
            <br/>
            <br/>

            <div class="row">
              <div class="col-2"></div>
              <div class="col-4 col-ms-12 text-center">
                <input type="email" class="form-control" name="" id="email" aria-describedby="emailHelpId" placeholder="Email">
              </div>
              <div class="col-4 col-ms-12 text-center">
                <input type="email" class="form-control" name="" id="confirmEmail" aria-describedby="emailConfirmHelpId" placeholder="Confirm Email">
              </div>
              <div class="col-2"></div>
            </div>

            <br/>
            <br/>

            <div class="row">
              <div class="col-2"></div>
              <div class="col-4 col-ms-12">
                  <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                  <small>At least 8 characters, at least 1 number, at least 1 lowercase character (a-z), at least 1 uppercase character (A-Z), only 0-9a-zA-Z</small>
              </div>
              <div class="col-4 col-ms-12">
                  <input type="password" class="form-control" id="inputPasswordConfirmation" placeholder="Confirm Password">
              </div>
              <div class="col-2"></div>
            </div>

            <br/>
            <br/>
            
            <div class="row">
              <div class="col-2"></div>
              <div class="col-8 col-ms-12  text-center">
               
                  <button type="button" id="buttonSave" class="w-100 btn btn-outline-primary p-2" disabled="disabled">
                    CADASTRAR-SE
                  </button>
                
              </div>
              <div class="col-2"></div>
            </div>
             
            <div class="none" id="success-panel">
            	<br/>
	            <div class="row" >
	              <div class="col-2"></div>
	              <div class="col-8 col-ms-12  text-center">
	               
	                 <div class='alert alert-success'>
	                  	Congratulations, Your User Was Created With Success!
	                 </div>
	                
	              </div>
	              <div class="col-2"></div>
	            </div>
            </div>
           
            <br/>
            <br/>
            
            <div class="row">
              <div class="col text-center">
                <h5> 
                  <a href="${pageContext.request.contextPath}/pages/signin.jsp">Já tem conta? Então Clica Aqui.</a>
                </h5>
              </div>
            </div>

            <br/>

          </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
    
    
    <script>
	    $('#email').on('input', function() {
	    	var input=$(this);
	    	var re = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	    	var is_email=re.test(input.val());
	    	
	    	if(is_email){
	    		input.removeClass("invalid").addClass("valid");
	    		enalbeButton()
	    	}
	    	else{
	    		input.removeClass("valid").addClass("invalid");
	    		disableButton()
	    	}
	    });
	    
	    $('#confirmEmail').on('input', function() {
	    	var input=$(this);
	    	
	    	if(input.val() === $('#email').val()){
	    		input.removeClass("invalid").addClass("valid");
	    		enalbeButton();
	    	} else{
	    		input.removeClass("valid").addClass("invalid");
	    		disableButton()
	    	}
	    	
	    });
	    
	    $('#inputPassword').on('input', function() {
	    	var input=$(this);
	    	var re = /^.*(?=.{8,})(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).*$/;
	    	var password=re.test(input.val());
	    	
	    	if(password){
	    		input.removeClass("invalid").addClass("valid");
	    		enalbeButton();
	    	}else{
	    		input.removeClass("valid").addClass("invalid");
	    		disableButton()
	    	}
	    });
	    
	    $('#inputPasswordConfirmation').on('input', function() {
	    	var input=$(this);
	    	
	    	if(input.val() === $('#inputPassword').val()){
	    		input.removeClass("invalid").addClass("valid");
	    		enalbeButton();
	    	} else{
	    		input.removeClass("valid").addClass("invalid");
	    		disableButton()
	    	}
	    	
	    });
	    
	    
	    $('#buttonSave').click(function() {
	    	 
	    	if($('#inputPassword').val() === $('#inputPasswordConfirmation').val() && $('#email').val() === $('#confirmEmail').val()){
	    		
	    		 $.ajax({
	    			    type: 'POST',
	    			    url: 'http://localhost:8080/monkeys-money/users',
	    			    data: '{"email":"'+$('#email').val()+'", "password":"'+$('#inputPassword').val()+'" }', // or JSON.stringify ({name: 'jonas'}),
	    			    success: function(data) { 
	    			    	
	    			    	$('#inputPassword').val(""); 
	    			    	$('#inputPasswordConfirmation').val("");
	    			    	$('#email').val("");
	    			    	$('#confirmEmail').val("");
	    			    	
	    			    	$('#inputPassword').removeClass("valid").addClass("common");
	    			    	$('#inputPasswordConfirmation').removeClass("valid").addClass("common");
	    			    	$('#email').removeClass("valid").addClass("common");
	    			    	$('#confirmEmail').removeClass("valid").addClass("common");
	    			    	
	    			    	$('#success-panel').fadeIn(3000);
	    			    	$('#success-panel').fadeOut(5000);
	    			    },
	    			    contentType: "application/json",
	    			    dataType: 'json'
	    		});		
	    	}

	    });
	    
	    function enalbeButton(){
	    	if($('#inputPassword').val() === $('#inputPasswordConfirmation').val() && $('#email').val() === $('#confirmEmail').val()){
    			$('#buttonSave').removeAttr("disabled");	
    		}
	    }
	    
	    function disableButton(){
	    	if($('#inputPassword').val() === $('#inputPasswordConfirmation').val() && $('#email').val() === $('#confirmEmail').val()){
    			$('#buttonSave').attr("disabled");	
    		}
	    }
	    
    </script>
  </body>
</jsp>
