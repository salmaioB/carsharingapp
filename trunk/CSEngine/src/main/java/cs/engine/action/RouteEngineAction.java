package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.RouteDAO;
import cs.dao.spring.SpringDAO;
import cs.model.Route;

public class RouteEngineAction
{
	private RouteDAO caBean;
	
	public RouteDAO getCaBean() {
		return caBean;
	}
	public void setCaBean(RouteDAO caBean) {
		this.caBean = caBean;
	}
	public RouteEngineAction()
	{
		//caBean = SpringDAO.getSpring().getRouteDAO();
		//XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		//caBean = (RouteDAO) beanFactory.getBean("RouteDAO");
	}
	public Route load(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id);
		}
		return null;
	}
}
