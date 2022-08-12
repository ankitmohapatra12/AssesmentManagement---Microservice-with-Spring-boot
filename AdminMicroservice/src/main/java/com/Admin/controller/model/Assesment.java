package com.Admin.controller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@Table(name="assesments")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Assesment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int assesment_id;
	private String assesments;
	private String dateField;
	private String assesmentType;
	private int user_id;
}
