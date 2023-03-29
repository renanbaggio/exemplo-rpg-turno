package com.biasolibros.base;

import java.util.ArrayList;
import java.util.List;

import com.biasolibros.modelo.inimigo.EspecieInimigo;
import com.biasolibros.modelo.inimigo.InimigoComum;

public class BibliotecaDeInimigo {

	private List<InimigoComum> listaInimigoExistente = new ArrayList<>();
	
	public BibliotecaDeInimigo() {
		// Estes dados poderiam vir de uma fonte mais flexível (banco de dados, arquivo CSV, planilha, etc),
		// mas vamos deixar fixo (hardcoded) alguns inimigos aqui para simplificar o exemplo
		
		InimigoComum inimigo = new InimigoComum("Goblin Verde", EspecieInimigo.GOBLIN);
		inimigo.setHpTotal(30);
		inimigo.setHpRestante(inimigo.getHpTotal());
		inimigo.setForca(9);
		inimigo.setResiliencia(7);
		inimigo.setVelocidade(6);
		listaInimigoExistente.add(inimigo);
		
		inimigo = new InimigoComum("Goblin Vermelho", EspecieInimigo.GOBLIN);
		inimigo.setHpTotal(55);
		inimigo.setHpRestante(inimigo.getHpTotal());
		inimigo.setForca(12);
		inimigo.setResiliencia(10);
		inimigo.setVelocidade(8);
		listaInimigoExistente.add(inimigo);
		
		inimigo = new InimigoComum("Slime Roxo", EspecieInimigo.SLIME);
		inimigo.setHpTotal(36);
		inimigo.setHpRestante(inimigo.getHpTotal());
		inimigo.setForca(6);
		inimigo.setResiliencia(8);
		inimigo.setVelocidade(5);
		listaInimigoExistente.add(inimigo);
		
		inimigo = new InimigoComum("Slime Azul", EspecieInimigo.SLIME);
		inimigo.setHpTotal(72);
		inimigo.setHpRestante(inimigo.getHpTotal());
		inimigo.setForca(9);
		inimigo.setResiliencia(11);
		inimigo.setVelocidade(7);
		listaInimigoExistente.add(inimigo);
		
		inimigo = new InimigoComum("Dragão Escarlate", EspecieInimigo.DRAGAO);
		inimigo.setHpTotal(190);
		inimigo.setHpRestante(inimigo.getHpTotal());
		inimigo.setForca(14);
		inimigo.setResiliencia(12);
		inimigo.setVelocidade(12);
		listaInimigoExistente.add(inimigo);
	}

	public InimigoComum getInimigo(int index) {
		return listaInimigoExistente.get(index);
	}

	public List<InimigoComum> getListaInimigoExistente() {
		return listaInimigoExistente;
	}
}
