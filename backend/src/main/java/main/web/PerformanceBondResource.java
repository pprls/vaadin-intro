package main.web;

import main.model.PerformanceBond;
import main.service.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/PerformanceBond")
public class PerformanceBondResource {

    @Autowired
    PersonRepository repository;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = {APPLICATION_JSON_VALUE})
    public PerformanceBond createBond(@RequestBody PerformanceBond bond)
    {
        PerformanceBond newBond = new PerformanceBond(bond);
        repository.save(newBond);
        return newBond;
    }

    //

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public List<PerformanceBond> find(@RequestParam(value="name", defaultValue="World") String name)
    {
        List<PerformanceBond> persons = repository.findByName(name);
       return persons;
    }
}
