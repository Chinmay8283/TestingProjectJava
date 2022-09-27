package com.csi.controller;


import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;


    @PostMapping("/savedata")

    public ResponseEntity<Employee>saveData(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeServiceImpl.saveData(employee));
    }

    @GetMapping("/getalldata")

    public ResponseEntity<List<Employee>> getAllData(){

        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{empId}")

    public ResponseEntity<Employee> updateData(@PathVariable int empId, @RequestBody Employee employee){

        return ResponseEntity.ok(employeeServiceImpl.updateData(employee));

    }

    @DeleteMapping("/deletedata/{empId}")

    public ResponseEntity<String> deleteDataById(@PathVariable int empId){

        employeeServiceImpl.deleteDataById(empId);

        return ResponseEntity.ok("Data Deleted Successfully...");
    }
}
