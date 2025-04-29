package com.sufi.tech.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sufi.tech.entity.College;
import com.sufi.tech.repository.CollegeRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	CollegeRepository collegeRepository;
	
	@PostMapping("/save")
	public String saveCollege(@RequestBody College college) {
		collegeRepository.save(college);
		return "College data hase been Saved Successfully--- ";
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<College>> getCollege() {
		
		List<College> list=new ArrayList<College>();
		collegeRepository.findAll().forEach(list::add);
		return new ResponseEntity<List<College>>(list,HttpStatus.OK);
	}
	
     @DeleteMapping("/delete/{id}")
  public String deleteCollegeByID( @PathVariable("id") long id) {
	collegeRepository.deleteById(id);
	return "College Details Deleted with "+id+" deleted Successfully--";
    }

      @PutMapping("/update/{id}")
      public String updateCollege(@PathVariable ("id") long id, @RequestBody College college) {
            College  clg = collegeRepository.findById(id).get();
          if(clg!=null) {
        	  college.setCollegeId(id);
        	  collegeRepository.save(college);
        	  return "College Details with" +id+ " updated Successfully...";
          }else {
        	  return "College Details with" +id+"Not Fund...";
          }
          
      }
}
