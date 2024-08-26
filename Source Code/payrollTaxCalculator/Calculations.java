package payrollTaxCalculator;

public class Calculations {

	//calculate SUTA from user input on percentage
	public double procSuta(double sutaPercent,double salary) {
		
		double percent = sutaPercent;
		
		percent = percent/100;
		
		double suta = salary * percent;
		return suta;
		
	}
	// calculating FUTA from salary
	public double procFuta(double futaCredit, double salary,double hWage) {
		
		double futaPer = 6;
		double futa = 0.0;
		
		futaPer = futaPer - futaCredit;
		
		futaPer = futaPer/100;
		
		if(salary <= 0.00) {
			
			if(hWage < 7000) {
				futa = hWage * futaPer;
				
			}
			
			else { futa = 7000 * futaPer;}
			
			return futa;
		}
		
		else {
			
			if(salary < 7000) {
				futa = salary * futaPer;
				
			}
			
			else { futa = 7000 * futaPer;}
			
			return futa;
			}
	}
	
public double procFit(String fit,double salary) {
		
		String fPer = fit;
		double fTax = 0.0;
		
		if(fPer== "7.65%") {
			
			fTax = .0765 * salary;
				
		}
		else { fTax= .153 * salary;}
		
		return fTax;
		
	}
	
	//calculating state income tax
	public double procSit(double sitPer, double salary) {
		double per = sitPer/100;
		double sit = per * salary;
		return sit;
	}

	// calculating  OASDI tax
	public double procOASDI(double salary) {
		
		double percent = 6.2/100;
		double socTax = percent * salary;
		return socTax;
	}
	
	//calculating medicare tax
	public double procMedi(double salary) {
		
		double percent = 1.45/100;
		double medTax = percent * salary;
		return medTax;
	}
	
	public double procGrossPay(String spf,double salary,double hour,double hRate,double over,double oRate) {
		
		String payFreq = spf;
		double grossPay = 0.0;
		double hPay;
		if(salary == 0.00) {
			hPay = (hour*hRate) + (over * oRate);
			return hPay;
			
			}
		else {
			if(payFreq== "Bi-weekly") {
				
				grossPay = salary/26;
					
				}
			else { grossPay = salary/12;}
			
			return grossPay;
		}
	
		
	}
	
	public double procNPay(double grossPay, double OASDI, double medi, double fit, double sit) {
		
		double nPay;	
		
		nPay = grossPay - (OASDI + medi + fit + sit); 
		
		return nPay;
	}
}
