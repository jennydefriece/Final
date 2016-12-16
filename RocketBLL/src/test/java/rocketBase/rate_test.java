package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void test_getRate() throws RateException {
		try{
	
		assert(RateBLL.getRate(650)==4.5);
		assert(RateBLL.getRate(800)==3.5);
		assert(RateBLL.getRate(700)==4.0);
		assert(RateBLL.getRate(640)== 5.0);
		assert(RateBLL.getRate(600)==5.0);
		}
		catch (RateException e) {
			e.printStackTrace();
		}
		@Test
		public void Test_Payment(){
			assertEquals(RateBLL.getPayment(0.04/12, 360, 300000, 0, false), -1432.25, 0.005);
		}
		
		
	}
}
