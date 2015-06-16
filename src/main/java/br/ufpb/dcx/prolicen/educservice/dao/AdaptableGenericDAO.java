package br.ufpb.dcx.prolicen.educservice.dao;

import com.nanuvem.lom.api.EntityType;
import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.PropertyType;
import com.nanuvem.lom.api.Type;

public class AdaptableGenericDAO extends AbstractAdaptableDAO {

	public AdaptableGenericDAO(Facade facade) {
		super(facade);
	}

	public void criarEducServiceSchema() {
		criarEntityTypeEPropertiesTypesDeAluno();
		criarEntityTypeEPropertiesTypesDeExercicio();
		criarEntityTypeEPropertiesTypesDeQuestaoDeMultiplaEscolha();
		criarEntityTypeEPropertiesTypesDeRepostaDeQuetaoDeMultilplaEscolha();
	}

	private void criarEntityTypeEPropertiesTypesDeAluno() {
		EntityType alunoEntityType = criarUmEntityType(
				AdaptableAlunoDAO.NAMESPACE_ALUNO_ENTITY_TYPE,
				AdaptableAlunoDAO.NAME_ALUNO_ENTITY_TYPE);

		criarUmPropertyType(alunoEntityType,
				AdaptableAlunoDAO.NOME_PROPERTY_TYPE_NAME, Type.TEXT,
				"{\"mandatory\" : true}");

		criarUmPropertyType(alunoEntityType,
				AdaptableAlunoDAO.LOGIN_PROPERTY_TYPE_NAME, Type.TEXT,
				"{\"mandatory\" : true}");

		criarUmPropertyType(alunoEntityType,
				AdaptableAlunoDAO.SENHA_PROPERTY_TYPE_NAME, Type.PASSWORD,
				"{\"mandatory\" : true}");
	}

	private void criarEntityTypeEPropertiesTypesDeExercicio() {
		EntityType exercicioEntityType = criarUmEntityType(
				AdaptableExercicioDAO.NAMESPACE_EXERCICIO_ENTITY_TYPE,
				AdaptableExercicioDAO.NAME_EXERCICIO_ENTITY_TYPE);

		criarUmPropertyType(exercicioEntityType,
				AdaptableExercicioDAO.PALAVRA_CHAVE_01, Type.TEXT, null);

		criarUmPropertyType(exercicioEntityType,
				AdaptableExercicioDAO.PALAVRA_CHAVE_02, Type.TEXT, null);

		criarUmPropertyType(exercicioEntityType,
				AdaptableExercicioDAO.PALAVRA_CHAVE_03, Type.TEXT, null);

		criarUmPropertyType(exercicioEntityType,
				AdaptableExercicioDAO.PALAVRA_CHAVE_04, Type.TEXT, null);

		criarUmPropertyType(exercicioEntityType,
				AdaptableExercicioDAO.PALAVRA_CHAVE_05, Type.TEXT, null);
	}

	private void criarEntityTypeEPropertiesTypesDeQuestaoDeMultiplaEscolha() {
		EntityType qMEEntityType = criarUmEntityType(
				AdaptableQuestaoMultiplaEscolhaDAO.NAMESPACE_QUESTAO_MULTIPLA_ESCOLHA,
				AdaptableQuestaoMultiplaEscolhaDAO.NAME_QUESTAO_MULTIPLA_ESCOLHA);

		criarUmPropertyType(
				qMEEntityType,
				AdaptableQuestaoMultiplaEscolhaDAO.ENUNCIADO_PROPERTY_TYPE_NAME,
				Type.LONGTEXT, "{\"mandatory\" : true}");

		criarUmPropertyType(
				qMEEntityType,
				AdaptableQuestaoMultiplaEscolhaDAO.ALTERNATIVA_CORRETA_PROPERTY_TYPE_NAME,
				Type.INTEGER, "{\"mandatory\" : true, \"minvalue\" : 1}");

		criarUmPropertyType(
				qMEEntityType,
				AdaptableQuestaoMultiplaEscolhaDAO.ALTERNATIVA_A_PROPERTY_TYPE_NAME,
				Type.TEXT, "{\"mandatory\" : true}");

		criarUmPropertyType(
				qMEEntityType,
				AdaptableQuestaoMultiplaEscolhaDAO.ALTERNATIVA_B_PROPERTY_TYPE_NAME,
				Type.TEXT, "{\"mandatory\" : true}");

		criarUmPropertyType(
				qMEEntityType,
				AdaptableQuestaoMultiplaEscolhaDAO.ALTERNATIVA_C_PROPERTY_TYPE_NAME,
				Type.TEXT, "{\"mandatory\" : true}");

		criarUmPropertyType(
				qMEEntityType,
				AdaptableQuestaoMultiplaEscolhaDAO.ALTERNATIVA_D_PROPERTY_TYPE_NAME,
				Type.TEXT, "{\"mandatory\" : true}");

		criarUmPropertyType(
				qMEEntityType,
				AdaptableQuestaoMultiplaEscolhaDAO.ALTERNATIVA_E_PROPERTY_TYPE_NAME,
				Type.TEXT, "{\"mandatory\" : true}");

		criarUmPropertyType(
				qMEEntityType,
				AdaptableQuestaoMultiplaEscolhaDAO.ID_EXERCICIO_PROPERTY_TYPE_NAME,
				Type.INTEGER, "{\"mandatory\" : true, \"minvalue\" : 1}");
	}

	private void criarEntityTypeEPropertiesTypesDeRepostaDeQuetaoDeMultilplaEscolha() {
		EntityType respostaEntityType = criarUmEntityType(
				AdaptableRespostaDAO.NAMESPACE_RESPOSTA_ENTITY_TYPE,
				AdaptableRespostaDAO.NAME_RESPOSTA_ENTITY_TYPE);

		criarUmPropertyType(respostaEntityType,
				AdaptableRespostaDAO.ID_ALUNO_PROPERTY_TYPE_NAME, Type.INTEGER,
				"{\"mandatory\" : true, \"minvalue\" : 1}");

		criarUmPropertyType(respostaEntityType,
				AdaptableRespostaDAO.ID_EXERCICIO_PROPERTY_TYPE_NAME,
				Type.INTEGER, "{\"mandatory\" : true, \"minvalue\" : 1}");

		criarUmPropertyType(respostaEntityType,
				AdaptableRespostaDAO.ID_QUESTAO_PROPERTY_TYPE_NAME,
				Type.INTEGER, "{\"mandatory\" : true, \"minvalue\" : 1}");

		criarUmPropertyType(respostaEntityType,
				AdaptableRespostaDAO.ALTERNATIVA_CORRETA_PROPERTY_TYPE_NAME,
				Type.INTEGER,
				"{\"mandatory\" : true, \"minvalue\" : 1, \"maxvalue\" : 5}");
	}

	private EntityType criarUmEntityType(String namespace, String name) {
		EntityType entityType = new EntityType();
		entityType.setName(name);
		entityType.setNamespace(namespace);
		return lomFacade.create(entityType);
	}

	private void criarUmPropertyType(EntityType entityType,
			String propertyTypeName, Type type, String configuration) {

		PropertyType propertyType = new PropertyType();
		propertyType.setName(propertyTypeName);
		propertyType.setType(type);
		propertyType.setEntityType(entityType);
		propertyType.setConfiguration(configuration);
		this.lomFacade.create(propertyType);
	}

	@Override
	protected void construirEntitiesTypesEPropertiesTypes() {
		// TODO Auto-generated method stub
	}
}
