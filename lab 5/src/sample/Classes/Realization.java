package sample.Classes;

import java.io.*;
import java.util.ArrayList;

public class Realization implements Serializable{
    File file;
public Realization(){}
    public Realization(String pathname){
        file = new File(pathname);
    }
    public String New(Cars cars) throws IOException {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (fileOutputStream != null) {
                oos = new ObjectOutputStream(fileOutputStream);
                oos.writeObject(cars.list2);
                return "Запись прошла успешно";
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(oos!=null) {
                try {
                    oos.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return "Ошибка записи в файл";
    }

    public String Deserialization(Cars cars) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        try {
            cars.list2=(ArrayList)ois.readObject();
            return "Чтение прошло успешно";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Ошибка чтения из файла";
    }
}
