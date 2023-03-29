package com.biasolibros.modelo;

public interface ParticipanteDeBatalha {

	/* ------ Métodos do objeto ------ */
	public void atacar(ParticipanteDeBatalha inimigo);

	public void receberDano(int dano);

	/* ------ Getters e setters ------ */
	public String getNome();

	public int getHpTotal();

	public void setHpTotal(int hpTotal);

	public int getHpRestante();

	public void setHpRestante(int hpRestante);

	public int getForca();

	public void setForca(int forca);

	public int getResiliencia();

	public void setResiliencia(int resiliencia);

	public int getVelocidade();

	public void setVelocidade(int velocidade);

	public int getAtaque();

	public int getDefesa();

	public boolean isAcaoRealizada();

	public void setAcaoRealizada(boolean acaoRealizada);

	public default boolean isDerrotado() {
		if (getHpRestante() == 0) {
			return true;
		}
		return false;
	}

	public default String getStatus() {
		String infoSobreDerrota = isDerrotado() ? " (derrotado)" : "";
		return "HP: " + getHpRestante() + "/" + getHpTotal() + infoSobreDerrota;
	}
}
