package br.ufpb.dcx.prolicen.educservice.adaptable.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.dcx.prolicen.educservice.educservice.QuestaoMultiplaEscolha;

import com.nanuvem.lom.api.Entity;
import com.nanuvem.lom.api.EntityType;
import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.Property;
import com.nanuvem.lom.api.PropertyType;

public class AdaptableQuestaoMultiplaEscolhaDAO extends AdaptableDAO {

	private static final int INDICE_ID = 0;
	private static final int INDICE_ENUNCIADO = 2;
	private static final int INDICE_ALTERNATIVA_CORRETA = 3;
	private static final int INDICE_ALTERNATIVA_A = 4;
	private static final int INDICE_ALTERNATIVA_B = 5;
	private static final int INDICE_ALTERNATIVA_C = 6;
	private static final int INDICE_ALTERNATIVA_D = 7;
	private static final int INDICE_ALTERNATIVA_E = 8;

	private static final String FULLNAME_QUESTAO_MULTIPLA_ESCOLHA = "br.ufpb.educservice.QuestaoMultiplaEscolha";

	private static final String ID_PROPERTY_TYPE_NAME = "id";
	private static final String ENUNCIADO_PROPERTY_TYPE_NAME = "enunciado";
	private static final String ALTERNATIVA_CORRETA_PROPERTY_TYPE_NAME = "alternativaCorreta";
	private static final String ALTERNATIVA_A_PROPERTY_TYPE_NAME = "alternativaA";
	private static final String ALTERNATIVA_B_PROPERTY_TYPE_NAME = "alternativaB";
	private static final String ALTERNATIVA_C_PROPERTY_TYPE_NAME = "alternativaC";
	private static final String ALTERNATIVA_D_PROPERTY_TYPE_NAME = "alternativaD";
	private static final String ALTERNATIVA_E_PROPERTY_TYPE_NAME = "alternativaE";
	private static final String ID_EXERCICIO_PROPERTY_TYPE_NAME = "idExercicio";

	private EntityType questaoMultilplaEscolhaET;

	private PropertyType enunciadoPT;
	private PropertyType alternativaCorretaPT;
	private PropertyType alternativaAPT;
	private PropertyType alternativaBPT;
	private PropertyType alternativaCPT;
	private PropertyType alternativaDPT;
	private PropertyType alternativaEPT;
	private PropertyType idExercicioPT;
	private PropertyType idPT;

	public AdaptableQuestaoMultiplaEscolhaDAO(Facade lomFacade) {
		super(lomFacade);
	}

	@Override
	protected void construirEntitiesTypesEPropertiesTypes() {
		questaoMultilplaEscolhaET = this.lomFacade
				.findEntityTypeByFullName(FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		idPT = this.lomFacade.findPropertyTypeByNameAndFullnameEntityType(
				ID_PROPERTY_TYPE_NAME, FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		enunciadoPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ENUNCIADO_PROPERTY_TYPE_NAME,
						FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		alternativaCorretaPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_CORRETA_PROPERTY_TYPE_NAME,
						FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		alternativaAPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_A_PROPERTY_TYPE_NAME,
						FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		alternativaBPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_B_PROPERTY_TYPE_NAME,
						FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		alternativaCPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_C_PROPERTY_TYPE_NAME,
						FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		alternativaDPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_D_PROPERTY_TYPE_NAME,
						FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		alternativaEPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_E_PROPERTY_TYPE_NAME,
						FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		idExercicioPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ID_EXERCICIO_PROPERTY_TYPE_NAME,
						FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);
	}

	public QuestaoMultiplaEscolha cadastrarQuestaoME(String idExercicio,
			String enunciado, List<String> alternativas,
			Integer alternativaCorreta) {

		Entity questaoMEEntity = new Entity();
		questaoMEEntity.setEntityType(questaoMultilplaEscolhaET);

		List<Property> properties = new ArrayList<Property>();
		questaoMEEntity.setProperties(properties);

		// Atribuindo valor para o ID
		Property idProperty = newProperty(idPT, idExercicio, questaoMEEntity);
		properties.add(idProperty);

		// Atribuindo valor para o ID do EXERCICIO
		Property idExercicioProperty = newProperty(idExercicioPT, idExercicio,
				questaoMEEntity);
		properties.add(idExercicioProperty);

		// Atribuindo valor para o ENUNCIADO
		Property enunciadoProperty = newProperty(enunciadoPT, enunciado,
				questaoMEEntity);
		properties.add(enunciadoProperty);

		// Atribuindo valor para a ALTERNATIVA CORRETA
		Property alternativaCorretaProperty = newProperty(alternativaCorretaPT,
				String.valueOf(alternativaCorreta), questaoMEEntity);
		properties.add(alternativaCorretaProperty);

		// Atribuindo valor para a alternativa A
		int indiceAlternativaANoArrayDeProperties = 0;
		int indiceAlternativaBNoArrayDeProperties = 1;
		int indiceAlternativaCNoArrayDeProperties = 2;
		int indiceAlternativaDNoArrayDeProperties = 3;
		int indiceAlternativaENoArrayDeProperties = 4;

		Property alternativaAProperty = newProperty(alternativaAPT,
				alternativas.get(indiceAlternativaANoArrayDeProperties),
				questaoMEEntity);
		properties.add(alternativaAProperty);

		// Atribuindo valor para a alternativa B
		Property alternativaBProperty = newProperty(alternativaBPT,
				alternativas.get(indiceAlternativaBNoArrayDeProperties),
				questaoMEEntity);
		properties.add(alternativaBProperty);

		// Atribuindo valor para a alternativa C
		Property alternativaCProperty = newProperty(alternativaCPT,
				alternativas.get(indiceAlternativaCNoArrayDeProperties),
				questaoMEEntity);
		properties.add(alternativaCProperty);

		// Atribuindo valor para a alternativa D
		Property alternativaDProperty = newProperty(alternativaDPT,
				alternativas.get(indiceAlternativaDNoArrayDeProperties),
				questaoMEEntity);
		properties.add(alternativaDProperty);

		// Atribuindo valor para a alternativa E
		Property alternativaEProperty = newProperty(alternativaEPT,
				alternativas.get(indiceAlternativaENoArrayDeProperties),
				questaoMEEntity);
		properties.add(alternativaEProperty);

		return this.converterEmUmaQuestaoME(lomFacade.create(questaoMEEntity));
	}

	public QuestaoMultiplaEscolha pesquisarQuestaoMEPorId(String idQuestao) {
		List<Entity> entities = lomFacade
				.findEntitiesByEntityTypeId(questaoMultilplaEscolhaET.getId());

		for (Entity e : entities) {
			String id = e.getProperties().get(INDICE_ID).getValue();

			if (idQuestao.equals(id)) {
				return converterEmUmaQuestaoME(e);
			}
		}
		return null;
	}

	private QuestaoMultiplaEscolha converterEmUmaQuestaoME(Entity entity) {
		List<Property> properties = entity.getProperties();

		String id = properties.get(INDICE_ID).getValue();

		// int idDoExercicio = Integer.parseInt(properties.get(1).getValue());

		String enunciado = properties.get(INDICE_ENUNCIADO).getValue();
		int alternativaCorreta = Integer.parseInt(properties.get(
				INDICE_ALTERNATIVA_CORRETA).getValue());

		List<String> alternativas = new ArrayList<String>();

		String alternativaA = properties.get(INDICE_ALTERNATIVA_A).getValue();
		alternativas.add(alternativaA);

		String alternativaB = properties.get(INDICE_ALTERNATIVA_B).getValue();
		alternativas.add(alternativaB);

		String alternativaC = properties.get(INDICE_ALTERNATIVA_C).getValue();
		alternativas.add(alternativaC);

		String alternativaD = properties.get(INDICE_ALTERNATIVA_D).getValue();
		alternativas.add(alternativaD);

		String alternativaE = properties.get(INDICE_ALTERNATIVA_E).getValue();
		alternativas.add(alternativaE);

		return new QuestaoMultiplaEscolha(id, enunciado, alternativas,
				alternativaCorreta);
	}
}