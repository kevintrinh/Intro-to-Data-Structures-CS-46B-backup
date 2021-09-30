package movies;

public class Movie implements Comparable<Movie> {
	private String title;
	private int year;
	
	public Movie (String title, int year) {
		this.title = title;
		this.year = year;
	}
	@Override
	public int compareTo(Movie that) {
		if (this.title.compareTo(that.title) == 0){
				return Integer.compare(this.year, that.year);
			}
		else 
			return this.title.compareTo(that.title);
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public int getYear() {
		return this.year;
	}
	@Override
	public boolean equals(Object x) {
		Movie that = (Movie)x;
		return this.compareTo(that) == 0;
	}
	@Override
	public String toString() {
		return ("Movie " + getTitle() + " (" + getYear() + ")");
	}
	
	public static Movie[] getTestMovies() {
		Movie[] movies = new Movie[10];
		
		Movie movie0 = new Movie("The Thomas Crown Affair", 1968);
		Movie movie1 = new Movie("The Thomas Crown Affair", 1999);
		Movie movie2 = new Movie("The Martian", 2015);
		Movie movie3 = new Movie("Bridge of Spies", 2015);
		Movie movie4 = new Movie("Mulan", 2020);
		Movie movie5 = new Movie("Fireworks", 2017);
		Movie movie6 = new Movie("Weathering with you", 2019);
		Movie movie7 = new Movie("Avatar", 2009);
		Movie movie8 = new Movie("Avenger: Endgame", 2019);
		Movie movie9 = new Movie("Your Name", 2016);
		
		movies[0] = movie0;
		movies[1] = movie1;
		movies[2] = movie2;
		movies[3] = movie3;
		movies[4] = movie4;
		movies[5] = movie5;
		movies[6] = movie6;
		movies[7] = movie7;
		movies[8] = movie8;
		movies[9] = movie9;
		
		return movies;
	}
	@Override
	public int hashCode() {
		return title.hashCode() + year;
      }
}