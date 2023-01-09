package com.Prospecta.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result {
private String Title;
private String Description;
}

//This class is required because in question 1 of coding challenge we are asked to
// get only title and description.


