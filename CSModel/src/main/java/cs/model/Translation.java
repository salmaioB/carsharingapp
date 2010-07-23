package cs.model;

public class Translation
{
	private Integer id;
	private Integer idTranslationValue;
	private String valueSummary;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
