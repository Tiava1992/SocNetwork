package by.tyav.soc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorPageCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "ErrorPage";
    }
}
