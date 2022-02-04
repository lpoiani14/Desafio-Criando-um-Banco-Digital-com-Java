package com.banco.cliente;

public class Cliente {

	private String nome;
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String Cpf) {
		if (Cpf.length()==11) {
			cpf = Cpf;
			System.out.println("CPF de " + nome + " cadastrado com sucesso!");
		}else
			System.out.println("CPF Inválido!");
	}

}
