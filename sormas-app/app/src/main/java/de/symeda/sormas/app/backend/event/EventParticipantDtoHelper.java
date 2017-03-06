package de.symeda.sormas.app.backend.event;

import de.symeda.sormas.api.event.EventParticipantDto;
import de.symeda.sormas.api.event.EventParticipantReferenceDto;
import de.symeda.sormas.app.backend.common.AdoDtoHelper;
import de.symeda.sormas.app.backend.common.DatabaseHelper;
import de.symeda.sormas.app.backend.person.Person;
import de.symeda.sormas.app.backend.person.PersonDtoHelper;

public class EventParticipantDtoHelper extends AdoDtoHelper<EventParticipant, EventParticipantDto> {

    private PersonDtoHelper personHelper;

    public EventParticipantDtoHelper() {
        personHelper = new PersonDtoHelper();
    }

    @Override
    public EventParticipant create() {
        return new EventParticipant();
    }

    @Override
    public EventParticipantDto createDto() {
        return new EventParticipantDto();
    }

    @Override
    public void fillInnerFromDto(EventParticipant ado, EventParticipantDto dto) {

        if(dto.getEvent()!=null) {
            ado.setEvent(DatabaseHelper.getEventDao().queryUuid(dto.getEvent().getUuid()));
        }
        else {
            ado.setEvent(null);
        }

        if(dto.getPerson()!=null) {
            ado.setPerson(DatabaseHelper.getPersonDao().queryUuid(dto.getPerson().getUuid()));
        }
        else {
            ado.setEvent(null);
        }

        ado.setInvolvementDescription(dto.getInvolvementDescription());
        
    }

    @Override
    public void fillInnerFromAdo(EventParticipantDto dto, EventParticipant ado) {

        if (ado.getEvent() != null) {
            Event event = DatabaseHelper.getEventDao().queryForId(ado.getEvent().getId());
            dto.setEvent(EventDtoHelper.toReferenceDto(event));
        } else {
            dto.setEvent(null);
        }

        if (ado.getPerson() != null) {
            Person person = DatabaseHelper.getPersonDao().queryForId(ado.getPerson().getId());
            dto.setPerson(personHelper.adoToDto(person));
        } else {
            dto.setEvent(null);
        }

        dto.setInvolvementDescription(ado.getInvolvementDescription());
    }


    public static EventParticipantReferenceDto toReferenceDto(EventParticipant ado) {
        if (ado == null) {
            return null;
        }
        EventParticipantReferenceDto dto = new EventParticipantReferenceDto();
        fillReferenceDto(dto, ado);

        return dto;
    }
}