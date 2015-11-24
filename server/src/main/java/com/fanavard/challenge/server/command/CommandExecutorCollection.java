package com.fanavard.challenge.server.command;

import com.fanavard.challenge.core.model.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ITRENT2 on 11/24/2015.
 */
@Component
@Scope("singleton")
public class CommandExecutorCollection implements CommandExecutor, CommandRunnerRegistry, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(CommandExecutorCollection.class);

    private Map<Class<? extends Command>, CommandRunner> commandCollection = new HashMap<>();

    @Autowired
    ApplicationContext context;

    @Override
    public Object execute(Command command) {
        logger.debug("executing command {}", command.getClass());
        return commandCollection.get(command.getClass()).run(command);
    }

    @Override
    public void register(Class<? extends Command> commandClass, CommandRunner commandRunner) {
        commandCollection.put(commandClass, commandRunner);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for(CommandRunner commandRunner: context.getBeansOfType(CommandRunner.class).values()) {
            register(commandRunner.getCommandClass(), commandRunner);
        }
    }
}
