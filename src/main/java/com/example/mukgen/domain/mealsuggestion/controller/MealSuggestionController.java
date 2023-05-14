package com.example.mukgen.domain.mealsuggestion.controller;

import com.example.mukgen.domain.mealsuggestion.controller.dto.request.MealSuggestionCreateRequest;
import com.example.mukgen.domain.mealsuggestion.controller.dto.request.MealSuggestionUpdateRequest;
import com.example.mukgen.domain.mealsuggestion.controller.dto.response.MealSuggestionResponse;
import com.example.mukgen.domain.mealsuggestion.service.MealSuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mealSuggestion")
public class MealSuggestionController {

    private final MealSuggestionService mealSuggestionService;

    @PostMapping
    public void mealSuggestionAdd(
            @RequestBody @Valid MealSuggestionCreateRequest request
    ) {
        mealSuggestionService.addMealSuggestion(request);
    }

    @PutMapping("/{suggestionId}")
    public void mealSuggestionModify(
            @RequestBody @Valid MealSuggestionUpdateRequest request,
            @PathVariable Long suggestionId
    ) {
        mealSuggestionService.modifyMealSuggestion(request, suggestionId);
    }

    @DeleteMapping("/{suggestionId}")
    public void mealSuggestionRemove(
            @PathVariable Long suggestionId
    ) {
        mealSuggestionService.removeMealSuggestion(suggestionId);
    }

    @GetMapping("/list")
    public List<MealSuggestionResponse> mealSuggestionList() {
        return mealSuggestionService.findAllSuggestion();
    }

    @PostMapping("/{mealSuggestionId}")
    public void checkClick(
            @PathVariable Long mealSuggestionId
    ) {
        mealSuggestionService.clickCheck(mealSuggestionId);
    }
}