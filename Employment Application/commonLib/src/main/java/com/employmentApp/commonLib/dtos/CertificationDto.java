package com.employmentApp.commonLib.dtos;

import java.time.LocalDateTime;

public class CertificationDto
{
	/*
	 * @author Mohamed Rafick
	 */
	private String name;
	private String issuer;
	private LocalDateTime issuedDate;
	private LocalDateTime validUntil;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public LocalDateTime getIssuedDate() {
		return issuedDate;
	}
	public void setIssuedDate(LocalDateTime issuedDate) {
		this.issuedDate = issuedDate;
	}
	public LocalDateTime getValidUntil() {
		return validUntil;
	}
	public void setValidUntil(LocalDateTime validUntil) {
		this.validUntil = validUntil;
	}
	
	

}
