package com.aleyna.notebook_app.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "user_notes")
public class NotesModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "NOTE", length = 300)
	private String userPassword;
	
	@Column(name="CREATION_TIME")
	private LocalDate creationTime;
	
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

	public long getId() {
		return Id;
	}

	public UserModel getUsermod() {
		return user;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public LocalDate getCreationTime() {
		return creationTime;
	}

	public void setCreationTime() {
		this.creationTime = LocalDate.now();
	}

	public NotesModel(String userPassword, LocalDate creationTime, UserModel usermod) {
		super();
		this.userPassword = userPassword;
		this.creationTime = creationTime;
		this.user = usermod;
	}
	
	public NotesModel() {}
}
