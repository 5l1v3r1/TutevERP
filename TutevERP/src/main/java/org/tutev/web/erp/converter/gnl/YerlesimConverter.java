package org.tutev.web.erp.converter.gnl;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tutev.web.erp.entity.genel.KodluListe;
import org.tutev.web.erp.entity.genel.Yerlesim;
import org.tutev.web.erp.service.YerlesimService;

@Controller("yerlesimConverter")
@Scope("request")
public class YerlesimConverter implements Converter {
	@Autowired
	private transient YerlesimService yerlesimService;
	
	public static Logger logger = Logger.getLogger(YerlesimConverter.class);

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (arg2 != null && arg2.trim().length() > 0 && !arg2.equals("null")) {
			try {
				Yerlesim ent = yerlesimService.getById(new Long(arg2));
				logger.debug("yerlesimConverter Convert Yaptý " + arg2);
				return ent;
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
	 if(arg2 != null && !arg2.equals("null") && arg2 instanceof KodluListe ) {
            return String.valueOf(((Yerlesim) arg2).getId());
        }
        else {
            return null;
        }
	}

}
