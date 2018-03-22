public class ThreadRunner implements Runnable {
    private Monitor _monitor;
    private int _threadId;

    public ThreadRunner(int threadId, Monitor monitor){
        _threadId = threadId;
        _monitor = monitor;
    }

    @Override
    public void run(){
        for(int i = 1; i <= 10; ++i){
            _monitor.waitForTurn(_threadId);
            System.out.println(threadOutputString(i));
            _monitor.moveToNextThread();
        }
    }

    private String threadOutputString(int messageNum){
        String message = "Message from thread" + messageNum;
        return message;
    }
}
