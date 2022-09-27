package com.csi.dao.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoImplTest {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    @MockBean
    EmployeeRepo employeeRepoImpl;


    @Test
    public void saveDataTest(){

        Date dob=null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            dob=simpleDateFormat.parse("26-09-1999");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Employee employee = new Employee(101,"Chinmay Nagargoje",52000.00,"Chakan",dob);

        employeeDaoImpl.saveData(employee);

        verify(employeeRepoImpl, times(1)).save(employee);



    }

    @Test

    public void getAllDataTest(){

        Date dob1 = null;
        Date dob2 = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            dob1=simpleDateFormat.parse("26-09-1999");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        try {
            dob2=simpleDateFormat.parse("17-08-1999");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        when(employeeRepoImpl.findAll()).thenReturn(Stream.of(new Employee(101,"Chinmay Nagargoje",52000.00,"Chakan",dob1),new Employee(102,"Saurabh Satkar",40000.00,"Rajgurunagar",dob2)).collect(Collectors.toList()));

        assertEquals(2,employeeDaoImpl.getAllData().size());
    }


    @Test
    public void updateDataTest(){

        Date dob3 = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");

        try {
            dob3=simpleDateFormat.parse("26-09-1999");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        Employee employee = new Employee(101,"Chinmay Nagargoje",52000.00,"Chakan",dob3);

        employeeDaoImpl.updateData(employee);

        verify(employeeRepoImpl, times(1)).save(employee);



    }

    @Test
    public void deleteDataTest(){

        Date dob4 = null;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            dob4=simpleDateFormat.parse("26-09-1999");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Employee employee = new Employee(101,"Chinmay Nagargoje",520000.00,"Chakan",dob4);

     employeeDaoImpl.deleteDataById(employee.getEmpId());
     verify(employeeRepoImpl, times(1)).deleteById(employee.getEmpId());
    }




}
