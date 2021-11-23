USE `yuriichuk_7_72`;
DROP procedure IF EXISTS `select_user_and_book`;

USE `yuriichuk_7_72`;
DROP procedure IF EXISTS `yuriichuk_7_72`.`select_user_and_book`;
;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `select_user_and_book`(
	IN in_substring_in_name VARCHAR(45))
BEGIN
	IF in_substring_in_name IS NULL
		THEN SET in_substring_in_name = '';
    END IF;
    
    SELECT CONCAT(first_name, ' ', second_name) AS user, name
    FROM users
    JOIN bookmark ON users.id = user_id
    JOIN book ON book.id = book_id
    WHERE name LIKE CONCAT('%', in_substring_in_name, '%');
END$$

DELIMITER ;