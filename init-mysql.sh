/home/sicemal/mysql-5.7.44-linux-glibc2.12-x86_64

mkdir /home/sicemal/mysql
mkdir /home/sicemal/mysql/data
/home/sicemal/mysql-5.7.44-linux-glibc2.12-x86_64/bin/mysqld --initialize --user=mysql --basedir=/home/sicemal/mysql --datadir=/home/sicemal/mysql/data


sudo apt update
sudo apt install mysql-server -y
mysql --version



mysql> CREATE TABLE sample_table (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(255) NOT NULL,
         description TEXT,
         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
         );
         
mysql> CREATE TABLE user (
         id INT AUTO_INCREMENT PRIMARY KEY,
         name VARCHAR(255) NOT NULL,
         description TEXT,
         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
         );         
         

mysql> INSERT INTO sample_table (name, description) VALUES 
       ('Sample Item 1', 'This is the first sample item.'),
       ('Sample Item 2', 'This is the second sample item.'),
       ('Sample Item 3', 'This is the third sample item.');
       
mysql> SELECT * FROM sample_table;
       
       
REMOVE MYSQL:
sudo apt remove --purge mysql-server
sudo apt purge mysql-server
sudo apt autoremove
sudo apt autoclean
sudo apt remove dbconfig-mysql

sudo apt install mysql-server -y

sudo mysql -u root -p

mysql> USE mysql;
mysql> UPDATE user SET plugin='mysql_native_password' WHERE User='root';
mysql> FLUSH PRIVILEGES;
mysql> exit;

sudo service mysql restart


BACKUP MYSQL:
mysqldump -uroot -p --databases db000 > db000.sql


--OR--
sudo mysql -u root # I had to use "sudo" since it was a new installation

mysql> USE mysql;
mysql> CREATE USER 'YOUR_SYSTEM_USER'@'localhost' IDENTIFIED BY '1234';
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY '1234';
mysql> GRANT ALL PRIVILEGES ON *.* TO 'YOUR_SYSTEM_USER'@'localhost';
mysql> UPDATE user SET plugin='auth_socket' WHERE User='YOUR_SYSTEM_USER';
mysql> FLUSH PRIVILEGES;
mysql> exit;

sudo service mysql restart

GRANT ALL PRIVILEGES ON * TO 'root'@'localhost';
FLUSH PRIVILEGES;

ALTER USER 'root'@'localhost' IDENTIFIED BY '1234';

         
Enable MySQL to automatically start at boot time.
sudo systemctl enable mysql

sudo systemctl start mysql
sudo systemctl status mysql

Secure the MySQL Server
sudo mysql_secure_installation
                
ALTER DATABASE <database_name> CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
ALTER TABLE <table_name> CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
ALTER TABLE <table_name> MODIFY <column_name> VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;


How to convert all tables in database to one collation?
ALTER TABLE tbl_name
[[DEFAULT] CHARACTER SET charset_name]
[COLLATE collation_name]

SELECT * 
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_SCHEMA="db000"
AND TABLE_TYPE="BASE TABLE";

CREATE TEMPORARY TABLE IF NOT EXISTS change_colation AS (SELECT CONCAT("ALTER TABLE ", TABLE_SCHEMA, '.', TABLE_NAME," COLLATE your_collation_name_here;") AS ExecuteTheString
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_SCHEMA="db000"
AND TABLE_TYPE="BASE TABLE");

ALTER TABLE IF NOT EXISTS (SELECT CONCAT("ALTER TABLE ", TABLE_SCHEMA, '.', TABLE_NAME," COLLATE your_collation_name_here;)

                
         
