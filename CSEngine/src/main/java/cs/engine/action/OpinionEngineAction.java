package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.OpinionDAO;
import cs.model.Opinion;

public class OpinionEngineAction
{
	private OpinionDAO caBean;
	
	public OpinionEngineAction()
	{
		XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		caBean = (OpinionDAO) beanFactory.getBean("OpinionDAO");
	}
	public Opinion load(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id);
		}
		return null;
	}
}
