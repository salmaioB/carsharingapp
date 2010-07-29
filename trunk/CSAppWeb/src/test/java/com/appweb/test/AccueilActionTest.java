package com.appweb.test;

import junit.framework.TestCase;
import com.opensymphony.xwork2.ActionSupport;
import com.appweb.action.AccueilAction;

public class AccueilActionTest extends TestCase
{
  public void testhelloAction() throws Exception
  {
	  System.out.println("test");
	  /*
    AccueilAction index = new AccueilAction();
    String result = index.execute();
    assertTrue("Expected a success result!", ActionSupport.SUCCESS.equals(result));
    assertTrue("Expected the default message!", AccueilAction.MESSAGE.equals(index.getMessage()));
    */
    }
}