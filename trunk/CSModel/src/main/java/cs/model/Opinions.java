package cs.model;

import java.util.Date;

public class Opinions
{
	private Integer idOpinion;
	private Integer idCustomerAccount;
	private Integer positiveOrNegative;
	private String comment;
	private Date dateCreated;
	
	
	public Integer getIdOpinion() {
		return idOpinion;
	}
	
	public void setIdOpinion(Integer idOpinion) {
		this.idOpinion = idOpinion;
	}
	
	public Integer getIdCustomerAccount() {
		return idCustomerAccount;
	}
	
	public void setIdCustomerAccount(Integer idCustomerAccount) {
		this.idCustomerAccount = idCustomerAccount;
	}
	
	public Integer getPositiveOrNegative() {
		return positiveOrNegative;
	}
	
	public void setPositiveOrNegative(Integer positiveOrNegative) {
		this.positiveOrNegative = positiveOrNegative;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
