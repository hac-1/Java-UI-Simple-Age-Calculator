import java.util.*; 	
import java.awt.*; 
import java.awt.event.*;	
import javax.swing.*;
//-----------------------------------------------------------
class calc{
	int d,m,y,dd,dm,dy,buff;
	//GottenDate,Month,Year,DifferenceDate,Month,Year

	calc(String a,String b,String c){
		d=Integer.parseInt(a);
		y=Integer.parseInt(c);
		if(b.equals("January")){m=1;dd=31;buff=31;}
		else if(b.equals("February")){
			m=2;
			if(y%4==0){dd=29;}//Calculation during leap year
			else{dd=28;}
			buff=31;
		}
		else if(b.equals("March")){m=3;dd=31;buff=30;}
		else if(b.equals("April")){m=4;dd=30;buff=31;}
		else if(b.equals("May")){m=5;dd=31;buff=30;}
		else if(b.equals("June")){m=6;dd=30;buff=31;}
		else if(b.equals("July")){m=7;dd=31;buff=30;}
		else if(b.equals("August")){m=8;dd=31;buff=30;}
		else if(b.equals("September")){m=9;dd=30;buff=31;}
		else if(b.equals("October")){m=10;dd=31;buff=30;}
		else if(b.equals("November")){m=11;dd=30;buff=31;}
		else if(b.equals("December")){m=12;dd=31;buff=30;}
		
	}
	void calculate(){
		//Calender intialisation
		GregorianCalendar cal = new GregorianCalendar();
		int cy=cal.get(Calendar.YEAR); //Current Year
		int cm=cal.get(Calendar.MONTH)+1; //Current Month
		int cd=cal.get(Calendar.DATE); //Current Date
		if(cm<m){ //to ensure for non negative months
			cm=cm+12;
			dy=cal.get(Calendar.YEAR)-y-1;}
		else{dy=cal.get(Calendar.YEAR)-y;}
		dm=cm-m;
		if(d>dd){
			dm=dm-1;
			dd=dd+buff;}
		dd=dd-d;
	}
	
		
}

//-----------------------------------------------------------
public class AgeFromBday{


public static void main(String args[]){
	//Creating Frame
	JFrame jf=new JFrame("AGE CALCULATOR");
	jf.setSize(1300,1300);
	jf.setResizable(false);
	jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel panel1=new JPanel();
	JLabel label1=new JLabel("Enter Details");
	label1.setSize(300,100);
	panel1.add(label1);

	JPanel panel2=new JPanel();
	//DATE------------------------
	JLabel datelabel=new JLabel("Date:");
	panel2.add(datelabel);

	JTextField datetext=new JTextField(2);
	panel2.add(datetext);

	//MONTH-------------------------------------------
	JLabel mlabel=new JLabel("Month:");
	panel2.add(mlabel);	

	String months[]={"January","February","March","April","May","June","July","August","September","October","December"};

	final JComboBox<String> mtext=new JComboBox<>(months);
	mtext.setSelectedIndex(0);
	panel2.add(mtext);

	//YEAR---------------------------------------------

	JLabel ylabel=new JLabel("Year:");
	panel2.add(ylabel);

	JTextField ytext=new JTextField(4);
	panel2.add(ytext);

//CALCUATE BUTTON-----------------------------------------

	JPanel panel3=new JPanel();
	JButton getdetailsbutton=new JButton("Calculate");

//INPUT TO OUTPUT----------------------------------------
	String s[]={"0","null","0"};

	//Upon Clicking
	getdetailsbutton.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			//getting values from gui
			s[0]=datetext.getText();
			s[1]=String.valueOf(mtext.getSelectedItem());
			s[2]=ytext.getText();

			//creating object and calculating
			calc ans=new calc(s[0],s[1],s[2]);
			ans.calculate();
			
			//Printing
	JOptionPane.showMessageDialog(jf,("You are "+ans.dy+"Years,"+ans.dm+"Months,"+ans.dd+"Days old"),"Answer",JOptionPane.PLAIN_MESSAGE);
		}
		});//ActionListener over
	panel3.add(getdetailsbutton);

	jf.add(panel1,BorderLayout.NORTH);	
	jf.add(panel2,BorderLayout.CENTER);
	jf.add(panel3,BorderLayout.SOUTH);
	//Packing and visibilty
	jf.pack();
	jf.setVisible(true);
	
	//To ensure that multiple times values can be entered
	while(true){
		System.out.print("");
	}
	


}//main closure

}//AgeFromBday class closure
		
