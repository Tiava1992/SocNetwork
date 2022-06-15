package by.tyav.soc.command;

import by.tyav.soc.command.get.ErrorPageCommand;
import by.tyav.soc.command.get.HomePageCommand;
import by.tyav.soc.command.get.UsersPageCommand;

public enum CommandEnum {

    HOME_PAGE(new HomePageCommand()),
    USERS_PAGE(new UsersPageCommand()),
    ERROR_PAGE(new ErrorPageCommand());

    private ICommand command;

    CommandEnum(ICommand command) {
        this.command = command;
    }

    public ICommand getCommand() {
        return command;
    }
}
