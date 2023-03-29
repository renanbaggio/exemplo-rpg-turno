package com.biasolibros.base;

import java.util.ArrayList;
import java.util.List;

import com.biasolibros.modelo.equipamento.Arma;
import com.biasolibros.modelo.equipamento.Armadura;

public class BibliotecaDeEquipamento {

	private List<Arma> listaArmaExistente = new ArrayList<>();
	private List<Armadura> listaArmaduraExistente = new ArrayList<>();
	
	public BibliotecaDeEquipamento() {
		// Estes dados poderiam vir de uma fonte mais flexível (banco de dados, arquivo CSV, planilha, etc),
		// mas vamos deixar fixo (hardcoded) alguns equipamentos aqui para simplificar o exemplo
		
		Arma arma = new Arma();
		arma.setNome("Espada de Treino");
		arma.setBonusDeAtaque(4);
		listaArmaExistente.add(arma);
		
		arma = new Arma();
		arma.setNome("Espada Longa");
		arma.setBonusDeAtaque(10);
		listaArmaExistente.add(arma);
		
		Armadura armadura = new Armadura();
		armadura.setNome("Escudo Básico");
		armadura.setBonusDeDefesa(5);
		listaArmaduraExistente.add(armadura);
	}

	public Arma getArma(int index) {
		return listaArmaExistente.get(index);
	}

	public Armadura getArmadura(int index) {
		return listaArmaduraExistente.get(index);
	}

	public List<Arma> getListaArmaExistente() {
		return listaArmaExistente;
	}

	public List<Armadura> getListaArmaduraExistente() {
		return listaArmaduraExistente;
	}
}
