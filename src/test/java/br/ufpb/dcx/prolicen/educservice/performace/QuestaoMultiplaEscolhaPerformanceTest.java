package br.ufpb.dcx.prolicen.educservice.performace;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.AdaptableEducServiceTest;
import br.ufpb.dcx.prolicen.educservice.helper.QuestaoMultiplaEscolhaHelper;
import br.ufpb.dcx.prolicen.educservice.model.Exercicio;

public class QuestaoMultiplaEscolhaPerformanceTest extends
		AdaptableEducServiceTest {

	@Test
	public void verificarDesempenhoNasOperacoesAcercaDeQuestaoDeMultiplaEscolha() {
		try {
			verificarDesempenhoAoCadastrarQuestaoMultiplaEscolha(10);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public void verificarDesempenhoAoCadastrarQuestaoMultiplaEscolha(
			int qtdQuestoes) throws Exception {

		Map<String, String> trace = new HashMap<String, String>();
		trace.put("tipo", PerformanceEvaluationTypeEnum.CREATE.toString());
		trace.put("nomeDaClasseDeTeste", this.getClass().getSimpleName());
		trace.put("nomeDoMetodo",
				"verificarDesempenhoAoCadastrarQuestaoMultiplaEscolha");
		trace.put("quatidadeDeRegistros", String.valueOf(qtdQuestoes));
		trace.put("horaDeInicioExecucao", new Date().toString());

		Exercicio exercicio = facade.criarExercicio();
		long time = 0;
		try {
			for (int i = 0; i < qtdQuestoes; i++) {

				long tempoInicial = System.currentTimeMillis();
				QuestaoMultiplaEscolhaHelper
						.verificarCriacaoDeUmQuestaoDeMultiplaEscolhaValida(
								facade, "enunciado" + i, exercicio, 1,
								("alternativaA" + i), ("alternativaB" + i),
								("alternativaC" + i), ("alternativaD" + i),
								("alternativaE" + i));

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
