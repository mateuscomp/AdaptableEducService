package br.ufpb.dcx.prolicen.educservice.model;

import java.util.List;

import br.ufpb.dcx.prolicen.educservice.adaptable.dao.AdaptableAlunoDAO;
import br.ufpb.dcx.prolicen.educservice.adaptable.dao.AdaptableExercicioDAO;
import br.ufpb.dcx.prolicen.educservice.adaptable.dao.AdaptableQuestaoMultiplaEscolhaDAO;
import br.ufpb.dcx.prolicen.educservice.adaptable.dao.AdaptableRespostaDAO;

import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.business.FacadeFactory;

public class AdaptableEducServiceFacade implements EducServiceFacade {

	private Facade lomFacade;
	private AdaptableQuestaoMultiplaEscolhaDAO questaoMultiplaEscolhaDAO;
	private AdaptableExercicioDAO exercicioDAO;
	private AdaptableAlunoDAO alunoDAO;
	private AdaptableRespostaDAO respostaDAO;

	public AdaptableEducServiceFacade() {
		this.lomFacade = new FacadeFactory().createFacade();

		this.questaoMultiplaEscolhaDAO = new AdaptableQuestaoMultiplaEscolhaDAO(
				lomFacade);
		this.alunoDAO = new AdaptableAlunoDAO(lomFacade);
		this.exercicioDAO = new AdaptableExercicioDAO(lomFacade);
		this.respostaDAO = new AdaptableRespostaDAO(lomFacade);
	}

	// Aluno
	public Aluno criarAluno(String nome, String login, String senha) {
		return this.alunoDAO.criarAluno(nome, login, senha);
	}

	public Aluno pesquisarAluno(String id) {
		return this.alunoDAO.pesquisarAluno(id);
	}

	public void removerAluno(String idAluno) {
		this.alunoDAO.removerAluno(idAluno);
	}

	// Exercício
	public Exercicio criarExercicio() {
		return this.exercicioDAO.criarExercicio();
	}

	public Exercicio criarExercicio(List<String> palavrasChave) {
		return this.exercicioDAO.criarExercicio(palavrasChave);
	}

	public Exercicio pesquisarExercicioPorId(String idExercicio) {
		return this.exercicioDAO.pesquisarExercicioPorId(idExercicio);
	}

	// QUESTÔES DE MULTIPLA ESCOLHA
	public QuestaoMultiplaEscolha cadastrarQuestaoME(String idExercicio,
			String enunciado, List<String> alternativas) {

		return this.questaoMultiplaEscolhaDAO.cadastrarQuestaoME(idExercicio,
				enunciado, alternativas, null);
	}

	public QuestaoMultiplaEscolha cadastrarQuestaoME(String idExercicio,
			String enunciado, List<String> alternativas, int alternativaCorreta) {

		return this.questaoMultiplaEscolhaDAO.cadastrarQuestaoME(idExercicio,
				enunciado, alternativas, alternativaCorreta);
	}

	public QuestaoMultiplaEscolha pesquisarQuestaoMEPorId(String idExercicio,
			String idQuestao) {

		return this.questaoMultiplaEscolhaDAO
				.pesquisarQuestaoMEPorId(idQuestao);
	}

	public void cadastrarRespostaQuestaoMEPorId(String idAluno,
			String idExercicio, String idQuestao, int alternativaCorreta) {

		this.respostaDAO.cadastrarRespostaQuestaoMEPorId(idAluno, idExercicio,
				idQuestao, alternativaCorreta);
	}

	public void cadastraRespostaVFDeAluno(String idAluno, String idExercicio,
			String idQuestao, List<String> respostas) {
		// TODO Auto-generated method stub

	}

	public void cadastrarRespostaQuestaoDissertativaPorId(String idAluno,
			String idExercicio, String idQuestao, String solucao) {
		// TODO Auto-generated method stub

	}

	public Questao consultaRespostaDeAluno(String idAluno, String idExercicio,
			String idQuestao) {
		// TODO Auto-generated method stub
		return null;
	}

	public void configuraPalavrasChave(String idExercicio) {
		// TODO Auto-generated method stub

	}

	public void apagar(String idExercicio) {
		// TODO Auto-generated method stub

	}

	public void atualizar(Exercicio e) {
		// TODO Auto-generated method stub

	}

	public QuestaoVouF cadastrarQuestaoVouF(String idExercicio,
			List<String> afirmativas) {
		// TODO Auto-generated method stub
		return null;
	}

	public QuestaoDissertativa cadastrarQuestaoDissertativa(String idExercicio,
			String enunciado) {
		// TODO Auto-generated method stub
		return null;
	}

	public Questao pesquisarQuestaoPorId(String idExercicio, String idQuestao) {
		// TODO Auto-generated method stub
		return null;
	}

	public QuestaoVouF pesquisarQuestaoVouFPorId(String idExercicio,
			String idQuestao) {
		// TODO Auto-generated method stub
		return null;
	}

	public QuestaoDissertativa pesquisarQuestaoDissertativaPorId(
			String idExercicio, String idQuestao) {
		// TODO Auto-generated method stub
		return null;
	}

	public QuestaoMultiplaEscolha cadastrarRespostaQuestaoMEPorId(
			String idExercicio, int alternativaCorreta) {
		// TODO Auto-generated method stub
		return null;
	}

	public QuestaoVouF cadastrarRespostaQuestaoVouFPorId(String idExercicio,
			String idQuestao, List<String> respostas) {
		// TODO Auto-generated method stub
		return null;
	}

	public QuestaoDissertativa cadastrarRespostaQuestaoDissertativaPorId(
			String idExercicio, String idQuestao, String solucao) {
		// TODO Auto-generated method stub
		return null;
	}

	public QuestaoVouF cadastrarQuestaoVouF(String idExercicio,
			List<String> afirmativas, List<String> respostas) {
		// TODO Auto-generated method stub
		return null;
	}

	public QuestaoDissertativa cadastrarQuestaoDissertativa(String idExercicio,
			String enunciado, String solucao) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Exercicio> pesquisarTodosOsExercicios() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Exercicio> pesquisarExerciciosSobre(List<String> palavrasChave) {
		// TODO Auto-generated method stub
		return null;
	}

}
