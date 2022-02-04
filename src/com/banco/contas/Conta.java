package com.banco.contas;

import com.banco.banco.Banco;
import com.banco.cliente.Cliente;

public abstract class Conta implements IConta {
	
	protected enum TipoConta {CORRENTE, POUPANCA};
	public enum TIPOPIX {TELEFONE, CPF};
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected TipoConta tipo;
	protected String chavePix;

	public Conta(Banco banco, Cliente cliente, TipoConta tipo) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.tipo = tipo;
		this.chavePix = null;
		addContaToBank(banco);
	}
	private void addContaToBank(Banco banco) {
		banco.addContas(this);
	}
		
	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public boolean transferir(double valor, Banco banco, String Pix) {
		this.sacar(valor);
		for (int i = 0; i <= banco.getContas().size()-1; i++) {
			if (banco.getContas().get(i).chavePix == Pix) {
				banco.getContas().get(i).depositar(valor);
				System.out.println("Transferência PIX feita com sucesso!");
				return true;
			}	
		}		
		System.out.println("Não existe chave PIX conforme informado!");
		this.depositar(valor);
		return false;
	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public void criarChavePix(TIPOPIX tipoPix) {
		if (tipoPix == TIPOPIX.CPF) {
			chavePix = cliente.getCPF();
		}else
			System.out.println("Pix por Telefone ainda não implementado.");
		
		
	}
	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
