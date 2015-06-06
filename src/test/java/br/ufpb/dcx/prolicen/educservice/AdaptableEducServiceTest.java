package br.ufpb.dcx.prolicen.educservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

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

	public void gerarTrace(Map<String, String> propertyValueMap) {
		String json = "{";

		boolean ehAPrimeiraProperiedade = true;
		for (String property : propertyValueMap.keySet()) {
			if (!ehAPrimeiraProperiedade) {
				json += ",";
			}

			json += "\"" + property + "\" : \""
					+ propertyValueMap.get(property) + "\"";
			ehAPrimeiraProperiedade = false;
		}
		json += "}";

		this.outputTrace(json);
	}

	private void outputTrace(String texto) {
		String userHome = System.getProperty("user.home");
		String separator = System.getProperty("file.separator");

		String nameOfFile = "performaceEvaluationEduServiceTest.log";

		File file = new File(userHome + separator + nameOfFile);

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(file, true), "UTF-8"));
			bw.append(texto + "\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
