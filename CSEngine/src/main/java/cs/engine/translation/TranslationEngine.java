package cs.engine.translation;

import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.TranslationValueDAO;
import cs.model.TranslationValue;

public class TranslationEngine
{
	private TranslationValueDAO caBean;
	
	private List<TranslationValue> tr;
	
	public TranslationEngine()
	{
		XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		caBean = (TranslationValueDAO) beanFactory.getBean("TranslationValueDAO");
		tr = caBean.getListTranslationValue();
		for (TranslationValue s : tr) {
		    System.out.println(s.getTranslationValue() );
		}
	}
	
	public List<TranslationValue> getTr() {
		return tr;
	}

	public void setTr(List<TranslationValue> tr) {
		this.tr = tr;
	}

	public String tr_html(Integer id,String country)
	{
		if(caBean != null)
		{
			return caBean.load(id,country);
		}
		return null;
	}
}
