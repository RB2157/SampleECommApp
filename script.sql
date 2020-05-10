CREATE DATABASE SampleEcommApp;

USE SampleEcommApp;

CREATE TABLE Items (
    item_id BIGINT PRIMARY KEY NOT NULL,
    item_desc VARCHAR(200),
    item_quantity INTEGER,
    item_price DOUBLE
);
 
CREATE TABLE Orders (
    order_id BIGINT,
    email_id VARCHAR(200),
    item_id BIGINT,
    order_quantity INTEGER
);


