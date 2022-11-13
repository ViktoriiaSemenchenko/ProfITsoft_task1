import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


/**
 * (Positive) Create a method that takes an array of integers
 * as input and returns only those that are positive (>=0),
 * sorting them in descending order.
 * Make unit tests for this method.
 *
 * (FoundHashTags) Write a method that accepts as input a list of text strings
 * that may contain hashtags (words beginning with the "#" sign).
 * As a result, the method should return the top-5 most frequently mentioned hashtags
 * with the number of mentions of each of them.
 * Multiple identical hashtags on the same line should count as one mention.
 * Write unit tests for this method.
 *
 * (SortVolume)Implement a method that sorts geometric 3d shapes by volume.
 * The method accepts as a parameter a collection of arbitrary geometric figures
 * (cube, sphere, cylinder).
 * Write unit tests for the method.
 *
 * @author Semenchenko V.
 */
public class Main {
    public static void main(String[] args) {

        int[] array = new int[]{-5, 0, 3, 7, -4, -2, 8, 1, 3, -1};
        System.out.println(Arrays.toString(Positive(array)));

        ArrayList<String> list = new ArrayList<>(5);
        list.add("#My favourite #color #is #orange. It #is so #beautiful");
        list.add("#My name #is Tom. #country.");
        list.add("Ukraine #is a #beautiful #country. It #is #my #country");
        list.add("#My cat #is #orange. #beautiful.");
        list.add("#Beautiful places are #my weakness. #my. #orange");
        System.out.println(FoundHashTags(list));

        Shape cube = new Cube(3.0);
        Shape sphere = new Sphere(8.0);
        Shape cylinder = new Cylinder(2.0, 3.0);

        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(cube);
        shapeList.add(sphere);
        shapeList.add(cylinder);

        System.out.println(SortVolume(shapeList));
    }
    /**
     * Positive
     * Takes an array as input, sorts it in descending order,
     * copies values >= 0 into a separate positiveArray and returns it.
     *
     * @param array - input array
     * @return positiveArray
     */
    public static int[] Positive(int[] array) {
        int count = 0;

        //sort the array
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] < array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }

        //count the number of values to create an array of the required length
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= 0) {
                count++;
            }
        }

        //create new array and copy values to it
        int[] positiveArray = new int[count];
        System.arraycopy(array, 0, positiveArray, 0, count);

        return positiveArray;
    }

    /**
     * FoundHashTags
     * The method returns the top-5 most frequently mentioned hashtags
     * with the number of mentions of each of them.
     *
     * @param list - a list of text strings that may contain hashtags
     * @return topList
     */
    public static Map<String, Integer> FoundHashTags(ArrayList<String> list) {
        Map<String, Integer> hashTags = new HashMap<>();
        List<String> hashTagList = new ArrayList<>();

        //a regular expression
        Pattern pattern = Pattern.compile("[#+][a-zA-Zа-яА-Я0-9]+");

        //found a hashtags and write them down as keys
        for (String str : list) {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                String key = str.substring(matcher.start(), matcher.end()).toLowerCase();
                if (hashTagList.indexOf(key) < 0) {
                    hashTagList.add(key);
                }
            }
        }

        //the number of mentions of the hashtag
        for (String hashTag : hashTagList) {
            int count = 0;
            for (String str : list) {
                if (str.toLowerCase().indexOf(hashTag) > -1) {
                    count++;
                }
            }
            hashTags.put(hashTag, count);
        }

        //top-5 most frequently mentioned hashtags
        Map<String, Integer> topList = new LinkedHashMap<>();
        hashTags.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> topList.put(entry.getKey(), entry.getValue()));

        return topList;
    }

    /**
     * SortVolume
     * The method returns a list of geometric shapes sorted by volume.
     *
     * @param shapeList -collection of geometric shapes
     * @return - SortedList
     */
    public static Map<Shape, Double> SortVolume (List<Shape> shapeList) {

        //create a map and put the object as a key and the volume as a value in it
        Map<Shape, Double> SortVolumeList = new LinkedHashMap<>();
        for (Shape vList: shapeList) {
            double volume;
            volume = vList.Volume();
            SortVolumeList.put(vList, volume);
        }

        //sorted map
        Map<Shape, Double> SortedList = new LinkedHashMap<>();
        SortVolumeList.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> SortedList.put(entry.getKey(), entry.getValue()));

        return SortedList;
    }
}
