package br.ufpb.dcx.prolicen.educservice;

import org.junit.After;
import org.junit.Before;

import br.ufpb.dcx.prolicen.educservice.model.AdaptableEducServiceFacade;

import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.dao.DaoFactory;
import com.nanuvem.lom.business.BusinessFacade;
import com.nanuvem.lom.kernel.dao.MySqlDaoFactory;

public class AdaptableEducServiceTest {

	protected AdaptableEducServiceFacade facade;
	private DaoFactory daoFactory;

	@Before
	public void init() {
		daoFactory = new MySqlDaoFactory();
		daoFactory.createDatabaseSchema();

		Facade lomFacade = new BusinessFacade(daoFactory);
		AdaptableEducServiceFacade.createEducServiceSchema(lomFacade);

		this.facade = new AdaptableEducServiceFacade(lomFacade);
	}

	@After
	public void finish() {
		daoFactory.dropDatabaseSchema();
	}
}
