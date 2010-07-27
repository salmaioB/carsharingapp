package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.TranslationDAO;
import cs.model.Translation;

public class TranslationEngineAction
{
	private TranslationDAO caBean;
	
	public TranslationEngineAction()
	{
		XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		caBean = (TranslationDAO) beanFactory.getBean("TranslationDAO");
	}
	public Translation load(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id);
		}
		return null;
	}
}
