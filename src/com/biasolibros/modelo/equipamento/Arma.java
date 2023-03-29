package com.biasolibros.modelo.equipamento;

public class Arma {

	/* ------ Atributos do objeto ------ */
	private String nome;
	private int bonusDeAtaque;

	/* ------ Getters e setters ------ */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getBonusDeAtaque() {
		return bonusDeAtaque;
	}

	public void setBonusDeAtaque(int bonusDeAtaque) {
		this.bonusDeAtaque = bonusDeAtaque;
	}
}
