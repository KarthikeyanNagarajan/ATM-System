package com.karthik.ATMSystem.state;

import java.util.Optional;
import com.karthik.ATMSystem.model.Account;
import com.karthik.ATMSystem.service.ATMSystem;

public class CardInsertedState implements ATMState
{
	ATMSystem atm;

	public CardInsertedState(ATMSystem atm)
	{
		this.atm = atm;
	}

	@Override
	public void insertCard(String cardNo)
	{
		System.out.println("Card already inserted !!! Cannot insert another card !!!");
	}

	@Override
	public void insertPin(String pin)
	{
		System.out.println("Validating Pin...");
		atm.getInsertedCard().setPin(pin);
		Optional<Account> account = atm.getBank().getAccount(atm.getInsertedCard());
		if (account.isPresent())
		{
			System.out.println("Pin Authenticated !!!");
			atm.setAuthenticatedAccount(account.get());
			atm.setState(atm.getPinValidatedState());
		}
		else
		{
			System.out.println("Incorrect Pin !!! Enter valid Pin !!!");
			atm.getState().ejectCard();
		}
	}

	@Override
	public void checkAccountBalance()
	{
		System.out.println("Not authenticated !!! Cannot check account balance !!!");
	}

	@Override
	public void changePin(String oldPin, String newPin)
	{
		System.out.println("Not authenticated !!! Cannot change Pin !!!");
	}

	@Override
	public void withdrawMoney(double amount)
	{
		System.out.println("Not authenticated !!! Cannot withdraw money !!!");
	}

	@Override
	public void depositMoney(double amount)
	{
		System.out.println("Not authenticated !!! Cannot insert money !!!");
	}

	@Override
	public void ejectCard()
	{
		atm.setState(atm.getTransactionCompleteState());
		atm.getState().ejectCard();
	}

}
