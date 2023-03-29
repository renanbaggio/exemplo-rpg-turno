package com.biasolibros.modelo.personagem;

import com.biasolibros.funcionalidade.CalculadoraDeDano;
import com.biasolibros.modelo.ParticipanteDeBatalha;
import com.biasolibros.modelo.equipamento.Arma;
import com.biasolibros.modelo.equipamento.Armadura;

public class Heroi implements ParticipanteDeBatalha {

	/* ------ Atributos do objeto ------ */
	private String nome;
	private int hpTotal;
	private int hpRestante;
	private int forca;
	private int resiliencia;
	private int velocidade;
	private boolean acaoRealizada;
	private int nivel;
	private Arma arma;
	private Armadura armadura;
	
	// Objeto de composição
	private CalculadoraDeDano calculadoraDeDano = new CalculadoraDeDano();

	/* ------ Construtor (explícito) do objeto ------ */
	public Heroi(String nome, int nivel) {
		this.nome = nome;
		this.nivel = nivel;
	}

	/* ------ Métodos do objeto ------ */
	@Override
	public void atacar(ParticipanteDeBatalha inimigo) {
		int dano = calculadoraDeDano.calcularDanoComum(getForca(), getAtaque(), inimigo.getDefesa());
		inimigo.receberDano(dano);
		
		System.out.println("Você atacou " + inimigo.getNome() + " e causou " + dano + " de dano! Status → " + inimigo.getStatus());
	}

	@Override
	public void receberDano(int dano) {
		setHpRestante(hpRestante - dano);
	}

	/* ------ Getters e setters ------ */
	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public int getHpTotal() {
		return hpTotal;
	}

	@Override
	public void setHpTotal(int hpTotal) {
		this.hpTotal = hpTotal;
	}

	@Override
	public int getHpRestante() {
		return hpRestante;
	}

	@Override
	public void setHpRestante(int hpRestante) {
		if (hpRestante < 0) {
			hpRestante = 0;
		}
		this.hpRestante = hpRestante;
	}

	@Override
	public int getForca() {
		return forca;
	}

	@Override
	public void setForca(int forca) {
		this.forca = forca;
	}

	@Override
	public int getResiliencia() {
		return resiliencia;
	}

	@Override
	public void setResiliencia(int resiliencia) {
		this.resiliencia = resiliencia;
	}

	@Override
	public int getVelocidade() {
		return velocidade;
	}

	@Override
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	@Override
	public int getAtaque() {
		return getForca() + getArma().getBonusDeAtaque();
	}

	@Override
	public int getDefesa() {
		return getResiliencia() + getArmadura().getBonusDeDefesa();
	}

	@Override
	public boolean isAcaoRealizada() {
		return acaoRealizada;
	}

	@Override
	public void setAcaoRealizada(boolean acaoRealizada) {
		this.acaoRealizada = acaoRealizada;
	}

	public int getNivel() {
		return nivel;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public Armadura getArmadura() {
		return armadura;
	}

	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}

	@Override
	public String toString() {
		return "Heroi [nome=" + nome + ", HP=" + hpRestante + "/" + hpTotal + "]";
	}
}
