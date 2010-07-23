package cs.model;

import java.util.Date;

public class Opinion
{
	private Integer id;
	private Integer idCustomerAccount;
	private Integer positiveOrNegative;
	private String comment;
	private Date dateCreated;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
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
