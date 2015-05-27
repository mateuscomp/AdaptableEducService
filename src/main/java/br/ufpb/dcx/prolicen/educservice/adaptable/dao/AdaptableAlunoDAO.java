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
		Long idLong = Long.parseLong(id);
		return converterEmAluno(this.lomFacade.findEntityById(idLong));
	}

	@Override
	protected void construirEntitiesTypesEPropertiesTypes() {
		this.alunoET = this.lomFacade.findEntityTypeByFullName(FULLNAME_ALUNO);

		List<PropertyType> propertiesTypes = alunoET.getPropertiesTypes();
		this.nomePT = propertiesTypes.get(0);
		this.loginPT = propertiesTypes.get(1);
		this.senhaPT = propertiesTypes.get(2);
	}

	private Aluno converterEmAluno(Entity alunoEntity) {
		List<Property> properties = alunoEntity.getProperties();

		Aluno aluno = new Aluno();
		aluno.setId(String.valueOf(alunoEntity.getId()));
		aluno.setNome(properties.get(0).getValue());
		aluno.setLogin(properties.get(1).getValue());
		aluno.setSenha(properties.get(2).getValue());

		return aluno;
	}
}
