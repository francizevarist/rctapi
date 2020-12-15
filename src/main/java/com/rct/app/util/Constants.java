package com.rct.app.util;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Constants {
    public static class Status{
        public final static Integer TRUE = 1;
        public final static Integer FALSE = 0;
    }

    public static class DefaultTime{
        public final static Long DEFAULT_TIME = 0L;
    }

    public static class Data{
        public final static String EMPTY_STRING = "";
        public final static Integer NO_VALUE = 0;
    }

    public static class Token{
        public final static String  FORMAT_TOKEN = "Bearer ";
        public final static Integer EXPIRE_TIME = 60*120; //seconds
        public final static String reformat(String token){
            return token.replace(Constants.Token.FORMAT_TOKEN,Constants.Data.EMPTY_STRING);
        }
    }

    public static class Twilio{
        public final static String ACCOUNT_SID = "ACe0a037a76a37341757350bb301e7ae48";
        public final static String AUTH_TOKEN = "11223a221df5a76bd78279c257bbf5fa";
        public final static String SENDER_NUMBER = "+17755263501";
        public final static Long CODE_LIFE_TIME = 900000L;
    }

    public static class OTP{
        public final static Integer EXPIRE_TIME = 60*5;
    }

    public static class GradesScale{
        private static final List<Rice> GRADE_LIST = Arrays.asList(
                new Rice("Large",1),
                new Rice("Medium",2),
                new Rice("Small",3)
        );
        static class Rice{
            private String name;
            private Integer value;

            public Rice(String name, Integer value) {
                this.name = name;
                this.value = value;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getValue() {
                return value;
            }

            public void setValue(Integer value) {
                this.value = value;
            }
        }
    }

    public static class Grades{
        private static final List<Rice> GRADE_LIST = Arrays.asList(
                new Rice("Grade A",1),
                new Rice("Grade B",2),
                new Rice("Grade C",3)
        );
        static class Rice{
            private String name;
            private Integer value;

            public Rice(String name, Integer value) {
                this.name = name;
                this.value = value;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getValue() {
                return value;
            }

            public void setValue(Integer value) {
                this.value = value;
            }
        }
    }

    public static class ApplicationType{

        private static final List<Grades.Rice> GRADE_LIST = Arrays.asList(
                new Grades.Rice("Induvidual",1),
                new Grades.Rice("Company",2),
                new Grades.Rice("Association",3)
        );

        static class Rice{
            private String name;
            private Integer value;
        }

        public ApplicationType() {
            super();
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }
    }

    public static Long secToMillSec(Integer expireTime){
        return 1000L * expireTime;
    }

    public static class Profle{
        public final  static String SIGNATURE = MD5(String.valueOf(UUID.randomUUID()));
        public final  static Integer DEFAULT_MATURITY_RATING = 18;
    }

    public static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public static String EXTRACT_NAME_FROM_EMAIL(String email){
        return email.replaceAll("@.*","").replaceAll("[^a-zA-Z]+", " ").trim();
    }

    public static UUID validateEmptyID(String id){
        UUID contentId;
        try {
            contentId = UUID.fromString(id);
        }catch (Exception exception){
            contentId = UUID.randomUUID();
        }
        return contentId;
    }

    public static Long MinutesToMilliseconds(int Min){
        return Min*1000L;
    }

}

