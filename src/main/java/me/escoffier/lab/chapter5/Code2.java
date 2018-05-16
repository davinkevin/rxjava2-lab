package me.escoffier.lab.chapter5;

import io.vertx.core.json.JsonArray;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.buffer.Buffer;
import io.vertx.reactivex.core.file.FileSystem;

public class Code2 {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        FileSystem fileSystem = vertx.fileSystem();

        fileSystem.rxReadFile("src/main/resources/characters.json")
                .map(Buffer::toString)
                .map(JsonArray::new)
                .map(JsonArray::encodePrettily)
                .subscribe(System.out::println, Throwable::printStackTrace);
    }

}
