package me.escoffier.lab.chapter5;

import io.reactivex.Observable;
import io.reactivex.Single;
import me.escoffier.superheroes.Character;

import java.util.Collections;

public class Code5 extends AbstractSuperAPI {

    public static void main(String[] args) {
        new Code5().hero()
            .subscribe(System.out::println, Throwable::printStackTrace);

        new Code5().villain()
            .subscribe(System.out::println, Throwable::printStackTrace);
    }

    @Override
    public Single<Character> hero() {
        return load()
                .filter(character -> !character.isVillain())
                .toList()
                .map(list -> {
                    Collections.shuffle(list);
                    return list;
                })
                .flatMapObservable(Observable::fromIterable)
                .firstOrError();

    }

    @Override
    public Single<Character> villain() {
        return load()
            // Implement the pipeline to return a random villain.
            .firstOrError();
    }

}
