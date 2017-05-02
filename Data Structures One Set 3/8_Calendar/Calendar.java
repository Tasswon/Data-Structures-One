/** Name: Joseph Tassone
 *  Description: Creates a calendar date, which can be manipulated. 
 */


public class Calendar {
	
	private int month;
	private int day;
	private int year;
	
	//Default constructor, throws exception if the date is formatted incorrectly
	public Calendar(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
		
		if(month > 12 || month < 1) {
			throw new BadDateException("Invalid month!");
		}
		
		if(day < 1) {
			throw new BadDateException("Invalid day!");
		}
		
		if(day > 31) {
			throw new BadDateException("Invalid day!");
		}
		
		if(day >= 29) {
			if((month == 2 && isLeapYear(year) == false) || (month == 2 && day > 29)) {
				throw new BadDateException("Invalid day!");
			}
		}
		
		if(day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
			throw new BadDateException("Invalid day!");
		}
	}
	
	//Advances one day
	public void advanceDay() {

		this.day = this.day + 1;

		if(this.day == 29 || this.day == 30) {
			if(this.month == 2) {
				if(isLeapYear(year) == false) {
					this.day = 1;
					this.month = month + 1;
				}
				if(this.day == 30) {
					this.day = 1;
					this.month = month + 1;
				}
			}
		}
		
		else if(this.day == 31) {
			if(month == 4 || month == 6 || month == 9 || month == 11) {
				this.day = 1;
				this.month = month + 1;
			}
		}
		else if(this.day == 32) {
			if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if(this.month == 12) {
					this.day = 1;
					this.month = 1;
					this.year = this.year + 1;
				}
				else {
					this.day = 1;
					this.month = month + 1;
				}
			}
		}
	}

	//Advances one month
	public void advanceMonth() {
		this.month = this.month + 1;

		if(month == 13) {
			this.month = 1;
			this.year = this.year + 1;
		}
	}

	//Advances one year
	public void advanceYear() {
		this.year = this.year + 1;
	}

	//Reduces by one day
	public void reduceDay() {

		this.day = this.day - 1;

		if(this.day == 0) {
			if(this.month == 3) {
				if(isLeapYear(year) == false) {
					this.day = 28;
					this.month = month - 1;
				}
				else {
					this.day = 29;
					this.month = month - 1;
				}
			}

			else if(month == 5 || month == 7 || month == 10 || month == 12) {
				this.day = 30;
				this.month = month - 1;
			}

			else if(month == 1 || month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11) {
				if(this.month == 1) {
					this.day = 31;
					this.month = 12;
					this.year = this.year - 1;
				}
				else {
					this.day = 31;
					this.month = month - 1;
				}
			}
		}
	}


	//Reduces one month
	public void reduceMonth() {
		this.month = this.month - 1;

		if(month == -1) {
			this.month = 12;
			this.year = this.year - 1;
		}
	}

	//Reduces one year
	public void reduceYear() {
		this.year = this.year - 1;
	}
	
	//Prints the date, with the month in words
	public String displayWords() {
		return "Date: " + dayOfWeek(month, day, year) + ", " + monthName(this.month) + ", " + this.day + " " + this.year;
	}
	
	//Prints the date in numbers
	public String displayNumbers() {
		return "Date: " + this.month + " / " + this.day + " / " + this.year;
	}
	
	//Takes in a number and outputs a month name
	private String monthName(int month) {
		
		String[] months = {"January", "February", "March", "April", "May", "June",
				"July", "August", "September", "October", "November", "December"};
		
		return months[month - 1];
	}

	//Takes in a year and checks if it's a leap year
	private boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}
	
	private String dayOfWeek(int month, int day, int year) {

		if (month == 1 ) {
			month = 13;
			year = year - 1;
		}

		if (month == 2) {
			month = 14;
			year = year - 1;
		}
		
		//Uses Zeller's Algorithm to calculate the day of the week
		String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		int dayOfTheWeek = (int) (((day + (((month + 1) * 26) / 10) + year + (year / 4) + (6 * (year / 100)) + (year / 400)) - 1) % 7);

		return days[dayOfTheWeek];
	}
}
