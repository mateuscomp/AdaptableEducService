package br.ufpb.dcx.prolicen.educservice.performace;

import java.util.HashMap;
import java.util.Map;

import br.ufpb.dcx.prolicen.educservice.AdaptableEducServiceTest;
import br.ufpb.dcx.prolicen.educservice.model.EducServiceFacade;

public class AlunoPerformanceHelper {

	public static void cadastrarAlunoEExportarTempoGasto(
			EducServiceFacade facade, int index, String idTrace) {
		
		Map<String, String> trace = new HashMap<String, String>();
		trace.put("id", idTrace);

		long tempoInicial = System.currentTimeMillis();
		criarAluno(facade, index);
		long tempoFinal = System.currentTimeMillis() - tempoInicial;

		trace.put("tempoGastoEmMilisegundos", String.valueOf(tempoFinal));
		AdaptableEducServiceTest.gerarTrace(trace);
	}

	public static void criarAluno(EducServiceFacade facade, int index) {
		facade.criarAluno(("aluno" + index), ("login" + index),
				("senha" + index));
	}

	public static void pesquisarAlunoEExportarTempoGasto(
			EducServiceFacade facade, String id, String idTrace) {
		Map<String, String> trace = new HashMap<String, String>();
		trace.put("id", idTrace);

		long tempoInicial = System.currentTimeMillis();
		facade.pesquisarAluno(id);
		long tempoFinal = System.currentTimeMillis() - tempoInicial;

		trace.put("tempoGastoEmMilisegundos", String.valueOf(tempoFinal));
		AdaptableEducServiceTest.gerarTrace(trace);
	}
}