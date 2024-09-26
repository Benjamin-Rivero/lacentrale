package fr.hb.lacentrale.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.lacentrale.dto.ListingDto;
import fr.hb.lacentrale.entity.Listing;
import fr.hb.lacentrale.json_views.JsonViewListing;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import fr.hb.lacentrale.service.ListingService;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/listing")
public class ListingController {


    private final ListingService listingService;

    @PostMapping
    @JsonView(JsonViewListing.ListingListView.class)
    public Listing create(@Valid @RequestBody ListingDto listingDto){
        return listingService.create(listingDto);
    }

    @GetMapping("/{id}")
    public Listing show(@PathVariable String id){
        return listingService.findById(id);
    }

    @GetMapping
    @JsonView(JsonViewListing.ListingListView.class)
    public List<Listing> list(){
        return listingService.list();
    }

}