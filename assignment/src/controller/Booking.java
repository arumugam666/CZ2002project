package controller;

import model.show;

public class Booking{

    //the person who has made the booking
	private int custID;
	
    private int bookingID;
    
    //movie object booked by the customer
    private String movieBooked;
    
    //Date of the Booking
    //private Date dateBooked;

    private int numseats;

    private String firstseat, lastseat;
    
    private show show;
    
    public Booking() {};

    public Booking(int custID, String movieBooked,int numseats, String firstseat, String lastseat, show show){
        this.custID = custID;
    	
        //assign according to number of bookings
        this.bookingID = 
   
        this.movieBooked = movieBooked;
        
        
        this.numseats = numseats;
        
        //check if last-first = num?
        this.firstseat = firstseat;
        this.lastseat = lastseat;
        
        this.setShow(show);
    }
    
    public String getmovieBooked() {
    	return movieBooked;
    }
    
    public int getbookingID() {
    	return bookingID;
    }
    
    public int getnumseats() {
    	return numseats;
    }
    
    public String getfirstseat() {
    	return firstseat;
    }
    
    
    
    public void setmovieBooked(String movieBooked) {
    	this.movieBooked = movieBooked;
    }
    
    public void setbookingID(int bookingID ) {
    	this.bookingID = bookingID;
    }
    
    public void setnumseats(int numseats) {
    	this.numseats = numseats;
    }
    
    public void setfirstseat(String firstseat) {
    	this.firstseat = firstseat;
    }
    

	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}

	public show getShow() {
		return show;
	}

	public void setShow(show show) {
		this.show = show;
	}
}

