package com.task.demo.Controller;

import java.util.UUID;
import com.task.demo.Entities.Load;
import com.task.demo.Service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private LoadService loadService;


    @GetMapping("/load")
    public List<Load> getLoadByShipperId(@RequestParam UUID shipperId){
        return loadService.getLoadByShipperId(shipperId);
    }

    @GetMapping("/load/{loadId}")
    public Load getLoadById(@PathVariable Long loadId){
        return loadService.getLoadById(loadId);
    }

    @PostMapping("/load")
    public String createLoad(@RequestBody List<Load> load){
        for(Load l : load){
            loadService.createLoad(l);
        }
        return "Load details added successfully";
    }

    @PutMapping("/load/{loadId}")
    public Load updateLoad(@PathVariable Long loadId, @RequestBody Load load){
        return loadService.updateLoad(loadId,load);
    }

    @DeleteMapping("/load/{loadId}")
    public void deleteLoad(@PathVariable Long loadId){
        loadService.deleteLoad(loadId);
    }


}
