
public class Worker {

    private static final int plannedError = 33; // Номер задачи которая запланированно закончится неуспешно
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;


    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {

        for (int i = 0; i < 100; i++) {
            int taskNumber = i + 1;  // номер задачи
            if (i == plannedError - 1) {
                errorCallback.onError("Task " + taskNumber + " is error!!!");
            } else {
                callback.onDone("Task " + taskNumber + " is done");
            }
        }
    }
}
