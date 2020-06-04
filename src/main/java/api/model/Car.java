package api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Car Entity", description = "Describe Car Entity 2")
public class Car {

	@ApiModelProperty(example="Id can be null for new car 2")
	protected long id;

	@ApiModelProperty(required=true, example="Car name 2")
	protected String name;

	@ApiModelProperty(required=true, example="Brand name 2")
	protected String brand;

	public Car(long id, String name,String brand) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}