package com.Prospecta.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Data
@ToString
public class EntryData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 public Integer dataId;
	    public String API;
	    public String Description;
	    public String Auth;
	    public boolean HTTPS;
	    public String Cors;
	    public String Link;
	    public String Category;
	    
	    
	    public EntryData(String API, String Description, String Auth, boolean HTTPS, String Cors, String Link,
				String Category) {
			super();
			this.API = API;
			this.Description = Description;
			this.Auth = Auth;
			this.HTTPS = HTTPS;
			this.Cors = Cors;
			this.Link = Link;
			this.Category = Category;
		}
	    
//	    I need a constructor which doesn't include dataId thats why I overridden 
//	    another constructor without dataId;
	    
}
