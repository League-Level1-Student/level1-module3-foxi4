package _05_netflix;

public class Netflix {

	  public static void main(String[] args) throws Exception {
		  Movie movie = new Movie("very intersting movie title", 5);
		 movie.getRating();
		 movie.getTicketPrice();
		System.out.println(movie.getTitle());
		 System.out.println(movie.getRating());
		 System.out.println(movie.getTicketPrice());
		//okay..
	}

}
