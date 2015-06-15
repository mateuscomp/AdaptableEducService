package br.ufpb.dcx.prolicen.educservice.performace;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.ufpb.dcx.prolicen.educservice.AdaptableEducServiceTest;
import br.ufpb.dcx.prolicen.educservice.model.AdaptableEducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.model.Exercicio;

public class ExercicioPerformanceHelper {

	public static void cadastrarExercicioComQuestoesDeMultiplaEscolhaEExportarTempoGasto(
			AdaptableEducServiceFacade facade, int quantidadeDeQuestoes,
			String idTrace) {

		Map<String, String> trace = new HashMap<String, String>();
		trace.put("id", idTrace);

		Exercicio exercicio = criarExercicioComCincoPalavrasChave(facade);

		for (int i = 0; i < quantidadeDeQuestoes; i++) {
			List<String> alternativas = new LinkedList<String>();
			alternativas.add("alternativaA" + i);
			alternativas.add("alternativaB" + i);
			alternativas.add("alternativaC" + i);
			alternativas.add("alternativaD" + i);
			alternativas.add("alternativaE" + i);

			facade.cadastrarQuestaoME(exercicio.getId(), "enunciado" + i,
					alternativas, 1);
		}
	}

	public static Exercicio criarExercicioComCincoPalavrasChave(
			AdaptableEducServiceFacade facade) {

		List<String> palavrasChave = new LinkedList<String>();
		palavrasChave.add("palavraChave01");
		palavrasChave.add("palavraChave02");
		palavrasChave.add("palavraChave03");
		palavrasChave.add("palavraChave04");
		palavrasChave.add("palavraChave05");
		return facade.criarExercicio(palavrasChave);
	}

	public static void pesquisarExercioEExportarTempoGasto(
			AdaptableEducServiceFacade facade, String id, String idTrace) {

		Map<String, String> trace = new HashMap<String, String>();
		trace.put("id", idTrace);

		long tempoInicial = System.currentTimeMillis();
		facade.pesquisarExercicioPorId(id);
		long tempoFinal = System.currentTimeMillis() - tempoInicial;

		trace.put("tempoGastoEmMilisegundos", String.valueOf(tempoFinal));
		AdaptableEducServiceTest.gerarTrace(trace);
	}
}