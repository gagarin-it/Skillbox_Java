package zone.gagarin.todolist.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zone.gagarin.todolist.entity.Task;
import zone.gagarin.todolist.service.TaskService;

@Controller
public class DefaultController
{

    private final TaskService taskService;

    public DefaultController(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping("/")
    public String index(Model model)
    {
        Iterable<Task> taskIterable = taskService.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for(Task task : taskIterable) {
            tasks.add(task);
        }
        model.addAttribute("tasks", tasks);
        model.addAttribute("tasksCount", tasks.size());
        return "index";
    }
}