package com.Prospecta.Bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class AllData {
	
	 public int count;
	 public List<EntryData> entries;
}


//This Class has been created so that i can retrieve all the entries provided in the
//URL from here.
