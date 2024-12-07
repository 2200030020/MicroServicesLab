package klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import klu.model.College;
import klu.model.CollegeManager;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	CollegeManager CM;
	
	@PostMapping("/save")
	public String save(@RequestBody College C) {
		
		return CM.saveData(C);
	}
	
	@PutMapping("/update")
	public String update(@RequestBody College C) {
		return CM.updateData(C);
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam("acronym") String acronym) {//->we can pass through the url
		return CM.deleteData(acronym);
	}
	
	@GetMapping("/read")
	public String read() {
		return CM.readData().toString();
	}
}
