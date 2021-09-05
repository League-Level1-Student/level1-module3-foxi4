package _05_netflix;

public class Netflix {

	  public static void main(String[] args) throws Exception {
		  Movie movie = new Movie("Luca", 4);
		  Movie movie2 = new Movie("Cinderella", 3);
		  Movie movie3 = new Movie("Demon Slayer: The Movie", 5);
		  Movie movie4 = new Movie("Cruella", 5);
		  Movie movie5 = new Movie("Violet Everfarden: The Movie", 5);
		  
		 movie.getRating();
		 movie.getTicketPrice();

		 //instantiate netflxi queue
		System.out.println("The movie title is: " + movie.getTitle());
		 System.out.println("The rating of " + movie.getTitle() + " is " + movie.getRating());
		 System.out.println(movie.getTicketPrice());
		 System.out.println("The best movie is... " + movie5);
		 System.out.println("The second movie is... " + movie3);
System.out.println(movie2);
System.out.println(movie4);

		
	}

}
