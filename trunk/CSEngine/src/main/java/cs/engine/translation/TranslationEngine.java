package cs.engine.translation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.TranslationValueDAO;
import cs.dao.spring.Spring;
import cs.model.TranslationValue;

public class TranslationEngine
{
	private TranslationValueDAO caBean;
	private String country;
	private Map<Integer, Map<String, String>> tr;
	
	/**
	 * Setteur and getteur
	 */
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Map<Integer, Map<String, String>>getTr() {
		return tr;
	}

	public void setTr(Map<Integer, Map<String, String>> tr) {
		this.tr = tr;
	}
	/**
	 * Constructeur par défaut
	 */
	public TranslationEngine()
	{
		//XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		//caBean = (TranslationValueDAO) beanFactory.getBean("TranslationValueDAO");
		caBean = Spring.getSpring().getTranslationValueDAO();
		tr = caBean.getTranslation();
		//valeur par défaut
		country = "fr";
	}
	/**
	 * Fonction de translation
	 * @param id
	 * @return
	 */
	public String tr_html(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id,country);
		}
		return null;
	}
	public String tr_html(Integer id,String _country)
	{
		if(caBean != null)
		{
			return caBean.load(id,_country);
		}
		return null;
	}

}
