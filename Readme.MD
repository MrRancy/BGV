# Welcome to Background Verification Check!

This Project was intentionally made for development and practice purpose only, anyone can go ahead and clone this project, modify, add new features.
Forking is considered to be the best option. Please fork.
> **Note** : Future enhancements for the updated UI and operations will be coming soon.

## Required applications:

-  Java v8 or above (this project was compiled on v13).
-  Eclipse J2EE (Suggested because it comes with all the required internal dependencies. Please choose J2EE while installing eclipse)
-  SQL Workbench v8.0 or above (this project was compiled on v8)
    While installing SQL make sure your copy the **username** and **password** to a safe location, which we will be requiring later.
- Any browser.

#### 1. Open SQL Workbench and follow these Initial Steps to get your tables created and initial data fed.

```

    `CREATE TABLE `users` (
    `user_id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    `username` varchar(45) NOT NULL,
    `password` varchar(64) NOT NULL,
    `enabled` tinyint(4) DEFAULT NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `username_UNIQUE` (`username`)
    );

    CREATE TABLE `roles` (
    `role_id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(45) NOT NULL,
    PRIMARY KEY (`role_id`)
    );

    CREATE TABLE `users_roles` (
    `user_id` int(11) NOT NULL,
    `role_id` int(11) NOT NULL,
    KEY `user_fk_idx` (`user_id`),
    KEY `role_fk_idx` (`role_id`),
    CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
    CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
    );

    CREATE TABLE `request` (
    `request_id` int(11) NOT NULL AUTO_INCREMENT,
    `company_name1` varchar(45) NOT NULL,
    `doj1` varchar(45) NOT NULL,
    `lwd1` varchar(45) NOT NULL,
    `address1` varchar(225) NOT NULL,
    `company_name2` varchar(45) NOT NULL,
    `doj2` varchar(45) NOT NULL,
    `lwd2` varchar(45) NOT NULL,
    `address2` varchar(225) NOT NULL,
    `highest_degree` varchar(45) NOT NULL,
    `college` varchar(45) NOT NULL,
    `year` varchar(45) NOT NULL,
    `status` varchar(45) NOT NULL,
    `date_submitted` varchar(10) NOT NULL,
    PRIMARY KEY (`request_id`)
    );

    CREATE TABLE `request_user` (
    `user_id` int(11) NOT NULL,
    `request_id` int(11) NOT NULL,
    KEY `user_fk_idx` (`user_id`),
    KEY `request_fk_idx` (`request_id`),
    CONSTRAINT `user_req_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`),
    CONSTRAINT `request_fk` FOREIGN KEY (`request_id`) REFERENCES `request` (`request_id`)
    );

    INSERT INTO `roles` (`name`) VALUES ('USER');
    INSERT INTO `roles` (`name`) VALUES ('ADMIN');

    INSERT INTO `users` (`username`, `name`, `password`, `enabled`) VALUES ('123456', 'Ram', '$2a$10$tNslbySo5WhRCb4mSYKHEeGi5kBL5A3bfLzIPRzS4Q9wFukrNTGfC', '1');
    INSERT INTO `users` (`username`, `name`, `password`, `enabled`) VALUES ('654321', 'Sam', '$2a$10$tNslbySo5WhRCb4mSYKHEeGi5kBL5A3bfLzIPRzS4Q9wFukrNTGfC', '1');
    INSERT INTO `users` (`username`, `name`, `password`, `enabled`) VALUES ('admin', 'Admin', '$2a$10$tNslbySo5WhRCb4mSYKHEeGi5kBL5A3bfLzIPRzS4Q9wFukrNTGfC', '1');

    INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (1, 1);
    INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (2, 1);
    INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES (3, 2);

```

Your can alternatively run the SQL Script to get everything done automatically.

```
    File is located in the root directory of this project named as SQL_Statements.sql
```

#### 2. Import the project in Eclipse as a Maven project

```
    File >> Import... >> Existing Maven Projects (You can get this option by searching maven)

    Now in the Root Directory >> Click Browse... >> Select the location of the project where pom.xml is there (usually in the root location). >> Finish

    After Successfull Import, wait for a couple of minutes for the project to automatically download all the required dependencies.
```

#### 3. Change DB configurations

```
    Follow this path to get the file location

    BGV >> Java Resources >> src/java/resource >> application.properties

    In this file change the following parameters to your MySQL Local Server
    
    for example;
    spring.datasource.url=jdbc:mysql://localhost:3306/bgv
    spring.datasource.username=root 
    spring.datasource.password=Password!@#456
```

#### 4. Install Spring Boot Tool in Eclipse

```
    Go to Help >> Eclipse Marketplace >> Search

    Next to Find, search for Spring Tools

    You should be seeing Spring Tools 4 (aka Spring Tool Suite 4) 4.7.0.RELEASE

    You will find install button, go ahead and complete the installation by accepting all the terms and conditions.

    Now you will be having Spring boot installed in your Eclipse

    ** Restart may be needed
```

#### 5. Run the Application

```
    Right click on the BGV Application >> Run As >> Spring Boot App

    If no errors were found the app should be running successfully and you should see some output like this.

    INFO 7160 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
    INFO 7160 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    INFO 7160 --- [  restartedMain] com.wipro.BackgroundVerificationCheck    : Started BackgroundVerificationCheck in 2.729 seconds (JVM running for 3.399)
```

#### 6. Use these Credentials here after to test the application

```
    For Admin:
        username:admin      password:wipro@123
    For User:
        username:123456     Passwrod:wipro@123
        username:654321     Passwrod:wipro@123
```

Happy Developing,
***MrRancy***