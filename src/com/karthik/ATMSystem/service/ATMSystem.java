package com.karthik.ATMSystem.service;

import com.karthik.ATMSystem.model.Account;
import com.karthik.ATMSystem.model.Card;
import com.karthik.ATMSystem.state.ATMState;
import com.karthik.ATMSystem.state.CardInsertedState;
import com.karthik.ATMSystem.state.IdleState;
import com.karthik.ATMSystem.state.PinValidatedState;
import com.karthik.ATMSystem.state.TransactionCompleteState;

public class ATMSystem
{
	private Bank bank;
	private ATMState state;
	private ATMState idleState;
	private ATMState cardInsertedState;
	private ATMState pinValidatedState;
	private ATMState transactionCompleteState;

	private double atmBalance;
	private Card insertedCard;
	private Account authenticatedAccount;

	private static ATMSystem atmSystem;

	private ATMSystem(double atmBalance)
	{
		this.idleState = new IdleState(this);
		this.cardInsertedState = new CardInsertedState(this);
		this.pinValidatedState = new PinValidatedState(this);
		this.transactionCompleteState = new TransactionCompleteState(this);
		this.state = idleState;
		this.atmBalance = atmBalance;
		this.bank = Bank.getInstance();
	}

	public static ATMSystem getInstance(double atmBalance)
	{
		if (atmSystem == null)
			atmSystem = new ATMSystem(atmBalance);
		return atmSystem;
	}

	public void increaseAtmBalance(double amount)
	{
		this.atmBalance += amount;
	}

	public void decreaseAtmBalance(double amount)
	{
		this.atmBalance -= amount;
	}

	public ATMState getState()
	{
		return state;
	}

	public void setState(ATMState state)
	{
		this.state = state;
	}

	public ATMState getIdleState()
	{
		return idleState;
	}

	public ATMState getCardInsertedState()
	{
		return cardInsertedState;
	}

	public ATMState getPinValidatedState()
	{
		return pinValidatedState;
	}

	public ATMState getTransactionCompleteState()
	{
		return transactionCompleteState;
	}

	public Account getAuthenticatedAccount()
	{
		return authenticatedAccount;
	}

	public void setAuthenticatedAccount(Account authenticatedAccount)
	{
		this.authenticatedAccount = authenticatedAccount;
	}

	public Bank getBank()
	{
		return bank;
	}

	public Card getInsertedCard()
	{
		return insertedCard;
	}

	public void setInsertedCard(Card insertedCard)
	{
		this.insertedCard = insertedCard;
	}

	public double getAtmBalance()
	{
		return atmBalance;
	}

	public void insertCard(String cardNo)
	{
		state.insertCard(cardNo);
	}

	public void insertPin(String pin)
	{
		state.insertPin(pin);
	}

	public void ejectCard()
	{
		state.ejectCard();
	}

	public void changePin(String oldPin, String newPin)
	{
		state.changePin(oldPin, newPin);
	}

	public void checkAccountBalance()
	{
		state.checkAccountBalance();
	}

	public void withdrawMoney(double amount)
	{
		state.withdrawMoney(amount);
	}

	public void depositMoney(double amount)
	{
		state.depositMoney(amount);
	}
}
