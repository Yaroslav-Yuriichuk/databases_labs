SET SQL_SAFE_UPDATES = 0;
USE yuriichuk_7_72;


CALL clear_tables();


CALL insert_into_passwords('qwerty123');
CALL insert_into_passwords('qwerty');
CALL insert_into_passwords('123456');
CALL insert_into_passwords('111111');
CALL insert_into_passwords('pass');
CALL insert_into_passwords('password');
CALL insert_into_passwords('pass1234');


CALL insert_into_users('homie1', 'Ivan', 'Smith', 'Ivanovych', '2000.12.12',
	'Lviv', 'Lviv', 'Hello!', 8.5, 1);
CALL insert_into_users('homie2', 'Petro', 'Williams', 'Maksymovych', '1999.12.23',
	'Lviv', 'Lviv', "What's up?", 7.8, 2);
CALL insert_into_users('homie3', 'Kolia', 'Brown', 'Petrovych', '2000.12.12',
	'Lviv', 'Lviv', 'Hi!', 6.9, 3);
CALL insert_into_users('homie4', 'Artur', 'Jones', 'Mykolaiovych', '2000.12.12',
	'Lviv', 'Lviv', 'Hey!', 9.2, 4);
CALL insert_into_users('homie5', 'Sasha', 'Miller', 'Ivanovych', '2000.12.12',
	'Lviv', 'Lviv', 'Wassup!', 8.2, 5);
CALL insert_into_users('homie6', 'Erik', 'Johnson', 'Oleksandrovych', '2000.12.12',
	'Lviv', 'Lviv', "What's popping!", 8.6, 6);
CALL insert_into_users('homie7', 'Oleg', 'Garcia', 'Petrovych', '2000.12.12',
	'Lviv', 'Lviv', 'Hello!', 8.9, 7);
    

/*CALL insert_into_book('Harry Potter and the Deathly Hallows', 'Rowling J.K.', 9.1, 1);*/
CALL insert_into_book('Book1', 'Author1', 6.7, 1);
CALL insert_into_book('Book2', 'Author2, Author3', 8.5, 2);
CALL insert_into_book('Book3', 'Author3', 7.7, 1);
CALL insert_into_book('Book4', 'Author4', 9.1, 3);
CALL insert_into_book('Book5', 'Author5, Author1', 8.1, 2);
CALL insert_into_book('Book6', 'Author6, Author1', 6.9, 3);
CALL insert_into_book('Book7', 'Author7, Author3', 7.9, 1);
CALL insert_into_book('Book8', 'Author8, Author3', 7.7, 3);
CALL insert_into_book('Book9', 'Author2, Author3', 9.1, 3);
CALL insert_into_book('Book10', 'Author4, Author8', 8.2, 1);


CALL insert_into_link('www.vbdskbjkvds.com', 1);
CALL insert_into_link('www.vsdkjds.com', 2);
CALL insert_into_link('www.klknsvd.com', 3);
CALL insert_into_link('www.qwkvesd.com', 4);
CALL insert_into_link('www.pinvds.com', 5);
CALL insert_into_link('www.lsdnvvdssd.com', 6);
CALL insert_into_link('www.tterdvxas.com', 7);
CALL insert_into_link('www.mhbvsdosdv.com', 8);
CALL insert_into_link('www.asceimlvds.com', 9);
CALL insert_into_link('www.xdviivlnsd.com', 10);
CALL insert_into_link('www.mllsdvsedf.com', 1);
CALL insert_into_link('www.ewvnslllnv.com', 3);
CALL insert_into_link('www.lvbdsyiiubds.com', 4);
CALL insert_into_link('www.sbcbkjvdd.com', 7);
CALL insert_into_link('www.xdsvnivpsd.com', 8);


CALL insert_into_bookmark(1, 1);
CALL insert_into_bookmark(2, 3);
CALL insert_into_bookmark(3, 4);
CALL insert_into_bookmark(4, 6);
CALL insert_into_bookmark(5, 8);
CALL insert_into_bookmark(6, 9);
CALL insert_into_bookmark(7, 10);
CALL insert_into_bookmark(1, 2);
CALL insert_into_bookmark(3, 5);
CALL insert_into_bookmark(4, 7);
CALL insert_into_bookmark(6, 3);
CALL insert_into_bookmark(4, 4);
CALL insert_into_bookmark(7, 9);


CALL insert_into_catalog_tree('Heading 1', 1);
CALL insert_into_catalog_tree('Heading 2', 1);
CALL insert_into_catalog_tree('Heading 3', 1);
CALL insert_into_catalog_tree('Heading 4', 2);
CALL insert_into_catalog_tree('Heading 5', 4);
CALL insert_into_catalog_tree('Heading 6', 3);
CALL insert_into_catalog_tree('Heading 7', 5);
CALL insert_into_catalog_tree('Heading 8', 5);