package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */

public class JsonNull extends Json {
    private static final String NUL = "null";

    @Override
    public String toJson() {
        return NUL;
    }
}
