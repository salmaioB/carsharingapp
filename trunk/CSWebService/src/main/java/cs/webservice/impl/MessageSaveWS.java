package cs.webservice.impl;

import com.opensymphony.xwork2.ActionSupport;

public class MessageSaveWS extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	
	private String title;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String execute() throws Exception
 	{
		
		
		return SUCCESS;	
 	}
}
