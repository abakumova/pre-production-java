package com.viktoriia_abakumova.task6.subtask3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

public class ObjectSerializer {

    public void serialize(Serializable serializable, String filename) throws NotSerializableException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(filename));
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(serializable);
        } catch (IOException e) {
            throw new NotSerializableException(String.format("Can't serialize object: %s, by path: %s",
            serializable.getClass().getSimpleName(), filename));
        }
    }

    public <T> T deserialize(Class<T> type, String filename) throws NotSerializableException {
        T deserializeObject;
        try (FileInputStream fileInputStream = new FileInputStream(new File(filename));
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            deserializeObject = type.cast(objectInputStream.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new NotSerializableException(String.format("Can't deserialize object: %s, by path: %s",
            type.getSimpleName(), filename));
        }
        return deserializeObject;
    }
}