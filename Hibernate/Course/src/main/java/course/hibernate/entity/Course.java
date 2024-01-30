package course.hibernate.entity;

public class Course {
    private int courseId;
    private String name;
    private String provider;
    private int duration;
    private int fees;

    public Course(){}
    public Course(int courseId, String name, String provider, int duration, int fees) {
        this.courseId = courseId;
        this.name = name;
        this.provider = provider;
        this.duration = duration;
        this.fees = fees;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", name='" + name + '\'' +
                ", provider='" + provider + '\'' +
                ", duration=" + duration +
                ", fees=" + fees +
                '}';
    }
}
