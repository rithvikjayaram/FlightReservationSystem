package com.fight.client.dto;

import lombok.Data;

@Data
public class ReservationRequest {

	private int flightId;
	private String passenerFirstName;
	private String passenerLastName;
	private String passeneremail;
	private String passenerPhone;
	private String nameOnTheCard;
	private String cardNo;
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getPassenerFirstName() {
		return passenerFirstName;
	}
	public void setPassenerFirstName(String passenerFirstName) {
		this.passenerFirstName = passenerFirstName;
	}
	public String getPassenerLastName() {
		return passenerLastName;
	}
	public void setPassenerLastName(String passenerLastName) {
		this.passenerLastName = passenerLastName;
	}
	public String getPasseneremail() {
		return passeneremail;
	}
	public void setPasseneremail(String passeneremail) {
		this.passeneremail = passeneremail;
	}
	public String getPassenerPhone() {
		return passenerPhone;
	}
	public void setPassenerPhone(String passenerPhone) {
		this.passenerPhone = passenerPhone;
	}
	public String getNameOnTheCard() {
		return nameOnTheCard;
	}
	public void setNameOnTheCard(String nameOnTheCard) {
		this.nameOnTheCard = nameOnTheCard;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getSecurityCode() {
		return securityCode;
	}
	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	private String expiryDate;
	private String securityCode;
}
