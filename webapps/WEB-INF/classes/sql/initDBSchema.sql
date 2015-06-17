-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema lilac_blog
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `lilac_blog` ;

-- -----------------------------------------------------
-- Schema lilac_blog
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `lilac_blog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `lilac_blog` ;

-- -----------------------------------------------------
-- Table `lilac_blog`.`BOARD`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lilac_blog`.`BOARD` ;

CREATE TABLE IF NOT EXISTS `lilac_blog`.`BOARD` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NAME` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lilac_blog`.`ARTICLE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lilac_blog`.`ARTICLE` ;

CREATE TABLE IF NOT EXISTS `lilac_blog`.`ARTICLE` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `BOARD_ID` INT NOT NULL,
  `TITLE` VARCHAR(128) NOT NULL,
  `CONTENT` LONGTEXT NOT NULL,
  `ARTICLE_TIME` TIMESTAMP NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_ARTICLE_BOARD1`
    FOREIGN KEY (`BOARD_ID`)
    REFERENCES `lilac_blog`.`BOARD` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `lilac_blog`.`ARTICLE_COMMENT`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `lilac_blog`.`ARTICLE_COMMENT` ;

CREATE TABLE IF NOT EXISTS `lilac_blog`.`ARTICLE_COMMENT` (
  `ARTICLE_ID` INT NULL,
  `USER_ID` VARCHAR(45) NOT NULL,
  `COMMENT_TIME` TIMESTAMP NOT NULL,
  `CONTENT` LONGTEXT NOT NULL,
  PRIMARY KEY (`ARTICLE_ID`, `USER_ID`, `COMMENT_TIME`),
  CONSTRAINT `fk_ARTICLE_COMMENT_ARTICLE1`
    FOREIGN KEY (`ARTICLE_ID`)
    REFERENCES `lilac_blog`.`ARTICLE` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
