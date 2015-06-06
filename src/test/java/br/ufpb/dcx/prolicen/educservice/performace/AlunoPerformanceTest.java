package br.ufpb.dcx.prolicen.educservice.performace;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.AdaptableEducServiceTest;
import br.ufpb.dcx.prolicen.educservice.helper.AlunoHelper;

public class AlunoPerformanceTest extends AdaptableEducServiceTest {

	@Test
	public void verificarDesempenhoNasOperacoesAcercaDeAluno() {
		try {
			verificarDesempenhoAoCadastrarAlunos(10);
			verificarDesempenhoAoCadastrarAlunos(100);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public void verificarDesempenhoAoCadastrarAlunos(int quantidadeDeAlunos)
			throws Exception {
		Map<String, String> trace = new HashMap<String, String>();
		trace.put("tipo", PerformanceEvaluationTypeEnum.CREATE.toString());
		trace.put("nomeDaClasseDeTeste", this.getClass().getSimpleName());
		trace.put("nomeDoMetodo", "verificarDesempenhoAoCadastrarAlunos");
		trace.put("quatidadeDeRegistros", String.valueOf(quantidadeDeAlunos));
		trace.put("horaDeInicioExecucao", new Date().toString());

		long time = 0;
		try {
			for (int i = 0; i < quantidadeDeAlunos; i++) {
				long tempoInicial = System.currentTimeMillis();
				AlunoHelper.verificarCriacaoDeUmAlunoValido(facade,
						("aluno" + i), ("login" + i), ("senha" + i));
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
