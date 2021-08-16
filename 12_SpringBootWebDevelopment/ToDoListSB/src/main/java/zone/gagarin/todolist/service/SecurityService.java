package zone.gagarin.todolist.service;

public interface SecurityService {
  boolean isAuthenticated();
  void autoLogin(String username, String password);

}
