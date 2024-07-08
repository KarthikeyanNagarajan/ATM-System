package com.karthik.ATMSystem.model;

import java.util.Objects;

public class Card
{
	private String cardNumber;
	private String pin;

	public Card(String cardNumber, String pin)
	{
		this.cardNumber = cardNumber;
		this.pin = pin;
	}

	public String getCardNumber()
	{
		return cardNumber;
	}

	public void setCardNumber(String cardNumber)
	{
		this.cardNumber = cardNumber;
	}

	public String getPin()
	{
		return pin;
	}

	public void setPin(String pin)
	{
		this.pin = pin;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Card card = (Card) o;
		return cardNumber.equals(card.cardNumber) && pin.equals(card.pin);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(cardNumber, pin);
	}
}
