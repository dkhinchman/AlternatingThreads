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
        String message = (messageNum == 1) ? "1st" : (messageNum == 2) ? "2nd"
                : (messageNum == 3) ? "3rd" : messageNum + "th";
        return message + " Message from thread " + _threadId;
    }
}
