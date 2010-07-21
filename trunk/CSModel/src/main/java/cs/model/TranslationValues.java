package cs.model;

public class TranslationValues
{
	private Integer idTranslationValue;
	private String translationValue;
	private String languageCode;
	private String countryCode;
	
	public Integer getIdTranslationValue() {
		return idTranslationValue;
	}
	
	public void setIdTranslationsValue(Integer idTranslationValue) {
		this.idTranslationValue = idTranslationValue;
	}
	
	public String getTranslationValue() {
		return translationValue;
	}
	
	public void setTranslationValue(String translationValue) {
		this.translationValue = translationValue;
	}
	
	public String getLanguageCode() {
		return languageCode;
	}
	
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}