package com.example.Studentprojectinfo.controller;

import com.example.Studentprojectinfo.dto.Projectrequest;
import com.example.Studentprojectinfo.model.Project;
import com.example.Studentprojectinfo.service.Projectservice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/project")
public class Projectcontroller {
    @Autowired
    private Projectservice projectservice;
    @PostMapping("/add projects")
   public ResponseEntity<Project>saveproject(@RequestBody  @Valid Projectrequest projectrequest)
    {
        return new ResponseEntity<>(projectservice.saveproject(projectrequest),HttpStatus.CREATED);
    }

    @PostMapping("/addprojects")
    public List<Project> addprojects(@RequestBody List<Project> projects)
    {
        return projectservice.saveprojects(projects);
    }
    @GetMapping
    public List<Project> getproject()
            {
                return projectservice.getproject();
            }
   @GetMapping("/{id}")
    public ResponseEntity<Project>getprojectById(@PathVariable("id") int id)
   {

       return new ResponseEntity<>(projectservice.getprojectById(id),HttpStatus.OK);
   }
  @DeleteMapping("/{id}")
    public String deleteprojectById(@PathVariable("id") int id) {
      projectservice.deleteprojectById(id);
      return "deleted";
  }

}
