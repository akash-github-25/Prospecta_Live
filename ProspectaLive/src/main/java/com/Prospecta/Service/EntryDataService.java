package com.Prospecta.Service;

import java.util.List;

import com.Prospecta.Bean.EntryData;
import com.Prospecta.Bean.Result;
import com.Prospecta.Exception.EntryDataException;



public interface EntryDataService {
	
  public List<Result> findEntryDataByCategory(String category);
  public String saveEntryDataByCategory(String category);
  public EntryData saveEntryData(EntryData data) throws EntryDataException;
  
}
