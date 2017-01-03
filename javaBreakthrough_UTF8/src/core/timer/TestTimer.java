package core.timer;

import java.util.Timer;
import java.util.TimerTask;

/**   
* @author lzw   
* @date 2016年12月2日 下午5:05:28 
* @Description: 
* @version V1.0   
*/
public class TestTimer {
	public static void main(String[] args) {
		Timer timer = new Timer(); 
	     timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("我是定时任务");
			}
		}, 3*1000,1*1000);
	     
	     
//	     public void schedule(TimerTask task,long delay,long period)
//	     public void schedule(TimerTask task,Date time)
	}
}
