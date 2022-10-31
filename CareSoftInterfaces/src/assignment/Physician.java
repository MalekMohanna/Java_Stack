package assignment;

import java.sql.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {
	
//... imports class definition...
    
	// TO DO: Constructor that takes an ID
    public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	// Inside class:    
    private ArrayList<String> patientNotes;
	
    
    
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

    
    // TO DO: Implement HIPAACompliantUser!
    
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
//		 1000 and 9999 
		
		String pinString = Integer.toString(pin); 
		if (pinString.length() == 4) {
			this.setPin(pin);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		 if (this.id == confirmedAuthID) {
			 return true;
		 }
		
		return false;
	}



	// TO DO: Setters & Getters
	
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}



	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
	

}
