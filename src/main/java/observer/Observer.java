package observer;

public interface Observer {
    //通知变化
    public void update(int totalAttendees, int totalSpeakers, String nameEvent);
}
