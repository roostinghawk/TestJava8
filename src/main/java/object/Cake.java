package object;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cake implements Cloneable {

    private int weight;

    private String color;

    @Override
    public Cake clone(){
        try {
            Cake c = (Cake)super.clone();
            // 不需要下面的设置就可以拷贝属性了
//            c.setColor(this.color);
//            c.setWeight(this.weight);

            return c;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }

}
