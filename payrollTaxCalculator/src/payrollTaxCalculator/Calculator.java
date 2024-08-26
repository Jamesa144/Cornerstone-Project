package payrollTaxCalculator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Calculator{
	
	//import of classes
	Workbook excelFile = new Workbook();
	Calculations procVari = new Calculations();
	

	//variables
	private String fName;
	private String lName;
	private double salary;
	private double hour;
	private double hRate;
	private double oTimeRate;
	private double oTime;
	private String mStatus;
	private String spf;
	private double pYtd;
	private double uDues;
	private double sutaPercent;
	private double futaCredit;
	private String fit;
	private double sit;
	private double gPay;
	
	 private String[] status = {" ","single", "Joint"};
	 private String[] payFreq = {" ","Bi-weekly", "Monthly"};
	 private String[] fTax = {" ","7.65%", "15.3%"};

	private String fileNam;
	private String drive;

	// setter and getters for the variables
	public void setFirstName(JTextField text1){
		
		String fName = text1.getText();
		this.fName = fName;
	}
	
	public String getFirstName(){
		
		return fName;
		
	}
	
	public void setLastName(JTextField text2){
		
		String lName = text2.getText();
		this.lName = lName;
	}
	public String getLastName(){
		
		return lName;
		
	}
	
	public void setSalary(JTextField text3){
		
		String strSalary = text3.getText();
		double salary = Double.parseDouble(strSalary);
		this.salary = salary;
	}
	
	public double getSalary(){
		
		return salary;
		
	}
	
	public void setHour(JTextField text4){
		
		String strHour = text4.getText();
		double hour = Double.parseDouble(strHour);
		this.hour = hour;
	}
	
	public double getHour(){
		
		return hour;
		
	}
	
	public void setHRate(JTextField text5) {
		
		String strHRate = text5.getText();
		double hRate = Double.parseDouble(strHRate);
		this.hRate = hRate;
		
	}
	
	public double getHRate() {
		
		return hRate;
	}
	
	public void setOTime(JTextField text6) {
		
		String strOtime = text6.getText();
		double oTime = Double.parseDouble(strOtime);
		this.oTime = oTime;
	}
	
	public double getOTime() {
		
		return oTime;
	}
	
	public void setOTimeRate(JTextField text7) {
		
		String strOTimeRate = text7.getText();
		double oTimeRate = Double.parseDouble(strOTimeRate);
		this.oTimeRate = oTimeRate;
		
	}
	
	public double getOTimeRate() {
		
		return oTimeRate;
	}
	
	public void setMStatus(JComboBox<String> text8) {
		
		String mStatus = text8.getSelectedItem().toString();
		
		this.mStatus = mStatus;
	}
	
	public String getMStatus() {
		
		return mStatus;
	}
	
	public void setSutaPercent(JTextField text9) {
		
		String strSuta = text9.getText();
		double suta = Double.parseDouble(strSuta);
		this.sutaPercent = suta;
		
	}
	
	public double getSutaPercent() {
		
		return sutaPercent;
	}
	
	public void setFutaCredit(JTextField text10) {
		
		String strFuta = text10.getText();
		double futa = Double.parseDouble(strFuta);
		this.futaCredit = futa;
	}
	
	public double getFutaCredit() {
		
		return futaCredit;
	}
	
	public void setFit(JComboBox<String> text11) {
		
		String fit = text11.getSelectedItem().toString();
		
		this.fit = fit;
	}
	
	public String getFit() {
		
		return fit;
	}
	
	public void setSit(JTextField text12) {
		
		String strSit = text12.getText();
		double sit = Double.parseDouble(strSit);
		this.sit = sit;
	}
	
	public double getSit() {
		
		return sit;
	}
	
	
	public void setUDues(JTextField text13) {
		
		String strUDues = text13.getText();
		double uDues = Double.parseDouble(strUDues);
		this.uDues = uDues;
		
	}
	
	public double getUDues() {
		
		return uDues;
	}
	
	public void setPriorYtd(JTextField text14) {
		
		String strPriorYtd = text14.getText();
		double pYtd = Double.parseDouble(strPriorYtd);
		this.pYtd = pYtd;
		
	}
	
	public double getPriorYtd() {
		
		return pYtd;
	}
	
	public void setPayFreq(JComboBox<String> text15) {
		
		String spf = text15.getSelectedItem().toString();
		
		this.spf = spf;
	}
	
	public String getPayFreq() {
		
		return spf;
	}
	

	
	public void setGrossPay(String spf, double salary,double hour,double hRate,double oTime,double oTimeRate) {
		
		double gPay = procVari.procGrossPay(spf, salary,hour,hRate,oTime,oTimeRate);
		this.gPay = gPay;
		
	}
	
	public double getGrossPay() {
		
		return gPay;
	}
	
	
	// holds variables to file name and where to save it
	
	public void setFileName(String f){
		
		this.fileNam = f;
	}
	
	public String getFileName(){
		
		return fileNam;
	}	
	
	public void setDrive(String d){
		
		this.drive = d;
	}
	
	public String getDrive(){
		
		return drive;
		
	}
	
	 void d(){
			
		 String d= JOptionPane.showInputDialog("Please enter which drive to save to(EX.C,D or F): ");
		 setDrive(d);
	 }	
	
	 void f(){
		
		 String f= JOptionPane.showInputDialog("Please enter File's name: ");
		 setFileName(f);
		 }


	// GUI of the calculator
	public void cal(){
	
		//use to move items on the frame
		SpringLayout layout = new SpringLayout();
		
		// window setup
		JFrame back = new JFrame("Payroll Tax Calculator");
		JPanel calcu = new JPanel();
		
		//submit button
		JButton submit = new JButton("Submit");
		submit.setBounds(50, 300,95, 30);
		
		//save button
		JButton save = new JButton("Save file and exit");
		save.setBounds(150, 300,150, 30);
		
		// labels for the text fields
		JLabel label1 = new JLabel("First Name: ");
		JLabel label2 = new JLabel("Last Name: ");
		JLabel label3 = new JLabel("Salary: ");
		JLabel label4 = new JLabel("Hours: ");
		JLabel label5 = new JLabel("Hour Rate: ");
		JLabel label6 = new JLabel("Overtime Hours: ");
		JLabel label7 = new JLabel("Overtime Rate: ");
		JLabel label8 = new JLabel("W-4 allowance: ");
		JLabel label9 = new JLabel("SUTA Percent: ");
		JLabel label10 = new JLabel("FUTA Tax Credit: ");
		JLabel label11 = new JLabel("<html><p>Federal Income : <br>Tax<p><html> ");
		JLabel label12 = new JLabel("<html><p>State Income Tax: <br>(percentage)<p><html>");
		JLabel label13 = new JLabel("Union Due: ");
		JLabel label14 = new JLabel("<html><p>Prior earning : <br>(ytd)<html><p>");
		JLabel label15 = new JLabel("<html><p>Salary Pay : <br> Frequemcy<p><htmal>");
		
		
		//text fields for user input
	    JTextField text1 = new JTextField(10);
	    JTextField text2 = new JTextField(10);
	    JTextField text3 = new JTextField(10);
	    JTextField text4 = new JTextField(10);
	    JTextField text5 = new JTextField(10);
	    JTextField text6 = new JTextField(10);
	    JTextField text7 = new JTextField(10);
	    JComboBox<String> text8 = new JComboBox<String>(status);
	    JTextField text9 = new JTextField(10);
	    JTextField text10 = new JTextField(10);
	    JComboBox<String> text11 = new JComboBox<String>(fTax);
	    JTextField text12 = new JTextField(10);
	    JTextField text13 = new JTextField(10);
	    JTextField text14 = new JTextField(10);
	    JComboBox<String> text15 = new JComboBox<String>(payFreq);
	    
	   
	
	    // shortcut to fields by pressing alt+'letter'
	    label1.setLabelFor(text1);
	    label1.setDisplayedMnemonic('F');
	    
	    label2.setLabelFor(text2);
	    label2.setDisplayedMnemonic('L');
	    
	    label3.setLabelFor(text3);
	    label3.setDisplayedMnemonic('S');
	    
	    label4.setLabelFor(text4);
	    label4.setDisplayedMnemonic('H');
	    
	    label5.setLabelFor(text5);
	    
	    label6.setLabelFor(text6);
	    
	    label7.setLabelFor(text7);
	    
	    label8.setLabelFor(text8);
	    
	    label9.setLabelFor(text9);
	    
	    label10.setLabelFor(text10);
	    
	    label11.setLabelFor(text11);
	    
	    label12.setLabelFor(text12);
	    
	    label13.setLabelFor(text13);
	    
	    label14.setLabelFor(text14);
	    
	    label15.setLabelFor(text15);
	    
	   // add the label and text field onto the frame
	    calcu.add(label1);  
	    calcu.add(text1);
	    
	    calcu.add(label2);
	    calcu.add(text2);
	    
	    calcu.add(label3);
	    calcu.add(text3);
	    
	    calcu.add(label4);
	    calcu.add(text4);
	    
	    calcu.add(label5);
	    calcu.add(text5);
	    
	    calcu.add(label6);
	    calcu.add(text6);
	    
	    calcu.add(label7);
	    calcu.add(text7);
	    
	    calcu.add(label8);
	    calcu.add(text8);
	    
	    calcu.add(label9);
	    calcu.add(text9);
	    
	    calcu.add(label10);
	    calcu.add(text10);
	    
	    calcu.add(label11);
	    calcu.add(text11);
	    
	    calcu.add(label12);
	    calcu.add(text12);
	    
	    calcu.add(label12);
	    calcu.add(text12);
	    
	    calcu.add(label13);
	    calcu.add(text13);
	    
	    calcu.add(label14);
	    calcu.add(text14);
	    
	    calcu.add(label15);
	    calcu.add(text15);
	    
	   
	    
	    //items placement on the frame
	    
		calcu.setLayout(layout);
		
		//labels
		layout.putConstraint(SpringLayout.WEST, label2,10,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label2,10,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label3,10,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label3,40,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label5,10,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label5,75,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label7,10,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label7,110,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label9,10,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label9,140,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label11,10,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label11,170,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label13,10,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label13,205,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label15,10,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label15,230,SpringLayout.NORTH, calcu);
		
		
		
		layout.putConstraint(SpringLayout.WEST, label1,250,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label1,10,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label4,250,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label4,40,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label6,250,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label6,75,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label8,250,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label8,110,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label10,250,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label10,140,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label12,250,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label12,170,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, label14,250,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, label14,205,SpringLayout.NORTH, calcu);
		
		
		
		//text fields
		layout.putConstraint(SpringLayout.WEST, text2,110,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text2,10,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text3,110,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text3,40,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text5,110,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text5,75,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text7,110,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text7,110,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text9,110,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text9,140,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text11,110,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text11,170,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text13,110,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text13,205,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text15,110,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text15,230,SpringLayout.NORTH, calcu);
		
		
		
		layout.putConstraint(SpringLayout.WEST, text1,355,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text1,10,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text4,355,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text4,40,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text6,355,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text6,75,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text8,355,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text8,110,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text10,355,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text10,140,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text12,355,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text12,170,SpringLayout.NORTH, calcu);
		
		layout.putConstraint(SpringLayout.WEST, text14,355,SpringLayout.WEST, calcu);
		layout.putConstraint(SpringLayout.NORTH, text14,205,SpringLayout.NORTH, calcu);
		
		//buttons
	    back.add(submit); 
	    back.add(save);
	    //pane
	    back.add(calcu);
	    //frame size
	    back.setSize(600, 400);
	    back.show();
	    
	
    
    //when user clicks on submit button it records the data entered in the text fields to variables

	 
    submit.addActionListener(new ActionListener(){
    	
		public void actionPerformed(ActionEvent a){
			
			Pattern fName = Pattern.compile("^\\D{1,30}$");
			Matcher fPattern = fName.matcher(text1.getText());
			boolean fFind = fPattern.find();
			
			Pattern lName = Pattern.compile("^\\D{1,30}$");
			Matcher lPattern = lName.matcher(text2.getText());
			boolean lFind = lPattern.find();
			
			Pattern sName = Pattern.compile("^\\d{1,10}\\.\\d{0,2}$");
			Matcher sPattern = sName.matcher(text3.getText());
			boolean sFind = sPattern.find();
			
			Pattern hName = Pattern.compile("^\\d{1,5}$");
			Matcher hPattern = hName.matcher(text4.getText());
			boolean hFind = hPattern.find();
			
			Pattern hrName = Pattern.compile("^\\d{1,10}\\.\\d{0,2}$");
			Matcher hrPattern = hrName.matcher(text5.getText());
			boolean hrFind = hrPattern.find();
			
			Pattern oName = Pattern.compile("^\\d{1,5}$");
			Matcher oPattern = oName.matcher(text6.getText());
			boolean oFind = oPattern.find();
			
			Pattern orName = Pattern.compile("^\\d{1,10}\\.\\d{0,2}$");
			Matcher orPattern = orName.matcher(text7.getText());
			boolean orFind = orPattern.find();
			
			Pattern suName = Pattern.compile("^\\d{1,3}\\.\\d{0,4}$");
			Matcher suPattern = suName.matcher(text9.getText());
			boolean suFind = suPattern.find();
			
			Pattern fuName = Pattern.compile("^\\d{1}\\.\\d{0,2}$");
			Matcher fuPattern = fuName.matcher(text10.getText());
			boolean fuFind = fuPattern.find();
			
			Pattern sitName = Pattern.compile("^\\d{1,3}\\.\\d{0,2}$");
			Matcher sitPattern = sitName.matcher(text12.getText());
			boolean sitFind = sitPattern.find();
			
			Pattern uName = Pattern.compile("^\\d{1,10}\\.\\d{0,2}$");
			Matcher uPattern = uName.matcher(text13.getText());
			boolean uFind = uPattern.find();
			
			Pattern ytdName = Pattern.compile("^\\d{1,10}\\.\\d{0,2}$");
			Matcher ytdPattern = ytdName.matcher(text14.getText());
			boolean ytdFind = ytdPattern.find();
			
			if (fFind == true && lFind == true && sFind == true && hFind == true
				&& hrFind == true && oFind == true && orFind == true && suFind == true
				&& fuFind == true && sitFind == true && uFind == true && ytdFind == true )
				{
					// gathering user input into variables
				    
				    setFirstName(text1);
				    setLastName(text2);
				    setSalary(text3);
				    setHour(text4);
				    setHRate(text5);
				    setOTime(text6);
				    setOTimeRate(text7);
				    setMStatus(text8);
				    setSutaPercent(text9);
				    setFutaCredit(text10);
				    setFit(text11);
				    setSit(text12);
				    setUDues(text13);
				    setPriorYtd(text14);
				    setPayFreq(text15);
				    setGrossPay(getPayFreq(), getSalary(), getHour(), getHRate(), getOTime(), getOTimeRate());
				    
				}
			else 
				{
		           
				 JOptionPane.showMessageDialog (null, "Error:  please check all fields for valid entries.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		
		}
	});
    
    save.addActionListener(new ActionListener(){
    	
		public void actionPerformed(ActionEvent e){
			
			d();
			f();
			
			//creates the excel sheet with user input data
			excelFile.createFile( getFirstName(), 
								 getLastName(), 
								 getSalary(), 
								 getHour(),
								 getHRate(),
								 getOTime(),
								 getOTimeRate(),
								 getMStatus(),
								 procVari.procSuta(getSutaPercent(), getGrossPay()),
								 procVari.procFuta(getFutaCredit(),getSalary(),getGrossPay()),
								 procVari.procFit(getFit(), getGrossPay()),
								 procVari.procSit(getSit(),  getGrossPay()),
								 procVari.procOASDI( getGrossPay()),
								 procVari.procMedi( getGrossPay()),
								 getGrossPay(),
								 procVari.procNPay( getGrossPay(),procVari.procOASDI( getGrossPay()),
								 procVari.procMedi( getGrossPay()),procVari.procFit(getFit(), getGrossPay()),
								 procVari.procSit(getSit(),getGrossPay())),
								 getUDues(),
								 getPayFreq(),
								 getPriorYtd(),
								 getDrive(), 
								 getFileName());
			back.dispose();
		}
	});
   
    // closes program when users clicks on the x
    back.addWindowListener(new WindowAdapter() {
    	
        public void windowClosing(WindowEvent e) {
            back.dispose();
        }
    });
    	
	
	}
	
} 
