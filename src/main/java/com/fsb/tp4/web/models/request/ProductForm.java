package com.fsb.tp4.web.models.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductForm {
	@NotNull
	private Long id;
	@NotNull
	@Size(min=2, max=30)
    private String code;
	@NotNull
	@Size(min=4, max=30)
    private String name;
	@NotNull
    private Double price;
	@NotNull
	@Size(min=10, max=30)
    private String image;
	
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
