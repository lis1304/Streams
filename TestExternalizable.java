import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by LIS on 04.12.2017.
 */
public class TestExternalizable implements Externalizable {
     String name;
     int count;

    public TestExternalizable(String name, int count) {
        this.name = name;
        this.count = count;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(count);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        count = in.readInt();
    }

    @Override
    public String toString() {
        return "TestExternalizable{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
