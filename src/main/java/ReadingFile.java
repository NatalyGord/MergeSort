import java.io.*;
import java.util.ArrayList;

public class ReadingFile {
// чтение файлов
    public static void readFile(String[] namesIn, String type, ArrayList merger, int numberOfFiles) {
        try {
            File file = new File(namesIn[numberOfFiles]);
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line;
            int k = 0;
            while (true) {
                line = reader.readLine();
                if (type.equals("-i")) {
                    try {
                        merger.add(Integer.parseInt(line));
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                } else {
                    try {
                        merger.add(line);
                        break;
                    } catch (Exception e) {
                        System.out.println("Ошибка, неверные данные в файле: " + e.getMessage());
                        continue;
                    }
                }
            }
            while (line != null) {
                // считываем остальные строки в цикле
                while (true) {
                    line = reader.readLine();
                    if (line != null) {
                        if (type.equals("-i")) {
                            try {
                                merger.add(Integer.parseInt(line));
                                break;
                            } catch (Exception e) {
                                System.out.println("Ошибка, неверные данные в файле: " + e.getMessage());
                                continue;
                            }
                        } else {
                            try {
                                merger.add(line);
                                break;
                            } catch (Exception e) {
                                System.out.println("Ошибка, неверные данные в файле: " + e.getMessage());
                                continue;
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
            fr.close();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден " + e.getMessage());    //файл не найден
        } catch (IOException e) {
            System.out.println("Ошибка " + e.getMessage());    //ошибка ввода-вывода
        }
    }
}

