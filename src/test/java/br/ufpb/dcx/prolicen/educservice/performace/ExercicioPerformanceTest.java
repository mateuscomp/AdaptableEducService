package br.ufpb.dcx.prolicen.educservice.performace;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.AdaptableEducServiceTest;
import br.ufpb.dcx.prolicen.educservice.helper.ExercicioHelper;

public class ExercicioPerformanceTest extends AdaptableEducServiceTest {

	@Test
	public void verificarDesempenhoNoCadastroDeExercicio() {
		try {
			cadastrarEExportarTempoDeExecucaoNoCadastroDeExercicio(10);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public void cadastrarEExportarTempoDeExecucaoNoCadastroDeExercicio(
			int qtdQuestoes) throws Exception {

		Map<String, String> trace = new HashMap<String, String>();
		trace.put("tipo", PerformanceEvaluationTypeEnum.CREATE.toString());
		trace.put("nomeDaClasseDeTeste", this.getClass().getSimpleName());
		trace.put("nomeDoMetodo",
				"cadastrarEExportarTempoDeExecucaoNoCadastroDeExercicio");
		trace.put("quatidadeDeRegistros", String.valueOf(qtdQuestoes));
		trace.put("horaDeInicioExecucao", new Date().toString());

		long time = 0;
		try {
			for (int i = 0; i < qtdQuestoes; i++) {
				long tempoInicial = System.currentTimeMillis();

				ExercicioHelper.verificarCriacaoDeUmExercicioValido(facade,
						("palavraChaveA" + i), ("palavraChaveB" + i),
						("palavraChaveC" + i), ("palavraChaveD" + i),
						("palavraChaveE" + i));

				long tempoFinal = System.currentTimeMillis();
				time += (tempoFinal - tempoInicial);

				Thread.sleep(500);
			}
			trace.put("horaDeFimExecucao", new Date().toString());
			trace.put("tempoGastoEmMilisegundos", String.valueOf(time));
		} catch (Exception e) {
			trace.put("exception", e.getMessage());
			throw e;
		}
		super.gerarTrace(trace);
	}
}
