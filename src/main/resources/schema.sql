CREATE TABLE IF NOT EXISTS `Train`(
  `id` INTEGER PRIMARY KEY,
  `train_name` VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `Boarding`(
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `train_number` INTEGER NOT NULL,
  `from_station` VARCHAR(255) NOT NULL,
  `to_station` VARCHAR(255) NOT NULL
);
ALTER TABLE `Boarding`ADD FOREIGN KEY (train_number) REFERENCES `Train` (id);

CREATE TABLE IF NOT EXISTS `Sections`(
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `train_number` INTEGER NOT NULL,
  `section_name` CHAR(2) NOT NULL,
  `seat_number` INTEGER NOT NULL
);
ALTER TABLE `Sections`ADD FOREIGN KEY (train_number) REFERENCES `Train` (id);

CREATE TABLE IF NOT EXISTS `Person`(
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `email_address` VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS `Receipt`(
  `receipt_id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `user_id`INTEGER NOT NULL,
  `from_station` VARCHAR(255) NOT NULL,
  `to_station` VARCHAR(255) NOT NULL,
  `price` DOUBLE NOT NULL
);

ALTER TABLE `Receipt`ADD FOREIGN KEY (user_id) REFERENCES `Person` (id);


CREATE TABLE IF NOT EXISTS `Booking`(
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `receipt_id` INTEGER NOT NULL,
  `section_name` CHAR(2) NOT NULL,
  `seat_number` INTEGER NOT NULL
);
ALTER TABLE `Booking`ADD FOREIGN KEY (receipt_id) REFERENCES `Receipt` (receipt_id);