package me.escoffier.lab.chapter5;

import io.reactivex.Observable;

import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Code8 {

    private static final Path DIRECTORY = Paths.get("src/main/resources/super");

    public static void main(String[] args) {
        getFileNames().subscribe(System.out::println, Throwable::printStackTrace);
    }

    private static Observable<String> getFileNames() {
        return Observable.create(emitter -> {
            Files.walkFileTree(DIRECTORY, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path path, BasicFileAttributes attr) {
                        emitter.onNext(path.getFileName().toString());
                        return FileVisitResult.CONTINUE;
                    }
                });
            // ...
        });
    }
}
