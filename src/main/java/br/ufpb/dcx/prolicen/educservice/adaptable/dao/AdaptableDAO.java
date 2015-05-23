package br.ufpb.dcx.prolicen.educservice.adaptable.dao;

import java.util.List;

import com.nanuvem.lom.api.Entity;
import com.nanuvem.lom.api.EntityType;
import com.nanuvem.lom.api.Facade;
import com.nanuvem.lom.api.Property;
import com.nanuvem.lom.api.PropertyType;

public abstract class AdaptableDAO {

	protected Facade lomFacade;

	protected AdaptableDAO(Facade facade) {
		this.lomFacade = facade;
		this.construirEntitiesTypesEPropertiesTypes();
	}

	protected abstract void construirEntitiesTypesEPropertiesTypes();

	public Property newProperty(PropertyType propertyType, String value,
			Entity entity) {

		Property property = new Property();
		property.setPropertyType(propertyType);
		property.setValue(value);
		property.setEntity(entity);
		return property;
	}

	protected String criarIdAutoIncrementavel(EntityType entityType,
			String nomeDoPropertyTypeDoId) {
		List<Entity> entities = lomFacade.findEntitiesByEntityTypeId(entityType
				.getId());

		Long maxIdLong = 0L;
		for (Entity e : entities) {
			for (Property p : e.getProperties()) {
				if (p.getPropertyType().getName()
						.equals(nomeDoPropertyTypeDoId)) {
					Long idDaProperty = Long.parseLong(p.getValue());

					if (idDaProperty > maxIdLong) {
						maxIdLong = idDaProperty;
					}
				}
			}
		}
		maxIdLong = maxIdLong + 1;
		return maxIdLong.toString();
	}
}
