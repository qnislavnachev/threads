package com.clouway.fixedsizelist;

/**
 * Created by zumba on 08.08.16.
 *
 * @author Alexander Vladimirov
 *         <alexandervladimirov1902@gmail.com>
 */

public class ListFullException extends RuntimeException{

    public ListFullException(String message) {
        super(message);
    }
}