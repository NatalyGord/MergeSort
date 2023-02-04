import java.util.ArrayList;
import java.util.List;

public class MergeSort {
//проверка отсортирован ли список
    public static boolean isSortInt(ArrayList<Integer> array, String sort) {
        boolean res = true;
        if (sort.equals("-a")) {
            for (int i = 0; i < array.size() - 1; i++) {
                if (array.get(i) > array.get(i + 1)) {
                    res = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < array.size()-1; i++) {
                if (array.get(i) < array.get(i + 1)) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    public static boolean isSortStr(ArrayList<String> array, String sort) {
        boolean res = true;
        if (sort.equals("-a")) {
            for (int i = 0; i < array.size() - 1; i++) {
                if (array.get(i).compareTo(array.get(i + 1)) > 0) {
                    res = false;
                    break;
                }
            }
        } else {
            for (int i = 0; i < array.size() - 1; i++) {
                if (array.get(i).compareTo(array.get(i + 1)) < 0) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

//Слияние Int
    public static void mergeInt(List<Integer> mergerInt1, int startIndex1, List<Integer> mergerInt2, int startIndex2,
                                ArrayList<Integer> mergerIntSort, int startIndex3, String sort) {
        int len = mergerInt1.size() - startIndex1 + mergerInt2.size() - startIndex2;
        boolean endList = false;
        //по возрастанию
        if (sort.equals("-a")) {
            for (int i = startIndex3; i < len + startIndex3; i++) {
                if (((startIndex1 >= mergerInt1.size() || startIndex2 >= mergerInt2.size()) /*&& startIndex1 != startIndex2*/)
                    ||mergerInt1.isEmpty()||mergerInt2.isEmpty() || (endList&& mergerInt1.size() != mergerInt2.size())) {  //когда один из списков закончился
                    if (startIndex1 >= mergerInt1.size() || mergerInt1.isEmpty()) {
                        mergerIntSort.add(mergerInt2.get(startIndex2));
                        startIndex2++;
                        endList = true;
                    } else if (startIndex2 >= mergerInt2.size() || mergerInt2.isEmpty()) {
                        mergerIntSort.add(mergerInt1.get(startIndex1));
                        startIndex1++;
                        endList = true;
                    }
                } else {
                    if (mergerInt1.get(startIndex1) < mergerInt2.get(startIndex2)) {
                        mergerIntSort.add(mergerInt1.get(startIndex1));
                            startIndex1++;
                    } else {
                        mergerIntSort.add(mergerInt2.get(startIndex2));
                            startIndex2++;
                    }
                }
            }
        } else {        //по убыванию
            for (int i = startIndex3; i < len + startIndex3; i++) {
                if (((startIndex1 >= mergerInt1.size() || startIndex2 >= mergerInt2.size()) /*&& startIndex1 !=startIndex2*/)
                ||mergerInt1.isEmpty()||mergerInt2.isEmpty() || (endList&& mergerInt1.size() != mergerInt2.size())){  //когда один из списков закончился
                    if (startIndex1 >= mergerInt1.size()|| mergerInt1.isEmpty()) {
                        mergerIntSort.add(mergerInt2.get(startIndex2));
                        startIndex2++;
                        endList = true;
                    } else if (startIndex2 >= mergerInt2.size() || mergerInt2.isEmpty()) {
                        mergerIntSort.add(mergerInt1.get(startIndex1));
                        startIndex1++;
                        endList = true;
                    }
                } else {
                    if (mergerInt1.get(startIndex1) > mergerInt2.get(startIndex2)) {
                        mergerIntSort.add(mergerInt1.get(startIndex1));
                        startIndex1++;
                    } else {
                        mergerIntSort.add(mergerInt2.get(startIndex2));
                        startIndex2++;
                    }
                }
            }
        }
    }
//Слияние String
    public static void mergeString(ArrayList<String> mergerString1, int startIndex1, ArrayList<String> mergerString2, int startIndex2,
                                   ArrayList<String> mergerStringSort, int startIndex3, String sort) {
        int len = mergerString1.size() - startIndex1 + mergerString2.size() - startIndex2;
        boolean endList = false;
        //по возрастанию
        if (sort.equals("-a")) {
            for (int i = startIndex3; i < len + startIndex3; i++) {
                if (((startIndex1 >= mergerString1.size() || startIndex2 >= mergerString2.size())/*&& startIndex1 != startIndex2*/)
                ||mergerString1.isEmpty()||mergerString2.isEmpty() || (endList && mergerString1.size() != mergerString2.size())){  //когда один из списков закончился
                    if (startIndex1 >= mergerString1.size() || mergerString1.isEmpty()) {
                        mergerStringSort.add(mergerString2.get(startIndex2));
                        startIndex2++;
                        endList = true;
                    } else if (startIndex2 >= mergerString2.size() || mergerString2.isEmpty()) {
                        mergerStringSort.add(mergerString1.get(startIndex1));
                        startIndex1++;
                        endList = true;
                    }
                } else {
                    if (mergerString1.get(startIndex1).compareTo(mergerString2.get(startIndex2)) < 0) {
                        mergerStringSort.add(mergerString1.get(startIndex1));
                        startIndex1++;
                    } else {
                        mergerStringSort.add(mergerString2.get(startIndex2));
                        startIndex2++;
                    }
                }
            }
        } else {    //по убыванию
            for (int i = startIndex3; i < len + startIndex3; i++) {
                if (((startIndex1 >= mergerString1.size() || startIndex2 >= mergerString2.size())/*&& startIndex1 != startIndex2*/)
                ||mergerString1.isEmpty()||mergerString2.isEmpty() || (endList && mergerString1.size() != mergerString2.size())){  //когда один из списков закончился
                    if (startIndex1 >= mergerString1.size()||mergerString1.isEmpty()) {
                        mergerStringSort.add(mergerString2.get(startIndex2));
                        startIndex2++;
                        endList = true;
                    } else if (startIndex2 >= mergerString2.size()||mergerString2.isEmpty()) {
                        mergerStringSort.add(mergerString1.get(startIndex1));
                        startIndex1++;
                        endList = true;
                    }
                } else {
                    if (mergerString1.get(startIndex1).compareTo(mergerString2.get(startIndex2)) > 0) {
                        mergerStringSort.add(mergerString1.get(startIndex1));
                        startIndex1++;
                    } else {
                        mergerStringSort.add(mergerString2.get(startIndex2));
                        startIndex2++;
                    }
                }
            }
        }
    }

//Сортировка Int
    public static void sortInt(ArrayList<Integer> list, String sort) {
        int sizeList = list.size();
        ArrayList<Integer> mergerIntSort = new ArrayList<>();
        ArrayList<Integer> resList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        int len1 = 1;
        while (len1 < sizeList) {
            for (int i=0; i < list.size(); i += len1 * 2) {
                if(i+len1*2 <= list.size()-list.size()%(len1*2)) {
                    list1.addAll(list.subList(i, i + len1));
                    list2.addAll(list.subList(i + len1, i + len1 * 2));
                }
                else {
                    if(list.size()%(len1*2) <= len1 ){
                        list1.addAll(list.subList(i, i+len1-list.size()%len1));
                    }
                    else {
                        list1.addAll(list.subList(i, i+len1));
                        list2.addAll(list.subList(i + len1, list.size()));
                    }
                }
                mergeInt(list1, 0, list2, 0, mergerIntSort, 0, sort);

                resList.addAll(mergerIntSort);  //!!
                mergerIntSort.clear();
                list1.clear();
                list2.clear();
            }
            len1 = len1 * 2;
            list.clear();
            list.addAll(resList);
            resList.clear();
        }
    }
    public static void sortInt(ArrayList<Integer> list) {
        sortInt(list, "-a");
    }

//Сортировка String
    public static void sortString(ArrayList<String> list, String sort) {
        int sizeList = list.size();
        ArrayList<String> mergerIntSort = new ArrayList<>();
        ArrayList<String> resList = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        int len1 = 1;
        while (len1 < sizeList) {
            for (int i=0; i < list.size(); i += len1 * 2) {
                if(i+len1*2 <= list.size()-list.size()%(len1*2)) {
                    list1.addAll(list.subList(i, i + len1));
                    list2.addAll(list.subList(i + len1, i + len1 * 2));
                }
                else {
                    if(list.size()%(len1*2) <= len1 ){
                        list1.addAll(list.subList(i, i+len1-list.size()%len1));
                    }
                    else {
                        list1.addAll(list.subList(i, i+len1));
                        list2.addAll(list.subList(i + len1, list.size()));
                    }
                }
                mergeString(list1, 0, list2, 0, mergerIntSort, 0, sort);
                resList.addAll(mergerIntSort);
                mergerIntSort.clear();
                list1.clear();
                list2.clear();

            }
            len1 = len1 * 2;
            list.clear();
            list.addAll(resList);
            resList.clear();
        }
    }
    public static void sortString(ArrayList<String> list) {
        sortString(list, "-a");
    }
}
