
package example.annotation.core.annotation;
public class UserService implements GreetingService{
    private String name;
    private String message;
    private int age;


    public UserService() {
        System.out.println("User Service()");
    }

    public UserService(String name, String message, int age) {
        System.out.println("User Service(String , String , int)");
        this.name = name;
        this.message = message;
        this.age = age;
    }
    public UserService(String name,int age, String message) {
        System.out.println("User Service(String, int, String)");
        this.name = name;
        this.message = message;
        this.age = age;
    }

    public UserService(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Setting Name");
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message)
    {
        System.out.println("Setting message");
        this.message = message;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Setting Age");
        this.age = age;
    }

    @Override
    public String sayGreeting() {
        String greetMessage = this.message + " " + this.name + ", now you have turned "+ this.age;
        return greetMessage;
    }
}
