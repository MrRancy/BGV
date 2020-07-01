Follow these Initial Steps to get your tables created and initial data fed.

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



