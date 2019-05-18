package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Federation {
	private PossibleAttendees root;
	private Participants first;
	private final static String PATH_FILE = "data/MOCK_DATA (1).csv";
	public Federation(PossibleAttendees r) {
		root = r;
		
	}
	public void loadInformation() throws IOException {
		File archive = new File(PATH_FILE);
		FileReader reader = new FileReader(archive);
		BufferedReader br = new BufferedReader(reader);
		String ln = br.readLine();
		while(ln != null) {
			String[] parts = ln.split(",");
			int id = Integer.parseInt(parts[0]);
			String first_name = parts[1];
			String last_name = parts[2];
			String email = parts[3];
			String gender = parts[4];
		    String country = parts[5];
			String image = parts[6];
			String birthday = parts[7];
			PossibleAttendees a = new PossibleAttendees(id, first_name, last_name, email, gender, country, image, birthday, null, null);
			if(root == null) {
				root = a;
			}
			else {
				PossibleAttendees current = root;
				boolean added = false;
				while(!added) {
					if(a.getID()>root.getID()) {
						if(current.getRight() == null) {
							current.setRight(a);
							added = true;
						}else {
							current = current.getRight();
						}
					}else {
						if(current.getLeft()== null) {
							current.setLeft(a);
							added = true;
						}else {
							current = current.getLeft();
						}
					}
				}
			}
			ln = br.readLine();
		}
		reader.close();
		br.close();
		
	}
	public Participants getFirst() {
		return first;
	}
	public void selectEnrolled() {
		if(root == null) {
			first = null;
		}else {
			List<Integer> numbers = new ArrayList<>(1000);
			for (int i=1;i<1001;i++){
			   numbers.add(i);
			}
			while ((numbers.size() - 500) >1){
				Random random = new Random();
				int number = random.nextInt(numbers.size());
				PossibleAttendees current = root;
				while(current != null) {
					if(number == current.getID()) {
						Participants n = new Participants(current.getID(), current.getFirstName(), current.getLastName(), current.getEmail(), current.getGender(),current.getCountry(), current.getImage(), current.getBirthday());
						if(first == null) {
							first = n;
							current = null;
						}else{
							Participants aux = first;
							while(aux.getNext()!= null) {
								aux = aux.getNext();
							}
							aux.setNext(n);
							n.setPrev(aux);
							current = null;
						}
					}else if(number>current.getID()){
						current = current.getRight();
					}else {
					    current = current.getLeft();
				    }
			     }
				numbers.remove(number);
			}
		}
	}
	public PossibleAttendees searchSpectators(int id) {
		PossibleAttendees a = null;
		PossibleAttendees current = root;
		while(current != null) {
			if(id == current.getID()) {
				a = current;
				current = null;
			}else if(id >= current.getID()) {
				current = current.getRight();
			}else {
				current = current.getLeft();
			}
		}
		return a;
	}
	public Participants searchParticipants(int id) {
		Participants a = null;
		Participants current = first;
		while(current != null) {
			if(id == current.getID()) {
				a = current;
				current = null;
			}
			else {
				current = current.getNext();
			}
		}
		return a;
	}
		
	

}
