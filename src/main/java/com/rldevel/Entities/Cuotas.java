package com.rldevel.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Cuotas")
public class Cuotas {

	@Id
	private int nroCuota;
	private double valorCuota;
	
	public int getNroCuota() {
		return nroCuota;
	}
	public void setNroCuota(int nroCuota) {
		this.nroCuota = nroCuota;
	}
	public double getValorCuota() {
		return valorCuota;
	}
	public void setValorCuota(double valorCuota) {
		this.valorCuota = valorCuota;
	}
	
}

/*

CREATE TABLE `mydb`.`Cuotas` (
`NroCuota` INT NOT NULL,
`ValorCuota` DOUBLE NOT NULL,
PRIMARY KEY (`NroCuota`));

*/