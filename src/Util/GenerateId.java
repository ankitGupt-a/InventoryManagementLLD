package Util;

import java.util.UUID;

public class GenerateId {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
