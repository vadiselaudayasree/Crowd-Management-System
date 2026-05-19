package com.crowd_Entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data

@Entity
@Table(name = "visitor")

public class Visitor {

	@Id
	int id;

	@Column(name = "full_name")
	String fullName;

	String email;

	String phone;

	@Column(name = "id_proof_type")
	String idProofType;

	@Column(name = "id_proof_number")
	String idProofNumber;

	@Column(name = "registered_on")
	LocalDate registeredOn;
}