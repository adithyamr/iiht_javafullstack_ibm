#View user details
select * from mysql.user;
select host, user, authentication_string, select_priv, create_priv, update_priv, delete_priv from mysql.user;

#Create user and Allow access to mysql_training schema from local machine
CREATE USER 'ibmfsd'@'localhost' IDENTIFIED BY 'ibmfsd';
GRANT ALL PRIVILEGES ON mysql_training.employee TO 'ibmfsd'@'localhost';
GRANT SELECT ON mysql_training.employee TO 'ibmfsd'@'localhost';
REVOKE SELECT ON mysql_training.employee FROM 'ibmfsd'@'localhost';

GRANT ALL ON mysql_training.* TO 'ibmfsd'@'localhost' WITH GRANT OPTION;  

#Allow access to mysql_training schema from all machines with access to create schema
CREATE USER 'ibmfsd'@'*' IDENTIFIED BY 'ibmfsd';
GRANT ALL ON mysql_training.* TO 'ibmfsd'@'*' WITH GRANT OPTION;

#Allow access to all schemas from all machines with access to create schema
CREATE USER 'ibmfsd'@'%' IDENTIFIED BY 'ibmfsd';
GRANT ALL PRIVILEGES ON *.* TO 'ibmfsd'@'%' IDENTIFIED BY 'ibmfsd' WITH GRANT OPTION;

#Revoke access for all schemas
REVOKE ALL PRIVILEGES ON mysql_training.* FROM 'ibmfsd'@'localhost';
REVOKE ALL PRIVILEGES ON *.* FROM 'ibmfsd'@'localhost';    
REVOKE ALL PRIVILEGES ON *.* FROM 'ibmfsd'@'%'; 

#Delete user
delete from mysql.user where user = 'ibmfsd'; 

select user();
select database();