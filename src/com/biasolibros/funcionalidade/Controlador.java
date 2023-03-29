package com.biasolibros.funcionalidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.biasolibros.base.BibliotecaDeInimigo;
import com.biasolibros.base.CarregadorDeSave;
import com.biasolibros.modelo.inimigo.InimigoComum;
import com.biasolibros.modelo.personagem.Heroi;

public class Controlador {

	private Heroi heroi;
	private BibliotecaDeInimigo bibliotecaDeInimigo = new BibliotecaDeInimigo();

	public Controlador() {
		carregarDados();
	}

	public void carregarDados() {
		CarregadorDeSave carregadorDeSave = new CarregadorDeSave();
		heroi = carregadorDeSave.recuperarHeroi();
	}

	public void iniciarBatalha() {
		List<InimigoComum> listaDeInimigoEncontrado = getListaDeInimigoEncontrado();
		Batalha batalha = new Batalha(heroi, listaDeInimigoEncontrado);
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		while (!batalha.isBatalhaConcluida() && !batalha.isTentativaDeFugaBemSucedida()) {
			try {
				System.out.println("--------------------------------------------------------------");
				System.out.print("O que deseja fazer? Digite: '1' para atacar; '2' para fugir; → ");
				String valorInformado = scanner.next();
				
				AcaoDeBatalha acaoDeBatalha = AcaoDeBatalha.getEnumPorCodigo(valorInformado);
				batalha.realizarAcao(acaoDeBatalha);
			
			} catch (IllegalArgumentException e) {
				System.out.println("Informe uma das opções disponíveis.");
			}
		}
		processarResultadoDaBatalha(batalha);
	}

	private void processarResultadoDaBatalha(Batalha batalha) {
		if (batalha.isBatalhaConcluida()) {
			if (heroi.isDerrotado()) {
				System.out.println("Você foi derrotado...");
			} else {
				System.out.println("Você venceu a batalha!");
			}
		} else if (batalha.isTentativaDeFugaBemSucedida()) {
			System.out.println("Você conseguiu fugir!");
		}
	}

	private List<InimigoComum> getListaDeInimigoEncontrado() {
		// Atribuindo uma quantidade aleatória de inimigos de 1 a 3
		int quantidadeDeInimigos = ThreadLocalRandom.current().nextInt(1, 4);
		List<InimigoComum> listaDeInimigo = new ArrayList<>();
		
		for (int i = 0; i < quantidadeDeInimigos; i++) {
			
			// Carregando um inimigo aleatório
			int indexNaBiblioteca = ThreadLocalRandom.current().nextInt(0, 5);
			listaDeInimigo.add(bibliotecaDeInimigo.getInimigo(indexNaBiblioteca));
		}
		return listaDeInimigo;
	}
}
