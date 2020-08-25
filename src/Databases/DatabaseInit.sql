DROP DATABASE IF EXISTS spotifyDB;

CREATE DATABASE spotifyDB;

USE spotifyDB;

CREATE TABLE artists (artistId BIGINT PRIMARY KEY, artistName CHAR(64), albumId BIGINT);

CREATE TABLE albums (albumId BIGINT PRIMARY KEY, albumName CHAR(64), songId BIGINT, release DATE);

CREATE TABLE songs (songId BIGINT PRIMARY KEY, songName CHAR(64), artistId BIGINT, plays BIGINT);

CREATE TABLE friends (user1 BIGINT, user2 BIGINT, status INT);

CREATE TABLE users (userId BIGINT PRIMARY KEY, email CHAR(64), nickname CHAR(64), password CHAR(64));