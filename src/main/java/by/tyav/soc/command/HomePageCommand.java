package by.tyav.soc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomePageCommand implements ICommand{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "HomePage";
    }
}
