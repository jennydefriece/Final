package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException
	{
		ArrayList<RateDomainModel> Rates = RateDAL.getAllRates();
		double Rate = 0;
		
		for (RateDomainModel x : Rates) {
			if (Rates.getiMinCreditScore() == GivenCreditScore) {
				double foundrate = Rates.getdInterestRate();
				
			}
			double foundrate;
			if (foundrate == 0) {
				throw new RateException(Rates);
		}
			return Rate;
			
		}
		
	}
		
		
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}