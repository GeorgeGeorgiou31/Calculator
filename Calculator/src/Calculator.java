import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[10];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton,equButton,delButton,clrButton,negButton,powButton;
	JPanel panel;
	
	
	Font myFont = new Font("Ink Free", Font.BOLD, 30);
	
	
	double num1 = 0, num2=0, result=0;
	char operator;
	
	Calculator() {
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the calculator on X
		frame.setSize(510,600); //size
		frame.setLayout(null);
		
		//textfield
		textfield = new JTextField();
		textfield.setBounds(50, 25, 400, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false);  //user cant type in textfield
		
		
		//text in buttons
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("DEL");
		clrButton = new JButton("CLR");
		negButton = new JButton("(-)");
		powButton = new JButton("^");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		functionButtons[9] = powButton;
		
		//iterate through all special buttons
		for (int i=0; i<10; i++) {
			
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		
		//getting all buttons in a for loop rather than do it like the special buttons
				for (int i=0; i<10; i++) {
					
					numberButtons[i] = new JButton(String.valueOf(i));
					numberButtons[i].addActionListener(this);
					numberButtons[i].setFont(myFont);
					numberButtons[i].setFocusable(false);
					
				}
		
			//negButton.setBounds(50,430,100,50);  //Neg Button
			//delButton.setBounds(150,430,100,50);  //Del button bounds
			//clrButton.setBounds(250,430,100,50); //Clr button bounds
			
			
		
		
		//Panel to hold all the buttons
			panel = new JPanel();
			panel.setBounds(50,100,400,400);
			panel.setLayout(new GridLayout(5,4,10,10));  // (4,4,10,10)--> (rows,columns,pixel space, pixel space)
			panel.setBackground(Color.white);        //for bg color
			
			//showing special and number buttons
			panel.add(numberButtons[1]);
			panel.add(numberButtons[2]);
			panel.add(numberButtons[3]);
			panel.add(addButton);
			
			panel.add(numberButtons[4]);
			panel.add(numberButtons[5]);
			panel.add(numberButtons[6]);
			panel.add(subButton);
			
			panel.add(numberButtons[7]);
			panel.add(numberButtons[8]);
			panel.add(numberButtons[9]);
			panel.add(mulButton);
			
			panel.add(decButton);
			panel.add(numberButtons[0]);
			panel.add(powButton);
			panel.add(divButton);
			
			panel.add(delButton);
			panel.add(clrButton);
			panel.add(negButton);
			panel.add(equButton);
			
			
			
			
		frame.add(panel);
		//frame.add(negButton);
		//frame.add(delButton);  //showing del button
		//frame.add(clrButton);  //showing clr button
		//frame.add(powButton);  //showing pow button
		frame.add(textfield);  //showing textfield
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//when you press the button, it types on the textfield
		for (int i=0; i<10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		//when you press the decimal button types on the screen
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		
				//funcionalitu of the buttons
				
				if(e.getSource() == addButton) {
					num1 = Double.parseDouble(textfield.getText());
					operator = '+';
					textfield.setText("");
				}
		
		
				if(e.getSource() == subButton) {
					num1 = Double.parseDouble(textfield.getText());		
					operator = '-';
					textfield.setText("");
				}
				
				
				if(e.getSource() == mulButton) {
					num1 = Double.parseDouble(textfield.getText());
					operator = '*';
					textfield.setText("");
				}
	
				
				if(e.getSource() == divButton) {
					num1 = Double.parseDouble(textfield.getText());
					operator = '/';
					textfield.setText("");
				}
				
				if(e.getSource() == powButton) {
					num1 = Double.parseDouble(textfield.getText());
					operator = '^';
					textfield.setText("");
				}
				
				//equation Button
				if(e.getSource() == equButton) {
					num2 = Double.parseDouble(textfield.getText());
					
					switch(operator) {
					case '+':
						result = num1+num2;
						break;
					case '-':
						result = num1-num2;
						break;
					case '*':
						result = num1*num2;
						break;
					case '/':
						result = num1/num2;
						break;
					case '^':
						result = Math.pow(num1, num2);
						break;
					}
					
					textfield.setText(String.valueOf(result));
					num1=result; //saving the result
					
				}
				
				
					if(e.getSource() == clrButton) {
						textfield.setText("");
				}
					
					if(e.getSource() == delButton) {
						String string = textfield.getText();
						textfield.setText("");
						for(int i=0; i<string.length()-1; i++) {
							textfield.setText(textfield.getText()+string.charAt(i));
						}
					}
					
					if(e.getSource() == negButton) {
						double temp = Double.parseDouble(textfield.getText());
						temp*=-1;
						textfield.setText(String.valueOf(temp));
						
					}	
	}
	


}
