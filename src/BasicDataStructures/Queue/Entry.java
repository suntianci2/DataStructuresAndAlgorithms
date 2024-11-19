package BasicDataStructures.Queue;

import BasicDataStructures.Queue.Priority;

public class Entry implements Priority {
    private String message;

    private int priorityValue;

    public Entry() {
    }

    public Entry(String message, int priorityValue) {
        this.message = message;
        this.priorityValue = priorityValue;
    }


    @Override
    public int priority() {
        return priorityValue;
    }


    /**
     * 获取
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 获取
     * @return priorityValue
     */
    public int getPriorityValue() {
        return priorityValue;
    }

    /**
     * 设置
     * @param priorityValue
     */
    public void setPriorityValue(int priorityValue) {
        this.priorityValue = priorityValue;
    }

    public String toString() {
        return "Entry{message = " + message + ", priorityValue = " + priorityValue + "}";
    }
}
