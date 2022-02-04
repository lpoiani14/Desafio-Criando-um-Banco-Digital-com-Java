package com.banco.banco;
import java.util.ArrayList;
import java.util.List;

import com.banco.contas.Conta;

public class Banco {

	private String nome;
	private List<Conta> contas;
	
	public Banco(String nome) {
		super();
		this.nome = nome;
		this.contas = new ArrayList<Conta>();
	}

	public String getNome() {
		String auxStr = null;
		
		auxStr = "------------------\n" + "== " + nome + " ==\n" + "------------------";
		return auxStr;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void addContas(Conta conta) {
		this.contas.add(conta);
	}

}
