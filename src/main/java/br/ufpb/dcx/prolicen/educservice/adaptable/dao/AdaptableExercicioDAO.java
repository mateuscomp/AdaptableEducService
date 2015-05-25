package br.ufpb.dcx.prolicen.educservice.adaptable.dao;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.dcx.prolicen.educservice.model.Exercicio;

import com.nanuvem.lom.api.Entity;
import com.nanuvem.lom.api.EntityType;
import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.Property;
import com.nanuvem.lom.api.PropertyType;

public class AdaptableExercicioDAO extends AbstractAdaptableDAO {

	private static final String FULLNAME_EXERCICIO = "br.ufpb.educservice.Exercicio";

	private static final String ID_PROPERTY_TYPE_NAME = "id";
	private static final String PALAVRA_CHAVE_01 = "palavraChave01";
	private static final String PALAVRA_CHAVE_02 = "palavraChave02";
	private static final String PALAVRA_CHAVE_03 = "palavraChave03";
	private static final String PALAVRA_CHAVE_04 = "palavraChave04";
	private static final String PALAVRA_CHAVE_05 = "palavraChave05";

	private EntityType exercicioET;

	private PropertyType idPT;
	private PropertyType palavraChave01PT;
	private PropertyType palavraChave02PT;
	private PropertyType palavraChave03PT;
	private PropertyType palavraChave04PT;
	private PropertyType palavraChave05PT;

	public AdaptableExercicioDAO(Facade lomFacade) {
		super(lomFacade);
	}

	public Exercicio criarExercicio() {
		return this.criarExercicio(null);
	}

	public Exercicio criarExercicio(List<String> palavrasChave) {

		Entity exercicioEntity = new Entity();
		exercicioEntity.setEntityType(this.exercicioET);

		List<Property> properties = new ArrayList<Property>();
		Property idProperty = newProperty(idPT,
				criarIdAutoIncrementavel(exercicioET, ID_PROPERTY_TYPE_NAME),
				exercicioEntity);
		properties.add(idProperty);

		if (palavrasChave != null && palavrasChave.get(0) != null) {
			Property palavraChave01Property = newProperty(palavraChave01PT,
					palavrasChave.get(0), exercicioEntity);
			properties.add(palavraChave01Property);
		}

		if (palavrasChave != null && palavrasChave.get(1) != null) {
			Property palavraChave02Property = newProperty(palavraChave02PT,
					palavrasChave.get(1), exercicioEntity);
			properties.add(palavraChave02Property);
		}

		if (palavrasChave != null && palavrasChave.get(2) != null) {
			Property palavraChave03Property = newProperty(palavraChave03PT,
					palavrasChave.get(2), exercicioEntity);
			properties.add(palavraChave03Property);
		}

		if (palavrasChave != null && palavrasChave.get(3) != null) {
			Property palavraChave04Property = newProperty(palavraChave04PT,
					palavrasChave.get(3), exercicioEntity);
			properties.add(palavraChave04Property);
		}

		if (palavrasChave != null && palavrasChave.get(4) != null) {
			Property palavraChave05Property = newProperty(palavraChave05PT,
					palavrasChave.get(4), exercicioEntity);
			properties.add(palavraChave05Property);
		}
		exercicioEntity.setProperties(properties);
		exercicioEntity = this.lomFacade.create(exercicioEntity);
		return converterEmExercicio(exercicioEntity);
	}

	private Exercicio converterEmExercicio(Entity exercicioEntity) {
		List<Property> properties = exercicioEntity.getProperties();

		String idExercicio = properties.remove(0).getValue();
		List<String> palavrasChave = new ArrayList<String>();

		for (Property palavraChaveProperty : properties) {
			palavrasChave.add(palavraChaveProperty.getValue());
		}

		Exercicio exercicio = new Exercicio(idExercicio);
		exercicio.setPalavrasChave(palavrasChave);

		return exercicio;
	}

	@Override
	protected void construirEntitiesTypesEPropertiesTypes() {
		exercicioET = this.lomFacade
				.findEntityTypeByFullName(FULLNAME_EXERCICIO);

		idPT = this.lomFacade.findPropertyTypeByNameAndFullnameEntityType(
				ID_PROPERTY_TYPE_NAME, FULLNAME_EXERCICIO);

		palavraChave01PT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(PALAVRA_CHAVE_01,
						FULLNAME_EXERCICIO);

		palavraChave02PT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(PALAVRA_CHAVE_02,
						FULLNAME_EXERCICIO);

		palavraChave03PT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(PALAVRA_CHAVE_03,
						FULLNAME_EXERCICIO);

		palavraChave04PT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(PALAVRA_CHAVE_04,
						FULLNAME_EXERCICIO);

		palavraChave05PT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(PALAVRA_CHAVE_05,
						FULLNAME_EXERCICIO);
	}

	public Exercicio pesquisarExercicioPorId(String idExercicio) {
		List<Entity> exerciciosEntity = this.lomFacade
				.findEntitiesByEntityTypeId(this.exercicioET.getId());

		for (Entity entity : exerciciosEntity) {
			if (idExercicio.equals(entity.getProperties().get(0).getValue())) {
				return converterEmExercicio(entity);
			}
		}
		return null;
	}
}
