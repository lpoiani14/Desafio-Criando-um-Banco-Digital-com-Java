package com.banco.programa;
import com.banco.banco.Banco;
import com.banco.cliente.Cliente;
import com.banco.contas.Conta;
import com.banco.contas.Conta.TIPOPIX;
import com.banco.contas.ContaCorrente;
import com.banco.contas.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		// Cria o banco
		Banco banco = new Banco("Banco Vencedor");
		
		// Cria o cliente 1
		Cliente cliente1 = new Cliente();
		cliente1.setNome("João");
		cliente1.setCPF("11111111111");
		
		// Cria o cliente 2
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Maria");
		cliente2.setCPF("22222222222");
		
		// Cria a conta corrente do cliente 1 com chave PIX por CPF
		Conta cc = new ContaCorrente(banco, cliente1);
		cc.criarChavePix(TIPOPIX.CPF);
		
		// Cria a conta poupança do cliente 2 com chave PIX por CPF
		Conta poupanca = new ContaPoupanca(banco, cliente2);
		poupanca.criarChavePix(TIPOPIX.CPF);
		
		// Adiciona contas na lista do banco (agora é feito na criação da conta)
		// banco.addContas(cc);
		// banco.addContas(poupanca);
		
		// Printa o nome do banco
		System.out.println(banco.getNome());

		// Deposita 100 na conta do cliente 1
		cc.depositar(100);
		
		// cliente 1 transfere 100 por PIX para cliente 2
		cc.transferir(100, banco, "22222222222");
		
		// Imprime informações das contas
		cc.imprimirSaldo();
		poupanca.imprimirSaldo();
	}

}
