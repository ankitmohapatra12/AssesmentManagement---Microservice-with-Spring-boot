package com.loginMicroservice.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentDto {

	private int assesment_id;
	private String assesments;
	private String dateField;
	private String assesmentType;
	private int user_id;
}
