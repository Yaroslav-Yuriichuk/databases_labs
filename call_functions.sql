SELECT initials(first_name, second_name, middle_name) AS initials FROM users;

SELECT id, book_email_address, book_name_and_authors(book_id) FROM link;