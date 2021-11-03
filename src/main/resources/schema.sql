DROP TABLE IF EXISTS BOOK;
DROP TABLE IF EXISTS AUTHOR;
CREATE TABLE AUTHOR(
                       ID BIGINT,
                       NAME VARCHAR(255),
                       primary key (ID)
);
CREATE TABLE BOOK(
                     ID BIGINT,
                     NAME VARCHAR(255),
                     FK_AUTHOR_ID BIGINT,
                     primary key (ID),
                     foreign key (FK_AUTHOR_ID) references AUTHOR(ID)
);
