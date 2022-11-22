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
          <br/>
          <div class="row">
            <div class="col">
              <nav class="navbar navbar-expand-lg navbar-light bg-light rounded">
                <div class="container-fluid">
                  <a class="navbar-brand" href="#">Monkeys Money</a>
                  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                  </button>
                  <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                      <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="./ultimos_lancamentos.jsp">Ultimos LanÃ§amentos</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#">RelatÃ³rio de Despesas</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" href="#">RelatÃ³rio de Receita</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Alterar Password</a>
                      </li>
                      <li class="nav-item text-end">
                        <a class="nav-link" href="./signin.jsp">Sair</a>
                      </li>
                    </ul>
                  </div>
                </div>
              </nav>
            </div>
          </div>
          
          <br/>
          <div class="singin rounded "> 
            <br/>
            <br/>
            
            <!-- section logo -->
            <div class="row">
              <div class="col text-center">
                <img src="${pageContext.request.contextPath}/pages/assets/monkeysMoney.png" width="250"/>
              </div>
            </div>
            <!-- end section -->
            
            
            <br/>
            <br/>
            <div class="row">
              <div class="col-12">
                <div class="row">
                  <div class="col-2">
                  </div>
                  <div class="col-8 grid-color rounded top bottom">
                    <div class="card" style="width: 100%;">
                      <div class="card-body">
                        <h5 class="card-title text-center"> 
                          <span title="Anterior" style="color: #333 ;"> 
                            <a href="#"> < </a>
                          </span>
                          &nbsp;Julho&nbsp;
                          <span title="PrÃ³ximo"> 
                            <a href="#" style="color: #333 ;"> > </a> 
                          </span> 
                        </h5>
                        <h6 class="card-subtitle mb-5 text-center" style="margin-top: 30px;">
                          <span class="cifra">R$&nbsp;</span>
                          <span class="total_coast up">3.280,90</span>
                        </h6>
                        <div class="text-center">
                          <a href="#" class="card-link receita-txt">
                            Receita
                          </a>
                          <a href="#" class="card-link despesa-txt">
                            Despesa
                          </a>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-2">

                  </div>
                </div>
              </div>
            </div>

            <br/>
            <br/>
            <br/>

            <div class="row">
              <div class="col-2"></div>
              <div class="col-8 grid-color rounded-top">
                <div class="row">
                  <p>
                    <h4>Ultimos Lançamentos</h4>
                  </p>
                  <div class="col">
                    <ul class="list-group list-group-flush">
                      <li class="list-group-item">
                        <div class="row">
                          <div class="col">
                            <span class="rounded-circle despesa text-start">&nbsp;D&nbsp;</span>
                          </div>
                          <div class="col text-center lancamentos-font">
                            <text>Despesa</text>
                          </div>
                          <div class="col text-end lancamentos-font">
                            <span>R$ 500,00</span>
                          </div>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div class="row">
                          <div class="col">
                            <span class="rounded-circle receita text-start">&nbsp;R&nbsp;</span>
                          </div>
                          <div class="col text-center lancamentos-font">
                            <text>Receita</text>
                          </div>
                          <div class="col text-end lancamentos-font">
                            <span>R$ 2.000,00</span>
                          </div>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div class="row">
                          <div class="col">
                            <span class="rounded-circle receita text-start">&nbsp;R&nbsp;</span>
                          </div>
                          <div class="col text-center lancamentos-font">
                            <text>Receita</text>
                          </div>
                          <div class="col text-end lancamentos-font">
                            <span>R$ 600,00</span>
                          </div>
                        </div>
                      </li>
                      <li class="list-group-item">
                        <div class="row">
                          <div class="col">
                            <span class="rounded-circle despesa text-start">&nbsp;D&nbsp;</span>
                          </div>
                          <div class="col text-center lancamentos-font">
                            <text>Despesa</text>
                          </div>
                          <div class="col text-end lancamentos-font">
                            <span>R$ 250,00</span>
                          </div>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
                <hr/>
                <br/>
                <div class="row">
                  <div class="col-sm-6 col-md-6 col-lg-6 col-xl-6 col-xxl-6"></div>
                  <div class="col col-sm-6 col-md-6 col-lg-6 col-xl-6 col-xxl-6">
                    <button type="button" class="w-100 btn btn-outline-primary p-2 ultimos-lancamentos">LANÇAR</button>
                  </div>
                </div>
                <br/>
              </div>
              <div class="col-2"></div>
            </div>

          </div>
          <br/>
          <br/>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js" integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy" crossorigin="anonymous"></script>
  </body>
</jsp>
