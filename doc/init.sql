
-- 创建sellGoods表
CREATE TABLE IF NOT EXISTS `products` (
	`id` INT UNSIGNED AUTO_INCREMENT,
	`sellerId` INT UNSIGNED NOT NULL,
	`name` VARCHAR(20) NOT NULL,
	`img` VARCHAR(80) NOT NULL,
	`dscp` VARCHAR(200) NOT NULL,
	`price` FLOAT NOT NULL,
	`count` INT NOT NULL,
	PRIMARY KEY(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 插入seller
-- INSERT INTO seller(name,userName,password)VALUES('seller1','seller1','123456');




