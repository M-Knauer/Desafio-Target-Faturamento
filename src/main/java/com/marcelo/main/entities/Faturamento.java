package com.marcelo.main.entities;

public class Faturamento {

	private String dia;
	private String valor;
	
	public Faturamento() {

	}

	public Faturamento(String dia, String valor) {
		this.dia = dia;
		this.valor = valor;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Faturamento [dia=" + dia + ", valor=" + valor + "]";
	}
	
}
