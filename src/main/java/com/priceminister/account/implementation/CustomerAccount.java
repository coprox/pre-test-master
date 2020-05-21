package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

	private double _balance = 0;
		
	
    public void add(Double addedAmount) {
    	_balance += addedAmount;
    }

    public Double getBalance() {
    	return this._balance; 
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) throws IllegalBalanceException {
    
    	 if (rule.withdrawPermitted(_balance - withdrawnAmount) == false)
    		throw new IllegalBalanceException(withdrawnAmount);
    	
    	_balance -= withdrawnAmount;
    	
    	return _balance;
    }

}
