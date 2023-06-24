public class PC {
    private static PC instance;

    private String value;
    private PC() {
        value = "0000000000000000";
    }
    public static PC getInstance(){
        if (instance == null)
            instance = new PC();
        return instance;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (value.length() > 16) {
            System.out.println("CANT SET THE WHOLE VALUE SO WE WOULD ONLY TAKE THE LEAST SIGNIFICANT 16 BITS");
            String val = "";
            for (int i = value.length() - 1 ; i >= value.length() - 16 ; i--){
                val = value.charAt(i) + val;
            }
            this.value = val;
            return;
        }
        if (value.length() < 16 ){
            while (value.length() < 16){
                value = "0" + value;
            }
            return;
        }
        this.value = value;
    }
}
