package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	private static final RateDomainModel Rate = null;
	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
	
private RateDomainModel exceptRate;

	
	public RateException(RateDomainModel rate){
		this.exceptRate = rate;
		
	}
	
	public RateDomainModel getRate() {
		return Rate;
	
	}
}

