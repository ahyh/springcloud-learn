CREATE TABLE `payment` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `serial` VARCHAR(13) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci