USE `yuriichuk_7_72`;
DROP procedure IF EXISTS `shuffle_books`;

USE `yuriichuk_7_72`;
DROP procedure IF EXISTS `yuriichuk_7_72`.`shuffle_books`;
;

DELIMITER $$
USE `yuriichuk_7_72`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `shuffle_books`()
BEGIN
	DECLARE done BOOL DEFAULT FALSE;
    DECLARE c_id INT;
    DECLARE c_name VARCHAR(45);
    DECLARE c_author VARCHAR(45);
    DECLARE c_rating DECIMAL(4, 2);
    DECLARE c_catalog_tree_id INT;
    DECLARE book_cursor CURSOR FOR SELECT * FROM book;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    SET @current_date = CURDATE();
    SET @current_time = CURTIME();
    SET @table1_name = CONCAT('distributed_table_1_', @current_date,'-', @current_time);
    SET @table2_name = CONCAT('distributed_table_2_', @current_date,'-', @current_time);
    SET @CREATE_TABLE_STATEMENT = "CREATE TABLE IF NOT EXISTS `";
    SET @TABLE_COLUMNS = "` (
		  `id` INT NOT NULL AUTO_INCREMENT,
		  `name` VARCHAR(45) NOT NULL,
		  `author` VARCHAR(45) NOT NULL,
		  `rating` DECIMAL(4,2) NOT NULL,
		  `catalog_tree_id` INT NOT NULL,
		  PRIMARY KEY (`id`))
		ENGINE = InnoDB;";
        
    SET @create_table1_query = CONCAT(
		@CREATE_TABLE_STATEMENT,
        @table1_name,
        @TABLE_COLUMNS);
    PREPARE statement FROM @create_table1_query;
    EXECUTE statement;
    DEALLOCATE PREPARE statement;
    
    SET @create_table2_query = CONCAT(
		@CREATE_TABLE_STATEMENT,
        @table2_name,
        @TABLE_COLUMNS);
    PREPARE statement FROM @create_table2_query;
    EXECUTE statement;
    DEALLOCATE PREPARE statement;
    
    OPEN book_cursor;
    label: LOOP
		FETCH book_cursor INTO c_id, c_name, c_author, c_rating, c_catalog_tree_id;
		IF done THEN LEAVE label;
        END IF;
        IF RAND() <= 0.5 THEN
			SET @table_name_to_insert = @table1_name;
        ELSE
			SET @table_name_to_insert = @table2_name;
        END IF;    
        SET @insert_query = CONCAT(
			"INSERT INTO `", @table_name_to_insert,
            "` (
				`name`,
				`author`,
				`rating`,
				`catalog_tree_id`)
			VALUES (",
				CONCAT("'", c_name, "', "),
				CONCAT("'", c_author, "', "),
				CONCAT("'", c_rating, "', "),
				CONCAT("'", c_catalog_tree_id, "'"), ");");
                
		PREPARE statement FROM @insert_query;
        EXECUTE STATEMENT;
        DEALLOCATE PREPARE statement;
    END LOOP;
    
    CLOSE book_cursor;
END$$

DELIMITER ;
;

