package br.ufpb.dcx.prolicen.educservice.adaptable.dao;

import java.util.LinkedList;
import java.util.List;

import br.ufpb.dcx.prolicen.educservice.model.Aluno;

import com.nanuvem.lom.api.Entity;
import com.nanuvem.lom.api.EntityType;
import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.Property;
import com.nanuvem.lom.api.PropertyType;

public class AdaptableAlunoDAO extends AbstractAdaptableDAO {

	private static final String FULLNAME_ALUNO = "br.ufpb.educservice.Aluno";

	private EntityType alunoET;

	private PropertyType idPT;
	private PropertyType nomePT;
	private PropertyType loginPT;
	private PropertyType senhaPT;

	public AdaptableAlunoDAO(Facade facade) {
		super(facade);
	}

	public Aluno criarAluno(String nome, String login, String senha) {
		Entity alunoEntity = new Entity();
		alunoEntity.setEntityType(this.alunoET);

		List<Property> properties = new LinkedList<Property>();

		Property idProperty = newProperty(idPT,
				criarIdAutoIncrementavel(alunoET, "id"), alunoEntity);
		properties.add(idProperty);

		Property nomeProperty = newProperty(nomePT, nome, alunoEntity);
		properties.add(nomeProperty);

		Property loginProperty = newProperty(loginPT, login, alunoEntity);
		properties.add(loginProperty);

		Property senhaProperty = newProperty(senhaPT, senha, alunoEntity);
		properties.add(senhaProperty);

		alunoEntity.setProperties(properties);

		return this.converterEmAluno(this.lomFacade.create(alunoEntity));
	}

	public Aluno pesquisarAluno(String id) {
		List<Entity> alunosEntity = this.lomFacade
				.findEntitiesByEntityTypeId(this.alunoET.getId());

		for (Entity entity : alunosEntity) {
			if (entity.getProperties().get(0).getValue().equals(id)) {
				return converterEmAluno(entity);
			}
		}
		return null;
	}

	public void removerAluno(String idAluno) {
		// TODO;
	}

	@Override
	protected void construirEntitiesTypesEPropertiesTypes() {
		this.alunoET = this.lomFacade.findEntityTypeByFullName(FULLNAME_ALUNO);

		List<PropertyType> propertiesTypes = alunoET.getPropertiesTypes();
		this.idPT = propertiesTypes.get(0);
		this.nomePT = propertiesTypes.get(1);
		this.loginPT = propertiesTypes.get(2);
		this.senhaPT = propertiesTypes.get(3);
	}

	private Aluno converterEmAluno(Entity alunoEntity) {
		List<Property> properties = alunoEntity.getProperties();

		Aluno aluno = new Aluno();
		aluno.setId(properties.get(0).getValue());
		aluno.setNome(properties.get(1).getValue());
		aluno.setLogin(properties.get(2).getValue());
		aluno.setSenha(properties.get(3).getValue());
		return aluno;
	}
}
