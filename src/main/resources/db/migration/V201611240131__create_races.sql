CREATE TABLE races (
    id          INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    name        VARCHAR(128) NOT NULL,
    started_at  TIMESTAMP NOT NULL,
    finished_at TIMESTAMP
);
