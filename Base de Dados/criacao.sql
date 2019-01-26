-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Funcionario` (
  `Username` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NULL,
  PRIMARY KEY (`Username`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Carro` (
  `ID_Carro` INT NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `Preco` DOUBLE NULL,
  PRIMARY KEY (`ID_Carro`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Configuracao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Configuracao` (
  `ID_Configuracao` INT NOT NULL,
  `Preco` DOUBLE NULL,
  `Carro_ID_Carro` INT NOT NULL,
  PRIMARY KEY (`ID_Configuracao`),
  INDEX `fk_Configuracao_Carro1_idx` (`Carro_ID_Carro` ASC) VISIBLE,
  CONSTRAINT `fk_Configuracao_Carro1`
    FOREIGN KEY (`Carro_ID_Carro`)
    REFERENCES `mydb`.`Carro` (`ID_Carro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Encomenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Encomenda` (
  `ID_Encomenda` INT NOT NULL,
  `Cliente_NIF` INT NULL,
  `Cliente_Nome` VARCHAR(45) NULL,
  `Cliente_Contato` INT NULL,
  `Estado` VARCHAR(45) NULL,
  `Configuracao_ID` INT NOT NULL,
  PRIMARY KEY (`ID_Encomenda`),
  INDEX `fk_Encomenda_Configuracao1_idx` (`Configuracao_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Encomenda_Configuracao1`
    FOREIGN KEY (`Configuracao_ID`)
    REFERENCES `mydb`.`Configuracao` (`ID_Configuracao`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;




-- -----------------------------------------------------
-- Table `mydb`.`Componente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Componente` (
  `Nome` VARCHAR(45) NOT NULL,
  `Obrigatorio` TINYINT NOT NULL,
  `Preco` DOUBLE NULL,
  `Stock` INT NULL,
  PRIMARY KEY (`Nome`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pacote`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pacote` (
  `ID_Pacote` INT NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `Desconto` FLOAT NULL,
  PRIMARY KEY (`ID_Pacote`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Incompativeis`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Incompativeis` (
  `Nome` VARCHAR(45) NOT NULL,
  `Componente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Nome`, `Componente`),
  INDEX `fk_Incompativeis_Componente1_idx` (`Componente` ASC) VISIBLE,
  CONSTRAINT `fk_Incompativeis_Componente1`
    FOREIGN KEY (`Componente`)
    REFERENCES `mydb`.`Componente` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Dependentes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Dependentes` (
  `Nome` VARCHAR(45) NOT NULL,
  `Componente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Nome`, `Componente`),
  INDEX `fk_Obrigatorios_Componente1_idx` (`Componente` ASC) VISIBLE,
  CONSTRAINT `fk_Obrigatorios_Componente1`
    FOREIGN KEY (`Componente`)
    REFERENCES `mydb`.`Componente` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pacote_Componente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pacote_Componente` (
  `Pacote_ID` INT NOT NULL,
  `Componente_Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Pacote_ID`, `Componente_Nome`),
  INDEX `fk_Pacote_has_Componente_Componente1_idx` (`Componente_Nome` ASC) VISIBLE,
  INDEX `fk_Pacote_has_Componente_Pacote1_idx` (`Pacote_ID` ASC) VISIBLE,
  CONSTRAINT `fk_Pacote_has_Componente_Pacote1`
    FOREIGN KEY (`Pacote_ID`)
    REFERENCES `mydb`.`Pacote` (`ID_Pacote`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pacote_has_Componente_Componente1`
    FOREIGN KEY (`Componente_Nome`)
    REFERENCES `mydb`.`Componente` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Componente_Configuracao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Componente_Configuracao` (
  `Componente_Nome` VARCHAR(45) NOT NULL,
  `Configuracao_ID` INT NOT NULL,
  PRIMARY KEY (`Componente_Nome`, `Configuracao_ID`),
  INDEX `fk_Componente_has_Configuracao_Configuracao1_idx` (`Configuracao_ID` ASC) VISIBLE,
  INDEX `fk_Componente_has_Configuracao_Componente1_idx` (`Componente_Nome` ASC) VISIBLE,
  CONSTRAINT `fk_Componente_has_Configuracao_Componente1`
    FOREIGN KEY (`Componente_Nome`)
    REFERENCES `mydb`.`Componente` (`Nome`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Componente_has_Configuracao_Configuracao1`
    FOREIGN KEY (`Configuracao_ID`)
    REFERENCES `mydb`.`Configuracao` (`ID_Configuracao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
