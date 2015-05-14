package br.ufpb.dcx.prolicen.educservice.adaptable.impl;

import java.util.List;

import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.business.BusinessFacade;
import com.nanuvem.lom.kernel.dao.MySqlDaoFactory;

import br.ufpb.dcx.prolicen.educservice.educservice.Aluno;
import br.ufpb.dcx.prolicen.educservice.educservice.EducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.educservice.Exercicio;
import br.ufpb.dcx.prolicen.educservice.educservice.Questao;
import br.ufpb.dcx.prolicen.educservice.educservice.QuestaoDissertativa;
import br.ufpb.dcx.prolicen.educservice.educservice.QuestaoMultiplaEscolha;
import br.ufpb.dcx.prolicen.educservice.educservice.QuestaoVouF;

public class AdaptableEducServiceFacade implements EducServiceFacade {

	private Facade lomFacade ;
	private QuestaoMultiplaEscolhaService questaoMultiplaEscolhaService;
	
	public AdaptableEducServiceFacade(){
		new BusinessFacade(new MySqlDaoFactory());
		questaoMultiplaEscolhaService = new QuestaoMultiplaEscolhaService(lomFacade);
	}

	public Aluno criarAluno(String login, String senha) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cadastraRespostaVFDeAluno(String idAluno, String idExercicio,
			String idQuestao, List<String> respostas) {
		// TODO Auto-generated method stub

	}

	public void cadastrarRespostaQuestaoMEPorId(String idAluno,
			String idExercicio, String idQuestao, int alternativaCorreta) {
		// TODO Auto-generated method stub

	}

	public void cadastrarRespostaQuestaoDissertativaPorId(String idAluno,
			String idExercicio, String idQuestao, String solucao) {
		// TODO Auto-generated method stub

	}

	public void removerAluno(String idAluno) {
		// TODO Auto-generated method stub

	}

	public Questao consultaRespostaDeAluno(String idAluno, String idExercicio,
			String idQuestao) {
		// TODO Auto-generated method stub
		return null;
	}

	public Exercicio criarExercicio() {
		// TODO Auto-generated method stub
		return null;
	}

	public Exercicio criarExercicio(List<String> palavrasChave) {
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

	public Exercicio pesquisarExercicioPorId(String idExercicio) {
		// TODO Auto-generated method stub
		return null;
	}

	public QuestaoMultiplaEscolha cadastrarQuestaoME(String idExercicio,
			String enunciado, List<String> alternativas) {
		// TODO Auto-generated method stub
		return null;
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

	public QuestaoMultiplaEscolha pesquisarQuestaoMEPorId(String idExercicio,
			String idQuestao) {
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

	public QuestaoMultiplaEscolha cadastrarQuestaoME(String idExercicio,
			String enunciado, List<String> alternativas, int alternativaCorreta) {

		return this.questaoMultiplaEscolhaService.cadastrarQuestaoME(
				idExercicio, enunciado, alternativas, alternativaCorreta);
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
