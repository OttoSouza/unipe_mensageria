package animes.animescon.ws;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import animes.animescon.model.Animes;
import animes.animescon.queue.AnimesConsumer;
import animes.animescon.queue.AnimesProducer;

@RestController
@RequestMapping("/api")
public class AnimesRest {

	@Autowired
    private AnimesProducer animesProducer;
	
	@Autowired
    private AnimesConsumer animesConsumer;


    @PostMapping("/anime")
    public ResponseEntity<Animes> createUser(@RequestBody Animes anime){
        return animesProducer.sendMessage(anime) ? ResponseEntity.ok(anime) : ResponseEntity.badRequest().build();
    }

    @GetMapping("/consumer")
    public ResponseEntity<String> consultaFila(){

    	animesConsumer.processaAnimes();

       return ResponseEntity.ok("Processado");
    }


    @GetMapping("/anime")
    public ResponseEntity<Animes> getAnimes(){

        Animes u = new Animes();
        u.setId(1l);
        u.setNome("Naruto " + new Date().toString());
        return ResponseEntity.ok(u);

    }

}
