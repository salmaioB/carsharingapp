package cs.model;

public class Translations
{
	private Integer idTranslation;
	private Integer idTranslationValue;
	private String valueSummary;
	
	
	public Integer getIdTranslation() {
		return idTranslation;
	}
	
	public void setId(Integer idTranslation) {
		this.idTranslation = idTranslation;
	}
	
	public Integer getIdTranslationValue() {
		return idTranslationValue;
	}
	
	public void setIdTranslationValue(Integer idTranslationValue) {
		this.idTranslationValue = idTranslationValue;
	}
	
	public String getValueSummary() {
		return valueSummary;
	}
	
	public void setValueSummary(String valueSummary) {
		this.valueSummary = valueSummary;
	}
}
