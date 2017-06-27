package com.oreilly.aspectjcookbook;

public class BusinessCard
{
	private String firstName;
	private String surname;
	private String jobDescription;
	private String emailAddress;

	public BusinessCard(
		String firstName,
		String surname,
		String jobDescription,
		String emailAddress)
	{
		this.firstName = firstName;
		this.surname = surname;
		this.jobDescription = jobDescription;
		this.emailAddress = emailAddress;
	}

	public String toString()
	{
		return this.firstName
			+ " "
			+ this.surname
			+ "\n"
			+ this.jobDescription
			+ "\n"
			+ this.emailAddress
			+ "\n";
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}

	public String getJobDescription()
	{
		return jobDescription;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getSurname()
	{
		return surname;
	}

}
