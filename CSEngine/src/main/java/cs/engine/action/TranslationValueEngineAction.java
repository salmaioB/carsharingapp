package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.TranslationValueDAO;
import cs.model.TranslationValue;

public class TranslationValueEngineAction
{
	private TranslationValueDAO caBean;
	
	public TranslationValueEngineAction()
	{
		XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		caBean = (TranslationValueDAO) beanFactory.getBean("TranslationValueDAO");
	}
	public String tr_html(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id,"fr");
		}
		return null;
	}
}
