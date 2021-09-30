package movies;

import java.util.ArrayList;
import java.util.TreeSet; 

public class TreeFilmArchive extends TreeSet<Movie> implements FilmArchive{
	
	public ArrayList<Movie> getSorted(){
		ArrayList<Movie> arrayMovies = new ArrayList<Movie>(this);
		return arrayMovies;
	}
	
	public static void main(String[] args)
	{
		TreeFilmArchive archive = new TreeFilmArchive();
		for (Movie m: Movie.getTestMovies())
			archive.add(m);
		for (Movie m: archive)
			System.out.println(m); 
		System.out.println("**************");
		for (Movie m: archive.getSorted())
			System.out.println(m);
      }
}
