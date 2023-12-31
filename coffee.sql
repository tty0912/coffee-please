SET TERMOUT ON
PROMPT Building coffee_plz tables. Please wait.
SET TERMOUT OFF

-- TABLE DROP
DROP TABLE BUYER CASCADE CONSTRAINTS;
DROP TABLE SELLER CASCADE CONSTRAINTS;
DROP TABLE CATEGORY CASCADE CONSTRAINTS;
DROP TABLE BEANS CASCADE CONSTRAINTS;
DROP TABLE CART CASCADE CONSTRAINTS;
DROP TABLE ORDER_PROD CASCADE CONSTRAINTS;
DROP TABLE ORDER_PROD_DETAIL CASCADE CONSTRAINTS;
DROP TABLE BEAN_LIKE CASCADE CONSTRAINTS;

-- SEQUENCE DROP
DROP SEQUENCE SQ_BEANS_NUM;

CREATE TABLE BUYER (
    BUYER_EMAIL VARCHAR2(50) CONSTRAINT NN_BUYER_EMAIL NOT NULL,
    BUYER_NAME VARCHAR2(20) CONSTRAINT NN_BUYER_NAME NOT NULL,
    NICKNAME VARCHAR2(30) CONSTRAINT NN_NICKNAME NOT NULL,
    PASSWD VARCHAR2(20) CONSTRAINT NN_BU_PASSWD NOT NULL,
    POINT NUMBER(10) DEFAULT 10000000,
    TEL VARCHAR2(20) CONSTRAINT NN_BU_TEL NOT NULL,
    REGDATE DATE DEFAULT SYSDATE CONSTRAINT NN_BU_REGDATE NOT NULL,
    BUYER_IMG VARCHAR2(100),
    ADR VARCHAR2(300) CONSTRAINT NN_BU_ADR NOT NULL,
    CONSTRAINT PK_BUYER_EMAIL PRIMARY KEY (BUYER_EMAIL),
    CONSTRAINT UQ_BU_NICKNAME UNIQUE (NICKNAME),
    CONSTRAINT UQ_BU_TEL UNIQUE (TEL)
);

CREATE TABLE SELLER (
    SELLER_EMAIL VARCHAR2(50) CONSTRAINT NN_SELLER_EMAIL NOT NULL,
    BUSINESS_NAME VARCHAR2(50) CONSTRAINT NN_BUSINESS_NAME NOT NULL,
    BUSINESS_NUM VARCHAR2(20) CONSTRAINT NN_BUSINESS_NUM NOT NULL,
    NICKNAME VARCHAR2(30) CONSTRAINT NN_SE_NICKNAME NOT NULL,
    PASSWD VARCHAR2(20) CONSTRAINT NN_SE_PASSWD NOT NULL,
    POINT NUMBER(10) DEFAULT 0,
    TEL VARCHAR2(20) CONSTRAINT NN_SE_TEL NOT NULL,
    REGDATE DATE DEFAULT SYSDATE CONSTRAINT NN_SE_REGDATE NOT NULL,
    SELLER_IMG VARCHAR2(100),
    ADR VARCHAR2(300) CONSTRAINT NN_SE_ADR NOT NULL,
    CONSTRAINT PK_SELLER_EMAIL PRIMARY KEY (SELLER_EMAIL),
    CONSTRAINT UQ_BUSINESS_NUM UNIQUE (BUSINESS_NUM),
    CONSTRAINT UQ_SE_NICKNAME UNIQUE (NICKNAME),
    CONSTRAINT UQ_SE_TEL UNIQUE (TEL)
);

CREATE TABLE CATEGORY (
    CATEGORY_NUM NUMBER(5) CONSTRAINT NN_CA_NUM NOT NULL,
    REF_CNUM NUMBER(5),
    C_NAME VARCHAR2(20) CONSTRAINT NN_C_NAME NOT NULL,
    CONSTRAINT PK_CATEGORY_NUM PRIMARY KEY (CATEGORY_NUM),
    CONSTRAINT UQ_C_NAME UNIQUE (C_NAME),
    CONSTRAINT FK_REF_CNUM FOREIGN KEY (REF_CNUM) REFERENCES CATEGORY (CATEGORY_NUM)
);

CREATE TABLE BEANS (
    BEANS_NUM NUMBER(6) CONSTRAINT NN_BE_NUM NOT NULL,
    BEANS_REGDATE DATE DEFAULT SYSDATE CONSTRAINT NN_BE_REGDATE NOT NULL,
    SELLER_EMAIL VARCHAR2(50) CONSTRAINT NN_BE_SELLER_EMAIL NOT NULL,
    CATEGORY_NUM NUMBER(5) CONSTRAINT NN_BE_CATEGORY_NUM NOT NULL,
    BEAN_NAME VARCHAR2(300) CONSTRAINT NN_BE_NAME NOT NULL,
    BEAN_PRICE NUMBER(8) CONSTRAINT NN_BE_PRICE NOT NULL,
    BEAN_IMG VARCHAR2(100) CONSTRAINT NN_BE_IMG NOT NULL,
    DESCRIPT VARCHAR2(100) CONSTRAINT NN_DESCRIPT NOT NULL,
    DELIVERY_CHARGE NUMBER(8) CONSTRAINT NN_DELIVERY_CHARGE NOT NULL,
    LIKE_COUNT NUMBER(8) DEFAULT 0 CONSTRAINT NN_LIKE_COUNT NOT NULL,
    DEADLINE DATE,
    GOAL_QTY NUMBER(8),
    GOAL_PRICE NUMBER(10),
    STATUS NUMBER(1) DEFAULT 0 CONSTRAINT NN_STATUS NOT NULL ,
    BEAN_TOTAL_SELCOUNT NUMBER(10) DEFAULT 0 CONSTRAINT NN_BE_TOTAL_SELCOUNT NOT NULL ,
    BEAN_THUMBNAIL VARCHAR2(100) CONSTRAINT NN_BE_THUMBNAIL NOT NULL,
    CONSTRAINT PK_BEANS_NUM PRIMARY KEY (BEANS_NUM),
    CONSTRAINT FK_SELLER_EMAIL FOREIGN KEY (SELLER_EMAIL) REFERENCES SELLER (SELLER_EMAIL),
    CONSTRAINT FK_CATEGORY_NUM FOREIGN KEY (CATEGORY_NUM) REFERENCES CATEGORY (CATEGORY_NUM)
);

CREATE TABLE CART (
    BUYER_EMAIL VARCHAR2(50) CONSTRAINT NN_CA_BUYER_EMAIL NOT NULL,
    BEANS_NUM NUMBER(6) CONSTRAINT NN_CA_BEANS_NUM NOT NULL,
    QTY NUMBER(5),
    CONSTRAINT PK_CART PRIMARY KEY (BUYER_EMAIL, BEANS_NUM),
    CONSTRAINT FK_BUYER_EMAIL_CART FOREIGN KEY (BUYER_EMAIL) REFERENCES BUYER (BUYER_EMAIL),
    CONSTRAINT FK_BEANS_NUM_CART FOREIGN KEY (BEANS_NUM) REFERENCES BEANS (BEANS_NUM)
);

CREATE TABLE ORDER_PROD (
    BUYER_EMAIL VARCHAR2(50) CONSTRAINT NN_OP_BUYER_EMAIL NOT NULL,
    ORDER_DATETIME DATE DEFAULT SYSDATE CONSTRAINT NN_OP_ORDER_DATETIME NOT NULL,
    ORDER_TOTAL_PRICE NUMBER(8) CONSTRAINT NN_OP_TOTAL_PRICE NOT NULL,
    BEFORE_ORDER_POINT NUMBER(8),
    CONSTRAINT PK_ORDER_PROD PRIMARY KEY (BUYER_EMAIL, ORDER_DATETIME),
    CONSTRAINT FK_BUYER_EMAIL_ORDER FOREIGN KEY (BUYER_EMAIL) REFERENCES BUYER (BUYER_EMAIL)
);

CREATE TABLE ORDER_PROD_DETAIL (
    BUYER_EMAIL VARCHAR2(50) CONSTRAINT NN_OPD_BUYER_EMAIL NOT NULL,
    ORDER_DATETIME DATE DEFAULT SYSDATE CONSTRAINT NN_OPD_ORDER_DATETIME NOT NULL,
    BEANS_NUM NUMBER(6) CONSTRAINT NN_OPD_BEANS_NUM NOT NULL,
    QTY NUMBER(5),
    CONSTRAINT PK_ORDER_PROD_DETAIL PRIMARY KEY (BUYER_EMAIL, ORDER_DATETIME, BEANS_NUM),
    CONSTRAINT FK_BUYER_EMAIL_OPD FOREIGN KEY (BUYER_EMAIL) REFERENCES BUYER (BUYER_EMAIL),
    CONSTRAINT FK_BEANS_NUM_OPD FOREIGN KEY (BEANS_NUM) REFERENCES BEANS (BEANS_NUM)
);

CREATE TABLE BEAN_LIKE (
    BUYER_EMAIL VARCHAR2(50) CONSTRAINT NN_BL_BUYER_EMAIL NOT NULL,
    BEANS_NUM NUMBER(6) CONSTRAINT NN_BL_BEANS_NUM NOT NULL,
    CONSTRAINT PK_LIKE PRIMARY KEY (BUYER_EMAIL, BEANS_NUM),
    CONSTRAINT FK_BUYER_EMAIL_LIKE FOREIGN KEY (BUYER_EMAIL) REFERENCES BUYER (BUYER_EMAIL),
    CONSTRAINT FK_BEANS_NUM_LIKE FOREIGN KEY (BEANS_NUM) REFERENCES BEANS (BEANS_NUM)
);

CREATE SEQUENCE SQ_BEANS_NUM
INCREMENT BY 1
START WITH 1
MINVALUE 1
MAXVALUE 999999
NOCYCLE;

COMMIT;

SET TERMOUT ON
PROMPT coffee_plz table build is complete.