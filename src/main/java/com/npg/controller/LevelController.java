package com.npg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.npg.dto.LevelDTO;
import com.npg.service.StudentService;

@RestController
@RequestMapping("student")
public class LevelController {

	@Autowired
	private StudentService studentService;

	@PostMapping("level")
	@ResponseBody
	public ResponseEntity<?> createLevel(@RequestBody LevelDTO request) {

		this.studentService.createLevel(request);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	@PutMapping("level")
	@ResponseBody
	public ResponseEntity<?> updateLevel(@RequestBody LevelDTO request) {

		this.studentService.updateLevel(request);

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("level")
	@ResponseBody
	public ResponseEntity<?> getLevels() {

		List<LevelDTO> levelDTOlist= this.studentService.getLevels();
		

		return new ResponseEntity<>(levelDTOlist,HttpStatus.OK);
	}

	@DeleteMapping("level/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteLevel(@PathVariable("id") Integer levelID) {

		this.studentService.deleteLevel(levelID);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
