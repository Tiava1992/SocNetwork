package by.tyav.soc.controller;

import by.tyav.soc.command.CommandFactory;
import by.tyav.soc.command.ICommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    private static final long serialVersionUID=14152342412423L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String forward=handleRequest(req, resp);
        req.getRequestDispatcher(forward+".jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect=handleRequest(req, resp);
        resp.sendRedirect(redirect);

    }

    private String handleRequest(HttpServletRequest req, HttpServletResponse resp){
        ICommand iCommand= CommandFactory.getCommand(req);
        return iCommand.execute(req, resp);
    }
}
