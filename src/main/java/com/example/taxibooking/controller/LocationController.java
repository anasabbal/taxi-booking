package com.example.taxibooking.controller;


import com.example.taxibooking.command.LocationCommand;
import com.example.taxibooking.dto.LocationDto;
import com.example.taxibooking.mapper.LocationMapper;
import com.example.taxibooking.model.ExactLocation;
import com.example.taxibooking.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/location")
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;
    private final LocationMapper locationMapper;

    @GetMapping("/{locationId}")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable("locationId") final String locationId){
        final ExactLocation location = locationService.findById(locationId);
        return ResponseEntity.ok(locationMapper.toLocationDto(location));
    }
    @PostMapping
    public ResponseEntity<LocationDto> creatLocation(@RequestBody final LocationCommand locationCommand){
        final ExactLocation location = locationService.createLocation(locationCommand);
        return ResponseEntity.ok(locationMapper.toLocationDto(location));
    }
    @PutMapping("/{locationId}")
    public ResponseEntity<LocationDto> updateLocation(@PathVariable("locationId") final String locationId, @RequestBody LocationCommand locationCommand){
        final ExactLocation location = locationService.update(locationId, locationCommand);
        return ResponseEntity.ok(locationMapper.toLocationDto(location));
    }
}
