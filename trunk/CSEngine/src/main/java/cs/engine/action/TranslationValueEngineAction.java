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
	public TranslationValue load(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id);
		}
		return null;
	}
}
