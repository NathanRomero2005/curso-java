package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comment c1 = new Comment("Have a nice trip!");
		Comment c2 = new Comment("WOW! That's awesome!");
		
		Post p1 = new Post(sdf.parse("21/06/2018 13:05:44"), 
						   "Traveling to New Zeland", 
						   "Gonna visit this wonderful contry!", 
						   12);
		
		p1.addComment(c1);
		p1.addComment(c2);
		
		sc.close();

	}

}
