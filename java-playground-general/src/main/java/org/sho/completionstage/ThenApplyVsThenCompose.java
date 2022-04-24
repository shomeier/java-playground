package org.sho.completionstage;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class ThenApplyVsThenCompose {

    public static void main(String... args) {

        CompletableFuture<List<Integer>> supplyAsync = CompletableFuture.supplyAsync(() -> List.of(1, 2, 3));

        Function<List<Integer>, CompletableFuture<List<Integer>>> supplyAsync2 = l -> CompletableFuture.supplyAsync(() -> l);

        CompletableFuture<CompletableFuture<List<Integer>>> thenApply = supplyAsync.thenApply(supplyAsync2);
        CompletableFuture<List<Integer>> thenCompose = supplyAsync.thenCompose(supplyAsync2);

    }

}
