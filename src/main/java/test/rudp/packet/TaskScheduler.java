package test.rudp.packet;

public class TaskScheduler implements Runnable {
    boolean debug;
    String name;
    private Runnable task;
    private long initialDelay;
    private long period;
    private boolean scheduled;
    private boolean cancelled;
    private boolean paused;
    private boolean stopped;
    private final Object lock = new Object();

    //i
    public TaskScheduler(String name, Runnable task) {
        this.name = name;
        this.task = task;
        initialDelay = 0L;
        period = 0L;
    }

    //a
    public void start() {
        debug = true;
        Thread thread = new Thread(this, name);
        thread.setDaemon(true);
        thread.start();
    }

    @Override
    public void run() {
        while (!stopped) {
            synchronized (this) {
                while (!scheduled && !stopped) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (stopped)
                    break;
            }

            synchronized (lock) {
                paused = false;
                cancelled = false;
                if (initialDelay > 0L) {
                    try {
                        lock.wait(initialDelay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (cancelled)
                    continue;
            }

            if (!paused) {
                task.run();
            }

            if (period <= 0L)
                continue;

            while (true) {
                synchronized (lock) {
                    paused = false;
                    try {
                        lock.wait(period);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (cancelled)
                        break;
                    if (paused)
                        continue;
                }
                task.run();
            }
        }
        if (stopped) {
            task = null;
        }
    }

    // a
    public synchronized void schedule(long delay) {
        schedule(delay, 0L);
    }

    // a
    public synchronized void schedule(long delay, long period) {
        initialDelay = delay;
        this.period = period;
        if (scheduled) {
            throw new IllegalStateException("already scheduled");
        }
        scheduled = true;
        notify();
        synchronized (lock) {
            lock.notify();
        }
    }

    // b
    public synchronized boolean isScheduled() {
        return scheduled;
    }

    // c
    public synchronized boolean isIdle() {
        return !scheduled;
    }

    // d
    public synchronized void pause() {
        synchronized (lock) {
            paused = true;
            lock.notify();
        }
    }

    // e
    public synchronized void cancel() {
        scheduled = false;
        synchronized (lock) {
            cancelled = true;
            lock.notify();
        }
    }

    // f
    public synchronized void stop() {
        cancel();
        stopped = true;
        notify();
    }
}