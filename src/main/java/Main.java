import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//Получение данных из коммандной строки
        ParserCommandLine pr = new ParserCommandLine();
        pr.parse(args);
        String[] namesIn = pr.getNamesIn(); //массив исходных файлов
        String sort = pr.getSort(); //по умолчанию по возрастанию
        String type = pr.getType(); //тип данных
        String nameOut = pr.getNameOut(); //имя выходного файла
        ArrayList<Integer> mergerInt1 = new ArrayList<>();
        ArrayList<Integer> mergerInt2 = new ArrayList<>();
        ArrayList<Integer> mergerIntSort = new ArrayList<>();
        ArrayList<String> mergerString1 = new ArrayList<>();
        ArrayList<String> mergerString2 = new ArrayList<>();
        ArrayList<String> mergerStringSort = new ArrayList<>();
        int numberOfFiles = 0; //индекс входящего файла

// чтение файлов, запись их в ArrayList
        //1
        if (type.equals("-i")) {
            ReadingFile.readFile(namesIn, type, mergerInt1, numberOfFiles);
            numberOfFiles++;
        } else {
            ReadingFile.readFile(namesIn, type, mergerString1, numberOfFiles);
            numberOfFiles++;
        }
        //2
        for (int i = 1; i < namesIn.length; i++) {
            if (type.equals("-i")) {
                ReadingFile.readFile(namesIn, type, mergerInt2, numberOfFiles);
                numberOfFiles++;
            } else {
                ReadingFile.readFile(namesIn, type, mergerString2, numberOfFiles);
                numberOfFiles++;
            }

//Проверяем отсортированы ли списки, если нет -> сортируем, если отсортированы делаем слияние
            if (type.equals("-s")) {
                while (true) {
                    if (MergeSort.isSortStr(mergerString1, sort) && MergeSort.isSortStr(mergerString2, sort)) {
                        MergeSort.mergeString(mergerString1, 0, mergerString2, 0, mergerStringSort, 0, sort);
                        break;
                    } else {
                        if(!MergeSort.isSortStr(mergerString1, sort)){
                           MergeSort.sortString(mergerString1, sort);
                        }
                        if(!MergeSort.isSortStr(mergerString2, sort)){
                            MergeSort.sortString(mergerString2, sort);
                        }
                    }
                }
            } else {
                while (true) {
                    if (MergeSort.isSortInt(mergerInt1, sort) && MergeSort.isSortInt(mergerInt2, sort)) {
                        MergeSort.mergeInt(mergerInt1, 0, mergerInt2, 0, mergerIntSort, 0, sort);
                        break;
                    } else {
                        if (!MergeSort.isSortInt(mergerInt1, sort)) {
                            MergeSort.sortInt(mergerInt1, sort);
                        }
                        if (!MergeSort.isSortInt(mergerInt2, sort)) {
                            MergeSort.sortInt(mergerInt2, sort);
                        }
                    }
                }
            }
            if (type.equals("-i")) {
                mergerInt1.clear();
                mergerInt1.addAll(mergerIntSort);
                mergerInt2.clear();
                mergerIntSort.clear();
            } else {
                mergerString1.clear();
                mergerString1.addAll(mergerStringSort);
                mergerString2.clear();
                mergerStringSort.clear();
            }
        }
//Запись в файл
        if (type.equals("-i")) {
            WritingFile.writerFile(type,nameOut,mergerInt1);

            //---------------
            System.out.println();
            for (Integer in : mergerInt1) {
                System.out.print(in + ", ");
            }
            System.out.println();
            System.out.println("Ok");
            //------------
        } else {
            WritingFile.writerFile(type,nameOut,mergerString1);

            //--------------
            System.out.println();
            for (String str : mergerString1) {
                System.out.print(str + ", ");
            }
            System.out.println();
            System.out.println("Ok");
            //------------
        }
    }
}
