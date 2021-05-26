package org.pk.com.controller;


import org.pk.com.config.ApplicationProperties;
import org.pk.com.domain.Employee;
import org.pk.com.exception.RecordNotFoundException;
import org.pk.com.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeResource {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeResource.class);

    private final EmployeeService service;

    private final ApplicationProperties applicationProperties;

    public EmployeeResource(EmployeeService service, ApplicationProperties applicationProperties){
        this.service = service;
        this.applicationProperties = applicationProperties;
    }

    /**
     * This API is used for just fetching the configuration properties configurated using @ConfigurationProperties annotation
     * @return
     */
    @GetMapping("/configurationproperties")
    public ApplicationProperties.AthmaBucket getAllConfigurationProperties(){
        LOG.debug("getAllConfigurationProperties method started");
        return applicationProperties.getAthmaBucket();
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() throws RecordNotFoundException {
        LOG.debug("getAllEmployees method started");
        List<Employee> list = service.getAllEmployees();
        if(list.size()<=0){
            throw new RecordNotFoundException("Employees are not found");
        }
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
        LOG.debug("getEmployeeById method started {}",id);
        Employee entity = null;
        try{
            entity = service.getEmployeeById(id);
        }catch (RecordNotFoundException e){
            throw e;
        }
        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createOrUpdateEmployee(@Valid @RequestBody Employee employee) throws RecordNotFoundException {
        LOG.debug("createOrUpdateEmployee method started {}",employee);
        Employee updated = service.createOrUpdateEmployee(employee);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
        LOG.debug("deleteEmployeeById method started {}",id);
        service.deleteEmployeeById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-adtApp-alert", "employee deleted");
        headers.add("X-adtApp-params", id.toString());
        return ResponseEntity.ok().headers(headers).build();
    }

}
