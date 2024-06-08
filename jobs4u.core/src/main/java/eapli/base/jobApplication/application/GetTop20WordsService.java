package eapli.base.jobApplication.application;

import eapli.base.jobApplication.utils.WordCounterRunnable;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class GetTop20WordsService {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final String filesPath = "\\\\wsl.localhost\\Ubuntu\\home\\jorge\\ISEP\\SCOMP\\us2001\\output_dir";

    private Map<String, List<String>> wordsAndItsLocation = new TreeMap<>();

    public Map<String, List<String>> getTop20WordsAndItsLocation(String jobReference, String candidateEmail) {
        File path = new File(filesPath + "\\" + jobReference + "\\" + candidateEmail);

        if (!path.exists() || !path.isDirectory()) {
            System.out.println("The specified path does not exist or is not a directory: " + path);
            return Collections.emptyMap();
        }

        List<String> allSubmitedFiles = getAllFilesFromPath(path);

        createAndExecuteThreads(allSubmitedFiles);

        return getTop20(wordsAndItsLocation);

    }

    private Map<String, List<String>> getTop20(Map<String, List<String>> wordsAndItsLocation) {
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


    private void createAndExecuteThreads(List<String> files) {

        List<Thread> threads = new ArrayList<>();

        for(int i = 0; i < files.size(); i++){
            WordCounterRunnable wcr = new WordCounterRunnable(wordsAndItsLocation, files.get(i));
            Thread t = new Thread(wcr, "Thread - " + i);
            t.start();
            threads.add(t);
        }

        for(Thread t : threads){
            try{
                t.join();
                System.out.println(t.getName() + " finished.");
            }catch (InterruptedException e) {
                e.printStackTrace();
                t.interrupt();
            }
        }

        System.out.println("Threads closed successfully.");

    }

    private List<String> getAllFilesFromPath(File path) {
        List<String> allFilesFromPath = new ArrayList<>();

        File[] listOfFiles = path.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                allFilesFromPath.add(path + "\\" + file.getName());
            }
        }

        return allFilesFromPath;
    }


}
