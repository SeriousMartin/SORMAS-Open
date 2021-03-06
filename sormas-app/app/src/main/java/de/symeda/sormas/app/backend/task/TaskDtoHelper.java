package de.symeda.sormas.app.backend.task;

import java.util.List;

import de.symeda.sormas.api.task.TaskDto;
import de.symeda.sormas.app.backend.caze.Case;
import de.symeda.sormas.app.backend.caze.CaseDtoHelper;
import de.symeda.sormas.app.backend.common.AdoDtoHelper;
import de.symeda.sormas.app.backend.common.DatabaseHelper;
import de.symeda.sormas.app.backend.contact.Contact;
import de.symeda.sormas.app.backend.contact.ContactDtoHelper;
import de.symeda.sormas.app.backend.event.Event;
import de.symeda.sormas.app.backend.event.EventDtoHelper;
import de.symeda.sormas.app.backend.user.User;
import de.symeda.sormas.app.backend.user.UserDtoHelper;
import de.symeda.sormas.app.rest.RetroProvider;
import retrofit2.Call;

/**
 * Created by Stefan Szczesny on 24.10.2016.
 */
public class TaskDtoHelper extends AdoDtoHelper<Task, TaskDto> {

    @Override
    protected Class<Task> getAdoClass() {
        return Task.class;
    }

    @Override
    protected Class<TaskDto> getDtoClass() { return TaskDto.class; }

    @Override
    protected Call<List<TaskDto>> pullAllSince(long since) {
        return RetroProvider.getTaskFacade().pullAllSince(since);
    }

    @Override
    protected Call<List<TaskDto>> pullByUuids(List<String> uuids) {
        return RetroProvider.getTaskFacade().pullByUuids(uuids);
    }

    @Override
    protected Call<Integer> pushAll(List<TaskDto> taskDtos) {
        return RetroProvider.getTaskFacade().pushAll(taskDtos);
    }

    @Override
    public void fillInnerFromDto(Task target, TaskDto source) {

        target.setTaskContext(source.getTaskContext());
        target.setCaze(DatabaseHelper.getCaseDao().getByReferenceDto(source.getCaze()));
        target.setContact(DatabaseHelper.getContactDao().getByReferenceDto(source.getContact()));
        target.setEvent(DatabaseHelper.getEventDao().getByReferenceDto(source.getEvent()));

        target.setTaskType(source.getTaskType());
        target.setTaskStatus(source.getTaskStatus());
        target.setDueDate(source.getDueDate());
        target.setPriority(source.getPriority());
        target.setSuggestedStart(source.getSuggestedStart());
        target.setStatusChangeDate(source.getStatusChangeDate());
        target.setPerceivedStart(source.getPerceivedStart());

        target.setCreatorUser(DatabaseHelper.getUserDao().getByReferenceDto(source.getCreatorUser()));
        target.setCreatorComment(source.getCreatorComment());
        target.setAssigneeUser(DatabaseHelper.getUserDao().getByReferenceDto(source.getAssigneeUser()));
        target.setAssigneeReply(source.getAssigneeReply());

        target.setClosedLat(source.getClosedLat());
        target.setClosedLon(source.getClosedLon());
        target.setClosedLatLonAccuracy(source.getClosedLatLonAccuracy());
    }

    @Override
    public void fillInnerFromAdo(TaskDto target, Task source) {

        target.setTaskContext(source.getTaskContext());
        if (source.getCaze() != null) {
            Case caze = DatabaseHelper.getCaseDao().queryForId(source.getCaze().getId());
            target.setCaze(CaseDtoHelper.toReferenceDto(caze));
        } else {
            target.setCaze(null);
        }
        if (source.getContact() != null) {
            Contact contact = DatabaseHelper.getContactDao().queryForId(source.getContact().getId());
            target.setContact(ContactDtoHelper.toReferenceDto(contact));
        } else {
            target.setContact(null);
        }
        if (source.getEvent() != null) {
            Event event = DatabaseHelper.getEventDao().queryForId(source.getEvent().getId());
            target.setEvent(EventDtoHelper.toReferenceDto(event));
        } else {
            target.setEvent(null);
        }
        target.setTaskType(source.getTaskType());
        target.setTaskStatus(source.getTaskStatus());
        target.setDueDate(source.getDueDate());
        target.setPriority(source.getPriority());
        target.setSuggestedStart(source.getSuggestedStart());
        target.setStatusChangeDate(source.getStatusChangeDate());
        target.setPerceivedStart(source.getPerceivedStart());

        if (source.getCreatorUser() != null) {
            User user = DatabaseHelper.getUserDao().queryForId(source.getCreatorUser().getId());
            target.setCreatorUser(UserDtoHelper.toReferenceDto(user));
        } else {
            target.setCreatorUser(null);
        }
        target.setCreatorComment(source.getCreatorComment());
        if (source.getAssigneeUser() != null) {
            User user = DatabaseHelper.getUserDao().queryForId(source.getAssigneeUser().getId());
            target.setAssigneeUser(UserDtoHelper.toReferenceDto(user));
        } else {
            target.setAssigneeUser(null);
        }
        target.setAssigneeReply(source.getAssigneeReply());

        target.setClosedLat(source.getClosedLat());
        target.setClosedLon(source.getClosedLon());
        target.setClosedLatLonAccuracy(source.getClosedLatLonAccuracy());
    }
}
