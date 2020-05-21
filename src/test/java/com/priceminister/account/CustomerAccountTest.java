package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    Account customerAccount;
    AccountRule rule;
    
    final double addBalance = 10;
    final double withdrawnAmount = 10;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        customerAccount = new CustomerAccount();
        rule = new CustomerAccountRule();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {

    	assertNotNull(customerAccount.getBalance());
    	assertEquals(0.0, customerAccount.getBalance(), 0);

    }
    
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
    	
    	double initialBalance = 0;
    	
    	assertNotNull(customerAccount.getBalance());
    	initialBalance = customerAccount.getBalance();
    	customerAccount.add(addBalance);
    	assertEquals(initialBalance + addBalance, customerAccount.getBalance(), 0);	
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test
    public void testWithdrawAndReportBalanceIllegalBalance() {
    	
    	double initialBalance = 0;
    	double reportBalance = 0;
    	
    	assertNotNull(customerAccount.getBalance());
    	initialBalance = customerAccount.getBalance();
    	
    	try {
    		reportBalance = customerAccount.withdrawAndReportBalance(withdrawnAmount, rule);
    	}
    	
    	catch (IllegalBalanceException e){
    		assertEquals("Illegal account balance: "+withdrawnAmount, e.toString());
    		return ;
    	}
    	catch (Exception e)
    	{
    		fail("wrongException");
    	}
    	
    	assertEquals(initialBalance - withdrawnAmount, reportBalance, 0);	
    	
    }
    
    // Also implement missing unit tests for the above functionalities.

}
