package org.tutev.web.erp.converter.gnl;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.genel.KodluListe;
import org.tutev.web.erp.service.KodluListeService;

@Controller("kodluListeConverter")
@Scope("request")
public class KodluListeConverter implements Converter {
	@Autowired
	private transient KodluListeService kodluListeService;
	
	public static Logger logger = Logger.getLogger(KodluListeConverter.class);

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 != null && arg2.trim().length() > 0) {
			try {
				KodluListe kodluListe = kodluListeService.getById(new Long(arg2));
				logger.debug("KodluListeConverter Convert Yaptý " + arg2);
				return kodluListe;
			} catch (Exception e) {
				logger.error(e);
			}
			return null;
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
	 if(arg2 != null) {
            return String.valueOf(((KodluListe) arg2).getId());
        }
        else {
            return null;
        }
	}

}
