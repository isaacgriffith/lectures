create schema test_db;

use test_db;

CREATE TABLE customers (
  id                INTEGER NOT NULL PRIMARY KEY Auto_Increment,
  name              VARCHAR(25) NOT NULL,
  address           VARCHAR(30),
  city              VARCHAR(20),
  state             VARCHAR(2),
  postal_code       VARCHAR(9),
  created_at        DATETIME,
  updated_at        DATETIME
);

CREATE TABLE orders (
  id                INTEGER NOT NULL PRIMARY KEY Auto_Increment,
  date              DATETIME NOT NULL,
  customer_id       INTEGER REFERENCES customers (customer_id),
  created_at        DATETIME,
  updated_at        DATETIME
);

CREATE TABLE products (
  id                INTEGER NOT NULL PRIMARY KEY Auto_Increment,
  description       VARCHAR(50),
  finish            VARCHAR(20),
  price             DECIMAL(6,2),
  product_line_id   INTEGER,
  created_at        DATETIME,
  updated_at        DATETIME
);

CREATE TABLE order_lines (
  id                INTEGER NOT NULL PRIMARY KEY Auto_Increment,
  order_id          INTEGER NOT NULL REFERENCES orders (order_id),
  product_id        INTEGER NOT NULL REFERENCES products (product_id),
  quantity          INTEGER,
  created_at        DATETIME,
  updated_at        DATETIME
);