DROP TABLE IF EXISTS BOOK;
DROP TABLE IF EXISTS AUTHOR;
CREATE TABLE AUTHOR
(
                       author_id BIGINT NOT NULL PRIMARY KEY,
                       name VARCHAR(255)
);
CREATE TABLE BOOK
(
                     book_id BIGINT NOT NULL PRIMARY KEY,
                     name VARCHAR(255),
                     author_id BIGINT references AUTHOR(author_id)
);
