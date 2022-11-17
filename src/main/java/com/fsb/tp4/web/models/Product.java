package com.fsb.tp4.web.models;

public class Product {
	 	private long id;
	    private String code;
	    private String name;
	    private Double price;
	    private String image;
	 
	    public Product() {
	 
	    }
	 
	    public Product(Long id, String code, String name,Double price, String image) {
	        this.id = id;
	        this.code = code;
	        this.name = name;
	        this.price= price;
	        
	        this.image = image;
	    }
	 
	    public Long getId() {
	        return id;
	    }
	 
	    public void setId(Long id) {
	        this.id = id;
	    }
	 
	    public String getCode() {
	        return code;
	    }
	 
	    public void setCode(String code) {
	        this.code = code;
	    }
	 
	    public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	    
	    
	 
	    public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getImage() {
	        return image;
	    }
	 
	    public void setImage(String image) {
	        this.image = image;
	    }

}
