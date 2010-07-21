package cs.model;

import java.util.Date;

public class Opinions
{
	private Integer id;
	private Integer idCustomerAccount;
	private Integer positiveOrNegative;
	private String comment;
	private Date created;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
}
