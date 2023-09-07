package com.example.backendarsii.service.serviceImpl;
import com.example.backendarsii.dto.EventDto;
import com.example.backendarsii.dto.EventRequest;
import com.example.backendarsii.entity.Event;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.repository.EventRepository;
import com.example.backendarsii.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

   @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        List<EventDto> eventDtos = new ArrayList<>();

        for (Event event : events) {
            EventDto eventDto = EventDto.makeEvent(event);
            eventDtos.add(eventDto);
        }
        return eventDtos;
    }

    @Override
    public void createEvent(@org.jetbrains.annotations.NotNull EventRequest eventRequest) {
        Event event =  Event.builder()
                .title(eventRequest.getTitle())
                .description(eventRequest.getDescription())
                .former(eventRequest.getFormer())
                .URLImage(eventRequest.getURLImage())
                .numberOfParticipants(eventRequest.getNumberOfParticipants())
                .location(eventRequest.getLocation())
                .status(eventRequest.isStatus())
                .typeEvent(eventRequest.getTypeEvent())
                .build();
                 eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Integer eventId) {
        eventRepository.deleteById(eventId);
    }
    @Override
    public EventDto getEventById(Integer eventId) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            return EventDto.makeEvent(event);
        } else {
            throw new NotFoundException("event with ID : " + eventId);
        }
    }
    @Override
    public boolean isActive(EventDto event) {
        if (event != null && event.getId() != null) {
            List<Event> activeEventsWithSameId = eventRepository.findByStatus(true);
            return !activeEventsWithSameId.isEmpty();
        }
        return false;
    }




}
