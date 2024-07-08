package com.karthik.ATMSystem.state;

import com.karthik.ATMSystem.model.Card;
import com.karthik.ATMSystem.service.ATMSystem;

public class IdleState implements ATMState
{
	ATMSystem atm;

	public IdleState(ATMSystem atm)
	{
		this.atm = atm;
	}

	@Override
	public void insertCard(String cardNo)
	{
		System.out.println("Card inserted !!! Validating...");
		if (atm.getBank().isCardValid(cardNo))
		{
			System.out.println("Card No. valid... Please enter Pin !!!");
			atm.setInsertedCard(new Card(cardNo, null));
			atm.setState(atm.getCardInsertedState());
		}
		else
		{
			System.out.println("Card No. Invalid !!!");
			atm.setState(atm.getTransactionCompleteState());
			atm.getState().ejectCard();
		}
	}

	@Override
	public void insertPin(String pin)
	{
		System.out.println("Card not inserted !!! Cannot insert Pin !!!");
	}

	@Override
	public void checkAccountBalance()
	{
		System.out.println("Card not inserted !!! Cannot check account balance !!!");
	}

	@Override
	public void changePin(String oldPin, String newPin)
	{
		System.out.println("Card not inserted !!! Cannot change Pin !!!");
	}

	@Override
	public void withdrawMoney(double amount)
	{
		System.out.println("Card not inserted !!! Cannot withdraw money !!!");
	}

	@Override
	public void depositMoney(double amount)
	{
		System.out.println("Card not inserted !!! Cannot deposit money !!!");
	}

	@Override
	public void ejectCard()
	{
		System.out.println("Card not inserted !!! Cannot eject card !!!");
	}

}
