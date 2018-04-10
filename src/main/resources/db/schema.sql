CREATE TABLE IF NOT EXISTS `title` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `pid` BIGINT(20) NOT NULL,
  `name` VARCHAR(200) NOT NULL DEFAULT '',
  `open` TINYINT NOT NULL DEFAULT 0,
  `create_time` DATETIME NOT NULL,
  `modify_time` DATETIME NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE IF NOT EXISTS `content` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `title_id` BIGINT(20) NOT NULL,
  `contents` VARCHAR(5000) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `unq_content_title_id` (`title_id` ASC));
  
--  INSERT INTO `title` (`id`, `pid`, `name`, `open`, `create_time`, `modify_time`) VALUES (1, 0, '分类1', true, '2018-04-09 20:52:00', NULL);
--  INSERT INTO `title` (`id`, `pid`, `name`, `open`, `create_time`, `modify_time`) VALUES (2, 1, 'note1', false, '2018-04-09 20:52:00', NULL);
--  INSERT INTO `title` (`id`, `pid`, `name`, `open`, `create_time`, `modify_time`) VALUES (3, 1, 'note2', false, '2018-04-09 20:52:00', NULL);
--  INSERT INTO `title` (`id`, `pid`, `name`, `open`, `create_time`, `modify_time`) VALUES (4, 0, '分类2', true, '2018-04-09 20:52:00', NULL);
--  INSERT INTO `title` (`id`, `pid`, `name`, `open`, `create_time`, `modify_time`) VALUES (5, 4, 'note3', false, '2018-04-09 20:52:00', NULL);
--  INSERT INTO `title` (`id`, `pid`, `name`, `open`, `create_time`, `modify_time`) VALUES (6, 0, '分类3', true, '2018-04-09 20:52:00', NULL);
  
--  INSERT INTO `content` (`id`, `title_id`, `contents`) VALUES (1, 2, 'fadfsdfs');
--  INSERT INTO `content` (`id`, `title_id`, `contents`) VALUES (2, 3, 'xvvcxzvcxvxz');
--  INSERT INTO `content` (`id`, `title_id`, `contents`) VALUES (3, 5, 'sdffdssfsddfsdfsdfsdfsdfsdfsdf');