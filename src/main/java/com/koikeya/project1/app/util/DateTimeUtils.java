package com.koikeya.project1.app.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

import org.springframework.stereotype.Component;

/**
 * 日時ユーティリティクラス
 *
 * @author user
 *
 */
@Component
public class DateTimeUtils {

    /**
     * コンストラクタ
     */
    public DateTimeUtils() {
        super();
    }

    /**
     * 日本の年（西暦）を整数で取得する
     *
     * @return 日本の年（西暦）の整数
     */
    public static int fetchYear() {
        return LocalDateTime.now().getYear();
    }

    /**
     * 日本の現在日時を取得する
     *
     * @return 日本の現在日時（yyyy-MM-dd HH:mm:ss形式）
     */
    public static String fetchTime() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.JAPAN).format(LocalDateTime.now().
          truncatedTo(ChronoUnit.SECONDS));
    }
    /**
     * 日本の30分前の現在日時を取得する
     *
     * @return 日本の30分前の現在日時（yyyy-MM-dd HH:mm:ss形式）
     */
    public static String fetchTimeThirtyMinutesAgo() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.JAPAN).format(LocalDateTime.now()
          .minusMinutes(30).truncatedTo(ChronoUnit.SECONDS));
    }
}
