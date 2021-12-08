import java.io.Serializable;

public class Monitor implements Serializable {
    int width;
    int height;
    String name;

    public Monitor(String name, int width, int height) {
        this.width = width;
        this.height = height;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Device{" +
                "width=" + width +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }
}
