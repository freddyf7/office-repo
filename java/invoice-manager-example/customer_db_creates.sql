SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `customer_db` ;
USE `customer_db` ;

-- -----------------------------------------------------
-- Table `customer_db`.`Customer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `customer_db`.`Customer` (
  `idCustomer` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(45) NULL ,
  `telephone` VARCHAR(15) NULL ,
  `birthday` DATE NULL ,
  PRIMARY KEY (`idCustomer`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_db`.`Salesman`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `customer_db`.`Salesman` (
  `idSalesman` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `telephone` VARCHAR(45) NULL ,
  PRIMARY KEY (`idSalesman`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_db`.`Invoice`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `customer_db`.`Invoice` (
  `idInvoice` INT NOT NULL AUTO_INCREMENT ,
  `date` DATE NOT NULL ,
  `total` DOUBLE NULL ,
  `idCustomer` INT NOT NULL ,
  `idSalesman` INT NOT NULL ,
  PRIMARY KEY (`idInvoice`) ,
  INDEX `fk_Invoice_Customer` (`idCustomer` ASC) ,
  INDEX `fk_Invoice_Salesman1` (`idSalesman` ASC) ,
  CONSTRAINT `fk_Invoice_Customer`
    FOREIGN KEY (`idCustomer` )
    REFERENCES `customer_db`.`Customer` (`idCustomer` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Invoice_Salesman1`
    FOREIGN KEY (`idSalesman` )
    REFERENCES `customer_db`.`Salesman` (`idSalesman` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_db`.`Product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `customer_db`.`Product` (
  `idProduct` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(200) NULL ,
  `type` VARCHAR(45) NULL ,
  `price` DOUBLE NULL ,
  PRIMARY KEY (`idProduct`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `customer_db`.`Item`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `customer_db`.`Item` (
  `idItem` INT NOT NULL ,
  `price` DOUBLE NULL ,
  `quantity` INT NULL ,
  `idInvoice` INT NOT NULL ,
  `idProduct` INT NOT NULL ,
  PRIMARY KEY (`idItem`, `idInvoice`) ,
  INDEX `fk_Item_Invoice1` (`idInvoice` ASC) ,
  INDEX `fk_Item_Product1` (`idProduct` ASC) ,
  CONSTRAINT `fk_Item_Invoice1`
    FOREIGN KEY (`idInvoice` )
    REFERENCES `customer_db`.`Invoice` (`idInvoice` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Item_Product1`
    FOREIGN KEY (`idProduct` )
    REFERENCES `customer_db`.`Product` (`idProduct` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
