package com.restapi.restapi.contoller;

import com.restapi.restapi.contoller.entity.RestapiEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/restapi")
public class RestApiController {

    private HashMap<Long, RestapiEntry> restapiEntries = new HashMap<>();

    @GetMapping
    public List<RestapiEntry> getAll(){
        return new ArrayList<>(restapiEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody RestapiEntry myEntry){
        restapiEntries.put(myEntry.getId(),myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public RestapiEntry getRestapiEntryById(@PathVariable Long myId){
       return restapiEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public RestapiEntry deleteRestapiEntryById(@PathVariable Long myId){
        return restapiEntries.remove(myId);
    }

    @PutMapping("/id/{id}")
    public RestapiEntry updateRestapiEntryById(@PathVariable Long id, @RequestBody RestapiEntry myEntry){
        return restapiEntries.put(id,myEntry);
    }


}
