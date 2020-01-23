package controller.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("conversorSexo")
public class conversorSexo implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value.equals("M"))
			return new String("Masculino");
		
		return new String("Feminino");
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (((String) value).equals("M"))
			return new String("Masculino");
		
		return new String("Feminino");
	}

}
