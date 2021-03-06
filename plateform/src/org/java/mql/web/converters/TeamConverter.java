package org.java.mql.web.converters;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import org.java.mql.business.Module2Business;
import org.java.mql.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("teamConverter")
public class TeamConverter implements Converter<Team> {

	@Autowired
	private Module2Business service;
	
	
	
	
	public Team getAsObject(FacesContext fc, UIComponent uic, String value) {
		if(value != null && value.trim().length() > 0) {
			try {
				int id = Integer.parseInt(value);
				return service.selectTeamById(id);
			} catch(NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid item."));
			}
		}
		else {
			return null;
		}
	}

	public String getAsString(FacesContext fc, UIComponent uic, Team object) {
		if(object != null) {
			return String.valueOf(object.getId());
		}
		else {
			return null;
		}
	}
	
	
}