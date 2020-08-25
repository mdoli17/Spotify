DROP DATABASE IF EXISTS spotifyDB;

CREATE DATABASE spotifyDB;

USE spotifyDB;

CREATE TABLE artists (artistId BIGINT, artistName CHAR(64), albumId BIGINT);

CREATE TABLE albums (albumId BIGINT, albumName CHAR(64), songId BIGINT);

CREATE TABLE songs (songId BIGINT, songName CHAR(64), artistId BIGINT);