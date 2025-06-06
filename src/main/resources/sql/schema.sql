DROP DATABASE IF EXISTS freedom404;
CREATE DATABASE freedom404;
USE freedom404;

CREATE TABLE IF NOT EXISTS puzzles
(
    id              INT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(100)                               NOT NULL,
    type            ENUM ('RIDDLE', 'SQL', 'CIPHER', 'NUMBER') NOT NULL,
    prompt          TEXT                                       NOT NULL,
    answer          VARCHAR(255)                               NOT NULL,
    hint            TEXT,
    room_label      VARCHAR(100),
    story_intro     TEXT,
    consequence     TEXT,
    success_message TEXT
);
