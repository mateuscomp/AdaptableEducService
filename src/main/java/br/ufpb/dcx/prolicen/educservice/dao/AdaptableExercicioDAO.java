package br.ufpb.dcx.prolicen.educservice.dao;

import java.util.ArrayList;
import java.util.List;

import br.ufpb.dcx.prolicen.educservice.model.Exercicio;

import com.nanuvem.lom.api.Entity;
import com.nanuvem.lom.api.EntityType;
import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.Property;
import com.nanuvem.lom.api.PropertyType;

public class AdaptableExercicioDAO extends AbstractAdaptableDAO {

	public static final String NAMESPACE_EXERCICIO_ENTITY_TYPE = "br.ufpb.educservice";
	public static final String NAME_EXERCICIO_ENTITY_TYPE = "Exercicio";

	public static final String PALAVRA_CHAVE_01 = "palavraChaveUm";
	public static final String PALAVRA_CHAVE_02 = "palavraChaveDois";
	public static final String PALAVRA_CHAVE_03 = "palavraChaveTres";
	public static final String PALAVRA_CHAVE_04 = "palavraChaveQuatro";
	public static final String PALAVRA_CHAVE_05 = "palavraChaveCinco";

	private EntityType exercicioET;

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

		String idExercicio = String.valueOf(exercicioEntity.getId());
		idExercicio = String.valueOf(exercicioEntity.getId());

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
				.findEntityTypeByFullName(getFullNameExercicioEntityType());

		palavraChave01PT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(PALAVRA_CHAVE_01,
						getFullNameExercicioEntityType());

		palavraChave02PT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(PALAVRA_CHAVE_02,
						getFullNameExercicioEntityType());

		palavraChave03PT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(PALAVRA_CHAVE_03,
						getFullNameExercicioEntityType());

		palavraChave04PT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(PALAVRA_CHAVE_04,
						getFullNameExercicioEntityType());

		palavraChave05PT = this.lomFacade
				.findPropertyTypeByNameAndFullnameEntityType(PALAVRA_CHAVE_05,
						getFullNameExercicioEntityType());
	}

	private String getFullNameExercicioEntityType() {
		return NAMESPACE_EXERCICIO_ENTITY_TYPE + "."
				+ NAME_EXERCICIO_ENTITY_TYPE;
	}

	public Exercicio pesquisarExercicioPorId(String idExercicio) {
		return converterEmExercicio(this.lomFacade.findEntityById(Long
				.parseLong(idExercicio)));
	}
}
