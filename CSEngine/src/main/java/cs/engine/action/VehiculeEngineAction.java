package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import cs.dao.dao.VehiculeDAO;
import cs.dao.spring.Spring;
import cs.model.Vehicule;

public class VehiculeEngineAction
{
	private VehiculeDAO caBean;
	
	public VehiculeEngineAction()
	{
		caBean = null;//Spring.getSpring().getVehiculeDAO();
		//XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		//caBean = (VehiculeDAO) beanFactory.getBean("VehiculeDAO");
	}
	public Vehicule load(Integer id)
	{
		if(caBean != null)
		{
			return caBean.load(id);
		}
		return null;
	}
}
