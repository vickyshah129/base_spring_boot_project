CREATE TABLE `auth_server`.`permission` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `enabled` BIT NULL,
  `archived` BIT NULL,
  `created_by` BIGINT NULL,
  `date_creation` TIMESTAMP NULL,
  `date_archive` TIMESTAMP NULL,
  `date_update` TIMESTAMP NULL,
  PRIMARY KEY (`id`));
