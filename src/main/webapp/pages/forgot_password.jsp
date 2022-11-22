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
              <div class="col-6">
                <div class="row">
                  <div class="col-12">
                    <h3 class="">&nbsp; Recupere Sua Senha!</h3>
                    <p class="justify">
                      Nós valorizamos a segurança a seus dados, e se você se esqueceu da sua senha não se preocupe ao preencher o 
                      formulário abaixo irá receber todas as instruções necessarias em seu email para que possa cadastra uma nova
                      senha em nosso sistema e continuar desfrutando de todos os recursos para te ajudar a controlar todos os seus gastos, receitas e Investimentos.
                    </p>
                  </div>
                </div>

                <br/>

                <div class="row">
                  <div class="col-12 left-15">
                    <input type="email" class="form-control" name="" id="" aria-describedby="recoveryHelpId" placeholder="Email">
                  </div>
                </div>

                <br/>
                <br/>

                <div class="row">
                  <div class="col-12 left-15">
                    <a href="./signin.jsp">
                      <button type="button" class="w-100 btn btn-outline-primary p-2">
                        RECUPERAR SENHA
                      </button>
                    </a>
                  </div>
                </div>

                <br/>
                <br/>

                <div class="row">
                  <div class="col-12 text-center">
                    <h5> 
                      <a href="${pageContext.request.contextPath}/pages/signin.jsp">Lembrou da senha? Então clica aqui!</a>
                    </h5>
                  </div>
                </div>
              </div>
              <div class="col-6 text-center">
                <img src="${pageContext.request.contextPath}/pages/assets/monkeysMoney.png" width="400"/>
              </div>
            </div>
            <!-- end section -->
            <br/>
          </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
  </body>
</jsp>
