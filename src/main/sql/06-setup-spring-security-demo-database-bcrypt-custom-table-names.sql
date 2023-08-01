USE `employee_directory`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;

--
-- Table structure for table `members`
--

CREATE TABLE `members` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `members`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.luv2code.com/generate-bcrypt-password
--
-- Default passwords here are: fun123
--

INSERT INTO `members`
VALUES
(1,'john','$2a$10$0Lxsjt64UrfDTxBhb8cQ.OBoGSaTjZz36FYPujvqu8oXoyxfuxjhK',1),
(2,'mary','$2a$10$0Lxsjt64UrfDTxBhb8cQ.OBoGSaTjZz36FYPujvqu8oXoyxfuxjhK',1),
(3,'susan','$2a$10$0Lxsjt64UrfDTxBhb8cQ.OBoGSaTjZz36FYPujvqu8oXoyxfuxjhK',1);


--
-- Table structure for table `authorities`
--


CREATE TABLE `roles` (
  `user_id` int NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `roles`
--

INSERT INTO `roles`
VALUES
(1,'ROLE_EMPLOYEE'),
(2,'ROLE_EMPLOYEE'),
(2,'ROLE_MANAGER'),
(3,'ROLE_EMPLOYEE'),
(3,'ROLE_MANAGER'),
(3,'ROLE_ADMIN');
