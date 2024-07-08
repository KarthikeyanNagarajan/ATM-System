package com.karthik.ATMSystem.state;

import com.karthik.ATMSystem.model.Card;
import com.karthik.ATMSystem.service.ATMSystem;

public interface ATMState
{
	public void insertCard(String cardNo);

	public void insertPin(String pin);

	public void checkAccountBalance();

	public void changePin(String oldPin, String newPin);

	public void withdrawMoney(double amount);

	public void depositMoney(double amount);
	
	public void ejectCard();

	default void ejectCard1(Card card, ATMSystem atm)
	{
		System.out.println("Ejecting card...");
		atm.setInsertedCard(null);
		atm.setAuthenticatedAccount(null);
		atm.setState(atm.getIdleState());
	}
}
