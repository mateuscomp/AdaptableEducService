package br.ufpb.dcx.prolicen.educservice.dao;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.dcx.prolicen.educservice.model.QuestaoMultiplaEscolha;

import com.nanuvem.lom.api.Entity;
import com.nanuvem.lom.api.EntityType;
import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.Property;
import com.nanuvem.lom.api.PropertyType;

public class AdaptableQuestaoMultiplaEscolhaDAO extends AbstractAdaptableDAO {

	private static final int INDICE_ENUNCIADO = 1;
	private static final int INDICE_ALTERNATIVA_CORRETA = 2;
	// private static final int INDICE_ALTERNATIVA_A = 2;
	// private static final int INDICE_ALTERNATIVA_B = 3;
	// private static final int INDICE_ALTERNATIVA_C = 4;
	// private static final int INDICE_ALTERNATIVA_D = 5;
	// private static final int INDICE_ALTERNATIVA_E = 6;

	public static final String NAMESPACE_QUESTAO_MULTIPLA_ESCOLHA = "br.ufpb.educservice";
	public static final String NAME_QUESTAO_MULTIPLA_ESCOLHA = "QuestaoMultiplaEscolha";

	public static final String ENUNCIADO_PROPERTY_TYPE_NAME = "enunciado";
	public static final String ALTERNATIVA_CORRETA_PROPERTY_TYPE_NAME = "alternativaCorreta";
	public static final String ALTERNATIVA_A_PROPERTY_TYPE_NAME = "alternativaA";
	public static final String ALTERNATIVA_B_PROPERTY_TYPE_NAME = "alternativaB";
	public static final String ALTERNATIVA_C_PROPERTY_TYPE_NAME = "alternativaC";
	public static final String ALTERNATIVA_D_PROPERTY_TYPE_NAME = "alternativaD";
	public static final String ALTERNATIVA_E_PROPERTY_TYPE_NAME = "alternativaE";
	public static final String ID_EXERCICIO_PROPERTY_TYPE_NAME = "idExercicio";

	private EntityType questaoMultilplaEscolhaET;

	private PropertyType enunciadoPT;
	private PropertyType alternativaCorretaPT;
	private PropertyType alternativaAPT;
	private PropertyType alternativaBPT;
	private PropertyType alternativaCPT;
	private PropertyType alternativaDPT;
	private PropertyType alternativaEPT;
	private PropertyType idExercicioPT;

	public AdaptableQuestaoMultiplaEscolhaDAO(Facade lomFacade) {
		super(lomFacade);
	}

	@Override
	protected void construirEntitiesTypesEPropertiesTypes() {
		questaoMultilplaEscolhaET = this.lomFacade
				.findEntityTypeByFullName(getFullnameQuestaoMutiplaEscolha());

		enunciadoPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ENUNCIADO_PROPERTY_TYPE_NAME,
						getFullnameQuestaoMutiplaEscolha());

		alternativaCorretaPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_CORRETA_PROPERTY_TYPE_NAME,
						getFullnameQuestaoMutiplaEscolha());

		alternativaAPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_A_PROPERTY_TYPE_NAME,
						getFullnameQuestaoMutiplaEscolha());

		alternativaBPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_B_PROPERTY_TYPE_NAME,
						getFullnameQuestaoMutiplaEscolha());

		alternativaCPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_C_PROPERTY_TYPE_NAME,
						getFullnameQuestaoMutiplaEscolha());

		alternativaDPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_D_PROPERTY_TYPE_NAME,
						getFullnameQuestaoMutiplaEscolha());

		alternativaEPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_E_PROPERTY_TYPE_NAME,
						getFullnameQuestaoMutiplaEscolha());

		idExercicioPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ID_EXERCICIO_PROPERTY_TYPE_NAME,
						getFullnameQuestaoMutiplaEscolha());
	}

	private String getFullnameQuestaoMutiplaEscolha() {
		return NAMESPACE_QUESTAO_MULTIPLA_ESCOLHA + "."
				+ NAME_QUESTAO_MULTIPLA_ESCOLHA;
	}

	public QuestaoMultiplaEscolha cadastrarQuestaoME(String idExercicio,
			String enunciado, List<String> alternativas,
			Integer alternativaCorreta) {

		Entity questaoMEEntity = new Entity();
		questaoMEEntity.setEntityType(questaoMultilplaEscolhaET);

		List<Property> properties = new ArrayList<Property>();
		questaoMEEntity.setProperties(properties);

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

		questaoMEEntity.setProperties(properties);
		Entity createdEntity = lomFacade.create(questaoMEEntity);
		return this.converterEmUmaQuestaoME(createdEntity);
	}

	public QuestaoMultiplaEscolha pesquisarQuestaoMEPorId(String idQuestao) {
		return converterEmUmaQuestaoME(this.lomFacade.findEntityById(Long
				.parseLong(idQuestao)));
	}

	private QuestaoMultiplaEscolha converterEmUmaQuestaoME(Entity entity) {
		List<Property> properties = entity.getProperties();

		String enunciado = properties.get(INDICE_ENUNCIADO).getValue();
		int alternativaCorreta = Integer.parseInt(properties.get(
				INDICE_ALTERNATIVA_CORRETA).getValue());

		List<String> alternativas = new ArrayList<String>();

		for (Property p : properties) {
			String name = p.getPropertyType().getName();

			boolean ehUmaAlternativa = ALTERNATIVA_A_PROPERTY_TYPE_NAME
					.equals(name)
					|| ALTERNATIVA_B_PROPERTY_TYPE_NAME.equals(name)
					|| ALTERNATIVA_C_PROPERTY_TYPE_NAME.equals(name)
					|| ALTERNATIVA_D_PROPERTY_TYPE_NAME.equals(name)
					|| ALTERNATIVA_D_PROPERTY_TYPE_NAME.equals(name)
					|| ALTERNATIVA_E_PROPERTY_TYPE_NAME.equals(name);

			if (ehUmaAlternativa) {
				alternativas.add(p.getValue());
			}
		}

		return new QuestaoMultiplaEscolha(String.valueOf(entity.getId()),
				enunciado, alternativas, alternativaCorreta);
	}
}