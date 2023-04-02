package com.marcelo.main.entities;

public class Faturamento {

	private String dia;
	private Double valor;
	
	public Faturamento() {

	}

	public Faturamento(String dia, Double valor) {
		this.dia = dia;
		this.valor = valor;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Faturamento [dia=" + dia + ", valor=" + valor + "]";
	}
	
}
