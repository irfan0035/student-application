package com.example.students.Controller;


import com.example.students.Service.MarkService;
import com.example.students.dtos.MarksDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarkController {
    @Autowired
    MarkService markService;

    @PostMapping("/add")
    public MarksDto add(@RequestBody MarksDto marksDto){
        return markService.addMarks(marksDto);
    }
    @GetMapping("/show")
    public List<MarksDto> show(){
        return markService.showMark();
    }
    @GetMapping("/show/details")
    public List<MarksDto> showDetails(){
        return markService.showMarks();
    }
}
