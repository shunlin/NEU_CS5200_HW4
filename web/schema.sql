CREATE DATABASE DB_HW4;
USE DB_HW4;

## In my implementation, I changed the data type of Actor's dateOfBirth to be DATE. Because it is a DATE.
## And I set the data type of commentId and castId to be int, so when insert a new comment,
## the commentId could be AUTO_INCREMENT.

CREATE TABLE User (
  username VARCHAR(64) NOT NULL,
  password VARCHAR(20) NOT NULL,
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
  email VARCHAR(64) NOT NULL,
  dateOfBirth DATE NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE Movie (
  movieId VARCHAR(20) NOT NULL,
  title VARCHAR(64) NOT NULL,
  posterImage VARCHAR(128),
  releaseDate DATE,
  PRIMARY KEY (movieId)
);

CREATE TABLE Comment (
  commentId INT NOT NULL AUTO_INCREMENT,
  comment TEXT NOT NULL,
  date DATE,
  username VARCHAR(64) NOT NULL,
  movieId VARCHAR(20) NOT NULL,
  FOREIGN KEY (username) REFERENCES User(username) ON DELETE CASCADE,
  FOREIGN KEY (movieId) REFERENCES Movie(movieId) ON DELETE CASCADE,
  PRIMARY KEY (commentId)
);

CREATE TABLE Actor (
  actorId VARCHAR(20) NOT NULL,
  firstName VARCHAR(20) NOT NULL,
  lastName VARCHAR(20) NOT NULL,
  dateOfBirth DATE NOT NULL,
  PRIMARY KEY (actorId)
);

CREATE TABLE Cast (
  castId INT NOT NULL AUTO_INCREMENT,
  characterName VARCHAR(64) NOT NULL,
  movieId VARCHAR(20) NOT NULL,
  actorId VARCHAR(20) NOT NULL,
  FOREIGN KEY (movieId) REFERENCES Movie(movieId) ON DELETE CASCADE,
  FOREIGN KEY (actorId) REFERENCES Actor(actorId),
  PRIMARY KEY (castId)
);



