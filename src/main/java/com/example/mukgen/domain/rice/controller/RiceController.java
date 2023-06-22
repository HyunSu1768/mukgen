package com.example.mukgen.domain.rice.controller;

import com.example.mukgen.domain.rice.controller.dto.request.MukgenPickRequest;
import com.example.mukgen.domain.rice.controller.dto.request.RiceRequest;
import com.example.mukgen.domain.rice.controller.dto.response.MukgenPickResponse;
import com.example.mukgen.domain.rice.controller.dto.response.RiceResponse;
import com.example.mukgen.domain.rice.controller.dto.response.RiceTodayResponse;
import com.example.mukgen.domain.rice.service.RiceService;
import com.example.mukgen.infra.feign.client.NeisUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@RestController
public class RiceController {

    private final RiceService riceService;

    private final NeisUtil neisUtil;

    @GetMapping("/meal")
    public RiceResponse mealDetails(
            @RequestBody RiceRequest request
            ){
        return riceService.findRice(request);
    }

    @GetMapping("/meal/today")
    public RiceTodayResponse mealTodayList(){
        return riceService.findTodayRice();
    }

    @PostMapping("/meal/download")
    public void mealDownload(){
        ZonedDateTime curDate = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        riceService.downLoadAllRice(curDate.getMonthValue());
    }

    @PostMapping("/mukgen-pick")
    public void mukgenPickAdd(
            @RequestBody MukgenPickRequest request
            ){
        riceService.setMukgenPick(request);
    }

    @GetMapping("/mukgen-pick")
    public MukgenPickResponse mukgenPickDetails(){
        return riceService.findMukgenPick();
    }

}
