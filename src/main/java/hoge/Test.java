package hoge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {

    static Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {
        PasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();

        logger.info("パスワードを入力してください");
        String encodedpassword = passwordEncoder.encode(promptPassword());
        logger.info("パスワード = " + encodedpassword);
    }

    public static String promptPassword() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String password = bufferedReader.readLine();
            return password;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
