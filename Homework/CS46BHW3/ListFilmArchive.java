package movies;

import java.util.ArrayList; 
import java.util.TreeSet;

public class ListFilmArchive extends ArrayList<Movie> implements FilmArchive {
	
	@Override
	public boolean add(Movie a) {
		for (Movie listMovies: this) {
			if (listMovies.equals(a))
				return false;
		}
		super.add(a);
		
		return true;
	}
	
	public ArrayList<Movie> getSorted() {
		TreeSet<Movie> treeMovies = new TreeSet<Movie>(this);
		ArrayList<Movie> arrayMovies = new ArrayList<Movie>(treeMovies);
		return arrayMovies;
	}
	
	public static void main(String[] args)
	{
		ListFilmArchive archive = new ListFilmArchive();
		for (Movie m: Movie.getTestMovies())
			archive.add(m);
		for (Movie m: archive)
			System.out.println(m); 
		System.out.println("**************");
		for (Movie m: archive.getSorted())
			System.out.println(m);
      }
}
