package cs.model;

public class translationValues
{
	private Integer id;
	private String translationValue;
	private String languageCode;
	private String countryCode;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
