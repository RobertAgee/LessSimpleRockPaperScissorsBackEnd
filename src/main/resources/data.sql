CREATE TABLE Users (
    id INTEGER NOT NULL,
    games_total INTEGER,
    games_won INTEGER,
    games_tied INTEGER,
    games_lost INTEGER,
    you_rock INTEGER,
    you_paper INTEGER,
    you_scissors INTEGER,
    comp_rock INTEGER,
    comp_paper INTEGER,
    comp_scissors INTEGER
);

ALTER TABLE Users ADD CONSTRAINT id_PK PRIMARY KEY (id);

DROP SEQUENCE IF EXISTS id_PK_SEQ;
CREATE SEQUENCE id_PK_SEQ START WITH 0;

INSERT INTO Users (id, games_total, games_won, games_tied, games_lost, you_rock, you_paper, you_scissors, comp_rock, comp_paper, comp_scissors) VALUES (NEXT VALUE FOR id_PK_SEQ, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
