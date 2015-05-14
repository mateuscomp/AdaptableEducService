package br.ufpb.dcx.prolicen.educservice.adaptable.impl;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.dcx.prolicen.educservice.educservice.QuestaoMultiplaEscolha;

import com.nanuvem.lom.api.Entity;
import com.nanuvem.lom.api.EntityType;
import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.Property;
import com.nanuvem.lom.api.PropertyType;

public class QuestaoMultiplaEscolhaService {

	private static final String ENUNCIADO_PROPERTY_TYPE_NAME = "enunciado";
	private static final String ALTERNATIVA_CORRETA_PROPERTY_TYPE_NAME = "alternativaCorreta";
	private static final String ALTERNATIVA_A_PROPERTY_TYPE_NAME = "alternativaA";
	private static final String ALTERNATIVA_B_PROPERTY_TYPE_NAME = "alternativaB";

	private static final String FULLNAME_QUESTAO_MULTIPLA_ESCOLHA = "br.ufpb.educservice.QuestaoMultiplaEscolha";

	private Facade lomFacade;

	private EntityType questaoMultilplaEscolhaET;

	private PropertyType enunciadoPT;
	private PropertyType alternativaAPT;
	private PropertyType alternativaBPT;
	// TODO - Fazer até a alternativa D;
	private PropertyType alternativaCorretaPT;

	public QuestaoMultiplaEscolhaService(Facade lomFacade) {
		this.lomFacade = lomFacade;
		this.init();
	}

	private void init() {
		questaoMultilplaEscolhaET = this.lomFacade
				.findEntityTypeByFullName(FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		// Com o LOM, ainda não consigo carregar o exercício, faltando
		// implementar os relacionamentos

		enunciadoPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ENUNCIADO_PROPERTY_TYPE_NAME,
						FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		alternativaAPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_A_PROPERTY_TYPE_NAME,
						FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		alternativaBPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_B_PROPERTY_TYPE_NAME,
						FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);

		alternativaCorretaPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						ALTERNATIVA_CORRETA_PROPERTY_TYPE_NAME,
						FULLNAME_QUESTAO_MULTIPLA_ESCOLHA);
		
		// TODO - Armazenar a chave estrangeira do exercício
	}

	public QuestaoMultiplaEscolha cadastrarQuestaoME(String idExercicio,
			String enunciado, List<String> alternativas, int alternativaCorreta) {

		Entity questaoMEEntity = new Entity();
		questaoMEEntity.setEntityType(questaoMultilplaEscolhaET);

		// Atribuindo valor para o ENUNCIADO
		Property enunciadoProperty = new Property();
		enunciadoProperty.setPropertyType(enunciadoPT);
		enunciadoProperty.setValue(enunciado);
		enunciadoProperty.setEntity(questaoMEEntity);

		// Atribuindo valor para a ALTERNATIVA CORRETA
		Property alternativaCorretaProperty = new Property();
		enunciadoProperty.setPropertyType(alternativaCorretaPT);
		enunciadoProperty.setValue(alternativaCorreta + "");
		enunciadoProperty.setEntity(questaoMEEntity);

		// Atribuindo valor para a alternativa A
		Property alternativaAProperty = new Property();
		alternativaAProperty.setPropertyType(alternativaAPT);
		alternativaAProperty.setValue(alternativas.get(0));
		alternativaAProperty.setEntity(questaoMEEntity);

		// Atribuindo valor para a alternativa B
		Property alternativaBProperty = new Property();
		alternativaBProperty.setPropertyType(alternativaBPT);
		alternativaBProperty.setValue(alternativas.get(1));
		alternativaBProperty.setEntity(questaoMEEntity);

		List<Property> properties = new ArrayList<Property>();
		properties.add(enunciadoProperty);
		properties.add(alternativaCorretaProperty);
		properties.add(alternativaAProperty);
		properties.add(alternativaBProperty);
		questaoMEEntity.setProperties(properties);

		return this.converterEmUmaQuestaoME(lomFacade.create(questaoMEEntity));

	}

	private QuestaoMultiplaEscolha converterEmUmaQuestaoME(Entity entity) {

		String enunciado = entity.getProperties().get(0).getValue();
		int alternativaCorreta = Integer.parseInt(entity.getProperties().get(1)
				.getValue());

		List<String> alternativas = new ArrayList<String>();
		String alternativaA = entity.getProperties().get(2).getValue();
		String alternativaB = entity.getProperties().get(3).getValue();
		alternativas.add(alternativaA);
		alternativas.add(alternativaB);

		return new QuestaoMultiplaEscolha("0", enunciado, alternativas,
				alternativaCorreta);
	}
}