package br.ufpb.dcx.prolicen.educservice.adaptable.impl;

import com.nanuvem.lom.api.Entity;
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
}
