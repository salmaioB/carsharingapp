package cs.model;

public class TranslationValue
{
	private Integer id;
	private Integer idTranslation;
	private String translationValue;
	private String languageCode;
	private String countryCode;

	public Integer getIdTranslation() {
		return idTranslation;
	}
	public void setIdTranslation(Integer idTranslation) {
		this.idTranslation = idTranslation;
	}
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
