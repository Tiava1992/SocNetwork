package by.tyav.soc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {

    String execute (HttpServletRequest req, HttpServletResponse resp);
}
