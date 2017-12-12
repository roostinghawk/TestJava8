package hashcode;

public class Apple {

    private int count;

    public Apple(int count) {
        this.count = count;
    }

    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        } else if (this == obj) {
            return true;
        } else if (!this.getClass().equals(obj.getClass())) {
            return false;
        } else {
            Apple apple = (Apple) obj;
            if(this.count == apple.count) {
                return true;
            }
        }

        return false;
    }

    public int hashCode(){
        return Integer.hashCode(count);
    }
}
