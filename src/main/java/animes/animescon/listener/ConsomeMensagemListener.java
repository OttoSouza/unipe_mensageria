package animes.animescon.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import animes.animescon.model.Animes;

@Component
public class ConsomeMensagemListener {

    Logger log = LoggerFactory.getLogger(ConsomeMensagemListener.class);

    @JmsListener(destination = "animes.animescon.topico.animes")
    public void processMessage(Animes anime) {

        log.info("Recebendo mensagem por Listener {} ", anime.getNome());
    }

}
