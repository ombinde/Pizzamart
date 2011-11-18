SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `sigurlu_pizzamart2` DEFAULT CHARACTER SET utf8 ;
USE `sigurlu_pizzamart2` ;

-- -----------------------------------------------------
-- Table `sigurlu_pizzamart2`.`customer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sigurlu_pizzamart2`.`customer` (
  `idcustomer` INT NOT NULL AUTO_INCREMENT ,
  `forename` VARCHAR(45) NOT NULL ,
  `lastname` VARCHAR(45) NOT NULL ,
  `phone` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(45) NOT NULL ,
  `postcode` VARCHAR(45) NOT NULL ,
  `postaladdress` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idcustomer`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sigurlu_pizzamart2`.`orders`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sigurlu_pizzamart2`.`orders` (
  `idorder` INT NOT NULL AUTO_INCREMENT ,
  `status` VARCHAR(45) NOT NULL ,
  `customer_idcustomer` INT NOT NULL ,
  `comments` MEDIUMTEXT  NULL ,
  `allergy` TINYINT(1)  NOT NULL ,
  `delivery` TINYINT(1)  NOT NULL ,
  `time` MEDIUMTEXT  NOT NULL ,
  PRIMARY KEY (`idorder`, `customer_idcustomer`) ,
  INDEX `fk_orders_customer1` (`customer_idcustomer` ASC) ,
  CONSTRAINT `fk_orders_customer1`
    FOREIGN KEY (`customer_idcustomer` )
    REFERENCES `sigurlu_pizzamart2`.`customer` (`idcustomer` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sigurlu_pizzamart2`.`product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sigurlu_pizzamart2`.`product` (
  `idproduct` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `price` DOUBLE  NOT NULL ,
  `comments` VARCHAR(45) NULL ,
  `visability` TINYINT(1)  NOT NULL ,
  PRIMARY KEY (`idproduct`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sigurlu_pizzamart2`.`product_has_order`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sigurlu_pizzamart2`.`product_has_order` (
  `product_idproduct` INT NOT NULL ,
  `orders_idorder` INT NOT NULL ,
  `quantity` INT NOT NULL ,
  PRIMARY KEY (`product_idproduct`, `orders_idorder`) ,
  INDEX `fk_product_has_orders_orders1` (`orders_idorder` ASC) ,
  INDEX `fk_product_has_orders_product1` (`product_idproduct` ASC) ,
  CONSTRAINT `fk_product_has_orders_product1`
    FOREIGN KEY (`product_idproduct` )
    REFERENCES `sigurlu_pizzamart2`.`product` (`idproduct` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_has_orders_orders1`
    FOREIGN KEY (`orders_idorder` )
    REFERENCES `sigurlu_pizzamart2`.`orders` (`idorder` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sigurlu_pizzamart2`.`properties`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `sigurlu_pizzamart2`.`properties` (
  `limitFreeDelivery` DOUBLE NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `address` VARCHAR(45) NOT NULL ,
  `postcode` VARCHAR(45) NOT NULL ,
  `postaladdress` VARCHAR(45) NOT NULL ,
  `phone` VARCHAR(45) NOT NULL )
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
