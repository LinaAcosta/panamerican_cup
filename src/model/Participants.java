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
	public String getMessage() {
		String message = ""; 
		message += ("ID: " + id + " ,name: " +first_name + " " +last_name + " ,email: " +email + " ,gender: " +gender + " , country: " +country + " ,image: " + image + " ,Birthday: " + birthday + "\n");
		return message;
	}

}
