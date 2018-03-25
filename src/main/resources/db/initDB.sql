DROP TABLE IF EXISTS test_table;

CREATE TABLE test_table
(
  id   INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name TEXT NOT NULL
);
CREATE UNIQUE INDEX test_table_id_uindex ON test_table (id);