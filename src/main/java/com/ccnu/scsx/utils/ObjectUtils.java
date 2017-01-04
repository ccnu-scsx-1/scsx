package com.ccnu.scsx.utils;

import java.util.Collection;

public class ObjectUtils {
  public static boolean isEmpty(String arg) {
    return arg == null || arg.isEmpty();
  }

  public static boolean isNotEmpty(String arg) {
    return arg != null && arg.length() > 0;
  }

  public static boolean isEmpty(Object[] arg) {
    return arg == null || arg.length == 0;
  }

  public static boolean isNotEmpty(Object[] arg) {
    return arg != null && arg.length > 0;
  }

  public static boolean isEmpty(Collection<?> list) {
    return list == null || list.isEmpty();
  }

  public static boolean isNotEmpty(Collection<?> list) {
    return list != null && list.size() > 0;
  }

  public static boolean hasText(String text) {
    return text != null && text.trim().length() > 0;
  }

}
