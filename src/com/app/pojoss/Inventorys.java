package com.app.pojoss;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


public class Inventorys {
	
 
    private Long id;
    
    
    private Long pid;
    
    
	private int quantity;
    
	
    private Vendors ven;

}
