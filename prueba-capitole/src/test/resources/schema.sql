

CREATE TABLE IF not EXISTS PRICES 
(
    BRAND_ID int not null,
    START_DATE  TIMESTAMP  not null,
    END_DATE TIMESTAMP  not null,
    PRICE_LIST int not null,
    PRODUCT_ID int not null,
    PRIORITY int not null,
    PRICE numeric(20,2) not null,
    CURR varchar(10) not null
);
	
