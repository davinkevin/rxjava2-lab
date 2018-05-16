package me.escoffier.lab.chapter2;


import io.reactivex.Observable;

public class Code4 {

    public static void main(String... args) {
        Observable<String> stream = Observable.create(s -> {
            // Emit items
            s.onNext("Black Canary");
            s.onNext("Catwoman");
            s.onError(new RuntimeException("A wonderful and unexpected error..."));
            s.onNext("Elektra");
            // Notify the completion
            s.onComplete();
        });

        stream
            .subscribe(
                i -> System.out.println("Received: " + i),
                err -> System.out.println("BOOM"),
                () -> System.out.println("Completion")
            );

    }
}
