--
-- File generated with SQLiteStudio v3.2.1 on qui jan 16 12:19:16 2020
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: student_record
DROP TABLE IF EXISTS student_record;

CREATE TABLE student_record (
    student_id       INTEGER       NOT NULL
                                   PRIMARY KEY AUTOINCREMENT,
    student_name     VARCHAR (100),
    student_email    VARCHAR (50),
    student_password VARCHAR (20),
    student_gender   VARCHAR (1),
    student_address  VARCHAR (100) 
);

INSERT INTO student_record (
                               student_id,
                               student_name,
                               student_email,
                               student_password,
                               student_gender,
                               student_address
                           )
                           VALUES (
                               1,
                               'John',
                               'john@jcg.com',
                               'access@123',
                               'M',
                               'America'
                           );

INSERT INTO student_record (
                               student_id,
                               student_name,
                               student_email,
                               student_password,
                               student_gender,
                               student_address
                           )
                           VALUES (
                               2,
                               'Monica',
                               'monica@jcg.com',
                               'access@123',
                               'F',
                               'Iceland'
                           );

INSERT INTO student_record (
                               student_id,
                               student_name,
                               student_email,
                               student_password,
                               student_gender,
                               student_address
                           )
                           VALUES (
                               3,
                               'Raymond',
                               'raymond@jcg.com',
                               'access@123',
                               'M',
                               'Greece'
                           );

INSERT INTO student_record (
                               student_id,
                               student_name,
                               student_email,
                               student_password,
                               student_gender,
                               student_address
                           )
                           VALUES (
                               4,
                               'Jane',
                               'jane@jcg.com',
                               'access@123',
                               'F',
                               'Norway'
                           );

INSERT INTO student_record (
                               student_id,
                               student_name,
                               student_email,
                               student_password,
                               student_gender,
                               student_address
                           )
                           VALUES (
                               5,
                               'Rachel',
                               'rachel@jcg.com',
                               'access@123',
                               'F',
                               'France'
                           );


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
