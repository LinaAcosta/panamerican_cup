package model;

public class Participants{
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String gender;
	private String country;
	private String image;
	private String birthday;
	private Participants next;
	private Participants prev;
	public Participants(int i, String f, String l, String e, String g, String c, String im, String b) {
		id = i; 
		first_name = f;
		last_name = l;
		email = e;
		gender = g;
		country = c;
		image = im; 
		birthday = b;
	}
	public Participants getNext() {
		return next;
	}
	public Participants getPrev() {
		return prev;
	}
	public void setNext(Participants n) {
		next = n;
	}
	public void setPrev(Participants p) {
		prev = p;
	}
	public int getID() {
		return id;
	}
	public String getImage() {
		return image;
	}
	public String getCountry() {
		return country;
	}
	public String getMessage() {
		String message = ""; 
		message += ("\n ID: " + id + "\n Name: " +first_name + " " +last_name + "\n Email: " +email + "\n Gender: " +gender + "\n Country: " +country  + "\n Birthday: " + birthday + "\n");
		return message;
	}

}
