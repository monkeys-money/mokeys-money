# Monkeys Money


## Structure Of Project

<pre><font color="#12488B"><b>.</b></font>
├── pom.xml
├── README.MD
├── <font color="#12488B"><b>resources</b></font>
│   ├── database.sql
│   ├── monkeys-money.postman_collection.json
│   └── postgres-compose.yml
├── <font color="#12488B"><b>src</b></font>
│   ├── <font color="#12488B"><b>main</b></font>
│   │   ├── <font color="#12488B"><b>java</b></font>
│   │   │   └── <font color="#12488B"><b>br</b></font>
│   │   │       └── <font color="#12488B"><b>com</b></font>
│   │   │           └── <font color="#12488B"><b>fiap</b></font>
│   │   │               └── <font color="#12488B"><b>fintech</b></font>
│   │   │                   └── <font color="#12488B"><b>monkeys_money</b></font>
│   │   │                       ├── <font color="#12488B"><b>app</b></font>
│   │   │                       │   ├── <font color="#12488B"><b>controller</b></font>
│   │   │                       │   │   ├── ExpenditureController.java
│   │   │                       │   │   ├── <font color="#12488B"><b>iface</b></font>
│   │   │                       │   │   │   └── IRestAPIOperation.java
│   │   │                       │   │   ├── InvestmentController.java
│   │   │                       │   │   ├── LoginController.java
│   │   │                       │   │   ├── ProfileController.java
│   │   │                       │   │   ├── RevenueController.java
│   │   │                       │   │   └── UserController.java
│   │   │                       │   ├── <font color="#12488B"><b>dto</b></font>
│   │   │                       │   │   ├── <font color="#12488B"><b>error</b></font>
│   │   │                       │   │   │   └── ErrorMessage.java
│   │   │                       │   │   ├── <font color="#12488B"><b>request</b></font>
│   │   │                       │   │   │   ├── ExpenditureRequest.java
│   │   │                       │   │   │   ├── InvestmentRequest.java
│   │   │                       │   │   │   ├── ProfileRequest.java
│   │   │                       │   │   │   ├── RevenueRequest.java
│   │   │                       │   │   │   └── UserRequest.java
│   │   │                       │   │   └── <font color="#12488B"><b>response</b></font>
│   │   │                       │   │       ├── ExpenditureResponse.java
│   │   │                       │   │       ├── InvestmentResponse.java
│   │   │                       │   │       ├── ProfileResponse.java
│   │   │                       │   │       ├── RevenueResponse.java
│   │   │                       │   │       ├── TokenResponse.java
│   │   │                       │   │       └── UserResponse.java
│   │   │                       │   └── <font color="#12488B"><b>service</b></font>
│   │   │                       │       ├── ExpenditureService.java
│   │   │                       │       ├── <font color="#12488B"><b>iface</b></font>
│   │   │                       │       │   ├── IExpenditureService.java
│   │   │                       │       │   ├── IInvestmentService.java
│   │   │                       │       │   ├── ILoginService.java
│   │   │                       │       │   ├── IProfileService.java
│   │   │                       │       │   ├── IRevenueService.java
│   │   │                       │       │   ├── IService.java
│   │   │                       │       │   └── IUserService.java
│   │   │                       │       ├── InvestmentService.java
│   │   │                       │       ├── LoginService.java
│   │   │                       │       ├── RevenueService.java
│   │   │                       │       └── UserService.java
│   │   │                       ├── <font color="#12488B"><b>cross</b></font>
│   │   │                       │   ├── <font color="#12488B"><b>auth</b></font>
│   │   │                       │   │   └── JWT.java
│   │   │                       │   ├── <font color="#12488B"><b>crud</b></font>
│   │   │                       │   │   └── <font color="#12488B"><b>iface</b></font>
│   │   │                       │   │       ├── Delete.java
│   │   │                       │   │       ├── FindMany.java
│   │   │                       │   │       ├── FindOne.java
│   │   │                       │   │       ├── Save.java
│   │   │                       │   │       └── Update.java
│   │   │                       │   ├── <font color="#12488B"><b>excep</b></font>
│   │   │                       │   │   └── UserAuthenticateException.java
│   │   │                       │   ├── <font color="#12488B"><b>gson</b></font>
│   │   │                       │   │   ├── GsonWrapper.java
│   │   │                       │   │   ├── LocalDateDeserializer.java
│   │   │                       │   │   ├── LocalDateSerializer.java
│   │   │                       │   │   ├── LocalDateTimeDeserializer.java
│   │   │                       │   │   └── LocalDateTimeSerializer.java
│   │   │                       │   ├── <font color="#12488B"><b>mapper</b></font>
│   │   │                       │   │   ├── ExpenditureMapper.java
│   │   │                       │   │   ├── InvestmentMapper.java
│   │   │                       │   │   ├── RevenueMapper.java
│   │   │                       │   │   └── UserMapper.java
│   │   │                       │   └── <font color="#12488B"><b>util</b></font>
│   │   │                       │       ├── DateConverterHelper.java
│   │   │                       │       ├── ServletPrintWriterHelper.java
│   │   │                       │       └── StringUtils.java
│   │   │                       ├── <font color="#12488B"><b>domain</b></font>
│   │   │                       │   └── <font color="#12488B"><b>usecase</b></font>
│   │   │                       │       ├── FindExpenditureUseCase.java
│   │   │                       │       ├── FindInvestmentUseCase.java
│   │   │                       │       ├── FindRevenueUseCase.java
│   │   │                       │       ├── FindUserUseCase.java
│   │   │                       │       ├── <font color="#12488B"><b>iface</b></font>
│   │   │                       │       │   ├── <font color="#12488B"><b>expenditure</b></font>
│   │   │                       │       │   │   ├── IDeleteExpenditureUseCase.java
│   │   │                       │       │   │   ├── IFindExpenditureUseCase.java
│   │   │                    ´´´   │       │   │   ├── INewExpenditureUseCase.java
│   │   │                       │       │   │   └── IUpdateExpenditureUseCase.java
│   │   │                       │       │   ├── <font color="#12488B"><b>investment</b></font>
│   │   │                       │       │   │   ├── IDeleteInvestmentUseCase.java
│   │   │                       │       │   │   ├── IFindInvestmentUseCase.java
│   │   │                    ´´´   │       │   │   ├── INewInvestmentUseCase.java
│   │   │                       │       │   │   └── IUpdateInvestmentUseCase.java
│   │   │                       │       │   ├── <font color="#12488B"><b>login</b></font>
│   │   │                       │       │   │   └── ILoginUserCase.java
│   │   │                       │       │   ├── <font color="#12488B"><b>profile</b></font>
│   │   │                       │       │   │   ├── IDeleteProfilerUseCase.java
│   │   │                       │       │   │   ├── IFindProfileUseCase.java
│   │   │                       │       │   │   ├── INewProfileUseCase.java
│   │   │                       │       │   │   └── IUpdateProfileUseCase.java
│   │   │                       │       │   ├── <font color="#12488B"><b>revenue</b></font>
│   │   │                       │       │   │   ├── IDeleteRevenueUseCase.java
│   │   │                       │       │   │   ├── IFindRevenueUseCase.java
│   │   │                       │       │   │   ├── INewRevenueUseCase.java
│   │   │                       │       │   │   └── IUpdateRevenueUseCase.java
│   │   │                       │       │   └── <font color="#12488B"><b>user</b></font>
│   │   │                       │       │       ├── IDeleteUserUseCase.java
│   │   │                       │       │       ├── IFindUserUseCase.java
│   │   │                       │       │       ├── INewUserUseCase.java
│   │   │                       │       │       └── IUpdateUserUseCase.java
│   │   │                       │       ├── LoginUserCase.java
│   │   │                       │       ├── NewExpenditureUseCase.java
│   │   │                       │       ├── NewInvestmentUseCase.java
│   │   │                       │       ├── NewRevenueUseCase.java
│   │   │                       │       └── NewUserUseCase.java
│   │   │                       └── <font color="#12488B"><b>infradb</b></font>
│   │   │                           ├── <font color="#12488B"><b>model</b></font>
│   │   │                           │   ├── Expenditure.java
│   │   │                           │   ├── Investment.java
│   │   │                           │   ├── Profile.java
│   │   │                           │   ├── Revenue.java
│   │   │                           │   └── User.java
│   │   │                           └── <font color="#12488B"><b>repository</b></font>
│   │   │                               ├── <font color="#12488B"><b>database</b></font>
│   │   │                               │   └── <font color="#12488B"><b>factory</b></font>
│   │   │                               │       ├── <font color="#12488B"><b>oracle</b></font>
│   │   │                               │       │   └── DBConnectionFactory.java
│   │   │                               │       └── <font color="#12488B"><b>postgres</b></font>
│   │   │                               │           └── PostgresFactory.java
│   │   │                               ├── ExpenditureRepository.java
│   │   │                               ├── <font color="#12488B"><b>iface</b></font>
│   │   │                               │   ├── AbstractRepository.java
│   │   │                               │   └── Repository.java
│   │   │                               ├── InvestmentRepository.java
│   │   │                               ├── ProfileRepository.java
│   │   │                               ├── RevenueRepository.java
│   │   │                               └── UserRepository.java
│   │   ├── <font color="#12488B"><b>resources</b></font>
│   │   └── <font color="#12488B"><b>webapp</b></font>
│   │       ├── <font color="#12488B"><b>pages</b></font>
│   │       │   ├── <font color="#12488B"><b>assets</b></font>
│   │       │   │   ├── <font color="#A347BA"><b>error404.jpg</b></font>
│   │       │   │   └── <font color="#A347BA"><b>monkeysMoney.png</b></font>
│   │       │   ├── <font color="#12488B"><b>css</b></font>
│   │       │   │   ├── bootstrap.min.css
│   │       │   │   ├── fintech_config.css
│   │       │   │   ├── fintech.css
│   │       │   │   ├── fintech_custom.css
│   │       │   │   ├── fintech_global.css
│   │       │   │   └── fintech_responsive.css
│   │       │   ├── <font color="#12488B"><b>error</b></font>
│   │       │   │   ├── error401.jsp
│   │       │   │   └── error404.jsp
│   │       │   ├── forgot_password.jsp
│   │       │   ├── <font color="#12488B"><b>js</b></font>
│   │       │   │   ├── bootstrap.bundle.js
│   │       │   │   ├── bootstrap.bundle.js.map
│   │       │   │   ├── bootstrap.bundle.min.js
│   │       │   │   ├── bootstrap.bundle.min.js.map
│   │       │   │   ├── bootstrap.esm.js
│   │       │   │   ├── bootstrap.esm.js.map
│   │       │   │   ├── bootstrap.esm.min.js
│   │       │   │   ├── bootstrap.esm.min.js.map
│   │       │   │   ├── bootstrap.js
│   │       │   │   ├── bootstrap.js.map
│   │       │   │   ├── bootstrap.min.js
│   │       │   │   └── bootstrap.min.js.map
│   │       │   ├── <font color="#12488B"><b>protected</b></font>
│   │       │   │   └── ultimos_lancamentos.jsp
│   │       │   ├── signin.jsp
│   │       │   └── signup.jsp
│   │       └── <font color="#12488B"><b>WEB-INF</b></font>
│   │           └── web.xml
│   └── <font color="#12488B"><b>test</b></font>
│       ├── <font color="#12488B"><b>java</b></font>
│       │   └── <font color="#12488B"><b>br</b></font>
│       │       └── <font color="#12488B"><b>com</b></font>
│       │           └── <font color="#12488B"><b>fiap</b></font>
│       │               └── <font color="#12488B"><b>fintech</b></font>
│       │                   └── <font color="#12488B"><b>monkeys_money</b></font>
│       │                       └── <font color="#12488B"><b>cross</b></font>
│       │                           └── <font color="#12488B"><b>auth</b></font>
│       │                               └── JWTTest.java
│       └── <font color="#12488B"><b>resources</b></font>
└── <font color="#12488B"><b>target</b></font>
    ├── <font color="#12488B"><b>classes</b></font>
    │   └── <font color="#12488B"><b>br</b></font>
    │       └── <font color="#12488B"><b>com</b></font>
    │           └── <font color="#12488B"><b>fiap</b></font>
    │               └── <font color="#12488B"><b>fintech</b></font>
    │                   └── <font color="#12488B"><b>monkeys_money</b></font>
    │                       ├── <font color="#12488B"><b>app</b></font>
    │                       │   ├── <font color="#12488B"><b>controller</b></font>
    │                       │   │   ├── ExpenditureController.class
    │                       │   │   ├── <font color="#12488B"><b>iface</b></font>
    │                       │   │   │   └── IRestAPIOperation.class
    │                       │   │   ├── InvestmentController.class
    │                       │   │   ├── LoginController.class
    │                       │   │   ├── ProfileController.class
    │                       │   │   ├── RevenueController.class
    │                       │   │   └── UserController.class
    │                       │   ├── <font color="#12488B"><b>dto</b></font>
    │                       │   │   ├── <font color="#12488B"><b>error</b></font>
    │                       │   │   │   └── ErrorMessage.class
    │                       │   │   ├── <font color="#12488B"><b>request</b></font>
    │                       │   │   │   ├── ExpenditureRequest.class
    │                       │   │   │   ├── InvestmentRequest.class
    │                       │   │   │   ├── ProfileRequest.class
    │                       │   │   │   ├── RevenueRequest.class
    │                       │   │   │   └── UserRequest.class
    │                       │   │   └── <font color="#12488B"><b>response</b></font>
    │                       │   │       ├── ExpenditureResponse.class
    │                       │   │       ├── InvestmentResponse.class
    │                       │   │       ├── ProfileResponse.class
    │                       │   │       ├── RevenueResponse.class
    │                       │   │       ├── TokenResponse.class
    │                       │   │       └── UserResponse.class
    │                       │   └── <font color="#12488B"><b>service</b></font>
    │                       │       ├── ExpenditureService.class
    │                       │       ├── <font color="#12488B"><b>iface</b></font>
    │                       │       │   ├── IExpenditureService.class
    │                       │       │   ├── IInvestmentService.class
    │                       │       │   ├── ILoginService.class
    │                       │       │   ├── IProfileService.class
    │                       │       │   ├── IRevenueService.class
    │                       │       │   ├── IService.class
    │                       │       │   └── IUserService.class
    │                       │       ├── InvestmentService.class
    │                       │       ├── LoginService.class
    │                       │       ├── RevenueService.class
    │                       │       └── UserService.class
    │                       ├── <font color="#12488B"><b>cross</b></font>
    │                       │   ├── <font color="#12488B"><b>auth</b></font>
    │                       │   │   └── JWT.class
    │                       │   ├── <font color="#12488B"><b>crud</b></font>
    │                       │   │   └── <font color="#12488B"><b>iface</b></font>
    │                       │   │       ├── Delete.class
    │                       │   │       ├── FindMany.class
    │                       │   │       ├── FindOne.class
    │                       │   │       ├── Save.class
    │                       │   │       └── Update.class
    │                       │   ├── <font color="#12488B"><b>excep</b></font>
    │                       │   │   └── UserAuthenticateException.class
    │                       │   ├── <font color="#12488B"><b>gson</b></font>
    │                       │   │   ├── GsonWrapper.class
    │                       │   │   ├── LocalDateDeserializer.class
    │                       │´´´   │   ├── LocalDateSerializer.class
    │                       │   │   ├── LocalDateTimeDeserializer.class
    │                       │   │   └── LocalDateTimeSerializer.class
    │                       │   ├── <font color="#12488B"><b>mapper</b></font>
    │                       │   │   ├── ExpenditureMapper.class
    │                       │   │   ├── InvestmentMapper.class
    │                       │   │   ├── RevenueMapper.class
    │                       │   │   └── UserMapper.class
    │                       │   └── <font color="#12488B"><b>util</b></font>
    │                       │       ├── DateConverterHelper.class
    │                       │       ├── ServletPrintWriterHelper.class
    │                       │       └── StringUtils.class
    │                       ├── <font color="#12488B"><b>domain</b></font>
    │                       │   └── <font color="#12488B"><b>usecase</b></font>
    │                       │       ├── FindExpenditureUseCase.class
    │                       │       ├── FindInvestmentUseCase.class
    │                       │       ├── FindRevenueUseCase.class
    │                       │       ├── FindUserUseCase.class
    │                       │       ├── <font color="#12488B"><b>iface</b></font>
    │                       │       │   ├── <font color="#12488B"><b>expenditure</b></font>
    │                       │       │   │   ├── IDeleteExpenditureUseCase.class
    │                       │       │   │   ├── IFindExpenditureUseCase.class
    │                       │       │   │   ├── INewExpenditureUseCase.class
    │                       │       │   │   └── IUpdateExpenditureUseCase.class
    │                       │       │   ├── <font color="#12488B"><b>investment</b></font>
    │                       │       │   │   ├── IDeleteInvestmentUseCase.class
    │                       │       │   │   ├── IFindInvestmentUseCase.class
    │                       │       │   │   ├── INewInvestmentUseCase.class
    │                       │       │   │   └── IUpdateInvestmentUseCase.class
    │                       │       │   ├── <font color="#12488B"><b>login</b></font>
    │                       │       │   │   └── ILoginUserCase.class
    │                       │       │   ├── <font color="#12488B"><b>profile</b></font>
    │                       │       │   │   ├── IDeleteProfilerUseCase.class
    │                       │       │   │   ├── IFindProfileUseCase.class
    │                       │       │   │   ├── INewProfileUseCase.class
    │                       │       │   │   └── IUpdateProfileUseCase.class
    │                       │       │   ├── <font color="#12488B"><b>revenue</b></font>
    │                       │       │   │   ├── IDeleteRevenueUseCase.class
    │                       │       │   │   ├── IFindRevenueUseCase.class
    │                       │       │   │   ├── INewRevenueUseCase.class
    │                       │       │   │   └── IUpdateRevenueUseCase.class
    │                       │       │   └── <font color="#12488B"><b>user</b></font>
    │                       │       │       ├── IDeleteUserUseCase.class
    │                       │       │       ├── IFindUserUseCase.class
    │                       │       │       ├── INewUserUseCase.class
    │                       │       │       └── IUpdateUserUseCase.class
    │                       │       ├── LoginUserCase.class
    │                       │       ├── NewExpenditureUseCase.class
    │                       │       ├── NewInvestmentUseCase.class
    │                       │       ├── NewRevenueUseCase.class
    │                       │       └── NewUserUseCase.class
    │                       └── <font color="#12488B"><b>infradb</b></font>
    │                           ├── <font color="#12488B"><b>model</b></font>
    │                           │   ├── Expenditure.class
    │                           │   ├── Investment.class
    │                           │   ├── Profile.class
    │                           │   ├── Revenue.class
    │                           │   └── User.class
    │                           └── <font color="#12488B"><b>repository</b></font>
    │                               ├── <font color="#12488B"><b>database</b></font>
    │                               │   └── <font color="#12488B"><b>factory</b></font>
    │                               │       ├── <font color="#12488B"><b>oracle</b></font>
    │                               │       │   └── DBConnectionFactory.class
    │                               │       └── <font color="#12488B"><b>postgres</b></font>
    │                               │           └── PostgresFactory.class
    │                               ├── ExpenditureRepository.class
    │                               ├── <font color="#12488B"><b>iface</b></font>
    │                               │   ├── AbstractRepository.class
    │                               │   └── Repository.class
    │                               ├── InvestmentRepository.class
    │                               ├── ProfileRepository.class
    │                               ├── RevenueRepository.class
    │                               └── UserRepository.class
    ├── <font color="#12488B"><b>generated-sources</b></font>
    │   └── <font color="#12488B"><b>annotations</b></font>
    ├── <font color="#12488B"><b>generated-test-sources</b></font>
    │   └── <font color="#12488B"><b>test-annotations</b></font>
    ├── <font color="#12488B"><b>m2e-wtp</b></font>
    │   └── <font color="#12488B"><b>web-resources</b></font>
    │       └── <font color="#12488B"><b>META-INF</b></font>
    │           └── <font color="#12488B"><b>maven</b></font>
    │               └── <font color="#12488B"><b>br.com.fiap.fintech.monkeys_money</b></font>
    │                   └── <font color="#12488B"><b>monkeys-money</b></font>
    │                       ├── pom.properties
    │                       └── pom.xml
    └── <font color="#12488B"><b>test-classes</b></font>
        └── <font color="#12488B"><b>br</b></font>
            └── <font color="#12488B"><b>com</b></font>
                └── <font color="#12488B"><b>fiap</b></font>
                    └── <font color="#12488B"><b>fintech</b></font>
                        └── <font color="#12488B"><b>monkeys_money</b></font>
                            └── <font color="#12488B"><b>cross</b></font>
                                └── <font color="#12488B"><b>auth</b></font>
                                    └── JWTTest.class
</pre>
