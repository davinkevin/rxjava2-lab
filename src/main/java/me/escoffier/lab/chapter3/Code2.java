package me.escoffier.lab.chapter3;


import io.reactivex.Single;

import static java.util.Objects.nonNull;

public class Code2 {


    public static void main(String[] args) {
        Single.just("Superman")
            .subscribe((v, err) -> {
                if (nonNull(err)) {
                    System.out.println("Error happend" + err );
                    err.printStackTrace();
                    return;
                }

                System.out.println("All good with " + v);

            })
            // use subscribe to retrieve the element and the error if any.
        ;
    }
}
