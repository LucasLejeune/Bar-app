package main.java.com.examen.ExamenLucasLejeune.service.impl;

import main.java.com.examen.ExamenLucasLejeune.model.Cocktail;
import main.java.com.examen.ExamenLucasLejeune.repository.CocktailRepository;
import main.java.com.examen.ExamenLucasLejeune.service.CocktailService;
import org.springframework.web.bind.annotation.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.Override;



@Service
public class CocktailServiceImpl implements CocktailService{
    @Autowired
    private CocktailRepository cocktailRepository;

    @Override
    public Cocktail createCocktail(Cocktail cocktail){
        return CocktailRepository.save(cocktail);
    }
    
    @Override
    public Cocktail getCocktail(int id) {
        return cocktailRepository.findById(id).orElse(null);
    }
    
    @Override
    public Cocktail updateCocktail(Cocktail cocktail) {
        return cocktailRepository.save(cocktail);
    }


}
