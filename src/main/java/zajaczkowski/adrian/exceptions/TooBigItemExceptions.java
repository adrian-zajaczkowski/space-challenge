package zajaczkowski.adrian.exceptions;

public class TooBigItemExceptions extends RuntimeException {

    private static final String MESSAGE = "Item is too big. It can not be load!";

    public TooBigItemExceptions(){
        super(MESSAGE);
    }
}
