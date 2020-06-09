CREATE TABLE IF NOT EXISTS dateformula(
          dateId          varchar  (6)    NOT NULL  PRIMARY KEY
         ,dateName        varchar  (32)
         ,year  int   Default 0  NOT NULL
         ,month int   Default 0  NOT NULL
         ,date  int   Default 0  NOT NULL

);