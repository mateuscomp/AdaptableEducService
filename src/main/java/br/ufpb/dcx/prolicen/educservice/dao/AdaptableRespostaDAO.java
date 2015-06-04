package br.ufpb.dcx.prolicen.educservice.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import br.ufpb.dcx.prolicen.educservice.model.Questao;
import br.ufpb.dcx.prolicen.educservice.model.QuestaoMultiplaEscolha;

import com.nanuvem.lom.api.Entity;
import com.nanuvem.lom.api.EntityType;
import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.Property;
import com.nanuvem.lom.api.PropertyType;

public class AdaptableRespostaDAO extends AbstractAdaptableDAO {

	public static final String NAMESPACE_RESPOSTA_ENTITY_TYPE = "br.ufpb.educservice";
	public static final String NAME_RESPOSTA_ENTITY_TYPE = "Resposta";

	public static final String ID_ALUNO_PROPERTY_TYPE_NAME = "idAluno";
	public static final String ID_EXERCICIO_PROPERTY_TYPE_NAME = "idExercicio";
	public static final String ID_QUESTAO_PROPERTY_TYPE_NAME = "idQuestao";
	public static final String ALTERNATIVA_CORRETA_PROPERTY_TYPE_NAME = "alternativaCorreta";

	private EntityType respostaET;

	private PropertyType idAlunoPT;
	private PropertyType idExercicioPT;
	private PropertyType idQuestaoPT;
	private PropertyType alternativaCorretaPT;

	private AdaptableQuestaoMultiplaEscolhaDAO questaoMultiplaEscolhaDAO;

	public AdaptableRespostaDAO(Facade facade,
			AdaptableQuestaoMultiplaEscolhaDAO questaoMultiplaEscolhaDAO) {
		super(facade);
		this.questaoMultiplaEscolhaDAO = questaoMultiplaEscolhaDAO;
	}

	@Override
	protected void construirEntitiesTypesEPropertiesTypes() {
		this.respostaET = this.lomFacade
				.findEntityTypeByFullName(getFullnameRespostaEntityType());

		this.idAlunoPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ID_ALUNO_PROPERTY_TYPE_NAME,
						getFullnameRespostaEntityType());
		this.idExercicioPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ID_EXERCICIO_PROPERTY_TYPE_NAME,
						getFullnameRespostaEntityType());

		this.idQuestaoPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ID_QUESTAO_PROPERTY_TYPE_NAME,
						getFullnameRespostaEntityType());

		this.alternativaCorretaPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_CORRETA_PROPERTY_TYPE_NAME,
						getFullnameRespostaEntityType());
	}

	private String getFullnameRespostaEntityType() {
		return NAMESPACE_RESPOSTA_ENTITY_TYPE + "." + NAME_RESPOSTA_ENTITY_TYPE;
	}

	public void cadastrarRespostaQuestaoMEPorId(String idAluno,
			String idExercicio, String idQuestao, int alternativaCorreta) {

		Entity respostaEntity = new Entity();
		respostaEntity.setEntityType(this.respostaET);

		List<Property> properties = new LinkedList<Property>();

		Property idAlunoProperty = newProperty(idAlunoPT, idAluno,
				respostaEntity);
		properties.add(idAlunoProperty);

		Property idExercicioProperty = newProperty(idExercicioPT, idExercicio,
				respostaEntity);
		properties.add(idExercicioProperty);

		Property idQuestaoProperty = newProperty(idQuestaoPT, idQuestao,
				respostaEntity);
		properties.add(idQuestaoProperty);

		Property alternativaCorretaProperty = newProperty(alternativaCorretaPT,
				String.valueOf(alternativaCorreta), respostaEntity);
		properties.add(alternativaCorretaProperty);

		respostaEntity.setProperties(properties);
		this.lomFacade.create(respostaEntity);

	}

	public Questao pesquisarRespostaDeAlunoEmUmaQuestao(String idAluno,
			String idExercicio, String idQuestao) {

		Map<String, String> valoresDasProperties = new HashMap<String, String>();
		valoresDasProperties.put(ID_ALUNO_PROPERTY_TYPE_NAME, idAluno);
		valoresDasProperties.put(ID_EXERCICIO_PROPERTY_TYPE_NAME, idExercicio);
		valoresDasProperties.put(ID_QUESTAO_PROPERTY_TYPE_NAME, idQuestao);

		List<Entity> respostasEntity = this.lomFacade
				.findEntityByNameOfPropertiesTypeAndByValueOfProperties(
						getFullnameRespostaEntityType(), valoresDasProperties);

		if (respostasEntity != null && respostasEntity.size() > 0) {
			return converterEmResposta(respostasEntity.get(0));
		}

		return null;
	}

	private Questao converterEmResposta(Entity entity) {
		List<Property> properties = entity.getProperties();

		String idQuestao = properties.get(2).getValue();
		int alternativaCorreta = Integer.parseInt(properties.get(3).getValue());

		QuestaoMultiplaEscolha questao = questaoMultiplaEscolhaDAO
				.pesquisarQuestaoMEPorId(idQuestao);
		questao.setAlternativaCorreta(alternativaCorreta);

		return questao;
	}
}
