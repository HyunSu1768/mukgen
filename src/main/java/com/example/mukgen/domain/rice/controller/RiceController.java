package com.example.mukgen.domain.rice.controller;

import com.example.mukgen.domain.rice.controller.dto.request.RiceRequest;
import com.example.mukgen.domain.rice.controller.dto.response.RiceResponse;
import com.example.mukgen.domain.rice.service.RiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RiceController {

    private final RiceService riceService;

    @GetMapping("/meal")
    public RiceResponse mealDetails(
            @RequestBody RiceRequest request
            ){
        return riceService.findRice(request);
    }

    @PostMapping("/meal/download")
    public void mealDownload(){
        riceService.downLoadAllRice();
    }

}