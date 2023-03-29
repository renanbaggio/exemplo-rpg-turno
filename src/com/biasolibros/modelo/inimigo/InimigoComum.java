package com.biasolibros.modelo.inimigo;

import com.biasolibros.funcionalidade.CalculadoraDeDano;
import com.biasolibros.modelo.ParticipanteDeBatalha;

public class InimigoComum implements ParticipanteDeBatalha {

	/* ------ Atributos do objeto ------ */
	private String nome;
	private int hpTotal;
	private int hpRestante;
	private int forca;
	private int resiliencia;
	private int velocidade;
	private boolean acaoRealizada;
	private EspecieInimigo especie;
	
	// Objeto de composição
	private CalculadoraDeDano calculadoraDeDano = new CalculadoraDeDano();

	/* ------ Construtor (explícito) do objeto ------ */
	public InimigoComum(String nome, EspecieInimigo especie) {
		this.nome = nome;
		this.especie = especie;
	}

	/* ------ Métodos do objeto ------ */
	@Override
	public void atacar(ParticipanteDeBatalha heroi) {
		int dano = calculadoraDeDano.calcularDanoComum(getForca(), getAtaque(), heroi.getDefesa());
		heroi.receberDano(dano);
		
		System.out.println(getNome() + " atacou você e causou " + dano + " de dano!...Result. → " + heroi.getStatus());
	}

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
		return getForca();
	}

	@Override
	public int getDefesa() {
		return getResiliencia();
	}

	@Override
	public boolean isAcaoRealizada() {
		return acaoRealizada;
	}

	@Override
	public void setAcaoRealizada(boolean acaoRealizada) {
		this.acaoRealizada = acaoRealizada;
	}

	public EspecieInimigo getEspecie() {
		return especie;
	}

	@Override
	public String toString() {
		return "InimigoComum [nome=" + nome + ", HP=" + hpRestante + "/" + hpTotal + "]";
	}
}
