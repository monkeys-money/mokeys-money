
-- system_user
CREATE SEQUENCE user_id_seq
INCREMENT 1
START 1;

CREATE TABLE IF NOT EXISTS system_user(
    id           NUMERIC(10)   PRIMARY KEY DEFAULT NEXTVAL('user_id_seq'),
    email        VARCHAR(255)  NOT NULL,
    password     VARCHAR(255)  NOT NULL,
    enabled      BOOLEAN       NOT NULL,
    created_at   TIMESTAMP     NOT NULL,
    updated_at   TIMESTAMP     NULL,
    UNIQUE(email)
);


-- profile
CREATE SEQUENCE profile_id_seq
INCREMENT 1
START 1;

CREATE TABLE IF NOT EXISTS profile(
    id          NUMERIC(10)  PRIMARY KEY DEFAULT NEXTVAL('profile_id_seq'),
    user_id     NUMERIC(10)  NOT NULL,
    first_name  VARCHAR(150) NOT NULL,
    middle_name VARCHAR(80)  NOT NULL,
    last_name   VARCHAR(80)  NOT NULL,
    born_at     DATE         NOT NULL,
    gender      VARCHAR(80)  NOT NULL,
    created_at   TIMESTAMP    NOT NULL,
    updated_at  TIMESTAMP    NULL,
    CONSTRAINT fk_system_user_profile
      FOREIGN KEY(user_id) 
	  REFERENCES system_user(id)
);

-- expenditure
CREATE SEQUENCE expediture_id_seq
INCREMENT 1
START 1;

CREATE TABLE IF NOT EXISTS expenditure(
    id             NUMERIC(10)   PRIMARY KEY DEFAULT NEXTVAL('profile_id_seq'),
    user_id        NUMERIC(10)   NOT NULL,
    expenditure     VARCHAR(150)  NOT NULL,
    description    VARCHAR(255)  NOT NULL,
    amount         NUMERIC(19,4) NOT NULL,
    expenditure_at TIMESTAMP     NOT NULL,
    created_at      TIMESTAMP     NOT NULL,
    updated_at     TIMESTAMP     NULL,
    CONSTRAINT fk_system_user_expenditure
      FOREIGN KEY(user_id) 
	  REFERENCES system_user(id)
);

-- revenue
CREATE SEQUENCE revenue_id_seq
INCREMENT 1
START 1;

CREATE TABLE IF NOT EXISTS revenue(
    id             NUMERIC(10)   PRIMARY KEY DEFAULT NEXTVAL('revenue_id_seq'),
    user_id        NUMERIC(10)   NOT NULL,
    revenue        VARCHAR(150)  NOT NULL,
    description    VARCHAR(255)  NOT NULL,
    amount         NUMERIC(19,4) NOT NULL,
    revenue_at     TIMESTAMP     NOT NULL,
    created_at      TIMESTAMP     NOT NULL,
    updated_at     TIMESTAMP     NULL,
    CONSTRAINT fk_system_user_revenue
      FOREIGN KEY(user_id) 
	  REFERENCES system_user(id)
);

-- investment
CREATE SEQUENCE investment_id_seq
INCREMENT 1
START 1;

CREATE TABLE IF NOT EXISTS investment(
    id             NUMERIC(10)   PRIMARY KEY DEFAULT NEXTVAL('investment_id_seq'),
    user_id        NUMERIC(10)   NOT NULL,
    investment     VARCHAR(150)  NOT NULL,
    description    VARCHAR(255)  NOT NULL,
    amount         NUMERIC(19,4) NOT NULL,
    investment_at  TIMESTAMP     NOT NULL,
    created_at      TIMESTAMP     NOT NULL,
    updated_at     TIMESTAMP     NULL,
    CONSTRAINT fk_system_user_investment
      FOREIGN KEY(user_id) 
	  REFERENCES system_user(id)
);