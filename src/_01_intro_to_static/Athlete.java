package _01_intro_to_static;
//LISTENING TO MUSIC RNn

	public class Athlete {
	    static int nextBibNumber = 4;
	    static String raceLocation = "Chicago";
	    static String raceStartTime = "9.00am";
	    String name;
	    int speed;
	    int bibNumber;

	    Athlete (String name, int speed){
	        this.name = name;
	        this.speed = speed;
	        this.bibNumber = nextBibNumber;
	        nextBibNumber++;
	    }

	    public static void main(String[] args) {
	    	Athlete one = new Athlete("Bob", 20);
	    	Athlete two = new Athlete("Joe", 19);
	    	System.out.println("The race is in " + Athlete.raceLocation);
	    	System.out.println("The race starts at " + Athlete.raceStartTime);
	    	System.out.println("The first contestant's name is " + one.name);
	    	System.out.println("His bib number is: " + one.bibNumber);
	    	System.out.println("The second contestant's name is " + two.name);
	    	System.out.println("His bib number is: " + two.bibNumber);
	        //create two athletes
	        //print their names, bibNumbers, and the location of their race. 
	    }
	}


