package br.ufpb.dcx.prolicen.educservice.helper;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

import br.ufpb.dcx.prolicen.educservice.model.EducServiceFacade;
import br.ufpb.dcx.prolicen.educservice.model.Exercicio;
import br.ufpb.dcx.prolicen.educservice.model.QuestaoMultiplaEscolha;

public class QuestaoMultiplaEscolhaHelper {

	public static QuestaoMultiplaEscolha verificarCriacaoDeUmQuestaoDeMultiplaEscolhaValida(
			EducServiceFacade facade, String enunciado, Exercicio exercicio,
			int indiceAlternativaCorreta, String... alternativas) {

		List<String> alternativasList = new LinkedList<String>();
		int qtdMaxAlternativas = 5;
		for (int i = 0; i < qtdMaxAlternativas; i++) {
			alternativasList.add(alternativas[i]);
		}

		QuestaoMultiplaEscolha qME = facade.cadastrarQuestaoME(
				exercicio.getId(), enunciado, alternativasList,
				indiceAlternativaCorreta);

		QuestaoMultiplaEscolha qMEPesquisada = facade.pesquisarQuestaoMEPorId(
				exercicio.getId(), String.valueOf(qME.getId()));

		Assert.assertEquals(qME.getEnunciado(), qMEPesquisada.getEnunciado());
		Assert.assertEquals(qME.getAlternativaCorreta(),
				qMEPesquisada.getAlternativaCorreta());
		Assert.assertEquals(qME.getDescricao(), qMEPesquisada.getDescricao());
		Assert.assertEquals(qME.getSolucao(), qMEPesquisada.getSolucao());

		for (int i = 0; i < alternativasList.size(); i++) {
			Assert.assertEquals(alternativasList.get(i), qMEPesquisada
					.getAlternativas().get(i));
		}
		return qME;
	}
}
