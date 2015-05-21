package br.ufpb.dcx.prolicen.educservice.adaptable.impl;

import java.util.List;

import br.ufpb.dcx.prolicen.educservice.educservice.Exercicio;

import com.nanuvem.lom.api.EntityType;
import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.PropertyType;

public class AdaptableExercicioDAO {
	
	private static final String FULLNAME_QUESTAO_MULTIPLA_ESCOLHA = "br.ufpb.educservice.Exercicio";
	
	private static final String ID_PROPERTY_TYPE_NAME = "id";
	private static final String PALAVRA_CHAVE_01 = "PALAVRA_CHAVE_01";

	private Facade lomFacade;

	private EntityType exercicioET;
	private PropertyType idPT;


	public AdaptableExercicioDAO(Facade lomFacade) {
		this.lomFacade = lomFacade;
	}

	public Exercicio criarExercicio() {
		return this.criarExercicio(null);
	}

	public Exercicio criarExercicio(List<String> palavrasChave) {
		return null;
	}

}
