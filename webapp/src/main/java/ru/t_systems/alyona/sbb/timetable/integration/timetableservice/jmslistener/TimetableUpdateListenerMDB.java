package ru.t_systems.alyona.sbb.timetable.integration.timetableservice.jmslistener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.t_systems.alyona.sbb.timetable.TimetableUpdateDTO;
import ru.t_systems.alyona.sbb.timetable.service.TimetableHolder;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(
                        propertyName = "destinationLookup",
                        propertyValue = "java:/jms/topic/TimetableTopic"),
                @ActivationConfigProperty(
                        propertyName = "destinationType",
                        propertyValue = "javax.jms.Topic"),
                @ActivationConfigProperty(
                        propertyName = "acknowledgeMode",
                        propertyValue = "Auto-acknowledge"),
        })
public class TimetableUpdateListenerMDB implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimetableUpdateListenerMDB.class);

    private TimetableHolder timetableHolder;

    @Inject
    public void setTimetableHolder(TimetableHolder timetableHolder) {
        this.timetableHolder = timetableHolder;
    }

    @Override
    public void onMessage(final Message incomingMessage) {
        try {
            processMessage(incomingMessage);
        } catch (Exception e) {
            LOGGER.error("Failed to process a message from the timetable topic", e);
        }
    }

    private void processMessage(final Message incomingMessage) throws JMSException {
        TimetableUpdateDTO timetableChanges = incomingMessage.getBody(TimetableUpdateDTO.class);
        timetableHolder.updateTimetable(timetableChanges);
    }
}
