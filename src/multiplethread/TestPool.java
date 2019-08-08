package multiplethread;

import java.util.concurrent.ThreadPoolExecutor;

public class TestPool {

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();
        int sleep = 1000;

        for (int i = 0; i < 20; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    //System.out.println("执行任务");
                    //任务可能是打印一句话
                    //可能是访问文件
                    //可能是做排序
                }
            };

            pool.add(task);

            try {
                Thread.sleep(sleep);
                sleep = sleep>100?sleep-100:sleep;//速度越来越快
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

}