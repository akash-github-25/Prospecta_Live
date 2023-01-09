package com.Prospecta.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Prospecta.Bean.AllData;
import com.Prospecta.Bean.EntryData;
import com.Prospecta.Bean.Result;
import com.Prospecta.Exception.EntryDataException;
import com.Prospecta.Repository.ProspectaRepository;



@Service
public class EntryDataServiceImpl implements EntryDataService{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ProspectaRepository prospectaRepository;	
	

	@Override
	public List<Result> findEntryDataByCategory(String category) {
		
		String query ="https://api.publicapis.org/entries";	
		ResponseEntity<AllData> desc = restTemplate.getForEntity(query, AllData.class);	
			
		AllData data = desc.getBody();
			List<EntryData> getEntries=data.getEntries();
			List<EntryData> newEntries=getEntries.stream().filter((e)->e.getCategory().equals(category)).collect(Collectors.toList());
			List<Result> results=new ArrayList<>();
			for(EntryData x:newEntries) {
				Result c= new Result(x.getAPI(),x.getDescription());
				results.add(c);
			}
			return results;
	}

	@Override
	public String saveEntryDataByCategory(String category) {
		
		String query ="https://api.publicapis.org/entries";	
		ResponseEntity<AllData> desc = restTemplate.getForEntity(query, AllData.class);	
			AllData data = desc.getBody();
			List<EntryData> getEntries=data.getEntries();
			List<EntryData> list=getEntries.stream().filter((e)->e.getCategory().equals(category)).collect(Collectors.toList());
			for(EntryData item:list) {
				EntryData newProject = new EntryData(item.getAPI(), item.getDescription(), item.getAuth(), item.isHTTPS(), item.getCors(), item.getLink(), item.getCategory());
			    prospectaRepository.save(newProject);
			}		
			return "Data is Saved !";
	}

	@Override
	public EntryData saveEntryData(EntryData data) throws EntryDataException{
		
		if(data==null) {
			throw new EntryDataException("Data might be null... please provide proper data !");
		}
		String query ="https://api.publicapis.org/entries";	
		ResponseEntity<AllData> desc = restTemplate.getForEntity(query, AllData.class);	
			AllData data1 = desc.getBody();
			List<EntryData> getEntries=data1.getEntries();
			getEntries.add(data);
        prospectaRepository.save(data);
		return data;
	}

}
