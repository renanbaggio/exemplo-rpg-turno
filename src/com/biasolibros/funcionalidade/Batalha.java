package com.biasolibros.funcionalidade;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.biasolibros.modelo.ParticipanteDeBatalha;
import com.biasolibros.modelo.inimigo.InimigoComum;
import com.biasolibros.modelo.personagem.Heroi;

public class Batalha {

	private Heroi heroi;
	private List<InimigoComum> listaDeInimigo = new ArrayList<>();
	private boolean tentativaDeFugaBemSucedida;

	public Batalha(Heroi heroi, List<InimigoComum> listaDeInimigo) {
		this.heroi = heroi;
		this.listaDeInimigo.addAll(listaDeInimigo);
		
		informarInicioDeBatalha(listaDeInimigo);
	}

	private void informarInicioDeBatalha(List<InimigoComum> listaDeInimigo) {
		String inimigosNestaBatalha = "";
		Map<String, Integer> mapQuantidadeDeCadaInimigo = new HashMap<>();
		
		for (InimigoComum inimigo : listaDeInimigo) {
			
			if (mapQuantidadeDeCadaInimigo.containsKey(inimigo.getNome())) {
				int quantidade = mapQuantidadeDeCadaInimigo.get(inimigo.getNome());
				quantidade = quantidade + 1;
				mapQuantidadeDeCadaInimigo.put(inimigo.getNome(), quantidade);
			
			} else {
				mapQuantidadeDeCadaInimigo.put(inimigo.getNome(), 1);
			}
		}
		inimigosNestaBatalha = mapQuantidadeDeCadaInimigo.toString();
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Iniciando nova batalha! Inimigos: " + inimigosNestaBatalha);
	}

	public void realizarAcao(AcaoDeBatalha acaoDeBatalha) {
		prepararParticipantes();
		
		switch (acaoDeBatalha) {
		case ATACAR:
			realizarAtaque();
			break;
		case FUGIR:
			tentarFugir();
			break;
		}
	}

	private void prepararParticipantes() {
		heroi.setAcaoRealizada(false);
		listaDeInimigo.forEach(inimigo -> inimigo.setAcaoRealizada(false));
	}

	private void realizarAtaque() {
		// Ordenando os participantes da batalha por velocidade
		List<ParticipanteDeBatalha> listaDeParticipante = getListaDeParticipanteOrdenadaPorVelocidade();
		
		// Realizando o ataque de cada participante
		for (ParticipanteDeBatalha participante : listaDeParticipante) {
			
			if (participante.isAcaoRealizada()) {
				continue; // Pula para o próximo da lista
			}
			if (participante instanceof InimigoComum) {
				participante.atacar(heroi);
			
			} else if (participante instanceof Heroi) {
				InimigoComum inimigo = getInimigoComMenorHp();
				participante.atacar(inimigo);
			}
			participante.setAcaoRealizada(true);
		}
	}

	private void tentarFugir() {
		double sorteNaFuga = Math.random() * 100; // Número qualquer de 0 a 100
		
		if (sorteNaFuga > 30) {
			tentativaDeFugaBemSucedida = true;
			return;
		}
		heroi.setAcaoRealizada(true);
		realizarAtaque();
	}

	private List<ParticipanteDeBatalha> getListaDeParticipanteOrdenadaPorVelocidade() {
		List<InimigoComum> listaDeInimigoNaoDerrotado = getListaDeInimigoNaoDerrotado();
		
		List<ParticipanteDeBatalha> listaDeParticipante = new ArrayList<>();
		listaDeParticipante.add(heroi);
		listaDeParticipante.addAll(listaDeInimigoNaoDerrotado);
		
		// Ordenando com o método sort da própria interface List (o comparador foi criado usando method reference)
		listaDeParticipante.sort(Comparator.comparing(ParticipanteDeBatalha::getVelocidade).reversed());
		
		return listaDeParticipante;
	}

	private InimigoComum getInimigoComMenorHp() {
		List<InimigoComum> listaDeInimigoNaoDerrotado = getListaDeInimigoNaoDerrotado();
		listaDeInimigoNaoDerrotado.sort(Comparator.comparing(ParticipanteDeBatalha::getHpRestante));
		
		return listaDeInimigoNaoDerrotado.get(0); // Retorna o primeiro da lista
	}

	private List<InimigoComum> getListaDeInimigoNaoDerrotado() {
		// Filtrando a lista de inimigos para manter apenas os que ainda não foram derrotados (o filtro foi criado usando lambda)
		return listaDeInimigo.stream().filter(inimigo -> !inimigo.isDerrotado()).collect(Collectors.toList());
	}

	public boolean isBatalhaConcluida() {
		if (heroi.isDerrotado()) {
			return true;
		}
		for (InimigoComum inimigo : listaDeInimigo) {
			if (!inimigo.isDerrotado()) {
				return false;
			}
		}
		return true;
	}

	public boolean isTentativaDeFugaBemSucedida() {
		return tentativaDeFugaBemSucedida;
	}
}
