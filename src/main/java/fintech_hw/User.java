package fintech_hw;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;

public class User {
    private String gender;

    private String title;
    private String firstName;
    private String lastName;
    private String inn;

    private String city;
    private String street;
    private String state;
    private String house;
    private int flat;
    private String postcode;

    private GregorianCalendar dob;
    private int age;

    public String getGender() {
        return gender;
    }
    public void SetGender(String gender){
        if (gender.equals("female")){
            this.gender = "Ж";
        }else{
            this.gender = "М";
        }
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public GregorianCalendar getDob() {
        return dob;
    }

    public void setDob(GregorianCalendar dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAGE(int age) {
        this.age = age;
    }

    public void setFlat() {
        Random rand = new Random();
        int flat = (1 + rand.nextInt(1000));
        this.flat = flat;
    }
    public int getFlat() {
        return flat;
    }
    public void setINN() throws Exception {
        String inn = new String();
        Random rand = new Random();
        ArrayList<Integer> Inn = new ArrayList(12);
        Inn.add(7);
        Inn.add(7);

        int kontrNumber1;
        for(kontrNumber1 = 2; kontrNumber1 < 10; ++kontrNumber1) {
            Inn.add(rand.nextInt(9));
        }

        kontrNumber1 = 0;
        int[] Arr1 = new int[]{7, 2, 4, 10, 3, 5, 9, 4, 6, 8};

        for(int i = 0; i < 10; ++i) {
            kontrNumber1 += Arr1[i] * (Integer)Inn.get(i);
        }
        int k1 = kontrNumber1 % 11;
        Inn.add(k1 % 10);
        int[] Arr2 = new int[]{3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int kontrNumber2 = 0;

        for(int i = 0; i < 11; ++i) {
            kontrNumber2 += Arr2[i] * (Integer)Inn.get(i);
        }

        int k2 = kontrNumber2 % 11;
        Inn.add(k2 % 10);

        int i;
        for(Iterator var11 = Inn.iterator(); var11.hasNext(); inn = inn + i) {
            i = (Integer)var11.next();
        }
        this.inn = inn;
    }
    public String getInn() {
        return inn;
    }
    public void setHouse() {
        Random rand = new Random();
        int house = (1 + rand.nextInt(100));
        this.house = String.valueOf(house);
    }

    public void setDayOfBirth() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1900, 2018);
        gc.set(1, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(6));
        gc.set(6, dayOfYear);
        this.dob = gc;
    }

    public int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (double)(end - start));
    }

    public void setAge(GregorianCalendar dob) {
        GregorianCalendar today = new GregorianCalendar();
        int year1 = today.get(1);
        int year2 = dob.get(1);
        int age = year1 - year2;
        int month1 = today.get(2);
        int month2 = dob.get(2);
        if (month2 > month1) {
            --age;
        } else if (month1 == month2) {
            int day1 = today.get(5);
            int day2 = dob.get(5);
            if (day2 > day1) {
                --age;
            }
        }
        this.age = age;
    }
    public static String getAddress(String filename,int count)throws Exception {
        BufferedReader bufferedReader = new BufferedReader(beginReading(filename));
        Random rand = new Random();
        int num = 1 + rand.nextInt(count);
        String ans = new String();
        for (Integer pointLine = 1; bufferedReader.ready(); pointLine = pointLine + 1) {
            String line = bufferedReader.readLine();
            if (pointLine == num){
                ans = line;
            }
        }
        return ans;
    }

    private static BufferedReader beginReading (String filename) throws Exception {
        File file = new File(filename);
        String encoding = System.getProperty("console.encoding", "Cp1251");
        Reader fileReader = new InputStreamReader(new FileInputStream(file), encoding);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }
    public void setPostcode(){
        Random rand = new Random();
        long postcode = 100000 + rand.nextInt(100000);
        this.postcode = String.valueOf(postcode);
    }

}
