package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Inventory")
public class Inventory {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inv_id")
    private Long id;
    
    
    @Column(name = "product_id")
    private Long pid;
    
	@Column(name = "quantity")
	private int quantity;
    
    @ManyToOne
    @JoinColumn(name = "ven_id")
    private Vendor ven;

}
