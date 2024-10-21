package com.ListForReact.ApiDbList;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
public class ListController {

    private final ListRepository listRepository;

    public ListController(ListRepository listRepository){
        this.listRepository = listRepository;
    }

    @GetMapping("")
    public List<GoodThingList> findAll() {
        return listRepository.findAll();
    }
    @PostMapping("/add")
    public void add(@RequestBody GoodThingList item){
        listRepository.create(item.getName(), item.isEatable());
    }
    @PostMapping("/seed")
    public void seed() {
        listRepository.seed();
    }
    @DeleteMapping("/delete")
    public void delete(@RequestBody Integer id){
        System.out.println(id);
        listRepository.delete(id);
        System.out.println(id + " should be gone");
    }
}
