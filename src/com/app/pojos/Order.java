package com.app.pojos;


import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "OrderTable")
public class Order {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "product_id")
    private Long pid;

    @Column(name = "name", nullable = false, unique = true)
    @Length(min = 3)
    private String name;
    
    
    @Column(name = "rent", nullable = false)
    @DecimalMin(value = "0.00")
    private Double rent;
    
    
    @Column(name = "quantity")
    private int quantity;
    
    
    @Column(name = "bookdate")
    @Temporal(TemporalType.DATE)
    private Date bdate;
    
    
    @Column(name = "returndate")
    @Temporal(TemporalType.DATE)
    private Date rdate;
    
    @ManyToOne
    @JoinColumn(name = "cust_id")
    private Customer cust;
    

}
