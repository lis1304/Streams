import java.io.Serializable;

public class TestSerializable implements Serializable{
    String name;
    int count;
    transient int sum;

    public TestSerializable(String name, int count, int sum) {
        this.name = name;
        this.count = count;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "TestSerializable{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", sum=" + sum +
                '}';
    }
}
