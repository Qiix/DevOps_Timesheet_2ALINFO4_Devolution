package tn.esprit.spring.entities;

import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class MissionDTO {

private int idDTO;
	
	private String nameDTO;
	
	private String descriptionDTO;
	
	private int departementIdDTO;
	
	private  List<Timesheet> timesheetsDTO;
	
	public MissionDTO() {
		super();
	}

	

	public int getIdDTO() {
		return idDTO;
	}

	public void setIdDTO(int idDTO) {
		this.idDTO = idDTO;
	}

	public String getNameDTO() {
		return nameDTO;
	}

	public void setNameDTO(String nameDTO) {
		this.nameDTO = nameDTO;
	}

	public String getDescriptionDTO() {
		return descriptionDTO;
	}

	public void setDescriptionDTO(String descriptionDTO) {
		this.descriptionDTO = descriptionDTO;
	}

	public int getDepartementIdDTO() {
		return departementIdDTO;
	}

	public void setDepartementIdDTO(int departementIdDTO) {
		this.departementIdDTO = departementIdDTO;
	}

	public List<Timesheet> getTimesheetsDTO() {
		return timesheetsDTO;
	}

	public void setTimesheets(List<Timesheet> timesheetsDTO) {
		this.timesheetsDTO = timesheetsDTO;
	}
}
