package model;

public class PossibleAttendees {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String gender;
	private String country;
	private String image;
	private String birthday;
	private PossibleAttendees right;
	private PossibleAttendees left;
	public PossibleAttendees(int i, String f, String l, String e, String g, String c, String im, String b, PossibleAttendees r, PossibleAttendees le) {
		id = i; 
		first_name = f;
		last_name = l;
		email = e;
		gender = g;
		country = c;
		image = im; 
		birthday = b;
		right = r; 
		left = le;
	}
	public int getID() {
		return id;
	}
	public String getFirstName() {
		return first_name;
	}
	public String getLastName() {
		return last_name;
	}
	public String getEmail() {
		return email;
	}
	public String getGender() {
		return gender;
	}
	public String getCountry() {
		return country;
	}
	public String getImage() {
		return image;
	}
	public String getBirthday() {
		return birthday;
	}
	public PossibleAttendees getRight() {
		return right;
	}
	public PossibleAttendees getLeft() {
		return left;
	}
	public void setRight(PossibleAttendees r) {
		right = r;
	}
	public void setLeft(PossibleAttendees l) {
		left = l;
	}
	public String getMessage() {
		String message = ""; 
		message += ("ID: " + id + " ,name: " +first_name + " " +last_name + " ,email: " +email + " ,gender: " +gender + " , country: " +country + " ,image: " + image + " ,Birthday: " + birthday + "\n");
		return message;
	}

}
