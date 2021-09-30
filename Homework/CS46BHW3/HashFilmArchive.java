package movies;

import java.util.ArrayList;
import java.util.HashSet;

public class HashFilmArchive extends HashSet<Movie> implements FilmArchive{
	
	public ArrayList<Movie> getSorted() {
		
		HashSet<Movie> hashMovies = new HashSet<Movie>(this);
		ArrayList<Movie> ArrayMovies = new ArrayList<Movie>(hashMovies);
		return ArrayMovies;
	}
	
	public static void main(String[] args)
	{
		HashFilmArchive archive = new HashFilmArchive();
		for (Movie m: Movie.getTestMovies())
			archive.add(m);
		for (Movie m: archive)
			System.out.println(m); 
		System.out.println("**************");
		for (Movie m: archive.getSorted())
			System.out.println(m);
      }
}
