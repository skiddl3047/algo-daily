package amazon.coding;

import java.util.HashMap;
import java.util.Map;
/*
Design a logger system that receives a stream of messages along with their timestamps.
Each unique message should only be printed at most every 10 seconds (i.e. a message printed at timestamp t will prevent other identical messages from being printed until timestamp t + 10).
All messages will come in chronological order. Several messages may arrive at the same timestamp.
Implement the Logger class:
* Logger() Initializes the logger object.
* boolean shouldPrintMessage(int timestamp, string message) Returns true if the message should be printed in the given timestamp,
otherwise returns false.

Input
["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
[[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
Output
[null, true, true, false, false, false, true]

Explanation
Logger logger = new Logger();
logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21  
 */
public class LoggerPrintMessageLimiter {

    private Map<String, Integer> limiter;
    private int duration;

    /** Initialize your data structure here. */
    public LoggerPrintMessageLimiter(int duration) {
        limiter = new HashMap<>();
        this.duration = duration;
    }

    /**
     Returns true if the message should be printed in the given timestamp, otherwise returns
     false. If this method returns false, the message will not be printed. The timestamp is in
     seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int t = limiter.getOrDefault(message, 0);
        if (t > timestamp) {
            return false;
        }
        limiter.put(message, timestamp + duration);
        return true;
    }

    public static void main(String[] args) {
        LoggerPrintMessageLimiter logger = new LoggerPrintMessageLimiter(10);
        logSamples(logger);

        logger = new LoggerPrintMessageLimiter(1);
        logSamples(logger);
    }

    private static void logSamples(LoggerPrintMessageLimiter logger) {
        System.out.println(logger.shouldPrintMessage(1, "foo"));  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
        System.out.println(logger.shouldPrintMessage(2, "bar"));  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
        System.out.println(logger.shouldPrintMessage(3, "foo"));  // 3 < 11, return false
        System.out.println(logger.shouldPrintMessage(8, "bar"));  // 8 < 12, return false
        System.out.println(logger.shouldPrintMessage(10, "foo")); // 10 < 11, return false
        System.out.println(logger.shouldPrintMessage(11, "foo"));
    }
}
