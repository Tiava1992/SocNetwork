package by.tyav.soc.command;

import javax.servlet.http.HttpServletRequest;

//класс для создания ICommand
public final class CommandFactory {

    // пустой конструктор, чтобы объекты класса нельзя было создавать
    private CommandFactory(){
    }

    public static ICommand getCommand(HttpServletRequest req){
        String command=req.getParameter("command");
        ICommand iCommand=null;

        if(command!=null){
            try{
                iCommand=CommandEnum.valueOf(command).getCommand();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
                iCommand=CommandEnum.valueOf(command).getCommand();
            }
        }
        else {
            iCommand=CommandEnum.valueOf(command).getCommand();
        }
        return iCommand;
    }
}
