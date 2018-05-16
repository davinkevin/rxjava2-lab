package me.escoffier.lab.chapter5;

import io.reactivex.Flowable;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.buffer.Buffer;
import io.vertx.reactivex.core.file.FileSystem;
import me.escoffier.superheroes.Character;

public class Code3 {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();

        FileSystem fileSystem = vertx.fileSystem();

        fileSystem.rxReadFile("src/main/resources/characters.json")
                .map(Buffer::toString)
                .map(JsonArray::new)
                .flatMapPublisher(Flowable::fromIterable)
                .cast(JsonObject.class)
                .map(json -> json.mapTo(Character.class))
                .subscribe(System.out::println, Throwable::printStackTrace);
    }

}
