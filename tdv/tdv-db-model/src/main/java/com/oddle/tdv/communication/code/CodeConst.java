package com.oddle.tdv.communication.code;

public class CodeConst {
    public static int UNKNOWN_ERR = -1;

    public static int CODE_ID_IS_NOT_NULL = 1010;
    public static String MSG_ID_IS_NOT_NULL = "Id(%d) must be NULL";

    public static int CODE_CITY_NAME_EXIST = 1011;
    public static String MSG_CITY_NAME_EXIST = "City with name = '%s' exist";

    public static int CODE_CITY_ID_IS_NULL = 1012;
    public static String MSG_CITY_ID_IS_NULL = "City ID must not be NULL";

    public static int CODE_CITY_ID_IS_NOT_EXIST = 1013;
    public static String MSG_CITY_ID_IS_NOT_EXIST = "City with ID = '%d' must be exist";
}
