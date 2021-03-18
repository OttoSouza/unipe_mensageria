package animes.animescon.agendamento;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import animes.animescon.listener.Destinations;
import animes.animescon.model.Animes;

@Component
@EnableAsync
public class AgendaConsumo {

    @Autowired
    private JmsTemplate jmsTemplate;

    Logger log = LoggerFactory.getLogger(AgendaConsumo.class);

    @Scheduled(fixedRate = 10000)
    @Async
    public void consomeFila(){
        try{
            log.info("Schedule - Processamento dos animes iniciado  "+ Destinations.FILA_ANIME);
            Animes anime = (Animes) jmsTemplate.receiveAndConvert(Destinations.FILA_ANIME);
            log.info("Anime recebido pela schedule : {}" , anime.getNome());
        } catch(Exception e){
            log.error("Anime recebido pela schedule: ", e);
        }
    }
}
