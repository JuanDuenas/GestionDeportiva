package co.edu.uptc.GestionDeportiva.controller;

import co.edu.uptc.GestionDeportiva.model.AffiliatedManagment;
import co.edu.uptc.GestionDeportiva.service.AffiliatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/affiliated")
public class AffiliatedController {
    @Autowired
    private AffiliatedService affiliatedService;


    @GetMapping("/all")
    public List<AffiliatedManagment> getAffiliated(){
        return affiliatedService.getAffiliateds();
    }

    @PostMapping("/insert")
    public AffiliatedManagment insert(@RequestBody AffiliatedManagment affiliatedManagment){
        return affiliatedService.addAffiliated(affiliatedManagment);
    }

    @PutMapping("/update/{id}")
    public AffiliatedManagment update(@PathVariable String id,@RequestBody AffiliatedManagment affiliatedManagment){
        return affiliatedService.updateAffiliated(id,affiliatedManagment);
    }

    @DeleteMapping("/delete/{id}")
    public AffiliatedManagment delete(@PathVariable String id){
        return affiliatedService.deleteAffiliated(id);
    }

}
