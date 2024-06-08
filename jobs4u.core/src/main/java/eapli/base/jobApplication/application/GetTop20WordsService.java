package eapli.base.jobApplication.application;

import eapli.base.jobApplication.utils.WordCounterRunnable;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class GetTop20WordsService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private static Map<String, List<String>> wordsAndItsLocation = new TreeMap<>();

    public static Map<String, List<String>> getTop20WordsAndItsLocation(String jobReference, String candidateEmail) {
        File path = new File("C:\\Users\\jorge\\repos\\JobApplications-lapr4\\" + jobReference + "\\" + candidateEmail);

        List<String> allSubmitedFiles = getAllFilesFromPath(path);

        createAndExecuteThreads(allSubmitedFiles);

        return getTop20(wordsAndItsLocation);

    }

    private static Map<String, List<String>> getTop20(Map<String, List<String>> wordsAndItsLocation) {
        return wordsAndItsLocation.entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .limit(20)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }


    private static void createAndExecuteThreads(List<String> files) {

        for(int i = 0; i < files.size(); i++){
            WordCounterRunnable wcr = new WordCounterRunnable(wordsAndItsLocation, files.get(i));
            Thread t = new Thread(wcr, "Thread - " + i);
            t.start();
        }

    }

    private static List<String> getAllFilesFromPath(File path) {
        List<String> allFilesFromPath = new ArrayList<>();

        File[] listOfFiles = path.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                allFilesFromPath.add(path + "\\" + file.getName());
            }
        }

        return allFilesFromPath;
    }

    public static void main(String[] args) {
        Map <String, List<String>> top20 = getTop20WordsAndItsLocation("IBM-000001", "janefoster@marvel.com");
        printMap(top20);
    }

    private static void printMap(Map<String, List<String>> map) {
        map.forEach((word, locations) ->
                System.out.println(word + ": " + locations.size() + " occurrences in files " + locations));
    }


}
