package br.ufpb.dcx.prolicen.educservice.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Conversion;

import br.ufpb.dcx.prolicen.educservice.model.Questao;

import com.nanuvem.lom.api.Entity;
import com.nanuvem.lom.api.EntityType;
import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.Property;
import com.nanuvem.lom.api.PropertyType;

public class AdaptableRespostaDAO extends AbstractAdaptableDAO {

	private static final String FULLNAME_RESPOSTA_ENTITY = "br.ufpb.educservice.Resposta";

	private EntityType respostaET;

	private PropertyType idAlunoPT;
	private PropertyType idExercicioPT;
	private PropertyType idQuestaoPT;
	private PropertyType alternativaCorretaPT;

	public AdaptableRespostaDAO(Facade facade) {
		super(facade);
	}

	@Override
	protected void construirEntitiesTypesEPropertiesTypes() {
		this.respostaET = this.lomFacade
				.findEntityTypeByFullName(FULLNAME_RESPOSTA_ENTITY);

		this.idAlunoPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType("idAluno",
						FULLNAME_RESPOSTA_ENTITY);
		this.idExercicioPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType("idExercicio",
						FULLNAME_RESPOSTA_ENTITY);

		this.idQuestaoPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType("idQUestao",
						FULLNAME_RESPOSTA_ENTITY);

		this.alternativaCorretaPT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(
						"alternativaCorreta", FULLNAME_RESPOSTA_ENTITY);
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

		Map<String, String> nomeDosPropertiesTypesEValoresDeUmaResposta = new HashMap<String, String>();
		nomeDosPropertiesTypesEValoresDeUmaResposta.put(idAlunoPT.getName(),
				idAluno);
		nomeDosPropertiesTypesEValoresDeUmaResposta.put(
				idExercicioPT.getName(), idExercicio);
		nomeDosPropertiesTypesEValoresDeUmaResposta.put(idQuestaoPT.getName(),
				idQuestao);

		List<Entity> respostasEntity = this.lomFacade
				.findEntityByEntityTypeFullnameAndPropertiesTypesNameAndValue(
						FULLNAME_RESPOSTA_ENTITY,
						nomeDosPropertiesTypesEValoresDeUmaResposta);

		if (respostasEntity != null && respostasEntity.size() > 0) {
			return converterEmResposta(respostasEntity.get(0));
		}

		return null;
	}

	private Questao converterEmResposta(Entity entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
