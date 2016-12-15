package rocket.app.view;

import java.awt.TextField;

import com.sun.xml.ws.org.objectweb.asm.Label;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	private MainApp mainApp;
	
	//	TODO - RocketClient.RocketMainController
	
	//	Create private instance variables for:
	//		TextBox  - 	txtIncome
	//		TextBox  - 	txtExpenses
	//		TextBox  - 	txtCreditScore
	//		TextBox  - 	txtHouseCost
	//		ComboBox -	loan term... 15 year or 30 year
	//		Labels   -  various labels for the controls
	//		Button   -  button to calculate the loan payment
	//		Label    -  to show error messages (exception throw, payment exception)
	
	
	@FXML
	private TextField txtIncome;
	@FXML
	private TextField txtExpenses;
	@FXML
	private TextField txtCreditScore;
	@FXML
	private TextField txtHouseCost;
	@FXML
	private TextField txtDownPayment;

	@FXML
	private Label lblTitle;
	@FXML
	private Label lblDirections;
	@FXML
	private Label lblIncome;
	@FXML
	private Label lblExpenses;
	@FXML
	private Label lblCreditScore;
	@FXML
	private Label lblHouseCost;
	@FXML
	private Label lblMortgageTerm;
	@FXML
	private Label lblMortgagePayment;
	
	@FXML
	private ComboBox<String> cmbTerm;
	
	
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	private void initialize(){
		cmb.getItems().removeAll(cmb.getItems());
		cmb.getItems().addAll("15","30");
	}
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Object message = null;
		//	TODO - RocketClient.RocketMainController
		
		Action a = new Action(eAction.CalculatePayment);
		LoanRequest lq = new LoanRequest();
		//	TODO - RocketClient.RocketMainController
		//			set the loan request details...  rate, term, amount, credit score, downpayment
		//			I've created you an instance of lq...  execute the setters in lq

		
		lq.setIncome(Double.parseDouble(txtIncome.getText()));
		lq.setdExpenses(Double.parseDouble(txtExpenses.getText()));
		lq.setdAmount(Double.parseDouble(txtHouseCost.getText()));
		lq.setiDownPayment(Integer.parseInt(txtDownPayment.getText()));
		lq.setiIncome(Double.parseDouble(txtIncome.getText()));
		
		
		
		
		a.setLoanRequest(lq);
		
		//	send lq as a message to RocketHub		
		mainApp.messageSend(lq);
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		//	TODO - RocketClient.HandleLoanRequestDetails
		//			lRequest is an instance of LoanRequest.
		//			after it's returned back from the server, the payment (dPayment)
		//			should be calculated.
		//			Display dPayment on the form, rounded to two decimal places
		
		double actualPayment;
		double PITI1 = lRequest.getdRate()*0.28;
		double PITI2 = lRequest.getdRate()*0.36 - lRequest.getExpenses();
		
		if (PITI1 < PITI2) {
			double actualPayment1 = PITI1 ;
		}
		else {
			double actualPayment1 = PITI2;
		}
		
		
		if (lRequest.getdPayment() > actualPayment) {
			lblErrors.setText("House Cost is too high for you.");
		}
		else {
			lblMortgagePayment.setText("Monthly Mortgage Payment: "+ actualPayment);

		}
		
	}
}
		
	
