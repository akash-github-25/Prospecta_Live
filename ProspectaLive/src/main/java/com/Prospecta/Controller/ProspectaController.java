package com.Prospecta.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Prospecta.Bean.EntryData;
import com.Prospecta.Bean.Result;
import com.Prospecta.Exception.EntryDataException;
import com.Prospecta.Service.EntryDataService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/Prospecta")
public class ProspectaController {
	
	@Autowired
	private EntryDataService eds;
	
	@GetMapping("/{category}")
	  public ResponseEntity<List<Result>>  findEntryByCategory(@PathVariable("category") String category){	
	  return new ResponseEntity<>(eds.findEntryDataByCategory(category),HttpStatus.OK);	
	}
	
	@PostMapping("/saveEntry/{category}")
       public ResponseEntity<String>  saveEntryByCategory(@PathVariable("category") String category){
	   return new ResponseEntity<>(eds.saveEntryDataByCategory(category),HttpStatus.CREATED);
    }
	
	@PostMapping("/Entry")
	public ResponseEntity<EntryData> saveEntry(@RequestBody EntryData data) throws EntryDataException {
		 return new ResponseEntity<>(eds.saveEntryData(data),HttpStatus.CREATED);
	}
	
}
