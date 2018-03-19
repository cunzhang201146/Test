package com.example.yangpan.logutils;

import android.util.Log;

/**
 * Created by yangpan on 2018/3/15.
 */

public class LogUtils {
    public static int d(String tag, String msg) {


        return Log.d(tag, new DebugInfo() + msg);
    }

    static class DebugInfo extends Exception {
        public int line() {
            StackTraceElement[] trace = getStackTrace();
            if (trace == null || trace.length == 0) {
                return -1;
            }
            return trace[0].getLineNumber();
        }

        public String fun() {
            StackTraceElement[] trace = getStackTrace();
            if (trace == null || trace.length == 0) {
                return "";
            }
            return trace[1].getMethodName();
        }

        public DebugInfo() {
            super();
        }

        @Override
        public String toString() {
            return line() + "|" + fun() + "|";
        }
    }
}
