package com.biasolibros.funcionalidade;

import java.util.concurrent.ThreadLocalRandom;

public class CalculadoraDeDano {

	public int calcularDanoComum(int pontosAtaqueBaseDoAtacante, int pontosAtaqueTotalDoAtacante, int pontosDefesaTotalDoAlvo) {
		// Calculando através da fórmula base dos Dragon Quest antigos
		double dano = (pontosAtaqueTotalDoAtacante - (pontosDefesaTotalDoAlvo / 2)) * (20 + pontosAtaqueBaseDoAtacante) / 20;
		
		// Adicionando variabilidade de 15% ao dano
		dano = dano + (dano * ThreadLocalRandom.current().nextDouble(-0.15, 0.15));
		
		if (dano <= 0) {
			dano = 1;
		}
		return (int) Math.round(dano);
	}
}
