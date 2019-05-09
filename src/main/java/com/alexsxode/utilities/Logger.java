package com.alexsxode.utilities;

import com.alexsxode.utilities.collection.Pair;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Logger {

    public static final boolean ACTIVE = true;
    private static boolean activeWarningIssued = false;

    private static ArrayList<LogEvent> logs = new ArrayList<>();

    public static final String[] LOGLEVEL_STRING = {"Info", "Warning", "Important", "Critical", "Error"};


    public enum LogLevel {
        INFO(1),
        WARNING(2),
        IMPORTANT(3),
        CRITICAL(4),
        ERROR(5);

        private int level;

        LogLevel(int level) {
            this.level = level;
        }

        public int getLevel() {
            return this.level;
        }

        @Override
        public String toString() {
            return Logger.LOGLEVEL_STRING[this.getLevel()];
        }
    }

    private static class LogEvent {
        public final Object emitter;
        public final LogLevel logLevel;
        public final Object[] objects;

        public LogEvent( Object emitter, LogLevel logLevel, Object[] objects) {
            this.emitter = emitter;
            this.logLevel = logLevel;
            this.objects = objects;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();

            sb.append(this.logLevel.toString());
            sb.append(":\t");
            sb.append(this.emitter.toString());
            sb.append(" : \n");

            for (Object arg_obj : this.objects ) {
                sb.append(arg_obj.toString());
            }

            return sb.toString();
        }

    }

    public static ArrayList<LogEvent> getLogs() {
        if (!Logger.activeWarningIssued) {
            System.err.println("Warning: logger deactivated!");
            Logger.activeWarningIssued = true;
        }
        return logs;
    }

    public static void log(Object obj, LogLevel logLevel, Object... args) {
        if (Logger.ACTIVE) {
            logs.add(new Logger.LogEvent(obj, logLevel, args));
        }
    }

    public static void logInfo(Object obj, Object... args) {
        Logger.log(obj, LogLevel.INFO, args);
    }

    public static void logWarning(Object obj, Object... args) {
        Logger.log(obj, LogLevel.WARNING, args);
    }

    public static void printLogs() {
        for (LogEvent logEvent : Logger.getLogs()) {
            System.out.println(logEvent);
        }
    }

    public static void print_logs(ArrayList<LogEvent> logs) {
        for (LogEvent logEvent : logs) {
            System.out.println(logEvent);
        }
    }

    public static ArrayList<LogEvent> filterLogs(Predicate<LogEvent> predicate) {
        return Logger.getLogs()
                .stream()
                .filter(predicate)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static ArrayList<LogEvent> atLeastLevel(int level) {
        return filterLogs(l -> l.logLevel.getLevel() >= level);
    }

    public static ArrayList<LogEvent> fromObject(Object obj) {
        return filterLogs(le -> le == obj);
    }

    public static ArrayList<LogEvent> ofLevel(int level) {
        return filterLogs(le -> le.logLevel.getLevel() == level);
    }

    public static ArrayList<LogEvent> fromClass(Class c) {
        return filterLogs(le -> le.emitter.getClass() == c);
    }

    public static ArrayList<LogEvent> fromEqualObject(Object obj) {
        return filterLogs(le -> le.emitter.equals(obj));
    }
}
