package com.redrock.date2.config;

/**
 * Created by zhuchenxi on 15/8/2.
 */
public class API {
    public static final class URL {
        public static final String BASEURL = "http://123.56.225.103/api/index.php?s=/api/";

        public static final String Register = BASEURL + "public/register";
        public static final String Login = BASEURL + "public/login";
        public static final String Pwdfind = BASEURL + "account/pwdfind";
        public static final String Certification = BASEURL + "account/verify";
        public static final String DateList = BASEURL + "date/datefilter";
        public static final String DateType = BASEURL + "public/datetype";

        public static String QiniuToken = "";
        //user
        public static final String getCollectList = BASEURL + "user/collection";
        public static final String getLetterList = BASEURL + "user/getletter";
        public static final String postLetter = BASEURL + "user/postletter";
        public static final String getMyDateList = BASEURL + "user/mydatelist";
        public static final String getMyJoinedDateList = BASEURL + "user/joineddatelist";
        public static final String getAttendCount = BASEURL + "user/carenum";
        public static final String getMyAttendPerson = BASEURL + "user/care";
        public static final String addCare = BASEURL + "user/addcare";
        public static final String delCare = BASEURL + "user/delcare";
        public static final String modifyFace = BASEURL + "user/editavatar";
        public static final String modifySign = BASEURL + "user/editsignature";
        public static final String modifyHobby = BASEURL + "user/edithobby";
        public static final String modifyPassword = BASEURL + "user/editpassword";
        public static final String searchUser = BASEURL + "user/search";
        public static final String searchHotUser = BASEURL + "user/hotsearch";

        //date
        public static final String getDateList = BASEURL + "date/datelist";
        public static final String dateFilter = BASEURL + "date/datefilter";
        public static final String getDateDetail = BASEURL + "date/detaildate";
        public static final String publishDate = BASEURL + "date/createdate";
        public static final String dealDate = BASEURL + "date/judgedate";
        public static final String applyDate = BASEURL + "date/applydate";
        public static final String collectDate = BASEURL + "date/collectdate";
        public static final String commentDate = BASEURL + "date/commentdate";


        //discover
        public static final String getDiscoverList = BASEURL + "discover/discoverlist";

        //public
        public static final String getBanner = BASEURL + "public/banner";
        public static final String getSchool = BASEURL + "public/school";
        public static final String getUserData = BASEURL + "user/info";  //获取某个人信息
    }

    public static class KEY {
        public static final String STATUS = "status";
        public static final String INFO = "info";
        public static final String DATA = "data";
    }

    public static class CODE {
        public static final int SUCCEED = 0;
        public static final int PARAMS_ERROR = 1;
        public static final int SERVER_ERROR = 1001;
        public static final int LOGINSTATUS_DENIED = 1002;
        public static final int ACCOUNT_DENIED = 1002;
        public static final int PARAMS_INVALID = -1;
        public static final int PERMISSION_DENIED = -3;
    }
}
