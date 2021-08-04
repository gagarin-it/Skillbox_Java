package zone.gagarin.todolist.service;

import java.util.List;
import zone.gagarin.todolist.entity.Subtask;
import zone.gagarin.todolist.entity.Task;

public interface SubtaskService {

  List<Subtask> findAllByTask(Task task);

  Subtask findById(Long id);

  void save(Subtask subtask);

  void deleteById(Long id);

  void deleteAll(Task task);

}
