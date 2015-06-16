package br.ufpb.dcx.prolicen.educservice;

import org.junit.Test;

import br.ufpb.dcx.prolicen.educservice.model.Exercicio;
import br.ufpb.dcx.prolicen.educservice.performace.AlunoPerformanceHelper;
import br.ufpb.dcx.prolicen.educservice.performace.ExercicioPerformanceHelper;
import br.ufpb.dcx.prolicen.educservice.performace.QuestaoMultiplaEscolhaPerformanceHelper;

public class EducServicePerformanceEvaluationTest extends
		AdaptableEducServiceTest {

	/**
	 * Cenário 1: Cadastrar 10.000 alunos e medir o tempo de cada cadastro.
	 * Depois colocar cada tempo desse numa planilha e traçar o gráfico desse
	 * tempo medido ao longo a medida em que aumenta o número de alunos Variável
	 * #tempoCadastroAluno
	 */
	@Test
	public void coletarTempoGastoParaCadastrarMuitosAlunos() {
		int quantidadeDeAlunosACadastrar = 10000;

		for (int i = 0; i < quantidadeDeAlunosACadastrar; i++) {
			AlunoPerformanceHelper.cadastrarAlunoEExportarTempoGasto(facade, i,
					"#tempoCadastroAluno");
			sleep(2000);
		}
	}

	/**
	 * Cenário 2: Cadastra um exercício e vai aumentando o número de questões
	 * até 10.000 e calcula o tempo gasto para cadastrar cada questão Variável
	 * #tempoCadastroQuestao1Exercicio
	 */
	@Test
	public void coletarTempoGastoParaCadastrarUmExercicioComMuitasQuestoes() {
		Exercicio exercicio = ExercicioPerformanceHelper
				.criarExercicioComCincoPalavrasChave(facade);

		int quantidadeDeQuestoes = 10000;
		for (int i = 0; i < quantidadeDeQuestoes; i++) {
			QuestaoMultiplaEscolhaPerformanceHelper
					.cadastrarQuestaoMultiplaEscolhaEExportarTempoGasto(facade,
							exercicio, i, "#tempoCadastroQuestao1Exercicio");
			sleep(2000);
		}
	}

	/**
	 * Cenário 3: Cadastrar 10.000 exercícios de 10 questões cada e calcular o
	 * tempo de cadastro de cada exercício Variável
	 * #tempoCadastroExercicio10Questoes
	 */
	@Test
	public void coletarTempoGastoParaCadastrarMuitosExercicioComDezQuestoes() {
		int quantidadeDeExercicios = 10000;
		int quantidadeDeQuestoes = 10;

		for (int i = 0; i < quantidadeDeExercicios; i++) {
			ExercicioPerformanceHelper
					.cadastrarExercicioComQuestoesDeMultiplaEscolhaEExportarTempoGasto(
							facade, quantidadeDeQuestoes,
							"#tempoCadastroExercicio10Questoes");
			sleep(5000);
		}
	}

	/**
	 * Cenário 4: - Depois de cadastrar 10.000 Exercícios e 10.000 alunos, você
	 * vai calcular o tempo para fazer a pesquisa de um aluno e de um exercício
	 * #tempoPesquisaAluno (do 1o. ao último aluno) #tempoPesquisaExercicio (do
	 * 1o. ao último exercício) #tempoPesquisaQuestao (do 1o. ao último
	 * exercício a primeira questão de cada um)
	 */
	@Test
	public void coletarTempoDePesquisaDeExercicioEAlunoDepoisComMuitosExerciciosEMuitosAlunosCadastrados() {
		int qtdDeExerciciosEAlunos = 10000;
		int qtdQuestoesPorExercicio = 10;
		long timeSleep = 5000;

		this.cadastrarMuitosAlunosMuitosExerciciosMuitasQuestoes(
				qtdDeExerciciosEAlunos, qtdQuestoesPorExercicio, timeSleep);

		for (int i = 1; i <= qtdDeExerciciosEAlunos; i++) {
			AlunoPerformanceHelper.pesquisarAlunoEExportarTempoGasto(facade,
					String.valueOf(i), "#tempoPesquisaAluno");
			sleep(timeSleep);
		}

		for (int i = 0; i < qtdDeExerciciosEAlunos; i++) {
			String idDoExercicio = String.valueOf(i * 10 + 2 * i + 2);
			ExercicioPerformanceHelper.pesquisarExercioEExportarTempoGasto(
					facade, idDoExercicio, "#tempoPesquisaExercicio");
			sleep(timeSleep);
		}

		int idQuestao = 3;
		for (int i = 0; i < qtdQuestoesPorExercicio; i++) {
			for (int j = 1; j <= qtdDeExerciciosEAlunos; j++) {
				QuestaoMultiplaEscolhaPerformanceHelper
						.pesquisarPrimeiraQuestaoDeMultiplaEscolhaDeExercicioEExportarTempoGasto(
								facade, String.valueOf(j),
								String.valueOf(idQuestao),
								"#tempoPesquisaQuestao");
				sleep(timeSleep);
				idQuestao++;
			}
			
			// Esse incremento ocorre devido a quantidade de property criada
			// quando um novo exercicio é criado
			idQuestao += 2;
		}
	}

	private void cadastrarMuitosAlunosMuitosExerciciosMuitasQuestoes(
			int qtdDeExerciciosEAlunos, int qtdQuestoesPorExercicio,
			long timeSleep) {

		for (int i = 0; i < qtdDeExerciciosEAlunos; i++) {
			AlunoPerformanceHelper.criarAluno(facade, i);

			Exercicio exercicio = ExercicioPerformanceHelper
					.criarExercicioComCincoPalavrasChave(facade);

			for (int j = 0; j < qtdQuestoesPorExercicio; j++) {
				QuestaoMultiplaEscolhaPerformanceHelper
						.cadastrarQuestaoMultiplaEscolha(facade, exercicio);
			}
			sleep(timeSleep);
		}
	}

	private void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
