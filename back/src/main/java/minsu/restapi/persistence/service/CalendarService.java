package minsu.restapi.persistence.service;

import minsu.restapi.persistence.model.Calendar;

import java.util.List;

public interface CalendarService {

    public Long save(Calendar calendar);

    public void pbToggle(Long id);

    public void setRepresent(Long id);

    public Calendar findById(Long id);

    public List<Calendar> findAll();

    public List<Calendar> findByUserId(Long id);

    public Calendar findByUserIdAndRepresent(Long id);

    public void deleteById(Long id);
}
