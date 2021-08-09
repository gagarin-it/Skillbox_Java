$(function () {

  //Show adding task form
  $('#show-add-task-form').click(function () {
    $('#task-form').css('display', 'flex');
  });

  //Closing adding task form
  $('#task-form').click(function (event) {
    if (event.target === this) {
      $(this).css('display', 'none');
    }
  });

  //Adding task
  $('#save-task').click(function () {
    var data = {};
    var dataArray = $('#task-form form').serializeArray();
    for (i in dataArray) {
      data[dataArray[i]['name']] = dataArray[i]['value'];
    }
    $.ajax({
      type: "POST",
      url: '/todolist/tasks',
      data: JSON.stringify(data),
      contentType: 'application/json',
      dataType: "json",
      success: function (response) {
        $('#task-form').css('display', 'none');
        location.reload();
      },
      error: function (response) {
        if (response.status === 400) {
          alert('Ошибка, пустое пустое тело запроса');
        }
      }
    });
    return false;
  });

  //Delete task by ID
  $('#delete-task').click(function () {
    var taskId = document.getElementById('delete-task').value;
    $.ajax({
      type: "DELETE",
      url: '/todolist/tasks/' + taskId,
      success: function (response) {
        $('#task-form').css('display', 'none');
        location.reload();
      },
      error: function (response) {
        if (response.status === 500) {
          alert('Ошибка, задача отсутствует');
        }
      }
    });
    return false;
  });

  //Delete all tasks
  $('#delete-all-task').click(function () {
    $.ajax({
      type: "DELETE",
      url: '/todolist/tasks',
      success: function (response) {
        $('#task-form').css('display', 'none');
        location.reload();
      },
      error: function (response) {
        if (response.status === 400) {
          alert('Ошибка, список задач пуст');
        }
      }
    });
    return false;
  });
});