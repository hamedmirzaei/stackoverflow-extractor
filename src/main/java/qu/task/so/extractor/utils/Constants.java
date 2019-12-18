package qu.task.so.extractor.utils;

import qu.task.so.extractor.domain.Settings;

public class Constants {
    public final static String BASE_URL = "https://stackoverflow.com";
    public final static String STACKOVERFLOW_NEWEST_URL = BASE_URL + "/questions/tagged/android?sort=Newest";
    public final static String STACKOVERFLOW_MOSTVOTE_URL = BASE_URL + "/questions/tagged/android?sort=Votes";

    public final static String STACKOVERFLOW_PARAMETRIC_URL = BASE_URL + "/questions/tagged/MY_TOPIC?sort=MY_TYPE";

    public static Settings settings = new Settings("Newest", "android");
}
