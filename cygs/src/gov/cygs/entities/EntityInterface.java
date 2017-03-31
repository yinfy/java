package gov.cygs.entities;

public interface EntityInterface {
	public Object getId();	
	public String getFieldAsString(String fieldName, String classes);
	public String getAsXml(boolean hasHead, String classes);
}
