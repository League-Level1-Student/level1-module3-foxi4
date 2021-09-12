package _05_netflix;

public class Netflix {

	  public static void main(String[] args) throws Exception {
		  Movie movie = new Movie("CATS", 1);
		  Movie movie2 = new Movie("Frozen 2", 2);
		  Movie movie3 = new Movie("Demon Slayer: The Movie", 4);
		  Movie movie4 = new Movie("Cruella", 3);
		  Movie movie5 = new Movie("Violet Evergarden: The Movie", 5);
		  
			 System.out.println("The movie title is: " + movie.getTitle());
			 System.out.println(movie.getTicketPrice());
			 
		 NetflixQueue queue = new NetflixQueue();
		queue.addMovie(movie);
		 queue.addMovie(movie2);
		 queue.addMovie(movie3);
		queue.addMovie(movie4);
		 queue.addMovie(movie5);
		queue.printMovies();

	
		 System.out.println("The best movie is... " + queue.getBestMovie());
		 System.out.println("The second best movie is... " + queue.getMovie(1));
		 

	}

}
