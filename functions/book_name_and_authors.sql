USE `yuriichuk_7_72`;
DROP function IF EXISTS `book_name_and_authors`;

USE `yuriichuk_7_72`;
DROP function IF EXISTS `yuriichuk_7_72`.`book_name_and_authors`;
;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER=`root`@`localhost` FUNCTION `book_name_and_authors`(
	in_id INT) RETURNS VARCHAR(90)
    READS SQL DATA
BEGIN
	DECLARE info VARCHAR(90);
    SELECT CONCAT(name, ' - ', authors) INTO info FROM book
    WHERE id = in_id;
RETURN info;
END$$

DELIMITER ;
;

