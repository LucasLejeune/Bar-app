package main.java.com.examen.ExamenLucasLejeune.controller;

import main.java.com.examen.ExamenLucasLejeune.service.CocktailService;
import org.springframework.web.bind.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/cocktails")
public class CocktailController {
    @Autowired
    private CocktailService cocktailService;
    
    @PostMapping
    public ResponseEntity<Cocktail> createCocktail(@RequestBody Cocktail cocktail) {
        Cocktail createdCocktail = cocktailService.createCocktail(cocktail);
        return new ResponseEntity<>(createdCocktail, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cocktail> getCocktail(@PathVariable Long id) {
        Cocktail cocktail = cocktailService.getCocktail(id);
        if (cocktail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cocktail, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cocktail> updateCocktail(@PathVariable Long id, @RequestBody Cocktail cocktail) {
        Cocktail existingCocktail = cocktailService.getCocktail(id);
        if (existingCocktail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cocktail.setId(id);
        Cocktail updatedCocktail = cocktailService.updateCocktail(cocktail);
        return new ResponseEntity<>(updatedCocktail, HttpStatus.OK);
    }
}
