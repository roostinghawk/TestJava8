import hashcode.Apple;
import object.Cake;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

public class Application {

    public static void main(String[] args) {

        testHashMap();

    }

    private static void testHashMap(){
        final HashMap<Apple, String> map = new HashMap<>();
        map.put(new Apple(1), "1");
        map.put(new Apple(1), "1");
        System.out.println(map.size());
    }

    private static void testFileScanner(){
        File file = new File("C:\\Users\\lenovo\\Documents\\dumps\\Dump20170918.sql");
        Scanner scanner = null;
        try {
            int count = 0;
            scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                count ++;
                scanner.nextLine();
            }
            scanner.close();
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    private static void testDate(){
        Date date = new Date();
        System.out.println(date);
    }

    private static void testObjecMethod(){
        Cake cake = new Cake();
        cake.setWeight(10);
        cake.setColor("白色");
        Cake cakeClone = cake.clone();
        System.out.println(cakeClone.getWeight());
        System.out.println(cakeClone.getColor());
    }

    private static void testLong(){
        Long sum = 0L;
        System.out.println(sum.hashCode());
        sum += 10;
        System.out.println(sum.hashCode());

    }

    private static void testEqual(){
        System.out.println("abC".equals("Abc"));
        System.out.println(null == null);
        System.out.println(Float.NaN == 0.0f);
    }

    private static void testHashCode(){
        final Apple apple1 = new Apple(1);
        final Apple apple2 = new Apple(1);

        System.out.println(apple1.equals(apple2));
        System.out.println(apple1.hashCode());
        System.out.println(apple2.hashCode());
        System.out.println(apple1 == apple2);

        System.out.println("abc".hashCode());
        System.out.println("abc".hashCode());

        List<Apple> appleList1 = new ArrayList<>();
        appleList1.add(apple1);
        // List的contains，用equal方法。如果两个object相等，那么就算包含
        if(appleList1.contains(apple2)) {
            System.out.println("Contained");
        }

        Map<Apple, String> m = new HashMap<>();
        m.put(new Apple(2), "Liuwei");
        // Map的如果没有覆盖hashcode方法，那么将打印null
        System.out.println(m.get(new Apple(2)));
    }


    private static void testStream(){
        // 测试-流
        List<Transaction> transactions = new ArrayList<Transaction>();
        Currency currencyChina = new Currency();
        currencyChina.setNo("cn");
        currencyChina.setName("人民币");
        Currency currencyUsa = new Currency();
        currencyUsa.setNo("us");
        currencyUsa.setName("美元");
        Transaction transaction1 = new Transaction();
        transaction1.setAmount(1);
        transaction1.setCurrency(currencyChina);
        Transaction transaction2 = new Transaction();
        transaction2.setAmount(100);
        transaction2.setCurrency(currencyUsa);
        Transaction transaction3 = new Transaction();
        transaction3.setAmount(50);
        transaction3.setCurrency(currencyChina);

        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);

        Map<Currency, List<Transaction>> map = transactions.stream()
                .sorted(comparing(Transaction::getAmount))
                .collect(groupingBy(Transaction::getCurrency));

        System.out.println(map);
    }
}
