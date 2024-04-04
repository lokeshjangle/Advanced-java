package example.annotation.core.annotation.autowiring;

public class MusicSystem {

    private String make;
    private String soundEffect;
    public MusicSystem(){
        this.make = "Sony";
        this.soundEffect = "Dolby";
    }

    public MusicSystem(String make, String soundEffect) {
        this.make = make;
        this.soundEffect = soundEffect;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getSoundEffect() {
        return soundEffect;
    }

    public void setSoundEffect(String soundEffect) {
        this.soundEffect = soundEffect;
    }

    @Override
    public String toString() {
        return "MusicSystem{" +
                "make='" + make + '\'' +
                ", soundEffect='" + soundEffect + '\'' +
                '}';
    }
}
