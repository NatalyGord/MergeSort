import static java.lang.System.exit;

public class ParserCommandLine {
    private int len = 0;
    private int numberOfFiles = 0; //количество исходных файлов
    private String[] namesIn; //массив исходных файлов
    private String sort = "-a"; //по умолчанию по возрастанию
    private String type = "";
    private String nameOut = "";

//парсинг аргументов командной строки
    public void parse(String[] args) {
        len = args.length;
        numberOfFiles = len - 2; //количество исходных файлов
        namesIn = new String[numberOfFiles]; //массив исходных файлов

        if (args[0].equals("-d") || args[0].equals("-a") || args[0].equals("-s") || args[0].equals("-i")) {
            if (args[0].equals("-d")) {
                sort = "-d";
            } else if (args[0].equals("-a")) {
                sort = "-a";
            } else if (args[0].equals("-s")) {
                type = "-s";
            } else if (args[0].equals("-i")) {
                type = "-i";
            }

            if (args[1].equals("-d") || args[1].equals("-a") || args[1].equals("-s") || args[1].equals("-i")) {

                if (args[1].equals("-d")) {
                    sort = "-d";
                } else if (args[1].equals("-a")) {
                    sort = "-a";
                } else if (args[1].equals("-s")) {
                    type = "-s";
                } else if (args[1].equals("-i")) {
                    type = "-i";
                }
                nameOut = args[2];
                numberOfFiles = len - 3;
                namesIn = new String[numberOfFiles];
                for (int i = 3, j = 0; i < len; i++, j++) {
                    namesIn[j] = args[i];
                }
            } else {
                nameOut = args[1];
                for (int i = 2, j = 0; i < len; i++, j++) {
                    namesIn[j] = args[i];
                }
            }
        } else {
            System.out.println("Ошибочные параметры.");
            exit(-1);
        }
    }

    public String[] getNamesIn() {
        return namesIn;
    }

    public String getSort() {
        return sort;
    }

    public String getType() {
        return type;
    }

    public String getNameOut() {
        return nameOut;
    }
}
