package com.banco.contas;
import com.banco.banco.Banco;
import com.banco.cliente.Cliente;

public class ContaCorrente extends Conta {

	public ContaCorrente(Banco banco, Cliente cliente) {
		super(banco, cliente, TipoConta.CORRENTE);
	}

	@Override
	public void imprimirSaldo() {
		System.out.println("\n=== Saldo Conta Corrente ===");
		super.imprimirInfosComuns();
	}

	
}
