package com.zzuli.home.util;

import com.zzuli.home.AppConstants;
import com.zzuli.home.AppContext;


public class PathUtil {

    public static String getFullPath(String path) {
        if (path == null) {
            path = "";
        }
        
        String urlPrefix = AppConstants.APP_URL_PREFIX;
        if (!StringUtil.isEmpty(urlPrefix)) {
            urlPrefix += "/";
        }

        return AppContext.getContextPath()+ "/" + urlPrefix  + path;
    }

}
