package com.example.backendarsii.service.serviceImpl;
import com.example.backendarsii.dto.EventDto;
import com.example.backendarsii.entity.Event;
import com.example.backendarsii.exception.NotFoundException;
import com.example.backendarsii.repository.EventRepository;
import com.example.backendarsii.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private  EventRepository eventRepository;

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
    public EventDto createEvent(EventDto eventDto) {
        Event event = new Event(
                eventDto.getId(),
                eventDto.getTitle(),
                eventDto.getDescription(),
                eventDto.getDate(),
                eventDto.getFormer(),
                eventDto.getURLImage(),
                eventDto.getNumberOfParticipants(),
                eventDto.getLocation(),
                eventDto.isStatus(),
                eventDto.getTypeEvent(),
                eventDto.getCreatedAt(),
                eventDto.getUpdatedAt(),
                eventDto.isDeleted()
        );

        Event savedEvent = eventRepository.save(event);
        return EventDto.makeEvent(savedEvent);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
    @Override
    public EventDto getEventById(Long eventId) {
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
