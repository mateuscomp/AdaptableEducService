package br.ufpb.dcx.prolicen.educservice.performace;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.AdaptableEducServiceTest;
import br.ufpb.dcx.prolicen.educservice.helper.RespostaDeQuestaoHelper;
import br.ufpb.dcx.prolicen.educservice.model.Aluno;
import br.ufpb.dcx.prolicen.educservice.model.Exercicio;
import br.ufpb.dcx.prolicen.educservice.model.QuestaoMultiplaEscolha;

public class RespostaDeQuestaoPerformanceTest extends AdaptableEducServiceTest {

	@Test
	public void verificarDesempenhoNasOperacoesAcercaDeRespostaDeQuestao() {
		try {
			verificarDesempenhoAoCadastrarRespostaDeQuestao(10);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public void verificarDesempenhoAoCadastrarRespostaDeQuestao(int qtdQuestoes)
			throws Exception {

		Map<String, String> trace = new HashMap<String, String>();
		trace.put("tipo", PerformanceEvaluationTypeEnum.CREATE.toString());
		trace.put("nomeDaClasseDeTeste", this.getClass().getSimpleName());
		trace.put("nomeDoMetodo",
				"verificarDesempenhoAoCadastrarRespostaDeQuestao");
		trace.put("quatidadeDeRegistros", String.valueOf(qtdQuestoes));
		trace.put("horaDeInicioExecucao", new Date().toString());

		Exercicio exercicio = facade.criarExercicio();

		Aluno aluno = facade.criarAluno("aluno01", "login01", "senha01");

		List<String> alternativas = new LinkedList<String>();
		alternativas.add("alternativa01");
		alternativas.add("alternativa02");
		alternativas.add("alternativa03");
		alternativas.add("alternativa04");
		alternativas.add("alternativa05");
		QuestaoMultiplaEscolha questaoDeMultiplaEscolha = facade
				.cadastrarQuestaoME(exercicio.getId(), "Enunciado01",
						alternativas, 1);

		long time = 0;
		try {
			for (int i = 0; i < qtdQuestoes; i++) {

				long tempoInicial = System.currentTimeMillis();
				RespostaDeQuestaoHelper
						.verificarCriacaoDeUmaRespostaCorretaParaUmaQuestaoDeMultiplaEscolhaValida(
								facade, aluno.getId(), exercicio.getId(),
								questaoDeMultiplaEscolha.getId(), 1);

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