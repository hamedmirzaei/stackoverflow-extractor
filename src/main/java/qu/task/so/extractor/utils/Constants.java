package qu.task.so.extractor.utils;

import qu.task.so.extractor.domain.Settings;

public class Constants {
    public final static String BASE_URL = "https://stackoverflow.com";
    public final static String STACKOVERFLOW_NEWEST_URL = BASE_URL + "/questions/tagged/android";
    public final static String STACKOVERFLOW_MOSTVOTE_URL = BASE_URL + "/questions/tagged/android?tab=Votes";

    public static Settings settings = new Settings("android");
}
