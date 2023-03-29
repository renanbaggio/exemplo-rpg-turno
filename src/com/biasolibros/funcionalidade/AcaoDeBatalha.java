package com.biasolibros.funcionalidade;

public enum AcaoDeBatalha {

	ATACAR ("Atacar", 1),
	FUGIR  ("Fugir",  2);

	private String nome;
	private int codigo;

	private AcaoDeBatalha(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public static AcaoDeBatalha getEnumPorCodigo(String valorInformado) {
		int codigoInformado = Integer.parseInt(valorInformado);
		
		for (AcaoDeBatalha objeto : values()) {
			if (objeto.codigo == codigoInformado) {
				return objeto;
			}
		}
		throw new IllegalArgumentException(valorInformado);
	}
}
