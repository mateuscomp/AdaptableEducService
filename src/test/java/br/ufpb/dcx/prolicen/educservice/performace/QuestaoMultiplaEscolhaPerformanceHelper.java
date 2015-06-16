package br.ufpb.dcx.prolicen.educservice.performace;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.ufpb.dcx.prolicen.educservice.AdaptableEducServiceTest;
import br.ufpb.dcx.prolicen.educservice.model.AdaptableEducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.model.Exercicio;

public class QuestaoMultiplaEscolhaPerformanceHelper {

	public static void cadastrarQuestaoMultiplaEscolhaEExportarTempoGasto(
			AdaptableEducServiceFacade facade, Exercicio exercicio, int index,
			String idTrace) {

		Map<String, String> trace = new HashMap<String, String>();
		trace.put("id", idTrace);

		long tempoInicial = System.currentTimeMillis();

		cadastrarQuestaoMultiplaEscolha(facade, exercicio);

		long tempoFinal = System.currentTimeMillis() - tempoInicial;
		trace.put("tempoGastoEmMilisegundos", String.valueOf(tempoFinal));
		AdaptableEducServiceTest.gerarTrace(trace);
	}

	public static void cadastrarQuestaoMultiplaEscolha(
			AdaptableEducServiceFacade facade, Exercicio exercicio) {
		
		int qtdMaxAlternativas = 5;
		List<String> alternativasList = new LinkedList<String>();
		for (int i = 0; i < qtdMaxAlternativas; i++) {
			alternativasList.add("alternativa" + (i + 1));
		}
		facade.cadastrarQuestaoME(exercicio.getId(),
				"enunciado" + exercicio.getId(), alternativasList, 1);
	}

	public static void pesquisarPrimeiraQuestaoDeMultiplaEscolhaDeExercicioEExportarTempoGasto(
			AdaptableEducServiceFacade facade, String idExercicio,
			String idQuestao, String idTrace) {

		Map<String, String> trace = new HashMap<String, String>();
		trace.put("id", idTrace);
		long tempoInicial = System.currentTimeMillis();

		facade.pesquisarQuestaoMEPorId(idExercicio, idQuestao);

		long tempoFinal = System.currentTimeMillis() - tempoInicial;
		trace.put("tempoGastoEmMilisegundos", String.valueOf(tempoFinal));
		AdaptableEducServiceTest.gerarTrace(trace);
	}
}