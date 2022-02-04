package com.banco.contas;

import com.banco.banco.Banco;

public interface IConta {
	
	void sacar(double valor);
	
	void depositar(double valor);
	
	void transferir(double valor, IConta contaDestino);
	
	void imprimirSaldo();

	boolean transferir(double valor, Banco banco, String Pix);
}
