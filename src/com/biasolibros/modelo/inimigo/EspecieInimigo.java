package com.biasolibros.modelo.inimigo;

import com.biasolibros.modelo.Elemento;

public enum EspecieInimigo {

	GOBLIN ("Goblin", new Elemento[] { Elemento.AGUA, Elemento.TERRA },        new Elemento[] { }),
	SLIME  ("Slime",  new Elemento[] { Elemento.FOGO },                        new Elemento[] { Elemento.ELETRICIDADE }),
	ORC    ("Orc",    new Elemento[] { Elemento.ELETRICIDADE },                new Elemento[] { Elemento.TERRA }),
	LOBO   ("Lobo",   new Elemento[] { Elemento.FOGO },                        new Elemento[] { Elemento.GELO }),
	HIDRA  ("Hidra",  new Elemento[] { Elemento.ELETRICIDADE, Elemento.GELO }, new Elemento[] { Elemento.AGUA }),
	FADA   ("Fada",   new Elemento[] { Elemento.VENTO, Elemento.TREVAS },      new Elemento[] { Elemento.LUZ }),
	DJINN  ("Djinn",  new Elemento[] { Elemento.VENTO, Elemento.LUZ },         new Elemento[] { Elemento.NEUTRO }),
	TROLL  ("Troll",  new Elemento[] { Elemento.TERRA, Elemento.LUZ },         new Elemento[] { Elemento.VENTO }),
	DRAGAO ("Dragão", new Elemento[] { Elemento.GELO },                        new Elemento[] { Elemento.NEUTRO, Elemento.FOGO });
	
	private String nome;
	private Elemento[] fraquezas;
	private Elemento[] resistencias;
	
	private EspecieInimigo(String nome, Elemento[] fraquezas, Elemento[] resistencias) {
		this.nome = nome;
		this.fraquezas = fraquezas;
		this.resistencias = resistencias;
	}

	public String getNome() {
		return nome;
	}

	public Elemento[] getFraquezas() {
		return fraquezas;
	}

	public Elemento[] getResistencias() {
		return resistencias;
	}
}
