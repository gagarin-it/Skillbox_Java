package zone.gagarin.todolist.model;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;

@Entity
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  private String name;

  @Column
  private String description;

  @MapKeyColumn
  private Map<Integer, Subtask> subtaskMap = new HashMap<>();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Map<Integer, Subtask> getSubtaskMap() {
    return subtaskMap;
  }

  public void setSubtaskMap(Map<Integer, Subtask> subtaskMap) {
    this.subtaskMap = subtaskMap;
  }

}
