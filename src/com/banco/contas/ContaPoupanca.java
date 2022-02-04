package com.banco.contas;
import com.banco.banco.Banco;
import com.banco.cliente.Cliente;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Banco banco, Cliente cliente) {
		super(banco, cliente, TipoConta.POUPANCA);
	}

	@Override
	public void imprimirSaldo() {
		System.out.println("\n=== Saldo Conta Poupança ===");
		super.imprimirInfosComuns();
	}

}
