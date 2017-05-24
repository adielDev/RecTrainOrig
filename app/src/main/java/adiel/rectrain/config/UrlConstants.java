package adiel.rectrain.config;

public class UrlConstants
{

    public static final String AWS_ACCOUNT_ID = "069157535684";
    public static final String COGNITO_POOL_ID = "us-east-1:507a4bd9-1b92-43db-be21-505952665ef9";
    public static final String COGNITO_ROLE_UNAUTH = "";
    public static final String COGNITO_ROLE_AUTH = "arn:aws:iam::069157535684:role/auth_user_dev_role";
    public static final String BUCKET_NAME = "recntrek.com";
    public static final String REGISTRATION__RNT = "6";
    public static final String REGISTRATION__FB = "3";
    public static final String fbURL = "/reg/fb";
    public static final String googleURL = "/reg/google";
    public static final String rntRegURL = "/reg/rnt";
    public static final String rntLoginURL = "/reg/login";
    public static final String trekSync = "/trek-sync";
    public static final String newTrek = "/start";
    public static final String stopTrek = "/stop";
    public static final String resetRecordingState = "/reset-state";
    public static final String syncTrek = "/sync";
    public static final String uploadMedia = "/media";
    public static final String trekDownload ="/trek";
    public static final String privacyURL = "/user/privacy";
    public static final String CHAT_LIST = "/msg/chat-list";
    public static final String CHAT_MSGS = "/msg/get-chat";
    public static final String CHAT_HEADER = "/msg/get-header";
    public static final String SEND_MSG = "/msg/send-msg";


    public static final String trekSearch = "/search";
    public static final int fbRegistration = 1;
    public static final int rntRegistration = 2;
    public static final int rntLogin = 3;
    public static final int fullFileSync = 1;


//    public static String trekMapsDownload = RntConfig.ServerUrl+"/trek/maps?trek_id=";
//    public static String siteMapsDownload = RntConfig.ServerUrl+"/site/maps?site_id=";
//    public static String deleteTrek = RntConfig.ServerUrl + "/trek/delete";
//    public static String siteDownload = "/site";
//    public static String editTrek = RntConfig.ServerUrl + "/trek/edit";
//    public static String editTrekMedia = RntConfig.ServerUrl + "/trek/edit-media";

    public static String notifyMediaServerComplete ="/media/intent?trek_id=";
    public static String logout = "/user/logout";
}
