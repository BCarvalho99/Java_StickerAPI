package br.com.vlad.langapi;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LangController {
 
    @Autowired
    private LangRepository repository;



    @GetMapping("/languages")
    public List<Lang> getLanguages() {
        List<Lang> languages = repository.findByOrderByRank();
        return languages;
    }

    @PostMapping("/languages")
    public ResponseEntity<Lang> postLanguages(@RequestBody Lang language) {
        Lang registeredLanguage = repository.save(language);
        return new ResponseEntity<>(registeredLanguage, HttpStatus.CREATED);
    }

    @GetMapping("/languages/{id}")
    public Lang getLanguageById(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    @PutMapping("/languages/{id}")
    public Lang updateLanguage(@PathVariable String id, @RequestBody Lang language) {
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        language.setId(id);
        Lang registeredLanguage = repository.save(language);
        return registeredLanguage;
    };
    
    @DeleteMapping("/languages/{id}")
    public void deleteLanguage(@PathVariable String id) {
        repository.deleteById(id);
    }
        

  

}