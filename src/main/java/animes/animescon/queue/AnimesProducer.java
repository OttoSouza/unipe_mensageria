package animes.animescon.queue;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import animes.animescon.model.Animes;


@Component
public class AnimesProducer {
	
	 	@Autowired
	    private JmsTemplate jmsTemplate;

	    Logger log = LoggerFactory.getLogger(AnimesProducer.class);

	    @Value("${pos.activemq.fila}")
	    private String fila;

	    public Boolean sendMessage(Animes message){
	        try{
	            log.info("Enviando mensagem para o tópico : "+ fila);
	            
	            jmsTemplate.convertAndSend(fila, message);
	            log.info("Animes enviado para o tópico : "+ fila);
	        } catch(Exception e){
	            log.error(" Ocorreu um erro durante envio da Mensagem: ", e);
	            return false;
	        }
	        return true;
	    }

	    public void sendUsuarioFilaEspecial(Animes message){

	    }  
}
