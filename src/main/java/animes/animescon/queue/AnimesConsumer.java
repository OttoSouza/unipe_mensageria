package animes.animescon.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import animes.animescon.listener.Destinations;
import animes.animescon.model.Animes;


@Component
public class AnimesConsumer {

    @Autowired
    private JmsTemplate jmsTemplate;

    Logger log = LoggerFactory.getLogger(AnimesConsumer.class);

    public void processaAnimes(){

        try{
            log.info("Processamento de anime Iniciado por EndPoint para  "+ Destinations.FILA_ANIME);
            Animes anime = (Animes) jmsTemplate.receiveAndConvert(Destinations.FILA_ANIME);
            log.info("Anime recebido : {}" , anime.getNome());
        } catch(Exception e){
            log.error(" Ocorreu um erro durante envio da Mensagem: ", e);
        }
    }
}
