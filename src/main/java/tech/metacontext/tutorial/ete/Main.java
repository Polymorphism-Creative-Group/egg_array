/*
 * Copyright 2020 Jonathan Chang, Chun-yien <ccy@musicapoetica.org>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tech.metacontext.tutorial.ete;

import java.util.Arrays;
import static java.util.function.Predicate.not;
import java.util.stream.Stream;
import tech.metacontext.tutorial.ete.ex.EggNotCookedException;

/**
 * A Java Mini Tutorial for <br>
 * 1. Array (and how to transform it into stream), <br>
 * 2. OO, Class and Status, <br>
 * 3. Use of Exception, and <br>
 * 4. Stream & Functional Interface: Supplier, Consumer, Predicate.
 *
 * @author Jonathan Chang, Chun-yien <ccy@musicapoetica.org>
 */
public class Main {

    public static void main(String[] args) {

        final var number = 100;
        // Egg[] eggRack
        var eggRack = Stream.generate(Egg::new)
                .limit(number)
                .toArray(Egg[]::new);
        System.out.println("\nWe have " + eggRack.length + " eggs!!\n");
        // To see what we've got.
        // Arrays.stream(eggRack).forEach(System.out::println);
        // Can we eat them?
        System.out.println("\nCan we eat them?\n");
        try {
            Arrays.stream(eggRack).forEach(Egg::eat);
        } catch (Exception ex) {
            System.out.println("\nNo we can't because of " + ex.getClass().getSimpleName());
        }
        // So we have to unwrap them first.
        System.out.println("\nSo we have to unwrap them first.\n");
        Arrays.stream(eggRack).forEach(Egg::unwrap);
        // Can we eat them now?
        System.out.println("\nCan we eat them now?\n");
        try {
            Arrays.stream(eggRack).forEach(Egg::eat);
        } catch (Exception ex) {
            System.out.println("\nNo we can't because of " + ex.getClass().getSimpleName());
        }
        // So we just cook them.
        System.out.println("\nSo we just cook them.\n");
        try {
            Arrays.stream(eggRack).forEach(Egg::cook);
        } catch (Exception ex) {
            System.out.println("\nOh no! " + ex.getClass().getSimpleName());
        }
        // We have to filter out the rotten ones.
        System.out.println("\nWe have to filter out the rotten ones then cook.\n");
        Arrays.stream(eggRack).filter(not(Egg::isRotten))
                .filter(not(Egg::isCooked)).forEach(Egg::cook);
        // Can we eat them now?
        System.out.println("\nCan we eat them now?\n");
        // So if we filter them out, we eat now!
        System.out.println("\nSo if we filter the rotten out, we can eat now!\n");
        try {
            Arrays.stream(eggRack).filter(not(Egg::isRotten)).forEach(Egg::eat);
        } catch (EggNotCookedException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println("\nNo we can't because of " + ex.getClass().getSimpleName());
        }
    }
}


