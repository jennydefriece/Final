package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
			
			//added code
			
			try{
				int creditScore = lq.getiCreditScore();
				lq.setdRate(RateBLL.getRate(lq.getiCreditScore()));
				double rate = lq.getdRate() / 1200;
				double p = RateBLL.getPayment(rate/1200, lq.getiTerm()*12, lq.getdAmount() - lq.getiDownPayment(),0, false);
			
				lq.setdPayment(p);
				sendToAll(lq);
			}
			catch (RateException e) {
				sendToAll(lq);
		}
	}
	}
}
