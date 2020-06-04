package api.controller;

import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import api.model.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(value = "API for Car", description = "Rest for Car entities")
public class CarController {

	@RequestMapping(value = "/" ,method = RequestMethod.GET)
	@ApiOperation(value = "no hidden",hidden = true)
	public String index(){
		return "CBCTECK";
	}

	@ApiOperation(value = "Get car 2", notes = "Get car using car id 2")
	@RequestMapping(value="/car/{car_id}", method= RequestMethod.GET, produces = "application/json")
	public Car getCar(
			@ApiParam(value = "car id 2", required = true, defaultValue = "1") @PathVariable("car_id")  String id)
			throws Exception {
		return new Car(0, "Axio","Toyota");
	}

	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Invalid ID supplied 2"),
			@ApiResponse(code = 404, message = "Pet not found 2"),
			@ApiResponse(code = 405, message = "Validation exception 2")})
	@ApiOperation(value = "Retrieve all Cars", notes = "Format [Response JSONArray](#_get_all_cars).")
	@RequestMapping(value="/cars", method= RequestMethod.GET, produces = "application/json")
	public List<Car> getCars() {
		List<Car> cars =  new ArrayList<Car>();
		return cars;
	}

	@ApiOperation(value = "Add new car 2", notes = "See 2 [Request JSON](#_save_car).")
	@ApiResponses(value = {@ApiResponse(code = 201,message = "Save new car [JSON](#_car)")})
	@PostMapping(value = "/car/save",produces = "application/json")
	public Car saveCar(@ApiParam(value = "car", required = true) @ModelAttribute("car")  Car car){
		return car;
	}

	/*@ApiOperation(value = "Get Custom Json", notes = "Get custome JSON List in Map")
	*//*@ApiImplicitParams({
			@ApiImplicitParam(
					name = "Get Custom Json",
					value = "A JSON value representing a transaction. An example of the expected schema can be found down here. The fields marked with * means that they are required. See the schema of KambiTransaction for more information.",
					required = true,
					dataType = "String",
					paramType = "body",
					examples = @Example(value = {@ExampleProperty(mediaType = "application/json", value = "{foo: whatever, bar: whatever2}")}))})*//*
	@RequestMapping(value="/custom/map", method= RequestMethod.GET, produces = "application/json")
	public Custom getMapList() {
		List<Map<String,String>> list =  new ArrayList<Map<String, String>>();
		Map<String,String> map = new HashMap<String, String>();
		map.put("car1","Axio");
		map.put("car2","Prious");
		map.put("car3","Corolla");
		map.put("car4","121");
		list.add(map);
		Custom custom = new Custom();
		custom.setList(list);
		return custom;
	}*/
}