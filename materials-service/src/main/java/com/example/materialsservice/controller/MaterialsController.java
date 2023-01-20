package com.example.materialsservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ms-api")
@RequiredArgsConstructor
public class MaterialsController {
    private final List<String> materials = new ArrayList<>();

    @GetMapping("/")
    public List<String> getMaterials() {
        return this.materials;
    }

    @PostMapping("/{material}")
    public String addMaterial(@PathVariable String material) {
        materials.add(material);
        return "You have added a material: " + material;
    }

}
