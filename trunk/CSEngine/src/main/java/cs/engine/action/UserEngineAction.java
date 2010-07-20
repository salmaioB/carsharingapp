package cs.engine.action;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import cs.dao.dao.UserDAO;
import cs.model.User;

public class UserEngineAction
{
	private UserDAO userBean;
	
	public UserEngineAction()
	{
		XmlBeanFactory beanFactory =  new XmlBeanFactory(new ClassPathResource("bean.xml"));
		userBean = (UserDAO) beanFactory.getBean("UserDAO");
	}
	public User load(Integer id)
	{
		if(userBean != null)
		{
			return userBean.load(id);
		}
		return null;
	}
}
