package cs.engine.test;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.io.Resource;

public class Spring3HelloWorldConfigTest {

	public static void main(String[] args) {
        //Initialize IoC Container
		ConfigurableApplicationContext context = new ConfigurableApplicationContext() {
			
			@Override
			public void stop() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void start() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isRunning() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Resource getResource(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ClassLoader getClassLoader() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Resource[] getResources(String arg0) throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void publishEvent(ApplicationEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public String getMessage(String arg0, Object[] arg1, String arg2,
					Locale arg3) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getMessage(String arg0, Object[] arg1, Locale arg2)
					throws NoSuchMessageException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getMessage(MessageSourceResolvable arg0, Locale arg1)
					throws NoSuchMessageException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public BeanFactory getParentBeanFactory() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean containsLocalBean(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isTypeMatch(String arg0, Class arg1)
					throws NoSuchBeanDefinitionException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isSingleton(String arg0)
					throws NoSuchBeanDefinitionException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isPrototype(String arg0)
					throws NoSuchBeanDefinitionException {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Class getType(String arg0) throws NoSuchBeanDefinitionException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getBean(String arg0, Object[] arg1) throws BeansException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getBean(String arg0, Class arg1) throws BeansException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Object getBean(String arg0) throws BeansException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String[] getAliases(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean containsBean(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Map getBeansOfType(Class arg0, boolean arg1, boolean arg2)
					throws BeansException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Map getBeansOfType(Class arg0) throws BeansException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String[] getBeanNamesForType(Class arg0, boolean arg1, boolean arg2) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String[] getBeanNamesForType(Class arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String[] getBeanDefinitionNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getBeanDefinitionCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public boolean containsBeanDefinition(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public long getStartupDate() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public ApplicationContext getParent() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getId() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getDisplayName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public AutowireCapableBeanFactory getAutowireCapableBeanFactory()
					throws IllegalStateException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void setParent(ApplicationContext arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void registerShutdownHook() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void refresh() throws BeansException, IllegalStateException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isActive() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public ConfigurableListableBeanFactory getBeanFactory()
					throws IllegalStateException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addBeanFactoryPostProcessor(BeanFactoryPostProcessor arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addApplicationListener(ApplicationListener arg0) {
				// TODO Auto-generated method stub
				
			}
		};

		System.out.println("Calling Bean method: sayHello()");
		//Retrieve the bean from Container
		Spring3HelloWorld myBean = (Spring3HelloWorld) context.getBean("spring3HelloWorld");
		myBean.sayHello();

	}

}
