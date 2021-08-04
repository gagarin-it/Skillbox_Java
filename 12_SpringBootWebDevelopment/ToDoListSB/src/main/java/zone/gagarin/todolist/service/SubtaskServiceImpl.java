package zone.gagarin.todolist.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zone.gagarin.todolist.dao.SubtaskRepository;
import zone.gagarin.todolist.entity.Subtask;
import zone.gagarin.todolist.entity.Task;

@Service
public class SubtaskServiceImpl implements SubtaskService{

  private final SubtaskRepository subtaskRepository;

  @Autowired
  public SubtaskServiceImpl(SubtaskRepository subtaskRepository) {
    this.subtaskRepository = subtaskRepository;
  }

  @Override
  public List<Subtask> findAllByTask(Task task) {
    return subtaskRepository.findAllByTask(task);
  }

  @Override
  public Subtask findById(Long id) {
    Subtask subtask = null;
    Optional<Subtask> optional = subtaskRepository.findById(id);
    if(optional.isPresent()){
      subtask = optional.get();
    }
    return subtask;
  }

  @Override
  public void save(Subtask subtask) {
    subtaskRepository.save(subtask);
  }

  @Override
  public void deleteById(Long id) {
    subtaskRepository.deleteById(id);
  }

  @Override
  public void deleteAll(Task task) {
    List<Subtask> subtasks = subtaskRepository.findAllByTask(task);
    subtasks.forEach(s -> subtaskRepository.deleteById(s.getId()));
  }
}
