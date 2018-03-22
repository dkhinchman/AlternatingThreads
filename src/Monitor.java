public class Monitor {
    private int _runningThreadId;
    private int _totalThreads;

    public Monitor(int totalThreads){
        if(totalThreads < 1)
            throw new IllegalArgumentException("There must me at least one thread running");
        _totalThreads = totalThreads;
        _runningThreadId = 0;
    }

    public synchronized void waitForTurn(int threadId){
        while(_runningThreadId != threadId){
            try{
                this.wait();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void moveToNextThread(){
        ++_runningThreadId;
        _runningThreadId %= (_totalThreads);
        this.notifyAll();
    }
}
