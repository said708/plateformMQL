package org.java.mql.web.converters;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Enseignant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("enseignantConverter")
public class EnseignantConverter implements Converter<Enseignant> {

	@Autowired
	private Module2Business service;
	
	
	
	
	public Enseignant getAsObject(FacesContext fc, UIComponent uic, String value) {
		System.out.println("getAsObject");
		if(value != null && value.trim().length() > 0) {
			try {
				int id = Integer.parseInt(value);
				return service.selectEnseignantById(id);
			} catch(NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
			}
		}
		else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Enseignant object) {
		System.out.println("getAsString");
		if(object != null) {
			return String.valueOf(object.getId());
		}
		else {
			return null;
		}
	}
	
	
}