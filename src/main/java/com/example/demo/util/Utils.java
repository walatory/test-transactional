package com.example.demo.util;

import java.io.*;
import java.util.function.Consumer;

public class Utils {

    public static class Seria implements Serializable {
        private static final long serialVersionUID = 8025925345765570181L;
        public Class<?> capturingClass;
        public String functionalInterfaceClass;
        public String functionalInterfaceMethodName;
        public String functionalInterfaceMethodSignature;
        public String implClass;
        public String implMethodName;
        public String implMethodSignature;
        public int implMethodKind;
        public String instantiatedMethodType;
        public Object[] capturedArgs;
    }


    interface Getter<T, V> extends Serializable {
        V get(T bean);
    }

    private static final String BINARY = "iso-8859-1";

    public static <T> String getMethodName(Consumer<T> consumer) throws IOException, ClassNotFoundException {

        String originalName = java.lang.invoke.SerializedLambda.class.getName();
        String replacedName = com.example.demo.util.Utils.Seria.class.getName();
        assert (originalName.length() == replacedName.length());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(consumer);
        oos.flush();

        byte[] bytes = new String(bos.toByteArray(), BINARY).replace(originalName, replacedName).getBytes(BINARY);

        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Seria serializedLambda = (Seria) (in.readObject());

        return serializedLambda.implMethodName;
    }

}
