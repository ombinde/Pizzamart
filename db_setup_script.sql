SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`customer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`customer` (
  `idcustomer` INT NOT NULL AUTO_INCREMENT ,
  `forename` VARCHAR(45) NOT NULL ,
  `lastname` VARCHAR(45) NOT NULL ,
  `phone` VARCHAR(45) NOT NULL ,
  `adress` VARCHAR(45) NOT NULL ,
  `postcode` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idcustomer`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`employee`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`employee` (
  `idemployee` INT NOT NULL AUTO_INCREMENT ,
  `lastname` VARCHAR(45) NOT NULL ,
  `forename` VARCHAR(45) NOT NULL ,
  `username` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idemployee`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orders`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`orders` (
  `idorder` INT NOT NULL AUTO_INCREMENT ,
  `status` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idorder`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`product` (
  `idproduct` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `price` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`idproduct`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`product_has_order`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`product_has_order` (
  `product_idproduct` INT NOT NULL ,
  `orders_idorder` INT NOT NULL ,
  PRIMARY KEY (`product_idproduct`, `orders_idorder`) ,
  INDEX `fk_vare_has_ordre_ordre1` (`orders_idorder` ASC) ,
  CONSTRAINT `fk_vare_has_ordre_vare1`
    FOREIGN KEY (`product_idproduct` )
    REFERENCES `mydb`.`product` (`idproduct` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vare_has_ordre_ordre1`
    FOREIGN KEY (`orders_idorder` )
    REFERENCES `mydb`.`orders` (`idorder` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orders_has_customer`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`orders_has_customer` (
  `orders_idorder` INT NOT NULL ,
  `customer_idcustomer` INT NOT NULL ,
  PRIMARY KEY (`orders_idorder`, `customer_idcustomer`) ,
  INDEX `fk_orders_has_customer_customer1` (`customer_idcustomer` ASC) ,
  CONSTRAINT `fk_orders_has_customer_orders1`
    FOREIGN KEY (`orders_idorder` )
    REFERENCES `mydb`.`orders` (`idorder` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_customer_customer1`
    FOREIGN KEY (`customer_idcustomer` )
    REFERENCES `mydb`.`customer` (`idcustomer` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
