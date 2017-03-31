package gov.cygs.entities;

public class TemplateMap {
	private String template;
	private String tfield;
	private String field;
	
	public TemplateMap() {

	}

	public TemplateMap(String t, String tf, String f) {
		this.template = t;
		this.tfield = tf;
		this.field = f;
	}
	
	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getTfield() {
		return tfield;
	}

	public void setTfield(String tfield) {
		this.tfield = tfield;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

}
