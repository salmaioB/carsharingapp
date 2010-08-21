package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.TranslationValueDAO;
import cs.dao.spring.SpringDAO;
import cs.model.TranslationValue;

public class TranslationValueEngineAction
{
	private TranslationValueDAO caBean;
	
	public TranslationValueDAO getCaBean() {
		return caBean;
	}

	public void setCaBean(TranslationValueDAO caBean) {
		this.caBean = caBean;
	}

	public TranslationValueEngineAction()
	{
		//caBean = SpringDAO.getSpring().getTranslationValueDAO();
		//XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		//caBean = (TranslationValueDAO) beanFactory.getBean("TranslationValueDAO");
	}
}
