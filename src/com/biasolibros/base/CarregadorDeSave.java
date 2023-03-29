package com.biasolibros.base;

import com.biasolibros.modelo.equipamento.Arma;
import com.biasolibros.modelo.equipamento.Armadura;
import com.biasolibros.modelo.personagem.Heroi;

public class CarregadorDeSave {

	public Heroi recuperarHeroi() {
		// Estes dados viriam de uma fonte dinâmica (arquivo de save, banco de dados, arquivo CSV, etc),
		// mas vamos deixar fixo (hardcoded) os dados do herói aqui para simplificar o exemplo
		
		Heroi heroi = new Heroi("Rafasoli", 3);
		heroi.setHpTotal(96);
		heroi.setHpRestante(96);
		heroi.setForca(9);
		heroi.setResiliencia(9);
		heroi.setVelocidade(7);
		
		BibliotecaDeEquipamento bibliotecaDeEquipamento = new BibliotecaDeEquipamento();
		Arma arma = bibliotecaDeEquipamento.getArma(1); // Pegando a arma da lista referente ao index informado
		Armadura armadura = bibliotecaDeEquipamento.getArmadura(0); // Pegando a armadura da lista referente ao index informado
		
		heroi.setArma(arma);
		heroi.setArmadura(armadura);
		
		return heroi;
	}
}
