package org.pprls;

/*
 * MyEvent bus events used in Dashboard are listed here as inner classes.
 */
public abstract class MyEvent {

    public static class FirstButtonEvent {

        private final String buttonText;

        public FirstButtonEvent(String text){
            buttonText=text;
        }

        public String getText(){
            return buttonText;
        }
    }

    public static class SecondButtonEvent {

        private final String buttonText;

        public SecondButtonEvent(String text){
            buttonText=text;
        }

        public String getText(){
            return buttonText;
        }
    }
}
