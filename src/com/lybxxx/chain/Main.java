package com.lybxxx.chain;

import com.lybxxx.chain.model.Person;


import javax.sql.ConnectionPoolDataSource;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.time.DayOfWeek;
import java.util.*;

/**
 * @author lybxxx
 */
public class Main {
    public static void main(String[] args) {







        List<Person> linkedList = new LinkedList<>();
        linkedList.add(new Person("wyx",20));
        linkedList.add(new Person("lyb",21));
        linkedList.add(new Person("xxx",20));
        System.out.println(linkedList);
        Collections.shuffle(linkedList);
        System.out.println("洗牌后："+linkedList);

        List<Person> unList = Collections.unmodifiableList(linkedList);
        linkedList.add(new Person("www",20));

        System.out.println(unList);

        Queue<Person> queue = new LinkedList<>();
        Queue<Person> queue1 = new PriorityQueue<>();
        Deque<Person> deque = new LinkedList<>();
        Deque<Person> deque1 =new ArrayDeque<>();
        queue.offer(new Person("lyb",20));
        queue.add(new Person("wyx",2));
        queue.poll();
        queue.poll();


        List<String> list2 = Collections.emptyList();

        List<String> list3 = Collections.singletonList("lyb");
        list3 = Collections.singletonList("wyx");
        System.out.println("!!!!!"+list3);
        System.out.println(list2);

        List<Person> list = new LinkedList<>();
        List<Person> list1 = new ArrayList<>();


        List<Person> arrayList = new ArrayList<>();
        Map<String,Person> map =  new HashMap<>(0);
        Person lyb = new Person("lyb",20);
        Person lyb2 = new Person("lyb",20);
        Person wyx = new Person("wyx",20);
        map.put("lyb",lyb);
        map.put("wyx",wyx);

        System.out.println(lyb.hashCode());
        System.out.println(lyb2.hashCode());
        for(String key : map.keySet()){

            Person person1 = map.get(key);
            System.out.println(person1.toString());
        }

        for(Map.Entry<String,Person> entry: map.entrySet()){
            String key = entry.getKey();
            Person person1 = entry.getValue();
            System.out.println(key+":"+person1.toString());
        }


        Map<DayOfWeek, String> enumMap = new EnumMap<>(DayOfWeek.class);
        enumMap.put(DayOfWeek.MONDAY, "星期一");
        enumMap.put(DayOfWeek.TUESDAY, "星期二");
        enumMap.put(DayOfWeek.WEDNESDAY, "星期三");
        enumMap.put(DayOfWeek.THURSDAY, "星期四");
        enumMap.put(DayOfWeek.FRIDAY, "星期五");
        enumMap.put(DayOfWeek.SATURDAY, "星期六");
        enumMap.put(DayOfWeek.SUNDAY, "星期日");
        System.out.println(enumMap);
        System.out.println(enumMap.get(DayOfWeek.MONDAY));
        System.out.println(enumMap.getClass());
        System.out.println(map.getClass());



        Map<Person,String> treeMap = new TreeMap<>();
        treeMap.put(new Person("lyb",21),"lyb");
        treeMap.put(new Person("wyx",20),"wyx");
        treeMap.put(new Person("xxx",22),"xxx");
        for (Map.Entry<Person,String> entry:treeMap.entrySet()){
            Person key = entry.getKey();
            String person = entry.getValue();
            System.out.println(key.toString()+":"+person);
        }


        String settings = "# test" + "\n" + "course=Java" + "\n" + "last_open_date=2019-08-07T12:35:01";
        try{
            ByteArrayInputStream input = new ByteArrayInputStream(settings.getBytes("UTF-8"));
            Properties props = new Properties();
            props.load(input);

            System.out.println("course: " + props.getProperty("course"));
            System.out.println("last_open_date: " + props.getProperty("last_open_date"));
            System.out.println("last_open_file: " + props.getProperty("last_open_file"));
            System.out.println("auto_save: " + props.getProperty("auto_save", "60"));
        }catch (Exception e){}


        Set<Person> set = new HashSet<>();
        set.add(new Person("lyb",20));
        set.add(new Person("wyx",20));
        set.add(new Person("lyb",20));
        set.addAll(linkedList);
        System.out.println(set.size());
        for(Person p : set){
            System.out.println(p.toString());
        }




        String string = hexToString(15);
        System.out.println(string);


    }
    public static String hexToString(int n) {
       Stack<String> hexstrings = new Stack<>();

        while (n != 0){
            int m = n % 16;
            String s = Integer.toHexString(m);

            n = n / 16;

        }
        String result = "";
        while (!hexstrings.isEmpty()){
            result = result + hexstrings.pop();
        }

        return result;
    }


}
