import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
public class LoanAssistentGui{
	JFrame frame;
	JLabel loanAmount,interestRate,numberOfPayments,mothlyAmount,loanAnalysis;
	JTextField text1,text2,text3,text4;
	JTextArea textArea;
	JButton btnComputePayment,btnNewCompute,btnExit,btnX,btnX2;
	public LoanAssistentGui() {
		//Design a Loan Analysis Frame.......
		frame = new JFrame();
		frame.setTitle("Loan Assistant");
		frame.setSize(640,280);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		Font font = new Font("Arial",Font.PLAIN,16);
		loanAmount=new JLabel("Loan Balance");
		loanAmount.setFont(font);
		loanAmount.setSize(100,40);
		loanAmount.setLocation(5,0);
		text1=new JTextField();
		text1.setHorizontalAlignment(JTextField.RIGHT);
		text1.setFont(font);
		text1.setBounds(170,5,120,25);
		interestRate=new JLabel("Interest Rate");
		interestRate.setFont(font);
		interestRate.setSize(100,40);
		interestRate.setLocation(5,40);
		text2=new JTextField();
		text2.setHorizontalAlignment(JTextField.RIGHT);
		text2.setFont(font);
		text2.setBounds(170,45,120,25);
		numberOfPayments=new JLabel("Number of Payments");
		numberOfPayments.setFont(font);
		numberOfPayments.setSize(150,40);
		numberOfPayments.setLocation(5,80);
		text3=new JTextField();
		text3.setHorizontalAlignment(JTextField.RIGHT);
		text3.setFont(font);
		text3.setBounds(170,85,120,25);
		btnX=new JButton("X");
		btnX.setSize(50,25);
		btnX.setLocation(300, 85);
		mothlyAmount=new JLabel("Monthly Payment");
		mothlyAmount.setFont(font);
		mothlyAmount.setSize(150,40);
		mothlyAmount.setLocation(5,120);
		text4=new JTextField();
		text4.setHorizontalAlignment(JTextField.RIGHT);
		text4.setFont(font);
		text4.setBounds(170,125,120,25);
		btnX2=new JButton("X");
		btnX2.setSize(50,25);
		btnX2.setLocation(300,125);
		btnComputePayment=new JButton("Compute Payment");
		btnComputePayment.setSize(230,25);
		btnComputePayment.setLocation(40,165);
		btnNewCompute=new JButton("New Loan Analysis");
		btnNewCompute.setSize(150,25);
		btnNewCompute.setLocation(80,205);
		btnNewCompute.setEnabled(false);
		loanAnalysis=new JLabel("Loan Analysis");
		loanAnalysis.setFont(font);
		loanAnalysis.setSize(150,40);
		loanAnalysis.setLocation(360,0);
		textArea=new JTextArea();
		textArea.setFont(new Font("Arial",Font.BOLD,12));
		textArea.setEditable(false);
		textArea.setSize(250,170);
		textArea.setLocation(360,35);
		btnExit=new JButton("Exit");
		btnExit.setSize(70,25);
		btnExit.setLocation(445,210);
		Container c = frame.getContentPane();
		c.setLayout(null);
		c.add(loanAmount);
		c.add(text1);
		text1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text1ActionPerformed(e);
			}
		});
		c.add(interestRate);
		c.add(text2);
		text2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text2ActionPerformed(e);
			}
		});
		c.add(numberOfPayments);
		c.add(text3);
		text3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text3ActionPerformed(e);
			}
		});
		c.add(mothlyAmount);
		c.add(text4);
		text4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				text4ActionPerformed(e);
			}
		});
		c.add(btnX);
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		c.add(btnX2);
		btnX2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		c.add(btnComputePayment);
		c.add(btnNewCompute);
		c.add(loanAnalysis);
		c.add(textArea);
		c.add(btnExit);
		btnNewCompute.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				btnNewComputeActionPerformed(e);
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnXActionPerformed(e);
			}
		});
		btnX2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnX2ActionPerformed(e);
			}
		});
		btnComputePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnComputePaymentActionListener(e);
			}
		});
/*		 __________________________________________________________
		|                     __________        Loan Analysis      |
		| Loan Balance       |__________|        __________________|
		| Interest Rate      |__________|  ___  |                  |
		| Number of Payment  |__________| |_X_| |                  |
		| Monthly Payment    |__________| |_X_| |   //TextArea     |
		|    ____________________________       |                  |  
		|   |_Compute Monthly Payment____|      |                  |
		|	    _______________________         |__________________|
		|	   |____New Loan Analysis__|               |Exit|      |
		|__________________________________________________________|
*/		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	Color lightBlue = new Color(186,219,255);
	boolean computePayment;
	private void btnXActionPerformed(ActionEvent e) {
		//Compute Number of Payment
		computePayment=false;
		btnX.setVisible(false);
		btnX2.setVisible(true);
		text4.setEditable(true);
		text4.setBackground(Color.WHITE);
		text4.setFocusable(true);
		text3.setText("");
		text3.setEditable(false);
		text3.setFocusable(false);
		text3.setBackground(lightBlue);
		btnComputePayment.setText("Compute Number of Payment");
		loanAmount.requestFocus();
	}
	private void btnX2ActionPerformed(ActionEvent e) {
		//compute Month
		computePayment=true;
		btnX2.setVisible(false);
		btnX.setVisible(true);
		text4.setText("");
		text4.setEditable(false);
		text4.setBackground(lightBlue);
		text4.setFocusable(false);
		text3.setBackground(Color.WHITE);
		text3.setEditable(true);
		text3.setFocusable(true);
		btnComputePayment.setText("Compute Monthly Payments");
		loanAmount.requestFocus();
	}
	
	private void btnComputePaymentActionListener(ActionEvent e) {
		//Calculating loan Analysis.....
		double loanBalance,interestRate,monthlyPayment;
		int numberOfPayment;
		double balance,finalPayment;
		if(validateInput(text1)) {
			loanBalance=Double.valueOf(text1.getText()).doubleValue();
		}
		else {
			JOptionPane.showConfirmDialog(null, "Invalid or Empty Loan Balance Entry.\nPlease Correct."
			,"Balance Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(validateInput(text2)) {
			interestRate=Double.valueOf(text2.getText()).doubleValue();
		}
		else {
			JOptionPane.showConfirmDialog(null, "Invalid or Empty Interest Rate Entry.\nPlease Correct."
			,"Interest Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		double monthlyInterest,multiplier;
		monthlyInterest=interestRate/1200; 
		if(computePayment) {
			//Compute Monthly Payment......
			if(validateInput(text3)) {
				numberOfPayment=Integer.valueOf(text3.getText()).intValue();
			}
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or Empty Number of Month Entry.\nPlease Correct."
						,"Number of Month Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if(interestRate==0) {
				monthlyPayment=loanBalance/numberOfPayment;
			}
			else {
				multiplier=Math.pow(1+monthlyInterest, numberOfPayment);
				monthlyPayment=loanBalance*monthlyInterest*multiplier/(multiplier-1);
			}
			text4.setText(new DecimalFormat("0.00").format(monthlyPayment));
		}
		else {
			//Compute Number of Payment
			if(validateInput(text4)) {
				monthlyPayment=Double.valueOf(text4.getText()).doubleValue();
				if(monthlyPayment<=(loanBalance*monthlyInterest+1.0)) {
					//To check Monthly Payment Amount is valid or not........
					if(JOptionPane.showConfirmDialog(null, "Minimum Payment should be $"
				+new DecimalFormat("0.00").format((int)(loanBalance*monthlyInterest+1.0))+
				"\n"+"Do you Want to use this minimum payment?","Input Error"
				,JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION) {
						
						text4.setText(new DecimalFormat("0.00").format((int)(loanBalance*monthlyInterest+1.0)));
						monthlyPayment=Double.valueOf(text4.getText()).doubleValue();
					}
					else {
						text4.requestFocus();
						return;
					}
				}
			}
			else {
				JOptionPane.showConfirmDialog(null, "Invalid or Empty Monthly Amount Entry.\nPlease Correct."
						,"Monthly Amount Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
				return;
			}
			if(interestRate==0) {
				numberOfPayment=(int)(loanBalance/monthlyPayment);
			}
			else {
				numberOfPayment=(int)((Math.log(monthlyPayment)-Math.log(monthlyPayment-loanBalance*monthlyInterest))/Math.log(1+monthlyInterest));
			}
			text3.setText(String.valueOf(numberOfPayment));
		}
		//showing all compute amount and interest paid, etc, on the Loan Analysis textArea...........
		monthlyPayment=Double.valueOf(text4.getText()).doubleValue();
		textArea.setText("Loan Balance : $"+new DecimalFormat("0.00").format(loanBalance));
		textArea.append("\n"+"Interest Rate : "+ new DecimalFormat("0.00").format(interestRate)+"%");
		balance=loanBalance;
		for(int payNumber=1;payNumber<=numberOfPayment-1;payNumber++) {
			balance=balance+balance*monthlyInterest-monthlyPayment;
		}
		finalPayment=balance;
		//To check final payment is greater than monthly Payment
		if(finalPayment>monthlyPayment) {
			balance=balance+balance*monthlyInterest-monthlyPayment;
			finalPayment=balance;
			numberOfPayment++;
			text3.setText(String.valueOf(numberOfPayment));
		}
		textArea.append("\n\n"+String.valueOf(numberOfPayment-1)+" Payments of $"+ new DecimalFormat("0.00").format(monthlyPayment));
		textArea.append("\n"+"Final Payment : $"+new DecimalFormat("0.00").format(finalPayment));
		textArea.append("\n"+"Total Payment : $"+new DecimalFormat("0.00").format((numberOfPayment-1)*monthlyPayment+finalPayment));
		textArea.append("\n"+"Interest Paid : $"+new DecimalFormat("0.00").format((numberOfPayment-1)*monthlyPayment+finalPayment-loanBalance));
		btnComputePayment.setEnabled(false);
		btnNewCompute.setEnabled(true);
		btnNewCompute.requestFocus();
	}
	
	//Enable New Loan Button and disable compute Button...
	private void btnNewComputeActionPerformed(ActionEvent e) {
		if(computePayment) {
			text4.setText("");
		}
		else {
			text3.setText("");
		}
		textArea.setText("");
		btnComputePayment.setEnabled(true);
		btnNewCompute.setEnabled(false);
		text1.requestFocus();
	}
	
	//Focus Transfer to the textFields..........
	private void text1ActionPerformed(ActionEvent e) {
		text1.transferFocus();
	}
	private void text2ActionPerformed(ActionEvent e) {
		text2.transferFocus();
	}	
	private void text3ActionPerformed(ActionEvent e) {
		text3.transferFocus();
	}
	private void text4ActionPerformed(ActionEvent e) {
		text4.transferFocus();
	}
	
	//Input Validation Code
	public boolean validateInput(JTextField textField) {
		String str = textField.getText().trim();
		boolean hasDec=false;
		boolean valid =true;
		if(str.length()==0) {
			valid=false;
		}
		else {
			for(int i=0;i<str.length();i++) {
				char ch =str.charAt(i);
				if(ch>='0' && ch<='9') {
					continue;
				}
				else if(ch=='.' && !hasDec) {
					hasDec=true;
				}
				else {
					valid=false;  //Invalid Character Found
				}
			}
		}
		textField.setText(str);
		if(!valid) {
			textField.requestFocus();
		}
		return valid;
	}
	//Main Method.........
	public static void main(String[] args) {
		new LoanAssistentGui();
	}
}