CREATE DATABASE IF NOT EXISTS db_book_service;
CREATE DATABASE IF NOT EXISTS db_loan_service;
CREATE DATABASE IF NOT EXISTS db_user_service;
-- Tambahkan database lain jika diperlukan
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'root';
CREATE USER 'root'@'%' IDENTIFIED BY 'root';
