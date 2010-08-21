package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.OpinionDAO;
import cs.dao.dao.RouteDAO;
import cs.dao.spring.SpringDAO;
import cs.model.Opinion;

public class OpinionEngineAction
{
	private OpinionDAO caBean;
	
	public OpinionDAO getCaBean() {
		return caBean;
	}
	public void setCaBean(OpinionDAO caBean) {
		this.caBean = caBean;
	}
	
	public OpinionEngineAction()
	{
		//caBean = SpringDAO.getSpring().getOpinionDAO();
		//XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		//caBean = (OpinionDAO) beanFactory.getBean("OpinionDAO");
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
