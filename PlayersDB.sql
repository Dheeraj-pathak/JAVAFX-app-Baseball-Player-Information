CREATE DATABASE IF NOT EXISTS PlayersDB;
USE PlayersDB;

CREATE TABLE IF NOT EXISTS Players (
    PlayerID INT PRIMARY KEY CHECK (PlayerID BETWEEN 101 AND 999),
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    BattingAverage DOUBLE CHECK (BattingAverage > 0)
);

INSERT INTO Players VALUES
(101, 'Mike', 'Trout', 0.325),
(102, 'Aaron', 'Judge', 0.287),
(103, 'Shohei', 'Ohtani', 0.301),
(104, 'Mookie', 'Betts', 0.313),
(105, 'Freddie', 'Freeman', 0.331);
