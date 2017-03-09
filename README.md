# Accounts and Data Management

A small Java based application to manage data from different accounts.

### Database
1. Install JDBC Driver (MySQL Database is used in this Project so [MySQL Connector](https://dev.mysql.com/downloads/connector/j/) is used).
2. Create database 'adm'.
3. Create table  with following command : 
   '''
          CREATE TABLE products
              (
                P_ID INT(11) PRIMARY KEY NOT NULL,
                name VARCHAR(50) NOT NULL,
                cost FLOAT NOT NULL
              );
    '''

### About files
1. Main - It is the application launcher
2. LoginController - Manages login after application starts.
3. DataView - A single table based file to show data from any account.
4. Accounts - A page where we can select and make new accounts (yet to add functionality)
5. Customer and Products are sample accounts to be made.

### Targets
1. Changes in Accounts file so that we can select account to view data.
2. We can also make new Account by taking input for account and adding a .java file for it and re-compiling the code. Also we have to add that account to the database.
3. UI needs improvements.
