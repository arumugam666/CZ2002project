package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.AdminChangeStatus;
import model.Cineplex;
import model.master;
import model.movie;
import model.show;

public class CreateUpdateRemoveCinemaShowtimes {
	
private static master Master;
	
	
	public CreateUpdateRemoveCinemaShowtimes(master m){
		Master = m;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<movie> movies=new ArrayList<movie>();
		int i;
		
		ArrayList<Cineplex> Cineplexes_1 =new ArrayList<Cineplex>();
		
		Cineplexes_1 = Master.getCineplexes();
        
        for(i=0; i< Cineplexes_1.size();i++)
        	System.out.printf("%d) "+Cineplexes_1.get(i).getCineplexName()+"\n",i+1);
        
        System.out.println("");
        
        System.out.print("Select a Cineplex: ");
        int choice_1 = sc.nextInt();
        
        System.out.print("Select a Screen (1 / 2 / 3): ");
        int cinema_id = sc.nextInt();
       
        System.out.print("Is the Movie 3D? (true/false): ");
        boolean threed = sc.nextBoolean();
        
        System.out.print("Enter the Date Time:  ");
        String s_1 = sc.nextLine(); 
		
        System.out.println("");
        
        movies = Master.getMovies();
		
        movie mov;
        show s;
        System.out.println("-- All Movies --");
        
        for(i=0; i< movies.size();i++)
        	System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
        
        System.out.println("");
        
        System.out.print("Please select a Movie to be added: ");
        int mov_num = sc.nextInt();
        
        movie m = movies.get(mov_num-1);
        
        s = m.createShowListing(s_1, cinema_id-1, choice_1-1, threed);
        
        Cineplexes_1.get(choice_1-1).getCinemaList().get(cinema_id-1).addShow(s);
        
        Master.setCineplexes(Cineplexes_1);
        
        
        
        //delete
        
        movies = Master.getMovies();
        int selection;
        int choice;
        System.out.println("");
        System.out.println("-- All Movies --");
        for(i=0; i< movies.size();i++)
        	System.out.printf("%d) "+movies.get(i).getMovieName()+"\n",i+1);
        
        do {	System.out.print("\n"
                + "Please make a selection:\n"
                + " 1) Select  to delete show\n"
                + " 2) Back\n");
                selection = sc.nextInt();
                
                if (selection == 3) {
                	System.out.println("");
                	System.err.print("Invalid Input, Please Try Again!"); 
                	System.out.println("");
                }
                
                if (selection == 1) {
                	System.out.print("Please select a Movie Index to list its details and shows: ");
                	selection = sc.nextInt();
                	if (selection-1 > movies.size()) {
                		System.out.println("");
                		System.err.println("Please enter a valid movie number!");
                		continue;
                	}
                	
                	System.out.println("");
                	mov = movies.get(selection-1);
					System.out.println(mov.getMovieName());
					System.out.println(mov.getDirectorName());
					String [] reviews = mov.getReviews();
					for(int x =0;x<reviews.length;x++) 
						System.out.printf("%s ",reviews[x]);
					
					System.out.printf("\n");
					double [] ratings = mov.getAllRatings();
					for(int x =0;x<ratings.length;x++) 
						System.out.printf("%f ",ratings[x]);
					System.out.printf("\n");

					
					System.out.println(mov.getShowingStatus());
					System.out.println(mov.getSynopsis());
					String[] Cast = mov.getCast();
					for(int x =0;x<Cast.length;x++) 
						System.out.printf("%s ",Cast[x]);
					System.out.printf("\n");

					ArrayList<show> temp = mov.getShows();
					
					for (int k =0 ;k<temp.size();k++) {
						s = temp.get(k);
						System.out.printf("\n\nShow %d:\n",k+1);
						System.out.println(s.getDateTime());
						System.out.printf("CineplexID: %d\n",s.getCineplexID());
						System.out.printf("CinemaID: %d\n",s.getScreenNum());
						s.printSeats();
					}
					System.out.println("Please input the show number to be removed");
					choice =sc.nextInt();
					choice --;
					mov.deleteShow(Master, choice);
                }
        } while(selection!= 2);
        
	}


}
